package uq.deco2800.ducktales.rendering.sprites;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.entities.EntitySprite;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This is the factory that will createEntitySprite and return sprites as requested
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class SpritesFactory {

	static int initTime;
	static GameTime gameTime = new GameTime();

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
    	initTime = gameTime.getCurrentDay();
        switch (spriteType) {
            case SHEEP:
                return createSheep(index, ResourceType.SHEEP);
            case DUCK:
                return createDuck(index, ResourceType.DUCK);
            case COW:
            	return createCow(index, ResourceType.COW);
            case HOSPITAL:
                return createHospital(index, ResourceType.HOSPITAL);
            case BAKERY:
                return createBakery(index, ResourceType.BAKERY);
            case BARN:
                return createBarn(index, ResourceType.BARN);
            case BUTCHER:
                return createButcher(index, ResourceType.BUTCHER);
            case CEMETERY:
                return createCemetery(index, ResourceType.CEMETERY);
            case CHURCH:
                return createChurch(index, ResourceType.CHURCH);
            case COMMUNITY_BUILDING:
                return createCommunityBuilding(index, ResourceType.COMMUNITY_BUILDING);
            case FARM:
                return createFarm(index, ResourceType.FARM);
            case FORGE:
                return createForge(index, ResourceType.FORGE);
            case HOUSE:
                return createHouse(index, ResourceType.HOUSE);
            case MINE:
                return createMine(index, ResourceType.MINE);
            case OBSERVATORY:
                return createObservatory(index, ResourceType.OBSERVATORY);
            case PASTURE:
                return createPasture(index, ResourceType.PASTURE);
            case QUARRY:
                return createQuarry(index, ResourceType.QUARRY);
            case SAWMILL:
                return createSawmill(index, ResourceType.SAWMILL);
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
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.HOSPITAL));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(5*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a bakery
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a bakery
     */
    private static EntitySprite createBakery(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.BAKERY));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(4*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a barn
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a barn
     */
    private static EntitySprite createBarn(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.BARN));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(9*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a butcher
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a butcher
     */
    private static EntitySprite createButcher(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.BUTCHER));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(7*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a cemetery
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a cemetery
     */
    private static EntitySprite createCemetery(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.CEMETERY));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(2*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a church
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a church
     */
    private static EntitySprite createChurch(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.CHURCH));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(9*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a community building
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a community Building
     */
    private static EntitySprite createCommunityBuilding(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.COMMUNITY_BUILDING));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(8*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a farm
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a farm
     */
    private static EntitySprite createFarm(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.FARM));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(4*60); // Set up the actual animation, passing the duration
        sprite.setAnimationCycleCount(1);
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a forge
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a forge
     */
    private static EntitySprite createForge(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.FORGE));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(3*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a house
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a house
     */
    private static EntitySprite createHouse(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.HOUSE));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(2*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a mine
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a mine
     */
    private static EntitySprite createMine(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.MINE));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(3*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create an observatory
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing an observatory
     */
    private static EntitySprite createObservatory(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.OBSERVATORY));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(5*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a pasture
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a pasture
     */
    private static EntitySprite createPasture(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.PASTURE));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(4*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a quarry
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a quarry
     */
    private static EntitySprite createQuarry(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.QUARRY));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(5*60); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create a sawmill
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a sawmill
     */
    private static EntitySprite createSawmill(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.SAWMILL));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(3*60); // Set up the actual animation, passing the duration
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
        imageList.add(register.getResourceImage(ResourceType.SHEEPRight0));
        imageList.add(register.getResourceImage(ResourceType.SHEEPRight1));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(1.0); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Create and return a generic duck sprite.
     * @param index
     *     The index of the sprite
     * @param entityType
     *     The type of the sprite
     *
     * @return the sprite of a generic duck
     */
    private static EntitySprite createDuck(int index, ResourceType entityType) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, entityType);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
        imageList.add(register.getResourceImage(ResourceType.DUCK));
        imageList.add(register.getResourceImage(ResourceType.DUCKDown0));
        imageList.add(register.getResourceImage(ResourceType.DUCKDown1));
        imageList.add(register.getResourceImage(ResourceType.DUCKLeft0));
        imageList.add(register.getResourceImage(ResourceType.DUCKLeft1));
        imageList.add(register.getResourceImage(ResourceType.DUCKUp0));
        imageList.add(register.getResourceImage(ResourceType.DUCKUp1));
        imageList.add(register.getResourceImage(ResourceType.DUCKRight0));
        imageList.add(register.getResourceImage(ResourceType.DUCKRight1));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(1.0); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }
    
    /**
     * Create and return a generic cow sprite.
     * @param index
     *     The index of the sprite
     * @param entityType
     *     The type of the sprite
     *
     * @return the sprite of a generic duck
     */
    private static EntitySprite createCow(int index, ResourceType entityType) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, entityType);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
        imageList.add(register.getResourceImage(ResourceType.COW));
        // BELOW THIS SHOULD BE THE REMAINING COW SPRITES TO CREATE THE ANIMATION
        imageList.add(register.getResourceImage(ResourceType.COWLeft0));
        imageList.add(register.getResourceImage(ResourceType.COWRight0));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(1.0); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }
}
