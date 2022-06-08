package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.cunnilinux.jogodosfoda.factories.ProjectileFactory;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

<<<<<<< HEAD
    private Hero hero;
    private Picture backgroundGame;

    public void start() {
        setupThings();
        setupLevel();
        // ProjectileFactory.createProjectiles();
        //Enemies.createEnemies();
=======
    private Picture backgroundGame = new Picture(0, 0, AssetPaths.BACKGROUND);
    private Picture heroDireita = new Picture(450, 60, AssetPaths.HERO_RIGHT);
    private Picture heroEsquerda = new Picture(450, 60, AssetPaths.HERO_LEFT);
    private Picture monsterTier1 = new Picture(400, 400, AssetPaths.MONSTER_TIER1);
>>>>>>> 2468be00406d109040122f2225e0a1f3bb1a1e0a

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
<<<<<<< HEAD


=======
>>>>>>> 2468be00406d109040122f2225e0a1f3bb1a1e0a


