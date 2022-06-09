package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.RandomGenerator;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.concurrent.RecursiveAction;


public class Enemy {

    private int xPosition;
    private Picture enemy;
    private Direction direction;
    private int speed; //Speed of zombie (random from 1 to 3)

    public Enemy() {

        direction = Direction.randomDirectionType();
        xPosition = (direction == Direction.RIGHT) ? 0 : Canvas.CANVAS_WIDTH;
        enemy = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.MONSTER_TIER1);
        speed = RandomGenerator.getRandom(1, 2);

    }

    public void move() {
        switch (direction) {
            case RIGHT:
                moveRight();
                break;
            case LEFT:
            default:
                moveLeft();
                break;
        }
    }

    private void moveRight() {

        enemy.translate(Canvas.CELL_SIZE, 0.0);
        show();

    }

    private void moveLeft() {

        enemy.translate(-Canvas.CELL_SIZE, 0.0);
        show();

    }

    public Rectangle bounds() {
        return new Rectangle(enemy.getX(), enemy.getY(),
                enemy.getWidth(), enemy.getHeight());
    }

    public void show() {
        enemy.draw();
    }

    public void hide() {
        enemy.delete();
    }
}
