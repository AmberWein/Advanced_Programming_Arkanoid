//author 208783522

package sprites;

import biuoop.DrawSurface;
import geometryprimitives.Line;
import geometryprimitives.Point;

import java.awt.Color;
import java.util.ArrayList;

import management.HitNotifier;
import management.HitListener;
import driver.GameLevel;
import management.GameEnvironment;
import management.CollisionInfo;

/**
 * The type Ball.
 * Represent a ball with 5 fields: a center point, a radius, a color, a velocity and a game environment
 */
public class Ball implements Sprite, HitNotifier {
    private Point center;
    private int r;
    private Color color;
    private Velocity velocity;
    private GameEnvironment ge;
    private ArrayList<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new sprites.Ball.
     *
     * @param center   the center point of this ball
     * @param r        the radius of this ball
     * @param color    the color of this ball
     * @param ge       the game environment of this ball
     */
    public Ball(Point center, int r, Color color, GameEnvironment ge) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.ge = ge;
    }

    /**
     * Get color java . awt . color.
     *
     * @return the color of this ball
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets velocity.
     *
     * @return the velocity of this ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Sets velocity.
     *
     * @param v represents a velocity to change to
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets color.
     *
     * @param newColor represents a color to change to
     */
    public void setColor(java.awt.Color newColor) {
        this.color = newColor;
    }

    /**
     * Draw on.
     * draw this ball on the given Surface
     *
     * @param surface the surface we draw the ball on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        int xValue = (int) this.center.getX();
        int yValue = (int) this.center.getY();
        surface.setColor(Color.BLACK);
        surface.drawCircle(xValue, yValue, this.r);
        surface.setColor(this.color);
        surface.fillCircle(xValue, yValue, this.r);
    }

    /**
     * Move one step.
     * makes the ball move
     */
    public void moveOneStep() {
        // compute the trajectory of the ball
        Point start = this.center;
        Point end = this.getVelocity().applyToPoint(start);
        Line trajectory = new Line(start, end);
        // there might be a hit with one block (or more)
        // if there is one, find the information of the closest collision
        CollisionInfo closestCollision = this.ge.getClosestCollision(trajectory);
        // check if there is one, if no- then move it to the end point
        if (closestCollision == null) {
            this.center = end;
        } else {
            Point collisionPoint = closestCollision.collisionPoint();
            // update the velocity
            Velocity newVelocity = closestCollision.getCollisionObject().hit(this, collisionPoint, this.velocity);
            this.velocity = newVelocity;
            // check if there is another collided block
            end = this.getVelocity().applyToPoint(start);
            trajectory = new Line(start, end);
            CollisionInfo anotherCollision = this.ge.getClosestCollision(trajectory);
            // there is no one
            if (anotherCollision == null) {
                this.center = this.velocity.applyToPoint(this.center);
            } else {
                // there is one
                collisionPoint = anotherCollision.collisionPoint();
                newVelocity = anotherCollision.getCollisionObject().hit(this, collisionPoint, this.velocity);
                this.velocity = newVelocity;
                this.center = this.velocity.applyToPoint(this.center);
            }
        }
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Add to game.
     * add this ball to a game
     *
     * @param g a game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove from game.
     * Removes the current block from the game.
     *
     * @param game a game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Remove hit listener.
     * Remove the argument hit listener.
     *
     * @param hl The hit listener.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
