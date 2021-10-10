package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-10
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Sphere {
    private Point center;
    private double radius;
    private Color color;

    /**
     * Constructor for Sphere class
     * @param center - [Point] center point of sphere
     * @param radius - [double] radius of sphere
     * @param color - [Color] color of the sphere's surface
     */
    public Sphere(Point center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Hit intersect(Ray r) {
        Point shiftedX0 = Vector.subtract(r.getX0(), Vector.direction(center.x, center.y, center.z));
        // a = d^2 | b = 2x0*d | c = x0^2 - r^2
        double a = Vector.dotProduct(r.getDirection(), r.getDirection());
        double b = 2 * Vector.dotProduct(shiftedX0, r.getDirection());
        double c = Vector.dotProduct(shiftedX0, shiftedX0) - (radius*radius);

        // calculate discriminant n to check if hitpoint exists
        double n = b*b - 4*a*c;

        // calculate actual hitpoint
        if(n >= 0) {
            double t = 0;
            double t1 = (-b + Math.sqrt((b*b) - (4*a*c))) / (2*a);
            double t2 = (-b - Math.sqrt((b*b) - (4*a*c))) / (2*a);

            // use smaller t to get first hit
            if(t1 < t2) {
                t = t1;
            }
            else {
                t = t2;
            }
            // if tmin <= t <= tmax return hitpoint
            if(r.isValid(t)) {
                Point x = Vector.add(r.getX0(), Vector.multiply(t, r.getDirection()));
                // normal vector = (x-center)/radius
                Direction normal = Vector.negate(Vector.divide(Vector.subtract(center, x), radius));
                return new Hit(t, x, normal, color);
            }
        }
        return null;
    }

    public Color getColor() {
        return color;
    }
}
