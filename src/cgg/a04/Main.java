package cgg.a04;

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
        groupSpheres.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), Color.lightblue));
        groupSpheres.addShape(new Sphere(Vector.point(-1.0, -0.25, -2.5), 0.7, Color.blue));
        groupSpheres.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.5, Color.yellow));
        groupSpheres.addShape(new Sphere(Vector.point(1.0, -0.25, -2.5), 0.7, Color.red));

        // a04-scene.png
        CameraObscura camera2 = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group groupTotoro = new Group();
        groupTotoro.addShape(new Background(Color.lightblue));
        groupTotoro.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), Color.darkgreen));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.75, Color.gray));
        // Totoro body
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.2, -2.3), 0.65, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.5, -2.1), 0.5, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, -0.25, -2.35), 0.65, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.2, -2.23), 0.6, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-0.15, 0.6, -1.6), 0.07, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(0.15, 0.6, -1.6), 0.07, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-0.12, 0.53, -1.4), 0.025, Color.black));
        groupTotoro.addShape(new Sphere(Vector.point(0.12, 0.53, -1.4), 0.025, Color.black));
        groupTotoro.addShape(new Sphere(Vector.point(0.0, 0.5, -1.4), 0.02, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(-0.01, 0.5, -1.4), 0.02, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(0.01, 0.5, -1.4), 0.02, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(-0.2, 0.85, -1.8), 0.1, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(0.2, 0.85, -1.8), 0.1, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(-0.22, 0.9, -1.77), 0.1, Color.gray));
        groupTotoro.addShape(new Sphere(Vector.point(0.22, 0.9, -1.77), 0.1, Color.gray));
        // cloud
        groupTotoro.addShape(new Sphere(Vector.point(-1.75, 1.2, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.65, 1.2, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.55, 1.2, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.45, 1.2, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.35, 1.2, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.7, 1.15, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.6, 1.15, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.5, 1.15, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.4, 1.15, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.7, 1.25, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.6, 1.25, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.5, 1.25, -2), 0.1, Color.white));
        groupTotoro.addShape(new Sphere(Vector.point(-1.4, 1.25, -2), 0.1, Color.white));
        // bushes
        groupTotoro.addShape(new Sphere(Vector.point(-1.25, -0.5, -3), 1, Color.darkgreen));
        groupTotoro.addShape(new Sphere(Vector.point(-1.5, -0.75, -2.5), 1, Color.darkgreen));
        groupTotoro.addShape(new Sphere(Vector.point(-1.75, -1, -2), 1, Color.darkgreen));
        groupTotoro.addShape(new Sphere(Vector.point(1.5, -0.75, -2.5), 1, Color.darkgreen));
        groupTotoro.addShape(new Sphere(Vector.point(1.75, -1, -2), 1, Color.darkgreen));

        spheres.sample(new Raytracer(camera1, groupSpheres), 32);
        totoro.sample(new Raytracer(camera2, groupTotoro), 32);

        // Write the images to disk
        final String filename1 = "doc/a04-3-spheres.png";
        final String filename2 = "doc/a04-scene.png";
        spheres.write(filename1);
        totoro.write(filename2);
        System.out.println("Wrote image: " + filename1);
        System.out.println("Wrote image: " + filename2);
    }
}
