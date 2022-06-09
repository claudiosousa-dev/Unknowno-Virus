package org.academiadecodigo.cunnilinux.hackermen.gameObjects;

import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;

public class CollisionDetector {

    private static Canvas canvas;
    private static Hero hero;
    private static Enemy enemy;
    private static Projectile projectiles;

    public static boolean intersectsEnemy() {
        return checkIntersection(hero.bounds(), enemy.bounds());
    }

    public static boolean checkIntersection(int[] heroBounds, int[] enemyBounds) {

        return ((enemyBounds[1] > heroBounds[0]) && (enemyBounds[0] < heroBounds[1])) ||
                ((enemyBounds[0] < heroBounds[1]) && (enemyBounds[1] > heroBounds[0]));

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
