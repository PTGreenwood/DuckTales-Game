package uq.deco2800.ducktales.resources;

import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.agententities.Cow;
import uq.deco2800.ducktales.features.entities.agententities.Duck;
import uq.deco2800.ducktales.features.entities.agententities.Sheep;
import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Butcher;
import uq.deco2800.ducktales.features.entities.worldentities.CommunityBuilding;
import uq.deco2800.ducktales.features.entities.worldentities.Pasture;

import java.util.concurrent.ConcurrentHashMap;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This class holds the information of the size of entities
 *
 * Created on 10/09/2016.
 * @author khoiphan21
 */
public class ResourceInfoRegister {
    /**
     * CONSTANTS
     */
    public static final int X = 0; // The variable to retrieve the size from
    public static final int Y = 1;


    private static ResourceInfoRegister ourInstance = new ResourceInfoRegister();

    public static ResourceInfoRegister getInstance() {
        return ourInstance;
    }

    /** The maps holding information of the resources */
    private ConcurrentHashMap<ResourceType, ResourceInfo> entityInformation;

    /*
     * Invariant: each values in sizeInfo must have exactly 2 integers in the int[]
     *            array
     */

    /**
     * Instantiate an empty resource size register
     */
    private ResourceInfoRegister() {
        entityInformation = new ConcurrentHashMap<>();

        // Start registering entity sizes here
        register(BAKERY, Bakery.X_LENGTH, Bakery.Y_LENGTH, Bakery.PASSABLILITY);

    }

    /**
     * Get the size of the given entity
     *
     * @param entityType
     *          The entity whose size is to be acquired
     * @param direction
     *          Which size to be get - either ResourceInfoRegister.X or .Y
     *
     * @return the size in the given direction
     *         0 if the entity has not been registered
     */
    public int getEntitySize(ResourceType entityType, int direction)
            throws ResourceRegisterException{
        if (entityInformation.containsKey(entityType)) {
            int size;

            switch (direction) {
                case X:
                    size = entityInformation.get(entityType).getSizeX();
                    break;
                case Y:
                    size = entityInformation.get(entityType).getSizeY();
                    break;
                default:
                    size = 0;
                    break;
            }
            return size;
        } else {
            throw new ResourceRegisterException("Entity type " + entityType + "'s " +
                    " size is not yet registered in ResourceInfoRegister");
        }
    }

    /**
     * Return an actual instance of the entity of the given type
     *
     * TODO FOR ENTITIES TEAMS, IMPLEMENT THIS TO ADD ALL YOUR ENTITIES IN
     *
     * @param entityType
     *          The type of entity to construct
     * @param x
     *          The x-coordinate of the entity
     * @param y
     *          The y-coordinate of the entity
     *
     * @return an instance of the entity of the given type,
     *          null if the entity is not yet registered
     */
    public static Entity getEntity(ResourceType entityType, int x, int y) {
        Entity entity = null;

        // Check for all world entities here
        switch (entityType) {
            case BUTCHER:
                entity = new Butcher(x, y);
                break;
            case COMMUNITY_BUILDING:
                entity = new CommunityBuilding(x, y);
                break;
            case BAKERY:
                entity = new Bakery(x, y);
                break;
            case PASTURE:
                entity = new Pasture(x, y);
                break;
            case CONSTRUCTION:
                break;
        }

        // Check for all agent entities here
        switch(entityType) {
            case SHEEP:
                entity = new Sheep(x, y);
                break;
            case COW:
                entity = new Cow(x, y);
                break;
            case DUCK:
                entity = new Duck(x, y);
                break;
        }

        return entity;
    }

    /**
     * Register the given entity into the entityInformation list
     * @param entityType
     * @param sizeX
     * @param sizeY
     * @param isPassable
     * @throws ResourceRegisterException
     */
    private void register(ResourceType entityType, int sizeX, int sizeY, boolean isPassable)
            throws ResourceRegisterException {
        if (!entityInformation.containsKey(entityType)) {
            // Construct a new resource info object
            ResourceInfo resource = new ResourceInfo(entityType, sizeX, sizeY, isPassable);

            entityInformation.put(entityType, resource);
        } else {
            throw new ResourceRegisterException("Entity type: " + entityType + " is" +
                    " already registered in ResourceInfoRegister");
        }
    }

    /**
     * The helper class that holds information of one type of entity
     */
    class ResourceInfo {
        /** The information of an entity */
        private ResourceType type;
        private int sizeX;
        private int sizeY;
        private boolean isPassable;

        /**
         * Construct an object to store information about a given class
         * @param type
         * @param sizeX
         * @param sizeY
         * @param isPassable
         */
        public ResourceInfo(ResourceType type, int sizeX,
                            int sizeY, boolean isPassable) {
            this.type = type;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.isPassable = isPassable;
        }

        public ResourceType getType() {
            return type;
        }

        public int getSizeX() {
            return sizeX;
        }

        public int getSizeY() {
            return sizeY;
        }

        public boolean isPassable() {
            return isPassable;
        }
    }
}
