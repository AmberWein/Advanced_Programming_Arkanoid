//author 208783522

package management;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type High scores animation.
 */
public class HighScoresAnimation implements Animation {
    private Counter highScore;

    /**
     * Instantiates a new High scores animation.
     *
     * @param newHighScore the new high score
     */
    public HighScoresAnimation(Counter newHighScore) {
        this.highScore = newHighScore;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(100, 100, new String("High score: "), 30);
        d.setColor(Color.BLUE);
        d.drawText(200, 200, new String(Integer.toString(this.highScore.getValue())), 50);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
