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
    public final Point p;
    public final Direction n;
    public final Material m;
    public final double u;
    public final double v;

    /**
     * Constructor for Hit class
     * @param t - [double] ray parameter
     * @param x - [Point] hitpoint
     * @param n - [Direction] unit (normal) vector
     * @param m - [Material] material of the hit surface
     */
    public Hit(double t, Point x, Direction n, Material m) {
        this.t = t;
        this.p = x;
        this.n = n;
        this.u = 0;
        this.v = 0;
        this.m = m;
    }

    public Hit(double t, Point x, Direction n, double u, double v, Material m) {
        this.t = t;
        this.p = x;
        this.n = n;
        this.u = u;
        this.v = v;
        this.m = m;
    }

    public double getDistance() {
        return t;
    }

    public Point getHitpoint() {
        return p;
    }

    public Direction getNormal() {
        return n;
    }

    public double getU() {
        return u;
    }

    public double getV() {
        return v;
    }

    public Material getMaterial() {
        return m;
    }
}
