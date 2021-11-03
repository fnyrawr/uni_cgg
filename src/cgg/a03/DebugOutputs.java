package cgg.a03;

import cgg.cgobjects.*;
import cgtools.*;

public class DebugOutputs {

    public DebugOutputs() {}

    public static void rayTesting() {
        // RAY TESTING (succeeded)
        CameraObscura camera = new CameraObscura(Math.PI / 2, Vector.point(0, 0, 0), 10, 10);
        Ray ray_00 = camera.generateRay(0, 0);
        Ray ray_55 = camera.generateRay(5, 5);
        Ray ray_1010 = camera.generateRay(10, 10);

        System.out.println("\nDEBUG: ray generation results");
        System.out.println("d(R(0,0)) = " + ray_00.getDirection().toString());
        System.out.println("d(R(5,5)) = " + ray_55.getDirection().toString());
        System.out.println("d(R(10,10)) = " + ray_1010.getDirection().toString());
    }

    public static void hitpointsTesting() {
        // SPHERE HITPOINTS TESTING (succeeded)
        Sphere s1 = new Sphere(Vector.point(0, 0, -2), 1, new DiffuseMaterial(Color.red));
        Sphere s2 = new Sphere(Vector.point(0, -1, -2), 1, new DiffuseMaterial(Color.yellow));
        Sphere s3 = new Sphere(Vector.point(0, 0, -4), 1, new DiffuseMaterial(Color.blue));

        Ray r1 = new Ray(Vector.point(0, 0, 0), Vector.direction(0, 0, -1), 0, 50);
        Ray r2 = new Ray(Vector.point(0, 0, 0), Vector.direction(0, 1, -1), 0, 50);
        Ray r3 = new Ray(Vector.point(0, 0, -4), Vector.direction(0, 0, -1), 0, 50);
        Ray r4 = new Ray(Vector.point(0, 0, 0), Vector.direction(0, 0, -1), 0, 2);

        System.out.println("\nDEBUG: sphere hitpoints");
        Hit hp1 = s1.intersect(r1);
        System.out.println("Hitpoint of sphere 1: " + hp1.getHitpoint().toString());
        System.out.println("Normal vector: " + hp1.getNormal().toString());
        if (s1.intersect(r2) == null) {
            System.out.println("no hitpoint for sphere 2");
        }
        Hit hp2 = s2.intersect(r1);
        System.out.println("Hitpoint of sphere 2: " + hp2.getHitpoint().toString());
        System.out.println("Normal vector: " + hp2.getNormal().toString());
        if (s1.intersect(r3) == null) {
            System.out.println("no hitpoint for sphere 4");
        }
        if (s3.intersect(r4) == null) {
            System.out.println("no hitpoint for sphere 5");
        }
    }
}
