package org.academiadecodigo.cunnilinux.hackermen.utils;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/* public class GameMusic {
    private Clip clip;

    GameMusic() {
    }

    void stopMusic() {
        this.clip.stop();
    }

    void play(String var1) {
        AudioInputStream var3 = null;

        try {
            URL var2 = Game.class.getResource(var1);
            var3 = AudioSystem.getAudioInputStream(var2);
        } catch (UnsupportedAudioFileException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        try {
            this.clip = AudioSystem.getClip();
            this.clip.open(var3);
            this.clip.start();
            this.clip.loop(-1);
        } catch (LineUnavailableException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}*/
