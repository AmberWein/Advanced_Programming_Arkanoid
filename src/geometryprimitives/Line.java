package geometryprimitives;

//author 208783522

import java.util.List;

/**
 * The type Line.
 * A line which is made out of two point: a starting one and an ending one.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start point of this line
     * @param end   the end point of this line
     */
    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    /**
     * Instantiates a new geometryprimitives.Line.
     *
     * @param x1 the x value of the first point
     * @param y1 the y value of the first point
     * @param x2 the x value of the second point
     * @param y2 the y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    /**
     * Set.
     *
     * @param newStart the start point to change to
     * @param newEnd   the end point to change to
     */
    public void set(Point newStart, Point newEnd) {
        this.start = newStart;
        this.end = newEnd;
    }

    /**
     * Start point.
     *
     * @return the start point of this line
     */
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     *
     * @return the end point of this line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Is intersecting boolean.
     *
     * @param other represents another line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        // this segment points values
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();
        // other segment points values
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();
        // find denominator
        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        // check if it is 0- meaning the segments are parallel
        if (denominator == 0) {
            return false;
        }
        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denominator;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / denominator;
        // check t and u values:
        // if between 0<=t<=1 and also 0<=u<=1
        return ((t >= 0) && (t <= 1) && (u >= 0) && (u <= 1));
    }


    /**
     * Intersection with point.
     *
     * @param other represents another line
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        // check if there is an intersection point
        if (!this.isIntersecting(other)) {
            return null;
        } else {
            // this segment points values
            double x1 = this.start.getX();
            double y1 = this.start.getY();
            double x2 = this.end.getX();
            double y2 = this.end.getY();
            // other segment points values
            double x3 = other.start.getX();
            double y3 = other.start.getY();
            double x4 = other.end.getX();
            double y4 = other.end.getY();
            // find denominator
            double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
            double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denominator;
           return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
        }
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect a rectangle that this line might collide with
     * @return the closest collision point of this line with a rectangle.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> listOfIntersectionPoints = rect.intersectionPoints(this);
        // check if there are no intersection points
        if (listOfIntersectionPoints.size() == 0) {
            return null;
        }
        // check if there is only one intersection point- if so, return it
        if (listOfIntersectionPoints.size() == 1) {
            return listOfIntersectionPoints.get(0);
        } else {
            // there are two intersection points,
            // we need to find the closer one
            double firstDistance = listOfIntersectionPoints.get(0).distance(this.start);
            double secondDistance = listOfIntersectionPoints.get(1).distance(this.start);
            if (firstDistance < secondDistance) {
                return listOfIntersectionPoints.get(0);
            } else {
                return listOfIntersectionPoints.get(1);
            }
        }
    }
}