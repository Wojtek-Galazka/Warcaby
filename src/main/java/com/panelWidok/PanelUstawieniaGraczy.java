package com.panelWidok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUstawieniaGraczy extends JPanel {

    public static Color kolorPionkowGracz1 = Color.BLUE;
    public static Color kolorPionkowGracz2 = Color.GRAY;
    JButton wybranyKolorGracz1;

    JButton wybranyKolorGracz2;


    public PanelUstawieniaGraczy(){
        setLayout(null);
        setSize(785,300);
        setLocation(5,160);
        setBackground(Color.gray);
        gracz1Ustawienia();
        gracz2Ustawienia();
        dodajKoloryDoWyboruGracz1(150,65);
        dodajKoloryDoWyboruGracz2(560,65);
        dodajPrzyciski();
        wczytajKolorGracza1();
        wczytajKolorGracza2();
    }

    public void gracz1Ustawienia(){
        Font font = new Font("SansSerif", Font.BOLD, 25);
        String text = "";
        if(PanelStartowy.nazwaGracz1.getText().equals(""))
            text = "Gracz 1";
        else text = PanelStartowy.nazwaGracz1.getText();
        JLabel jLabelGracz1 = new JLabel(text);
        jLabelGracz1.setFont(font);
        jLabelGracz1.setBounds(150,10,200,30);
        add(jLabelGracz1);
        wybranyKolorGracz1 = new JButton();
        wybranyKolorGracz1.setBounds(246,15,20,20);
        add(wybranyKolorGracz1);

        Font f = new Font("SansSerif", Font.BOLD, 15);
        JLabel jLabelKolorPionkow = new JLabel("Kolor pionkow:");
        jLabelKolorPionkow.setFont(f);
        jLabelKolorPionkow.setBounds(30,60,200,30);
        add(jLabelKolorPionkow);


    }

    public void gracz2Ustawienia(){
        Font font = new Font("SansSerif", Font.BOLD, 25);
        String text = "";
        if(PanelStartowy.nazwaGracz2.getText().equals(""))
            text = "Gracz 2";
        else text = PanelStartowy.nazwaGracz2.getText();
        JLabel jLabelGracz2 = new JLabel(text);
        jLabelGracz2.setFont(font);
        jLabelGracz2.setBounds(520,10,200,30);
        add(jLabelGracz2);
        wybranyKolorGracz2 = new JButton();
        wybranyKolorGracz2.setBounds(616,15,20,20);
        add(wybranyKolorGracz2);



        JLabel jLabelKolorPionkow = new JLabel("Kolor pionkow:");
        Font f = new Font("SansSerif", Font.BOLD, 15);
        jLabelKolorPionkow.setFont(f);
        jLabelKolorPionkow.setBounds(440,60,200,30);
        add(jLabelKolorPionkow);
    }



    public void dodajKoloryDoWyboruGracz1(int x, int y){
        Color colors [] = new Color[]{Color.black,Color.blue,Color.pink,Color.green, Color.orange};
        for (int i = 0; i < colors.length; i++){
            final JButton jButton  = new JButton();
            jButton.setBackground(colors[i]);
            jButton.setSize(20,20);
            jButton.setLocation(x,y);
            add(jButton);
            x+=30;
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kolorPionkowGracz1 =  ((JButton) e.getSource()).getBackground();
                    wybranyKolorGracz1.setBackground(kolorPionkowGracz1);
                }
            });
        }
    }

    public void dodajKoloryDoWyboruGracz2(int x, int y){
        Color colors [] = new Color[]{Color.black,Color.blue,Color.pink,Color.green, Color.orange};
        for (int i = 0; i < colors.length; i++){
            final JButton jButton  = new JButton();
            jButton.setBackground(colors[i]);
            jButton.setSize(20,20);
            jButton.setLocation(x,y);
            add(jButton);
            x+=30;
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kolorPionkowGracz2 =  ((JButton) e.getSource()).getBackground();
                    wybranyKolorGracz2.setBackground(kolorPionkowGracz2);
                }
            });
        }
    }

    public void dodajPrzyciski(){
        JButton wroc = new JButton("Wróć");
        wroc.setBounds(200,240,150,50);
        add(wroc);
        wroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelStartowy.oknoUstawien.setVisible(false);
            }
        });


        JButton zatwierdz = new JButton("Zatwierdź");
        zatwierdz.setBounds(440,240,150,50);
        add(zatwierdz);
        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelStartowy.oknoUstawien.setVisible(false);

            }
        });
    }

    private void wczytajKolorGracza1(){
        wybranyKolorGracz1.setBackground(kolorPionkowGracz1);
    }

    private void wczytajKolorGracza2(){
        wybranyKolorGracz2.setBackground(kolorPionkowGracz2);
    }

}
