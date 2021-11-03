package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-01
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

/*
    class for glass material:
    emmission: none
    albedo: object's own color
    secondaryRay: complex mirroring calculation
 */
public class GlassMaterial implements Material {
    protected Color emmission;
    protected Color albedo;
    private double n1 = 1.0;
    private double n2 = 1.5;

    public GlassMaterial(Color color) {
        this.emmission = Color.black;
        this.albedo = color;
    }

    public Color getEmmission() {
        // no emmission
        return emmission;
    }

    public Color getAlbedo() {
        return albedo;
    }

    public Ray getSecondaryRay(Ray ray, Hit hit) {
        // calculate scattered ray direction
        Direction d = ray.getDirection();
        Direction n = hit.getNormal();
        if(Vector.dotProduct(n, d) > 0) {
            // negate n
            n = Vector.negate(n);
            // swap n1 and n2
            double tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        Direction r = refract(d, n, n1, n2);
        if(r != null) {
            if(Random.random() > schlick(d, n, n1, n2))
                return new Ray(hit.getHitpoint(), r, 0.0001, ray.tmax);
        }
        return new Ray(hit.getHitpoint(), reflect(d, n), 0.0001, ray.tmax);
    }

    public Direction reflect(Direction d, Direction n) {
        // r = -2*<n,v>*n+v
        return Vector.add(Vector.multiply(-2.0*Vector.dotProduct(n, d), n), d);
    }

    public double schlick(Direction d, Direction n, double n1, double n2) {
        double r0 = ((n1-n2)/(n1+n2))*((n1-n2)/(n1+n2));
        return r0 + (1-r0) * Math.pow((1+Vector.dotProduct(n, d)),5);
    }

    public Direction refract(Direction d, Direction n, double n1, double n2) {
        double r = n1/n2;
        double c = Vector.dotProduct(n, d);
        double discriminant = 1-r*r*(1-c*c);
        if(discriminant >= 0) {
            return Vector.add(Vector.negate(Vector.multiply(r, d)), Vector.multiply(10*r*c-Math.sqrt(discriminant), n));
        }
        return null;
    }
}