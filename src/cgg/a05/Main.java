package cgg.a05;

/**
 * @author Florian Kate
 * Date 2021-11-10
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;
import static cgtools.Vector.color;

public class Main {
    public static void main(String[] args) {
        // debug: test glass helper methods
        // DebugOutputs.glassTests();
        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        // preparation for translation and rotation
        // Matrix r = Matrix.rotation(Vector.direction(1, 0, 0), -25);
        // Matrix t = Matrix.translation(Vector.direction(0,1,1));
        // CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.multiply(t, r), width, height);
        CameraObscura camera = new CameraObscura(Math.PI / 2, Vector.point(0, 0, 0), width, height);
        Group group = new Group();

        // Group planes with bounding box
        group.addShape(new Background(color(0.005, 0.005, 0.005)));
        Group planes = new Group();
        planes.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), 3,
                new DiffuseMaterial(Color.yellow)));
        planes.addShape(new Plane(Vector.point(0.0, -0.3, 0.0), Vector.direction(0, 1, 0), 3,
                new WaterMaterial(Color.lightblue, 0.7)));
        group.addShape(planes);

        // moon
        Group moon = new Group();
        moon.addShape(new Sphere(Vector.point(-5.0, 5.0, -20.0), 7.0, new EmmittingMaterial(Color.lightgray)));
        group.addShape(moon);

        // flash light from origin
        Group flashlight = new Group();
        flashlight.addShape(new Sphere(Vector.point(0.0, 0.0, 2.0), 0.5, new EmmittingMaterial(Color.white)));
        group.addShape(flashlight);

        // Totoro body
        Group totoroBody = new Group();
        Group totoroHead = new Group();
        totoroBody.addShape(new Sphere(Vector.point(0.0, -0.25, -2.5), 0.75, new DiffuseMaterial(Color.gray)));
        totoroBody.addShape(new Sphere(Vector.point(0.0, 0.2, -2.3), 0.65, new DiffuseMaterial(Color.gray)));
        totoroBody.addShape(new Sphere(Vector.point(0.0, 0.5, -2.1), 0.5, new DiffuseMaterial(Color.gray)));
        totoroBody.addShape(new Sphere(Vector.point(0.0, -0.25, -2.35), 0.65, new DiffuseMaterial(Color.white)));
        totoroBody.addShape(new Sphere(Vector.point(0.0, 0.2, -2.23), 0.6, new DiffuseMaterial(Color.white)));
        totoroHead.addShape(new Sphere(Vector.point(-0.15, 0.55, -1.65), 0.07, new DiffuseMaterial(Color.white)));
        totoroHead.addShape(new Sphere(Vector.point(0.15, 0.55, -1.65), 0.07, new DiffuseMaterial(Color.white)));
        totoroHead.addShape(new Sphere(Vector.point(-0.14, 0.54, -1.6), 0.03, new EmmittingMaterial(Color.red)));
        totoroHead.addShape(new Sphere(Vector.point(0.14, 0.54, -1.6), 0.03, new EmmittingMaterial(Color.red)));
        totoroHead.addShape(new Sphere(Vector.point(0.0, 0.5, -1.6), 0.02, new DiffuseMaterial(Color.gray)));
        totoroHead.addShape(new Sphere(Vector.point(-0.01, 0.5, -1.6), 0.02, new DiffuseMaterial(Color.gray)));
        totoroHead.addShape(new Sphere(Vector.point(0.01, 0.5, -1.6), 0.02, new DiffuseMaterial(Color.gray)));
        totoroHead.addShape(new Sphere(Vector.point(-0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        totoroHead.addShape(new Sphere(Vector.point(0.2, 0.85, -1.8), 0.1, new DiffuseMaterial(Color.gray)));
        totoroHead.addShape(new Sphere(Vector.point(-0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        totoroHead.addShape(new Sphere(Vector.point(0.22, 0.9, -1.77), 0.1, new DiffuseMaterial(Color.gray)));
        group.addShape(totoroBody);
        group.addShape(totoroHead);

        // cloud
        Group cloud = new Group();
        cloud.addShape(new Sphere(Vector.point(-1.75, 1.0, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.65, 1.0, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.55, 1.0, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.45, 1.0, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.35, 1.0, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.7, 0.95, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.6, 0.95, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.5, 0.95, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.4, 0.95, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.7, 1.05, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.6, 1.05, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.5, 1.05, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        cloud.addShape(new Sphere(Vector.point(-1.4, 1.05, -2.25), 0.1, new DiffuseMaterial(Color.white)));
        group.addShape(cloud);

        // bushes
        Group bushesLeft = new Group();
        Group bushesRight = new Group();
        bushesLeft.addShape(new Sphere(Vector.point(-1.25, -0.5, -3.0), 1, new DiffuseMaterial(Color.darkgreen)));
        bushesLeft.addShape(new Sphere(Vector.point(-1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        bushesLeft.addShape(new Sphere(Vector.point(-1.75, -1.0, -2.0), 1, new DiffuseMaterial(Color.darkgreen)));
        bushesRight.addShape(new Sphere(Vector.point(1.5, -0.75, -2.5), 1, new DiffuseMaterial(Color.darkgreen)));
        bushesRight.addShape(new Sphere(Vector.point(1.75, -1.0, -2.0), 1, new DiffuseMaterial(Color.darkgreen)));
        group.addShape(bushesLeft);
        group.addShape(bushesRight);

        // fireflies
        Group firefliesLeft = new Group();
        Group firefliesMiddle = new Group();
        Group firefliesRight = new Group();
        for (int i = 0; i < 150; i++) {
            firefliesLeft.addShape(new Sphere(Vector.point(Random.randomMinMax(-1.25, -0.5), Random.randomMinMax(-0.25, 0.0), Random.randomMinMax(-0.25, -1.0)),
                    0.001, new EmmittingMaterial(Color.yellowgreen)));
            firefliesMiddle.addShape(new Sphere(Vector.point(Random.randomMinMax(-0.5, 0.5), Random.randomMinMax(-0.25, 0.0), Random.randomMinMax(-0.25, -1.0)),
                    0.001, new EmmittingMaterial(Color.yellowgreen)));
            firefliesRight.addShape(new Sphere(Vector.point(Random.randomMinMax(0.5, 1.25), Random.randomMinMax(-0.25, 0.0), Random.randomMinMax(-0.25, -1.0)),
                    0.001, new EmmittingMaterial(Color.yellowgreen)));
        }
        group.addShape(firefliesLeft);
        group.addShape(firefliesMiddle);
        group.addShape(firefliesRight);

        group.calculateBounds();
        image.sample(new Raytracer(camera, group, 32), 64);

        // Write the images to disk
        final String filename = "doc/test.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
