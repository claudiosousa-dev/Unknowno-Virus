package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.*;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.GameOverMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.MainMenu;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final Canvas canvas;
    private final Picture background;

    private final Hero hero;

    /**
     * Container of enemies
     */
    private final Enemy enemy;

    /**
     * Number of enemies to spawn
     */
    private int spawnedEnemies = 2;

    private final Health health;

    /**
     * Animation delay
     */
    private int delay;

    private boolean gameOver;

    private final Picture startMenu;
    private final Picture gameOverShow;
    private final Music musicGame;


    public Game(int delay) {

        canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);

        this.delay = delay;

        enemy = new Enemy(Direction.randomDirectionType());
        hero = new Hero(Canvas.CANVAS_WIDTH / 2);
        health = new Health();
        gameOver = false;

        startMenu = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.START_MENU_WHITE);
        gameOverShow = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.GAME_OVER);
        musicGame = new Music(AssetPaths.DURING_GAME_MUSIC);

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

        musicGame.startMusic(-1);

        while (true) {

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

            try {

                hero.getBullet().move();

            } catch (NullPointerException ignored) {
            }

            enemy.move();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }

        }

        gameOver();

    }

    public void gameOver() {

        gameOver = true;
        musicGame.stop();
        setBackground();

    }

    private void initCollisionDetector() {

        CollisionDetector.setHero(hero);
        CollisionDetector.setEnemy(enemy);

    }

}
