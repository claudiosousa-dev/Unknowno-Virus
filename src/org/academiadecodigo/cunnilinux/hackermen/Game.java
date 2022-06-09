package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.CollisionDetector;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Hero;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Canvas canvas;
    private Picture background;
    private Hero hero;
    private Enemy enemy;
    private boolean gameOver;

    public void init() {

        Canvas canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);
        hero = new Hero(Canvas.CANVAS_WIDTH / 2);
        enemy = new Enemy();
        gameOver = false;

        background.draw();
        hero.draw();
        enemy.show();

        initCollisionDetector();

    }

    public void start() {

        while (true) {

            CollisionDetector.intersectCanvas();

            if(CollisionDetector.intersectsEnemy()) {
                hero.setDead(true);
                gameOver = true;
                break;
            }
            enemy.move();

            try {
                Thread.sleep(300);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }

        }

    }

    private void initCollisionDetector() {

        CollisionDetector.setCanvasBoundaries(canvas);
        CollisionDetector.setHero(hero);
        CollisionDetector.setEnemy(enemy);

    }

}
