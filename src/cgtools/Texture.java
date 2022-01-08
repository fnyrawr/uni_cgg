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
        if(u > width) u = u - width;
        if(v > height) v = v - height;
        Point p = Matrix.multiply(transformation, Vector.point(u, v, 0));
        double r = Math.pow(texture.getColor(p.x, p.y).r, 2.2);
        double g = Math.pow(texture.getColor(p.x, p.y).g, 2.2);
        double b = Math.pow(texture.getColor(p.x, p.y).b, 2.2);
        return new Color(r, g, b);
    }

    public int getRecursionDepth() {
        return 0;
    }
}
