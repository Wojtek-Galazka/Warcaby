package com.panelWidok.controler;

import com.panelWidok.view.View;
import com.panelWidok.view.ViewField;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.panelWidok.Confg.*;
import static java.lang.Math.abs;

public class Controler implements MouseListener {
    private View oknoGry;
    private int oldX = -1;
    private int oldY = -1;
    private int tablicaPionkow[][] = new int[8][8];
    private boolean tablicaTp[][] = new boolean[8][8];


    public Controler(final View oknoGry) {
        this.oknoGry = oknoGry;
        oknoGry.setActionController(this);

        startPosition();
    }

    private void startPosition() {
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 8; i++) {
                if ((i + j) % 2 == 0)
                    tablicaPionkow[i][j] = VALUE_1;
            }

        for (int j = 5; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if ((i + j) % 2 == 0)
                    tablicaPionkow[i][j] = VALUE_2;
            }
        }
        oknoGry.setTablicaPionkow(tablicaPionkow);
        oknoGry.repaint();

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        ViewField source = (ViewField) e.getSource();

        boolean isReadyForMove = oldX == -1 && oldY == -1;
        boolean isMoving = oldX != -1 && oldY != -1;
        if(isReadyForMove) {
            if(showTips(source, tablicaPionkow[source.getX()][source.getY()]) | showTipsForKill(source)) {
                saveOldPosition(source);
            }
            return;
        }

        if(isMoving) {
            doMove(source);
            return;
        }


        oknoGry.repaint();
    }

    private void doMove(ViewField source) {
        boolean isProperMove = tablicaTp[source.getX()][source.getY()];
        if(isProperMove){
            int oldItem = tablicaPionkow[oldX][oldY];
            tablicaPionkow[oldX][oldY] = 0;
            tablicaPionkow[source.getX()][source.getY()] = oldItem;
            tablicaTp = new boolean[8][8];

            int xLen = source.getX() - oldX;
            int yLen = source.getY() - oldY;
            if(abs(xLen)==2 && abs(yLen)==2){
                tablicaPionkow[oldX + xLen/2][oldY + xLen/2] = 0;
            }

            if((source.getY() == 7 || source.getY() == 0) && (oldItem == VALUE_1 || oldItem == VALUE_2))  {
                tablicaPionkow[source.getX()][source.getY()] = oldItem+1; // damka to po prostu  o jeden więcej patrz Config....Queen
            }

            oknoGry.setTableTips(tablicaTp);
            oknoGry.setTablicaPionkow(tablicaPionkow);
            oknoGry.repaint();
            endMoveCleanup();
        }
    }

    private boolean showTipsForKill(ViewField source) {
        boolean result = false;
        if (isBoundIndex(source.getX() + 1, source.getY() + 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_1 &&
                tablicaPionkow[source.getX() + 1][source.getY() + 1] == VALUE_2) {
            result = result | verifyAndAddTip(source.getX() + 2, source.getY() + 2);
        }
        if (isBoundIndex(source.getX() - 1, source.getY() + 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_1 &&
                tablicaPionkow[source.getX() - 1][source.getY() + 1] == VALUE_2) {
            result = result | verifyAndAddTip(source.getX() - 2, source.getY() + 2);
        }

        if (isBoundIndex(source.getX() + 1, source.getY() - 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_2 &&
                tablicaPionkow[source.getX() + 1][source.getY() - 1] == VALUE_1) {
            result = result | verifyAndAddTip(source.getX() + 2, source.getY() - 2);
        }
        if (isBoundIndex(source.getX() - 1, source.getY() - 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_2 &&
                tablicaPionkow[source.getX() - 1][source.getY() - 1] == VALUE_1) {
            result = result | verifyAndAddTip(source.getX() - 2, source.getY() - 2);
        }

        return result;
    }

    private void endMoveCleanup() {
        oldX = -1;
        oldY = -1;
    }

    private boolean showTips(ViewField source, int currentPlayer) {
        boolean result = false;
        if (tablicaPionkow[source.getX()][source.getY()] == VALUE_1) {
            result = result | verifyAndAddTip(source.getX() + 1, source.getY() + 1);
            result = result | verifyAndAddTip(source.getX() - 1, source.getY() + 1);
        }

        if (tablicaPionkow[source.getX()][source.getY()] == VALUE_2) {
            result = result | verifyAndAddTip(source.getX() + 1, source.getY() - 1);
            result = result | verifyAndAddTip(source.getX() - 1, source.getY() - 1);

        }
        oknoGry.setTableTips(tablicaTp);
        oknoGry.repaint();
        return result;
    }

    private void saveOldPosition(ViewField source) {
        oldX = source.getX();
        oldY = source.getY();
    }

    private boolean verifyAndAddTip(int i, int j) {
        if (isBoundIndex(i, j)){
            if( tablicaPionkow[i][j]==0){
                tablicaTp[i][j] = true;
                return true;
            }
        }

        return false;
    }

    private boolean isBoundIndex(int i, int j) {
        return i > -1 && j > -1 && i < 8 && j < 8;
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
