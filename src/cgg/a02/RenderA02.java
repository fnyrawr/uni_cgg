package cgg.a02;

/**
 * @author Florian Kate
 * Date 2021-10-07
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

import cgg.Image;
import cgtools.Color;

public class RenderA02 {
    public static void RenderA02(int width, int height, int countDiscs, Color colorStart, Color colorEnd) {
        // Create image and sample colored discs
        Image coloredDiscs = new Image(width, height, 2.2);
        coloredDiscs.sample(new ColoredDiscs(width, height, countDiscs, colorStart, colorEnd), 0);
        Image coloredDiscsSupersampling = new Image(width, height, 2.2);
        coloredDiscsSupersampling.sample(new ColoredDiscs(width, height, countDiscs, colorStart, colorEnd), 128);

        // Write the images to disk
        final String filenameDisks = "doc/a02-discs.png";
        coloredDiscs.write(filenameDisks);
        System.out.println("Wrote image: " + filenameDisks);

        // Write the images to disk
        final String filenameDiscsSupersampling = "doc/a02-discs-supersampling.png";
        coloredDiscsSupersampling.write(filenameDiscsSupersampling);
        System.out.println("Wrote image: " + filenameDiscsSupersampling);
    }
}
