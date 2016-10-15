package uq.deco2800.ducktales.features.entities;

import java.io.IOException;

import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.agententities.AnimalManager;
import uq.deco2800.ducktales.features.entities.worldentities.BuildingManager;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Coordinate;
import uq.deco2800.ducktales.util.SpiralPathFinding;
import uq.deco2800.ducktales.util.Tickable;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * Manager for all the entities in the game.
 *
 * NOTE: This manager is not to be 'extended'. This is the manager that will
 * instantiate all other helper managers to deal with entities
 *
 * @author Leggy, khoiphan21
 */
public class EntityManager implements Tickable {

    /** The world pane to add entities onto */
    private Pane worldDisplay;

    /** The Instance of this object */
    private static final EntityManager INSTANCE = new EntityManager();

    /** The game world */
    private World world;

    /** The game manager */
    private GameManager gameManager;

    /** The other secondary managers */
    private TilesManager tilesManager;

    /** Helper Managers instantiated by this class */
    private AnimalManager animalManager;
    private BuildingManager buildingManager;
    private PeonManager peonManager;

    /** The registers */
    ResourceInfoRegister infoRegister;

    /**
     * Main constructor of the {@link EntityManager} class
     */
    private EntityManager() {
        // Instantiate the helper managers
        animalManager = new AnimalManager();
        buildingManager = new BuildingManager();
        peonManager = new PeonManager();
    }

    /**
     * Gets the instance of the EntityManager.
     *
     * @return Returns the EntityManager instance.
     */
    public static EntityManager getInstance() {
        return INSTANCE;
    }

    /**
     * Start the entity manager's cycles. First task is to check world for
     * entities, and createBuildingSprite the corresponding sprites
     */
    public void startRoutine() {
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

        // The register to get the size of the house
        ResourceInfoRegister infoRegister = ResourceInfoRegister.getInstance();

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
        } catch (IOException exception) {
            // IOException may be due to the 'generateName' method of Peon class
            exception.printStackTrace();
        }
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

    /**
     * Pass this manager a handle on the Tiles Manager
     *
     * @param tilesManager
     *          The tiles manager of the game
     */
    public void setTilesManager(TilesManager tilesManager) {
        this.tilesManager = tilesManager;
    }

    /**
     * Pass this manager a handle on the world display, for it to add entities
     * into
     *
     * @param worldDisplay
     *          The display where all entities in the world is rendered onto
     */
    public void setWorldDisplay(Pane worldDisplay) {
        this.worldDisplay = worldDisplay;
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

}
