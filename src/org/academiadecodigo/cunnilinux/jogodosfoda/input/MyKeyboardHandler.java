package org.academiadecodigo.cunnilinux.jogodosfoda.input;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyKeyboardHandler implements KeyboardHandler {

    private Picture heroDireita;
    private Picture heroEsquerda;

    public MyKeyboardHandler(Picture heroDireita, Picture heroEsquerda) {
        this.heroDireita = heroDireita;
        this.heroEsquerda = heroEsquerda;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                heroEsquerda.delete();
                heroDireita.draw();
                heroDireita.translate(-10, 0);
                break;
            case KeyboardEvent.KEY_D:
                heroDireita.delete();
                heroEsquerda.draw();
                heroEsquerda.translate(10, 0);
                break;
            case KeyboardEvent.KEY_S:
                heroDireita.translate(0,10);
                heroEsquerda.translate(0, 10);
                break;
            case KeyboardEvent.KEY_W:
                heroDireita.translate(0,-10);
                heroEsquerda.translate(0, -10);
                break;
            default:
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
