//author 208783522

package management;

import java.util.List;

import sprites.Sprite;
import sprites.Velocity;
import sprites.Block;

/**
 * The interface Level information.
 * Specifies the information required to fully describe a level.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     * Returns the number of balls the level has.
     *
     * @return The number of balls the level has.
     */
    int numberOfBalls();

    /**
     * Initial Ball Velocity List<Velocity>.
     * The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return the initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     * Returns the paddle speed.
     * @return The paddle speed.
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     * Returns the paddle width.
     *
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * Level name String.
     * The level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    String levelName();

    /**
     * Get background Sprite.
     * Returns a sprite with the background of the level
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * Blocks List<Block>.
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return The Blocks that make up this level
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return The number of blocks that should be removed before the
     * level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}
