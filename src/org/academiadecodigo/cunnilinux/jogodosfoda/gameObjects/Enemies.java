package org.academiadecodigo.cunnilinux.jogodosfoda.gameObjects;
import org.academiadecodigo.cunnilinux.jogodosfoda.Game;
import org.academiadecodigo.cunnilinux.jogodosfoda.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemies {

    //createEnemies(){
    private Picture monsterTier2 = new Picture(400.0, 400.0, "resources/zombie.png");
    Game game = new Game();
    Picture zombie;
    Position pos;

    public Enemies() {
        zombie = new Picture(pos.getCol(), getCol(), "resources/zombie.png");  // Second "getCol()" should be row value, but zombie doesnt need row value.
    }


    public void moveZombie() {
        int movePos = (int) (Math.random() * 2);
        if (movePos == 1) {
            this.moveLeft();
        }
        if (movePos == 2) {
            this.moveRight();
        }
    }

    private void moveRight() {
        if (this.getCol() <= 30) { // Needs testing
            this.pos.setCol((int) (this.getCol() + Math.random() * 3)); //Speed of zombie to right (random from 0 to 2)
            this.monsterTier2.draw();
            this.monsterTier2.translate(40.0, 0.0); // Needs testing
        }
    }

    private void moveLeft() {
        if (this.getCol() > 10) { // Needs testing
            this.pos.setCol((int) (this.getCol() - Math.random() * 3)); //Speed of zombie to left (random from 0 to 2)
            this.monsterTier2.draw();
            this.monsterTier2.translate(40.0, 0.0); // Needs testing
        }
    }

    public int getCol() {
        return pos.getCol();
    }
}
//joao
