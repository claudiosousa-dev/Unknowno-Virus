package org.academiadecodigo.cunnilinux.hackermen.gameObjects;
import org.academiadecodigo.cunnilinux.hackermen.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemies {

    private Picture monsterTier2 = new Picture(400.0, 400.0, "resources/zombie.png");
    Game game = new Game();
    Picture zombie;
    Hero hero;
    private int col; // Needs to change

    // Lines to create a number of random zombies






    // .

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

    //HEALTH
    private Picture health1 = new Picture(200, 120, "resources/health.png");
    private Picture health2 = new Picture(200,110,"resources/health.png");
    private Picture health3 = new Picture(200,100, "resources/health.png");

    public void Health(int col, int row) {
        health1.draw();
        health2.draw();
        health3.draw();
    }

    public void removeHealth() { // Needs some changes
        if (hero.getX() == monsterTier2.getX()) {
            health3.delete();
        } else if (hero.getX() == monsterTier2.getX()) {
            health2.delete();
        } else if (hero.getX() == monsterTier2.getX()) {
            health1.delete();
            System.out.println("You lost!"); // EXAMPLE FOR TESTING
        }
    }
}

//joao
