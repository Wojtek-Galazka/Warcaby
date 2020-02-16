package com.panelWidok;

import com.sun.scenario.effect.Color4f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class szachownica extends JPanel implements MouseListener {

    public szachownica(){
        setSize(800,800);
        setLocation(0,10);
        setLayout(null);

    }

    public void rep(){
        repaint();
    }
    //Rysowanie szachownicy i pionkow
    public void paintComponent(Graphics g){
        rysujSzachownice(g);
        rysujPionki(g);
    }

    private void rysujSzachownice(Graphics g){
        int x = 0, y = 0, wielkoscPlanszy = 800;
        int wielkoscPola = 100;
        g.setColor(new Color(112,54,67));
        g.fillRect(x,y,wielkoscPlanszy,wielkoscPlanszy);

        for (int i = x; i<=wielkoscPlanszy; i+=wielkoscPola*2){
            for (int j = y; j <=wielkoscPlanszy; j+=wielkoscPola*2 ){
                g.clearRect(i, j, wielkoscPola,wielkoscPola);
            }
        }
        for( int i = wielkoscPola; i<=wielkoscPlanszy+wielkoscPola; i +=wielkoscPola*2){
            for (int j = wielkoscPola; j <= wielkoscPola + wielkoscPlanszy; j+=wielkoscPola*2){
                g.clearRect(i,j,wielkoscPola,wielkoscPola);
            }
        }

    }

    private void rysujPionki(Graphics g){
        int x = 20, y = 20, wielkoscPlanszy = 800;
        int wielkoscPola = 100;
        int licznik = 0;
        Color aktualnyKolor = g.getColor();
        for (int i = x; i<=wielkoscPlanszy; i+=wielkoscPola*2, licznik++){
            if(licznik != 2){
                for (int j = y; j <=wielkoscPlanszy; j+=wielkoscPola*2 ){
                    g.fillOval(j,i,60,60);
                }
            }else g.setColor(Color.black);
        }
        licznik = 0;
        g.setColor(aktualnyKolor);
        
        for( int i = wielkoscPola + x; i<=wielkoscPlanszy+wielkoscPola; i +=wielkoscPola*2, licznik++){
            if(licznik != 1) {
                for (int j = wielkoscPola + x; j <= wielkoscPola + wielkoscPlanszy; j += wielkoscPola * 2) {
                    g.fillOval(j, i, 60, 60);
                }
            }else g.setColor(Color.black);
        }
    }

    public void rysowaniePunktu(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}