package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile {

    private final Picture projectile;
    private final Direction direction;
    private boolean moving;

    public Projectile(int xPosition, Direction direction) {

        projectile = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.BULLET);
        this.direction = direction;
        moving = true;

    }

    public boolean isMoving() {

        return moving;

    }

    public void move() {

        if (moving) {

            if (direction == Direction.RIGHT) {
                projectile.translate(Canvas.CELL_SIZE, 0);
            } else {
                projectile.translate(-Canvas.CELL_SIZE, 0);
            }

        }

    }

    public void show() {

        projectile.draw();

    }

    public void hide() {

        moving = false;
        projectile.delete();

    }

    public int getX() {

        return projectile.getX();

    }

    public int getRightX() {

        return projectile.getX() + projectile.getWidth();

    }

}
