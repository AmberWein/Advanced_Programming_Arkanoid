//author 208783522

package io;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type Image parser.
 */
public class ImageParser {
        /**
     * Constructor for image fill.
     * @param imageFileName The image file name.
     */
    public static Image createFromFile(String imageFileName) {
        Image img = null;

        try {
            File imageFile = new File(imageFileName);
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
