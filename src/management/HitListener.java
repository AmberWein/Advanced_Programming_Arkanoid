//author 208783522

package management;

import sprites.Ball;
import sprites.Block;

/**
 * The interface Hit listener.
 * Represent a listener to a hit event.
 */
public interface HitListener {
    /**
     * Hit event.
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the block that being hit
     * @param hitter the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
