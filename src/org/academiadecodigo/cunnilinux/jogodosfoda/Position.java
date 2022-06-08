package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.cunnilinux.jogodosfoda.Canvas;

public class Position {

    private int col;

    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int colToX() {
        return this.col * Canvas.CELL_SIZE;
    }

    public int rowToY() {
        return this.row * Canvas.CELL_SIZE;
    }

    public int setCol(int col) {
        return this.col = col;
    }

    public int setRow(int row) {
       return this.row = row;
    }

}
