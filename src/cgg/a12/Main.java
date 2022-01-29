package cgg.a12;

/**
 * @author Florian Kate
 * Date 2022-01-27
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgg.cgobjects.*;
import cgtools.*;

public class Main {
    public static void main(String[] args) {

        final int width = 1920;
        final int height = 1080;

        // Create an image, a new camera and a group for the image
        Image image = new Image(width, height, 2.2);

        CameraObscura camera = new CameraObscura(Math.PI/2, Vector.point(0,0,0), Matrix.identity(), width, height);
        Group group = new Group();

        // textures
        String skybox = "textures/skybox.jpg";
        String grass = "textures/grassTexture.jpg";
        String water = "textures/waterTexture.png";
        String gravel = "textures/gravelTexture.jpg";
        String planks = "textures/plankTexture.jpg";
        String tatami = "textures/tatamiTexture.jpg";
        String paper = "textures/paperTexture.jpg";

        // Group planes with bounding box
        group.addShape(new Background(new Texture(skybox, Matrix.scaling(2, 3, 3))));
        group.addShape(new PlaneWinnerRadius(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 25, 5,
                new MirroringMaterial(new Texture(water, Matrix.scaling(15, 15, 15)))));
        group.addShape(new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0,1,0), 5,
                new DiffuseMaterial(new Texture(grass, Matrix.scaling(15, 15, 15)))));

        // door frame and upper part
        Group doorFrame = new Group();
        doorFrame.addShape(new Rectangle(Vector.point(0.0, 0.5, -1.5), 3.5, 0.1, 0.05,
                new DiffuseMaterial(new Texture(planks))));
        doorFrame.addShape(new Rectangle(Vector.point(0.0, 1.0, -1.5), 0.1, 0.9, 0.05,
                new DiffuseMaterial(new Texture(planks, Matrix.rotation(Vector.direction(0.0, 0.0, 1.0), 90)))));
        doorFrame.addShape(new Rectangle(Vector.point(0.0, 1.0, -1.5), 3.5, 0.9, 0.005,
                new DiffuseMaterial(new Texture(paper))));
        doorFrame.addShape(new Rectangle(Vector.point(-0.8125, 1.0, -1.5), 0.025, 0.9, 0.025,
                new DiffuseMaterial(new Texture(planks, Matrix.rotation(Vector.direction(0.0, 0.0, 1.0), 90)))));
        doorFrame.addShape(new Rectangle(Vector.point(0.8125, 1.0, -1.5), 0.025, 0.9, 0.025,
                new DiffuseMaterial(new Texture(planks, Matrix.rotation(Vector.direction(0.0, 0.0, 1.0), 90)))));
        doorFrame.addShape(new Rectangle(Vector.point(0.0, 0.6, -1.5), 3.5, 0.0125, 0.0125,
                new DiffuseMaterial(new Texture(planks))));
        doorFrame.addShape(new Rectangle(Vector.point(0.0, 0.8, -1.5), 3.5, 0.0125, 0.0125,
                new DiffuseMaterial(new Texture(planks))));
        int n = 60;
        for(int i = 0; i<n; i++) {
            doorFrame.addShape(new Rectangle(Vector.point(-3.5/2+i*3.5/n, 1.0, -1.5), 0.0125, 0.9, 0.0125,
                    new DiffuseMaterial(new Texture(planks))));
        }
        group.addShape(doorFrame);

        // left shoji door
        Group leftDoor = new Group();
        leftDoor.addShape(new Rectangle(Vector.point(-1.25, -0.45, -1.5), 0.85, 0.025, 0.025,
                new DiffuseMaterial(new Texture(planks))));
        leftDoor.addShape(new Rectangle(Vector.point(-0.8125, 0.0, -1.5), 0.025, 0.925, 0.025,
                new DiffuseMaterial(new Texture(planks, Matrix.rotation(Vector.direction(0.0, 0.0, 1.0), 90)))));
        leftDoor.addShape(new Rectangle(Vector.point(-1.25, -0.25, -1.5), 0.85, 0.025, 0.025,
                new DiffuseMaterial(new Texture(planks))));
        leftDoor.addShape(new Rectangle(Vector.point(-1.25, 0.435, -1.5), 0.85, 0.025, 0.025,
                new DiffuseMaterial(new Texture(planks))));
        n = 5;
        for(int i = 1; i<n; i++) {
            leftDoor.addShape(new Rectangle(Vector.point(-1.25, -0.25+i*0.685/n, -1.5), 0.85, 0.0125, 0.0125,
                    new DiffuseMaterial(new Texture(planks))));
        }
        n = 9;
        for(int i = 1; i<n; i++) {
            leftDoor.addShape(new Rectangle(Vector.point(-0.8-i*0.75/n, 0.085, -1.5), 0.0125, 0.685, 0.0125,
                    new DiffuseMaterial(new Texture(planks))));
        }
        leftDoor.addShape(new Rectangle(Vector.point(-1.25, 0.0, -1.5), 0.85, 0.9, 0.005, new DiffuseMaterial(new Texture(paper))));
        group.addShape(leftDoor);

        // right shoji door
        Group rightDoor = new Group();
        rightDoor.addShape(new Rectangle(Vector.point(1.25, -0.45, -1.5), 0.85, 0.025, 0.025,
                new DiffuseMaterial(new Texture(planks))));
        rightDoor.addShape(new Rectangle(Vector.point(0.8125, 0.0, -1.5), 0.025, 0.925, 0.025,
                new DiffuseMaterial(new Texture(planks, Matrix.rotation(Vector.direction(0.0, 0.0, 1.0), 90)))));
        rightDoor.addShape(new Rectangle(Vector.point(1.25, -0.25, -1.5), 0.85, 0.025, 0.025,
                new DiffuseMaterial(new Texture(planks))));
        rightDoor.addShape(new Rectangle(Vector.point(1.25, 0.435, -1.5), 0.85, 0.025, 0.025,
                new DiffuseMaterial(new Texture(planks))));
        n = 5;
        for(int i = 1; i<n; i++) {
            rightDoor.addShape(new Rectangle(Vector.point(1.25, -0.25+i*0.685/n, -1.5), 0.85, 0.0125, 0.0125,
                    new DiffuseMaterial(new Texture(planks))));
        }
        n = 9;
        for(int i = 1; i<n; i++) {
            rightDoor.addShape(new Rectangle(Vector.point(0.8+i*0.75/n, 0.085, -1.5), 0.0125, 0.685, 0.0125,
                    new DiffuseMaterial(new Texture(planks))));
        }
        rightDoor.addShape(new Rectangle(Vector.point(1.25, 0.0, -1.5), 0.85, 0.9, 0.005, new DiffuseMaterial(new Texture(paper))));
        group.addShape(rightDoor);

        // veranda
        Group veranda = new Group();
        n = 25;
        for(int i = 0; i<n; i++) {
            veranda.addShape(new Rectangle(Vector.point(-3.5/2+i*3.5/n, -0.475, -1.75), 3.5/n, 0.05, 0.5,
                    new DiffuseMaterial(new Texture(planks))));
        }
        group.addShape(veranda);

        // tatami
        Group tatamiFloor = new Group();
        tatamiFloor.addShape(new Rectangle(Vector.point(0, -0.475, -0.75), 1.5, 0.05, 1.5,
                new DiffuseMaterial(new Texture(tatami, Matrix.rotation(Vector.direction(0.0, 0.0, 1.0), 90)))));
        tatamiFloor.addShape(new Rectangle(Vector.point(-1.5, -0.475, -0.75), 1.5, 0.05, 1.5,
                new DiffuseMaterial(new Texture(tatami))));
        tatamiFloor.addShape(new Rectangle(Vector.point(1.5, -0.475, -0.75), 1.5, 0.05, 1.5,
                new DiffuseMaterial(new Texture(tatami))));
        group.addShape(tatamiFloor);

        group.addShape(createTorii(Vector.point(0.0, -0.5, -2.5)));

        // create foliage on the outside
        Group treesLeft = new Group();
        Group treesRight = new Group();
            treesLeft.addShape(createTree(Vector.point(-1.125,-0.5,-2.25)));
            treesRight.addShape(createTree(Vector.point(1.125,-0.5,-2.25)));
            treesLeft.addShape(createTree(Vector.point(-1.125,-0.5,-3.0)));
            treesRight.addShape(createTree(Vector.point(1.125,-0.5,-3.0)));
            treesLeft.addShape(createTree(Vector.point(-1.125,-0.5,-3.75)));
            treesRight.addShape(createTree(Vector.point(1.125,-0.5,-3.75)));
        group.addShape(treesLeft);
        group.addShape(treesRight);
        Group bushesLeft = new Group();
        Group bushesRight = new Group();
            bushesLeft.addShape(new Sphere(Vector.point(-0.75, -0.5, -2.5), 0.125, new DiffuseMaterial(new Texture(grass))));
            bushesLeft.addShape(new Sphere(Vector.point(-0.75, -0.5, -3.25), 0.125, new DiffuseMaterial(new Texture(grass))));
            bushesRight.addShape(new Sphere(Vector.point(0.75, -0.5, -2.5), 0.125, new DiffuseMaterial(new Texture(grass))));
            bushesRight.addShape(new Sphere(Vector.point(0.75, -0.5, -3.25), 0.125, new DiffuseMaterial(new Texture(grass))));
        group.addShape(bushesLeft);
        group.addShape(bushesRight);
        group.addShape(new RectPlane(Vector.point(0.0, -0.499, -2.75), Vector.direction(0.0, 1.0, 0.0),
                0.5, 2.5, new DiffuseMaterial(new Texture(gravel, Matrix.scaling(4, 1, 3)))));

        // cat statue
        group.addShape(createCat(Vector.point(-0.9, -0.425, -1.35)));
        group.addShape(createCat(Vector.point(0.9, -0.425, -1.35)));

        // create world with scene and lights
        World world = new World(group);
        world.addLight(new PointLight(Vector.point(5.0, 9.0, -9.0), Color.lightgray, 15.0));
        image.sample(new Raytracer(camera, world, 32), 64);

        // Write the images to disk
        final String filename = "doc/cgg-competition-ws-21-923081.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }

    public static Group createTorii(Point point) {
        Group torii = new Group();
        String toriiTexture = "textures/concreteTexture.jpg";
        Matrix scaling = Matrix.scaling(5, 5, 5);
        // vertical beams
        torii.addShape(new Cylinder(Vector.point(point.x-0.4, point.y, point.z), 0.045, 0.75, new DiffuseMaterial(new Texture(toriiTexture, scaling))));
        torii.addShape(new Cylinder(Vector.point(point.x+0.4, point.y, point.z), 0.045, 0.75, new DiffuseMaterial(new Texture(toriiTexture, scaling))));
        // horizontal beams
        Group horizontalBeams = new Group(Matrix.rotation(Vector.direction(0, 0, 1), 90));
        horizontalBeams.addShape(new Cylinder(Vector.point(point.x-0.225, point.y-0.1, point.z), 0.05, 1.2, new DiffuseMaterial(new Texture(toriiTexture, scaling))));
        horizontalBeams.addShape(new Cylinder(Vector.point(point.x-0.05, point.y, point.z), 0.05, 1, new DiffuseMaterial(new Texture(toriiTexture, scaling))));
        torii.addShape(horizontalBeams);
        return torii;
    }

    public static Group createTree(Point point) {
        Group tree = new Group();
        String leavesTexture = "textures/leavesTexture.jpg";
        String woodTexture = "textures/woodTexture.jpg";
        Matrix scalingLeaves = Matrix.scaling(5,5,5);
        tree.addShape(new Cylinder(point, 0.075, 0.4, new DiffuseMaterial(new Texture(woodTexture, scalingLeaves))));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.5, 0)), 0.25, new DiffuseMaterial(new Texture(leavesTexture, scalingLeaves))));
        tree.addShape(new Sphere(Vector.add(point, Vector.direction(0, 0.65, 0)), 0.175, new DiffuseMaterial(new Texture(leavesTexture, scalingLeaves))));
        return tree;
    }

    public static Group createCat(Point point) {
        Group cat = new Group();
        String concrete = "textures/concreteTexture.jpg";
        // body
        cat.addShape(new Sphere(Vector.point(point.x, point.y+0.037, point.z), 0.075, new DiffuseMaterial(new Texture(concrete))));
        cat.addShape(new Sphere(Vector.point(point.x, point.y+0.1, point.z), 0.06, new DiffuseMaterial(new Texture(concrete))));
        // eyes
        cat.addShape(new Sphere(Vector.point(point.x-0.018, point.y+0.13, point.z+0.045), 0.0075, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x-0.018, point.y+0.1305, point.z+0.0495), 0.0035, new DiffuseMaterial(Color.lightgray)));
        cat.addShape(new Sphere(Vector.point(point.x+0.018, point.y+0.13, point.z+0.045), 0.0075, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x+0.018, point.y+0.1305, point.z+0.0495), 0.0035, new DiffuseMaterial(Color.lightgray)));
        // nose
        cat.addShape(new Sphere(Vector.point(point.x, point.y+0.12, point.z+0.05), 0.0075, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x-0.0045, point.y+0.117, point.z+0.053), 0.005, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x+0.0045, point.y+0.117, point.z+0.053), 0.005, new DiffuseMaterial(Color.black)));
        // ears
        cat.addShape(new Sphere(Vector.point(point.x-0.0325, point.y+0.1425, point.z+0.01), 0.015, new DiffuseMaterial(new Texture(concrete))));
        cat.addShape(new Sphere(Vector.point(point.x-0.0325, point.y+0.143, point.z+0.0116), 0.0135, new DiffuseMaterial(Color.black)));
        cat.addShape(new Sphere(Vector.point(point.x+0.0325, point.y+0.1425, point.z+0.01), 0.015, new DiffuseMaterial(new Texture(concrete))));
        cat.addShape(new Sphere(Vector.point(point.x+0.0325, point.y+0.143, point.z+0.0116), 0.0135, new DiffuseMaterial(Color.black)));
        return cat;
    }
}
