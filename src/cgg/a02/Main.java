package cgg.a02;

import cgg.Image;
import cgg.a01.ConstantColor;
import cgg.a01.Disc;
import cgg.a01.Polkadots;
import cgg.a01.RenderA01;

import static cgtools.Color.*;
import static cgtools.Color.yellow;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class Main {

    public static void main(String[] args) {
        final int width = 480;
        final int height = 270;

        // This class instance defines the contents of the images.
        ColoredDiscs contentDiscs = new ColoredDiscs(width, height, 50, red, yellow);

        // Creates images and iterates over all pixel positions inside the images
        Image coloredDiscs = new Image(width, height);
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != height; y++) {
                // Sets the color for one particular pixel in each image
                coloredDiscs.setPixel(x,y, contentDiscs.getColor(x, y));
            }
        }

        // Write the images to disk
        final String filename = "doc/a02-discs.png";
        coloredDiscs.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
