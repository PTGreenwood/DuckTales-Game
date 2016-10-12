package uq.deco2800.ducktales.features.entities;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.agententities.AnimalManager;
import uq.deco2800.ducktales.features.entities.worldentities.BuildingManager;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.rendering.sprites.EntitySprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Manager for all the entities in the game.
 *
 * @author Leggy, khoiphan21
 */
public class EntityManager implements Tickable {

    /** The world pane to add entities onto */
    private Pane worldDisplay;

    /** The Instance of this object */
    private static final EntityManager INSTANCE = new EntityManager();

    /** List of the sprite of all entities in the game */
    private ArrayList<EntitySprite> entitySprites;

    /** List of animals that have been registered in the HUD Menu */
    private ArrayList<ResourceType> registeredAnimals;

    /** The game world */
    private World world;

    /** The game manager */
    private GameManager gameManager;

    /** The other secondary managers */
    private TilesManager tilesManager;

    /** Helper Managers instantiated by this class */
    private AnimalManager animalManager;
    private BuildingManager buildingManager;

    /** The registers */
    ResourceInfoRegister infoRegister;

    /**
     * Main constructor of the {@link EntityManager} class
     */
    private EntityManager() {
        entitySprites = new ArrayList<>();

        // Load the list of registered animals in the HUD Menu
        registeredAnimals = new ArrayList<>();
        for (int i = 0; i < MenuManager.ANIMALS.length; i++) {
            registeredAnimals.add(MenuManager.ANIMALS[i]);
        }

        // Instantiate the helper managers
        animalManager = new AnimalManager();
        buildingManager = new BuildingManager();
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

            // Give the handle of the world to the helper managers
            animalManager.setWorld(this.world);
            buildingManager.setWorld(this.world);

        } else {
            System.err.println("Entity Manager has not received a handle on World");
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
        animalManager.addAnimal(animalType, x, y, registeredAnimals);
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
        buildingManager.addBuilding(buildingType, x, y);
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
     * Get the sprite of the entity at the given index
     *
     * @param index
     *          The index of the sprite
     */
    public EntitySprite getEntitySprite(int index) {
        return entitySprites.get(index);
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

        // Give the handle on game manager to secondary managers
        this.animalManager.setGameManager(gameManager);
        this.buildingManager.setGameManager(gameManager);
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



}
