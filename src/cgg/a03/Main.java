package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Main {
    public static void main(String[] args) {
        final int width = 480;
        final int height = 270;

        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), 10, 10);
        Ray ray_00 = camera.generateRay(0,0);
        Ray ray_55 = camera.generateRay(5,5);
        Ray ray_1010 = camera.generateRay(10,10);

        System.out.println("d(R(0,0)) = "+ray_00.getDirection().toString());
        System.out.println("d(R(5,5)) = "+ray_55.getDirection().toString());
        System.out.println("d(R(10,10)) = "+ray_1010.getDirection().toString());

        // Create image and sample colored discs
        // Image threeSpheres = new Image(width, height, 2.2);
        // threeSpheres.sample(new Object(), 0);

        // Write the images to disk
        // final String filename = "doc/a03-three-spheres.png";
        // threeSpheres.write(filename);
        // System.out.println("Wrote image: " + filename);
    }
}
