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
    public final Point origin;
    public final Direction direction;
    public final double tmin;
    public final double tmax;

    /**
     * Constructor for Ray class
     * @param origin - [Point] origin of ray
     * @param direction - [Direction] direction of ray
     * @param tmin - [double] start of ray
     * @param tmax - [double] end of ray
     */
    public Ray(Point origin, Direction direction, double tmin, double tmax) {
        this.origin = origin;
        this.direction = Vector.normalize(direction);
        this.tmin = tmin;
        this.tmax = tmax;
    }

    public Point pointAt(double t) {
        // x(t) = x0 + t*d
        return Vector.add(origin, Vector.multiply(t, direction));
    }

    public boolean contains(double t) {
        // return true if tmin <= t <= tmax
        if((t >= tmin) && (t <= tmax)) {
            return true;
        }
        return false;
    }

    public Point getOrigin() {
        return origin;
    }

    public Direction getDirection() {
        return direction;
    }
}
