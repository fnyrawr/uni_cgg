package cgg.cgobjects;

import cgtools.*;

/**
 * @author Florian Kate
 * Date 2021-10-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class Hit {
    public final double t;
    public final Point x;
    public final Direction n;
    public final Material m;

    /**
     * Constructor for Hit class
     * @param t - [double] ray parameter
     * @param x - [Point] hitpoint
     * @param n - [Direction] unit (normal) vector
     * @param m - [Material] material of the hit surface
     */
    public Hit(double t, Point x, Direction n, Material m) {
        this.t = t;
        this.x = x;
        this.n = n;
        this.m = m;
    }

    public double getDistance() {
        return t;
    }

    public Point getHitpoint() {
        return x;
    }

    public Direction getNormal() {
        return n;
    }

    public Material getMaterial() {
        return m;
    }
}
