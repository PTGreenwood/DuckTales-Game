package uq.deco2800.ducktales.rendering.sprites;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This is the factory that will createBuildingSprite and return sprites as requested
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class SpritesFactory {
    /** CONSTANTS */
    private static final int REAL_MINUTE = 1; // In seconds

	static int initTime;
	static GameTime gameTime = new GameTime();

    /**
     * This is supposed to only hide the implicit public declaration only
     *
     * It does not need to do anything yet
     */
    private SpritesFactory() {
    }

    /**
     * Create a sprite of a peon, with the given name as the unique ID
     * @param peonName
     *          The name of the peon
     *
     * @return A peon sprite with the given name as unique ID
     */
    public static PeonSprite createPeonSprite(String peonName) {
        // Check if the name given is an empty string
        if (peonName == "") {
            throw new GameSetupException("Peon name cannot be an empty string");
        }

        PeonSprite sprite = new PeonSprite(peonName);
        sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(
                ResourceType.PEON
        ));
        return sprite;
    }
	
    /**
     * Create and return a sprite of the given building type
     *
     * @param index
     *          The index of the sprite to be stored
     * @param buildingType
     *          The type of the sprite - of type RegisteredSprite
     *
     * @return The sprite of the building of the given type
     *          null if the building is not yet registered
     */
    public static BuildingSprite createBuildingSprite(
            int index, ResourceType buildingType) {
        switch (buildingType) {
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
                throw new GameSetupException("The given building type is" +
                        " not yet registered in SpritesFactory. Unable to" +
                        " create a building sprite of type: " + buildingType);
        }
    }

    /**
     * Create a sprite of an animal with the given specs
     *
     * @param index
     *          The index of the sprite
     * @param type
     *          The type of the animal sprite
     *
     * @return The animal sprite of the given type, storing the given index
     */
    public static AnimalSprite createAnimalSprite(int index, ResourceType type) {
        switch(type) {
            case SHEEP:
                return createSheep(index, ResourceType.SHEEP);
            case DUCK:
                return createDuck(index, DUCK);
            case COW:
                return createCow(index, ResourceType.COW);
            default:
                throw new GameSetupException("The given animal type is" +
                        " not yet registered in SpritesFactory. Unable to" +
                        " create an animal sprite of type: " + type);
        }
    }
    
    /**
     * Create a sprite of a droppable resource with the given specs
     * 
     * @param index, the index of the sprite
     * @param type, the resourceType of the sprite
     * @return the droppable resource sprite of the given type
     */
    public static DroppedResourceSprite createDroppableResourceSprite(ResourceType type) {
        DroppedResourceSprite sprite = new DroppedResourceSprite(type);
        switch(type) {
        case DUCK: 
            sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(
                    ResourceType.CLOUD
            ));
        }
        return sprite;
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
    private static BuildingSprite createHospital(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
            HOSPITAL_1,
            HOSPITAL_2,
            HOSPITAL_3,
            HOSPITAL_4,
            HOSPITAL_5
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                5.0*REAL_MINUTE,
                1.0, // Total time of idle animation
                idleFrames,
                false
        );
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
    private static BuildingSprite createBakery(int index, ResourceType type) {
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
                REAL_MINUTE*4.0, // from the time passed in the building class
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
    private static BuildingSprite createBarn(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

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
        sprite.setupAnimation(9 * REAL_MINUTE); // Set up the actual animation, passing the duration
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
    private static BuildingSprite createButcher(int index, ResourceType type) {
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
                7.0*REAL_MINUTE,
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
    private static BuildingSprite createCemetery(int index, ResourceType type) {
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
                2.0*REAL_MINUTE,
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
    private static BuildingSprite createChurch(int index, ResourceType type) {
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
                9.0*REAL_MINUTE,
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
    private static BuildingSprite createCommunityBuilding(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

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
        sprite.setupAnimation(8 * REAL_MINUTE); // Set up the actual animation, passing the duration
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
    private static BuildingSprite createFarm(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

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
        sprite.setupAnimation(4 * REAL_MINUTE); // Set up the actual animation, passing the duration
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
    private static BuildingSprite createForge(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
             ResourceType.FORGE_1,
             ResourceType.FORGE_2,
             ResourceType.FORGE_3,
             ResourceType.FORGE_4,
             ResourceType.FORGE_5,
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                2.0*REAL_MINUTE,
                1.0, // Total time of idle animation
                idleFrames,
                false
        );
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
    private static BuildingSprite createHouse(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
            HOUSE_1,
            HOUSE_2,
            HOUSE_3,
            HOUSE_4,
            HOUSE_5,
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                2.0*REAL_MINUTE,
                1.0, // Total time of idle animation
                idleFrames,
                false
        );

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
    private static BuildingSprite createMine(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
            MINE_1,
            MINE_2,
            MINE_3,
            MINE_4
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                3.0*REAL_MINUTE,
                1.0, // Total time of idle animation
                idleFrames,
                false
        );
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
    private static BuildingSprite createObservatory(int index, ResourceType type) {
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
                5.0*REAL_MINUTE,
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
    private static BuildingSprite createPasture(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

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
        sprite.setupAnimation(4 * REAL_MINUTE); // Set up the actual animation, passing the duration
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
    private static BuildingSprite createQuarry(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

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
        sprite.setupAnimation(5 * REAL_MINUTE); // Set up the actual animation, passing the duration
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
    private static BuildingSprite createSawmill(int index, ResourceType type) {
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
                3.0*REAL_MINUTE,
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
        for (ResourceType frameType : idleAnimationFrames) {
            idleFrames.add(register.getResourceImage(frameType));
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
    private static BuildingSprite createSchool(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

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
        sprite.setupAnimation(3 * REAL_MINUTE); // Set up the actual animation, passing the duration
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
    private static BuildingSprite createGymnasium(int index, ResourceType type) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type);

        // Define the key frames for the idle animation
        ResourceType[] idleFrames = {
            GYMNASIUM_1,
            GYMNASIUM_2,
            GYMNASIUM_3,
            GYMNASIUM_4,
            GYMNASIUM_5,
        };

        // Setup the sprite with the given parameters
        setupBuildingSprite(
                sprite,
                type,
                2.0*REAL_MINUTE,
                2.0, // Total time of idle animation
                idleFrames,
                false
        );
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
    private static AnimalSprite createSheep(int index, ResourceType entityType) {
        // The sprite to be returned
        AnimalSprite sprite = new AnimalSprite(index, entityType);

        // Setup the frames for the roaming animation.
        ResourceType[] roamingFrames = {
        ResourceType.SHEEP,
        ResourceType.SHEEPDown0,
        ResourceType.SHEEPDown1,
        ResourceType.SHEEPLeft0,
        ResourceType.SHEEPLeft1,
        ResourceType.SHEEPUp0,
        ResourceType.SHEEPUp1,
        ResourceType.SHEEPRight0,
        ResourceType.SHEEPRight1
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
     * Create and return a generic duck sprite.
     * @param index
     *     The index of the sprite
     * @param entityType
     *     The type of the sprite
     *
     * @return the sprite of a generic duck
     */
    private static AnimalSprite createDuck(int index, ResourceType entityType) {
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
    private static AnimalSprite createCow(int index, ResourceType entityType) {
        // The sprite to be returned
        AnimalSprite sprite = new AnimalSprite(index, entityType);

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
        ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();

        // Add all the frames for the roaming animation.
        for (ResourceType frameType: roamingAnimationFrames) {
            roamingFrames.add(register.getResourceImage(frameType));
        }

        // After all images are set up, now call these methods to set up the actual animation code.
        sprite.setUpRoamingAnimation(roamingFrames, roamingAnimationTime, autoReverse);

        // Now play the construction animation. Idle animation will automatically
        // play when construction animation is done
        sprite.playRoamingAnimation();
    }
}
