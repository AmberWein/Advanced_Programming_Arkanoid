//author 208783522

package levels;

import sprites.Sprite;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Background 3.
 * Represent the level 3 background.
 */
public class Background3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // Draw green background,
        d.setColor(new Color(26, 148, 49));
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());

        // Draw building.
        d.setColor(new Color(26, 26, 18));
        d.fillRectangle(50, 400, 112, 200);
        d.setColor(new Color(51, 51, 38));
        d.fillRectangle(95, 350, 30, 50);
        d.setColor(new Color(77, 77, 62));
        d.fillRectangle(105, 150, 10, 200);
        d.setColor(Color.ORANGE);
        d.fillCircle(110, 145, 15);
        d.setColor(Color.RED);
        d.fillCircle(110, 145, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(110, 145, 5);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(60 + (i * 20), 415 + (j * 40), 12, 30);
            }
        }
    }

    @Override
    public void timePassed() {
    }
}
