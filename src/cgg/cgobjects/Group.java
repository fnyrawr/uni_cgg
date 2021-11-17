package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.BoundingBox;
import cgtools.Matrix;
import cgtools.Shape;

import java.util.ArrayList;

public class Group implements Shape {
    protected ArrayList<Shape> shapes;
    protected BoundingBox boundingBox;
    protected Transformation transformation;

    public Group() {
        this.shapes = new ArrayList<Shape>();
        this.boundingBox = BoundingBox.empty;
        this.transformation = new Transformation(Matrix.identity);
    }

    public Group(Matrix transformation) {
        this.shapes = new ArrayList<Shape>();
        this.boundingBox = BoundingBox.empty;
        this.transformation = new Transformation(transformation);
    }

    public Group addShape(Shape shape) {
        shapes.add(shape);
        return this;
    }

    public Hit intersect(Ray ray) {
        if(!bounds().intersect(ray)) return null;
        Hit nearestHit = null;
        for(Shape shape: shapes) {
            Hit cmpHit = shape.intersect(ray);
            if (nearestHit == null || (cmpHit != null && cmpHit.getDistance() <= nearestHit.getDistance())) {
                nearestHit = cmpHit;
            }
        }
        return nearestHit;
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    // recursive bounding box bounds check over all groups and shapes before rendering
    public BoundingBox calculateBounds() {
        this.boundingBox = BoundingBox.empty;
        for(Shape shape: shapes) {
            this.boundingBox = this.boundingBox.extend(shape.calculateBounds());
        }
        return this.boundingBox;
    }
}
