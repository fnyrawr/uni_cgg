package cgg.a08;

/**
 * @author Florian Kate
 * Date 2021-11-13
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.identity(), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(Color.gray));
        Group planes = new Group();
        planes.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 5,
                new DiffuseMaterial(Color.darkgreen)));
        group.addShape(planes);

        // torii
        Group torii = new Group();
        for(int i=0; i<15; i++) {
            torii.addShape(createTorii(Vector.point(0, -0.5, -1-0.1*i)));
        }
        group.addShape(torii);

        // cat statues
        group.addShape(createCat(Vector.point(-0.45, -0.5, -0.85)));
        group.addShape(createCat(Vector.point(0.45, -0.5, -0.85)));
        group.addShape(createCat(Vector.point(0, -0.5, -2.75)));

        // pebbles
        Group pebbles = new Group();
        for(int i=0; i<20; i++) {
            pebbles.addShape(new Sphere(Vector.point(0, -0.59, -0.5-0.1*i), 0.1, new DiffuseMaterial(Color.darkgray)));
            pebbles.addShape(new Sphere(Vector.point(-0.075, -0.59, -0.45-0.1*i), 0.1, new DiffuseMaterial(Color.darkgray)));
            pebbles.addShape(new Sphere(Vector.point(0.075, -0.59, -0.45-0.1*i), 0.1, new DiffuseMaterial(Color.darkgray)));
            pebbles.addShape(new Sphere(Vector.point(-0.15, -0.59, -0.5-0.1*i), 0.1, new DiffuseMaterial(Color.darkgray)));
            pebbles.addShape(new Sphere(Vector.point(0.15, -0.59, -0.5-0.1*i), 0.1, new DiffuseMaterial(Color.darkgray)));
        }
        group.addShape(pebbles);

        // trees
        group.addShape(createTree(Vector.point(0, -0.5, -3.25)));
        Group treesLeft = new Group();
        Group treesRight = new Group();
        treesLeft.addShape(createTree(Vector.point(-1.5, -0.5, -3.25)));
        treesRight.addShape(createTree(Vector.point(1.5, -0.5, -3.25)));
        treesLeft.addShape(createTree(Vector.point(-1.5, -0.5, -2.25)));
        treesRight.addShape(createTree(Vector.point(1.5, -0.5, -2.25)));
        treesLeft.addShape(createTree(Vector.point(-1.5, -0.5, -1.25)));
        treesRight.addShape(createTree(Vector.point(1.5, -0.5, -1.25)));
        treesLeft.addShape(createTree(Vector.point(-2.5, -0.5, -2.75)));
        treesRight.addShape(createTree(Vector.point(2.5, -0.5, -2.75)));
        group.addShape(treesLeft);
        group.addShape(treesRight);

        // mountains
        Group mountains = new Group();
        mountains.addShape(new Sphere(Vector.point(0, -3, -11), 7, new DiffuseMaterial(Color.darkgreen)));
        mountains.addShape(new Sphere(Vector.point(-3, -1.5, -9), 4, new DiffuseMaterial(Color.darkgreen)));
        mountains.addShape(new Sphere(Vector.point(3, -1.5, -9), 4, new DiffuseMaterial(Color.darkgreen)));
        mountains.addShape(new Sphere(Vector.point(-6, -1, -7), 2.5, new DiffuseMaterial(Color.darkgreen)));
        mountains.addShape(new Sphere(Vector.point(6, -1, -7), 2.5, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(mountains);

        group.calculateBounds();
        image.sample(new Raytracer(camera, group, 32), 32);

        // Write the images to disk
        final String filename = "doc/a08-1.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }

    public static void createStars(Group group, Point point, double radius, double height, double starSize, int sectors, int nPerSector) {
        ArrayList<Group> starSectors = new ArrayList<Group>();
        for(int i=0; i<sectors; i++) {
            starSectors.add(new Group());
        }
        double secAngle = 2*Math.PI / sectors;
        for(int j=0; j<sectors; j++) {
            for(int i=0; i<nPerSector; i++) {
                double phi = secAngle*j + Random.randomMinMax(0, secAngle);
                double x = point.x + radius * Math.cos(phi);
                double y = point.y + Random.randomMinMax(0, height);
                double z = point.z + radius * Math.sin(phi);
                starSectors.get(j).addShape(new Sphere(Vector.point(x, y, z), Random.randomMinMax(starSize/8, starSize),
                        new EmmittingMaterial(Color.white)));
            }
        }
        for(Group starSector: starSectors) group.addShape(starSector);
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

    public static Group createTorii(Point point) {
        Group torii = new Group();
        // vertical beams
        torii.addShape(new Cylinder(Vector.point(point.x-0.4, point.y, point.z), 0.05, 0.75, new DiffuseMaterial(Color.red)));
        torii.addShape(new Cylinder(Vector.point(point.x+0.4, point.y, point.z), 0.05, 0.75, new DiffuseMaterial(Color.red)));
        // horizontal beams
        Group horizontalBeams = new Group(Matrix.rotation(Vector.direction(0, 0, 1), 90));
        horizontalBeams.addShape(new Cylinder(Vector.point(point.x-0.225, point.y-0.1, point.z), 0.05, 1.2, new DiffuseMaterial(Color.red)));
        horizontalBeams.addShape(new Cylinder(Vector.point(point.x-0.05, point.y, point.z), 0.05, 1, new DiffuseMaterial(Color.red)));
        horizontalBeams.addShape(new Cylinder(Vector.point(point.x+0.05, point.y+0.1, point.z), 0.005, 0.075, new DiffuseMaterial(Color.black)));
        horizontalBeams.addShape(new Cylinder(Vector.point(point.x+0.05, point.y+0.82, point.z), 0.005, 0.075, new DiffuseMaterial(Color.black)));
        // lanterns
        torii.addShape(new Cylinder(Vector.point(point.x-0.328, point.y+0.435, point.z), 0.01, 0.02, new DiffuseMaterial(Color.black)));
        torii.addShape(new Cylinder(Vector.point(point.x-0.328, point.y+0.365, point.z), 0.01, 0.07, new EmmittingMaterial(Color.lightgray)));
        torii.addShape(new Cylinder(Vector.point(point.x+0.328, point.y+0.435, point.z), 0.01, 0.02, new DiffuseMaterial(Color.black)));
        torii.addShape(new Cylinder(Vector.point(point.x+0.328, point.y+0.365, point.z), 0.01, 0.07, new EmmittingMaterial(Color.lightgray)));
        torii.addShape(horizontalBeams);
        return torii;
    }

    public static Group createTree(Point point) {
        Group tree = new Group();
        tree.addShape(new Cylinder(point, 0.1, 0.5, new DiffuseMaterial(Color.brown)));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.75, 0)), 0.4, new DiffuseMaterial(Color.darkgreen)));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.95, 0)), 0.3, new DiffuseMaterial(Color.darkgreen)));
        return tree;
    }
}