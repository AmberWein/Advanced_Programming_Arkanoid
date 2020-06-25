//author 208783522

package management;

import biuoop.DrawSurface;
import driver.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The type Score indicator.
 * In charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;
    // adjusts the score indicator printing to be in the middle of the screen
    public static final int OFFSET = 20;

    /**
     * Score indicator.
     * Create a new score indicator.
     *
     * @param counter Score counter.
     */
    public ScoreIndicator(Counter counter) {
        this.scoreCounter = counter;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(204, 194, 193));
        d.fillRectangle(0, 0, d.getWidth(), 20);
        d.setColor(java.awt.Color.BLACK);
        d.drawText((d.getWidth() / 2) - OFFSET, 15, "Score: " + this.scoreCounter.getValue(),
                14);
    }

    @Override
    public void timePassed() {
        // do nothing
    }

    /**
     * Add to game.
     * Add sprite to game.
     *
     * @param g The game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
