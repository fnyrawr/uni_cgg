package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Cylinder implements Shape {
    protected final Point center;
    protected final double radius;
    protected final double height;
    protected final Material material;
    protected final Group cylinderGroup;
    protected BoundingBox boundingBox;

    /**
     * Constructor for Cylinder class
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
        cylinderGroup.addShape(new Plane(center, Vector.direction(0,-1,0), radius, material));
        cylinderGroup.addShape(new CylinderCoat(Vector.add(center, Vector.direction(0, height/2, 0)),
                radius, height, material));
        cylinderGroup.addShape(new Plane(Vector.add(center, Vector.direction(0, height, 0)),
                Vector.direction(0,1,0), radius, material));
        this.boundingBox = cylinderGroup.calculateBounds();
    }

    public Hit intersect(Ray ray) {
        return cylinderGroup.intersect(ray);
    }

    public BoundingBox bounds() {
        return cylinderGroup.bounds();
    }

    public BoundingBox calculateBounds() {
        return cylinderGroup.bounds();
    }
}