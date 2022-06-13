package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Boss;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy.Zombie;
import org.academiadecodigo.cunnilinux.hackermen.utils.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private final Hero hero;
    private final Zombie[] enemies;
    private final Boss[] bosses;
    private final Bullet[] bullets;
    private Music zombieDie;

    public CollisionDetector(Hero hero, Zombie[] enemies) {
        this.hero = hero;
        this.enemies = enemies;
        bosses = null;
        bullets = hero.getBullets();
    }

    public CollisionDetector(Hero hero, Boss[] bosses) {
        this.hero = hero;
        enemies = null;
        this.bosses = bosses;
        bullets = hero.getBullets();
    }

    public boolean checkHeroEnemies() {

        boolean checkIntersection = false;

        if (enemies == null) {

            return false;

        }

        for (Zombie enemy : enemies) {

            if (!enemy.isDead() && intersects(hero.getHero(), enemy.getEnemy())) {

                checkIntersection = true;
                enemy.dead();


            } else {

                enemy.grow();

            }
        }

        return checkIntersection;

    }

    public boolean checkHeroBosses() {

        boolean checkIntersection = false;

        if (bosses == null) {

            return false;

        }

        for (Bullet bullet : bullets) {

            if (bullet.isMoving()) {

                for (Boss boss : bosses) {

                    if (!boss.isDead() && intersects(bullet.getBullet(), boss.getEnemy())) {

                        checkIntersection = true;
                        bullet.hide();
                        boss.dead();

                        zombieDie = new Music(AssetPaths.BOSS_DIE_SOUND);
                        zombieDie.play(0);

                    } else {

                        bullet.grow();

                    }

                }

            }

        }

        return checkIntersection;

    }

    public boolean checkEnemies() {

        boolean checkIntersection = false;

        if (enemies == null) {

            return false;

        }

        for (Bullet bullet : bullets) {

            if (bullet.isMoving()) {

                for (Zombie enemy : enemies) {

                    if (!enemy.isDead() && intersects(bullet.getBullet(), enemy.getEnemy())) {

                        checkIntersection = true;
                        bullet.hide();
                        enemy.dead();

                        zombieDie = new Music(AssetPaths.ZOMBIE_DIE_SOUND);
                        zombieDie.play(0);

                    } else {

                        bullet.grow();
                        enemy.grow();

                    }

                }

            }

        }

        return checkIntersection;

    }

    public boolean checkBosses() throws InterruptedException {

        boolean checkIntersection = false;

        if (bosses == null) {

            return false;

        }

        for (Bullet bullet : bullets) {

            if (bullet.isMoving()) {

                for (Boss boss : bosses) {

                    if (!boss.isDead() && intersects(bullet.getBullet(), boss.getEnemy())) {

                        checkIntersection = true;
                        bullet.hide();
                        boss.dead();

                        zombieDie = new Music(AssetPaths.BOSS_DIE_SOUND);
                        zombieDie.play(0);

                    } else {

                        bullet.grow();

                    }

                }

            }

        }

        return checkIntersection;

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
