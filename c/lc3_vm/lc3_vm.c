#include <stdint.h>
#include <stdbool.h>
#include <stdio.h>
#include <signal.h>
#include <windows.h>
#include <conio.h>

HANDLE hStdin = INVALID_HANDLE_VALUE;
DWORD fdwMode, fdwOldMode;

uint16_t memory[UINT16_MAX];
const uint16_t PC_START = 0x3000; //default program counter starting position

bool running;

enum Registers
{
    R_R0,
    R_R1,
    R_R2,
    R_R3,
    R_R4,
    R_R5,
    R_R6,
    R_R7,
    R_R8,
    R_PC,
    R_COND,
    R_COUNT,
};

enum TrapCodes
{
    TRAP_GETC = 0x20,
    TRAP_OUT = 0x21,
    TRAP_PUTS = 0x22,
    TRAP_IN = 0x23,
    TRAP_PUTSP = 0x24,
    TRAP_HALT = 0x25,
};

uint16_t reg[R_COUNT];

enum Opcodes
{
    OP_BR,
    OP_ADD,
    OP_LD,
    OP_ST,
    OP_JSR,
    OP_AND,
    OP_LDR,
    OP_STR,
    OP_RTI,
    OP_NOT,
    OP_LDI,
    OP_STI,
    OP_JMP,
    OP_RES,
    OP_LEA,
    OP_TRAP,
};

enum ConditionFlags
{
    FL_POS = 1 << 0,
    FL_ZRO = 1 << 1,
    FL_NEG = 1 << 2,
};

enum MemMappedRegisters
{
    MR_KBSR = 0xFE00,
    MR_KBDR = 0xFE02,
};

uint16_t sign_extend(uint16_t x, int bit_count)
{
    if ((x >> (bit_count - 1)) & 1)
    {
        x |= (0xFFFF << bit_count);
    }
    return x;
}

uint16_t swap16(uint16_t x) //lc3 programs use big endian so we have to swap
{
    return (x << 8) || (x >> 8);
}

void update_flags(uint16_t r)
{
    if (reg[r] == 0)
    {
        reg[R_COND] = FL_ZRO;
    }
    else if (reg[r] >> 15)
    {
        reg[R_COND] = FL_NEG;
    }
    else
    {
        reg[R_COND] = FL_POS;
    }
}

void read_image_file(FILE *file)
{
    uint16_t origin;
    fread(&origin, sizeof(origin), 1, file);
    origin = swap16(origin);

    uint16_t max_read = UINT16_MAX - origin;
    uint16_t *p = memory + origin;
    size_t read = fread(p, sizeof(uint16_t), max_read, file);

    while (read-- > 0)
    {
        *p = swap16(*p);
        p++;
    }
}

int read_image(const char *image_path)
{
    FILE *file = fopen(image_path, "rb");
    if (!file)
    {
        return 0;
    }
    printf("path: %s", image_path);
    read_image_file(file);
    fclose(file);

    return 1;
}

uint16_t check_key()
{
    return WaitForSingleObject(hStdin, 1000) == WAIT_OBJECT_0 && _kbhit();
}

void mem_write(uint16_t address, uint16_t val)
{
    memory[address] = val;
}

uint16_t mem_read(uint16_t address)
{
    if (address == MR_KBSR)
    {
        if (check_key())
        {
            memory[MR_KBSR] = (1 << 15);
            memory[MR_KBDR] = getchar();
        }
        else
        {
            memory[MR_KBSR] = 0;
        }
    }
    return memory[address];
}

void disable_input_buffering()
{
    hStdin = GetStdHandle(STD_INPUT_HANDLE);
    GetConsoleMode(hStdin, &fdwOldMode);
    fdwMode = fdwOldMode ^ ENABLE_ECHO_INPUT ^ ENABLE_LINE_INPUT;
    SetConsoleMode(hStdin, fdwMode);
    FlushConsoleInputBuffer(hStdin);
}

void restore_input_buffering()
{
    SetConsoleMode(hStdin, fdwOldMode);
}

void handle_interrupt(int signal)
{
    restore_input_buffering();
    printf("\n");
    exit(-2);
}

void trap_getc()
{
    reg[R_R0] = (uint16_t)getchar();
    reg[R_R0] &= 0xFF;
}

void trap_out()
{
    putc((char)reg[R_R0], stdout);
    fflush(stdout);
}

void trap_puts()
{
    uint16_t *c = memory + reg[R_R0];

    while (*c)
    {
        putc((char)*c, stdout);
        c++;
    }
    fflush(stdout);
}

void trap_in()
{
    printf("Please enter a character:\n");
    char c = getchar();
    printf("%c\n", c);

    reg[R_R0] = (uint16_t)c;
    reg[R_R0] &= 0xFF;
}

void trap_putsp()
{
    uint16_t *c = memory + reg[R_R0];
    while (*c)
    {
        char first_char = *c & 0xFF;
        putc(first_char, stdout);
        char second_char = *c >> 8;
        if (second_char)
        {
            putc(second_char, stdout);
        }
        c++;
    }
    fflush(stdout);
}

void trap_halt()
{
    puts("Program halted");
    fflush(stdout);
    running = false;
}

