package geometryprimitives;

//author 208783522

/**
 * The type Point.
 * A point which has two values:
 * one for the X axis and another for the Y axis
 */
public class Point {
    private double x;
    private double y;

    /**
     * Instantiates a new Point.
     * Creates a new point with the given X,Y coordinates.
     *
     * @param x the x value of this point
     * @param y the y value of this point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiates a new Point.
     * Copy constructor.
     *
     * @param other represents another point
     */
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Gets x.
     *
     * @return the x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y value of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Set x.
     *
     * @param newX the x value to change to
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * Distance double.
     *
     * @param other represents another point
     * @return the distance between this point to the other point
     */
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}