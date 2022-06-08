package org.academiadecodigo.cunnilinux.hackermen.old;

/*

public class HeroOld {

    private Position pos;
    private Picture hero;

    private HeroInputs heroInputs = new HeroInputs(new HeroMovement(this));

    HeroOld(int col, int row) {
        pos = new Position(col, row);
        hero = new Picture(pos.colToX(), pos.rowToY(), "resources/claudioTiroDireita.png");
    }

    public Position getPos() {
        return pos;
    }

    Picture getHero() {
        return hero;
    }

    void draw() {
        hero.draw();
    }

    private void moveLeft() {
        pos.setCol(pos.getCol() - 1);
        hero.load("resources/claudioTiroEsquerda.png");
        hero.translate(Canvas.CELL_SIZE, 0);
       // if (this.getPos().getCol() == 0) {
         //   return;
        //}

    }

    private void moveRight() {

        pos.setCol(pos.getCol() + 1);
        hero.load("resources/claudioTiroDireita.png");
        hero.translate(Canvas.CELL_SIZE, 0);
       // if (this.getPos().getCol() == 10) {
           // return;
        //}

    }

    private class HeroInputs {
        private HeroInputs(KeyboardHandler heroMovement) {

            Keyboard keyboard = new Keyboard(heroMovement);

            KeyboardEvent left = new KeyboardEvent();
            KeyboardEvent right = new KeyboardEvent();

            right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            right.setKey(KeyboardEvent.KEY_RIGHT);
            left.setKey(KeyboardEvent.KEY_LEFT);

            keyboard.addEventListener(left);
            keyboard.addEventListener(right);
        }

    }

    public class HeroMovement implements KeyboardHandler {

        private HeroOld hero;

        private HeroMovement(HeroOld hero) {
            this.hero = hero;
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                hero.moveLeft();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                hero.moveRight();
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
        }

    }


}

*/
