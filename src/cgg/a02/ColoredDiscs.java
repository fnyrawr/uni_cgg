package cgg.a02;

import java.util.ArrayList;
import cgtools.*;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class ColoredDiscs implements Sampler {
    protected ArrayList<Disc> discs;

    public ColoredDiscs(int width, int height, int n, Color color1, Color color2) {
        // generate random list with discs, sort descending
        discs = new ArrayList<Disc>();
        Color color;
        for(int i=0; i<n; i++) {
            color = Color.add(color1, Color.multiply(cgtools.Random.random(), Color.subtract(color2, color1)));
            discs.add(new Disc(cgtools.Random.random()*width, cgtools.Random.random()*height, cgtools.Random.random()*height/4, color));
        }
        sortDiscList();
    }

    private void sortDiscList() {
        discs.sort((Disc disc1, Disc disc2) -> (Double.compare(disc1.getRadius(), disc2.getRadius())));
    }

    public Color getColor(double x, double y) {
        for(Disc disc: discs) {
            if(disc.isPointInDisc(x,y)) {
                return disc.getColor();
            }
        }
        return Color.black;
    }

    public int getRecursionDepth() {
        return 0;
    }
}
