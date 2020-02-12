package com.panelWidok;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelStartowy extends JPanel {
    JLayeredPane layeredPane;
    JLabel imageContainer = new JLabel();
    JButton jButtonGraj = new JButton("WYBIERZ GRACZY");



    public PanelStartowy(){
        setSize(800,1300);
        setLocation(0,160);
        dodajPanel2();
        setjButtonGrajAkcja();


    }
    public void setjButtonGrajAkcja(){
        jButtonGraj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new OknoWyborGraczy();
                    }
                });

            }
        });
    }

    public void dodajPanel2(){
        String url = "D:\\Work\\Java\\Warcaby\\grafika\\szachownica.gif";
        ImageIcon icone = new ImageIcon(url);
        JLabel szachownica = new JLabel(icone);
        szachownica.setOpaque(true);
        szachownica.setSize(800,800);
        jButtonGraj.setBounds(175,200,450,350);
        jButtonGraj.setLayout(null);
        this.layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 1300));
        layeredPane.add(imageContainer, new Integer(50));
        layeredPane.add(jButtonGraj, new Integer(100));
        layeredPane.add(szachownica, new Integer(1));
        this.add(layeredPane);
    }





}
