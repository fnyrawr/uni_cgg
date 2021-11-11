package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class CylinderCoat implements Shape {
    protected final Point center;
    protected final double radius;
    protected final double height;
    protected final Material material;
    protected BoundingBox boundingBox;

    public CylinderCoat(Point center, double radius, double height, Material material) {
        this.center = center;
        this.radius = radius;
        this.height = height;
        this.material = material;
        this.boundingBox = new BoundingBox(Vector.add(Vector.direction(-radius, 0.0, -radius), center),
                Vector.add(Vector.direction(radius, 0.0, radius), Vector.add(Vector.direction(0.0, height, 0.0), center)));
    }

    public Hit intersect(Ray ray) {
        // https://mrl.cs.nyu.edu/~dzorin/rend05/lecture2.pdf
        Point shiftedOrigin = Vector.subtract(ray.getOrigin(), Vector.direction(center.x, center.y, center.z));
        // ignore y axis
        Direction d = Vector.direction(ray.getDirection().x, 0.0, ray.getDirection().z);
        // a = d^2 | b = 2x0*d | c = x0^2 - r^2
        double a = Vector.dotProductWithoutY(d, d);
        double b = 2 * Vector.dotProductWithoutY(shiftedOrigin, d);
        double c = Vector.dotProductWithoutY(shiftedOrigin, shiftedOrigin) - (radius*radius);

        double t0 = (-b + Math.sqrt((b*b) - (4*a*c))) / (2*a);
        double t1 = (-b - Math.sqrt((b*b) - (4*a*c))) / (2*a);

        if(!isTNotObstructed(ray, t1) && !(b*b < 4*a*c)) {
            Point x = ray.pointAt(t1);
            return new Hit(t1, x, Vector.divide(Vector.subtract(x, center), radius), material);
        }
        if(!isTNotObstructed(ray, t0) && !(b*b < 4*a*c)) {
            Point x = ray.pointAt(t0);
            return new Hit(t0, x, Vector.divide(Vector.subtract(x, center), radius), material);
        }
        return null;
    }

    protected boolean isTNotObstructed(Ray ray, double t) {
        return !ray.contains(t) || !inYbounds(ray.pointAt(t));
    }

    protected boolean inYbounds(Point p) {
        return (center.y - height/2 <= p.y) && (p.y <= center.y + height/2);
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    public BoundingBox calculateBounds() {
        return bounds();
    }
}