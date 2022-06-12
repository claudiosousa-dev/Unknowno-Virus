package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.cunnilinux.hackermen.utils.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Boss extends Enemy {

    public Boss(Direction direction) {
        super(direction);

        speed = RandomGenerator.getRandom(0.5, 2.0);

        enemy = new Picture(Canvas.CANVAS_WIDTH, Canvas.FLOOR_LEVEL, AssetPaths.BOSS_FINAL);
        enemy.translate(-getWidth(), -enemy.getHeight());

    }

    public Picture getEnemy() {

        return enemy;

    }

}
