package cgg.a06;

import cgg.cgobjects.*;
import cgtools.*;

public class DebugOutputs {
    public static void glassTests() {
        // debug outputs
        GlassMaterial glass = new GlassMaterial(Color.lightgray);

        // test reflect
        Direction debugDirection;
        Direction d = Vector.direction(0.0, 0.0, 0.0);
        Direction n = Vector.direction(0.0, 1.0, 0.0);
        debugDirection = glass.reflect(d, n);
        System.out.println("reflect("+d+","+n+") | expected 0.0, 0.0, 0.0 | calculated "+debugDirection.toString());

        d = Vector.direction(0.707, -0.707, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        debugDirection = glass.reflect(d, n);
        System.out.println("reflect("+d+","+n+") | expected 0.707, 0.707, 0.0 | calculated "+debugDirection.toString());

        d = Vector.direction(0.707, 0.707, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        debugDirection = glass.reflect(d, n);
        System.out.println("reflect("+d+","+n+") | expected 0.707, -0.707, 0.0 | calculated "+debugDirection.toString());
        System.out.println();

        // test schlick
        d = Vector.direction(0.707, 0.707, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        double n1 = 1.0;
        double n2 = 1.5;
        double rPhi = glass.schlick(d, n, n1, n2);
        System.out.println("schlick("+d+","+n+","+n1+","+n2+") | expected 13.9579 | calculated "+rPhi);

        d = Vector.direction(0.707, 0.707, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.5;
        n2 = 1.0;
        rPhi = glass.schlick(d, n, n1, n2);
        System.out.println("schlick("+d+","+n+","+n1+","+n2+") | expected 13.9579 | calculated "+rPhi);

        d = Vector.direction(0.995, -0.1, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.0;
        n2 = 1.5;
        rPhi = glass.schlick(d, n, n1, n2);
        System.out.println("schlick("+d+","+n+","+n1+","+n2+") | expected 0.608435 | calculated "+rPhi);

        d = Vector.direction(0.995, -0.1, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.5;
        n2 = 1.0;
        rPhi = glass.schlick(d, n, n1, n2);
        System.out.println("schlick("+d+","+n+","+n1+","+n2+") | expected 0.608435 | calculated "+rPhi);
        System.out.println();

        // test refract
        d = Vector.direction(0.707, 0.707, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.0;
        n2 = 1.5;
        debugDirection = glass.refract(d, n, n1, n2);
        System.out.println("refract("+d+","+n+","+n1+","+n2+") | expected 0.471, -0.882, 0.0 | calculated "+debugDirection);

        d = Vector.direction(0.707, 0.707, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.5;
        n2 = 1.0;
        debugDirection = glass.refract(d, n, n1, n2);
        System.out.println("refract("+d+","+n+","+n1+","+n2+") | expected null | calculated "+debugDirection);

        d = Vector.direction(0.995, -0.1, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.0;
        n2 = 1.5;
        debugDirection = glass.refract(d, n, n1, n2);
        System.out.println("refract("+d+","+n+","+n1+","+n2+") | expected 0.663, -0.748, 0.0 | calculated "+debugDirection);

        d = Vector.direction(0.995, -0.1, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.5;
        n2 = 1.0;
        debugDirection = glass.refract(d, n, n1, n2);
        System.out.println("refract("+d+","+n+","+n1+","+n2+") | expected null | calculated "+debugDirection);

        d = Vector.direction(0.1, -0.995, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.0;
        n2 = 1.5;
        debugDirection = glass.refract(d, n, n1, n2);
        System.out.println("refract("+d+","+n+","+n1+","+n2+") | expected 0.066, -0.998, 0.0 | calculated "+debugDirection);

        d = Vector.direction(0.1, -0.995, 0.0);
        n = Vector.direction(0.0, 1.0, 0.0);
        n1 = 1.5;
        n2 = 1.0;
        debugDirection = glass.refract(d, n, n1, n2);
        System.out.println("refract("+d+","+n+","+n1+","+n2+") | expected 0.149, -0.989, 0.0 | calculated "+debugDirection);
    }
}
