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
 * The type Level 4.
 * Represents the fourth level in the game.
 */
public class Level4 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsInitVelocities = new ArrayList<>();
        ballsInitVelocities.add(new Velocity(-3, -3));
        ballsInitVelocities.add(new Velocity(3, -3));
        ballsInitVelocities.add(new Velocity(0, -3));
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Background4();
    }

    @Override
    public List<Block> blocks() {
        List<Block> pattern = new ArrayList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN,
                Color.PINK, new Color(255, 105, 180), Color.CYAN};
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                pattern.add(new Block(new geometryprimitives.Rectangle(new Point(25 + (j * 50),
                        100 + (i * 25)), 50, 25), colors[i]));
            }
        }

        return pattern;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
