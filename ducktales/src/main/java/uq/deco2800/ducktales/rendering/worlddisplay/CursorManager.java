package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This manager manages the image that appears at the cursor while it's in the world
 * display
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class CursorManager {
    /** The root pane where the cursor image will be loaded into */
    private Pane rootPane;

    /** The image to be displayed at the cursor */
    private ImageView cursorImage;

    /** Variables to control the cursor image */
    private boolean cursorImageFreeMoving; // control whether it can be moved
    private ResourceType type; // Type of the resource of the image

    /** The sprites register that stores information about image files */
    private ResourceSpriteRegister resource;

    public CursorManager(Pane rootPane) {
        // Store the root pane
        this.rootPane = rootPane;

        // Set initial values for the cursor image
        cursorImage = new ImageView();
        cursorImageFreeMoving = true;

        // Retrieve the sprite register
        resource = ResourceSpriteRegister.getInstance();

        // Add the cursor image to the root
        rootPane.getChildren().add(cursorImage);
    }

    /**
     * Get the Node representing the cursor image
     * @return the ImageView cursor image
     */
    public ImageView getCursorImage() {
        return this.cursorImage;
    }

    /**
     * Change the image to be shown at the cursor
     * @param type
     *          The type of the sprite to be shown at the cursor
     */
    public void changeImage(ResourceType type) {
        // Retrieve the image from sprite register
        Image sprite = resource.getResourceImage(type);

        // Set the cursor image and bring it to the front
        cursorImage.setImage(sprite);
        cursorImage.toFront();
    }

    /**
     * Resize the image by the given scale
     *
     * @param scale
     *          The scale to resize the image to
     */
    public void resizeImage(double scale) {
        // The sprite of the cursor image
        Image sprite = cursorImage.getImage();

        // change the fit height and with of the image
        cursorImage.setFitHeight(sprite.getHeight() * scale);
        cursorImage.setFitWidth(sprite.getWidth() * scale);
    }

    /**
     * Adjust the offset of the image according to fit height and width
     */
    public void adjustOffset() {
        cursorImage.setX(-cursorImage.getFitWidth() / 2);
        cursorImage.setY(-cursorImage.getFitHeight() / 2);
    }

    /**
     * Move the cursor image to the given point on the world display
     *
     * @param x
     *          The x-coordinate on the world display to move to
     * @param y
     *          The y-coordinate on the world display to move to
     */
    public void moveCursorImage(double x, double y) {
        if (cursorImageFreeMoving) {
            cursorImage.setLayoutX(x);
            cursorImage.setLayoutY(y);
        }
    }
}
