package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyKeyboardHandler implements KeyboardHandler {

    private Picture hero;

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_W) {
            hero.translate(0, -10);
        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_S) {
            hero.translate(0, 10);
        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_A) {
            hero.translate(-10, 0);
        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_D) {
            hero.translate(10, 0);
        }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }
    }
}
