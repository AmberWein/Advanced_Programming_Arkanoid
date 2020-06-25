//author 208783522

package sprites;

import geometryprimitives.Point;

/**
 * The type Velocity-
 * Specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    // 2 fields: the difference in both the X axis and the Y axis
    private double dx;
    private double dy;

    /**
     * Instantiates a new sprites.Velocity.
     *
     * @param dx the difference on the X axis
     * @param dy the difference on the Y axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Get dx double.
     * Get this dx value.
     *
     * @return the double
     */
    public double getDX() {
        return this.dx;
    }

    /**
     * Get dy double.
     * Get this dy value.
     *
     * @return the dy difference
     */
    public double getDY() {
        return this.dy;
    }

    /**
     * Gets speed.
     * Get the speed value according to dx, dy.
     *
     * @return the speed value.
     */
    public double getSpeed() {
        return Math.sqrt((this.getDX() * this.getDX()) + (this.getDY()
                * this.getDY()));
    }

    /**
     * Set dx void.
     * change the dx in this velocity
     *
     * @param newDx the dx to change
     */
    public void setDX(double newDx) {
        this.dx = newDx;
    }

    /**
     * Set dx void.
     * change the dx in this velocity
     *
     * @param newDy the dy to change
     */
    public void setDY(double newDy) {
        this.dy = newDy;
    }

    /**
     * Apply to point point.
     *
     * @param p a point with position (x,y)
     * @return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * From angle and speed
     * Creates a new instance of velocity according to given speed and angle.
     *
     * @param angle The angle of the velocity.
     * @param speed The speed of the velocity.
     * @return New velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // represent the given angle in radians
        angle = angle - 90;
        double angleInRad = Math.toRadians(angle);
        // find the new dx and dy value
        double dx = Math.cos(angleInRad) * speed;
        double dy = Math.sin(angleInRad) * speed;
        // make a new velocity
        return new Velocity(dx, dy);
    }
}