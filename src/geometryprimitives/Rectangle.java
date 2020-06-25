package geometryprimitives;

//author 208783522

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Instantiates a new Rectangle.
     * Create a new rectangle with location and width/height.
     *
     * @param newUpperLeft the upper left point of the rectangle
     * @param newWidth     the width of the rectangle
     * @param newHeight    the height of the rectangle
     */
    public Rectangle(Point newUpperLeft, double newWidth, double newHeight) {
        this.upperLeft = newUpperLeft;
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Intersection points list.
     *
     * @param line a line
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public List<Point> intersectionPoints(Line line) {
        // get all of the rectangle corners
        Point upperRight = this.getUpperRight();
        Point lowerLeft = this.getLowerLeft();
        Point lowerRight = this.getLowerRight();
        Line[] lines = {
                // define the upper horizontal line that define the rectangle
                new Line(this.upperLeft, upperRight),
                // define the lower horizontal line that define the rectangle
                new Line(lowerLeft, lowerRight),
                // define the left vertical line that define the rectangle
                new Line(upperLeft, lowerLeft),
                // define the right vertical line that define the rectangle
                new Line(upperRight, lowerRight)
        };
        List<Point> listOfIntersectionPoints = new ArrayList<>();
        for (Line l : lines) {
            if (l.isIntersecting(line)) {
                listOfIntersectionPoints.add(l.intersectionWith(line));
            }
        }

        return listOfIntersectionPoints;
    }

    /**
     * Gets width.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper-left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets lower left.
     *
     * @return the lower-left point of the rectangle
     */
    public Point getLowerLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight());
    }

    /**
     * Gets upper right.
     *
     * @return the upper-right point of the rectangle
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + getWidth(), this.upperLeft.getY());
    }

    /**
     * Gets lower right.
     *
     * @return the lower-right point of the rectangle
     */
    public Point getLowerRight() {
        return new Point(this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
    }

    /**
     * Sets x upper left.
     * Sets the x value of the upper point
     *
     * @param newX the new x value to change to for the upper point
     */
    public void setXUpperLeft(int newX) {
        this.upperLeft.setX(newX);
    }
}