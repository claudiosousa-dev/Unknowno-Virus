package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Enemy {

    private int xPosition;
    private final Picture enemy;
    private Direction direction;
    private double speed; //Speed (double value) of the zombie (random from 0.5 to 2)

    public Enemy() {

        direction = Direction.randomDirectionType();
        xPosition = (direction == Direction.RIGHT) ? 0 : Canvas.CANVAS_WIDTH - 320;
        enemy = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.MONSTER_TIER1);
        speed = RandomGenerator.getRandom(0.5, 2.0);

    }

    public void move() {

        switch (direction) {
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            default:
                break;
        }

    }

    private void moveRight() {

        enemy.translate(Canvas.CELL_SIZE * speed, 0.0);
        show();

    }

    private void moveLeft() {

        enemy.translate(-Canvas.CELL_SIZE * speed, 0.0);
        show();

    }

    public int getX() {

        return enemy.getX();

    }

    public int getRightX() {

        return enemy.getX() + enemy.getWidth();

    }

    public void show() {
        enemy.draw();
    }

    public void hide() {
        enemy.delete();
    }

}
