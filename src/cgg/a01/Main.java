package cgg.a01;

import static cgtools.Color.*;

import cgg.*;

public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;

    // ToDo: a01.disc.png | a01-polka-dots.png
    // This class instance defines the contents of the image.
    ConstantColor contentImage = new ConstantColor(gray);
    Disc contentDisc = new Disc(width, height,height/2, red);

    // Creates an image and iterates over all pixel positions inside the image.
    Image image = new Image(width, height);
    Image disc = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image.setPixel(x, y, contentImage.getColor(x, y));
        disc.setPixel(x,y, contentDisc.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename = "doc/a01-image.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);

    final String filenameDisc = "doc/a01-disc.png";
    disc.write(filenameDisc);
    System.out.println("Wrote image: " + filenameDisc);
  }
}
