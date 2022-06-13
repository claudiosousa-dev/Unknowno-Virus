package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.cunnilinux.hackermen.AssetPaths;
import org.academiadecodigo.cunnilinux.hackermen.map.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu {
    private static final int KEY_ESC = 27;
    private boolean menu = true;
    private final Picture background = new Picture(Canvas.PADDING, Canvas.PADDING, AssetPaths.START_MENU_WHITE);
    private MenuInput menuInput = new MenuInput(new MenuLogic(this));

    public void menuLoop() {

        background.draw();
        Music music = new Music(AssetPaths.START_MENU_MUSIC);
        music.play(-1);

        while (menu) {

            background.load(AssetPaths.START_MENU_RED);

            try {

                Thread.sleep(100);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            background.load(AssetPaths.START_MENU_WHITE);

        }

        background.delete();
        music.stop();
    }

    void setMenu(boolean menu) {

        this.menu = menu;

    }

    private class MenuInput {
        public MenuInput(KeyboardHandler menuLogic) {

            Keyboard keyboard = new Keyboard(menuLogic);
            KeyboardEvent keyESC = new KeyboardEvent();
            KeyboardEvent KeyL = new KeyboardEvent();

            keyESC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            KeyL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            keyESC.setKey(KEY_ESC);
            KeyL.setKey(KeyboardEvent.KEY_L);

            keyboard.addEventListener(keyESC);
            keyboard.addEventListener(KeyL);
        }
    }

    private class MenuLogic implements KeyboardHandler {
        private MainMenu menu;

        MenuLogic(MainMenu menu) {

            this.menu = menu;

        }

        public void keyPressed(KeyboardEvent keyboardEvent) {

            if (keyboardEvent.getKey() == KEY_ESC) {

                menu.setMenu(false);
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {

                System.exit(0);

            }

        }

        public void keyReleased(KeyboardEvent keyboardEvent) {}

    }
}