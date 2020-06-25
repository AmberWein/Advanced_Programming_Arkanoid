//author 208783522

package management;

import geometryprimitives.Line;
import geometryprimitives.Point;
import sprites.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 * holds a list of Collidable objects.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Instantiates a new Game environment.
     * Creates a new game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * Add collidable.
     * Add the given collidable to the environment.
     *
     * @param c collidable object that will be added
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Remove collidable boolean.
     * Remove the given collidable to the environment.
     *
     * @param c The collidable that will be removed.
     * @return True if removed, false otherwise.
     */
    public boolean removeCollidable(Collidable c) {
        return this.collidables.remove(c);
    }

    /**
     * Gets closest collision CollisionInfo.
     *
     * @param trajectory the trajectory of an object
     * @return If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // a loop to find the closest collision if existed
        CollisionInfo cInfo = null;
        for (Collidable c : collidables) {
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collisionPoint != null) {
                double cPoint = collisionPoint.distance(trajectory.start());
                if (cInfo == null || cInfo.collisionPoint().distance(trajectory.start()) > cPoint) {
                    cInfo = new CollisionInfo(collisionPoint, c);
                }
            }
        }
        return cInfo;
    }
}

