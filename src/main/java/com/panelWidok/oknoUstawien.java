package com.panelWidok;

import javax.swing.*;

public class oknoUstawien extends JFrame {

    public oknoUstawien(){
        setLayout(null);
        setTitle("Ustawienia");
        setSize(800, 500);
        setLocation(100, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(false);
        add(new panelUstawieniaGlobalne());
        add(new panelUstawieniaGraczy());

    }

}
