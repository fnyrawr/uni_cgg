package cgg.a01;

import cgtools.*;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class Polkadots implements Sampler {
    private double width;
    private double height;
    private int countX;
    private int countY;
    private double size;
    private double stepX;
    private double stepY;
    private double centerX;
    private double centerY;
    private Color color1;
    private Color color2;

    public Polkadots(double width, double height, int countX, int countY, double size, Color color1, Color color2) {
        this.width = width;
        this.height = height;
        this.countX = countX;
        this.countY = countY;
        this.size = size;
        this.color1 = color1;
        this.color2 = color2;
        stepX = width/countX;
        stepY = height/countY;
        centerX = stepX/2;
        centerY = stepY/2;
    }

    // Returns the color for the given position.
    public Color getColor(double x, double y) {
        // get relative position on pattern
        double px = x % stepX;
        double py = y % stepY;

        // color = col1 + w*(col2-col1) | w = (x/width)
        double w = (x/width);
        Color color = Color.add(color1, Color.multiply(w, Color.subtract(color2, color1)));

        // if ((x-centerX)^2 + (y-centerY)^2) <= radius^2, point is on disc
        if((px-centerX)*(px-centerX) + (py-centerY)*(py-centerY) <= size/2 * size/2)
            return color;
        else
            return Color.black;
    }

    public int getRecursionDepth() {
        return 0;
    }
}
