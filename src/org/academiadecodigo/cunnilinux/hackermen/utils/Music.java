package org.academiadecodigo.cunnilinux.hackermen.utils;

import org.academiadecodigo.cunnilinux.hackermen.Main;

import javax.sound.sampled.*;
//import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            //InputStream inputStream;
            AudioInputStream audioInputStream = null;

            try {

                //File file = new File(filePath);
                //soundURL = file.toURI().toURL();

                String resource = "music.wav";
                //inputStream = Music.class.getResourceAsStream("/resources/" + resource); NOT WORKING
//                inputStream = Music.class.getResourceAsStream("resources/" + resource);
//                if (inputStream == null) {
//                    // this is how we load file within editor (eg eclipse)
//                    inputStream = Music.class.getClassLoader().getResourceAsStream(resource);
//                }

                inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
                //inputStream = this.getClass().getResourceAsStream("/StartMenuMusic.wav");
                audioInputStream = AudioSystem.getAudioInputStream(inputStream);

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

