package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-10
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Cylinder implements Shape {
    public final Point center;
    public final double radius;
    public final double height;
    public final Material material;
    public final Group cylinderGroup;

    /**
     * Constructor for Pipe class
     * @param center - [Point] center point of Cylinder
     * @param radius - [double] radius of Cylinder
     * @param height - [double] height of Cylinder
     * @param material - [Material] material of the Cylinder's surface
     */
    public Cylinder(Point center, double radius, double height, Material material) {
        this.center = center;
        this.radius = radius;
        this.height = height;
        this.material = material;
        this.cylinderGroup = new Group();
        // cylinderGroup.addShape(new Plane(center));
    }

    public Hit intersect(Ray ray) {
        return cylinderGroup.intersect(ray);
    }
}