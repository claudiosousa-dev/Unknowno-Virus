package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Hero {

    private int xPosition;
    private final Picture heroRight;
    private final Picture heroLeft;
    private final HeroInputs heroInputs;
    private Direction direction;
    private boolean dead;
    private Projectile projectile;

    public Hero(int xPosition) {

        this.xPosition = xPosition;
        heroLeft = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.HERO_LEFT);
        heroRight = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.HERO_RIGHT);
        heroInputs = new HeroInputs(new HeroMovement(this));
        direction = Direction.RIGHT;
        dead = false;
        projectile = null;

    }

    /*public Picture getHero() {

        if (direction == Direction.RIGHT) {
            return heroRight;
        } else {
            return heroLeft;
        }

    }*/

    public void show() {

        if (direction == Direction.RIGHT) {

            heroLeft.delete();
            heroRight.draw();

        } else {

            heroRight.delete();
            heroLeft.draw();

        }

    }

    public void moveProjectile() {

        if (projectile != null && projectile.isMoving()) {

            if (projectile.getDirection() == Direction.RIGHT) {
                projectile.move(Canvas.CELL_SIZE);
            } else {
                projectile.move(-Canvas.CELL_SIZE);
            }
        }

    }

    public void shootProjectile() {

        if (projectile != null) {

            projectile = new Projectile(getX(), direction);
            projectile.show();

        }

    }

    private void moveLeft() {

        if (getX() > Canvas.CELL_SIZE) {
            setDirection(Direction.LEFT);
            translate(-Canvas.CELL_SIZE);
        } else {
            setDirection(Direction.RIGHT);
            setX(Canvas.CELL_SIZE);
        }

    }

    private void moveRight() {

        if (getRightX() < Canvas.CANVAS_RIGHT_LIMIT) {
            setDirection(Direction.RIGHT);
            translate(Canvas.CELL_SIZE);
        } else {
            setDirection(Direction.LEFT);
            setX(Canvas.CANVAS_RIGHT_LIMIT - getWidth());
        }

    }

    private void translate(int distance) {

        draw();
        heroLeft.translate(distance, 0);
        heroRight.translate(distance, 0);

    }

    private static class HeroInputs {

        public HeroInputs(KeyboardHandler heroMovement) {

            Keyboard keyboard = new Keyboard(heroMovement);

            int[] keysArray = {KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_SPACE};
            addEventListener(keyboard, keysArray);

        }

        public void addEventListener(Keyboard keyboard, int[] keysArray) {

            for (int key : keysArray) {
                keyboard.addEventListener(createKeyboardEvent(key, KeyboardEventType.KEY_PRESSED));
            }

        }

        public KeyboardEvent createKeyboardEvent(int keyboardEventKey, KeyboardEventType keyboardEventType) {

            KeyboardEvent keyboardEvent = new KeyboardEvent();
            keyboardEvent.setKey(keyboardEventKey);
            keyboardEvent.setKeyboardEventType(keyboardEventType);
            return keyboardEvent;

        }

    }

    public class HeroMovement implements KeyboardHandler {

        private final Hero hero;

        private HeroMovement(Hero hero) {
            this.hero = hero;
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_LEFT:
                    hero.moveLeft();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    hero.moveRight();
                    break;
                case KeyboardEvent.KEY_SPACE:
                default:
                    shootProjectile();
                    break;

            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }

    }

    /*public boolean isDead() {
        return dead;
    }*/

    public void setDead(boolean dead) {

        this.dead = dead;

    }

    /*public Direction getDirection() {
        return direction;
    }*/

    public void setDirection(Direction direction) {

        this.direction = direction;

    }

    public int getX() {

        return heroRight.getX();

    }

    public int getRightX() {

        return getX() + getWidth();

    }

    public void setX(int xPosition) {

        translate(xPosition - getX());
        this.xPosition = xPosition;

    }

    public int getWidth() {

        return heroRight.getWidth();

    }

    public Projectile getProjectile() {

        return projectile;

    }
}

