package cgtools;

import cgg.cgobjects.Transformation;

/**
 * @author Florian Kate
 * Date 2022-01-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class Texture implements Sampler {
    private ImageTexture texture;
    private Matrix transformation;
    int width;
    int height;

    public Texture(String filename) {
        this.texture = new ImageTexture(filename);
        this.transformation = Matrix.identity();
        this.width = texture.width;
        this.height = texture.height;
    }

    public Texture(String filename, Matrix transformation) {
        this.texture = new ImageTexture(filename);
        this.transformation = transformation;
        this.width = texture.width;
        this.height = texture.height;
    }

    public Color getColor(double u, double v) {
        Point p = Matrix.multiply(transformation, Vector.point(u, v, 0));
        u = p.x - Math.floor(p.x);
        v = p.y - Math.floor(p.y);
        double r = Math.pow(texture.getColor(u, v).r, 2.2);
        double g = Math.pow(texture.getColor(u, v).g, 2.2);
        double b = Math.pow(texture.getColor(u, v).b, 2.2);
        return new Color(r, g, b);
    }

    public int getRecursionDepth() {
        return 0;
    }
}
