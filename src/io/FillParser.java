//author 208783522

package io;

import management.Fill;

import java.awt.*;

/**
 * Represents a fill parser.
 */
public class FillParser {
    private static final String IMAGE = "image";
    private static final String COLOR = "color";

    /**
     * Parse fill Fill.
     *
     * @param fillPattern The fill pattern.
     * @return Parsed fill.
     */
    public static Fill parseFill(String fillPattern) {
        // set a fill with null value
        Fill fill;
        if (fillPattern.startsWith(COLOR)) {
            ColorsParser parser = new ColorsParser();
            Color color = parser.colorFromString(fillPattern);
            fill = new Fill(color);
            return fill;
        } else if (fillPattern.startsWith(IMAGE)) {
            String fileNamePattern = fillPattern.split(IMAGE, 2)[1];
            String imageFileName = fileNamePattern.substring(1, fileNamePattern.length() - 1);
            Image image = ImageParser.createFromFile(imageFileName);
            fill = new Fill(image);
            return fill;
        }
        return null;
    }



}

