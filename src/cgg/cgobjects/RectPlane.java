package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2022-01-28
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class RectPlane implements Shape {
    public final Point point;
    public final Direction normal;
    public final double width;
    public final double depth;
    public final Material material;
    protected BoundingBox boundingBox;

    /**
     * Constructor for RectPlane class
     * @param point - [Point] anchor point of plane
     * @param normal - [Direction] direction of normal vector
     * @param material - [Material] material of plane's surface
     */
    public RectPlane(Point point, Direction normal, double width, double depth, Material material) {
        this.point = point;
        this.normal = Vector.normalize(normal);
        this.width = width;
        this.depth = depth;
        this.material = material;
        this.boundingBox = new BoundingBox(Vector.add(Vector.direction(-width/2.0, -0.001, -depth/2.0), point),
                Vector.add(Vector.direction(width/2.0, 0.001, depth/2), point));
    }

    public Hit intersect(Ray ray) {
        Point origin = ray.getOrigin();
        Direction dir = ray.getDirection();
        Point p0 = Vector.add(Vector.direction(-width/2.0, -0.001, -depth/2.0), point);
        Point p1 = Vector.add(Vector.direction(width/2.0, 0.001, depth/2.0), point);
        double x0 = p0.x;
        double y0 = p0.y;
        double z0 = p0.z;
        double x1 = p1.x;
        double y1 = p1.y;
        double z1 = p1.z;
        double dn = Vector.dotProduct(ray.getDirection(), normal);
        double t = Vector.dotProduct(Vector.subtract(point, ray.getOrigin()), normal) / dn;
        if (!ray.contains(t)) {
            return null;
        }
        double x = origin.x + t * dir.x;
        double z = origin.z + t * dir.z;
        if(x < x0 || x > x1 || z < z0 || z > z1) {
            return null;
        }
        Point px = ray.pointAt(t);
        double u = (z - z0) / (z1 - z0);
        double v = (x - x0) / (x1 - x0);

        return new Hit(t, px, normal, u, v, material);
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    public BoundingBox calculateBounds() {
        return bounds();
    }
}
