package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private final Hero hero;
    private final Enemy[] enemies;
    private final Enemy boss;
    private final Bullet[] bullets;
    private Music zombieDie;
    private Music bossDie;

    public CollisionDetector(Hero hero, Enemy[] enemies) {
        this.hero = hero;
        this.enemies = enemies;
        boss = null;
        bullets = hero.getBullets();
    }

    public CollisionDetector(Hero hero, Enemy boss) {
        this.hero = hero;
        enemies = null;
        this.boss = boss;
        bullets = hero.getBullets();
    }

    public boolean checkHeroEnemies() {

        boolean checkIntersection = false;

        if (enemies == null) {

            return false;

        }

        for (Enemy enemy : enemies) {

            if (!enemy.isDead() && intersects(hero.getHero(), enemy.getEnemy())) {

                checkIntersection = true;
                enemy.dead();


            } else {

                enemy.grow();

            }
        }

        return checkIntersection;

    }

    public boolean checkHeroBoss() {

        if (boss == null) {

            return false;

        }

        return intersects(hero.getHero(), boss.getEnemy());

    }

    public boolean checkEnemies() {

        boolean checkIntersection = false;

        if (enemies == null) {

            return false;

        }

        for (Bullet bullet : bullets) {

            if (bullet.isMoving()) {

                for (Enemy enemy : enemies) {

                    if (!enemy.isDead() && intersects(bullet.getBullet(), enemy.getEnemy())) {

                        checkIntersection = true;
                        bullet.hide();
                        enemy.dead();

                        zombieDie = new Music(AssetPaths.ZOMBIE_DIE_SOUND);
                        zombieDie.startMusic(0);

                    } else {

                        bullet.grow();
                        enemy.grow();

                    }

                }

            }

        }

        return checkIntersection;

    }

    public boolean checkBoss() throws InterruptedException {

        boolean checkIntersection = false;

        if (boss == null) {

            return false;

        }

        for (Bullet bullet : bullets) {

            if (bullet.isMoving()) {

                checkIntersection = intersects(bullet.getBullet(), boss.getEnemy());

            }

        }

        if (checkIntersection) {

            bossDie = new Music(AssetPaths.BOSS_DIE_SOUND);
            bossDie.startMusic(-1);

            Thread.sleep(2000);
            bossDie.stop();

            return true;
        }

        return false;

    }

    public static boolean intersects(Picture rect1, Picture rect2) {

        int rect1Width = rect1.getWidth();
        int rect1Height = rect1.getHeight();
        int rect2Width = rect2.getWidth();
        int rect2Height = rect2.getHeight();

        if (rect2Width <= 0 || rect2Height <= 0 || rect1Width <= 0 || rect1Height <= 0) {
            return false;
        }

        int rect1X = rect1.getX();
        int rect1Y = rect1.getY();
        int rect2X = rect2.getX();
        int rect2Y = rect2.getY();
        rect2Width += rect2X;
        rect2Height += rect2Y;
        rect1Width += rect1X;
        rect1Height += rect1Y;

        return ((rect2Width < rect2X || rect2Width > rect1X) &&
                (rect2Height < rect2Y || rect2Height > rect1Y) &&
                (rect1Width < rect1X || rect1Width > rect2X) &&
                (rect1Height < rect1Y || rect1Height > rect2Y));

    }

}
