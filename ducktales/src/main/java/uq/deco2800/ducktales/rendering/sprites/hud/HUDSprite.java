package uq.deco2800.ducktales.rendering.sprites.hud;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Created by Khoi on 4/09/2016.
 */
public class HUDSprite extends ImageView {

    /** Variables holding the information about this sprite */
    private ResourceType spriteType;
    private Image sprite;

    /**
     * Instantiate a HUD sprite with the given type
     *
     * @param spriteType
     *          The type of the entity that the sprite represents
     */
    public HUDSprite(ResourceType spriteType) {
        this.sprite = getSprite(spriteType);
        this.spriteType = spriteType;

        // Load the sprite into the image view
        this.setImage(this.sprite);
    }

    /**
     * Get the type of this sprite
     *
     * @return the type of this sprite
     */
    public ResourceType getSpriteType() {
        return spriteType;
    }

    /**
     * Set the type of this sprite
     * @param spriteType
     */
    public void setSpriteType(ResourceType spriteType) {
        this.spriteType = spriteType;

        // Reset the sprite image
        this.sprite = getSprite(spriteType);
        this.setImage(this.sprite);
    }

    /**
     * Get the height of this sprite's image
     *
     * @return the height of the sprite image
     */
    public double getSpriteHeight() {
        return this.sprite.getHeight();
    }

    /**
     * Get the width of this sprite's image
     *
     * @return the width of the sprite image
     */
    public double getSpriteWidth() {
        return sprite.getWidth();
    }

    /**
     * Get the image of the given sprite type
     *
     * @param spriteType
     *          The type of the sprite whose image is to be retrieved
     * @return the image of the sprite type given
     */
    private Image getSprite(ResourceType spriteType) {
        return ResourceSpriteRegister.getInstance().getResourceImage(spriteType);
    }

}
