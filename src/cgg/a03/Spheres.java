package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-10
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.cgobjects.*;
import cgtools.*;

import java.util.ArrayList;

public class Spheres implements Sampler {
    private double width;
    private double height;
    private CameraObscura camera;
    private int recursionDepth = 5;
    private Group spheres;

    public Spheres(double width, double height, CameraObscura camera) {
        this.width = width;
        this.height = height;
        this.camera = camera;

        //spheres = new ArrayList<Sphere>();
        spheres = new Group();
        spheres.addShape(new Sphere(Vector.point(0,0,-15), 7, Color.yellow));
        spheres.addShape(new Sphere(Vector.point(-10,-5,-20), 5, Color.red));
        spheres.addShape(new Sphere(Vector.point(0.5,0.5,-2), 0.5, Color.green));
    }

    public Color getColor(double x, double y) {
        Ray ray = camera.generateRay(x, y);
        return calculateRadiance(spheres, ray, recursionDepth);
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
            Color color = Color.multiply(material.getAlbedo(), calculateRadiance(scene, secondaryRay, depth));
            return Color.add(material.getEmmission(), color);
        }
        // absorbed, just emmission
        return material.getEmmission();
    }

    /*
    OLD DEPRECATED METHODS FROM BEFORE A05
    public Color getColor(double x, double y) {
        Ray r = camera.generateRay(x, y);
        Hit nearestHit = null;
        for(Sphere sphere: spheres) {
            Hit hit = sphere.intersect(r);
            if(hit != null) {
                if((nearestHit == null) || (hit.getDistance() < nearestHit.getDistance())) {
                    nearestHit = hit;
                }
            }
        }
        if(nearestHit != null) {
            return shade(nearestHit.getUnit(), nearestHit.getMaterial().);
        }
        return Color.black;
    }

    public static Color shade(Direction normal, Color color) {
        Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5));
        Color ambient = Color.multiply(0.1, color);
        Color diffuse = Color.multiply(0.9 * Math.max(0, Vector.dotProduct(lightDir, normal)), color);
        return Color.add(ambient, diffuse);
    }
     */
}
