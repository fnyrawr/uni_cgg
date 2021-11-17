package cgg.a07;

/**
 * @author Florian Kate
 * Date 2021-11-05
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
        Matrix r = Matrix.rotation(Vector.direction(1, 0, 0), -80);
        Matrix t = Matrix.translation(Vector.direction(0,5.5,1.25));
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.multiply(t, r), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(color(0.01, 0.01, 0.01)));
        Group planes = new Group();
        planes.addShape(new Plane(Vector.point(0.0, -1.31, 0.0), Vector.direction(0,1,0), 3,
                new EmmittingMaterial(Color.white)));
        planes.addShape(new Cylinder(Vector.point(0.0, -1.3, 0.0), 3, 1,
                new WaterMaterial(Color.lightblue, 0.5)));
        planes.addShape(new CylinderCoat(Vector.point(0,-0.8,0), 3, 1, new DiffuseMaterial(Color.darkgreen)));
        planes.addShape(new PlaneWinnerRadius(Vector.point(0.0, -0.3, 0.0), Vector.direction(0,1,0), 9, 3,
                new DiffuseMaterial(Color.darkgreen)));
        // add bubbles into the lake
        createBubbles(planes, Vector.point(0,-0.3,0), 3, 1.0, 0.05, 32,12);
        group.addShape(planes);

        // create a forest around the lake
        Group forest = new Group();
        createTreeRing(forest, Vector.point(0, -0.3, 0), Matrix.identity(), 3.5, 12);
        createTreeRing(forest, Vector.point(0, -0.3, 0),
                Matrix.rotation(Vector.direction(0, 1, 0), 45), 4.5, 14);
        createTreeRing(forest, Vector.point(0, -0.3, 0),
                Matrix.rotation(Vector.direction(0, 1, 0), 45/4), 5.5, 16);
        createTreeRing(forest, Vector.point(0, -0.3, 0),
                Matrix.rotation(Vector.direction(0, 1, 0), 45/2), 6.5, 18);
        // createTreeRing(forest, Vector.point(0, -0.3, 0),
        //         Matrix.rotation(Vector.direction(0, 1, 0), 45/8), 7.5, 20);
        // add fireflies into the forest
        createFireflies(forest, Vector.point(0, -0.25, 0), 3.0, 7.5, 0.75, 0.005, 32, 64);
        group.addShape(forest);

        // stars
        // Group groupStars = new Group();
        // createStars(groupStars, Vector.point(0, 0, 0), 20, 15, 0.1, 32, 20);
        // group.addShape(groupStars);

        group.calculateBounds();
        image.sample(new Raytracer(camera, group, 32), 64);

        // Write the images to disk
        final String filename = "doc/a07-2.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }

    public static void createBubbles(Group group, Point point, double radius, double height, double bubbleWidth, int sectors, int nPerSector) {
        ArrayList<Group> bubbleSectors = new ArrayList<Group>();
        for(int i=0; i<sectors; i++) {
            bubbleSectors.add(new Group());
        }
        double secAngle = 2*Math.PI / sectors;
        double bw2 = 2*bubbleWidth;
        for(int j=0; j<sectors; j++) {
            for(int i=0; i<nPerSector; i++) {
                double phi = secAngle*j + Random.randomMinMax(0, secAngle);
                double x = point.x + Random.randomMinMax(bw2, radius-bw2) * Math.cos(phi);
                double y = point.y + Random.randomMinMax(-height-bw2, 0);
                double z = point.z + Random.randomMinMax(bw2, radius-bw2) * Math.sin(phi*i);
                bubbleSectors.get(j).addShape(new Sphere(Vector.point(x, y, z), bubbleWidth, new GlassMaterial(Color.lightgray)));
            }
        }
        for(Group bubbleSector: bubbleSectors) group.addShape(bubbleSector);
    }

    public static void createFireflies(Group group, Point point, double innerRadius, double outerRadius, double height, double ffSize, int sectors, int nPerSector) {
        ArrayList<Group> ffSectors = new ArrayList<Group>();
        for(int i=0; i<sectors; i++) {
            ffSectors.add(new Group());
        }
        double secAngle = 2*Math.PI / sectors;
        double ff2 = 2*ffSize;
        for(int j=0; j<sectors; j++) {
            for(int i=0; i<nPerSector; i++) {
                double phi = secAngle*j + Random.randomMinMax(0, secAngle);
                double radius = Random.randomMinMax(innerRadius, outerRadius);
                double x = point.x + radius * Math.cos(phi);
                double y = point.y + Random.randomMinMax(ff2, height-ff2);
                double z = point.z + radius * Math.sin(phi);
                ffSectors.get(j).addShape(new Sphere(Vector.point(x, y, z), ffSize, new EmmittingMaterial(Color.yellowgreen)));
            }
        }
        for(Group ffSector: ffSectors) group.addShape(ffSector);
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

    public static void createTreeRing(Group group, Point point, Matrix m, double radius, int n) {
        int sectors = 32;
        ArrayList<Group> treeSectors = new ArrayList<Group>();
        for(int i=0; i<sectors; i++) {
            treeSectors.add(new Group());
        }
        for(int i=0; i<n; i++) {
            double phi = Math.PI * 2.0 / n;
            double x = point.x + radius * Math.cos(phi*i);
            double y = point.y;
            double z = point.z + radius * Math.sin(phi*i);
            double sector = (double) sectors/n*i;
            treeSectors.get((int) sector).addShape(createTree(Matrix.multiply(m, Vector.point(x, y, z))));
        }
        for(Group treeSector: treeSectors) group.addShape(treeSector);
    }

    public static Group createTree(Point point) {
        Group tree = new Group();
        tree.addShape(new Cylinder(point, 0.1, 0.5, new DiffuseMaterial(Color.brown)));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.75, 0)), 0.4, new DiffuseMaterial(Color.darkgreen)));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.95, 0)), 0.3, new DiffuseMaterial(Color.darkgreen)));
        return tree;
    }
}
