package cgtools;

/**
 * @author Florian Kate
 * Date 2021-10-31
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.cgobjects.*;

public interface Material {
    // Material describes diffusion and color intensity

    public Color getEmmission();
    public Color getAlbedo();
    public Ray getSecondaryRay(Ray ray, Hit hit);
}