package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int CELL_SIZE = 50;
    public static final int PADDING = 10;
    private static Rectangle canvas;

    public Canvas() {

        canvas = new Rectangle(PADDING, PADDING, CELL_SIZE * 38, CELL_SIZE * 20);
        canvas.fill();

    }

}
