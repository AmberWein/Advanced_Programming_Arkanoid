//author 208783522

package management;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 * Decorator-class that will wrap an existing animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyBoard;
    private String key;
    private Animation decoratedAnimation;
    private boolean stop;
    private boolean isAlreadyPressed;


    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    a keyboard sensor.
     * @param key       the key.
     * @param animation the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyBoard = sensor;
        this.key = key;
        this.decoratedAnimation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.decoratedAnimation.doOneFrame(d);
            // check if the key button is unpressed
            if (!this.keyBoard.isPressed(this.key)) {
                this.isAlreadyPressed = false;
            }
        }

    @Override
    public boolean shouldStop() {
        return ((this.keyBoard.isPressed(key) && !this.isAlreadyPressed) || this.decoratedAnimation.shouldStop());
    }
}
