package uq.deco2800.ducktales.rendering.sprites;

import javafx.scene.image.Image;
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

    /**
     * Create a simple entity sprite with a timeline
     */
    public EntitySprite() {
        super(); // Call this to activate the Timeline
    }

    /**
     * Create a sprite of an entity, storing its type and index. The index
     * will be the same as the index of the model stored, which means this
     * will be used to retrieve the correct sprite or model later
     *
     * @param index
     *          The index of this sprite in the stored list
     * @param entityType
     */
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

    /**
     * Get the index of this sprite. For some sprites, the index is the unique
     * id used to also retrieve the model of the object from World
     *
     * @return the index values of the sprite in the stored array
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the type of the entity that this sprite represents. The type of
     * this sprite must be the same as that of the entity
     *
     * @return the type of the entity that this sprite represents
     */
    public ResourceType getEntityType() {
        return entityType;
    }
}
