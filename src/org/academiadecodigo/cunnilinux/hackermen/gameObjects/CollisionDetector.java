package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

public class CollisionDetector {

    //private static Canvas canvas;
    private static Hero hero;
    private static Enemy enemy;

    public static boolean detectCollisionHeroEnemy() {

        return (enemy.getRightX() > hero.getX() && enemy.getX() < hero.getRightX()) ||
                (enemy.getX() < hero.getRightX() && enemy.getRightX() > hero.getX());

    }

    public static boolean detectCollisionBulletEnemy(Projectile projectile) {
        return (enemy.getRightX() > projectile.getX() && enemy.getX() < projectile.getRightX()) ||
                (enemy.getX() < projectile.getRightX() && enemy.getRightX() > projectile.getX());
    }

    public static void setHero(Hero hero) {

        CollisionDetector.hero = hero;

    }

    public static void setEnemy(Enemy enemy) {

        CollisionDetector.enemy = enemy;

    }

    /*public static void setProjectile(Projectile projectile) {
        CollisionDetector.projectile = projectile;
    }*/

    /*public static void setCanvas(Canvas canvas) {
        CollisionDetector.canvas = canvas;
    }*/

}
