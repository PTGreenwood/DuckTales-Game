package uq.deco2800.ducktales.rendering.managers;

import uq.deco2800.ducktales.resources.ResourceType;

import java.util.HashMap;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This class contains rendering information for all world entities such as
 * building size
 *
 * To add a new building, first register the size of that building in the
 * variable buildingSizes, and then add the enum type of that building to
 * buildingNames. Make sure the order is correct, and watch out for exceptions
 *
 * Created on 3/09/2016.
 * @author khoiphan21
 */
public class WorldEntityInfoManager {
    /** The instance and its getter method of this class */
    private static final WorldEntityInfoManager INSTANCE = new WorldEntityInfoManager();
    public static WorldEntityInfoManager getInstance() {
        return INSTANCE;
    }

    /** CONSTANTS */
    // The size of the array int[] holding the size of the building
    private final int BuildingSize = 2;

    /** Constants to get either the x or y length of the building */
    public static final int XLength = 0;
    public static final int YLength = 1;

    /*
     * INVARIANTS
     *      buildingSizes.length = buildingNames.length
     *      each int[] unit in buildingSizes only has 2 (BuildingSize) values
     */

    /**
     * The data structure holding information of all the building sizes
     *
     * TODO: TO ADD NEW BUILDINGS TO THE BUILDINGS MENU, ADD THEM HERE
     *
     * Note: make sure the order of registering the buildings is correct!
     */
    // The size of the building in tile unit, in the format {x, y}
    private int[][] buildingSizes = {
            {5, 5}, // pasture
            {2, 2}, // butcher
            {2, 2}, // community building
            {2, 2}, // bakery
            {2, 2} // construction

    };
    private ResourceType[] buildingNames = {
            PASTURE,
            BUTCHER,
            COMMUNITY_BUILDING,
            BAKERY,
            CONSTRUCTION
    };

    /**
     * The size of all building-type entities in the game
     */
    private HashMap<ResourceType, int[]> buildingSizeInfo;

    /**
     * Instantiate a world entity info manager and register all world entities
     */
    private WorldEntityInfoManager() {
        buildingSizeInfo = new HashMap<>();

        checkInvariants();

        // Register all building sizes
        for (int i = 0 ; i < buildingSizes.length; i++) {
            registerBuilding(buildingNames[i], buildingSizes[i]);
        }

    }

    /**
     * Get the length of the building in either the x or y direction
     *
     * @param buildingType
     *          The type of the building whose size is requested
     * @param index
     *          Whether it is the x-length or y-length
     *
     * @return the length of the building in the given direction
     *
     * @throws Exception
     *          When the registry is internally inconsistent
     */
    public int getBuildingLength(ResourceType buildingType, int index)
    throws Exception {
        // Check if the registry has the building type given
        if (!buildingSizeInfo.containsKey(buildingType)) {
            throw new Exception("BuildingMenuSprite type requested is not yet registered.");
        }

        // The building type given is in the registry. Check the requested index
        if (index != XLength && index != YLength) {
            throw new Exception("The index given must be " +
                    "WorldEntityInfoManager.XLength or YLength. Given index" +
                    "is: " + index);
        }

        // Everything should be okay at this point
        int[] size = buildingSizeInfo.get(buildingType);

        return size[index];
    }

    /**
     * Check if the info manager has the information for the given building
     * @param buildingType
     *          The type of the building to check
     * @return whether the manager has the information for that building type
     */
    public boolean containEntity(ResourceType buildingType) {
        return buildingSizeInfo.containsKey(buildingType);
    }

    /**
     * Register the building type and its size. size[0] should be the x-length,
     * and size[1] should be the y-length
     *
     * @param buildingType
     * @param size
     */
    private void registerBuilding(ResourceType buildingType, int[] size) {

        if (size.length != BuildingSize) {
            throw new IndexOutOfBoundsException("size of a building must be an" +
                    "array of 2 integers, the first is the x-length and the " +
                    "second is the y-length");
        } else {
            buildingSizeInfo.put(buildingType, size);
        }
    }

    private void checkInvariants() throws ClassFormatError {
        /**
         * The variables to make sure name array is the same size as size array
         */
        int nameArraySize = 0;
        int sizeArraySize = 0;

        for (int i = 0; i < buildingSizes.length; i++) {
            // Check that the length of each item is 2
            if (buildingSizes[i].length != BuildingSize) {
                throw new ClassFormatError("Size of each building must be a 1x2" +
                        "array, with size[0] is the x-length and size[1] is the" +
                        "y-length");
            }

            // increment size array size
            sizeArraySize++;
        }

        for (int i = 0; i < buildingNames.length; i++) {
            // increment name array size
            nameArraySize++;
        }

        // Check if size of name array is equal to that of the size array
        if (nameArraySize != sizeArraySize) {
            throw new ClassFormatError("Size of buildingSizes must be the same" +
                    "as size of buildingNames");
        }
    }

}
