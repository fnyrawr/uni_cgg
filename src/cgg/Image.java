package cgg;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgtools.*;

public class Image {
  private double[] data;
  private int width;
  private int height;
  private double gamma;

  public Image(int width, int height, double gamma) {
    // 1 dimensional array | size=W*H*C | C=3 components for RGB
    int size = width*height*3;
    data = new double[size];
    this.width = width;
    this.height = height;
    this.gamma = gamma;
    // init with 0 for black background
    for (double pixel: data) {
      pixel = 0;
    }
  }

  public void setPixel(int x, int y, Color color) {
    // get pixel index | i(x,y) = C(y*width+x)+Offset | C=3 components for RGB
    int index = 3*(y*width+x);
    // set colors for pixel | red: index+0 | green: index+1 | blue: index+2
    data[index] = Math.pow(color.r, 1/gamma);
    data[index+1] = Math.pow(color.g, 1/gamma);
    data[index+2] = Math.pow(color.b, 1/gamma);
  }

  public void write(String filename) {
    ImageWriter.write(filename, data, width, height);
  }

  public void sample(Sampler s, int stratSamplingN) {
    // Sets the color for one particular pixel in each image
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        if (stratSamplingN > 0) {
          setPixel(x, y, getStratifiedSampling(s, x, y, stratSamplingN));
        }
        else {
          setPixel(x, y, s.getColor(x, y));
        }
      }
    }
  }

  private Color getStratifiedSampling(Sampler s, double x, double y, int n) {
    Color color = new Color(.0, .0, .0);

    for (int xi = 0; xi < n; xi++) {
      for (int yi = 0; yi < n; yi++) {
        double rx = cgtools.Random.random();
        double ry = cgtools.Random.random();
        double xs = x + (xi + rx)/n;
        double ys = y + (yi + ry)/n;
        color = Color.add(color, s.getColor(xs, ys));
      }
    }
    return Color.divide(color,n*n);
  }
}
