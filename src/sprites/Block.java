//author 208783522

package sprites;

import biuoop.DrawSurface;
import driver.GameLevel;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

import management.Fill;
import management.HitListener;
import management.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 * Represent a block with a rectangle shape, a color ond a list of hit listeners.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    //    private Color color;
    private Color stroke;
    private Fill fill;
    private int hitPoint;
    private ArrayList<HitListener> hitListeners;

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the geometric representation of the block
     * @param color     the color of the block
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
        this.stroke = Color.BLACK;
        this.fill = new Fill(color);
        this.hitPoint = 5; // default value
    }


    /**
     * Instantiates a new Block.
     *
     * @param rectangle the geometric representation of the block
     * @param fill      the block fill
     * @param stroke    the color of the block
     * @param hitPoints number of hits
     */
    public Block(Rectangle rectangle, Fill fill, Color stroke, int hitPoints) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
        this.stroke = stroke;
        this.fill = fill;
        this.hitPoint = hitPoints;
    }

    /**
     * Gets collision rectangle.
     *
     * @return the "collision shape" of the block (rectangle)
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Color getColor() {
        if (!this.fill.isImage()) {
            return this.fill.getColor();
        }
        return null;
    }

    /**
     * Gets stroke.
     *
     * @return the stroke color
     */
    public Color getStroke() {
        return this.stroke;
    }

    /**
     * Gets fill.
     *
     * @return the stroke color
     */
    public Fill getFill() {
        return this.fill;
    }

    /**
     * Gets hit point.
     *
     * @return the hit point value
     */
    public int getHitPoint() {
        return this.hitPoint;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        Velocity newVelocity = new Velocity(currentVelocity.getDX(), currentVelocity.getDY());
        final double epsilon = 10e-15;
        // check if the hit is with one of the vertical lines of the rectangle
        if ((Math.abs(collisionPoint.getX() - (this.rectangle.getUpperLeft().getX())) <= epsilon)
                || (Math.abs(collisionPoint.getX() - (this.rectangle.getUpperRight().getX())) <= epsilon)) {
            newVelocity.setDX(currentVelocity.getDX() * (-1));
        }
        // check if the hit is with one of the horizontal lines of the rectangle
        if ((Math.abs(collisionPoint.getY() - (this.rectangle.getUpperLeft().getY())) <= epsilon)
                || (Math.abs(collisionPoint.getY() - this.rectangle.getLowerLeft().getY()) <= epsilon)) {
            newVelocity.setDY(currentVelocity.getDY() * (-1));
        }
        return newVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        int xLeft = (int) this.rectangle.getUpperLeft().getX();
        int yUpper = (int) this.rectangle.getUpperLeft().getY();
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        // check if there is an image to draw
        if (this.getFill().isImage()) {
            surface.drawImage(0, 0, this.getFill().getImage());
        } else {
            // there is no image, se there is a color to draw
            surface.setColor(this.getFill().getColor());
            surface.fillRectangle(xLeft, yUpper, width, height);
        }
        // draw a stroke for the current block
        if (this.stroke != null) {
            surface.setColor(this.getStroke());
            surface.drawRectangle(xLeft, yUpper, width, height);
        }
    }

    @Override
    public void timePassed() {
        // do nothing
    }

    /**
     * Add to game.
     * add this block to a game
     *
     * @param g a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove from game.
     * Removes the current block from the game.
     *
     * @param game a game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notify hit.
     * Notifies all of the registered HitListener objects whenever a hit()
     * occurs by calling their hitEvent method.
     *
     * @param hitter The hitter ball.
     */
    public void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

