package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.factory.EnemyFactory;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.utils.GameOverMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.MainMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private int gameLevel;
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
        gameLevel = 1;

    }

    public void init() {

        //startMenu = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.START_MENU_WHITE);
        //gameOverShow = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.GAME_OVER);
        musicGame = new Music(AssetPaths.DURING_GAME_MUSIC);

        setupMenu();


        health.show();


        enemies = new Enemy[spawnedEnemies];
        for (int i = 0; i < spawnedEnemies; i++) {

            enemies[i] = EnemyFactory.spawnEnemy(i);
            enemies[i].show();

        }

        collisionDetector = new CollisionDetector(hero, enemies);
        hero.setCollisionDetector(collisionDetector);

        musicGame.startMusic(-1);

    }

    public void start() throws InterruptedException {

        setupLevel();

        while (!gameOver) {

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

            if (checkGameEnd()) {

                gameOver = true;

            }

            moveAll();

        }

        if (gameOver) {

            gameOver();

        }

        gameLevel++;
        start();

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

    public void setupLevel() {

        if (gameLevel < 1 || gameLevel > 2) {

            gameOver();

        } else {

            setupStage(gameLevel);
            setupCollisionDetector(gameLevel);
            renderStage(gameLevel);

        }
    }

    public void setupStage(int gameLevel) {

        switch (gameLevel) {

            case 1:
                background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND_LEVEL1);
                health = new Health();
                hero = new Hero(Canvas.CANVAS_WIDTH / 2);
                break;
            case 2:
            default:
                background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND_LEVEL2);
                hero =  new Hero(0);
                break;

        }

    }

    public void setupCollisionDetector(int gameLevel) {



    }

    public void renderStage(int gameLevel) {

        background.draw();
        hero.show();

    }


    private boolean checkGameEnd() {

        return enemyDeadCounter == 0 || health.getHeroHealth() == 0;

    }

    public void gameOver() {

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
