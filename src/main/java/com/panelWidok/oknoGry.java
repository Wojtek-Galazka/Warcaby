package com.panelWidok;

import javax.swing.*;

public class oknoGry extends JFrame{

    public oknoGry(){
        setLayout(null);
        setTitle("Warcaby");
        setSize(800, 1000);
        setLocation(100, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        szachownica szachownica = new szachownica();
        add(szachownica);

//        setContentPane(szachownica);
    }
}
