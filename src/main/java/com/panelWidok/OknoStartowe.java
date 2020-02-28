package com.panelWidok;

//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OknoStartowe extends JFrame {
    private static Clip clip;
    public OknoStartowe() {
        ustawParametry();
        NazwaGry();
    }

    public void ustawParametry() {
        setLayout(null);
        String url =  "grafika\\szachownica.gif";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        setIconImage(img);
        setTitle("Warcaby");
        setSize(800, 1000);
        setLocation(100, 50);
        setResizable(false);
        add(new PanelStartowy());
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


    private static void muzykaTlo( String sciezka){

        try {
            File yourFile;
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;

            stream = AudioSystem.getAudioInputStream(new File(pobierzSciezke()[aktualnyindex]));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e) {
        }
    }

    public static String [] pobierzSciezke (){
        String [] listaSciezek = {"muzyka\\muzykaTlo.wav", "muzyka\\muzykaTlo1.wav"};
        return listaSciezek;
    }
     static int aktualnyindex;

    public static void muzykaStart(){

        if(clip !=null)
            clip.start();
        else
            muzykaTlo(pobierzSciezke()[0]);
    }

    public static void nastepnaMuzyka(){
        String [] listaSciezek = pobierzSciezke();
            if (aktualnyindex < listaSciezek.length-1)
                aktualnyindex += 1;
            else aktualnyindex = 0;
            muzykaStop();
            muzykaTlo(listaSciezek[aktualnyindex]);
            muzykaStart();
    }


    public static void muzykaStop(){
        clip.stop();
    }

}

