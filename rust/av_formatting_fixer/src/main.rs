use std::fs;
use std::fs::File;
use std::io;
use std::io::BufReader;
use std::io::Read;

fn main() -> io::Result<()> {
    let f = File::open("a.sm")?;
    let mut reader = BufReader::new(f);
    let mut buffer = Vec::new();

    reader.read_to_end(&mut buffer)?;

    let mut line_count: usize = 0;

    for value in &buffer {
        if *value == 10 {
            line_count = line_count + 1;
        }
    }

    let asf = buffer.len() + line_count;

    println!("bytez: {}\n", asf);

    let mut i: usize = 0;

    while i < asf {
        //println!("i: {}\n", i);
        if buffer[i] == 10 {
            //println!("line detected");
            buffer.insert(i, 13);
            i = i + 1;
        }
        i = i + 1;
    }
    fs::write("hi.sm", buffer)?;
    Ok(())
}
