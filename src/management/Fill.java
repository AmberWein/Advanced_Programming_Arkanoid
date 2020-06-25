package management;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Fill {

    private boolean isFillImage;
    private Color color;
    private Image image;

    /**
     * Constructor for color fill.
     * @param color The fill color.
     */
    public Fill(Color color) {
        isFillImage = false;
        this.color = color;
        this.image = null;
    }

    /**
     * Constructor for image fill.
     * @param image The fill image.
     */
    public Fill(Image image) {
        isFillImage = true;
        this.image = image;
        this.color = null;
    }

    /**
     * Get color Color.
     * Return the fill color.
     *
     * @return The fill color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Get image Image.
     * Return the fill image.
     *
     * @return The fill image.
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Is image boolean.
     * Return true if fill is image.
     *
     * @return True if fill is image.
     */
    public boolean isImage() {
        return this.isFillImage;
    }
}