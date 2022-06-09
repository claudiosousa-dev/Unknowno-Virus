package org.academiadecodigo.cunnilinux.hackermen.utils;

/**
 * Utility class to generating random numbers
 */
public class RandomGenerator {

    /**
     * Generate a random number between 0 and max (inclusive)
     */
    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    /**
     * Generate a random number between min and max (inclusive)
     */
    public static int getRandom(int min, int max) {

        // Between 0 and max :
        //return (int) (Math.random() * (max + 1));

        // Between 0+min and (max-min+min)
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static double getNormalProbability() {
        return Math.random();
    }
}
