package com.panelWidok;

import javax.swing.*;

public class oknoUstawien extends JFrame {

    public oknoUstawien(){
        setLayout(null);
        setTitle("Ustawienia");
        setSize(800, 600);
        setLocation(100, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        add(new panelUstawieniaGlobalne());
        add(new panelUstawieniaGraczy());

    }

}
