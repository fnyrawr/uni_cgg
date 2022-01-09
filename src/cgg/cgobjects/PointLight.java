package cgg.cgobjects;

import cgtools.*;

/**
 * @author Florian Kate
 * Date 2022-01-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class PointLight implements Light {
    protected Point point;      // origin of light source
    protected Color lightColor; // color of light source
    protected double radius;    // radius of light

    public PointLight(Point point, Color lightColor, double radius) {
        this.point = point;
        this.lightColor = lightColor;
        this.radius = radius;
    }

    public Color incomingIntensity(Point hit, Direction normal, Shape scene) {
        Direction posToLight = Vector.subtract(point, hit);
        double t = Vector.length(posToLight);
        Ray lightRay = new Ray(hit, Vector.normalize(posToLight),
                0.0001, t);
        Hit collision = scene.intersect(lightRay);
        if(collision != null && collision.getDistance() < Double.POSITIVE_INFINITY) return Color.black;

        double distSquare = (t/radius) * (t/radius);
        posToLight = Vector.normalize(posToLight);
        double nDotL = Math.max(Vector.dotProduct(normal, posToLight), 0.0);
        double atten = 1.0 / distSquare;
        if(t > radius) atten = Math.pow(atten, 1/atten);
        return Color.multiply (atten*nDotL, lightColor);
    }
}
