package cgg.cgobjects;

import cgtools.*;

/*
    class for perfect diffuse material (Lambertian material):
    emmission: none
    albedo: BRDF constant over surface, color of surface
    secondaryRay: x0: hitpoint, direction: random with cosinus distribution
 */
public class LambertianMaterial implements Material {
    private Color color;
    private Ray secondaryRay;

    public LambertianMaterial(Color color) {
        this.color = color;
        this.secondaryRay = null;
    }

    public Color getEmmission() {
        // no emmission
        return color;
    }

    public Color getAlbedo(Ray ray, Hit hit) {
        generateSecondaryRay(ray, hit);
        return color;
    }

    private void generateSecondaryRay(Ray ray, Hit hit) {
        // rejection sampling
        Direction direction = Vector.direction(1,1,1);
        while(Vector.length(direction) >= 1) {
            Vector.direction(Random.random(), Random.random(), Random.random());
        }
        secondaryRay = new Ray(hit.getHitpoint(), Vector.add(hit.getUnit(), direction), ray.tmin, ray.tmax);
    }

    public Ray getSecondaryRay() {
        return secondaryRay;
    }
}
