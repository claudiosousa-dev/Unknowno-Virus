package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile {

    private Position pos;

    private Picture bullet;

    private boolean moving;

    public Projectile(int col, int row){
        pos = new Position(col, row);
        bullet = new Picture(pos.colToX(), pos.rowToY());
    }

}
