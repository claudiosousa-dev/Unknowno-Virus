package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy {

    protected Picture enemy;
    protected Direction direction;
    protected double speed;
    protected boolean dead;

    public Enemy(Direction direction) {

        dead = false;
        this.direction = direction;

    }

    public abstract Picture getEnemy();

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

    public void grow() {};

    public boolean isDead() {

        return dead;

    }

    public void dead() {

        this.dead = true;
        hide();

    }
}
