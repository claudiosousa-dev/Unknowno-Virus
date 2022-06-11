package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final Canvas canvas;
    private final Picture background;

    private final Hero hero;
    private final Enemy enemy;
    private final Health health;
    private Picture startMenu;
    private Picture gameOverShow;



    private boolean gameOver;

    public Game() {

        canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);

        hero = new Hero(Canvas.CANVAS_WIDTH / 2);
        enemy = new Enemy();
        health = new Health();
        gameOver = false;
        startMenu = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.STARTMENU);
        gameOverShow = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.GAMEOVER);

    }

    public void init() {
        //startMenu.draw(); // Just for testing and need some graphic update!
        background.draw();
        hero.show();
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
                    enemy.hide();
                    gameOverShow.draw();
                    break;
                }
            }

            if (hero.getProjectile() != null && hero.getProjectile().isMoving()) {

                if (CollisionDetector.detectCollisionBulletEnemy(hero.getProjectile())) {

                    hero.setDead(true);
                    enemy.hide();
                    hero.getProjectile().hide();
                    gameOver = true;
                    gameOverShow.draw();
                    break;

                }

            }

            try {

                hero.getProjectile().move();

            } catch (NullPointerException ignored) {

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

        CollisionDetector.setHero(hero);
        CollisionDetector.setEnemy(enemy);

    }

}
