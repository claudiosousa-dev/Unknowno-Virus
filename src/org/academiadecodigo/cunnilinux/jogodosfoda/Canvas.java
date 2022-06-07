package org.academiadecodigo.cunnilinux.jogodosfoda;

import java.awt.*;

public class Canvas {

        public static final int CELL_SIZE =40;
        private static Rectangle CANVAS = null;

        Canvas() {
            CANVAS = new Rectangle(0,0,(CELL_SIZE) * 50, (CELL_SIZE) * 50);
        }

}
