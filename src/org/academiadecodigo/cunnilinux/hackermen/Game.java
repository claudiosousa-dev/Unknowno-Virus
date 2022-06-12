package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.factory.EnemyFactory;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.utils.GameOverMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.MainMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    //private final Canvas canvas;
    private Picture background;

    private Hero hero;
    private Enemy[] enemies;
    private final int spawnedEnemies = 2;

    private Health health;

    private CollisionDetector collisionDetector;

    /**
     * Animation delay
     */
    private int delay;

    private boolean gameOver;

    //private final Picture startMenu;
    //private final Picture gameOverShow;
    private Music musicGame;


    public Game(int delay) {

        this.delay = delay;
        gameOver = false;

    }

    public void init() {

        //canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);

        collisionDetector = new CollisionDetector(hero, enemies);

        hero = new Hero(Canvas.CANVAS_WIDTH / 2);
        health = new Health();

        //startMenu = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.START_MENU_WHITE);
        //gameOverShow = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.GAME_OVER);
        musicGame = new Music(AssetPaths.DURING_GAME_MUSIC);

        setupMenu();

        background.draw();
        health.show();
        hero.show();

        enemies = new Enemy[spawnedEnemies];
        for (int i = 0; i < spawnedEnemies; i++) {

            enemies[i] = EnemyFactory.spawnEnemy(i);
            enemies[i].show();

        }

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        musicGame.startMusic(-1);

        while (true) {

            try {
                Thread.sleep(delay);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }

            if (CollisionDetector.detectCollisionHeroEnemy()) {

                health.setCounter(health.getHeroHealth() - 1);

                if (health.getHeroHealth() == 0) {

                    hero.setDead(true);
                    enemy.hide();
                    break;

                }
            }

            if (hero.getBullet() != null &&
                    hero.getBullet().isMoving() &&
                    CollisionDetector.detectCollisionBulletEnemy(hero.getBullet())) {

                hero.setDead(true);
                enemy.hide();
                hero.getBullet().hide();
                break;

            }

            moveAll();



        }

        gameOver();

    }

    public void moveAll() {

        try {

            hero.getBullet().move();

        } catch (NullPointerException ignored) {
        }

        for (Enemy enemy : enemies) {
            enemy.move();
        }

    }

    public void gameOver() {

        gameOver = true;
        musicGame.stop();
        setBackground();

    }

    private void setupMenu() {

        MainMenu menu = new MainMenu();
        menu.menuLoop();

    }

    private void setBackground() {

        GameOverMenu menu = new GameOverMenu();
        menu.menuLoop();

    }

}
