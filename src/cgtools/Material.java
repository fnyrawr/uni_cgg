package cgtools;

import cgg.cgobjects.*;

public interface Material {
    // Material describes diffusion and color intensity

    public Color getEmmission();
    public Color getAlbedo(Ray ray, Hit hit);
    public Ray getSecondaryRay();
}
