package cgtools;

public interface Light {
    public Color incomingIntensity(Point hit, Direction normal, Shape scene);
}
