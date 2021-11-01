package cgg.a01;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

// Represents the contents of an image. Provides the same color for all pixels.
public class Disc implements Sampler {
    private double width;
    private double height;
    private double centerX;
    private double centerY;
    private double size;
    private Color color;

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
        // if ((x-centerX)^2 + (y-centerY)^2) <= radius^2, point is on disc
        if((x-centerX)*(x-centerX) + (y-centerY)*(y-centerY) <= size/2 * size/2) {
            return color;
        }
        return Color.black;
    }

    public int getRecursionDepth() {
        return 0;
    }
}