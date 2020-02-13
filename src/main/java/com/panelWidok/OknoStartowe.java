package com.panelWidok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class oknoStartowe extends JFrame implements WindowListener {

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


    @Override
    public void windowOpened(WindowEvent e) {
        setVisible(true);

    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(false);

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

