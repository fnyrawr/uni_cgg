package cgg.cgobjects;

import cgtools.Light;

import java.util.ArrayList;

/**
 * @author Florian Kate
 * Date 2022-01-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class World {
    public final ArrayList<Light> lights;
    public final Group scene;

    public World(ArrayList<Light> lights, Group scene) {
        this.lights = lights;
        this.scene = scene;
    }

    public World(Group scene, ArrayList<Light> lights) {
        this.lights = lights;
        this.scene = scene;
    }

    public World(Group scene) {
        this.lights = new ArrayList<Light>();
        this.scene = scene;
    }

    public void addLight(Light light) {
        lights.add(light);
    }
}
