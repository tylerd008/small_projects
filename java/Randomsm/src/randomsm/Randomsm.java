/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomsm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 *
 */
class subBeat{// my name for a line of arrows
    private final boolean[] notes;
    
    public subBeat(){
        notes = new boolean[4];
        for(int i = 0; i < 4; i++)
            notes[i] = false;     
    }
    
    public subBeat(boolean left, boolean down, boolean up, boolean right){
        notes = new boolean[4];
        notes[0] = left;
        notes[1] = down;
        notes[2] = up;
        notes[3] = right;
    }
    
    public int length(){
        return 4;
    }
    
    public boolean[] getNotes(){
        return notes;
    }
    
    public void setNote(int notePos){
        notes[notePos] = true;
    }
    
    public String toString(){
        String outp = "";
        for(int i = 0; i < 4; i++){
            outp = notes[i] ? "1" : "0";
        }
        return outp;
    }
    
    public static boolean isMinijack(subBeat sub1, subBeat sub2){//lmao this makes me feel like a genius
        return (Byte.parseByte(sub1.toString(), 2) & Byte.parseByte(sub2.toString(), 2)) != 0;
    }
}  

class measure{
    private final subBeat[] subBeats;
//    private final int[] subBeatTypes = {4, 8, 12, 16, 24, 32, 48, 64, 96, 192};
    
    
    
    public measure(int subBeatsNum){
        subBeats = new subBeat[subBeatsNum];
    }
    
    public void addNotes(subBeat notes, int subBeatPos){
        if(subBeatPos >= subBeats.length)
            return;
        subBeats[subBeatPos] = notes;
    }
    public void addNotes(subBeat[] notes){
        for(int i = 0; i < notes.length; i++)
            for(int k = 0; k < 4; k++)
                subBeats[i].getNotes()[k] = notes[i].getNotes()[k];
    }
    public int getSubBeatsNum(){
        return subBeats.length;
    }
    
    public boolean getNote(int subBeatNum, int notePos){
        return subBeats[subBeatNum].getNotes()[notePos];
    }
    
    public String toString(){
        String outp = "";
        for(int i = 0; i < subBeats.length; i++){
            outp = outp+subBeats[i]+"\n";
        }    
        return outp;
    }
}

class smFile extends ArrayList<measure>{
    private String fileName;
    private String BPM;
    private String header;
    
    public smFile(){
        header = "#TITLE:;\n" +
                 "#SUBTITLE:;\n" +
                 "#ARTIST:;\n" +
                 "#CREDIT:;\n" +
                 "#MUSIC:Respect Your Elders - Leffen Diss Tr.mp3;\n" +
                 "#SELECTABLE:YES;\n" +
                 "#BACKGROUND:;\n" +
                 "#BANNER:;\n" +
                 "#CDTITLE:;\n" +
                 "#OFFSET:-0.257982;\n" +
                 "#SAMPLESTART:0.000;\n" +
                 "#SAMPLELENGTH:0.000;\n" +
                 "#BPMS:0=;\n" +
                 "#STOPS:;"+""
                + "//---------------dance-single - ----------------\n" +
                  "#NOTES:\n" +
                        "     dance-single:\n" +
                                    "     :\n" +
                                "     Beginner:\n" +
                                    "     1:\n" +
                                "     0.000,0.000,0.000,0.000,0.000:\n";
    }
    
    public smFile(String BPM){
        header = "#TITLE:;\n" +
                 "#SUBTITLE:;\n" +
                 "#ARTIST:;\n" +
                 "#CREDIT:;\n" +
                 "#MUSIC:;\n" +
                 "#SELECTABLE:YES;\n" +
                 "#BACKGROUND:;\n" +
                 "#BANNER:;\n" +
                 "#CDTITLE:;\n" +
                 "#OFFSET:;\n" +
                 "#SAMPLESTART:0.000;\n" +
                 "#SAMPLELENGTH:0.000;\n" +
                 "#BPMS:0="+BPM+";\n" +
                 "#STOPS:;"+""
                + "//---------------dance-single - ----------------\n" +
                  "#NOTES:\n" +
                        "     dance-single:\n" +
                                    "     :\n" +
                                "     Beginner:\n" +
                                    "     1:\n" +
                                "     0.000,0.000,0.000,0.000,0.000:\n";
    }
    
