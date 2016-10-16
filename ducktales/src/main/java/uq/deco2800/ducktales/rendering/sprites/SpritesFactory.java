package uq.deco2800.ducktales.rendering.sprites;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.GameManager;
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

    /**
     * This is supposed to only hide the implicit public declaration only
     *
     * It does not need to do anything (yet)
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
    public static PeonSprite createPeonSprite(String peonName,
                                              GameManager gameManager) {
        // Check if the name given is an empty string
        String emptyString = "";
        if (peonName.equals(emptyString)) {
            throw new GameSetupException("Peon name cannot be an empty string");
        }

        PeonSprite sprite = new PeonSprite(peonName);

        // Retrieve the sprite register
        ResourceSpriteRegister spriteRegister = gameManager.getResourceSpriteRegister();

        // Set the image of the peon
        sprite.setImage(spriteRegister.getResourceImage(
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The sprite of the building of the given type
     *          null if the building is not yet registered
     */
    public static BuildingSprite createBuildingSprite(
            int index, ResourceType buildingType,
            GameManager gameManager
    ) {
        switch (buildingType) {
            // BUILDINGS
            case HOSPITAL:
                return createHospital(index, ResourceType.HOSPITAL, gameManager);
            case BAKERY:
                return createBakery(index, ResourceType.BAKERY, gameManager);
            case BARN:
                return createBarn(index, ResourceType.BARN, gameManager);
            case BUTCHER:
                return createButcher(index, ResourceType.BUTCHER, gameManager);
            case CEMETERY:
                return createCemetery(index, ResourceType.CEMETERY, gameManager);
            case CHURCH:
                return createChurch(index, ResourceType.CHURCH, gameManager);
            case COMMUNITY_BUILDING:
                return createCommunityBuilding(index, ResourceType.COMMUNITY_BUILDING, gameManager);
            case FARM:
                return createFarm(index, ResourceType.FARM, gameManager);
            case FORGE:
                return createForge(index, ResourceType.FORGE, gameManager);
            case HOUSE:
                return createHouse(index, ResourceType.HOUSE, gameManager);
            case MINE:
                return createMine(index, ResourceType.MINE, gameManager);
            case OBSERVATORY:
                return createObservatory(index, ResourceType.OBSERVATORY, gameManager);
            case PASTURE:
                return createPasture(index, ResourceType.PASTURE, gameManager);
            case QUARRY:
                return createQuarry(index, ResourceType.QUARRY, gameManager);
            case SAWMILL:
                return createSawmill(index, ResourceType.SAWMILL, gameManager);
            case SCHOOL:
                return createSchool(index, ResourceType.SCHOOL, gameManager);
            case GYMNASIUM:
                return createGymnasium(index, ResourceType.GYMNASIUM, gameManager);
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The animal sprite of the given type, storing the given index
     */
    public static AnimalSprite createAnimalSprite(
            int index, ResourceType type, GameManager gameManager
    ) {
        switch(type) {
            case SHEEP:
                return createSheep(index, ResourceType.SHEEP, gameManager);
            case DUCK:
                return createDuck(index, DUCK, gameManager);
            case COW:
                return createCow(index, ResourceType.COW, gameManager);
            default:
                throw new GameSetupException("The given animal type is" +
                        " not yet registered in SpritesFactory. Unable to" +
                        " create an animal sprite of type: " + type);
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
    private static BuildingSprite createHospital(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a bakery
     */
    private static BuildingSprite createBakery(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
    	
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                true,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a barn
     */
    private static BuildingSprite createBarn(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.BARN));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(9 * (double) REAL_MINUTE); // Set up the actual animation, passing the duration
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a butcher
     */
    private static BuildingSprite createButcher(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a cemetery
     */
    private static BuildingSprite createCemetery(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a church
     */
    private static BuildingSprite createChurch(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                true,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a community Building
     */
    private static BuildingSprite createCommunityBuilding(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.COMMUNITY_BUILDING));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(8 * (double) REAL_MINUTE); // Set up the actual animation, passing the duration
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a farm
     */
    private static BuildingSprite createFarm(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.FARM));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(4 * (double) REAL_MINUTE); // Set up the actual animation, passing the duration
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a forge
     */
    private static BuildingSprite createForge(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a house
     */
    private static BuildingSprite createHouse(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a mine
     */
    private static BuildingSprite createMine(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing an observatory
     */
    private static BuildingSprite createObservatory(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                true,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a pasture
     */
    private static BuildingSprite createPasture(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.PASTURE));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(4 * (double) REAL_MINUTE); // Set up the actual animation, passing the duration
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a quarry
     */
    private static BuildingSprite createQuarry(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.QUARRY));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(5 * (double) REAL_MINUTE); // Set up the actual animation, passing the duration
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a sawmill
     */
    private static BuildingSprite createSawmill(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                true,
                gameManager.getResourceSpriteRegister()
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
            boolean autoReverse,
            ResourceSpriteRegister register
    ) {
        // Setup the frames for the animations
        List<Image> constructionFrames = new ArrayList<>();
        List<Image> idleFrames = new ArrayList<>();

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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a school
     */
    private static BuildingSprite createSchool(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();

        // Now add all the images representing the animation here, one-by-one
        //imageList.add(register.getResourceImage(ResourceType.DIRT_1));  DOES NOT WORK
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION_2));
        imageList.add(register.getResourceImage(ResourceType.CONSTRUCTION));
        imageList.add(register.getResourceImage(ResourceType.SCHOOL));

        // After all images are set up, now call these methods to set up the
        // actual animation code
        sprite.setImageList(imageList); // Give the interpolator the list of images
        sprite.setupAnimation(3 * (double) REAL_MINUTE); // Set up the actual animation, passing the duration
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return The EntitySprite representing a gymnasium
     */
    private static BuildingSprite createGymnasium(int index, ResourceType type, GameManager gameManager) {
        // The sprite to be returned
        BuildingSprite sprite = new BuildingSprite(index, type, gameManager);

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
                false,
                gameManager.getResourceSpriteRegister()
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
     * @param gameManager
     *          The main manager of the game
     *
     * @return the sprite of a generic sheep
     */
    private static AnimalSprite createSheep(
            int index, ResourceType entityType, GameManager gameManager
    ) {
        // The sprite to be returned
        AnimalSprite sprite = new AnimalSprite(index, entityType, gameManager);

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
        SpritesFactory.setupAnimalSprite(
                sprite,
                entityType,
                1.0,
                roamingFrames,
                true,
                gameManager.getResourceSpriteRegister()
        );

        return sprite;
    }

    /**
     * Create and return a generic duck sprite.
     * @param index
     *     The index of the sprite
     * @param animalType
     *     The type of the sprite
     * @param gameManager
     *          The main manager of the game
     *
     * @return the sprite of a generic duck
     */
    private static AnimalSprite createDuck(
            int index, ResourceType animalType, GameManager gameManager) {
        // The sprite to be returned
        AnimalSprite sprite = new AnimalSprite(index, animalType, gameManager);

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
                animalType,
                1.0,
                roamingFrames,
                true,
                gameManager.getResourceSpriteRegister()
        );

        return sprite;
    }

    /**
     * Create and return a generic cow sprite.
     * @param index
     *     The index of the sprite
     * @param entityType
     *     The type of the sprite
     * @param gameManager
     *          The main manager of the game
     *
     * @return the sprite of a generic duck
     */
    private static AnimalSprite createCow(int index, ResourceType entityType, GameManager gameManager) {
        // The sprite to be returned
        AnimalSprite sprite = new AnimalSprite(index, entityType, gameManager);

        // Setup the frames for the animation
        List<Image> imageList = new ArrayList<>();
        ResourceSpriteRegister register = gameManager.getResourceSpriteRegister();
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
            boolean autoReverse,
            ResourceSpriteRegister register
    ) {
        // Setup the frames for the animations
        List<Image> roamingFrames = new ArrayList<>();

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
