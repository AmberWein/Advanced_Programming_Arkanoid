//author 208783522

package management;

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The type Countdown animation.
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numberOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Counter timeLeftInSeconds;
    private boolean shouldStop;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the number of seconds to count.
     * @param countFrom    The number to count from.
     * @param gameScreen   the game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numberOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timeLeftInSeconds = new Counter();
        this.shouldStop = false;
        this.timeLeftInSeconds.increase((int) this.numberOfSeconds);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        if (!this.shouldStop()) {
            d.setColor(new Color(102, 0, 0));
            d.drawText(365, 380, String.valueOf(this.timeLeftInSeconds.getValue()),
                    120);
            d.setColor(new Color(250, 0, 0));
            d.drawText(380, 380, String.valueOf(this.timeLeftInSeconds.getValue()),
                    80);
        }
        Sleeper sleeper = new Sleeper();
        sleeper.sleepFor(650);
        timeLeftInSeconds.decrease(1);
    }

    @Override
    public boolean shouldStop() {
        return this.timeLeftInSeconds.getValue() < 0;
    }
}
