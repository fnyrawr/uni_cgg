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
import static cgtools.Vector.point;

public class Main {
    public static void main(String[] args) {
        // debug: test glass helper methods
        // DebugOutputs.glassTests();

        final int width = 800;
        final int height = 600;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // preparation for translation and rotation
        // Matrix r = Matrix.rotation(Vector.direction(1, 0, 0), -25);
        // Matrix t = Matrix.translation(Vector.direction(0,1,1));
        // CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.multiply(t, r), width, height);
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(Color.white));
        Group planes = new Group();
        planes.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 3,
                new DiffuseMaterial(Color.yellow)));
        planes.addShape(new Plane(Vector.point(0.0, -0.3, 0.0), Vector.direction(0,1,0), 3,
                new WaterMaterial(Color.lightblue, 0.5)));
        group.addShape(planes);

        // moon
        group.addShape(new Sphere(Vector.point(-5.0, 5.0, -20.0), 7.0, new EmmittingMaterial(Color.lightgray)));

        group.addShape(new Plane(Vector.point(0.0, 0.0, -2.0), Vector.direction(0,0,-1), 15,
                new MistMaterial(Color.white, 0.05)));
        group.addShape(new Plane(Vector.point(0.0, 0.0, -2.1), Vector.direction(0,0,-1), 15,
                new MistMaterial(Color.white, 0.075)));
        group.addShape(new Plane(Vector.point(0.0, 0.0, -2.2), Vector.direction(0,0,-1), 15,
                new MistMaterial(Color.white, 0.1)));

        // Totoro body
        Group totoro = new Group();
        totoro.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.75, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(0.0, 0.2, -2.3), 0.65, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(0.0, 0.5, -2.1), 0.5, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(0.0, -0.25, -2.35), 0.65, new DiffuseMaterial(Color.white)));
        totoro.addShape(new Sphere(Vector.point(0.0, 0.2, -2.23), 0.6, new DiffuseMaterial(Color.white)));
        totoro.addShape(new Sphere(Vector.point(-0.15, 0.55, -1.65), 0.07, new DiffuseMaterial(Color.white)));
        totoro.addShape(new Sphere(Vector.point(0.15, 0.55, -1.65), 0.07, new DiffuseMaterial(Color.white)));
        totoro.addShape(new Sphere(Vector.point(-0.14, 0.54, -1.6), 0.025, new EmmittingMaterial(Color.red)));
        totoro.addShape(new Sphere(Vector.point(0.14, 0.54, -1.6), 0.025, new EmmittingMaterial(Color.red)));
        totoro.addShape(new Sphere(Vector.point(0.0, 0.5, -1.6), 0.02, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(-0.01, 0.5, -1.6), 0.02, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(0.01, 0.5, -1.6), 0.02, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(-0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(-0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        totoro.addShape(new Sphere(Vector.point(0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        group.addShape(totoro);

        // cloud
        Group cloud = new Group();
        cloud.addShape(new Sphere(Vector.point(-1.75, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.65, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.55, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.45, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.35, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.7, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.6, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.5, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.4, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.7, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.6, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.5, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.4, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(cloud);

        // bushes
        group.addShape(new Sphere(Vector.point(-1.25, -0.5, -3), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(-1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(-1.75, -1, -2), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(new Sphere(Vector.point(1.75, -1, -2), 1, new DiffuseMaterial(Color.darkgreen)));

        // fireflies
        Group fireflies = new Group();
        for(int i = 0; i < 75; i++) {
            fireflies.addShape(new Sphere(Vector.point(Random.randomMinMax(-0.25, 0.25), Random.randomMinMax(-0.29, -0.21), Random.randomMinMax(-0.6, -1.4)),
                    0.0005, new EmmittingMaterial(Color.yellowgreen)));
        }
        group.addShape(fireflies);

        image.sample(new Raytracer(camera, group, 32), 64);

        // Write the images to disk
        final String filename = "doc/a06-mirrors-glass-2.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
