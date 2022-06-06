package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Picture backgroundGame = new Picture(0, 0, "resources/backgroundGame.jpg");


    private Picture heroDireita = new Picture(450, 60, "resources/claudioTiroDireita.png");
    private Picture heroEsquerda = new Picture(450, 60, "resources/claudioTiroEsquerda.png");


    private Picture monsterTier1 = new Picture(400, 400, "resources/zombie.png");


    public void init() {
        backgroundGame.grow(50, 50);
        backgroundGame.draw();

        heroDireita.grow(-50, -50);
        heroDireita.draw();

        heroEsquerda.grow(-50,-50);
        heroEsquerda.draw();

        monsterTier1.grow(-120, -120);
        monsterTier1.draw();
    }

    public void start() {

    }

}
