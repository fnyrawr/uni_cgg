package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Background implements Shape {
    public final Color color;
    public final Material material;
    protected BoundingBox boundingBox;

    public Background(Color color) {
        this.color = color;
        this.material = new EmmittingMaterial(color);
        this.boundingBox = BoundingBox.everything;
    }

    public Hit intersect(Ray r) {
        Point x = Vector.point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Direction normal = Vector.negate(r.getDirection());
        return new Hit(Double.POSITIVE_INFINITY, x, normal, material);
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    public BoundingBox calculateBounds() {
        return bounds();
    }
}
