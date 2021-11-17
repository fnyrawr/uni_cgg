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

import static cgtools.Vector.color;

public class Main {
    public static void main(String[] args) {
        // debug: test glass helper methods
        // DebugOutputs.glassTests();

        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // preparation for translation and rotation
        // Matrix r = Matrix.rotation(Vector.direction(1, 0, 0), -80);
        // Matrix t = Matrix.translation(Vector.direction(0,5.5,1.25));
        // CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.multiply(t, r), width, height);
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.identity(), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(Color.white));
        Group planes = new Group();
        planes.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 5,
                new DiffuseMaterial(Color.darkgreen)));
        group.addShape(planes);

        // sun
        Group sun = new Group();
        sun.addShape(new Sphere(Vector.point(-5.0, 5.0, -20.0), 7.0, new EmmittingMaterial(Color.orange)));
        group.addShape(sun);

        group.calculateBounds();
        image.sample(new Raytracer(camera, group, 32), 8);

        // Write the images to disk
        final String filename = "doc/test.png";
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

    public static Group createTree(Point point) {
        Group tree = new Group();
        tree.addShape(new Cylinder(point, 0.1, 0.5, new DiffuseMaterial(Color.brown)));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.75, 0)), 0.4, new DiffuseMaterial(Color.darkgreen)));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.95, 0)), 0.3, new DiffuseMaterial(Color.darkgreen)));
        return tree;
    }
}