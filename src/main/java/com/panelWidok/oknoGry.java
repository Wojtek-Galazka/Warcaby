package com.panelWidok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oknoGry extends JFrame{

    public oknoGry(){
        setLayout(null);
        setTitle("Warcaby");
        setSize(800, 1000);
        setLocation(100, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
        szachownica szachownica = new szachownica();
        add(szachownica);
        dodajJLabel();

    }

    public void dodajJLabel(){
        Font font = new Font("SansSerif", Font.BOLD, 20);
        JLabel jLabel = new JLabel("Gracz 1: " +panelStartowy.nazwaGracz1.getText());
        jLabel.setFont(font);
        jLabel.setForeground(panelUstawieniaGraczy.kolorPionkowGracz1);
        jLabel.setBounds(10,50,200,30);
        add(jLabel);


        JLabel jLabel1 = new JLabel("Gracz 2: " +panelStartowy.nazwaGracz2.getText());
        jLabel1.setFont(font);
        jLabel1.setForeground(panelUstawieniaGraczy.kolorPionkowGracz2);
        jLabel1.setBounds(10,880,200,30);
        add(jLabel1);

        JButton powrot = new JButton("Wróć do strony głównej");
        powrot.setBounds(595,930,180,30);
        add(powrot);
        powrot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelStartowy.oknoGry.setVisible(false);
                panelStartowy.oknoStartowe.setVisible(true);
            }
        });

    }
}
