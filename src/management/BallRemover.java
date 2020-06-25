//author 208783522

package management;

import driver.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * The type Ball remover.
 * Is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter removedBalls;

    /**
     * Instantiates a new Block remover.
     *
     * @param newGame       the game
     * @param removedBlocks the removed blocks
     */
    public BallRemover(GameLevel newGame, Counter removedBlocks) {
        this.game = newGame;
        this.removedBalls = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        hitter.removeHitListener(this);
        this.removedBalls.decrease(1);
    }
}
