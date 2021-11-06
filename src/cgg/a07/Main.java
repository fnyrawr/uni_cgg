package cgg.a07;

/**
 * @author Florian Kate
 * Date 2021-11-05
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

import static cgtools.Vector.color;

public class Main {
    public static void main(String[] args) {
        // debug: test glass helper methods
        // DebugOutputs.glassTests();

        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // a06-mirrors-glass-1.png Camera and Group
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group group = new Group();
        group.addShape(new Background(color(0.9882, 0.7215, 0.4863)));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 3,
                new DiffuseMaterial(Color.yellow)));
        group.addShape(new Plane(Vector.point(0.0, -0.3, 0.0), Vector.direction(0,1,0), 3,
                new WaterMaterial(Color.lightblue, 0.5)));
        group.addShape(new Plane(Vector.point(0.0, 0.0, -2.0), Vector.direction(0,0,-1), 15,
                new MistMaterial(Color.white, 0.1)));
        group.addShape(new Plane(Vector.point(0.0, 0.0, -2.1), Vector.direction(0,0,-1), 15,
                new MistMaterial(Color.white, 0.2)));
        group.addShape(new Plane(Vector.point(0.0, 0.0, -2.2), Vector.direction(0,0,-1), 15,
                new MistMaterial(Color.white, 0.25)));
        group.addShape(new Sphere(Vector.point(-5.0, 5.0, -20.0), 7.0, new EmmittingMaterial(Color.orange)));

        // Totoro body
        group.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.75, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(0.0, 0.2, -2.3), 0.65, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(0.0, 0.5, -2.1), 0.5, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(0.0, -0.25, -2.35), 0.65, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(0.0, 0.2, -2.23), 0.6, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-0.15, 0.6, -1.6), 0.07, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(0.15, 0.6, -1.6), 0.07, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-0.12, 0.53, -1.4), 0.025, new DiffuseMaterial(Color.black)));
        group.addShape(new Sphere(Vector.point(0.12, 0.53, -1.4), 0.025, new DiffuseMaterial(Color.black)));
        group.addShape(new Sphere(Vector.point(0.0, 0.5, -1.4), 0.02, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(-0.01, 0.5, -1.4), 0.02, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(0.01, 0.5, -1.4), 0.02, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(-0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(-0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        group.addShape(new Sphere(Vector.point(0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        // cloud
        group.addShape(new Sphere(Vector.point(-1.75, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.65, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.55, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.45, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.35, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.7, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.6, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.5, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.4, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.7, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.6, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.5, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(new Sphere(Vector.point(-1.4, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        // bushes
        group.addShape(new Sphere(Vector.point(-1.25, -0.5, -3), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(-1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(-1.75, -1, -2), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(1.75, -1, -2), 1, new DiffuseMaterial(Color.darkgreen)));

        image.sample(new Raytracer(camera, group, 16), 64);

        // Write the images to disk
        final String filename = "doc/a07-1.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
