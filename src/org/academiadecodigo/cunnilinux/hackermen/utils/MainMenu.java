package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu {
        private boolean menu = true;
        private Picture background = new Picture(0.0, 0.0, "resources/STARTMENU2WHITE.png");
        private MenuInput menuInput = new MenuInput(new MenuLogic(this));

        public void menuLoop() {
            this.background.draw();

            for(; this.menu; this.background.load("resources/STARTMENU2WHITE.png")) {
                this.background.load("resources/STARTMENU2RED.png");

                try {
                    Thread.sleep(70L);
                } catch (InterruptedException var2) {
                    var2.printStackTrace();
                }
            }

            this.background.delete();
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
                var4.setKey(27);
                var5.setKey(76);
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
                if (var1.getKey() == 27) {
                    this.menu.setMenu(false);
                }
                if (var1.getKey() == 76) {
                    System.exit(0);
                }
            }

            public void keyReleased(KeyboardEvent var1) {
            }
        }
    }