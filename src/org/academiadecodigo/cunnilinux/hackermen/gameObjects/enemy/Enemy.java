package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    private static final int MAX_ENEMY_WIDTH = 200;

    private final Picture enemy;
    private final Direction direction;
    private final double speed;
    private boolean dead;

    public Enemy(Direction direction) {

        dead = false;
        this.direction = direction;
        speed = RandomGenerator.getRandom(0.5, 2.0);

        int xPosition = (direction == Direction.RIGHT) ? 0 : Canvas.CANVAS_WIDTH - MAX_ENEMY_WIDTH;

        enemy = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.MONSTER_TIER2);
        enemy.translate(0, -enemy.getHeight());

        grow();

    }

    public Picture getEnemy() {

        grow();
        return enemy;

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

    }

    private void moveLeft() {

        enemy.translate(-Canvas.CELL_SIZE * speed, 0.0);

    }

    public int getX() {

        return enemy.getX();

    }

    public int getWidth() {

        return enemy.getWidth();

    }

    public void show() {

        enemy.draw();

    }

    public void hide() {

        enemy.delete();

    }

    public void grow() {

        if (direction == Direction.LEFT) {

            enemy.grow(-getWidth(), 0);

        }

    }

    public boolean isDead() {
        return dead;
    }

    public void dead() {

        this.dead = true;
        hide();

    }
}
