//author 208783522

package tasks;

import biuoop.KeyboardSensor;
import management.Animation;
import management.AnimationRunner;
import management.KeyPressStoppableAnimation;

/**
 * The type Show hi scores task.
 */
public class ShowHighScoresTask implements Task {
    private AnimationRunner runner;
    private Animation animation;

    /**
     * Instantiates a new Show hi scores task.
     *
     * @param newRunner        the new runner animation
     * @param newHighScoreAnimation the new menu animation
     */
    public ShowHighScoresTask(AnimationRunner newRunner, Animation newHighScoreAnimation) {
        this.runner = newRunner;
        this.animation = newHighScoreAnimation;
    }

    @Override
    public Void run() {
        KeyPressStoppableAnimation keyPressStoppableAnimation =
                new KeyPressStoppableAnimation(this.runner.getKeyBoard(),
                        KeyboardSensor.SPACE_KEY, this.animation);
        this.runner.run(keyPressStoppableAnimation);
        return null;
    }
}
