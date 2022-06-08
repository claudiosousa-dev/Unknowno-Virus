package org.academiadecodigo.cunnilinux.hackermen.gameObjects;
import org.academiadecodigo.cunnilinux.hackermen.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemies {

    //createEnemies(){
    private Picture monsterTier2 = new Picture(400.0, 400.0, "resources/zombie.png");
    Game game = new Game();
    Picture zombie;

    private int col;
    private int row;

    public Enemies(int col) {
        zombie = new Picture(getCol(), getCol());  //row no value.
        }



    public void moveZombie() {
        int movePos = (int)(Math.random() * 2);
        if (movePos == 1) {
            this.moveLeft();
        }
        if (movePos == 2) {
            this.moveRight();
        }

    }

    private void moveRight() {
        if (this.getCol() <= 30) {
            this.setCol((int) (this.getCol() + Math.random() * 3)); //Speed of zombie to right (random from 0 to 2)
            this.monsterTier2.draw();
            this.monsterTier2.translate(40.0, 0.0);
        }
    }

    private void moveLeft() {
        if (this.getCol() > 10) {
            this.setCol((int) (this.getCol() - Math.random() * 3)); //Speed of zombie to left (random from 0 to 2)
            this.monsterTier2.draw();
            this.monsterTier2.translate(40.0, 0.0);
        }
    }
    public int getCol() {
        return this.col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }
}

//joao
