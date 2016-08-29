package uq.deco2800.ducktales.resources;

/**
 * This enum class holds the name for all types of resources in the game
 * to be used by ResourceRegister
 *
 * When adding a new type, remember to put in comments for easier management
 * in the future
 *
 * Created on 24/08/2016.
 * @author khoiphan21
 */
public enum ResourceType {
        // For WorldBuilder
        NONE,

        // Landscape
        TREE_1, TREE_2, TREE_3,
        GRASS_1, GRASS_2, GRASS_3,
        DIRT_1, DIRT_2, DIRT_3,
        VOID, CYAN, CYAN_CROSSED, YELLOW,
        BLANK,
        WATER,

        // Entities
        PEON,DUCK,COW, SHEEP,

        // Buildings
        HOUSE, SAWMILL, BAKERY, CEMETERY, BARN, FORGE, HOSPITAL, OBSERVATORY, FARMHOUSE,

        // Miscellaneous
        BOX, LONG_BOX, WOOD_BOX

}
