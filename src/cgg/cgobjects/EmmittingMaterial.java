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
    protected Color emmission;
    protected Color albedo;

    public EmmittingMaterial(Color color) {
        this.emmission = color;
        this.albedo = null;
    }

    public Color getEmmission() {
        // color of sky in ray direction, constant for now
        return emmission;
    }

    public Color getAlbedo() {
        // no diffusion, no albedo
        return albedo;
    }

    public Ray getSecondaryRay(Ray ray, Hit hit) {
        // no secondary ray as there is no diffusion going on
        return null;
    }
}
