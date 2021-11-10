package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.BoundingBox;
import cgtools.Shape;

import java.util.ArrayList;

public class Group implements Shape {
    protected ArrayList<Shape> shapes;
    protected BoundingBox boundingBox;

    public Group() {
        shapes = new ArrayList<Shape>();
        this.boundingBox = BoundingBox.empty;
    }

    public Shape addShape(Shape shape) {
        shapes.add(shape);
        if(shape.bounds() == BoundingBox.everything) {
            this.boundingBox = BoundingBox.everything;
        } else {
            this.boundingBox.extend(shape.bounds());
        }
        return this;
    }

    public Hit intersect(Ray ray) {
        // if(!bounds().intersect(ray)) return null;
        Hit nearestHit = null;
        for(Shape shape: shapes) {
            Hit cmpHit = null;
            // if(shape.bounds().intersect(ray))
                cmpHit = shape.intersect(ray);
            if (nearestHit == null || (cmpHit != null && cmpHit.getDistance() <= nearestHit.getDistance())) {
                nearestHit = cmpHit;
            }
        }
        return nearestHit;
    }

    public BoundingBox bounds() {
        return boundingBox;
    }
}
