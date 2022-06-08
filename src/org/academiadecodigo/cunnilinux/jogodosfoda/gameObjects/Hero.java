package org.academiadecodigo.cunnilinux.jogodosfoda.gameObjects;

import org.academiadecodigo.cunnilinux.jogodosfoda.AssetPaths;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hero {

    private Picture pictureHeroLeft;
    private Picture pictureHeroRight;
    private boolean dead;

    public Hero(double x, double y) {

        pictureHeroLeft = Picture(x, y, AssetPaths.HERO_LEFT);
        pictureHeroRight = Picture(x, y, AssetPaths.HERO_RIGHT);

    }

}
