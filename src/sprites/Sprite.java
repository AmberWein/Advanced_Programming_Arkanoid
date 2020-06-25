//author 208783522

package sprites;

import biuoop.DrawSurface;

/**
 * The interface Sprite.
 * Represent a game object that can be drawn to the screen
 * (and which is not just a background image).
 */
public interface Sprite {
    /**
     * Draw on.
     * draw the sprite to the screen
     *
     * @param d a surface on which the object is draw on
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed.
     * notify the sprite that time has passed
     */
    void timePassed();
}