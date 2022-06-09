package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile {

    private int xPosition;

    private Picture bullet;

    private boolean moving;

    public Projectile(int xPosition) {
         this.xPosition=xPosition;
        bullet = new Picture(xPosition, Canvas.FLOOR_LEVEL,AssetPaths.BULLET1);
        moving = false;
    }
    public boolean isMoving(){
        return moving;
    }
    public void move(int distance){
        bullet.translate(distance,0);
    }
    public void setMoving(){
        moving = true;
    }
    public void draw(){
        bullet.draw();
    }
    public void setX(int xPosition) {
        this.xPosition =xPosition;
    }
    public void hideBullet(){
        bullet.delete();
        //if bullet position = enemy - deal damage and delete bullet.
    }


}
