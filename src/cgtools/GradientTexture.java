package cgtools;

/**
 * @author Florian Kate
 * Date 2022-01-08
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class GradientTexture implements Sampler {
    private Color color1;
    private Color color2;

    public GradientTexture(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    public Color getColor(double u, double v) {
        // horizontal gradient depends only on u
        double w = 2*u;
        if(w > 1) w = 2-2*u;
        return Color.add(color1, Color.multiply(w, Color.subtract(color2, color1)));
    }

    public int getRecursionDepth() {
        return 0;
    }
}
