package io;

import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import management.Fill;
import sprites.Block;

import java.awt.Color;
import java.util.Map;


/**
 * The type Block creator.
 */
public class BlockCreator {

    private static final String HEIGHT = "height";
    private static final String WIDTH = "width";
    private static final String HIT_POINTS = "hit_points";
    private static final String FILL = "fill";
    private static final String STROKE = "stroke";

    private int height;
    private int width;
    private int hitPoints;
    private Fill fill;
    private Color stroke;


    /**
     * Instantiates a new Block creator.
     *
     * @param blockDefinitions the block definitions
     */
    public BlockCreator(Map<String, String> blockDefinitions) {
        this.height = Integer.valueOf(blockDefinitions.get(HEIGHT));
        this.width = Integer.valueOf(blockDefinitions.get(WIDTH));
        this.hitPoints = Integer.valueOf(blockDefinitions.get(HIT_POINTS));
        if (blockDefinitions.containsKey(STROKE)) {
            this.stroke = this.getStroke(blockDefinitions.get(STROKE));
        }
        if (blockDefinitions.containsKey(STROKE)) {
            this.fill = this.getFill(blockDefinitions.get(FILL));
        }
    }

    /**
     * Gets fill.
     *
     * @param s a string
     * @return the fill
     */
    public Fill getFill(String s) {
        return FillParser.parseFill(s);
    }

//    /**
//     * create Block.
//     * Create a block at the specified location.
//     *
//     * @param xPosition X position.
//     * @param yPosition X position.
//     * @return Block. block
//     */
//    Block create(int xPosition, int yPosition) {
//
//    }

    /**
     * Get stroke.
     * @param colorPattern Color.
     * @return Stroke.
     */
    private Color getStroke(String colorPattern) {
        ColorsParser parser = new ColorsParser();
        Color color = parser.colorFromString(colorPattern);

        return color;
    }

    /**
     * Create block.
     *
     * @param xPosition the x position
     * @param yPosition the y position
     * @return the block according to the given values
     */
    public Block create(int xPosition, int yPosition) {
        Rectangle rect = new geometryprimitives.Rectangle(new Point(xPosition, yPosition), this.width, this.height);
        Block block = new Block(rect, this.fill, this.stroke, this.hitPoints);

        return block;
    }
}
