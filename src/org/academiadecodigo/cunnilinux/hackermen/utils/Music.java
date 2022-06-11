package org.academiadecodigo.cunnilinux.hackermen.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

    public class Music {
        private Clip clip;
        private String filePath;

        public Music(String filePath) {
            this.filePath = filePath;
        }

        public void stop() {
            if (clip.isRunning()) {
                clip.stop();
            }
        }

        public void startMusic(int loop) {
            URL soundURL;
            AudioInputStream audioInputStream = null;

            try {
                File file = new File(filePath);
                soundURL = file.toURI().toURL();

                audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            } catch (UnsupportedAudioFileException | IOException e) {
                System.err.println(e.getMessage());
            }

            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                // -1 for Infinite Clip Loop | clip.LOOP_CONTINUOUSLY
                clip.loop(loop);
                clip.start();
            } catch (LineUnavailableException | IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

