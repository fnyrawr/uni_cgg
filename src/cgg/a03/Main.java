package cgg.a03;

/**
 * @author Florian Kate
 * Date 2021-10-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {
        final int width = 480;
        final int height = 270;

        // DebugOutputs.rayTesting();
        // DebugOutputs.hitpointsTesting();

        // Create a new camera and sample spheres
        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), width, height);
        Image spheres = new Image(width, height, 2.2);
        spheres.sample(new Spheres(width, height, camera), 16);

        // Write the images to disk
        final String filename = "doc/a03-three-spheres.png";
        spheres.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
