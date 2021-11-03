package cgg;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

// Constructive Solid Geometry nachschauen

import cgtools.*;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Image {
    private double[] data;
    private int width;
    private int height;
    private double gamma;

    public Image(int width, int height, double gamma) {
        // 1 dimensional array | size=W*H*C | C=3 components for RGB
        int size = width * height * 3;
        data = new double[size];
        this.width = width;
        this.height = height;
        this.gamma = gamma;
        // init with 0 for black background
        for (double pixel : data) {
            pixel = 0;
        }
    }

    public void setPixel(int x, int y, Color color) {
        // get pixel index | i(x,y) = C(y*width+x)+Offset | C=3 components for RGB
        int index = 3 * (y * width + x);
        // set colors for pixel | red: index+0 | green: index+1 | blue: index+2
        data[index] = Math.pow(color.r, 1 / gamma);
        data[index + 1] = Math.pow(color.g, 1 / gamma);
        data[index + 2] = Math.pow(color.b, 1 / gamma);
    }

    public void write(String filename) {
        ImageWriter.write(filename, data, width, height);
    }

    // Sets the color for one particular pixel in each image - sampling in multithreading
    public void sample(Sampler s, int n) {
        // get start time
        long startTime = System.nanoTime();
        // Pool creation, use all available processors for sampling
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        // pixel array for calculation
        ArrayList<Future<Color>> pixels = new ArrayList<Future<Color>>();
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != height; y++) {
                final int fx = x;
                final int fy = y;
                Callable<Color> calculateOnePixel = () -> {
                    Color color = getPixelColor(s, fx, fy, n);
                    return color;
                };
                Future<Color> pixel = pool.submit(calculateOnePixel);
                pixels.add(pixel);
            }
        }

        // collect calculated results
        int z = 0;
        double pixelsTotal = width*height;
        System.out.println(String.format("Rendering %d x %d image with recursionDepth %d and %dx antialiasing settings",
                width, height, s.getRecursionDepth(), n));
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != height; y++) {
                try {
                    // print runtime status to see current progress
                    double percentage = z*100/pixelsTotal;
                    long runningTime = (System.nanoTime()-startTime)/1000000000;
                    long expectedTime = Math.round(runningTime*100/percentage);
                    long remainingTime = expectedTime-runningTime;
                    int runMin = (int) runningTime/60;
                    int runSec = (int) runningTime % 60;
                    int expMin = (int) expectedTime/60;
                    int expSec = (int) expectedTime % 60;
                    int remMin = (int) remainingTime/60;
                    int remSec = (int) remainingTime % 60;
                    System.out.print(String.format("\r%.2f%% done | %d:%02d running | %d:%02d remaining | %d:%02d expected",
                            percentage, runMin, runSec, remMin, remSec, expMin, expSec));

                    setPixel(x, y, pixels.get(z).get());
                    z++;
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
            }
        }
        // get end time
        long endTime = System.nanoTime();
        long totalTime = (endTime-startTime)/1000000000;
        int runMin = (int) totalTime/60;
        int runSec = (int) totalTime % 60;
        System.out.print(String.format("\rrendering completed in %d:%02d \n\n", runMin, runSec));
        pool.shutdown();
    }

    private Color getPixelColor (Sampler s,double x, double y, int n){
        Color color = new Color(.0, .0, .0);

        // Antialiasing with n subpixels
        if (n > 0) {
            for (int xi = 0; xi < n; xi++) {
                for (int yi = 0; yi < n; yi++) {
                    double rx = cgtools.Random.random();
                    double ry = cgtools.Random.random();
                    double xs = x + (xi + rx) / n;
                    double ys = y + (yi + ry) / n;
                    color = Color.add(color, s.getColor(xs, ys));
                }
            }
            color = Color.divide(color, n * n);
            return color;
        }
        // no antialiasing
        color = s.getColor(x, y);
        return color;
    }
}
