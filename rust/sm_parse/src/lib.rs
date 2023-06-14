#![allow(dead_code)]
/* 
TODO:
make sure its okay to use unwrap where i used it and if it isnt replace with match/?
figure out good way to implement inconsistentkeynum error
figure out better way to get difficulty num from chartdifficulty enum
*/



use std::cmp::PartialEq;

#[derive(Debug, PartialEq)]
enum NoteType {
    None,
    Tap,
    HoldStart,
    LNEnd,
    RollStart,
    Fake,
    Lift,
    Mine
}

enum ChartDifficulty{
    Beginner(usize),
    Easy(usize),
    Medium(usize),
    Hard(usize),
    Insane(usize),
    Edit(usize)
}


#[derive(Debug)]
pub enum SMParseErr{
    UnknownNoteType(char),
    InconsistentKeyNum,//not sure right now how i want to return this error cause it should be an error but id rather not check every single line of the chart for key num
    UnknownDifficultyType(String),
    UnknownChartField(String),
    UnknownSelectableType(String),
}

#[derive(Debug, PartialEq)]
struct NoteLine {
    notes: Vec<NoteType>
}

#[derive(Debug)]
struct Measure {
    notes: Vec<NoteLine>
}

struct Chart{
    notes: Vec<Measure>,
    difficulty: ChartDifficulty,
}

pub struct SMFile{
    title: String,
    subtitle: String,
    artist: String,
    title_translit: String,
    subtitle_translit: String,
    artist_translit: String,
    genre: String,
    credit: String,
    music: String,
    banner: String,
    background: String,
    lyrics_path: String,
    cdtitle: String,
    sample_start: f64,
    sample_length: f64,
    selectable: bool,
    offset: f64,
    bpms: Vec<f64>,
    stops: String,
    bg_changes: String,
    fg_changes: String,//no idea what this is lol
    charts: Vec<Chart>,
}

impl NoteType{
    fn to_char(&self) -> char{
        match self {
            NoteType::None => '0',
            NoteType::Tap => '1',
            NoteType::HoldStart => '2',
            NoteType::LNEnd => '3',
            NoteType::RollStart => '4',
            NoteType::Fake => 'F',
            NoteType::Lift => 'L',
            NoteType::Mine => 'M',
        }
    }
}

impl ChartDifficulty{
    fn to_string(&self) -> String{
        match self{
            ChartDifficulty::Beginner(_) => String::from("Beginner"),
            ChartDifficulty::Easy(_) => String::from("Easy"),
            ChartDifficulty::Medium(_) => String::from("Medium"),
            ChartDifficulty::Hard(_) => String::from("Hard"),
            ChartDifficulty::Insane(_) => String::from("Challenge"),
            ChartDifficulty::Edit(_) => String::from("Edit")
        }
    }

    fn get_diff_num(&self) -> usize {//there has to be a better way to do this (actually dont think there is)
        match self{
            ChartDifficulty::Beginner(val) => *val,
            ChartDifficulty::Easy(val) => *val,
            ChartDifficulty::Medium(val) => *val,
            ChartDifficulty::Hard(val) => *val,
            ChartDifficulty::Insane(val) => *val,
            ChartDifficulty::Edit(val) => *val
        }
    }
}

impl NoteLine{
    fn from_string(notes_str: String) -> Result<NoteLine, SMParseErr> {
        let mut notes = Vec::with_capacity(notes_str.len());
        let char_indices = notes_str.char_indices();
        
        for (_, char) in char_indices{
            match char {
                '0' => notes.push(NoteType::None),
                '1' => notes.push(NoteType::Tap),
                '2' => notes.push(NoteType::HoldStart),
                '3' => notes.push(NoteType::LNEnd),
                '4' => notes.push(NoteType::RollStart),
                'F' => notes.push(NoteType::Fake),
                'L' => notes.push(NoteType::Lift),
                'M' => notes.push(NoteType::Mine),
                _ => return Err(SMParseErr::UnknownNoteType(char)),
            }
        }
        Ok(NoteLine{notes})
    }

    fn get_notes(&self) -> &Vec<NoteType>{
        &self.notes
    }

    fn to_string(&self) -> String{
        let mut note_str = String::new();
        for note in self.notes.iter(){
            note_str.push(note.to_char());
        }

        note_str
    }
}

impl Measure{
    fn from_string(notes_str: String) -> Result<Measure, SMParseErr>{
        let mut notes = Vec::new();
        let mut current_line;

        for line in notes_str.split("\n"){
            current_line = NoteLine::from_string(line.trim().to_string());
            match current_line {
                Ok(line) => notes.push(line),
                Err(e) => return Err(e),
            }
        }

        Ok(Measure{notes})
    }

