//author 208783522

package management;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private int score;
    private KeyboardSensor keyBoard;
    private boolean hasWon;
    private boolean shouldStop;

    /**
     * Instantiates a new End screen.
     *
     * @param isWinning true if player won, false otherwise.
     * @param score     the total game score.
     * @param kb        a keyBoard.
     */
    public EndScreen(boolean isWinning, int score, KeyboardSensor kb) {
        this.hasWon = isWinning;
        this.keyBoard = kb;
        this.score = score;
        this.shouldStop = false;
    }

    /**
     * Get should stop boolean.
     *
     * @return true if the game runner should stop, false otherwise.
     */
    public boolean getShouldStop() {
        return this.shouldStop;
    }

    /**
     * Get score int.
     *
     * @return the total game score.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Set Has Won.
     * Sets the hasWon value by the input parameter.
     *
     * @param newHasWon true if player won, false otherwise.
     */
    public void setHasWon(boolean newHasWon) {
        this.hasWon = newHasWon;
    }

    /**
     * Set score int.
     * Sets the total game score.
     *
     * @param newScore a counter with a new score.
     */
    public void setScore(Counter newScore) {
        this.score = newScore.getValue();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        if (this.hasWon) {
            d.drawText(50, 200, "You Win! Your score is " + (this.getScore()), 40);
        } else {
            d.drawText(50, 200, "Game Over. Your score is " + (this.getScore()), 40);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.getShouldStop();
    }
}
