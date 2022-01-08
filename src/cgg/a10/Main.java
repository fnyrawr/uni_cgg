package cgg.a10;

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

/**
 * @author Florian Kate
 * Date 2022-01-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class Main {
    public static void main(String[] args) {
        final int width = 1920;
        final int height = 1080;

        // Create a new camera and sample spheres
        Image image = new Image(width, height, 2.2);
        Matrix r = Matrix.rotation(Vector.direction(1, 0, 0), -30);
        Matrix t = Matrix.translation(Vector.direction(0,1.5,1.25));
        // CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.multiply(t, r), width, height);
        Group group = new Group();

        group.addShape(new Background(new Texture("textures/desertSkybox.jpg")));
        group.addShape(new Sphere(Vector.point(0, 0, -2.5), 0.5, new MirroringMaterial(new Texture("textures/waterTexture.png", Matrix.scaling(0.5, 0.5, 0.5)))));
        group.addShape(new Sphere(Vector.point(-1.5, 0, -2.5), 0.5, new DiffuseMaterial(new CheckerBoardTexture(20))));
        group.addShape(new Sphere(Vector.point(1.5, 0, -2.5), 0.5, new GlassMaterial(Color.lightgray)));
        group.addShape(new Sphere(Vector.point(1.5, 0, -2.5), 0.45, new DiffuseMaterial(new PolkaDotsTexture(0.5, Matrix.scaling(15, 15, 15), Color.darkgray, Color.white))));
        group.addShape(new Cylinder(Vector.point(-1.5, -0.55, -2.5), 0.5, 0.5, new DiffuseMaterial(new CheckerBoardTexture(20))));
        group.addShape(new Sphere(Vector.point(0.75, 0, -5), 1, new DiffuseMirroringMaterial(new GradientTexture(Color.yellow, Color.red), 0.5)));

        group.calculateBounds();
        image.sample(new Raytracer(camera, group, 32), 32);

        // Write the images to disk
        final String filename = "doc/a10-2.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
