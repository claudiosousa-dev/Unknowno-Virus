package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.cunnilinux.jogodosfoda.factories.ProjectileFactory;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Hero hero;
    private Picture backgroundGame;

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




