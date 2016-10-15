package uq.deco2800.ducktales.rendering.sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This is the sprite for an entity. It will only be responsible for GUI logic.
 * NO game logic should be included in this class
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class EntitySprite extends Sprite {

    /** The index of this sprite which corresponds to the index of the entity */
    private int index;

    /** The type of the entity this sprite represents */
    private ResourceType entityType;

    /** The sprite register */
    private ResourceSpriteRegister resource;

    /** The tile-location of the sprite */
    private int xLocation;
    private int yLocation;

    public EntitySprite(int index, ResourceType entityType) {
        super(); // Call this to activate the Timeline

        this.index = index;
        this.entityType = entityType;
        this.resource = ResourceSpriteRegister.getInstance();

        // Now load the image of the given entity type into this sprite
        Image image = resource.getResourceImage(entityType);
        this.setImage(image);

    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }
}