    fn to_string(&self) -> String{
        let mut meas_str = String::new();

        for line in self.notes.iter(){
            if true {
            meas_str.push_str(&format!("{}\n", line.to_string()));
            }
        }
        meas_str.pop();
        meas_str
    }
}

impl Chart {
    fn from_string(notes_str: String) -> Result<Chart, SMParseErr> {
       let mut lines = notes_str.split_terminator(':');

       //advance through the iterator until we get to actually important information
       println!("removed:{:?}",lines.next());
       println!("removed:{:?}",lines.next());
       println!("removed:{:?}",lines.next());

       let diff_name = lines.next().unwrap().trim().to_string();
       let diff_name = diff_name.trim();
       let diff_num = lines.next().unwrap().trim().to_string().parse().unwrap();

        let diff = match diff_name {
            "Beginner" => ChartDifficulty::Beginner(diff_num),
            "Easy" => ChartDifficulty::Easy(diff_num),
            "Medium" => ChartDifficulty::Medium(diff_num),
            "Hard" => ChartDifficulty::Hard(diff_num),
            "Challenge" => ChartDifficulty::Insane(diff_num),
            "Edit" => ChartDifficulty::Edit(diff_num),
            _ => return Err(SMParseErr::UnknownDifficultyType(diff_name.to_string())),
        };

        let mut notes = Vec::new();
        let mut current_meas;

        lines.next();

        let charts = lines.next().unwrap();

        println!("df{}", charts);

        let charts = charts.to_string();

        for meas in charts.split_terminator(','){
            let mut meas = meas.to_string();
            if meas.contains(';'){
                meas.remove(meas.find(';').unwrap());
                println!("{}", meas);
            }
            current_meas = Measure::from_string(meas);
            match current_meas {
                Ok(measu) => notes.push(measu),
                Err(e) => println!("Error when parsing chart: {:?}", e),
            }
        }

        Ok(Chart{notes, difficulty: diff})
    }

    fn to_string(&self) -> String{
        let mut notes_str = String::new();

        for meas in self.notes.iter(){
            notes_str.push_str(&format!("{},", meas.to_string()));
        }

        //pop twice to get rid of extra \n and ; at the end
        notes_str.pop();
        notes_str.pop();

        let chart_str = format!("
//--------------- dance-single -  ----------------
#NOTES:
        dance-single:
        :
        {}:
        {}:
        0,0,0,0,0:
{};", self.difficulty.to_string(), self.difficulty.get_diff_num(), notes_str);

        chart_str
    }
}

impl SMFile {
    pub fn from_string(mut file_str: String) -> Result<SMFile, SMParseErr>{
        let mut title = String::from("");
        let mut subtitle = String::from("");
        let mut artist = String::from("");
        let mut title_translit = String::from("");
        let mut subtitle_translit = String::from("");
        let mut artist_translit = String::from("");
        let mut genre = String::from("");
        let mut credit = String::from("");
        let mut music = String::from("");
        let mut banner = String::from("");
        let mut background = String::from("");
        let mut lyrics_path = String::from("");
        let mut cdtitle = String::from("");
        let mut sample_start = 0.0;
        let mut sample_length = 0.0;
        let mut selectable = true;
        let mut offset = 0.0;
        let mut bpms = vec![120.0];
        let mut stops = String::from("");
        let mut bg_changes = String::from("");
        let mut fg_changes = String::from("");
        let mut charts = Vec::new();

        let notes_str = file_str.split_off(file_str.find("//--").unwrap());//split off to parse metadata and notes seperately 

        for line in file_str.split_terminator('#'){
            if line.is_empty(){//cause the first elt of the iterator is nothing
                continue
            }
            let name_val = line.split_terminator(':').collect::<Vec<&str>>();
            let name = name_val[0];
            let mut val = name_val[1].to_string().trim().to_string();
            val.remove(val.find(';').unwrap());

            match name{//mayb should have a header struct to break things up here a lil
                "TITLE" => title = val,
                "SUBTITLE" => subtitle = val,
                "ARTIST" => artist = val,
                "TITLETRANSLIT" => title_translit = val,
                "SUBTITLETRANSLIT" => subtitle_translit = val,
                "ARTISTTRANSLIT" => artist_translit = val,
                "GENRE" => genre = val,
                "CREDIT" => credit = val,
                "BANNER" => banner = val,
                "BACKGROUND" => background = val,
                "LYRICSPATH" => lyrics_path = val,
                "CDTITLE" => cdtitle = val,
                "MUSIC" => music = val,
                "OFFSET" => offset = val.parse().unwrap(),
                "SAMPLESTART" => sample_start = val.parse().unwrap(),
                "SAMPLELENGTH" => sample_length = val.parse().unwrap(),
                "SELECTABLE" => selectable = SMFile::parse_selectable(val).unwrap(),
                "BPMS" => bpms = SMFile::parse_bpms(val),
                "STOPS" => stops = val,
                "BGCHANGES" => bg_changes = val,
                "FGCHANGES" => fg_changes = val,
                _ => return Err(SMParseErr::UnknownChartField(name.to_string())),

            }
        }

        for chart in notes_str.split_terminator("//"){
            if chart.is_empty(){
                continue;
            }
            charts.push(Chart::from_string(chart.to_string()).unwrap());
        }


    Ok(SMFile{
        title,
        subtitle,
        artist,
        title_translit,
        subtitle_translit,
        artist_translit,
        genre,
        credit,
        music,
        banner,
        background,
        lyrics_path,
        cdtitle,
        sample_start,
        sample_length,
        selectable,
        offset,
        bpms,
        stops,
        bg_changes,
        fg_changes,
        charts, })

        
    }

