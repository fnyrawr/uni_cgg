package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;
import java.util.ArrayList;
import java.util.Collections;

/*
    class for mist material:
    simulating a virtual fog, depth defines how many rays pass through
    emmission: none
    albedo: BRDF constant over surface, color of surface
    secondaryRay: x0: hitpoint, direction: random with cosinus distribution
 */
public class MistMaterial implements Material {
    protected Color emmission;
    protected Color albedo;
    protected double depth;

    public MistMaterial(Color color, double depth) {
        this.emmission = Color.black;
        this.albedo = color;
        this.depth = depth;
    }

    public Color getEmmission() {
        // no emmission
        return emmission;
    }

    public Color getAlbedo() {
        return albedo;
    }

    public Ray getSecondaryRay(Ray ray, Hit hit) {
        // randomize rays that shine through the fog
        if(Random.random() > depth) {
            // no collision, proceed with ray as secondary ray
            return new Ray(hit.getHitpoint(), ray.getDirection(), 0.0001, ray.tmax);
        }
        // collision with fog, proceed as with diffusing material
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