package cgg.cgobjects;

import cgtools.*;

public class Background implements Shape {
    public final Color color;

    public Background(Color color) {
        this.color = color;
    }

    public Hit intersect(Ray r) {
        if(r.isValid(Double.POSITIVE_INFINITY)) {
            Point x = Vector.point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            Direction normal = Vector.negate(r.getDirection());
            return new Hit(Double.POSITIVE_INFINITY, x, normal, color);
        }
        return null;
    };
}
