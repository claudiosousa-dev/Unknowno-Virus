package org.academiadecodigo.cunnilinux.hackermen.gameObjects;


import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;

public class CollisionDetector {

    private static Canvas canvas;
    private static Hero hero;
    private static Enemy enemy;
    private static Projectile projectiles;

    public static boolean intersectsEnemy() {
        return hero.bounds().intersects(enemy.bounds());
    }

    public static void setHero(Hero hero) {
        CollisionDetector.hero = hero;
    }

    public static void setEnemy(Enemy enemy) {
        CollisionDetector.enemy = enemy;
    }

    public static void setCanvasBoundaries(Canvas canvas) {
        CollisionDetector.canvas = canvas;
    }
    
}
