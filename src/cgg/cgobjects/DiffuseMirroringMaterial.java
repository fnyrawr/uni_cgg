package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-01
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

import java.util.ArrayList;
import java.util.Collections;

/*
    class for diffuse mirroring material:
    emmission: none
    albedo: mirror's own color
    secondaryRay: ray gets mirrored on hitpoint with slight diffusion
 */
public class DiffuseMirroringMaterial implements Material {
    protected Color emmission;
    protected Color albedo;
    protected double scatteringFactor;

    public DiffuseMirroringMaterial(Color color, Double scatteringFactor) {
        this.emmission = Color.black;
        this.albedo = color;
        this.scatteringFactor = scatteringFactor;
    }

    public Color getEmmission() {
        // no emmission
        return emmission;
    }

    public Color getAlbedo() {
        return albedo;
    }

    public Ray getSecondaryRay(Ray ray, Hit hit) {
        // mirroring direction = ray - 2*(hit.normal*ray)*hit.normal
        Direction direction = Vector.subtract(ray.getDirection(),
                Vector.multiply(Vector.dotProduct(hit.getNormal(), ray.getDirection()), hit.getNormal()));
        // adding a random scattering direction and normalizing the secondaryRay's direction
        direction = Vector.normalize(Vector.add(direction, getRandomDirection()));
        // edge case test: negate direction if it's angle is > 90° to the normal of hit
        if(Vector.dotProduct(direction, hit.getNormal()) < 0) {
            Vector.negate(direction);
        }
        return new Ray(hit.getHitpoint(), Vector.normalize(Vector.add(hit.getNormal(), direction)), 0.0001, ray.tmax);
    }

    // get random direction <= scatteringFactor
    private Direction getRandomDirection() {
        // create 3 randoms which are <= scatteringFactor in squared length
        double rnd1 = Random.randomMinMax(-scatteringFactor,scatteringFactor);
        double tmp = -Math.sqrt(Math.abs(-scatteringFactor+rnd1*rnd1));
        double rnd2 = Random.randomMinMax(-tmp, tmp);
        tmp = Math.sqrt(Math.abs(-scatteringFactor+rnd2*rnd2));
        double rnd3 = Random.randomMinMax(-tmp, tmp);

        // shuffle randoms for random direction
        ArrayList<Double> randoms = new ArrayList<Double>();
        randoms.add(rnd1);
        randoms.add(rnd2);
        randoms.add(rnd3);
        Collections.shuffle(randoms);

        return Vector.direction(randoms.get(0), randoms.get(1), randoms.get(2));
    }
}