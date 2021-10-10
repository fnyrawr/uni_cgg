package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Hit {
    private double t;
    private Point x;
    private Direction n;
    private Color c;

    /**
     * Constructor for Hit class
     * @param t - [double] ray parameter
     * @param x - [Point] hitpoint
     * @param n - [Direction] unit (normal) vector
     * @param c - [Color] color of the hit surface
     */
    public Hit(double t, Point x, Direction n, Color c) {
        this.t = t;
        this.x = x;
        this.n = n;
        this.c = c;
    }
}
