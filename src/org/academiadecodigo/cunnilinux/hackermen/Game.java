package org.academiadecodigo.cunnilinux.hackermen;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Hero;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Canvas canvas;
    private Picture background;
    private Hero hero;
    private Enemy enemy;
    private boolean gameOver;

    public void init() {

        Canvas canvas = new Canvas();
        background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.BACKGROUND);
        hero = new Hero(canvas.getWidth() / 2);
        //enemy = new Enemy();
        gameOver = false;

        background.draw();
        hero.draw();

    }

    public void start() {
        //init();
        //setupThings();
        //setupLevel();
        // ProjectileFactory.createProjectiles();
        //Enemies.createEnemies();

        //while (true) {


        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        //}

    }

    private void setupLevel() {

        //background.draw();
        //hero.draw();

    }

    public void setup() {


    }

}
