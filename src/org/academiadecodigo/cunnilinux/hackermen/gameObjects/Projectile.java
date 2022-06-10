package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile {

    private final Picture bullet;
    private Direction direction;
    private boolean moving;

    public Projectile(int xPosition, Direction direction) {

        bullet = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.BULLET);
        this.direction = direction;
        moving = true;

    }

    public boolean isMoving() {

        return moving;

    }

    public void move(int distance) {

        bullet.translate(distance, 0);

    }

    public void setMoving(Direction direction) {

        moving = true;
        this.direction = direction;

    }

    public void show() {

        bullet.draw();

    }

    public void hide() {

        bullet.delete();

    }

    public int getX() {

        return bullet.getX();

    }

    public int getRightX() {

        return bullet.getX() + bullet.getWidth();

    }

    public Direction getDirection() {
        return direction;
    }
}
