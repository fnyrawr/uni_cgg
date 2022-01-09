package cgg.cgobjects;

import cgtools.*;

/**
 * @author Florian Kate
 * Date 2022-01-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class DirectionLight implements Light {

    protected Direction lightDirection; // direction of light source
    protected Color lightColor;         // color of light source
    protected double intensity;         // intensity of light | 0 none ... 1 color | > 1 color + whitening

    public DirectionLight(Direction direction, Color color, double intensity) {
        this.lightDirection = Vector.normalize(direction);
        this.lightColor = color;
        this.intensity = intensity;
    }

    public Color incomingIntensity(Point hit, Direction normal, Shape scene) {
        // Phong Model:
        // p: hit | s: lightDirection | r: reflection of lightDirection | v: direction of view
        // ambiance: La = ambiance coefficient x Light intensity
        // diffusion: Ld = diffusion coefficient x Light intensity (normal * light direction)
        // specular: Ls = specular coefficient x Light intensity (reflection * direction of view)^exponent
        Ray lightRay = new Ray(hit, Vector.negate(lightDirection), 0.0001, Double.POSITIVE_INFINITY);
        Hit collision = scene.intersect(lightRay);
        // comparison here because ray could actually collide with the background
        if(collision != null && collision.getDistance() < Double.POSITIVE_INFINITY) return Color.black;

        Color ambient = Color.multiply(0.1, lightColor);
        Color diffuse = Color.multiply(0.9 * Math.max(0.0, Vector.dotProduct(Vector.negate(lightDirection), normal)), lightColor);
        return Color.add(ambient, diffuse);
    }
}
