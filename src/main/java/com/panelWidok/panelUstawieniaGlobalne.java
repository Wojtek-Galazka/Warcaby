package com.panelWidok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelUstawieniaGlobalne extends JPanel {


    public static Color kolorSzachwonicy = Color.black;



    public panelUstawieniaGlobalne() {
        setLayout(null);
        setBackground(Color.darkGray);
        setSize(785, 150);
        setLocation(5, 5);
        dodajJLabel();
        kolorSzachwonicy = wyborKolorySzachownicy();
        ustawieniaMuzyka();

    }

    public  void ustawieniaMuzyka(){
        JLabel jLabelKolorSzachownicy = new JLabel("Muzyka");
        jLabelKolorSzachownicy.setForeground(Color.white);
        Font font = new Font("SansSerif", Font.BOLD, 15);
        jLabelKolorSzachownicy.setBounds(380,40,200,50);
        jLabelKolorSzachownicy.setFont(font);
        add(jLabelKolorSzachownicy);

        JButton wlacz = new JButton("ON");
        wlacz.setSize(80,40);
        wlacz.setLocation(320,90);
        add(wlacz);
        wlacz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OknoStartowe.muzykaStart();

            }
        });

        JButton wylacz = new JButton("OFF");
        wylacz.setSize(80,40);
        wylacz.setLocation(410,90);
        add(wylacz);
        wylacz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OknoStartowe.muzykaStop();

            }
        });

    }

    public void dodajJLabel(){
        JLabel jLabel = new JLabel("Ustawienia Globalne");
        jLabel.setForeground(Color.white);
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        jLabel.setFont(font1);
        jLabel.setBounds(280,4,250,50);
        add(jLabel);

        JLabel jLabelKolorSzachownicy = new JLabel("Kolor szachwonicy");
        jLabelKolorSzachownicy.setForeground(Color.white);
        Font font = new Font("SansSerif", Font.BOLD, 15);
        jLabelKolorSzachownicy.setBounds(60,40,200,50);
        jLabelKolorSzachownicy.setFont(font);
        add(jLabelKolorSzachownicy);
    }

    public  Color wyborKolorySzachownicy(){
        JButton czarny = new JButton();
        czarny.setBackground(Color.black);
        czarny.setSize(20,20);
        czarny.setLocation(70,90);
        add(czarny);
        czarny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kolorSzachwonicy = Color.black;
            }
        });

        JButton niebieski = new JButton();
        niebieski.setBackground(Color.blue);
        niebieski.setSize(20,20);
        niebieski.setLocation(100,90);
        add(niebieski);
        niebieski.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kolorSzachwonicy = Color.blue;
            }
        });

        JButton czerwony = new JButton();
        czerwony.setBackground(Color.red);
        czerwony.setSize(20,20);
        czerwony.setLocation(130,90);
        add(czerwony);
        czerwony.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kolorSzachwonicy = Color.red;

            }
        });

        JButton zolty = new JButton();
        zolty.setBackground(Color.yellow);
        zolty.setSize(20,20);
        zolty.setLocation(160,90);
        add(zolty);
        zolty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kolorSzachwonicy = Color.yellow;

            }
        });
        return kolorSzachwonicy;
    }
}
