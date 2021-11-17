package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Raytracer implements Sampler {
    public final CameraObscura camera;
    public final Group group;
    public final int recursionDepth;

    public Raytracer(CameraObscura camera, Group group, int recursionDepth) {
        this.camera = camera;
        this.group = group;
        this.recursionDepth = recursionDepth;
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.generateRay(x, y);
        return calculateRadiance(group, ray, recursionDepth);
    }

    public Color calculateRadiance(Shape scene, Ray ray, int depth) {
        // check for maximum recursion depth
        if(depth == 0) return Color.black;
        // intersect ray with scene
        Hit hit = scene.intersect(ray);
        // query material at hit point
        Material material = hit.getMaterial();
        Ray secondaryRay = material.getSecondaryRay(ray, hit);
        if(secondaryRay != null) {
            // combine emmission and reflection
            Color color = Color.multiply(material.getAlbedo(), calculateRadiance(scene, secondaryRay, depth-1));
            return Color.add(material.getEmmission(), color);
        }
        // absorbed, just emmission
        return material.getEmmission();
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }
}
