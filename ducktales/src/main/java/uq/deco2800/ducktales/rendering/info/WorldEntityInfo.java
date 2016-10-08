package uq.deco2800.ducktales.rendering.info;

import uq.deco2800.ducktales.resources.ResourceType;

import java.util.HashMap;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This class contains rendering information for all world entities such as
 * building size
 *
 * To add a new building, first register the size of that building in the
 * variable BUILDINGSIZEs, and then add the enum type of that building to
 * buildingNames. Make sure the order is correct, and watch out for exceptions
 *
 * Created on 3/09/2016.
 * @author khoiphan21
 */
public class WorldEntityInfo {
    /** The instance and its getter method of this class */
    private static final WorldEntityInfo INSTANCE = new WorldEntityInfo();
    public static WorldEntityInfo getInstance() {
        return INSTANCE;
    }

    /** CONSTANTS */
    // The size of the array int[] holding the size of the building
    private static final int BUILDINGSIZE = 2;

    /** Constants to get either the x or y length of the building */
    public static final int XLENGTH = 0;
    public static final int YLENGTH = 1;

    /*
     * INVARIANTS
     *      BUILDINGSIZEs.length = buildingNames.length
     *      each int[] unit in BUILDINGSIZEs only has 2 (BUILDINGSIZE) values
     */

    /**
     * The data structure holding information of all the building sizes
     *
     * TODO: TO ADD NEW BUILDINGS TO THE BUILDINGS MENU, ADD THEM HERE
     *
     * Note: make sure the order of registering the buildings is correct!
     */
    // The size of the building in tile unit, in the format {x, y}
    private int[][] BUILDINGSIZEs = {
            {5, 5}, // pasture
            {2, 2}, // butcher
            {2, 2}, // community building
            {2, 2}, // bakery
            {2, 2}, // construction
            {5, 5},  // SAWMILL
            {2, 2}, // forge
            {2, 2}, //house
            {2, 2}, //observatory
            {5, 5}, //mine
            {2, 2}, // hospital
            {2, 2}, // cemetery
            {2, 2}, // church
            {5, 5}, // farmhouse
            {5, 5}, // quarry
            {5, 5}, //School
            {2, 2} //gymnasium

    };
    private ResourceType[] buildingNames = {
            PASTURE,
            BUTCHER,
            COMMUNITY_BUILDING,
            BAKERY,
            CONSTRUCTION, 
            SAWMILL, 
            FORGE,
            HOUSE,
            OBSERVATORY,
            MINE,
            HOSPITAL,
            CEMETERY,
            CHURCH,
            FARM,
            QUARRY,
            SCHOOL,
            GYMNASIUM
    };

    /**
     * The size of all building-type entities in the game
     */
    private HashMap<ResourceType, int[]> BUILDINGSIZEInfo;

    /**
     * Instantiate a world entity info manager and register all world entities
     */
    private WorldEntityInfo() {
        BUILDINGSIZEInfo = new HashMap<>();

        checkInvariants();

        // Register all building sizes
        for (int i = 0 ; i < BUILDINGSIZEs.length; i++) {
            registerBuilding(buildingNames[i], BUILDINGSIZEs[i]);
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
        if (!BUILDINGSIZEInfo.containsKey(buildingType)) {
            throw new Exception("BuildingMenuSprite type requested is not yet registered.");
        }

        // The building type given is in the registry. Check the requested index
        if (index != XLENGTH && index != YLENGTH) {
            throw new Exception("The index given must be " +
                    "WorldEntityInfo.XLENGTH or YLENGTH. Given index" +
                    "is: " + index);
        }

        // Everything should be okay at this point
        int[] size = BUILDINGSIZEInfo.get(buildingType);

        return size[index];
    }

    /**
     * Check if the info manager has the information for the given building
     * @param buildingType
     *          The type of the building to check
     * @return whether the manager has the information for that building type
     */
    public boolean containEntity(ResourceType buildingType) {
        return BUILDINGSIZEInfo.containsKey(buildingType);
    }

    /**
     * Register the building type and its size. size[0] should be the x-length,
     * and size[1] should be the y-length
     *
     * @param buildingType
     * @param size
     */
    private void registerBuilding(ResourceType buildingType, int[] size) {

        if (size.length != BUILDINGSIZE) {
            throw new IndexOutOfBoundsException("size of a building must be an" +
                    "array of 2 integers, the first is the x-length and the " +
                    "second is the y-length");
        } else {
            BUILDINGSIZEInfo.put(buildingType, size);
        }
    }

    private void checkInvariants() throws ClassFormatError {
        /**
         * The variables to make sure name array is the same size as size array
         */
        int nameArraySize = 0;
        int sizeArraySize = 0;

        for (int i = 0; i < BUILDINGSIZEs.length; i++) {
            // Check that the length of each item is 2
            if (BUILDINGSIZEs[i].length != BUILDINGSIZE) {
                throw new ClassFormatError("Size of each building must be a 1x2" +
                        "array, with size[0] is the x-length and size[1] is the" +
                        "y-length");
            }

            sizeArraySize++;
        }

        for (int i = 0; i < buildingNames.length; i++) {
            nameArraySize++;
        }

        // name array's size MUST be equal to size array's size
        if (nameArraySize != sizeArraySize) {
            throw new ClassFormatError("Size of BUILDINGSIZEs must be the same" +
                    "as size of buildingNames");
        }
    }

}
