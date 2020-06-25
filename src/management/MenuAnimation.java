//author 208783522

package management;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import tasks.Selection;

import java.awt.Color;
import java.util.ArrayList;

/**
 * The type Menu animation.
 * Represents a menu animation.
 *
 * @param <T> Type.
 */
public class MenuAnimation<T> implements Menu {
    private ArrayList<Selection> selections;
    private KeyboardSensor keyBoard;
    private boolean shouldStop;
    private Selection selected;
    private static final String NAME_TITLE = "Arkanoid";

    /**
     * Instantiates a new Menu animation.
     *
     * @param newKeyboard a new keyboard
     */
    public MenuAnimation(KeyboardSensor newKeyboard) {
        this.keyBoard = newKeyboard;
        this.selections = new ArrayList<>();
        this.shouldStop = false;
        this.selected = null;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(110, 200, NAME_TITLE, 150);
        //int lines = 1;
        d.setColor(Color.BLUE);
        for (int i = 0; i < this.selections.size(); i++) {
            d.drawText(100, 300 + (80) * i, this.selections.get(i).getKey()
                    + "   " + this.selections.get(i).getName(), 80);
            if (this.keyBoard.isPressed(this.selections.get(i).getKey())) {
                this.selected = this.selections.get(i);
                this.shouldStop = true;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }

    @Override
    public void addSelection(String key, String message, Object returnVal) {
        this.selections.add(new Selection(key, message, returnVal));
    }

    // note: if more then one key is pressed' then the first one will be chosen
    @Override
    public Object getStatus() {
        if (this.selected != null) {
            return this.selected.getObject();
        }
        return null;
    }

    /**
     * Reset.
     */
    public void reset() {
        this.shouldStop = false;
        this.selections = null;
    }
}