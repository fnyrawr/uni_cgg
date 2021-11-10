/** @author Florian Kate, 923081 */
package cgtools;

import cgg.cgobjects.Hit;
import cgg.cgobjects.Ray;

// A Sampler is something that can return hitpoint if a ray intersects it.
public interface Shape {
    public Hit intersect(Ray r);
    public BoundingBox bounds();
    public BoundingBox calculateBounds();
}
