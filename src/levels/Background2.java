//author 208783522

package levels;

import biuoop.DrawSurface;
import sprites.Sprite;

import java.awt.Color;

/**
 * The type Background 2.
 * Represent the level 2 background.
 */
public class Background2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // Draw a sun.
        Color lightYellow = new Color(230, 230, 138);
        Color darkYellow = new Color(240, 218, 0);
        d.setColor(lightYellow);
        d.fillCircle(180, 120, 60);
        // Draw sun rays.
        for (int i = 1; i < 70; i++) {
            d.drawLine(180, 120, 20 + (i * 10), 240);
        }
        d.setColor(darkYellow);
        d.fillCircle(180, 120, 50);
        d.setColor(Color.YELLOW);
        d.fillCircle(180, 120, 40);
    }

    @Override
    public void timePassed() {
    }
}
