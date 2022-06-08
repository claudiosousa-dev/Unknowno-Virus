package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.cunnilinux.jogodosfoda.gameObjects.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Picture background = new Picture(0, 0, AssetPaths.BACKGROUND);
    private Hero hero;
    private Picture monsterTier1 = new Picture(400, 400, AssetPaths.MONSTER_TIER1);
    private boolean gameOver = false;

    public void init() {

        Canvas canvas = new Canvas();

    }

    public void start() {
        setupThings();
        setupLevel();
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

    public void setupThings() {

        hero = new Hero(1, 1);
        background = new Picture(0, 0, AssetPaths.BACKGROUND);

    }

}
