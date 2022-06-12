package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Zombie extends Enemy {

    public Zombie(Direction direction) {
        super(direction);

        speed = RandomGenerator.getRandom(0.5, 5.0);

        int xPosition = (direction == Direction.RIGHT) ? 0 : Canvas.CANVAS_WIDTH;
        enemy = new Picture(xPosition, Canvas.FLOOR_LEVEL, AssetPaths.MONSTER_TIER2);
        enemy.translate(0, -enemy.getHeight());

        if (direction == Direction.LEFT) {
            enemy.translate(-getWidth(), 0);
        }

        grow();

    }

    public Picture getEnemy() {

        grow();
        return enemy;

    }

    @Override
    public void grow() {

        if (direction == Direction.LEFT) {

            enemy.grow(-getWidth(), 0);

        }

    }

}
