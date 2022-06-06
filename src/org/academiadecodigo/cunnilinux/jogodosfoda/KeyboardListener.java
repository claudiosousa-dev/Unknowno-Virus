package org.academiadecodigo.cunnilinux.jogodosfoda;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Picture heroDireita;
    private Picture heroEsquerda;
    public KeyboardListener(Picture hero) {
        this.hero = hero;
    }

    public void addEventListener() {
        KeyboardListener move = new KeyboardListener(hero);
        Keyboard moveHero = new Keyboard(move);


        KeyboardEvent heroMoveRight = new KeyboardEvent();
        KeyboardEvent heroMoveLeft = new KeyboardEvent();


        heroMoveLeft.setKey(KeyboardEvent.KEY_D);
        heroMoveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        heroMoveRight.setKey(KeyboardEvent.KEY_A);
        heroMoveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        moveHero.addEventListener(heroMoveLeft);
        moveHero.addEventListener(heroMoveRight);


        KeyboardListener move = new KeyboardListener(hero);
        Keyboard moveHero = new Keyboard(move);
    }




    public void setPicture1(Picture picture1) {
        this.hero = hero;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

