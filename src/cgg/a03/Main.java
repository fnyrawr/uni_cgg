package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {
        final int width = 1920;
        final int height = 1080;

        // DebugOutputs.rayTesting();
        // DebugOutputs.hitpointsTesting();

        // Create a new camera and sample spheres
        Image image = new Image(width, height, 2.2);
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group group = new Group();

        group.addShape(new Background(Color.white));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 2,
                new DiffuseMirroringMaterial(Color.lightgray, 0.5)));
        group.addShape(new Sphere(Vector.point(0.0,0.0,-1.5), 0.5, new MirroringMaterial(Color.lightgray)));
        group.addShape(new Sphere(Vector.point(-0.5,-0.25,-0.75), 0.25, new DiffuseMirroringMaterial(Color.red, 0.005)));
        group.addShape(new Sphere(Vector.point(0.25,-0.375,-0.75), 0.125, new DiffuseMirroringMaterial(Color.blue, 0.25)));

        image.sample(new Raytracer(camera, group, 16), 64);

        // Write the images to disk
        final String filename = "doc/a03-three-spheres.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
