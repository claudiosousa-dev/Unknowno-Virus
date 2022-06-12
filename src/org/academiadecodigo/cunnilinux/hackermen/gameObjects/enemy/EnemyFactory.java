package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.map.Direction;

public class EnemyFactory {

    public static Enemy spawnEnemy(int enemyCounter) {

        Enemy enemy;

        if ((enemyCounter % 2) == 0) {
            enemy = new Enemy(Direction.RIGHT);
        } else {
            enemy = new Enemy(Direction.LEFT);
        }

        return enemy;

    }
}