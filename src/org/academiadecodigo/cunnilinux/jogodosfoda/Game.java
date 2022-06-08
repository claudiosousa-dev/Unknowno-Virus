package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.cunnilinux.jogodosfoda.gameObjects.Hero;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Hero hero;
    private Picture backgroundGame = new Picture(0, 0, AssetPaths.BACKGROUND);
    private Picture monsterTier1 = new Picture(400, 400, AssetPaths.MONSTER_TIER1);

    public void init() {

    }

    public void start() {
        setupThings();
        setupLevel();
        // ProjectileFactory.createProjectiles();
        //Enemies.createEnemies();

    }

    private void setupLevel() {
        backgroundGame.draw();
        hero.draw();

    }

    public void setupThings() {
        hero = new Hero(1, 1);
        backgroundGame = new Picture(0, 0, "resources/backgroundGame.jpg");
    }


}