    fn parse_bpms(bpm_str: String) -> Vec<f64>{
        let mut num_last = 0.0;

        let mut bpms = Vec::new();

        for line in bpm_str.split_terminator(','){
            let num_val = line.split_terminator('=').collect::<Vec<&str>>();

            let num: f64;
            let val: f64;

            num = num_val[0].to_string().parse().unwrap();
            let mut val_str = num_val[1].to_string();
            val_str.pop();//removes newline char
            val = val_str.parse().unwrap();
            

            if num == 0.0 {
                bpms.push(val);
            } else if num != num_last + 1.0 {//for full clarity as well as making editing easier, add in the redundant bpms that are skipped in the .sm. todo: figure out how to add in beats that go to the end of the song, as the last bpm is not necessarily the last beat
                for _ in 0..((num-num_last) as usize){
                    bpms.push(val);
                }
            } else {
                bpms.push(val);
            }

            num_last = num;
        }

        bpms
    }

    fn parse_selectable(sel_str: String) -> Result<bool, SMParseErr> {

        match &sel_str[..] {
            "YES" => Ok(true),
            "NO" => Ok(false),
            _ => Err(SMParseErr::UnknownSelectableType(sel_str.to_string()))
        }
    }

    fn selectable_string(&self) -> String {
        if self.selectable{
             String::from("YES")
        } else {
            String::from("NO")
        }
    }

    pub fn to_string(&self) -> String{
        let mut bpm_last = -1.0;
        let mut bpm_str = String::new();
        let mut line_str;

        for i in 0..self.bpms.len(){
            if self.bpms[i] != bpm_last {
                line_str = format!("{}={},\n", i, self.bpms[i]);
                bpm_str.push_str(&line_str);
            }
            bpm_last = self.bpms[i];
        }

        let mut charts_str = String::new();

        for chart in self.charts.iter(){
            charts_str.push_str(&format!("{}\n", chart.to_string()));
        }

        let file_str = format!(
"#TITLE:{};
#SUBTITLE:{};
#ARTIST:{};
#TITLETRANSLIT{};
#SUBTITLETRANSLIT:{};
#ARTISTTRANSLIT:{};
#GENRE:{};
#CREDIT:{};
#MUSIC:{};
#BANNER:{};
#BACKGROUND:{};
#LYRICSPATH:{};
#CDTITLE:{};
#SAMPLESTART:{};
#SAMPLELENGTH:{};
#SELECTABLE:{};
#OFFSET:{};
#BPMS:{};
#STOPS:{};
#BGCHANGES:{};
#FGCHANGES:{};
{}", self.title, self.subtitle, self.artist, self.title_translit, self.subtitle_translit, self.artist_translit, 
            self.genre, self.credit, self.music, self.banner, self.background, self.lyrics_path, self.cdtitle, self.sample_start, 
            self.sample_length, self.selectable_string(), self.offset, bpm_str, self.stops, self.bg_changes, self.fg_changes, charts_str);

            file_str
    }

}


#[cfg(test)]
mod tests {
    use crate::*;

    #[test]
    fn note_line_test(){
        let nl = NoteLine::from_string("0100".to_string());
        assert_eq!(nl.unwrap().get_notes(), vec![NoteType::None, NoteType::Tap, NoteType::None, NoteType::None])
    }
}
