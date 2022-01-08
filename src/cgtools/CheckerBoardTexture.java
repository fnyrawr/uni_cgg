package cgtools;

public class CheckerBoardTexture implements Sampler {
    protected int n;
    public CheckerBoardTexture(int n) {
        this.n = n;
    }

    public Color getColor(double u, double v) {
        double ui = (int) ((u % 1) * n);
        double vi = (int) ((v % 1) * n);
        if((ui + vi) % 2 == 0) return new Color(1,1,1);
        return new Color(0,0,0);
    }

    public int getRecursionDepth() {
        return 0;
    }
}
