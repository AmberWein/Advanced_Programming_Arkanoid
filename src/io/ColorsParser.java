//author 208783522

package io;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a color parser.
 */
public class ColorsParser {
    private static final String RGB = "RGB";
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static final int BLUE = 3;

    /**
     * Color from string.
     *
     * @param s a given string.
     * @return a color.
     */
    public Color colorFromString(String s) {
        Color color;
//        s = StringSlicer.sliceRange(s, START, END);
        if (s.contains(RGB)) {
            color = this.parseName(s);
        } else {
            color = this.readNonRGB(s);
        }
        return color;
    }

    /**
     * Read non RGB Color.
     * Get a non RGB color.
     *
     * @param s a string.
     * @return  a non RGB color.
     */
    private Color readNonRGB(String s) {
        String color = s.split("\\(")[1];
        color = color.substring(0, color.length() - 1);
        // check which color it is
        switch (color) {
            case "black":
                return Color.BLACK;
            case "blue":
                return Color.BLUE;
            case "cyan":
                return Color.CYAN;
            case "darkGray":
                return Color.DARK_GRAY;
            case "gray":
                return Color.GRAY;
            case "green":
                return Color.GREEN;
            case "lightGray":
                return Color.LIGHT_GRAY;
            case "magenta":
                return Color.MAGENTA;
            case "orange":
                return Color.ORANGE;
            case "pink":
                return Color.PINK;
            case "red":
                return Color.RED;
            case "white":
                return Color.WHITE;
            case "yellow":
                return Color.YELLOW;
            default:
                return null;
        }
    }

    /**
     * Get RGB color.
     *
     * @param s String.
     * @return Color.
     */
    private Color parseName(String s) {
        String color = s.split("\\(")[2];
        color = color.substring(0, color.length() - 2);

        Pattern c = Pattern.compile(RGB + " *\\( *([0-9]+), *([0-9]+), *([0-9]+) *\\)");
        Matcher m = c.matcher(color);

        if (m.matches()) {
            return new Color(Integer.parseInt(m.group(RED)),
                    Integer.parseInt(m.group(GREEN)),
                    Integer.parseInt(m.group(BLUE)));
        }

        return null;
    }
}
