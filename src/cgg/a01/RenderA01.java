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
        // Creates images and iterates over all pixel positions inside the images
        Image image = new Image(width, height, 2.2);
        image.sample(new ConstantColor(constBG), 0);
        Image disc = new Image(width, height, 2.2);
        disc.sample(new Disc(width, height,height/2, discFG), 16);
        Image dots = new Image(width, height, 2.2);
        dots.sample(new Polkadots(width, height,countX,countY, height/(countY+2), pDotStart, pDotEnd), 16);

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
