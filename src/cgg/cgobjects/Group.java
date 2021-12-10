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

    public Group rotateMove(Matrix transformation) {
        this.transformation = new Transformation(transformation);
        return this;
    }

    public Matrix getTransformation() {
        return this.transformation.toWorld();
    }

    public Hit intersect(Ray ray) {
        Ray transformedRay = transformation.rayWorldToObject(ray);
        if(!bounds().intersect(transformedRay)) return null;
        Hit nearestHit = null;
        for(Shape shape: shapes) {
            Hit cmpHit = shape.intersect(transformedRay);
            if (nearestHit == null || (cmpHit != null && cmpHit.getDistance() <= nearestHit.getDistance())) {
                nearestHit = cmpHit;
            }
        }
        if (nearestHit == null) return null;
        return transformation.hitObjectToWorld(nearestHit);
    }

    public BoundingBox bounds() {
        return boundingBox;
    }

    // recursive bounding box bounds check over all groups and shapes before rendering
    public BoundingBox calculateBounds() {
        this.boundingBox = BoundingBox.empty;
        for(Shape shape: shapes) {
            if(shape instanceof Group && ((Group) shape).getTransformation() != Matrix.identity()) {
                this.boundingBox = this.boundingBox.extend(shape.calculateBounds().transform(((Group) shape).getTransformation()));
            } else {
                this.boundingBox = this.boundingBox.extend(shape.calculateBounds());
            }
        }
        return this.boundingBox;
    }
}
