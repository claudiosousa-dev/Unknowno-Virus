package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile {

    private Position pos;

    private Picture bullet;

    private boolean moving;

    public Projectile(int col, int row) {
        pos = new Position(col, row);
        bullet = new Picture(pos.colToX(), pos.rowToY(), AssetPaths.BULLET1);

    }
    public void draw(){
        bullet.draw();
    }
    private void setPos(int x, int y) {
        pos.setCol(x);
        pos.setRow(y);
    }
    public void resetBullet(){
        //if bullet position = enemy - deal damage and delete bullet.
    }


}
