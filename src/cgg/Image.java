package cgg;

/**
 * @author Florian Kate
 */

import cgtools.*;

public class Image {
  private double[] data;
  private int width;
  private int height;

  public Image(int width, int height) {
    // 1 dimensional array | size=W*H*C | C=3 components for RGB
    int size = width*height*3;
    data = new double[size];
    this.width = width;
    this.height = height;
    // init with 0 for black background
    for (double pixel: data) {
      pixel = 0;
    }
  }

  public void setPixel(int x, int y, Color color) {
    // get pixel index | i(x,y) = C(y*width+x)+Offset | C=3 components for RGB
    int index = 3*(y*width+x);
    // set colors for pixel | red: index+0 | green: index+1 | blue: index+2
    data[index] = color.r;
    data[index+1] = color.g;
    data[index+2] = color.b;
  }

  public void write(String filename) {
    ImageWriter.write(filename, data, width, height);
  }

  public void sample(Sampler s) {
    notYetImplemented();
  }

  private void notYetImplemented() {
    System.err.println("Please complete the implementation of class cgg.Image as part of assignment 1.");
    System.exit(1);
  }
}
