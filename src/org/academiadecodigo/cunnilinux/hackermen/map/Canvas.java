package org.academiadecodigo.cunnilinux.hackermen.map;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int CELL_SIZE = 50;
    public static final int PADDING = 0;
    public static final int FLOOR_LEVEL = 65;
    private static Rectangle canvas;

    public Canvas() {

        canvas = new Rectangle(PADDING, PADDING, CELL_SIZE * 36, CELL_SIZE * 18);
        canvas.fill();

    }

    public int getWidth() {
        return canvas.getWidth();
    }

    public int getHeight() {
        return canvas.getHeight();
    }

}
