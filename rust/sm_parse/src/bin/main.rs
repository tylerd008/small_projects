use sm_parse::*;
use std::fs::File;
use std::io::prelude::*;

fn main() -> std::io::Result<()>{
    let mut file = File::open("Bodysnatchers.sm")?;
    let mut data = String::new();
    file.read_to_string(&mut data)?;
    let sm = sm_parse::SMFile::from_string(data).unwrap();
    let mut new_file = File::create("test.sm")?;
    new_file.write(sm.to_string().as_bytes());
    Ok(())

}