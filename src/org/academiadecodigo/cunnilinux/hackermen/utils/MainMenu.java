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

            this.background.draw();
            Music music = new Music(AssetPaths.START_MENU_MUSIC);
            music.startMusic(-1);

            for(; this.menu; this.background.load(AssetPaths.START_MENU_WHITE)) {

                this.background.load(AssetPaths.START_MENU_RED);

                try {

                    Thread.sleep(70);

                } catch (InterruptedException var2) {

                    var2.printStackTrace();

                }
            }

            this.background.delete();
            music.stop();
        }

        void setMenu(boolean var1) {

            this.menu = var1;

        }

        private class MenuInput {
            public MenuInput(KeyboardHandler var2) {

                Keyboard var3 = new Keyboard(var2);
                KeyboardEvent var4 = new KeyboardEvent();
                KeyboardEvent var5 = new KeyboardEvent();

                var4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                var5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                var4.setKey(KEY_ESC);
                var5.setKey(KeyboardEvent.KEY_L);
                var3.addEventListener(var4);
                var3.addEventListener(var5);

            }
        }

        private class MenuLogic implements KeyboardHandler {
            private MainMenu menu;

            MenuLogic(MainMenu var2) {

                this.menu = var2;

            }

            public void keyPressed(KeyboardEvent var1) {

                if (var1.getKey() == KEY_ESC) {

                    this.menu.setMenu(false);

                }

                if (var1.getKey() == KeyboardEvent.KEY_L) {

                    System.exit(0);

                }

            }

            public void keyReleased(KeyboardEvent var1) {}

        }
    }