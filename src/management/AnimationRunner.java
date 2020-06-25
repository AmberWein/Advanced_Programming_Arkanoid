package management;

//author 208783522

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * The interface Animation runner.
 * Takes an Animation object and runs it.
 */
public class AnimationRunner {

    private GUI gui;
    private Sleeper sleeper;
    /**
     * The constant FRAMES_PER_SECOND.
     */
    public static final int FRAMES_PER_SECOND = 60;
    /**
     * The constant MILLI_SECONDS_PER_SECOND.
     */
    public static final int MILLI_SECONDS_PER_SECOND = 1000;

    /**
     * Creates a new animation runner.
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", 800, 600);
        this.sleeper = new Sleeper();
    }

    /**
     * Get gui GUI.
     *
     * @return the GUI to run.
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * Gets key board.
     *
     * @return the key board
     */
    public KeyboardSensor getKeyBoard() {
        return this.gui.getKeyboardSensor();
    }

    /**
     * Run.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = MILLI_SECONDS_PER_SECOND / FRAMES_PER_SECOND;
        // run the animation while it should not stop
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            // do one frame running
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}