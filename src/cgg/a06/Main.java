package cgg.a06;

/**
 * @author Florian Kate
 * Date 2021-11-01
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {
        // debug: test glass helper methods
        // DebugOutputs.glassTests();

        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // a06-mirrors-glass-1.png Camera and Group
        Matrix r = Matrix.rotation(Vector.direction(1, 0, -1), -25);
        Matrix t = Matrix.translation(Vector.direction(0,0,0.25));
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.multiply(t, r), width, height);
        // CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,1), width, height);
        Group group = new Group();
        group.addShape(new Background(Color.white));
        Group plane = new Group();
        plane.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), 3,
                new DiffuseMirroringMaterial(Color.lightgray, 0.01)));
        group.addShape(plane);

        // green mameshiba body
        Group mameshibaGreen = new Group();
        mameshibaGreen.addShape(new Sphere(Vector.point(0.0, -0.25, -1.5), 0.25, new DiffuseMaterial(Color.green)));
        mameshibaGreen.addShape(new Sphere(Vector.point(0.1, -0.27, -1.65), 0.23, new DiffuseMaterial(Color.green)));
        // ears
        mameshibaGreen.addShape(new Sphere(Vector.point(-0.25, -0.15, -1.5), 0.07, new DiffuseMaterial(Color.darkgreen)));
        mameshibaGreen.addShape(new Sphere(Vector.point(0.2, -0.15, -1.4), 0.07, new DiffuseMaterial(Color.darkgreen)));
        // mouth
        mameshibaGreen.addShape(new Sphere(Vector.point(0.0, -0.25, -1.28), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaGreen.addShape(new Sphere(Vector.point(-0.01, -0.27, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaGreen.addShape(new Sphere(Vector.point(-0.02, -0.275, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaGreen.addShape(new Sphere(Vector.point(0.01, -0.27, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaGreen.addShape(new Sphere(Vector.point(0.02, -0.275, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        // eyes
        mameshibaGreen.addShape(new Sphere(Vector.point(-0.06, -0.19, -1.29), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaGreen.addShape(new Sphere(Vector.point(-0.063, -0.185, -1.258), 0.01, new DiffuseMaterial(Color.white)));
        mameshibaGreen.addShape(new Sphere(Vector.point(0.06, -0.19, -1.289), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaGreen.addShape(new Sphere(Vector.point(0.06, -0.186, -1.255), 0.01, new DiffuseMaterial(Color.white)));
        group.addShape(mameshibaGreen);

        // yellow mameshiba body
        Group mameshibaYellow = new Group();
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.75, -0.25, -1.5), 0.25, new DiffuseMaterial(Color.yellow)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.65, -0.27, -1.65), 0.23, new DiffuseMaterial(Color.yellow)));
        // ears
        mameshibaYellow.addShape(new Sphere(Vector.point(-1.0, -0.15, -1.5), 0.07, new DiffuseMaterial(Color.orange)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.55, -0.15, -1.4), 0.07, new DiffuseMaterial(Color.orange)));
        // mouth
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.75, -0.25, -1.28), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.76, -0.27, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.77, -0.275, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.74, -0.27, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.73, -0.275, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        // eyes
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.81, -0.19, -1.29), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.804, -0.185, -1.258), 0.01, new DiffuseMaterial(Color.white)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.69, -0.19, -1.289), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaYellow.addShape(new Sphere(Vector.point(-0.69, -0.186, -1.255), 0.01, new DiffuseMaterial(Color.white)));
        group.addShape(mameshibaYellow);

        // blue mameshiba body
        Group mameshibaBlue = new Group();
        mameshibaBlue.addShape(new Sphere(Vector.point(0.75, -0.25, -1.5), 0.25, new DiffuseMaterial(Color.blue)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.65, -0.27, -1.65), 0.23, new DiffuseMaterial(Color.blue)));
        // ears
        mameshibaBlue.addShape(new Sphere(Vector.point(0.5, -0.15, -1.5), 0.07, new DiffuseMaterial(Color.lightblue)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.95, -0.15, -1.4), 0.07, new DiffuseMaterial(Color.lightblue)));
        // mouth
        mameshibaBlue.addShape(new Sphere(Vector.point(0.75, -0.25, -1.28), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.74, -0.27, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.73, -0.275, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.76, -0.27, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.77, -0.275, -1.28), 0.03, new DiffuseMaterial(Color.black)));
        // eyes
        mameshibaBlue.addShape(new Sphere(Vector.point(0.69, -0.19, -1.29), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.69, -0.185, -1.258), 0.01, new DiffuseMaterial(Color.white)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.81, -0.19, -1.289), 0.04, new DiffuseMaterial(Color.black)));
        mameshibaBlue.addShape(new Sphere(Vector.point(0.81, -0.186, -1.255), 0.01, new DiffuseMaterial(Color.white)));
        group.addShape(mameshibaBlue);

        // glass ball
        Group glassBall = new Group();
        glassBall.addShape(new Sphere(Vector.point(-0.3, -0.375, -1.15), 0.125, new GlassMaterial(Color.lightgray)));
        glassBall.addShape(new Sphere(Vector.point(-0.6, -0.375, -1.0), 0.125, new GlassMaterial(Color.lightgray)));
        glassBall.addShape(new Sphere(Vector.point(0.3, -0.375, -1.15), 0.125, new GlassMaterial(Color.lightgray)));
        group.addShape(glassBall);

        // mirror
        Group mirror = new Group();
        mirror.addShape(new Plane(Vector.point(0.5, 1.0, -2.0), Vector.direction(0.125,-1.5,1), 1.25,
                new MirroringMaterial(Color.lightgray)));
        // group.addShape(mirror);

        group.calculateBounds();
        image.sample(new Raytracer(camera, group, 32), 64);

        // Write the images to disk
        final String filename = "doc/a06-mirrors-glass-2.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
