package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-01
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

/*
    class for mirroring material:
    emmission: none
    albedo: mirror's own color
    secondaryRay: ray gets mirrored on hitpoint
 */
public class MirroringMaterial implements Material {
    protected Color emmission;
    protected Color albedo;

    public MirroringMaterial(Color color) {
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
        // secondaryRay = ray - 2*(hit.normal*ray)*hit.normal
        Direction direction = Vector.subtract(ray.getDirection(),
                Vector.multiply(Vector.dotProduct(hit.getNormal(), ray.getDirection()), hit.getNormal()));
        return new Ray(hit.getHitpoint(), Vector.normalize(Vector.add(hit.getNormal(), direction)), 0.0001, ray.tmax);
    }
}