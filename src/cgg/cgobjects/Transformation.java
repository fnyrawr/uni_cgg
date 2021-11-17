package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-11-13
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Transformation {
    // wtoM: world to object | otwM: object to world | otwN: object to world normal
    protected final Matrix wtoM;
    protected final Matrix otwM;
    protected final Matrix otwN;

    public Transformation(Matrix m) {
        this.wtoM = m;
        this.otwM = Matrix.invert(wtoM);
        this.otwN = Matrix.transpose(otwM);
    }

    public Matrix toWorld() {
        return otwM;
    }

    public Matrix toWorldN() {
        return otwN;
    }

    public Matrix fromWorld() {
        return wtoM;
    }

    public Ray rayWorldToObject(Ray ray) {
        return new Ray(Matrix.multiply(fromWorld(), ray.getOrigin()), Matrix.multiply(fromWorld(), ray.getDirection()),
                ray.tmin, ray.tmax);
    }

    public Hit hitObjectToWorld(Hit hit) {
        return new Hit(hit.getDistance(), Matrix.multiply(toWorld(), hit.getHitpoint()),
                Matrix.multiply(toWorldN(), hit.getNormal()), hit.getMaterial());
    }
}
