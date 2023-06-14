/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livestreamer;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author David
 */
class SyncPipe implements Runnable{
    private final InputStream is;
    private final OutputStream os;
    public SyncPipe(InputStream is_, OutputStream os_){
        is = is_;
        os = os_;
    }
    public void run(){
        try{
            final byte[] buffer = new byte[1024];
            for (int length = 0; (length = is.read(buffer)) != -1;){
                os.write(buffer, 0, length);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class DoubleOut{
    private final OutputStream one;
    private final OutputStream two;
    
    public DoubleOut(OutputStream one_, OutputStream two_){
        one = one_;
        two = two_;
    }
    
    
    
}

class gui extends JFrame implements ActionListener{
    private JTextField stream;
    private JPanel back;
    private String op;
    public gui() throws AWTException{
        setTitle("Livestreamer");
        setSize(300,200);
        back = new JPanel();
        stream = new JTextField(20);
        add(back);
        back.add(stream);
        stream.addActionListener(this);
        setLocationRelativeTo(null);
    }
    
    public void loadStream(String stream) throws IOException, URISyntaxException{
        String[] command = {"cmd",};
        Process p = Runtime.getRuntime().exec(command);
        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
        new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
        PrintWriter stdin = new PrintWriter(p.getOutputStream());
        stdin.println("\"C:\\Program Files (x86)\\Livestreamer\\livestreamer.exe\" twitch.tv/"+stream+" best");
        
        
        //Desktop.getDesktop().browse(new URI("https://www.twitch.tv/"+stream+"/chat?popout="));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            loadStream(stream.getText());
            stream.setEditable(false);
            Thread.sleep(40000);
            //System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public class Livestreamer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, AWTException {
       gui g = new gui();
       g.setVisible(true);
        
    }
}
