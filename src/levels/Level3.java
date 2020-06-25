//author 208783522

package levels;

import geometryprimitives.Point;
import management.LevelInformation;
import sprites.Block;
import sprites.Sprite;
import sprites.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 * Represents the third level in the game.
 */
public class Level3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsInitVelocities = new ArrayList<>();
        ballsInitVelocities.add(new Velocity(-2, -2));
        ballsInitVelocities.add(new Velocity(2, -2));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Background3();
    }

    @Override
    public List<Block> blocks() {
        List<Block> pattern = new ArrayList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10 - i; j++) {
                pattern.add(new Block(new geometryprimitives.Rectangle(new Point(375
                        + (j * 40) + (i * 40), 200 + (i * 20)),
                        40, 20), colors[i]));
            }
        }

        return pattern;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
