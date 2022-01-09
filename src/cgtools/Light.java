package cgtools;

/**
 * @author Florian Kate
 * Date 2022-01-09
 * Student ID: 923081
 * E-Mail: s51541@bht-berlin.de
 */

public interface Light {
    public Color incomingIntensity(Point hit, Direction normal, Shape scene);
}
