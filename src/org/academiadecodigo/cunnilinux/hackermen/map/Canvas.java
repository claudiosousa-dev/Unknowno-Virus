package org.academiadecodigo.cunnilinux.hackermen.map;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int PADDING = 0;
    public static final int CELL_SIZE = 10;
    public static final int CANVAS_WIDTH = 1800;
    public static final int CANVAS_HEIGHT = 900;
    public static final int CANVAS_RIGHT_LIMIT = CANVAS_WIDTH - CELL_SIZE;
    public static final int FLOOR_LEVEL = 740;

    private static Rectangle canvas;

    public Canvas() {

        canvas = new Rectangle(PADDING, PADDING, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.fill();

    }

}
