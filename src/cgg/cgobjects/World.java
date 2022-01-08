package cgg.cgobjects;

import cgtools.Light;

import java.util.ArrayList;

public class World {
    public final ArrayList<Light> lights;
    public final Group scene;

    public World(ArrayList<Light> lights, Group scene) {
        this.lights = lights;
        this.scene = scene;
    }
}
