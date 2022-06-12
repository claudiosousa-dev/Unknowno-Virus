package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private final static int GUN_LEVEL = 780;
    private final static double BULLET_SPEED = 3.0;
    private final Picture bullet;
    private Direction direction;
    private boolean moving;


    public Bullet() {

        moving = false;
        bullet = new Picture(0, GUN_LEVEL, AssetPaths.BULLET);

    }

    public boolean isMoving() {

        return moving;

    }

    public void move() {

        if (moving) {

            if (direction == Direction.RIGHT) {

                bullet.translate(Canvas.CELL_SIZE * BULLET_SPEED, 0);

            } else {

                bullet.translate(-Canvas.CELL_SIZE * BULLET_SPEED, 0);

            }

        }

    }

    public void show() {

        bullet.draw();

    }

    public void hide() {

        moving = false;
        bullet.delete();

    }

    public void grow() {

        if (direction == Direction.LEFT) {

            bullet.grow(-getWidth(), 0);

        }

    }

    public int getX() {

        return bullet.getX();

    }

    public int getWidth() {

        return bullet.getWidth();

    }

    public Picture getBullet() {

        grow();
        return bullet;

    }

    public void setMoving(boolean moving) {

        this.moving = moving;

    }

    public void setDirection(Direction direction) {

        this.direction = direction;

    }

    public void setX(int distance) {

        bullet.translate(distance, 0);

    }

}
