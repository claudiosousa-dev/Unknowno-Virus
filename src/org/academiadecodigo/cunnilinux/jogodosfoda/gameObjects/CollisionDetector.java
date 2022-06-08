package org.academiadecodigo.cunnilinux.jogodosfoda.gameObjects;

public class CollisionDetector {

    private static Hero hero;
    private static Enemy enemy;
    private static Projectile[] projectiles;

    public static boolean intersectsEnemy() {
        return false; // hero.bounds().intersects(enemies.bounds());
    }



    public static void setHero(Hero hero) {
        CollisionDetector.hero = hero;
    }

    public static void setEnemy(Enemy enemy) {
        CollisionDetector.enemy = enemy;
    }

}
