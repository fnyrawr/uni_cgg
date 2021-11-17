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

public class a05Main_old {
    public static void main(String[] args) {
        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // a05-diffuse-spheres.png_old Camera and Group
        CameraObscura camera = new CameraObscura(Math.PI/1.5, Vector.point(0,0,0), width, height);
        Group group = new Group();
        group.addShape(new Background(Color.white));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 9,
                new DiffuseMaterial(Color.lightgray)));
        for(int i=0; i<100; i++) {
            double rndSize = Random.randomMinMax(0.5, 1.0);
            double rndDist = Random.randomMinMax(9, 18);
            double rndPhi = Random.randomMinMax(0, camera.phi);
            double posX = rndDist*Math.sin(rndPhi);
            double posZ = -rndDist*Math.cos(rndPhi);
            Color color1 = Color.orange;
            Color color2 = Color.green;
            double w = Random.random();
            Color color = Color.add(color1, Color.multiply(w, Color.subtract(color2, color1)));
            group.addShape(new Sphere(Vector.point(posX, -0.5+rndSize, posZ), rndSize, new DiffuseMaterial(color)));
        }

        image.sample(new Raytracer(camera, group, 16), 64);

        // Write the images to disk
        final String filename = "doc/a05-diffuse-spheres.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}