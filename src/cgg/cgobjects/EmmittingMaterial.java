package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-31
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

/*
    class for light emitting material:
    emmission: color of e,mission
    albedo: no diffusion, no albedo
    secondaryRay: no diffusion
 */
public class EmmittingMaterial implements Material {
    protected Sampler emmission;

    public EmmittingMaterial(Color color) {
        this.emmission = new ConstantColor(color);
    }

    public EmmittingMaterial(Sampler texture) {
        this.emmission = texture;
    }

    public Color getEmmission(Hit hit) {
        // color of sky in ray direction, constant for now
        return emmission.getColor(hit.u, hit.v);
    }

    public Color getAlbedo(Hit hit) {
        // no diffusion, no albedo
        return null;
    }

    public Ray getSecondaryRay(Ray ray, Hit hit) {
        // no secondary ray as there is no diffusion going on
        return null;
    }
}
