package cgg.a11;

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.Color;
import cgtools.Matrix;
import cgtools.Vector;

public class Main {
    public static void main(String[] args) {

        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.identity(), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(Color.black));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 5,
                new DiffuseMaterial(Color.lightgray)));
        group.addShape(new Sphere(Vector.point(0,0,-2), 0.5, new DiffuseMaterial(Color.red)));
        group.addShape(new Sphere(Vector.point(-1,0,-3.5), 0.5, new DiffuseMaterial(Color.lightblue)));
        group.addShape(new Sphere(Vector.point(1,0,-3.5), 0.5, new DiffuseMaterial(Color.yellow)));

        // create world with scene and lights
        World world = new World(group);
        // world.addLight(new PointLight(Vector.point(-1.0, 1.0, -1.0), Color.lightblue, 1.0));
        // world.addLight(new PointLight(Vector.point(1.0, 1.0, -1.0), Color.yellow, 1.0));
        // world.addLight(new PointLight(Vector.point(-1.0, 1.0, -3.0), Color.green, 1.0));
        // world.addLight(new PointLight(Vector.point(1.0, 1.0, -3.0), Color.red, 1.0));
        world.addLight(new DirectionLight(Vector.direction(-2,-1,-2), Color.darkgray, 0.25));
        image.sample(new Raytracer(camera, world, 32), 4);

        // Write the images to disk
        final String filename = "doc/a11-2.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
