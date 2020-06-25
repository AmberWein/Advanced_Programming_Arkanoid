//author 208783522

package management;

import driver.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * The type Block remover.
 * Is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 **/
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter removedBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param newGame       the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel newGame, Counter removedBlocks) {
        this.game = newGame;
        this.removedBlocks = removedBlocks;
    }

    /**
     * Hit event.
     * Blocks that are hit should be removed from the game.
     * Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit The block being hit.
     * @param hitter   the hitter ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
            beingHit.removeFromGame(this.game);
            beingHit.removeHitListener(this);
            this.removedBlocks.decrease(1);
    }
}
