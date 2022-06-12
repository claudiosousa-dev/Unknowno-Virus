package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Health {
    private final int MAX_HEALTH = 3;

    private int counter;

    private final Picture health1;
    private final Picture health2;
    private final Picture health3;

    public Health() {

        counter = MAX_HEALTH;

        health1 = new Picture(-285, -150, AssetPaths.HEALTH);
        health2 = new Picture(-210, -150, AssetPaths.HEALTH);
        health3 = new Picture(-135, -150, AssetPaths.HEALTH);

        health1.grow(-250, -150);
        health2.grow(-250, -150);
        health3.grow(-250, -150);

    }

    public int getHealth() {

        return counter;

    }

    public void hide() {

        health1.delete();
        health2.delete();
        health3.delete();

    }

    public void setCounter(int counter) {

        this.counter = counter;
        show();

    }

    public void show() {

        switch (counter) {
            case 1:
                health1.draw();
                health2.delete();
                health3.delete();
                break;
            case 2:
                health1.draw();
                health2.draw();
                health3.delete();
                break;
            case 3:
                health1.draw();
                health2.draw();
                health3.draw();
                break;
            case 0:
            default:
                hide();
        }

    }
}
