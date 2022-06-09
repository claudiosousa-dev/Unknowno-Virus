package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Canvas canvas;
    private Picture background;
    private Hero hero;
    private Enemy enemy;
    private Health health;

    private boolean gameOver;
    private Projectile projectile;
    public void init() {

        Canvas canvas = new Canvas();
        health = new Health();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);
        hero = new Hero(Canvas.CANVAS_WIDTH/2);
        enemy = new Enemy();
        gameOver = false;

        background.draw();
        hero.draw();
        enemy.show();
        health.show();
        initCollisionDetector();

    }

    public void start() {

        while (true) {

            if(CollisionDetector.intersectsEnemy()) {
                health.setCounter(health.getHeroHealth() - 1);

                if (health.getHeroHealth() == 0) {
                    hero.setDead(true);
                    gameOver = true;
                    break;
                }
            }

            if(CollisionDetector.intersectsEnemy())

            hero.drawProjectile();
            enemy.move();

            try {
                Thread.sleep(500);
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
