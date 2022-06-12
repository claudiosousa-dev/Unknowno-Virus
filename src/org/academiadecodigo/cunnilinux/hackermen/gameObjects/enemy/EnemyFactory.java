package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.map.Direction;

public class EnemyFactory {

    public static Zombie spawnEnemy(int enemyCounter) {

        Zombie enemy;

        if ((enemyCounter % 2) == 0) {
            enemy = new Zombie(Direction.RIGHT);
        } else {
            enemy = new Zombie(Direction.LEFT);
        }

        return enemy;

    }
}