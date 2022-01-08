package cgtools;

/**
 * @author Florian Kate
 * Date 2022-01-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class PolkaDotsTexture implements Sampler {
    private double radius;
    private Matrix transformation;
    private Color dotColor;
    private Color backgroundColor;

    public PolkaDotsTexture(double radius, Color dotColor, Color backgroundColor) {
        this.radius = radius;
        this.transformation = Matrix.identity();
        this.dotColor = dotColor;
        this.backgroundColor = backgroundColor;
    }

    public PolkaDotsTexture(double radius, Matrix transformation, Color dotColor, Color backgroundColor) {
        this.radius = radius;
        this.transformation = transformation;
        this.dotColor = dotColor;
        this.backgroundColor = backgroundColor;
    }

    public Color getColor(double u, double v) {
        Point p = Matrix.multiply(transformation, Vector.point(u, v, 0));
        double ui = p.x - Math.floor(p.x + 0.5);
        double vi = p.y - Math.floor(p.y + 0.5);
        if ((ui * ui) + (vi * vi) > (radius * radius)) {
            return backgroundColor;
        }
        return dotColor;
    }

    public int getRecursionDepth() {
        return 0;
    }
}