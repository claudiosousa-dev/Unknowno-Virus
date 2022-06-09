package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Enemy {

    private int xPosition;
    private Picture enemy;
    private Direction direction;
    private int speed; //Speed of zombie (random from 1 to 3)

    public Enemy() {

        direction = Direction.randomDirectionType();
        xPosition = (direction == Direction.RIGHT) ? 0 : Canvas.CANVAS_WIDTH - 320;
        enemy = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.MONSTER_TIER2);
        speed = RandomGenerator.getRandom(1, 3);

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

    public int[] bounds() {
        return new int[]{enemy.getX(), enemy.getX() + enemy.getWidth()};
    }

    public void show() {
        enemy.draw();
    }

    public void hide() {
        enemy.delete();
    }

}
