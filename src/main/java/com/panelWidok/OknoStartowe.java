package com.panelWidok;

import com.sun.webkit.dom.HTMLImageElementImpl;
import javax.swing.*;
import java.awt.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class OknoStartowe extends JFrame {

    public OknoStartowe(){
        ustawParametry();
        NazwaGry();

    }
    public void ustawParametry(){
        setLayout(null);
        setTitle("Warcaby");
        setSize(800,1000);
        setLocation(100,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        add(new PanelStartowy());
    }


    public void NazwaGry(){
String ikona = "D:\\Work\\Java\\Warcaby\\grafika\\WARCABY.png";
        ImageIcon icone = new ImageIcon(ikona);
        JLabel warcaby = new JLabel(icone);
        warcaby.setSize(800,200);
        add(warcaby);
    }



}

