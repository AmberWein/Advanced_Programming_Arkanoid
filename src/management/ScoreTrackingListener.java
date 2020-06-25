//author 208783522

package management;

import sprites.Ball;
import sprites.Block;

/**
 * The type Score tracking listener.
 * To update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Score tracking listener.
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * Hit event.
     * Called when a hit happens, adds hitPoint's value to the current score.
     *
     * @param beingHit the being hit block
     * @param hitter   the hitter ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(beingHit.getHitPoint());
    }
}
