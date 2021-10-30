package cgg.a04;

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {
        final int width = 800;
        final int height = 600;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);
        CameraObscura camera = new CameraObscura(Math.PI/3, Vector.point(0,0,0), width, height);
        Group group = new Group();
        group.addShape(new Background(Color.gray));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), Color.yellow));
        group.addShape(new Sphere(Vector.point(-1.0, -0.25, -2.5), 0.7, Color.red));
        group.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.5, Color.green));
        group.addShape(new Sphere(Vector.point(1.0, -0.25, -2.5), 0.7, Color.blue));

        image.sample(new Raytracer(camera, group), 32);

        // Write the images to disk
        final String filename = "doc/a04-3-spheres.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
