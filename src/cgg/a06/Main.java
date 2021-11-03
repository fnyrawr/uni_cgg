package cgg.a06;

/**
 * @author Florian Kate
 * Date 2021-11-01
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {
        // debug: test glass helper methods
        // DebugOutputs.glassTests();

        final int width = 800;
        final int height = 600;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // a06-mirrors-glass-1.png Camera and Group
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group group = new Group();
        group.addShape(new Background(Color.white));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 4,
                new DiffuseMirroringMaterial(Color.lightgray, 0.25)));
        group.addShape(new Sphere(Vector.point(-2.0, 0.0, -2.0), 0.5, new DiffuseMaterial(Color.green)));
        group.addShape(new Sphere(Vector.point(1.0, 0.25, -1.75), 0.75, new GlassMaterial(Color.lightgray)));
        group.addShape(new Sphere(Vector.point(-0.5, -0.15, -1.25), 0.35, new GlassMaterial(Color.lightgray)));
        group.addShape(new Sphere(Vector.point(-1.0, -0.375, -1.5), 0.125, new DiffuseMaterial(Color.yellow)));
        group.addShape(new Sphere(Vector.point(-0.5, -0.45, -1.0), 0.05, new DiffuseMaterial(Color.orange)));
        group.addShape(new Sphere(Vector.point(-0.5, -0.375, -1.75), 0.125, new MirroringMaterial(Color.lightgray)));
        group.addShape(new Sphere(Vector.point(0.5, -0.25, -1), 0.25, new DiffuseMaterial(Color.lightblue)));

        image.sample(new Raytracer(camera, group, 16), 32);

        // Write the images to disk
        final String filename = "doc/test.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
