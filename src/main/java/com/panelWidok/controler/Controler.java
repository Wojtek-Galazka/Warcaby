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
    private boolean isWhiteTurn = true;
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

        if (isReadyForMove && isProperTurnClick(e)) {
            if (showTips(source) | showTipsForKill(source) | showTipsDamka(source, false)) {
                saveOldPosition(source);
            }
            return;

        }


        if (isMoving) {
            doMove(source);
            return;
        }


        oknoGry.repaint();

    }

    private boolean isProperTurnClick(MouseEvent e) {
        ViewField source = (ViewField) e.getSource();
        int player = tablicaPionkow[source.getX()][source.getY()];
        if (player == VALUE_1 || player == QUEEN_VALUE_1) {
            if (isWhiteTurn) {
                return true;
            }
        }

        if (player == VALUE_2 || player == QUEEN_VALUE_2) {
            if (!isWhiteTurn) {
                return true;
            }
        }
        return false;

    }

    private void doMove(ViewField source) {
        boolean isProperMove = tablicaTp[source.getX()][source.getY()];
        if (isProperMove) {
            int oldItem = tablicaPionkow[oldX][oldY];
            tablicaPionkow[oldX][oldY] = 0;
            tablicaPionkow[source.getX()][source.getY()] = oldItem;
            tablicaTp = new boolean[8][8];

            int xLen = source.getX() - oldX;
            int yLen = source.getY() - oldY;

            boolean killDone = tablicaPionkow[source.getX() - xLen / abs(xLen)][source.getY() - yLen / abs(yLen)] != 0;
            tablicaPionkow[source.getX() - xLen / abs(xLen)][source.getY() - yLen / abs(yLen)] = 0;


            if ((source.getY() == 7 || source.getY() == 0) && (oldItem == VALUE_1 || oldItem == VALUE_2)) {
                tablicaPionkow[source.getX()][source.getY()] = oldItem + 1; // damka to po prostu  o jeden więcej Config....Queen
            }

            oknoGry.setTableTips(tablicaTp);
            oknoGry.setTablicaPionkow(tablicaPionkow);
            oknoGry.repaint();

            if (!killDone || !showTipsForKill(source) && !showTipsDamka(source, true)) {
                endMoveCleanup();
            } else {
                oldX = source.getX();
                oldY = source.getY();

            }

        }
    }

    private boolean showTipsForKill(ViewField source) {
        boolean result = false;
        if (isBoundIndex(source.getX() + 1, source.getY() + 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_1 &&
                canKill(VALUE_1, tablicaPionkow[source.getX() + 1][source.getY() + 1])) {
            result = verifyAndAddTip(source.getX() + 2, source.getY() + 2);
        }
        if (isBoundIndex(source.getX() - 1, source.getY() + 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_1 &&
                canKill(VALUE_1, tablicaPionkow[source.getX() - 1][source.getY() + 1])) {
            result = result | verifyAndAddTip(source.getX() - 2, source.getY() + 2);
        }

        if (isBoundIndex(source.getX() + 1, source.getY() - 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_2 &&
                canKill(VALUE_2, tablicaPionkow[source.getX() + 1][source.getY() - 1])) {
            result = result | verifyAndAddTip(source.getX() + 2, source.getY() - 2);
        }
        if (isBoundIndex(source.getX() - 1, source.getY() - 1) &&
                tablicaPionkow[source.getX()][source.getY()] == VALUE_2 &&
                canKill(VALUE_2, tablicaPionkow[source.getX() - 1][source.getY() - 1])) {
            result = result | verifyAndAddTip(source.getX() - 2, source.getY() - 2);
        }

        oknoGry.setTableTips(tablicaTp);
        oknoGry.repaint();
        return result;
    }

    private void endMoveCleanup() {
        oldX = -1;
        oldY = -1;
        isWhiteTurn = !isWhiteTurn;
    }

    private boolean showTips(ViewField source) {
        boolean result = false;
        if (tablicaPionkow[source.getX()][source.getY()] == VALUE_1) {
            result = verifyAndAddTip(source.getX() + 1, source.getY() + 1);
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

    private boolean canKill(int player, int field) {
        if (player == VALUE_1 || player == QUEEN_VALUE_1) {
            if (field == VALUE_2 || field == QUEEN_VALUE_2) {
                return true;
            }
        }

        if (player == VALUE_2 || player == QUEEN_VALUE_2) {
            if (field == VALUE_1 || field == QUEEN_VALUE_1) {
                return true;
            }
        }
        return false;
    }

    private boolean showTipsDamka(ViewField source, boolean showOnlyKill) {
        boolean result = false;
        int currentSelection = tablicaPionkow[source.getX()][source.getY()];

        if (currentSelection == QUEEN_VALUE_1 || currentSelection == QUEEN_VALUE_2) {
            for (int i = 1; i < tablicaPionkow.length; i++) {
                if (isBoundIndex(source.getX() + i, source.getY() + i) &&
                        tablicaPionkow[source.getX() + i][source.getY() + i] != 0) {

                    if (canKill(currentSelection, tablicaPionkow[source.getX() + i][source.getY() + i])) {
                        result = result | verifyAndAddTip(source.getX() + i + 1, source.getY() + i + 1);
                    }

                    break;
                }
                if (!showOnlyKill) {
                    result = result | verifyAndAddTip(source.getX() + i, source.getY() + i);
                }
            }

            for (int i = 1; i < tablicaPionkow.length; i++) {
                if (isBoundIndex(source.getX() - i, source.getY() + i) &&
                        tablicaPionkow[source.getX() - i][source.getY() + i] != 0) {

                    if (canKill(currentSelection, tablicaPionkow[source.getX() - i][source.getY() + i])) {
                        result = result | verifyAndAddTip(source.getX() - i - 1, source.getY() + i + 1);
                    }

                    break;
                }
                if (!showOnlyKill) {
                    result = result | verifyAndAddTip(source.getX() - i, source.getY() + i);
                }
            }

            for (int i = 1; i < tablicaPionkow.length; i++) {
                if (isBoundIndex(source.getX() + i, source.getY() - i) &&
                        tablicaPionkow[source.getX() + i][source.getY() - i] != 0) {

                    if (canKill(currentSelection, tablicaPionkow[source.getX() + i][source.getY() - i])) {
                        result = result | verifyAndAddTip(source.getX() + i + 1, source.getY() - i - 1);
                    }

                    break;
                }
                if (!showOnlyKill) {
                    result = result | verifyAndAddTip(source.getX() + i, source.getY() - i);
                }
            }

            for (int i = 1; i < tablicaPionkow.length; i++) {
                if (isBoundIndex(source.getX() - i, source.getY() - i) &&
                        tablicaPionkow[source.getX() - i][source.getY() - i] != 0) {

                    if (canKill(currentSelection, tablicaPionkow[source.getX() - i][source.getY() - i])) {
                        result = result | verifyAndAddTip(source.getX() - i - 1, source.getY() - i - 1);
                    }

                    break;
                }
                if (!showOnlyKill) {
                    result = result | verifyAndAddTip(source.getX() - i, source.getY() - i);
                }
            }

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
        if (isBoundIndex(i, j)) {
            if (tablicaPionkow[i][j] == 0) {
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
