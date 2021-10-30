package cgg.cgobjects;

import cgtools.*;

public class Plane implements Shape {
    public final Point point;
    public final Direction normal;
    public final Color color;

    /**
     * Constructor for Plane class
     * @param point - [Point] anchor point of plane
     * @param normal - [Direction] direction of normal vector
     * @param color - [Color] color of the sphere's surface
     */
    public Plane(Point point, Direction normal, Color color) {
        this.point = point;
        this.normal = normal;
        this.color = color;
    }

    public Hit intersect(Ray r) {
        // double t = ( (plane.point-ray.x0)*plane.normal ) / ( ray.direction*plane.normal )
        double t = Vector.dotProduct(Vector.subtract(point, r.getX0()), normal) / Vector.dotProduct(r.getDirection(), normal);

        if(r.isValid(t)) {
            Point x = Vector.add(r.getX0(), Vector.multiply(t, r.getDirection()));
            return new Hit(t, x, normal, color);
        }
        return null;
    };
}
