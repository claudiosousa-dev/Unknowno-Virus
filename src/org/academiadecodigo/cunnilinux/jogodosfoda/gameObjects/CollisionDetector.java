package org.academiadecodigo.cunnilinux.jogodosfoda.gameObjects;

public class CollisionDetector {

    private static HeroOLd hero;
    private static Enemy[] enemies;
    private static Projectile[] projectiles;

    public static boolean intersectsEnemy() {
        return false; // hero.bounds().intersects(enemies.bounds());
    }

    public static void setHero(HeroOLd hero) {
        CollisionDetector.hero = hero;
    }

}
