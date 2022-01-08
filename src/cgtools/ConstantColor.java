package cgtools;

/**
 * @author Florian Kate
 * Date 2022-01-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class ConstantColor implements Sampler {
    private Color color;

    public ConstantColor(Color color) {
        this.color = color;
    }

    public Color getColor(double u, double v) {
        return color;
    }

    public int getRecursionDepth() {
        return 0;
    }
}
