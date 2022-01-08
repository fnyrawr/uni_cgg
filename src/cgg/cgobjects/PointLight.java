package cgg.cgobjects;

import cgtools.*;

public class PointLight implements Light {
    protected Point point;          // origin of light source
    protected Color lightColor;     // color of light source
    protected double tMax;          // max distance where light can be seen

    public PointLight(Point point, Color lightColor, double tMax) {
        this.point = point;
        this.lightColor = lightColor;
        this.tMax = tMax;
    }

    public Color incomingIntensity(Point hit, Direction normal, Shape scene) {
        return null;
    }
}
