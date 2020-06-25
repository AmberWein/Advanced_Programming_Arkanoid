//author 208783522

package sprites;

import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import driver.GameLevel;
import geometryprimitives.Line;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

/**
 * The type Paddle.
 * the player in the game. It is a rectangle that is controlled
 * by the arrow keys, and moves according to the player key presses.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private Velocity velocity;
    private static final int STEP_SIZE = 5;
    public static final double NUM_OF_SEGMENTS = 5;

    /**
     * Instantiates a new Paddle.
     *
     * @param newKeyboard  the new keyboard
     * @param newRectangle the shape of the paddle
     * @param newColor     the color of the paddle
     */
    public Paddle(KeyboardSensor newKeyboard, Rectangle newRectangle,
                  Color newColor) {
        this.keyboard = newKeyboard;
        this.rectangle = newRectangle;
        this.color = newColor;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * Get color Color.
     *
     * @return the color of this paddle.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Move left.
     * Move this paddle left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() - STEP_SIZE < 10) {
            this.velocity.setDX(0);
        } else {
            this.velocity.setDX(-STEP_SIZE);
        }
        // if the move is inbound, move the ball
        if (this.velocity.getDX() != 0) {
            this.rectangle.setXUpperLeft((int) (this.rectangle.getUpperLeft().getX() - STEP_SIZE));
        }
    }

    /**
     * Move right.
     * Move this paddle right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperRight().getX() + STEP_SIZE > 790) {
            this.velocity.setDX(0);
        } else {
            this.velocity.setDX(STEP_SIZE);
        }
        // if the move is inbound, move the ball
        if (this.velocity.getDX() != 0) {
            this.rectangle.setXUpperLeft((int) (this.rectangle.getUpperLeft().getX() + STEP_SIZE));
        }
    }

    /**
     * Get collision rectangle.
     *
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Get hit segment int.
     *
     * @param collisionPoint a collision point where the hit happens
     * @return the number of the segment of the paddle
     * on which the hit happens. If there is no hit, return 0.
     */
    private int getHitSegment(Point collisionPoint) {
        int segmentValue = 1;
        double segmentWidth = (this.rectangle.getWidth() / NUM_OF_SEGMENTS);
        Point start = new Point(this.rectangle.getUpperLeft());
        Point end = new Point(start.getX() + segmentWidth, start.getY());
        Line segmentLine = new Line(start, end);
        // a loop to find where the hit occurs
        for (int i = 1; i <= NUM_OF_SEGMENTS; i++) {
            // if the collision point is on the i-th segment of the paddle
            if (collisionPoint.getX() <= segmentLine.end().getX()) {
                return segmentValue;
            }
            // it is not the i-th segment, so we need to keep looking
            segmentValue++;
            segmentLine.start().setX(segmentLine.end().getX());
            segmentLine.end().setX(segmentLine.start().getX() + segmentWidth);
        }
        return segmentValue;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // check on which segment of this paddle is the hit and change the velocity according to it
        int segmentOfPaddle = this.getHitSegment(collisionPoint);
        // check if the hit is with the middle segment of the paddle
        if (segmentOfPaddle == 3) {
            return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
        }
        // the hit is with another segment of the paddle
        return Velocity.fromAngleAndSpeed(300 + ((segmentOfPaddle - 1) * 30), currentVelocity.getSpeed());
    }

    @Override
    public void timePassed() {
        // check if the left key is pressed
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        // check if the right key is pressed
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
        // make it stop
        this.velocity.setDX(0);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * Add to game.
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}