void trap(uint16_t instr)
{
    switch (instr & 0xFF)
    {
    case TRAP_GETC:
        trap_getc();
        break;
    case TRAP_OUT:
        trap_out();
        break;
    case TRAP_PUTS:
        trap_puts();
        break;
    case TRAP_IN:
        trap_in();
        break;
    case TRAP_PUTSP:
        trap_putsp();
        break;
    case TRAP_HALT:
        trap_halt();
        break;
    }
}

void add(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t r1 = (instr >> 6) & 0x7;
    uint16_t imm_flag = (instr >> 5) & 0x1;

    if (imm_flag)
    {
        uint16_t imm5 = sign_extend(instr & 0x1F, 5);
        reg[r0] = reg[r1] + imm5;
    }
    else
    {
        uint16_t r2 = instr & 0x7;
        reg[r0] = reg[r1] + reg[r2];
    }

    update_flags(r0);
}

void b_and(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t r1 = (instr >> 6) & 0x7;
    uint16_t imm_flag = (instr >> 5) & 0x1;

    if (imm_flag)
    {
        uint16_t imm5 = sign_extend(instr & 0x1F, 5);
        reg[r0] = reg[r1] & imm5;
    }
    else
    {
        uint16_t r2 = instr & 0x7;
        reg[r0] = reg[r1] & reg[r2];
    }
    update_flags(r0);
}

void br(uint16_t instr)
{
    uint16_t n = (instr >> 11) & 0xFFF;
    uint16_t z = (instr >> 10) & 0x7FF;
    uint16_t p = (instr >> 9) & 0x3FF;
    if (n | z | p)
    {
        uint16_t pc_offset9 = instr & 0x1FF;
        reg[R_PC] += pc_offset9;
    }
}

void jmp(uint16_t instr)
{
    uint16_t base_r = (instr >> 6) & 0x7;
    reg[R_PC] = reg[base_r];
}

void jsr(uint16_t instr)
{
    reg[R_R7] = reg[R_PC];
    uint16_t base_r_flag = (instr >> 11) & 0x1;
    if (!base_r_flag)
    {
        uint16_t base_r = (instr >> 6) & 0x7;
        reg[R_PC] = reg[base_r];
    }
    else
    {
        uint16_t pc_offset11 = instr & 0x7FF;
        reg[R_PC] += sign_extend(pc_offset11, 11);
    }
}

void ld(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t pc_offset9 = instr & 0x1FF;

    reg[r0] = mem_read(reg[R_PC] + sign_extend(pc_offset9, 9));
    update_flags(r0);
}

void ldi(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t pc_offset = sign_extend(instr & 0x1FF, 9);

    reg[r0] = mem_read(mem_read(reg[R_PC] + pc_offset));
    update_flags(r0);
}

void ldr(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t base_r = (instr >> 6) & 0x7;
    uint16_t offset6 = instr & 0x3F;

    reg[r0] = mem_read(reg[base_r] + sign_extend(offset6, 6));
    update_flags(r0);
}

void lea(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t pc_offset9 = instr & 0x1FF;

    reg[r0] = reg[R_PC] + sign_extend(pc_offset9, 9);
    update_flags(r0);
}

void not(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t sr = (instr >> 9) & 0x7;

    reg[r0] = ~reg[sr];
    update_flags(r0);
}

void st(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t pc_offset9 = instr & 0x1FF;

    mem_write(reg[R_PC] + sign_extend(pc_offset9, 9), reg[r0]);
}

void sti(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t pc_offset9 = instr & 0x1FF;

    mem_write(mem_read(reg[R_PC] + sign_extend(pc_offset9, 9)), reg[r0]);
}

void str(uint16_t instr)
{
    uint16_t r0 = (instr >> 9) & 0x7;
    uint16_t base_r = (instr >> 6) & 0x7;
    uint16_t pc_offset6 = instr & 0x3F;

    mem_write(reg[base_r] + sign_extend(pc_offset6, 6), reg[r0]);
}

void unknown_opcode()
{
    puts("Unknown opcode");
    fflush(stdout);
    running = false;
}

int main(int argc, const char *argv[])
{

    if (argc < 2)
    {
        printf("lc3 [image-file1] ... \n");
        exit(2);
    }

    for (int j = 1; j < argc; ++j)
    {
        if (!read_image(argv[j]))
        {
            printf("Failed to load image: %s\n", argv[j]);
            exit(1);
        }
    }
    signal(SIGINT, handle_interrupt);
    disable_input_buffering();

    reg[R_PC] = PC_START;

    running = true;

    while (running)
    {
        uint16_t instr = mem_read(reg[R_PC]++);
        uint16_t op = instr >> 12; //instructions are in bits 12-15

        

        switch (op)
        {
        case OP_ADD:
            add(instr);
            break;
        case OP_AND:
            b_and(instr);
            break;
        case OP_NOT:
            not(instr);
            break;
        case OP_BR:
            br(instr);
            break;
        case OP_JMP:
            jmp(instr);
            break;
        case OP_JSR:
            jsr(instr);
            break;
        case OP_LD:
            ld(instr);
            break;
        case OP_LDI:
            ldi(instr);
            break;
        case OP_LDR:
            ldr(instr);
            break;
        case OP_STI:
            sti(instr);
            break;
        case OP_STR:
            str(instr);
            break;
        case OP_TRAP:
            trap(instr);
            break;
        case OP_RES:
        case OP_RTI:
        default:
            unknown_opcode();
            break;
        }
    }
    restore_input_buffering();
}
