//author 208783522

package sprites;

import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

/**
 * The interface Collidable.
 * Represent a collidable object.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the "collision shape" of the object
     */
    Rectangle getCollisionRectangle();

    /**
     * Gets color.
     *
     * @return the color of the collision shape object
     */
    java.awt.Color getColor();

    /**
     * Hit velocity.
     *
     * @param hitter          a ball which hit the current collidable object
     * @param collisionPoint  a collision point with this object
     * @param currentVelocity a given velocity
     * @return The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us)
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Draw on.
     *
     * @param d a surface on which the object is draw on
     */
    void drawOn(DrawSurface d);
}
