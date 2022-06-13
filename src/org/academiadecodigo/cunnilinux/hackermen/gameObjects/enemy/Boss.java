package org.academiadecodigo.cunnilinux.hackermen.gameObjects.enemy;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.cunnilinux.hackermen.map.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Boss extends Enemy {

    public Boss(Direction direction, String picturePath) {
        super(direction);

        speed = 1.5;

        if (direction == Direction.LEFT) {
            enemy = new Picture(Canvas.CANVAS_WIDTH, Canvas.FLOOR_LEVEL, picturePath);
            enemy.translate(-getWidth(), -enemy.getHeight());
        } else {
            enemy = new Picture(0, Canvas.FLOOR_LEVEL, picturePath);
            enemy.translate(0, -enemy.getHeight());
        }
    }

    public Picture getEnemy() {

        return enemy;

    }

}
