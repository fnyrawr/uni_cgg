package cgg.cgobjects;

/**
 * @author Florian Kate
 * Date 2021-10-10
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class CameraObscura {
    public final double phi;
    public final Point position;
    public final Matrix matrix;
    public final double width;
    public final double height;

    /**
     * Constructor for CameraObscura class
     * @param phi - [double] camera's opening angle
     * @param position - [Point] position of camera
     * @param width - [double] width resolution of created image
     * @param height - [double] height resolution of created image
     */
    public CameraObscura(double phi, Point position, double width, double height) {
        this.phi = phi;
        this.position = position;
        this.matrix = Matrix.identity;
        this.width = width;
        this.height = height;
    }

    public CameraObscura(double phi, Point position, Matrix matrix, double width, double height) {
        this.phi = phi;
        this.position = position;
        this.matrix = matrix;
        this.width = width;
        this.height = height;
    }

    /**
     * Generating a new ray
     * @param x - [double] horizontal projection pixel
     * @param y - [double] vertical projection pixel
     */
    public Ray generateRay(double x, double y) {
        double dx = x-(width/2);
        double dy = -(y-(height/2));
        double dz = -((width/2) / (Math.tan(phi/2)));
        Direction d = Matrix.multiply(matrix, Vector.normalize(Vector.direction(dx, dy, dz)));
        Point cameraPosition = Matrix.multiply(matrix, position);
        return new Ray(cameraPosition, d, 0, Double.POSITIVE_INFINITY);
    }
}
