package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.factory.EnemyFactory;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.utils.GameOverMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.MainMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final int delay;
    private Picture background;

    private Hero hero;
    private Enemy[] enemies;
    private final int spawnedEnemies = 2;
    private int enemyDeadCounter;

    private Health health;

    private CollisionDetector collisionDetector;

    private boolean gameOver;
    private boolean win;

    //private final Picture startMenu;
    //private final Picture gameOverShow;
    private Music musicGame;


    public Game(int delay) {

        this.delay = delay;
        gameOver = false;
        win = false;
        enemyDeadCounter = spawnedEnemies;

    }

    public void init() {

        //canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);

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

        collisionDetector = new CollisionDetector(hero, enemies);
        hero.setCollisionDetector(collisionDetector);

    }

    public void start() throws InterruptedException {

        musicGame.startMusic(-1);

        while (true) {

            try {

                Thread.sleep(delay);

            } catch (InterruptedException exception) {

                exception.printStackTrace();
                throw new RuntimeException(exception);

            }

            if (collisionDetector.checkHero()) {

                enemyDeadCounter--;
                health.setCounter(health.getHeroHealth() - 1);

            }

            if (collisionDetector.checkEnemies()) {

                enemyDeadCounter--;

            }

            if (checkEnd()) {

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

    private boolean checkEnd() {

        return enemyDeadCounter == 0 || health.getHeroHealth() == 0;

    }

    public void gameOver() {

        gameOver = true;
        hero.setDead(true);
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
