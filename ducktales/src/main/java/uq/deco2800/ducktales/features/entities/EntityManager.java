package uq.deco2800.ducktales.features.entities;

import java.util.ArrayList;
import java.util.List;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.agententities.Duck;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Manager for all the entities in the game.
 *
 * @author Leggy, khoiphan21
 */
public class EntityManager implements Tickable {

    /** The Instance of this object */
    private static final EntityManager INSTANCE = new EntityManager();

    /** List of the sprite of all entities in the game */
    private ArrayList<EntitySprite> entitySprites;

    /** The game world */
    private World world;

    /**
     * Main constructor of the {@link EntityManager} class
     */
    private EntityManager() {
        entitySprites = new ArrayList<>();
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
        Entity entity = getNewEntity(entityType, x, y);

        // Add that entity to the entities list
        world.addEntity(entity);

        // Add the sprite of the entity to the sprites list, and set the
        // position of that sprite
        entitySprites.add(new EntitySprite(entitySprites.size(), entity.getType()));

    }


    /**
     * Adds a new entity to the game.
     *
     * @param entity The entity to add.
     */
    public void addEntity(Entity entity) {
        // Add the given entity to the world
        world.addEntity(entity);

        // Add the given sprite to the sprites list
        entitySprites.add(new EntitySprite(entitySprites.size(), entity.getType()));
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

    @Override
    public void tick() {

    }

    /**
     * Construct and return a new entity from the given entity type
     *
     * TODO FOR ENTITIES TEAM, IMPLEMENT THIS TO ADD ALL YOUR ENTITIES IN
     *
     * @param entityType
     *          The type of the entity to be constructed
     *
     * @return the entity constructed from the given type
     */
    private Entity getNewEntity(ResourceType entityType, int x, int y) {
        switch (entityType) {
            case DUCK:
                return new Duck(x, y);
            default:
                return new Peon(x, y);
        }
    }

}