    public smFile(String fileName, String BPM){
        header = "#TITLE:"+fileName+";\n" +
                 "#SUBTITLE:;\n" +
                 "#ARTIST:;\n" +
                 "#CREDIT:;\n" +
                 "#MUSIC:;\n" +
                 "#SELECTABLE:YES;\n" +
                 "#BACKGROUND:;\n" +
                 "#BANNER:;\n" +
                 "#CDTITLE:;\n" +
                 "#OFFSET:;\n" +
                 "#SAMPLESTART:0.000;\n" +
                 "#SAMPLELENGTH:0.000;\n" +
                 "#BPMS:0="+BPM+";\n" +
                 "#STOPS:;"+""
                + "//---------------dance-single - ----------------\n" +
                  "#NOTES:\n" +
                        "     dance-single:\n" +
                                    "     :\n" +
                                "     Beginner:\n" +
                                    "     1:\n" +
                                "     0.000,0.000,0.000,0.000,0.000:\n";
    }
    public String toString(){
        String outp = "";
        for(int i = 0; i < size(); i ++){
            if(i+1 == size())
                outp = outp+get(i)+";";
            else
                outp = outp+get(i)+", \n";
        }   
        return header+outp;
    }
    
    public void toFile() throws FileNotFoundException{
        try(PrintWriter out = new PrintWriter("C:\\Users\\Flossy\\Desktop\\d.sm")){
            out.println(toString());
        }
    }
}

class Generator{
    private final Random r = new Random();
    private final int[] measureSizes = {4, 8, 12, 16, 24, 32, 48, 64, 96, 192};
//    private final smFile notes;
   
    public Generator(){
        
    }
    
    private subBeat genSingle(){
        subBeat temp = new subBeat();
        temp.setNote(r.nextInt(4));
        return temp;
    }
    
    private subBeat genJump(){
        subBeat temp = new subBeat();
        int rand1 = 0;
        int rand2 = 0;
        while(rand1 == rand2){
            rand1 = r.nextInt(4);
            rand2 = r.nextInt(4);
        }
        temp.setNote(rand1);
        temp.setNote(rand2);
        return temp;
    }
    
    private subBeat genHand(){
        subBeat temp = new subBeat();
        int rand;
        rand = r.nextInt(4);
        for(int i = 0; i < 4; i++){
            if(i == rand) {
                
            } else
                temp.setNote(i);
        }
        return temp;
    }
    
    private subBeat genQuad(){
        return new subBeat(true, true, true, true);
    }
    
    public smFile generateSMFileUnweighted(int numMeasures){
        smFile notes = new smFile();
        for(int i = 0; i < numMeasures; i++){
            measure temp = new measure(measureSizes[r.nextInt(measureSizes.length)]);
            for(int k = 0; k < temp.getSubBeatsNum(); k++)
                temp.addNotes(new subBeat(r.nextBoolean(), r.nextBoolean(), r.nextBoolean(), r.nextBoolean()), k);
            notes.add(temp);   
        }
        return notes;
    }
    
    public smFile generateStream(int numMeasures){
        smFile f = new smFile();
        subBeat last = new subBeat(false, false,false,false);
        subBeat temp = genSingle();
        for(int i = 0; i < numMeasures; i++){
            measure tempm = new measure(16);
            for(int k = 0; k < 16; k++){
                while(subBeat.isMinijack(temp, last)){
                    temp = genSingle();
                }
                tempm.addNotes(temp, k);
                last = temp;
                temp = genSingle();
            }
            f.add(tempm);
        }
        return f; 
    }
    
    public smFile generateStream(double numSeconds, double BPM){
        int numMeasures = (int) Math.ceil((BPM / 4.0)*(numSeconds / 60.0));
        smFile f = new smFile(Integer.toString((int)BPM));
        subBeat last = new subBeat(false, false,false,false);
        subBeat temp = genSingle();
        for(int i = 0; i < numMeasures; i++){
            measure tempm = new measure(16);
            for(int k = 0; k < 16; k++){
                while(subBeat.isMinijack(temp, last)){
                    temp = genSingle();
                }
                tempm.addNotes(temp, k);
                last = temp;
                temp = genSingle();
            }
            f.add(tempm);
        }
        return f; 
    }
    
