package cgg.cgobjects;

import cgtools.*;

public class Raytracer implements Sampler{
    public final CameraObscura camera;
    public final Group group;

    public Raytracer(CameraObscura camera, Group group) {
        this.camera = camera;
        this.group = group;
    }

    public Color getColor(double x, double y) {
        Ray r = camera.generateRay(x, y);
        Hit h = group.intersect(r);
        if(h == null) {
            return Color.black;
        }
        return shade(h.getUnit(), h.getColor());
    }

    public static Color shade(Direction normal, Color color) {
        Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5));
        Color ambient = Color.multiply(0.1, color);
        Color diffuse = Color.multiply(0.9 * Math.max(0, Vector.dotProduct(lightDir, normal)), color);
        return Color.add(ambient, diffuse);
    }
}
