package org.academiadecodigo.cunnilinux.hackermen.map;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int CELL_SIZE = 50;
    public static final int PADDING = 0;
    public static final int FLOOR_LEVEL = 200;
    public static final int CANVAS_WIDTH = CELL_SIZE * 36;
    public static final int CANVAS_HEIGHT = CELL_SIZE * 18;
    private static Rectangle canvas;

    public Canvas() {

        canvas = new Rectangle(PADDING, PADDING, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.fill();

    }

    public int getWidth() {
        return canvas.getWidth();
    }

    public int getHeight() {
        return canvas.getHeight();
    }

}
