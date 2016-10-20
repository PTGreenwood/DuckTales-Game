package uq.deco2800.ducktales.rendering.sprites;

/**
 * This class represents a sprite of a resource entity. The sprite will have the same
 * id as the resource entity, in order to allow correct retrieval of corresponding 
 * resource entity
 *
 * @author Andrew Georgiou
 */

public class ResourceEntitySprite extends EntitySprite{
	
	/**
     * The unique value of this resource entity sprite. This should match up
     * with the value of the resource entity in the model
     */
	private Integer value;
	
	/**
     * Create a resource entity sprite with the given value
     * The value is the unique ID of this sprite
     *
     * @param name
     *          The value (unique ID( of the sprite
     */
    public ResourceEntitySprite(Integer value) {
        super();

        // Store the unique identifier of this sprite
        this.value = value;
    }
    
    /**
     * Get the value of the resource entity whose sprite this is for
     *
     * @return the value of the resource entity of this sprite
     */
    public Integer getResourceEntityValue() {
        return value;
    }
}