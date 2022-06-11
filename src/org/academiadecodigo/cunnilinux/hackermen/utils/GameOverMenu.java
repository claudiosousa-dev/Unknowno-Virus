package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverMenu {

    private final Picture gameOverBackground = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.GAME_OVER);
    private final boolean menu = true;

    public void menuLoop() {

        gameOverBackground.draw();
        Music gameOverMusic = new Music(AssetPaths.GAME_OVER_VOICE);
        gameOverMusic.startMusic(0);

        for (; menu; this.gameOverBackground.load(AssetPaths.GAME_OVER)) {

            this.gameOverBackground.load(AssetPaths.GAME_OVER2);

            try {

                Thread.sleep(70);

            } catch (InterruptedException var2) {

                var2.printStackTrace();

            }
        }

        gameOverMusic.stop();

    }
}