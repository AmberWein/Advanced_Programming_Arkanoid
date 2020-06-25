//author 208783522

package levels;

import biuoop.DrawSurface;
import sprites.Sprite;

import java.awt.Color;

/**
 * The type Background 4.
 * Represent the level 4 background.
 */
public class Background4 implements Sprite {
    /**
     * Draw on.
     *
     * @param d the d
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Draw background
        d.setColor(new Color(7, 87, 152));
        // Draw first cloud
        Color lightGrey = new Color(204, 194, 193);
        Color grey = new Color(179, 179, 173);
        Color darkGrey = new Color(153, 153, 138);

        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(lightGrey);
        for (int i = 0; i < 8; i++) {
            d.drawLine(160 + (i * 10), 450, 190 + (i * 10), 600);
        }
        d.fillCircle(150, 430, 30);
        d.fillCircle(180, 450, 25);
        d.setColor(grey);
        d.fillCircle(200, 430, 30);
        d.fillCircle(220, 450, 25);
        d.setColor(darkGrey);
        d.fillCircle(250, 430, 30);

        // Draw second cloud
        d.setColor(lightGrey);
        for (int i = 0; i < 8; i++) {
            d.drawLine(555 + (i * 10), 480, 585 + (i * 10), 600);
        }
        d.fillCircle(550, 500, 30);
        d.fillCircle(580, 530, 25);
        d.setColor(grey);
        d.fillCircle(600, 500, 30);
        d.fillCircle(620, 530, 25);
        d.setColor(darkGrey);
        d.fillCircle(650, 500, 30);
    }

    /**
     * Time passed.
     */
    @Override
    public void timePassed() {
    }
}
