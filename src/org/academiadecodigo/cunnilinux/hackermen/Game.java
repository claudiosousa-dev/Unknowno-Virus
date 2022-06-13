package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Boss;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.EnemyFactory;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Zombie;
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
    private Bullet[] bullets;
    private Zombie[] enemies;
    private Boss[] bosses;
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

            if (collisionDetector.checkHeroEnemies() || collisionDetector.checkHeroBosses()) {

                enemyDeadCounter--;
                health.setCounter(health.getHealth() - 1);

            }

            if (collisionDetector.checkEnemies() || collisionDetector.checkBosses()) {

                enemyDeadCounter--;

            }

            if (health.getHealth() == 0) {

                gameOver = true;
                win = false;

            }

            // Next level
            if (enemyDeadCounter == 0) {

                if (gameLevel == 2) {

                    win = true;
                    gameOver = true;

                }

                break;

            }

            moveAll(gameLevel);

        }

        if (gameOver) {

            gameOver();
            //return;

        }

        gameLevel++;
        Thread.sleep(3000);
        start();

    }

    public void moveAll(int gameLevel) {

        moveBullets();

        switch (gameLevel) {

            case 1:
                for (Zombie enemy : enemies) {

                    enemy.move();

                }
                break;
            case 2:
                for (Boss boss : bosses) {

                    boss.move();

                }

        }

    }

    private void moveBullets() {

        for (Bullet bullet : bullets) {

            bullet.move();

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
                musicGame.play(true);

                health = new Health();
                hero = new Hero(Canvas.CANVAS_WIDTH / 2);
                bullets = hero.getBullets();

                enemies = new Zombie[spawnedEnemies];
                for (int i = 0; i < spawnedEnemies; i++) {

                    enemies[i] = EnemyFactory.spawnEnemy(i);

                }
                enemyDeadCounter = spawnedEnemies;
                break;

            case 2:
                hero.setX(Canvas.CANVAS_WIDTH / 2);
                bosses = new Boss[spawnedEnemies];

                bosses[0] = new Boss(Direction.LEFT, AssetPaths.BOSS_FINAL);
                bosses[1] = new Boss(Direction.RIGHT, AssetPaths.BOSS1_RIGHT);

                enemyDeadCounter = spawnedEnemies;

                for (Bullet bullet : bullets) {

                    bullet.setMoving(false);
                    bullet.hide();

                }

                break;

        }

    }

    public void setupCollisionDetector(int gameLevel) {

        switch (gameLevel) {

            case 1:
                collisionDetector = new CollisionDetector(hero, enemies);
                break;
            case 2:
                collisionDetector = new CollisionDetector(hero, bosses);

        }

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
                bosses[0].show();
                bosses[1].show();

        }

    }

    public void gameOver() throws InterruptedException {

        hero.setDead(true);
        musicGame.stop();

        if (win) {

            victoryGame();

        } else {

            setBackground();

        }
        Thread.sleep(60000);

        System.exit(0);

    }

    public void victoryGame() {

        victoryBackground = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.VICTORY_MENU);
        victoryBackground.draw();
        musicOnVictory = new Music(AssetPaths.VICTORY_MENU_SOUND_AND_VOICE);
        musicOnVictory.play(true);

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
