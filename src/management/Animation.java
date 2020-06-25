//author 208783522

package management;

import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * Do one frame.
     * Do one frame of the animation.
     *
     * @param d The draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Checks game stopping condition.
     *
     * @return True if should stop.
     */
    boolean shouldStop();
}

