package cgg.a01;

import cgg.Image;
import cgtools.*;

import static cgtools.Color.*;

/**
 * @author Florian Kate
 * Date 2021-10-06
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public class RenderA01 {
    public static void RenderA01(int width, int height, Color constBG, Color discFG, Color pDotStart, Color pDotEnd, int countX, int countY) {
        // This class instance defines the contents of the images.
        ConstantColor contentImage = new ConstantColor(constBG);
        Disc contentDisc = new Disc(width, height,height/2, discFG);
        Polkadots contentDots = new Polkadots(width, height,countX,countY, height/(countY+1), pDotStart, pDotEnd);

        // Creates images and iterates over all pixel positions inside the images
        Image image = new Image(width, height);
        Image disc = new Image(width, height);
        Image dots = new Image(width, height);
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != height; y++) {
                // Sets the color for one particular pixel in each image
                image.setPixel(x, y, contentImage.getColor(x, y));
                disc.setPixel(x,y, contentDisc.getColor(x, y));
                dots.setPixel(x,y, contentDots.getColor(x, y));
            }
        }

        // Write the images to disk
        final String filename = "doc/a01-image.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);

        final String filenameDisc = "doc/a01-disc.png";
        disc.write(filenameDisc);
        System.out.println("Wrote image: " + filenameDisc);

        final String filenameDots = "doc/a01-polka-dots.png";
        dots.write(filenameDots);
        System.out.println("Wrote image: " + filenameDots);
    }
}
