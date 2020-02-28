package com.panelWidok;

import javax.swing.*;
import java.awt.*;

public class oknoUstawien extends JFrame {

    public oknoUstawien(){
        setLayout(null);
        String url =  "grafika\\szachownica.gif";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        setIconImage(img);
        setTitle("Ustawienia");
        setSize(800, 500);
        setLocation(100, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(false);
        add(new PanelUstawieniaGlobalne());
        add(new PanelUstawieniaGraczy());

    }

}
