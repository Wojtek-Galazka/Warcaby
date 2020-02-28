package com.panelWidok.view;

import com.panelWidok.PanelUstawieniaGlobalne;
import com.panelWidok.PanelUstawieniaGraczy;
import com.panelWidok.controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static com.panelWidok.Confg.*;

public class View extends JFrame implements ActionListener {

    private boolean tableTips[][] = new boolean[8][8];
    private ViewField clickers[][];
    private int tablicaPionkow[][] = new int[8][8];
    private Integer szerokosc = 650;
    private Integer wysokosc = 600;
    private JButton start;
    private JSeparator pion, poziom;

    protected static Color kolorPlanszy1, kolorPlanszy2, kolorPionkow1, kolorPionkow2;

    public View() {
        super("Pojedynek");
        setLocation(200, 50);
        setSize(530, 570);
        //setLocationRelativeTo(okonoGry);
        String url = "grafika\\szachownica.gif";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        setIconImage(img);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pion = new JSeparator();
        pion.setBounds(700, 15, 19, 650);
        pion.setOrientation(SwingConstants.VERTICAL);
        add(pion);

        poziom = new JSeparator();
        poziom.setBounds(700, 300, 200, 10);
        poziom.setOrientation(SwingConstants.HORIZONTAL);
        add(poziom);
        start = new JButton("Start");
        start.setBounds(530, 100, 100, 20);
        add(start);
        start.addActionListener(this);


        kolorPlanszy1 = PanelUstawieniaGlobalne.kolorSzachwonicy;
        kolorPlanszy2 = new Color(255 - kolorPlanszy1.getRed(),
                255 - kolorPlanszy1.getGreen(),
                255 - kolorPlanszy1.getBlue());
        kolorPionkow1 = PanelUstawieniaGraczy.kolorPionkowGracz1;
        kolorPionkow2 = PanelUstawieniaGraczy.kolorPionkowGracz2;


        clickers = new ViewField[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                clickers[i][j] = new ViewField(i, j);
                add(clickers[i][j]);
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(10, 40, 505, 505);


        drawBattleground(g2d);
        drawTips(g2d);
        drawItems(g2d);


    }

    private void drawBattleground(Graphics2D g2d) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0)
                    g2d.setColor(kolorPlanszy1);
                else
                    g2d.setColor(kolorPlanszy2);
                g2d.fillRect(11 + 63 * i, 41 + 63 * j, 62, 62);
            }
        }
    }

    private void drawItems(Graphics2D g2d) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablicaPionkow[i][j] == VALUE_1 || tablicaPionkow[i][j] == QUEEN_VALUE_1)
                    g2d.setColor(kolorPionkow1);
                else if (tablicaPionkow[i][j] == VALUE_2 || tablicaPionkow[i][j] == QUEEN_VALUE_2)
                    g2d.setColor(kolorPionkow2);

                if (tablicaPionkow[i][j] == VALUE_1 || tablicaPionkow[i][j] == VALUE_2)
                    g2d.fillOval(17 + 63 * i, 47 + 63 * j, 50, 50);
                else if (tablicaPionkow[i][j] == QUEEN_VALUE_1 || tablicaPionkow[i][j] == QUEEN_VALUE_2)
                    g2d.fillRect(17 + 63 * i, 47 + 63 * j, 50, 50);
            }
        }
    }

    private void drawTips(Graphics2D g2d) {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (tableTips[i][j]) {
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(11 + 63 * i, 41 + 63 * j, 62, 62);
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Object source = e.getSource();
        //        //if (source == start) {
        //            //ustaw();
        //            //repaint();
        //        //}
    }


    public void setActionController(Controler ctrl) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                clickers[i][j].addMouseListener(ctrl);
            }
        }
    }

    public void setTablicaPionkow(int[][] tablicaPionkow) {
        if (tablicaPionkow.length != 8 || tablicaPionkow[0].length != 8) {
            throw new RuntimeException("Złe pionki!");
        }
        this.tablicaPionkow = tablicaPionkow;
    }

    public void setTableTips(boolean[][] tableTips) {
        if (tableTips.length != 8 || tableTips[0].length != 8) {
            throw new RuntimeException("Złe podpowiedzi!");
        }
        this.tableTips = tableTips;
    }

}


