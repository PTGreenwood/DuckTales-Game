package uq.deco2800.ducktales.rendering.sprites;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

import static uq.deco2800.ducktales.resources.ResourceType.DUCK;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKDown0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKDown1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKLeft0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKLeft1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKRight0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKRight1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKUp0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKUp1;

/**
 * This is the factory that will createEntitySprite and return sprites as requested
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class SpritesFactory {
    /** CONSTANTS */
    private static int TOTAL_CONSTRUCTION_TIME = 3; // In seconds

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
            // ANIMALS
            case SHEEP:
                return createSheep(index, ResourceType.SHEEP);
            case DUCK:
                return createDuck(index, DUCK);
            case COW:
            	return createCow(index, ResourceType.COW);

            // BUILDINGS
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
            case SCHOOL:
                return createSchool(index, ResourceType.SCHOOL);
            case GYMNASIUM:
                return createGymnasium(index, ResourceType.GYMNASIUM);
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
        sprite.setupAnimation(5* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
    	
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
                ResourceType.BAKERY_1,
                ResourceType.BAKERY_2,
                ResourceType.BAKERY_3,
                ResourceType.BAKERY_4,
                ResourceType.BAKERY_5
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                60*4.0, // from the time passed in the building class
                1.0, // Total time of idle animation
                idleFrames,
                true
        );

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
        sprite.setupAnimation(9* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
                ResourceType.BUTCHER_1,
                ResourceType.BUTCHER_2,
                ResourceType.BUTCHER_3,
                ResourceType.BUTCHER_4,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                7.0*60,
                2.0, // Total time of idle animation
                idleFrames,
                false
        );
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
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
                ResourceType.CEMETERY_1,
                ResourceType.CEMETERY_2,
                ResourceType.CEMETERY_3,
                ResourceType.CEMETERY_4,
                ResourceType.CEMETERY_5,
                ResourceType.CEMETERY_6,
                ResourceType.CEMETERY_7,
                ResourceType.CEMETERY_8,
                ResourceType.CEMETERY_9,
                ResourceType.CEMETERY_10,
                ResourceType.CEMETERY_11,
                ResourceType.CEMETERY_12,
                ResourceType.CEMETERY_13,
                ResourceType.CEMETERY_14,
                ResourceType.CEMETERY_15,
                ResourceType.CEMETERY_16,
                ResourceType.CEMETERY_16,
                ResourceType.CEMETERY_16,
                ResourceType.CEMETERY_16
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                2.0*60,
                2.0, // Total time of idle animation
                idleFrames,
                false
        );

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
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
                ResourceType.CHURCH_1,
                ResourceType.CHURCH_2,
                ResourceType.CHURCH_3,
                ResourceType.CHURCH_4,
                ResourceType.CHURCH_5
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                9.0*60,
                1.0, // Total time of idle animation
                idleFrames,
                true
        );

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
        sprite.setupAnimation(8* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        sprite.setupAnimation(4* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        sprite.setupAnimation(3* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        sprite.setupAnimation(2* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        sprite.setupAnimation(3* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
                ResourceType.OBSERVATORY_1,
                ResourceType.OBSERVATORY_2,
                ResourceType.OBSERVATORY_3,
                ResourceType.OBSERVATORY_4,
                ResourceType.OBSERVATORY_5
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                5.0*60,
                1.0, // Total time of idle animation
                idleFrames,
                true
        );

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
        sprite.setupAnimation(4* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        sprite.setupAnimation(5* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
                ResourceType.SAWMILL_1,
                ResourceType.SAWMILL_2,
                ResourceType.SAWMILL_3,
                ResourceType.SAWMILL_4,
                ResourceType.SAWMILL_5,
                ResourceType.SAWMILL_6,
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                3.0*60,
                2.0, // Total time of idle animation
                idleFrames,
                true
        );

        return sprite;
    }

    /**
     * Set up the building sprite with the given parameters
     *
     * @param sprite
     *          The sprite to be set up
     * @param buildingType
     *          The type of the building
     * @param constructionTime
     *          The total time for construction
     * @param idleAnimationTime
     *          The total time that the idle animation will take up
     * @param idleAnimationFrames
     *          The key frames of the idle animation. Note: Only put in the
     *          forward direction, since reversing can be done via code
     */
    private static void setupBuildingSprite(
            BuildingSprite sprite,
            ResourceType buildingType,
            double constructionTime,
            double idleAnimationTime,
            ResourceType[] idleAnimationFrames,
            boolean autoReverse) {
        // Setup the frames for the animations
        List<Image> constructionFrames = new ArrayList<>();
        List<Image> idleFrames = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the construction animation here
        constructionFrames.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        constructionFrames.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        constructionFrames.add(register.getResourceImage(buildingType));

        // Add all the frames for the idle animation
        for (int i = 0; i < idleAnimationFrames.length; i++) {
            idleFrames.add(register.getResourceImage(idleAnimationFrames[i]));
        }

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setupConstructionAnimation(constructionFrames, constructionTime);
        sprite.setupIdleAnimation(idleFrames, idleAnimationTime, autoReverse);

        // Now play the construction animation. Idle animation will automatically
        // play when construction animation is done
        sprite.playConstructionAnimation();
    }
    
    /**
     * Create a school
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a school
     */
    private static EntitySprite createSchool(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.SCHOOL));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(3* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }
    
    /**
     * Create a gymnasium
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the sprite
     *
     * @return The EntitySprite representing a gymnasium
     */
    private static EntitySprite createGymnasium(int index, ResourceType type) {
        // The sprite to be returned
        EntitySprite sprite = new EntitySprite(index, type);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.GYMNASIUM));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(3* TOTAL_CONSTRUCTION_TIME); // Set up the actual animation, passing the duration
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
        AnimalSprite sprite = new AnimalSprite(index, entityType);

        // Setup the frames for the roaming animation.
        ResourceType[] roamingFrames = {
        DUCK,
        DUCKDown0,
        DUCKDown1,
        DUCKLeft0,
        DUCKLeft1,
        DUCKUp0,
        DUCKUp1,
        DUCKRight0,
        DUCKRight1
        };
        // Setup the sprite with the given parameters
        setupAnimalSprite(
                sprite,
                entityType,
                1.0,
                roamingFrames,
                true
        );

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

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(1.0); // Set up the actual animation, passing the duration
        sprite.startAnimation(); // Start the actual animation

        return sprite;
    }

    /**
     * Sets up the animal sprite with the given parameters.
     * @param sprite
     *         The sprite to be set up.
     * @param animalType
     *         The resourceType of the sprite to be set up.
     * @param roamingAnimationTime
     *         The duration of the roaming animation.
     * @param roamingAnimationFrames
     *         The key frames of the roaming animation.
     * @param autoReverse
     *         Whether the animation can move backwards.
     */
    private static void setupAnimalSprite(
            AnimalSprite sprite,
            ResourceType animalType,
            double roamingAnimationTime,
            ResourceType[] roamingAnimationFrames,
            boolean autoReverse) {
        // Setup the frames for the animations
        List<Image> roamingFrames = new ArrayList<>();
//        List<Image> deathFrames = new ArrayList<>();
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Add all the frames for the roaming animation.
        for (int i = 0; i < roamingAnimationFrames.length; i++) {
            roamingFrames.add(register.getResourceImage(roamingAnimationFrames[i]));
        }

        // After all images are set up, now call these methods to set up the actual animation code.
        sprite.setUpRoamingAnimation(roamingFrames, roamingAnimationTime, autoReverse);

        // Now play the construction animation. Idle animation will automatically
        // play when construction animation is done
        sprite.playRoamingAnimation();
    }
}
