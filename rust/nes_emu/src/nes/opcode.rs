pub enum Ad_Mode{
    Immediate,
    ZeroPage,
    ZeroPageX,
    ZeroPageY,
    IndirectX,
    IndirectY,
    Absolute,
    AbsoluteX,
    AbsoluteY,
    Accumulator,
    Indirect,
}

pub enum Opcode{//opcodes without an addressing mode field only have one possible address mode
    ADC(Ad_Mode),
    AND(Ad_Mode),
    ASL(Ad_Mode),
    BCC,
    BEQ,
    BIT(Ad_Mode),
    BMI,
    BNE,
    BPL,
    BRK,
    BVC,
    BVS,
    CLC,
    CLI,
    CLV,
    CMP(Ad_Mode),
    CPX(Ad_Mode),
    CPY(Ad_Mode),
    DEC(Ad_Mode),
    DEX,
    DEY,
    EOR(Ad_Mode),
    INC(Ad_Mode),
    INX,
    INY,
    JMP(Ad_Mode),
    JSR,
    LDA(Ad_Mode),
    LDX(Ad_Mode),
    LDY(Ad_Mode),
    LSR(Ad_Mode),
    NOP,
    ORA(Ad_Mode),
    PHA,
    PHP,
    PLA,
    PLP,
    ROL(Ad_Mode),
    ROR(Ad_Mode),
    RTI,
    RTS,
    SBC(Ad_Mode),
    SEC,
    SED,
    SEI,
    STA(Ad_Mode),
    STX(Ad_Mode),
    STY(Ad_Mode),
    TAX,
    TAY,
    TSX,
    TXA,
    TXS,
    TYA
}

impl Opcode{
    pub fn read_opcode(low_byte: u8, high_byte: u8) -> Opcode {
            let op = ((low_byte as u16) << 8) | (high_byte as u16);

            match op {
                0x00 => Opcode::BRK,
                0x01 => Opcode::ORA(Ad_Mode::IndirectX),
                0x05 => Opcode::ORA(Ad_Mode::ZeroPage),
                0x06 => Opcode::ASL(Ad_Mode::ZeroPage),
                0x08 => Opcode::PHP,
                0x09 => Opcode::ORA(Ad_Mode::Immediate),
                0x0A => Opcode::ASL(Ad_Mode::Accumulator),
                0x0D => Opcode::ORA(Ad_Mode::Absolute),
                0x0E => Opcode::ASL(Ad_Mode::Absolute),
                0x10 => Opcode::BPL,
                0x11 => Opcode::ORA(Ad_Mode::IndirectY),
                0x15 => Opcode::ORA(Ad_Mode::ZeroPageX),
                0x16 => Opcode::ASL(Ad_Mode::ZeroPageX),
                0x18 => Opcode::CLC,
                0x19 => Opcode::ORA(Ad_Mode::AbsoluteY),
                0x1D => Opcode::ORA(Ad_Mode::AbsoluteX),
                0x1E => Opcode::ASL(Ad_Mode::AbsoluteX),
                0x20 => Opcode::JSR,
                0x21 => Opcode::AND(Ad_Mode::IndirectX),
                0x24 => Opcode::BIT(Ad_Mode::ZeroPage),
                0x25 => Opcode::AND(Ad_Mode::ZeroPage),
                0x26 => Opcode::ROL(Ad_Mode::ZeroPage),
                0x28 => Opcode::PLP,
                0x29 => Opcode::AND(Ad_Mode::Immediate),
                0x2A => Opcode::ROL(Ad_Mode::Accumulator),
                0x2C => Opcode::BIT(Ad_Mode::Absolute),
                0x2D => Opcode::AND(Ad_Mode::Absolute),
                0x2E => Opcode::ROL(Ad_Mode::Absolute),
                0x30 => Opcode::BMI,
                0x31 => Opcode::AND(Ad_Mode::IndirectY),
                0x35 => Opcode::AND(Ad_Mode::ZeroPageX),
                0x36 => Opcode::ROL(Ad_Mode::ZeroPageX),
                0x38 => Opcode::SEC,
                0x39 => Opcode::AND(Ad_Mode::AbsoluteY),
                0x3D => Opcode::AND(Ad_Mode::AbsoluteX),
                0x3E => Opcode::ROL(Ad_Mode::AbsoluteX),
                0x40 => Opcode::RTI,
                0x41 => Opcode::EOR(Ad_Mode::IndirectX),
                0x45 => Opcode::EOR(Ad_Mode::ZeroPage),
                0x46 => Opcode::LSR(Ad_Mode::ZeroPage),
                0x48 => Opcode::PHA,
                0x49 => Opcode::EOR(Ad_Mode::Immediate),
                0x4A => Opcode::LSR(Ad_Mode::Accumulator),
                0x4C => Opcode::JMP(Ad_Mode::Absolute),
                0x4D => Opcode::EOR(Ad_Mode::Absolute),
                0x4E => Opcode::LSR(Ad_Mode::Absolute),
                0x50 => Opcode::BVC,
                0x51 => Opcode::EOR(Ad_Mode::IndirectY),
                0x55 => Opcode::EOR(Ad_Mode::ZeroPageX),
                0x56 => Opcode::LSR(Ad_Mode::ZeroPageX),
                0x58 => Opcode::CLI,
                0x59 => Opcode::EOR(Ad_Mode::AbsoluteY),
                0x5D => Opcode::EOR(Ad_Mode::AbsoluteX),
                0x5E => Opcode::LSR(Ad_Mode::AbsoluteX),
                0x60 => Opcode::RTS,
                0x61 => Opcode::ADC(Ad_Mode::IndirectX),
                0x65 => Opcode::ADC(Ad_Mode::ZeroPage),
                0x66 => Opcode::ROR(Ad_Mode::ZeroPage),
                0x68 => Opcode::PLA,
                0x69 => Opcode::ADC(Ad_Mode::Immediate),
                0x6A => Opcode::ROR(Ad_Mode::Accumulator),
                0x6C => Opcode::JMP(Ad_Mode::Indirect),
                0x6D => Opcode::ADC(Ad_Mode::Absolute),
                0x6E => Opcode::ROR(Ad_Mode::Absolute),
                0x70 => Opcode::BVS,
                0x71 => Opcode::ADC(Ad_Mode::IndirectY),
                0x75 => Opcode::ADC(Ad_Mode::ZeroPageX),
                0x76 => Opcode::ROR(Ad_Mode::ZeroPageX),





                




                _ => panic!("Unknown opcode")

            }
    }
}