//author 208783522

package levels;

import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import management.LevelInformation;
import sprites.Block;
import sprites.Sprite;
import sprites.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 * Represents the first level in the game.
 */

public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsInitVelocities = new ArrayList<>();
        ballsInitVelocities.add(new Velocity(0, -2));
        return ballsInitVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 480;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Background1();
    }

    @Override
    public List<Block> blocks() {
        List<Block> pattern = new ArrayList<>();
        pattern.add(new Block(new Rectangle(new Point(380, 200),
                40, 40), Color.RED));
        return pattern;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