    public smFile generateJumpstream(int numMeasures){
        smFile f = new smFile();
        subBeat last = new subBeat(false, false, false, false);
        subBeat temp = genJump();
        for(int i = 0; i < numMeasures; i ++){
            measure tempm = new measure(16);
            for(int k = 0; k < 16; k++){//16 because im just doing 16th js
                while(subBeat.isMinijack(temp, last)){
                    if(k%4 == 0)//2 for dense js, change to 4 for light js
                        temp = genJump();
                    else
                        temp = genSingle();
                }
                tempm.addNotes(temp, k);
                last = temp;
                if((k+1)%4 == 0)//2 for dense js, change to 4 for light js
                    temp = genJump();
                else
                    temp = genSingle();
            }
            f.add(tempm);
        }
        return f; 
    }
    
    public smFile generateJumpstream(double numSeconds, double BPM, boolean dense){
        int divnum;
        if(dense)
            divnum = 2;
        else
            divnum = 4;
        int numMeasures = (int) Math.ceil((BPM / 4.0)*(numSeconds / 60.0));
        smFile f = new smFile(Integer.toString((int)BPM));
        subBeat last = new subBeat(false, false, false, false);
        subBeat temp = genJump();
        for(int i = 0; i < numMeasures; i ++){
            measure tempm = new measure(16);
            for(int k = 0; k < 16; k++){//16 because im just doing 16th js
                while(subBeat.isMinijack(temp, last)){
                    if(k%divnum == 0)//2 for dense js, change to 4 for light js
                        temp = genJump();
                    else
                        temp = genSingle();
                }
                tempm.addNotes(temp, k);
                last = temp;
                if((k+1)%divnum == 0)//2 for dense js, change to 4 for light js
                    temp = genJump();
                else
                    temp = genSingle();
            }
            f.add(tempm);
        }
        return f; 
    }
    
    public smFile generateHandstream(int numMeasures){
        smFile f = new smFile();
        subBeat last = new subBeat(false, false, false, false);
        subBeat temp = genHand();
        for(int i = 0; i < numMeasures; i ++){
            measure tempm = new measure(16);
            for(int k = 0; k < 16; k++){
                while(subBeat.isMinijack(temp, last)){
                    if(k%4 == 0)
                        temp = genHand();
                    else if (k%2 == 0)
                        temp = genJump();
                    else
                        temp = genSingle();
                }
                tempm.addNotes(temp, k);
                last = temp;
                
                if((k+1)%4 == 0)
                    temp = genHand();
                else if ((k+1)%2 == 0)
                    temp = genJump();
                else
                    temp = genSingle();
            }
            f.add(tempm);
        }
        return f; 
    }  
    
    public smFile generateHandstream(double numSeconds, double BPM){
        int numMeasures = (int) Math.ceil((BPM / 4.0)*(numSeconds / 60.0));
        smFile f = new smFile(Integer.toString((int)BPM));
        subBeat last = new subBeat(false, false, false, false);
        subBeat temp = genHand();
        for(int i = 0; i < numMeasures; i ++){
            measure tempm = new measure(16);
            for(int k = 0; k < 16; k++){
                while(subBeat.isMinijack(temp, last)){
                    if(k%4 == 0)
                        temp = genHand();
                    else if (k%2 == 0)
                        temp = genJump();
                    else
                        temp = genSingle();
                }
                tempm.addNotes(temp, k);
                last = temp;
                
                if((k+1)%4 == 0)
                    temp = genHand();
                else if ((k+1)%2 == 0)
                    temp = genJump();
                else
                    temp = genSingle();
            }
            f.add(tempm);
        }
        return f; 
    }
    
}
public class Randomsm {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        Generator g = new Generator();
//        g.generateJumpstream(3);
//        System.out.print(g.generateJumpstream(5));
        /*String type = "", jsdense = ""; 
        int length = 0, bpm = 0;
        boolean jsdensee = false;
        
        System.out.println("Type?");
        while(!type.equals("js") || !type.equals("hs") || !type.equals("s")){
            type = s.nextLine();
        }
        while(length != 0)
            length = s.nextInt();
        while(bpm != 0)
            bpm = s.nextInt();
        if(type.equals("js"))
            while(!jsdense.equals("y") || !jsdense.equals("n")){
                if(jsdense.equals("y"))
                    jsdensee = true;
                else
                    jsdensee = false;
            }
                
        switch(type){
            case "js":
                 g.generateJumpstream(length, bpm, jsdensee);
                 break;
            case "s":
                g.generateStream(length, bpm);
                break;
            case "hs":
                g.generateHandstream(length, bpm);
        }
        */
        g.generateJumpstream(120, 160, false).toFile();
        
    }
 }
