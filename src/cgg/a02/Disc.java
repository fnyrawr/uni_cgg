package cgg.a02;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.Color;

// Represents the contents of an image. Provides the same color for all pixels.
public class Disc {
    private double centerX;
    private double centerY;
    private double radius;
    private Color color;

    public Disc(double centerX, double centerY, double radius, Color color) {
        this.radius = radius;
        this.color = color;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    // Returns, if point is in disc or not
    public boolean isPointInDisc(double x, double y) {
        // if ((x-centerX)^2 + (y-centerY)^2) <= radius^2, point is on disc
        if((x-centerX)*(x-centerX) + (y-centerY)*(y-centerY) <= radius * radius)
            return true;
        return false;
    }

    // Get color of disc
    public Color getColor() {
        return color;
    }

    // Get radius for comparison
    public double getRadius() {
        return radius;
    }
}