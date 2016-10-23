package uq.deco2800.ducktales.features.entities;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.agententities.AnimalManager;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.features.entities.worldentities.BuildingManager;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Coordinate;
import uq.deco2800.ducktales.util.SpiralPathFinding;
import uq.deco2800.ducktales.util.Tickable;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;
//import uq.deco2800.ducktales.util.SecondaryManager;


/**
 * Manager for all the entities in the game.
 *
 * NOTE: This manager is not to be 'extended'. This is the manager that will
 * instantiate all other helper managers to deal with entities
 *
 * @author Leggy, khoiphan21
 */
public class MainEntityManager implements Tickable {
    /** CONSTANTS */
    private static final int NUMBER_OF_TREES_INITIALLY = 10;

    /** The logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainEntityManager.class);

    /** The Instance of this object */
    private static final MainEntityManager INSTANCE = new MainEntityManager();

    /** The game world */
    private World world;

    /** The game manager */
    private GameManager gameManager;

    /** Helper Managers instantiated by this class */
    private AnimalManager animalManager;
    private BuildingManager buildingManager;
    private PeonManager peonManager;
    private ResourceEntityManager resourceEntityManager;

    /** The registers */
    ResourceInfoRegister infoRegister;
    
    /** Boolean variables for building*/
    private boolean isBuildingBuilt = false;
    
    /**
     * Main constructor of the {@link MainEntityManager} class
     */
    private MainEntityManager() {
        // Instantiate the helper managers
        animalManager = new AnimalManager();
        buildingManager = new BuildingManager();
        peonManager = new PeonManager();
        resourceEntityManager = new ResourceEntityManager();

        infoRegister = ResourceInfoRegister.getInstance();
    }

    /**
     * Gets the instance of the MainEntityManager.
     *
     * @return Returns the MainEntityManager instance.
     */
    public static MainEntityManager getInstance() {
        return INSTANCE;
    }

    /**
     * Start the entity manager's cycles. First task is to check world for
     * entities, and createBuildingSprite the corresponding sprites
     */
    public void startRoutine() {
        if (this.world == null) {
            throw new GameSetupException("MainEntityManager does not have" +
                    " a reference on World yet");
        } else if (this.gameManager == null) {
            throw new GameSetupException("MainEntityManager does not have " +
                    "a reference on GameManager yet");
        }
        // Give the resource entity manager the handle on the world and
        // game manager
        resourceEntityManager.setWorld(this.world);
        resourceEntityManager.setGameManager(this.gameManager);
        resourceEntityManager.createRandomTrees(NUMBER_OF_TREES_INITIALLY);

        // Load the size register
        infoRegister = ResourceInfoRegister.getInstance();

        if (this.world != null) {
            // Check the world for existing entities, and load them into the game
            loadExistingEntities(world);

            // IMPORTANT: set up the helper managers to give them access
            // to important variables of the game
            setupHelperManagers();

        } else {
            throw new GameSetupException(
                    "Entity Manager has not received a handle on World");
        }
    }

    /**
     * Retrieve the manager for all resource entities of the game.
     *
     * @return The manager for all resource entities of the game
     */
    public ResourceEntityManager getResourceEntityManager() {
        return resourceEntityManager;
    }

    /**
     * Give the primary manager a reference of the resource entity manager.
     * This is mainly required for testing purposes
     *
     * @param resourceEntityManager
     *          The manager for all resource entities in the game, such as trees,
     *          rocks, stones, etc.
     */
    public void setResourceEntityManager(ResourceEntityManager resourceEntityManager) {
        this.resourceEntityManager = resourceEntityManager;
    }

    /**
     * Add the animal to the list of managed animals, as well as render that
     * animal into the game
     *
     * @param animalType
     *          The type of the animal to be added
     * @param x
     *          The x-coordinate of the tile where the animal will be added onto
     * @param y
     *          The y-coordinate of the tile where the animal will be added onto
     */
    public void addAnimal(ResourceType animalType, int x, int y) {
        animalManager.addAnimal(animalType, x, y);      
    }

