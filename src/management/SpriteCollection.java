//author 208783522

package management;

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
import sprites.Sprite;

/**
 * The type Sprite collection.
 * Represents a list of some sprites objects.
 */
public class SpriteCollection {
    private List<Sprite> listOfSprites;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        listOfSprites = new ArrayList<>();
    }

    /**
     * Add sprite.
     * Ddd a sprite object to this sprites collection
     *
     * @param s a sprite object to add
     */
    public void addSprite(Sprite s) {
        this.listOfSprites.add(s);
    }

    /**
     * * Remove sprite.
     * Remove a sprite object to this sprites collection
     *
     * @param s a sprite object to remove
     */
    public void removeSprite(Sprite s) {
        this.listOfSprites.remove(s);
    }

    /**
     * Notify all time passed.
     * notify all the sprite objects that time has passed
     */
    public void notifyAllTimePassed() {
        // Make a copy of the hitListeners before iterating over them.
        List<Sprite> sprites = new ArrayList<>(this.listOfSprites);
        // a loop to notify all of the sprites that time has passed
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    /**
     * Draw all on.
     * draw all the sprite objects
     *
     * @param d a surface on which the object is draw on
     */
    public void drawAllOn(DrawSurface d) {
        // a loop to draw all of the sprites
        for (Sprite s : this.listOfSprites) {
            s.drawOn(d);
        }
    }
}