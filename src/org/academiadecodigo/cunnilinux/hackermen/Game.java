package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Canvas canvas;
    private Hero hero;
    private Enemy enemy;
    private Health health;

    private boolean gameOver;

    public void init() {

        Canvas canvas = new Canvas();
        Picture background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);

        hero = new Hero(Canvas.CANVAS_WIDTH / 2);
        enemy = new Enemy();
        health = new Health();
        gameOver = false;

        background.draw();
        hero.draw();
        enemy.show();
        health.show();
        initCollisionDetector();

    }

    public void start() {

        while (true) {

            if (CollisionDetector.detectCollisionHeroEnemy()) {

                health.setCounter(health.getHeroHealth() - 1);

                if (health.getHeroHealth() == 0) {
                    hero.setDead(true);
                    gameOver = true;
                    break;
                }
            }

            if (hero.getProjectile() != null && hero.getProjectile().isMoving()) {

                if (CollisionDetector.detectCollisionBulletEnemy()) {

                    enemy.hide();
                    hero.getProjectile().hide();

                }

            }

            hero.moveProjectile();
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

        //CollisionDetector.setCanvas(canvas);
        CollisionDetector.setHero(hero);
        CollisionDetector.setEnemy(enemy);
        CollisionDetector.setProjectile(hero.getProjectile());

    }

}
