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
        return h.getColor();
    }
}
