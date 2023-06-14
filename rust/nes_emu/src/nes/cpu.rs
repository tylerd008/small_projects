use crate::nes::opcode::{Ad_Mode, Opcode};

struct CPU {
    a: u8,
    x: u8,
    y: u8,
    pc: u16,
    s: u8,
    p: u8,
    memory: [u8; 65535],
}

impl CPU{
    pub fn new() -> CPU{
        CPU {
            a: 0,
            x: 0,
            y: 0,
            pc: 0x4020,
            s: 0xFD,
            p: 0x34,
            memory: [0; 65535],
        }
    }

    pub fn cycle(&mut self, memory: &mut Vec<u8>){
        let opcode = Opcode::read_opcode(memory[self.pc as usize], memory[self.pc as usize + 1]);

        self.pc += 2;
    }

    fn get_argument(&mut self, am: Ad_Mode) -> u16 {
        let index = self.pc as usize;
        match am {
            Accumulator => self.a as u16,
            Absolute => {((self.memory[index] as u16) << 8) | (self.memory[index + 1] as u16)},
            AbsoluteX => {((self.memory[index] as u16) << 8) | (self.memory[index + 1] as u16) + self.x as u16},
            AbsoluteX => {((self.memory[index] as u16) << 8) | (self.memory[index + 1] as u16) + self.y as u16},
            Immediate => 5,//not really sure what this one is 
            Indirect => 5,
            _ => panic!()
        }
    }

    fn brk(&mut self){
        self.push_stack((self.pc & 0xFF) as u8);
        self.push_stack(((self.pc >> 8) & 0xFF) as u8);
        self.push_stack(self.p);
        self.p |= 1 << 2;// set break bit
    }

    fn adc(&mut self){

    }

    fn push_stack(&mut self, val: u8){
        self.memory[(self.s + 0x100) as usize] = val;
        self.s += 1;
    }
}