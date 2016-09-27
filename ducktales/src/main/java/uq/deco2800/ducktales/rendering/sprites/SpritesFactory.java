package uq.deco2800.ducktales.rendering.sprites;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.entities.EntitySprite;
import uq.deco2800.ducktales.rendering.RenderingInformation;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the factory that will createEntitySprite and return sprites as requested
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class SpritesFactory {

    /**
     * Create and return a sprite of the given type
     *
     * @param index
     *          The index of the sprite
     * @param spriteType
     *          The type of the sprite - of type RegisteredSprite
     * @return The sprite of the entity of the given type
     */
    public static EntitySprite createEntitySprite(int index, ResourceType spriteType) {
        // TODO SEPARATE INTO ANIMALS AND BUILDINGS
        switch (spriteType) {
            case SHEEP:
                return createSheep(index, ResourceType.SHEEP);
            case HOSPITAL:
                return createHospital(index, ResourceType.CONSTRUCTION);
            default:
                return null;
        }
    }

    /**
     * Create a hospital
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *          
     * @return The EntitySprite representing a hospital
     */
    private static EntitySprite createHospital(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
        // Now add all the images representing the animation here, one-by-one
        imageList.add(register.getResourceImage(ResourceType.HOSPITAL));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(1.0); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create and return a generic sheep sprite
     *
     * @param index
     *          The index of the sprite
     * @param entityType
     *          The type of the sprite
     *
     * @return the sprite of a generic sheep
     */
    private static EntitySprite createSheep(int index, ResourceType entityType) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, entityType);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
        // Now add all the images representing the animation here, one-by-one
        imageList.add(register.getResourceImage(ResourceType.SHEEP));
        imageList.add(register.getResourceImage(ResourceType.SHEEPDown0));
        imageList.add(register.getResourceImage(ResourceType.SHEEPDown1));
        imageList.add(register.getResourceImage(ResourceType.SHEEPLeft0));
        imageList.add(register.getResourceImage(ResourceType.SHEEPLeft1));
        imageList.add(register.getResourceImage(ResourceType.SHEEPUp0));
        imageList.add(register.getResourceImage(ResourceType.SHEEPUp1));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(1.0); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        // Setup the size of the sheep
        sprite.setFitHeight(sprite.getLayoutBounds().getHeight() *
                RenderingInformation.ANIMAL_SCALE);
        sprite.setFitWidth(sprite.getLayoutBounds().getWidth() *
                RenderingInformation.ANIMAL_SCALE);

        return sprite;
    }
}