    /**
     * Add a building to the list of managed buildings, as well as render that
     * building into the game
     *
     * @param buildingType
     *          The type of the building to be added
     * @param x
     *          The x-coordinate of the tile where the building will be added
     * @param y
     *          The y-coordinate of that same tile
     */
    public void addBuilding(ResourceType buildingType, int x, int y) {
        if (buildingManager.addBuilding(buildingType, x, y)) {
            // Check if the building type is a house
            if (buildingType == ResourceType.HOUSE) {
                // Tell the peon manager to add a peon at the given house
                this.addPeonToHouse(x, y);
                
            }
            
            //If building is added in the game, change the variable of isBuildingBuilt to true
            this.isBuildingBuilt = true;
            //Actions when the mission is completed
            gameManager.getMissionManager().missionCompletedAction(3);
            
            
        } else {
            // the location requested for the building is not correct.
            // Ideally: display some sort of message to the user
        }
        
    }
    
    
    /**
     * Add a peon to the given house location. The peon will always be added
     * to the 'front' of the house - where it can be seen by the player
     *
     * @param houseLocationX
     *          The x-location of the house where a peon should be added
     * @param houseLocationY
     *          The y-location of the house where a peon should be added
     */
    public void addPeonToHouse(int houseLocationX, int houseLocationY) {
        // The final locations where the peon will be added to
        Coordinate finalLocation;

        // Get the final location using the path finding algorithm
        finalLocation = SpiralPathFinding.getFrontCoordinate(
                houseLocationX,
                houseLocationY,
                infoRegister.getEntitySize(ResourceType.HOUSE, ResourceInfoRegister.X),
                infoRegister.getEntitySize(ResourceType.HOUSE, ResourceInfoRegister.Y),
                this.world
        );

        // Now add the peon to that final location
        this.addPeon(finalLocation.getX(), finalLocation.getY());

    }

    /**
     * Add a peon to the given tile location. The peon will be a generic type
     *
     * @param x
     *          The x-coordinate of the location to add the peon to
     * @param y
     *          The y-coordinate of the location to add the peon to
     */
    public void addPeon(int x, int y) {
        try {
            peonManager.addPeon(x, y);            
            
        } catch (IOException e) {
            // IOException may be due to the 'generateName' method of Peon class
            LOGGER.info("Failed to add a peon to the game", e);
        }
    }
    
    
    public boolean getIsBuildingBuilt() {
    	return this.isBuildingBuilt;
    }
    /**
     * Move all the entity sprites in the game by the given x- and y- amount
     * @param xAmount
     *          The amount to move in x-direction
     * @param yAmount
     *          The amount to move in y-direction
     */
    public void moveAllEntities(double xAmount, double yAmount) {
        animalManager.moveAllAnimalsSprites(xAmount, yAmount);
        buildingManager.moveAllBuildingSprites(xAmount, yAmount);
        peonManager.moveAllPeonSprites(xAmount, yAmount);
        resourceEntityManager.moveAllSprites(xAmount, yAmount);
    }

    /**
     * Set the world for this entity manager
     * @param world
     *          The game world
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Pass this manager a handle on the Game Manager
     * Will also pass this reference to other helper managers in this class
     *
     * @param gameManager
     *          The manager of the game
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;

    }

    @Override
    public void tick() {
        animalManager.updateSpriteLocations();
    }



    /**
     * Check the given world for any existing entities, and createBuildingSprite sprites for
     * each of them, and add the sprites to the world pane accordingly
     *
     * @param world
     *
     */
    private void loadExistingEntities(World world) {
        if (world.getEntitiesNumber() != 0) {
            // There are some entities to make sprites for
        }
    }

    /**
     * Setup the helper managers, passing them references to important
     * variables in the game like GameManager and World
     */
    private void setupHelperManagers() {
        // Give them a handle on the world
        this.animalManager.setWorld(this.world);
        this.buildingManager.setWorld(this.world);
        this.peonManager.setWorld(this.world);

        // Give them a handle on the main game manager
        this.animalManager.setGameManager(this.gameManager);
        this.buildingManager.setGameManager(this.gameManager);
        this.peonManager.setGameManager(this.gameManager);
    }

    /**
     * Method to return the current instance of the Peon manager.
     * Returns the instance of the peon manager that contains all the
     * peons in the game.
     * 
     * @return the instance of the peon manager initialised.
     */
    public PeonManager getPeonManager(){
    	return this.peonManager;
    }
    
    /** 
     * Method to return the current instance of the building manager. 
     * Returns the instance of the building manager that contains all the 
     * sprites in the game.
     * 
     * @return the instance of the building manager intialised.
     */
    public BuildingManager getBuildingManager() {
    	return this.buildingManager;

    }

}
