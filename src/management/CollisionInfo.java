//author 208783522

package management;

import geometryprimitives.Point;
import sprites.Collidable;

/**
 * The type Collision info.
 * Holds information about the collision that occur:
 * point and object
 */
public class CollisionInfo {
    private Collidable collisionObject;
    private Point collisionPoint;

    /**
     * Instantiates a new Collision info.
     *
     * @param newCollisionPoint  the new collision point
     * @param newCollisionObject the new collision object
     */
    public CollisionInfo(Point newCollisionPoint, Collidable newCollisionObject) {
        this.collisionPoint = newCollisionPoint;
        this.collisionObject = newCollisionObject;
    }

    /**
     * Gets collision point.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Gets collision object.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable getCollisionObject() {
        return this.collisionObject;
    }

    /**
     * Sets collision point.
     * Sets the point at which the collision occurs.
     *
     * @param newCollisionPoint the collision point
     */
    public void setCollisionPoint(Point newCollisionPoint) {
        this.collisionPoint = newCollisionPoint;
    }
}