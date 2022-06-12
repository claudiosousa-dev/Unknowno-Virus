package org.academiadecodigo.cunnilinux.hackermen.gameObjects.factory;

import org.academiadecodigo.cunnilinux.hackermen.gameObjects.Enemy;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;

/**
 * A factory of different types of Enemies
 */
public class EnemyFactory {

    /**
     * Manufactures new random enemies
     *
     * @return a newly instantiated enemy
     */
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