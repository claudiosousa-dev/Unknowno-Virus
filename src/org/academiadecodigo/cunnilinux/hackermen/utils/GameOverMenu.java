package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverMenu {

    private final Picture gameOverBackground;
    private boolean menu;
    private Music gameOverMusic;

    public GameOverMenu() {

        menu = true;
        gameOverBackground = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.GAME_OVER);
        gameOverMusic = new Music(AssetPaths.GAME_OVER_VOICE);

    }

    public void menuLoop() {

        gameOverBackground.draw();
        gameOverMusic.startMusic(0);

        while(true) {

            gameOverBackground.load(AssetPaths.GAME_OVER2);

            try {

                Thread.sleep(70);

            } catch (InterruptedException exception) {

                exception.printStackTrace();

            }

        }

        //gameOverMusic.stop();

    }
}