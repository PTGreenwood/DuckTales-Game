package uq.deco2800.ducktales.features.entities;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.agententities.AnimalManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.features.landscape.tiles.Tile;
import uq.deco2800.ducktales.features.landscape.tiles.TileSprite;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.rendering.RenderingInformation;
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
     * entities, and createEntitySprite the corresponding sprites
     */
    public void startRoutine() {
        // Load the size register
        infoRegister = ResourceInfoRegister.getInstance();

        if (this.world != null) {
            // Check the world for existing entities, and load them into the game
            loadExistingEntities(world);

            // Give the handle of the world to the helper managers
            animalManager.setWorld(this.world);

        } else {
            System.err.println("Entity Manager has not received a handle on World");
        }
    }

    /**
     * Adds a new entity from the given type to the game, by creating a new
     * instance of the entity type
     *
     * @param entityType
     *          The type of entity to be added
     * @param x
     *          The x-coordinate of the tile to add the entity to
     * @param y
     *          The y-coordinate of the tile to add the entity to
     */
    public void addEntity(ResourceType entityType, int x, int y) {
        // Constructs a new entity from the given type
        Entity entity = ResourceInfoRegister.getEntity(entityType, x, y);

        // check if the entity has been registered
        if (entity != null) {
            // Check if the entity is an agent entity registered in HUD Manager
            if (registeredAnimals.contains(entityType)) {
                Animal animal = (Animal) entity;
                animal.setGameManager(this.gameManager);
            }

            // Add that entity to the entities list
            world.addEntity(entity);

            // Add the sprite of the entity to the sprites list, and set the
            // position of that sprite
            EntitySprite sprite = SpritesFactory.createEntitySprite(entitySprites.size(), entityType);
            if (sprite == null) {
                System.err.println("Sprite of type " + entityType + "" +
                        " is not yet registered in SpritesFactory");
                return;
            }

            // Setup the sprite
            Sprite.setupAgentEntitySprite(sprite, x, y,
                    gameManager.getWorldDisplayManager().getTilesManager());

            entitySprites.add(sprite);

            worldDisplay.getChildren().add(sprite);
        } else {
            System.err.println("Entity type: " + entityType + " is not yet" +
                    "registered in EntityManager");
        }
    }


    /**
     * Add the animal to the list of managed animals
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
     * Add the type of the given world entity to the world map, after checking
     * the validity of the addition
     *
     * @param entityType
     *          The type of world entity to be added
     * @param x
     *          The x-coordinate of the lead tile
     * @param y
     *          The y-coordinate of the lead tile
     */
    public void addWorldEntity(ResourceType entityType, int x, int y) {
        Entity entity = ResourceInfoRegister.getEntity(entityType, x, y);
        // Check if the entity has been registered
        if (entity != null) {
            // Get the size of the given entity
            int xLength = infoRegister.getEntitySize(entityType, ResourceInfoRegister.X);
            int yLength = infoRegister.getEntitySize(entityType, ResourceInfoRegister.Y);

            // Check validity of that building
            if (world.checkTileAvailability(x, y, xLength, yLength)) {
                // It is valid to add this tile

                // Add that entity to the entities list
                world.addWorldEntity(entity, x, y, xLength, yLength);

                // Add the sprite of the entity to the sprites list, and set the
                // position of that sprite
                EntitySprite sprite = SpritesFactory.createEntitySprite(entitySprites.size(), entity.getType());
                if (sprite == null) {
                    System.err.println("Sprite of type " + entityType + "" +
                            " is not yet registered in SpritesFactory");
                    return;
                }

                // Setup the sprite
                Sprite.setupAgentEntitySprite(sprite, x, y,
                        gameManager.getWorldDisplayManager().getTilesManager());

                entitySprites.add(sprite);

                worldDisplay.getChildren().add(sprite);
            } else {
                System.err.println("location is not valid");
            }
        } else {
            System.err.println("Entity type: " + entityType + " is not yet" +
                    "registered in EntityManager");
        }
    }

//    /**
//     * Set up the sprite based on its given tile-unit location
//     *
//     * @param sprite
//     *          The sprite to be set up
//     * @param x
//     *          The x-coordinate of the sprite
//     * @param y
//     *          The y-coordinate of the sprite
//     */
//    private void setupSprite(EntitySprite sprite, int x, int y) {
//        // Set the fit width and height of the sprite, based on the given
//        // rendering scale
//        double mainScale = RenderingInformation.MAIN_SCALE_FACTOR;
//        sprite.setFitHeight(sprite.getImage().getHeight() * mainScale);
//        sprite.setFitWidth(sprite.getImage().getWidth() * mainScale);
//
//        // Adjust the offset of the sprite, so that it is at the middle of the
//        // bottom of the sprite
//        sprite.setX(-sprite.getFitWidth() / 2);
//        sprite.setY(-sprite.getFitHeight());
//
//        // Get the sprite of the tile at the given location
//        TileSprite tileSprite = tilesManager.getTileSprite(x, y);
//
//        // set the location of the entity sprite based on the given tile
//        sprite.setLayoutX(tileSprite.getLayoutX() + tileSprite.getFitWidth() / 2);
//        sprite.setLayoutY(tileSprite.getLayoutY() + tileSprite.getFitHeight());
//    }

    /**
     * Get the number of entity sprites currently rendered into the world
     *
     * @return the number of entity sprites rendered into the world
     */
    public int getSpriteAmount() {
        return entitySprites.size();
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
     * Removes an entity from the game.
     *
     * @param entity The entity to be removed.
     */
    public void removeEntity(Entity entity) {
        world.removeEntity(entity);
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
        this.animalManager.setGameManager(gameManager);
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
//        updateSpriteLocations();
        animalManager.updateSpriteLocations();
    }

//    /**
//     * Update the location of the sprites based on the current location
//     * of the model of each sprite
//     */
//    private void updateSpriteLocations() {
//        // UPDATE THE LOCATION OF ALL ENTITY SPRITES
//        Entity entity;
//        EntitySprite sprite;
//        TileSprite tileSprite;
//        for (int i = 0; i < entitySprites.size(); i++) {
//            // Get the entity and its corresponding sprite, tile and tile sprite
//            entity = world.getEntity(i);
//            sprite = getEntitySprite(i);
//            tileSprite = tilesManager.getTileSprite(
//                    sprite.getxLocation(), sprite.getyLocation()
//            );
//
//            // Now the magic happens: update the location of the sprite according to the
//            // stored location of the model
//            Sprite.updateSpriteLocation(entity, sprite, tileSprite);
//
//        }
//    }


    /**
     * Check the given world for any existing entities, and createEntitySprite sprites for
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
