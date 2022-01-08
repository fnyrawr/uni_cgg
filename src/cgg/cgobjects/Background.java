package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Background implements Shape {
    public final Sampler background;
    public final Material material;
    protected BoundingBox boundingBox;

    public Background(Color color) {
        this.background = new ConstantColor(color);
        this.material = new EmmittingMaterial(background);
        this.boundingBox = BoundingBox.everything;
    }

    public Background(Sampler texture) {
        this.background = texture;
        this.material = new EmmittingMaterial(background);
        this.boundingBox = BoundingBox.everything;
    }

    public Hit intersect(Ray ray) {
        Point x = Vector.point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Direction normal = Vector.negate(ray.getDirection());
        double inclination = Math.acos(ray.getDirection().y);
        double azimuth = Math.PI + Math.atan2(ray.getDirection().x, ray.getDirection().z);
        double u = azimuth / (2*Math.PI);
        double v = inclination / Math.PI;
        return new Hit(Double.POSITIVE_INFINITY, x, normal, u, v, material);
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    public BoundingBox calculateBounds() {
        return bounds();
    }
}
