package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

public class BulletFactory {

    private final static int MAX_BULLETS = 10;

    public static Bullet[] createBullets() {

        Bullet[] bullets = new Bullet[MAX_BULLETS];

        for (int i = 0; i < bullets.length; i++) {

            bullets[i] = new Bullet();

        }

        return bullets;
    }

}


