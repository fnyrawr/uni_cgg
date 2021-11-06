package cgg.a04;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {
        final int width = 800;
        final int height = 600;

        // Create an image, a new camera and a group for the image
        Image spheres = new Image(width, height, 2.2);
        Image totoro = new Image(width, height, 2.2);

        // a04-3-spheres.png Camera and Group
        CameraObscura camera1 = new CameraObscura(Math.PI/3, Vector.point(0,0,0), width, height);
        Group groupSpheres = new Group();
        groupSpheres.addShape(new Background(Color.gray));
        groupSpheres.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 5, new DiffuseMaterial(Color.lightblue)));
        groupSpheres.addShape(new Sphere(Vector.point(-1.0, -0.25, -2.5), 0.7, new DiffuseMaterial(Color.blue)));
        groupSpheres.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.5, new DiffuseMaterial(Color.yellow)));
        groupSpheres.addShape(new Sphere(Vector.point(1.0, -0.25, -2.5), 0.7, new DiffuseMaterial(Color.red)));

        // a04-scene.png
        CameraObscura camera2 = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group groupTotoro = new Group();
        groupTotoro.addShape(new Background(Color.white));
        groupTotoro.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 3,
                new DiffuseMaterial(Color.darkgreen)));

        // Totoro body
        groupTotoro.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.75, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.2, -2.3), 0.65, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.5, -2.1), 0.5, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, -0.25, -2.35), 0.65, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.2, -2.23), 0.6, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-0.15, 0.6, -1.6), 0.07, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(0.15, 0.6, -1.6), 0.07, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-0.12, 0.53, -1.4), 0.025, new DiffuseMaterial(Color.black)));
        groupTotoro.addShape(new Sphere(Vector.point(0.12, 0.53, -1.4), 0.025, new DiffuseMaterial(Color.black)));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.5, -1.4), 0.02, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(-0.01, 0.5, -1.4), 0.02, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(0.01, 0.5, -1.4), 0.02, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(-0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(-0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        groupTotoro.addShape(new Sphere(Vector.point(0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        // cloud
        groupTotoro.addShape(new Sphere(Vector.point(-1.75, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.65, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.55, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.45, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.35, 1.2, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.7, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.6, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.5, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.4, 1.15, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.7, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.6, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.5, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.4, 1.25, -2), 0.1, new DiffuseMaterial(Color.white)));
        // bushes
        groupTotoro.addShape(new Sphere(Vector.point(-1.25, -0.5, -3), 1, new DiffuseMaterial(Color.darkgreen)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        groupTotoro.addShape(new Sphere(Vector.point(-1.75, -1, -2), 1, new DiffuseMaterial(Color.darkgreen)));

        // sample spheres
        // spheres.sample(new Raytracer(camera1, groupSpheres, 16), 32);

        // Write the image to disk
        // final String filename1 = "doc/a04-3-spheres.png";
        // spheres.write(filename1);
        // System.out.println("Wrote image: " + filename1);

        // sample totoro
        totoro.sample(new Raytracer(camera2, groupTotoro, 32), 64);

        // Write the image to disk
        final String filename2 = "doc/a04-scene.png";
        totoro.write(filename2);
        System.out.println("Wrote image: " + filename2);
    }
}
