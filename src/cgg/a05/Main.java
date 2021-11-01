package cgg.a05;

/**
 * @author Florian Kate
 * Date 2021-10-31
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

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // a05-diffuse-spheres.png Camera and Group
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Group group = new Group();
        group.addShape(new Background(Color.white));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 9, Color.lightgray));
        for(int i=0; i<200; i++) {
            double rndX = Random.randomMinMax(-2.5, 2.5);
            double rndZ = Random.randomMinMax(-3.0, -9.0);
            double rndSize = Random.randomMinMax(0.05, 0.5);
            double w = Random.random();
            Color color1 = Color.orange;
            Color color2 = Color.green;
            Color color = Color.add(color1, Color.multiply(w, Color.subtract(color2, color1)));
            group.addShape(new Sphere(Vector.point(rndX, -0.5+rndSize, rndZ), rndSize, color));
        }

        image.sample(new Raytracer(camera, group, 8), 32);

        // Write the images to disk
        final String filename = "doc/a05-diffuse-spheres.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
