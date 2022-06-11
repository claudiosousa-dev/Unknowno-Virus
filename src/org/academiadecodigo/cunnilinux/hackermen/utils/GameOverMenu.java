package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverMenu {

    private Picture gameOverBackground = new Picture(0.0, 0.0, "resources/gameover.png");
    private boolean menu = true;

    public void menuLoop() {
        this.gameOverBackground.draw();
        Music gameOverMusic = new Music("resources/gameovervoice.wav");
        gameOverMusic.startMusic(0);

        for (; this.menu; this.gameOverBackground.load("resources/gameover.png")) {
            this.gameOverBackground.load("resources/gameover2.png");

            try {
                Thread.sleep(70L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }
        gameOverMusic.stop();
    }
}