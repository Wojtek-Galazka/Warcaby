package com.panelWidok.view;

import javax.swing.*;
import java.awt.event.MouseListener;


public class ViewField extends JComponent{
    private int x;
    private int y;
    public ViewField(int i, int j) {
        this.x = i;
        this.y = j;
        int wspolrzedn_X_kafelka = 8+63*i;
        int wspolrzedn_Y_kafelka = 8+63*j;
        setBounds(wspolrzedn_X_kafelka,wspolrzedn_Y_kafelka, 60,60);
        setLayout(null);
        setVisible(true);
    }

    private void addListener(MouseListener listener) {
        addMouseListener(listener);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
