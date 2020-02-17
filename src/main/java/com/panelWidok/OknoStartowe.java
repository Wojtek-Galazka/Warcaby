package com.panelWidok;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class oknoStartowe extends JFrame {
    private static Clip clip;
    public oknoStartowe() {
        ustawParametry();
        NazwaGry();
    }

    public void ustawParametry() {
        setLayout(null);
        setTitle("Warcaby");
        setSize(800, 1000);
        setLocation(100, 50);
        setResizable(false);
        add(new panelStartowy());
    }

    public void NazwaGry() {
        String ikona = "grafika\\WARCABY.png";
        ImageIcon icone = new ImageIcon(ikona);
        JLabel warcaby = new JLabel(icone);
        warcaby.setSize(800, 200);
        add(warcaby);

        String url = "grafika\\szachownica.gif";
        ImageIcon szachy = new ImageIcon(url);
        JLabel szachownica = new JLabel(szachy);
        szachownica.setSize(800,800);
        szachownica.setLocation(0,170);
        add(szachownica);
    }


    private static void muzykaTlo(){

        try {
            File yourFile;
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;

            stream = AudioSystem.getAudioInputStream(new File("muzyka\\muzykaTlo.wav"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e) {
            //whatevers
        }
    }

    public static void muzykaStart(){
        if(clip !=null)
            clip.start();
        else
            muzykaTlo();
    }

    public static void muzykaStop(){
        clip.stop();
    }

}

