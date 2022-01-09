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
    public final World world;
    public final int recursionDepth;

    public Raytracer(CameraObscura camera, Group group, int recursionDepth) {
        this.camera = camera;
        this.group = group;
        this.recursionDepth = recursionDepth;
        this.world = new World(null, group);
        group.calculateBounds();    // calculate bounding boxes bounds as raytracer gets created
    }

    public Raytracer(CameraObscura camera, World world, int recursionDepth) {
        this.camera = camera;
        this.world = world;
        this.group = world.scene;
        this.recursionDepth = recursionDepth;
        group.calculateBounds();    // calculate bounding boxes bounds as raytracer gets created
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
            // get light radiance if lights exist in the world
            Color lightIntensity = null;
            if(world.lights != null) {
                // local variable for light, light intensity should include all world lights
                lightIntensity = Color.black;
                for(Light light: world.lights) {
                    Color sourceIntensity = light.incomingIntensity(hit.getHitpoint(), hit.getNormal(), scene);
                    sourceIntensity = Color.multiply(sourceIntensity, material.getAlbedo(hit));
                    lightIntensity = Color.add(lightIntensity, sourceIntensity);
                }
            }
            // combine emmission and reflection
            Color color = Color.multiply(material.getAlbedo(hit), calculateRadiance(scene, secondaryRay, depth-1));
            color = Color.add(material.getEmmission(hit), color);
            if(lightIntensity != null)
                color = Color.add(color, lightIntensity);
            return color;
        }
        // absorbed, just emmission
        return material.getEmmission(hit);
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }
}
