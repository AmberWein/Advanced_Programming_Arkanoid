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
 * The type Level 2.
 * Represents the second level in the game.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsInitVelocities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ballsInitVelocities.add(Velocity.fromAngleAndSpeed(-50 + (i * 10), 2));
            ballsInitVelocities.add(Velocity.fromAngleAndSpeed(10 + (i * 10), 2));
        }
        return ballsInitVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 240;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Background2();
    }

    @Override
    public List<Block> blocks() {
        List<Block> pattern = new ArrayList<>();
        Color red = Color.red;
        Color orange = new Color(255, 153, 0);
        Color yellow = new Color(255, 255, 0);
        Color green = Color.GREEN;
        Color blue = Color.BLUE;
        Color pink = new Color(255, 105, 180);
        Color cyan = Color.CYAN;
        Color[] colors = {red, red, orange, orange,
                yellow, yellow, green, green,
                green, blue, blue, pink,
                pink, cyan, cyan};
        // a loop to add all of the blocks in the current level to the list of blocks
        for (int i = 0; i < 15; i++) {
            pattern.add(new Block(new geometryprimitives.Rectangle(new Point(25 + (i * 50), 240),
                    50, 30), colors[i]));
        }

        return pattern;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
