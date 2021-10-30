package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-10
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.cgobjects.CameraObscura;
import cgg.cgobjects.Hit;
import cgg.cgobjects.Ray;
import cgg.cgobjects.Sphere;
import cgtools.*;

import java.util.ArrayList;

public class Spheres implements Sampler {
    private double width;
    private double height;
    private CameraObscura camera;

    protected ArrayList<Sphere> spheres;

    public Spheres(double width, double height, CameraObscura camera) {
        this.width = width;
        this.height = height;
        this.camera = camera;

        spheres = new ArrayList<Sphere>();
        spheres.add(new Sphere(Vector.point(0,0,-15), 7, Color.yellow));
        spheres.add(new Sphere(Vector.point(-10,-5,-20), 5, Color.red));
        spheres.add(new Sphere(Vector.point(0.5,0.5,-2), 0.5, Color.green));
    }

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
            return shade(nearestHit.getUnit(), nearestHit.getColor());
        }
        return Color.black;
    }

    public static Color shade(Direction normal, Color color) {
        Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5));
        Color ambient = Color.multiply(0.1, color);
        Color diffuse = Color.multiply(0.9 * Math.max(0, Vector.dotProduct(lightDir, normal)), color);
        return Color.add(ambient, diffuse);
    }
}
