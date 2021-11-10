package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Plane implements Shape {
    public final Point point;
    public final Direction normal;
    public final double radius;
    public final Material material;
    protected BoundingBox boundingBox;

    /**
     * Constructor for Plane class
     * @param point - [Point] anchor point of plane
     * @param normal - [Direction] direction of normal vector
     * @param material - [Material] material of plane's surface
     */
    public Plane(Point point, Direction normal, double radius, Material material) {
        this.point = point;
        this.normal = normal;
        this.radius = radius;
        this.material = material;
        this.boundingBox = new BoundingBox(Vector.add(Vector.direction(-radius, -0.001, -radius), point),
                Vector.add(Vector.direction(radius, 0.001, radius), point));
    }

    public Hit intersect(Ray r) {
        /*
            case 1: ray hits plane inside radius
                ray.direction * plane.normal != 0 && Distance(Hit-point <= radius)
                -> HIT
            case 2: ray hits plane outside of radius
                ray.direction * plane.normal != 0 && Distance(Hit-point > radius)
                -> NO HIT
            case 3: ray hits direct from side
                ray.direction * plane.normal == 0
                -> NO HIT
         */

        // dn = ray.direction * normal
        double dn = Vector.dotProduct(r.getDirection(), normal);

        // get hit distance: t = t = ( (plane.point-ray.x0)*plane.normal ) / ( ray.direction*plane.normal )
        double t = Vector.dotProduct(Vector.subtract(point, r.getOrigin()), normal) / dn;

        // hitpoint with plane
        Point x = r.pointAt(t);

        // return null if any of the above stated cases occur
        if(dn == 0 || !r.contains(t) || Vector.length(Vector.subtract(x, point)) > radius) return null;

        return new Hit(t, x, normal, material);
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    public BoundingBox calculateBounds() {
        return bounds();
    }
}
