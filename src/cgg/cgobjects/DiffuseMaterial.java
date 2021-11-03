package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-31
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    class for perfect diffuse material (Lambertian material):
    emmission: none
    albedo: BRDF constant over surface, color of surface
    secondaryRay: x0: hitpoint, direction: random with cosinus distribution
 */
public class DiffuseMaterial implements Material {
    protected Color emmission;
    protected Color albedo;

    public DiffuseMaterial(Color color) {
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
        // Vector.normalize(Vector.add(hit.getUnit(), direction): normalized addition of random direction (<=1) and hit normal
        return new Ray(hit.getHitpoint(), Vector.normalize(Vector.add(hit.getNormal(), getRandomDirection())), 0.0001, ray.tmax);
    }

    // get random direction <= 1
    private Direction getRandomDirection() {
        // create 3 randoms which are <= 1 in squared length
        double rnd1 = Random.randomMinMax(-1.0,1.0);
        double tmp = -Math.sqrt(Math.abs(-1.0+rnd1*rnd1));
        double rnd2 = Random.randomMinMax(-tmp, tmp);
        tmp = Math.sqrt(Math.abs(-1.0+rnd2*rnd2));
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
