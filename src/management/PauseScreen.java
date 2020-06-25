//author 208783522

package management;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 * Display a screen with the message paused -- press space to continue until a key is pressed.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Create a new pause screen object, that will respond to a keyboard press.
     *
     * @param k a keyboard
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * An animation, that will display a screen with the message:
     * paused -- press space to continue until a key is pressed.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
