package cgg.cgobjects;

import cgtools.Direction;
import cgtools.Point;
import cgtools.Vector;

/**
 * @author Florian Kate
 * Date 2021-10-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class Ray {
    // origin: x0 | direction: d | ray path: tmin tmax
    private Point x0;
    private Direction d;
    private double tmin;
    private double tmax;

    /**
     * Constructor for Ray class
     * @param x0 - [Point] origin of ray
     * @param d - [Direction] direction of ray
     * @param tmin - [double] start of ray
     * @param tmax - [double] end of ray
     */
    public Ray(Point x0, Direction d, double tmin, double tmax) {
        this.x0 = x0;
        this.d = Vector.normalize(d);
        this.tmin = tmin;
        this.tmax = tmax;
    }

    public Point pointAt(double t) {
        // x(t) = x0 + t*d
        return Vector.add(x0, Vector.multiply(t, d));
    }

    public boolean isValid(double t) {
        // return true if tmin <= t <= tmax
        if((t >= tmin) && (t <= tmax)) {
            return true;
        }
        return false;
    }

    public Point getX0() {
        return x0;
    }

    public Direction getDirection() {
        return d;
    }
}
