package org.academiadecodigo.cunnilinux.hackermen.map;

/**
 * The directions in which positions may move
 */
public enum Direction {

    LEFT,
    RIGHT;

    /**
     * Detects if two directions are opposite
     *
     * @param dir the direction to compare with
     * @return true if directions are opposite
     */
    public boolean isOpposite(Direction dir) {
        return dir.equals(oppositeDirection());
    }

    /**
     * Obtains the opposite direction
     *
     * @return the opposite direction
     */
    public Direction oppositeDirection() {

        Direction opposite = null;

        switch (this) {
            case LEFT:
                opposite = Direction.RIGHT;
                break;
            case RIGHT:
                opposite = Direction.LEFT;
                break;
        }

        return opposite;
    }

}
