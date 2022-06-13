package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.cunnilinux.hackermen.Main;

import javax.sound.sampled.*;
//import java.io.File;
import java.io.IOException;
import java.net.URL;

    public class Music {
        private Clip clip;
        private final String filePath;

        public Music(String filePath) {

            this.filePath = filePath;

        }

        public void stop() {

            if (clip.isRunning()) {

                clip.stop();

            }
        }

        public void play(int loop) {

            URL soundURL;
            AudioInputStream audioInputStream = null;

            try {

                //File file = new File(filePath);
                //soundURL = file.toURI().toURL();

                soundURL = Main.class.getResource(filePath);
                audioInputStream = AudioSystem.getAudioInputStream(soundURL);

            } catch (UnsupportedAudioFileException | IOException e) {

                System.err.println(e.getMessage());

            }

            try {

                clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                // -1 for Infinite Clip Loop | clip.LOOP_CONTINUOUSLY
                clip.start();
                clip.loop(loop);

            } catch (LineUnavailableException | IOException e) {

                System.err.println(e.getMessage());

            }
        }
    }

