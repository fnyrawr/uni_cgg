package cgg.cgobjects;

import cgtools.*;

/*
    class for background material:
    emmission: color of sky in ray direction
    albedo: no diffusion, no albedo
    secondaryRay: no diffusion
 */
public class BackgroundMaterial implements Material {
    private Color color;

    public BackgroundMaterial(Color color) {
        this.color = color;
    }

    public Color getEmmission() {
        // color of sky in ray direction, constant for now
        return color;
    }

    public Color getAlbedo(Ray ray, Hit hit) {
        // no diffusion, no albedo
        return Color.black;
    }

    public Ray getSecondaryRay() {
        // no secondary ray as there is no diffusion going on
        return null;
    }
}
