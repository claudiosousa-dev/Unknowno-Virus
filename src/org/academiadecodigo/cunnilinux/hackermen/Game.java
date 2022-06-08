package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Canvas canvas;
    private Picture background;
    private Hero hero;
    private Enemy enemyTier1;
    private boolean gameOver;

    public void init() {

        Canvas canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);
        hero = new Hero(canvas.);


        background.draw();

        hero = new Hero(1, 1);

        hero.draw();

    }

    public void start() {
        //setupThings();
        //setupLevel();
        // ProjectileFactory.createProjectiles();
        //Enemies.createEnemies();

        while (true) {


            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }

        }

    }

    private void setupLevel() {

        background.draw();
        hero.draw();

    }

    public void setup() {


    }

}
