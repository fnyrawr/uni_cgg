package cgg.a01;

import cgtools.*;

// Represents the contents of an image. Provides the same color for all pixels.
public class Disc implements Sampler {
    double width;
    double height;
    double centerX;
    double centerY;
    double size;
    Color color;

    public Disc(double width, double height, double size, Color color) {
        this.width = width;
        this.height = height;
        this.size = size;
        this.color = color;
        this.centerX = width/2;
        this.centerY = height/2;
    }

    // Returns the color for the given position.
    public Color getColor(double x, double y) {
        // check, if point is on disc
        boolean onDisc = false;
        // if ((x-centerX)^2 + (y-centerY)^2) <= radius^2, point is on disc
        if((x-centerX)*(x-centerX) + (y-centerY)*(y-centerY) <= size/2 * size/2)
            return color;
        else
            return Color.black;
    }
}