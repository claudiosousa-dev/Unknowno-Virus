package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Boss;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.EnemyFactory;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.GameOverMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.MainMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private int gameLevel;
    private final int delay;
    private Picture background;
    private Picture victoryBackground;

    private Hero hero;
    private Enemy[] enemies;
    private Enemy boss;
    private final int spawnedEnemies = 2;
    private int enemyDeadCounter;

    private Health health;

    private CollisionDetector collisionDetector;

    private boolean gameOver;
    private boolean win;

    private Music musicGame;
    private Music musicOnVictory;



    public Game(int delay) {

        this.delay = delay;
        gameOver = false;
        win = false;

        gameLevel = 1;

    }

    public void init() {

        setupMenu();

    }

    public void start() throws InterruptedException {

        setupLevel();

        while (!gameOver) {

            try {

                Thread.sleep(delay);

            } catch (InterruptedException exception) {

                throw new RuntimeException(exception);

            }

            if (collisionDetector.checkHeroEnemies() || collisionDetector.checkHeroBoss()) {

                enemyDeadCounter--;
                health.setCounter(health.getHealth() - 1);

            }

            if (collisionDetector.checkEnemies() || collisionDetector.checkBoss()) {

                enemyDeadCounter--;

            }

            if (health.getHealth() == 0) {

                gameOver = true;
                win = false;

            }

            // Next level
            if (enemyDeadCounter == 0) {

                win = true;
                break;

            }

            moveAll(gameLevel);

        }

        if (gameOver) {

            win = true;
            gameOver();

        }

        gameLevel++;
        start();

    }

    public void moveAll(int gameLevel) {

        try {

            hero.getBullet().move();

        } catch (NullPointerException ignored) {
        }

        switch (gameLevel) {

            case 1:
                for (Enemy enemy : enemies) {

                    enemy.move();

                }
                break;
            case 2:
                boss.move();

        }

    }

    public void setupLevel() throws InterruptedException {

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
                musicGame = new Music(AssetPaths.DURING_GAME_MUSIC);
                musicGame.startMusic(-1);
                health = new Health();
                hero = new Hero(Canvas.CANVAS_WIDTH / 2);

                enemies = new Enemy[spawnedEnemies];
                for (int i = 0; i < spawnedEnemies; i++) {

                    enemies[i] = EnemyFactory.spawnEnemy(i);

                }
                enemyDeadCounter = spawnedEnemies;
                break;

            case 2:
                hero.setX(Canvas.PADDING);
                boss = new Boss(Direction.LEFT);
                enemyDeadCounter = 1;
                break;

        }

    }

    public void setupCollisionDetector(int gameLevel) {

        switch (gameLevel) {
            case 1:
                collisionDetector = new CollisionDetector(hero, enemies);
                break;
            case 2:
                collisionDetector = new CollisionDetector(hero, boss);

        }

        hero.setCollisionDetector(collisionDetector);

    }

    public void renderStage(int gameLevel) {

        background.draw();
        health.show();
        hero.show();

        switch (gameLevel) {
            case 1:
                for (int i = 0; i < spawnedEnemies; i++) {

                    enemies[i].show();

                }
                break;
            case 2:
                boss.show();
        }

    }

    public void gameOver() throws InterruptedException {

        hero.setDead(true);
        musicGame.stop();
        setBackground();

        if (win) {
            victoryGame();
        }
        Thread.sleep(1000);
        System.exit(0);

    }

    public void victoryGame() {

        victoryBackground = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.VICTORY_MENU);
        victoryBackground.draw();
        musicOnVictory = new Music(AssetPaths.VICTORY_MENU_SOUND_AND_VOICE);
        musicOnVictory.startMusic(0);

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
