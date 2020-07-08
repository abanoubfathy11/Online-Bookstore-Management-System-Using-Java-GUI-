/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Mu Di
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
          final String song="E:\\FCIS\\Projects\\OOP\\Wa7wy_Ya_Wa7wy.mp3";
    MP3Player mp3=new MP3Player(new File(song));
        Start Splash=new Start();
        Splash.setVisible((true));
        signin_up Sign=new signin_up();
                mp3.play();
        try {
            
            for (int i = 0; i <= 100; i++) {
                
                Thread.sleep(42);
                Splash.loadingnum.setText(Integer.toString(i)+"%");
                Splash.loadingbar.setValue(i);
                
                if(i==100)
                {
                    Splash.setVisible(false);
                    Sign.setVisible(true);
                    Sign.jPanel3.setVisible(false);
                    Sign.jPanel4.setVisible(false);
                    mp3.stop();
                    
                }
            }
            
        } catch (Exception e) {
        }
    }
    
}
