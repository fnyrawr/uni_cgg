package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2022-01-28
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Rectangle implements Shape {
    public final Point point;
    public final double width;
    public final double height;
    public final double depth;
    public final Material material;
    public final Group rectangleGroup;
    protected BoundingBox boundingBox;

    public Rectangle(Point point, double width, double height, double depth, Material material) {
        this.point = point;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
        this.rectangleGroup = new Group();

        // add planes to form a rectangle
        Point zero = Vector.point(0, 0, 0);
        // bottom
        Group rectBottom = new Group(Matrix.multiply(Matrix.translation(-point.x, point.y-height/2.0, point.z),
                Matrix.rotation(Vector.direction(1.0,0.0,0.0), 180.0)));
        rectBottom.addShape(new RectPlane(zero, Vector.direction(0.0, 1.0, 0.0), width, depth, material));
        //top
        Group rectTop = new Group(Matrix.multiply(Matrix.translation(-point.x, point.y+height/2.0, point.z),
                Matrix.rotation(Vector.direction(1.0,0.0,0.0), 180.0)));
        rectTop.addShape(new RectPlane(zero, Vector.direction(0.0, 1.0, 0.0), width, depth, material));
        // left
        Group rectLeft = new Group(Matrix.multiply(Matrix.translation(point.y, -point.x+width/2.0, -point.z),
                Matrix.rotation(Vector.direction(0.0,0.0,1.0), 90.0)));
        rectLeft.addShape(new RectPlane(zero, Vector.direction(0.0, 1.0, 0.0), height, depth, material));
        // right
        Group rectRight = new Group(Matrix.multiply(Matrix.translation(point.y, -point.x-width/2.0, -point.z),
                Matrix.rotation(Vector.direction(0.0,0.0,1.0), 90.0)));
        rectRight.addShape(new RectPlane(zero, Vector.direction(0.0, 1.0, 0.0), height, depth, material));
        // front
        Group rectFront = new Group(Matrix.multiply(Matrix.translation(-point.x, point.z+depth/2.0, -point.y),
                Matrix.rotation(Vector.direction(1.0,0.0,0.0), 90.0)));
        rectFront.addShape(new RectPlane(zero, Vector.direction(0.0, 1.0, 0.0), width, height, material));
        // back
        Group rectBack = new Group(Matrix.multiply(Matrix.translation(-point.x, point.z-depth/2.0, -point.y),
                Matrix.rotation(Vector.direction(1.0,0.0,0.0), 90.0)));
        rectBack.addShape(new RectPlane(zero, Vector.direction(0.0, 1.0, 0.0), width, height, material));

        rectangleGroup.addShape(rectBottom);
        rectangleGroup.addShape(rectTop);
        rectangleGroup.addShape(rectLeft);
        rectangleGroup.addShape(rectRight);
        rectangleGroup.addShape(rectFront);
        rectangleGroup.addShape(rectBack);

        this.boundingBox = rectangleGroup.calculateBounds();
    }

    public Hit intersect(Ray ray) {
        return rectangleGroup.intersect(ray);
    }

    public BoundingBox bounds() {
        return rectangleGroup.bounds();
    }

    public BoundingBox calculateBounds() {
        return rectangleGroup.bounds();
    }
}


