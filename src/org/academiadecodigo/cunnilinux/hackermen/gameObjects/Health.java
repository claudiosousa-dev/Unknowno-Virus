package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Health {
    private final int MAXHEALTH = 3;
    private int counter;
    private Picture health1;
    private Picture health2;
    private Picture health3;

    public Health() {
        this.counter = MAXHEALTH;

        health1 = new Picture(-285,-150, AssetPaths.HEALTH);
        health2 = new Picture(-210,-150,AssetPaths.HEALTH);
        health3 = new Picture(-135,-150, AssetPaths.HEALTH);

        health1.grow(-250,-150);
        health2.grow(-250,-150);
        health3.grow(-250,-150);
    }

    public int getHeroHealth() {
        return counter;
    }

    public void show() {
        health1.draw();
        health2.draw();
        health3.draw();
    }

    public void hide() {
        health1.delete();
        health2.delete();
        health3.delete();
    }
    public void setCounter(int counter) {
        this.counter = counter;
        removeHealth();
    }

    public void removeHealth() {
        switch (counter) {
            case 1 :
                health1.draw();
                health2.delete();
                health3.delete();
                break;
            case 2 :
                health1.draw();
                health2.draw();
                health3.delete();
                break;
            case 3 :
                show();
                break;
            case 0 :
            default:
                hide();
        }
    }
}
