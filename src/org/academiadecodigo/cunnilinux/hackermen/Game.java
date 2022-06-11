package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.utils.GameOverMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.MainMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final Canvas canvas;
    private final Picture background;

    private final Hero hero;
    private final Enemy enemy;
    private final Health health;

    private boolean gameOver;

    private final Picture startMenu;
    private final Picture gameOverShow;
    public Music music;

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
    private void setupMenu() {
        MainMenu menu = new MainMenu();
        menu.menuLoop();

    }

    private void setBackground() {
        GameOverMenu menu = new GameOverMenu();
        menu.menuLoop();
    }

    public void init() {
        setupMenu();
        background.draw();
        hero.show();
        enemy.show();
        health.show();
        initCollisionDetector();

    }


    public void start() {

        Music musicGame = new Music("resources/duringGame.wav");
        musicGame.startMusic(-1);

        while (true) {

            if (CollisionDetector.detectCollisionHeroEnemy()) {

                health.setCounter(health.getHeroHealth() - 1);

                if (health.getHeroHealth() == 0) {
                    hero.setDead(true);
                    gameOver = true;
                    musicGame.stop();
                    enemy.hide();
                    setBackground();
                    break;
                }
            }

            if (hero.getBullet() != null &&
                    hero.getBullet().isMoving() &&
                    CollisionDetector.detectCollisionBulletEnemy(hero.getBullet())) {

                    hero.setDead(true);
                    enemy.hide();
                    musicGame.stop();
                    hero.getBullet().hide();

                    gameOver = true;
                    setBackground();
                    break;

            }

            try {

                hero.getBullet().move();

            } catch (NullPointerException ignored) {}

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
