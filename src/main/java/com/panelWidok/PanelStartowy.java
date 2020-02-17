package com.panelWidok;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelStartowy extends JPanel {

    public static JTextField nazwaGracz1, nazwaGracz2;
    JButton grajJButton;
    JButton ustawieniaJButton;
    public static oknoStartowe oknoStartowe = new oknoStartowe();
    public static oknoUstawien oknoUstawien;
    public static oknoGry oknoGry;



    public panelStartowy(){
        setLayout(null);
        setSize(500,500);
        setLocation(150,315);
        dodajPola();
        grajJButtonAkcja();
        ustawieniaJButtonAkcja();
    }

    public void grajJButtonAkcja(){
        grajJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (czyWprowadzonoNazwyGraczy()){
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            oknoGry = new oknoGry();
                            oknoGry.setVisible(true);
                            oknoStartowe.setVisible(false);

                        }
                    });

                }else {
                    JOptionPane.showMessageDialog(null, "PODAJ NAZWE GRACZA");

                }

            }
        });
    }

    public void ustawieniaJButtonAkcja(){
        ustawieniaJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        oknoUstawien = new oknoUstawien();
                        oknoUstawien.setVisible(true);
                    }
                });
            }
        });
    }

    public void dodajPola(){

        Font sansbold14 = new Font("SansSerif", Font.BOLD, 40);
        Color color = new Color(0,60,0);

        JLabel jLabel1 = new JLabel("WYBOR GRACZY");
        jLabel1.setBounds(70,25,400,40);
        jLabel1.setFont(sansbold14);


        add(jLabel1);

        JLabel jLabel = new JLabel("Gracz 1");
        jLabel.setBounds(50,80,200,100);
        jLabel.setFont(new Font("",Font.ROMAN_BASELINE,30));
        add(jLabel);

        JLabel jLabel2 = new JLabel("Gracz 2");
        jLabel2.setBounds(50,150,200,100);
        jLabel2.setFont(new Font("",Font.ROMAN_BASELINE,30));
        add(jLabel2);

        nazwaGracz1 = new JTextField();
        nazwaGracz1.setBounds(200,120,200,30);
        add(nazwaGracz1);

        nazwaGracz2 = new JTextField();
        nazwaGracz2.setBounds(200,190,200,30);
        add(nazwaGracz2);

        grajJButton = new JButton("Graj");
        grajJButton.setBounds(150,300,200,60);
        add(grajJButton);

        ustawieniaJButton = new JButton("Ustawienia");
        ustawieniaJButton.setBounds(20,440,100,40);
        add(ustawieniaJButton);


    }

    public boolean czyWprowadzonoNazwyGraczy(){
        if(!nazwaGracz1.getText().equals("") && !nazwaGracz2.getText().equals(""))
            return true;
        else
            return false;
    }



}
