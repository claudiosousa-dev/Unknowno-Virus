package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
public class Canvas {

        public static final int CELL_SIZE = 50;
        private static Rectangle myCanvas;

        public Canvas() {
            myCanvas = new Rectangle(0,0,CELL_SIZE * 38, CELL_SIZE * 20);
            myCanvas.fill();
        }

}
