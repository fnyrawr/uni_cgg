package cgg.a09;

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

import java.util.ArrayList;

import static cgtools.Vector.color;

public class Main {
    public static void main(String[] args) {

        final int width = 800;
        final int height = 400;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,-0.35,0), Matrix.identity(), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(Color.lightgray));
        Group planes = new Group();
        planes.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 2,
                new MirroringMaterial(Color.lightgray)));
        group.addShape(planes);

        // cat statues
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                group.addShape(createCat(Vector.point(-0.5+0.25*i, -0.5, -0.5-0.25*j)));
            }
        }

        group.calculateBounds();
        // sample 12 times for Ryzen 5 3600 6 core Processor with 12 threads to get benchmarking results
        for(int i=1; i<=12; i++){
            image.sample(new Raytracer(camera, group, 32), 32, i);
        }

        // Write the images to disk
        final String filename = "doc/a09-benchmark-scene.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }

    public static Group createCat(Point point) {
        Group cat = new Group();
        // body
        cat.addShape(new Sphere(Vector.point(point.x, point.y+0.037, point.z), 0.075, new DiffuseMaterial(Color.lightgray)));
        cat.addShape(new Sphere(Vector.point(point.x, point.y+0.1, point.z), 0.06, new DiffuseMaterial(Color.lightgray)));
        // eyes
        cat.addShape(new Sphere(Vector.point(point.x-0.018, point.y+0.13, point.z+0.045), 0.0075, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x-0.018, point.y+0.1305, point.z+0.0495), 0.0035, new DiffuseMaterial(Color.lightgray)));
        cat.addShape(new Sphere(Vector.point(point.x+0.018, point.y+0.13, point.z+0.045), 0.0075, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x+0.018, point.y+0.1305, point.z+0.0495), 0.0035, new DiffuseMaterial(Color.lightgray)));
        // nose
        cat.addShape(new Sphere(Vector.point(point.x, point.y+0.12, point.z+0.05), 0.0075, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x-0.0045, point.y+0.117, point.z+0.053), 0.005, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x+0.0045, point.y+0.117, point.z+0.053), 0.005, new DiffuseMaterial(Color.black)));
        // ears
        cat.addShape(new Sphere(Vector.point(point.x-0.0325, point.y+0.1425, point.z+0.01), 0.015, new DiffuseMaterial(Color.lightgray)));
        cat.addShape(new Sphere(Vector.point(point.x-0.0325, point.y+0.143, point.z+0.0116), 0.0135, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x+0.0325, point.y+0.1425, point.z+0.01), 0.015, new DiffuseMaterial(Color.lightgray)));
        cat.addShape(new Sphere(Vector.point(point.x+0.0325, point.y+0.143, point.z+0.0116), 0.0135, new DiffuseMaterial(Color.black)));
        return cat;
    }
}
