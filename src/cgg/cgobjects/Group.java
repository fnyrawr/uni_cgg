package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-30
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.Shape;

import java.util.ArrayList;

public class Group implements Shape {
    protected ArrayList<Shape> shapes;

    public Group() {
        shapes = new ArrayList<Shape>();
    }

    public Shape addShape(Shape shape) {
        shapes.add(shape);
        return this;
    }

    public Hit intersect(Ray r) {
        Hit nearestHit = null;
        for(Shape shape: shapes) {
            Hit cmpHit = shape.intersect(r);
            if(nearestHit == null || (cmpHit != null && cmpHit.getDistance() <= nearestHit.getDistance())) {
                nearestHit = cmpHit;
            }
        }
        return nearestHit;
    }
}
