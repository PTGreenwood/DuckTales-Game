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

        // Tiles
        GRASS_1, GRASS_2, GRASS_3, GRASS_4,
        DIRT_1, DIRT_2, DIRT_3,
        VOID, CYAN, CYAN_CROSSED, YELLOW,
        BLANK,
        WATER,
        
        // Landscape entities
        TREE_1, TREE_2, TREE_3,
        ROCK_1, ROCK_2,

        // Agent entities
        PEON,

        DUCK, DUCKUP, DUCKLEFT, DUCKRIGHT, DUCKDOWN, DUCK_FRONT_RIGHT, DUCK_1_1,
        DUCKDOWN0, DUCKDOWN1, DUCKLEFT0, DUCKLEFT1, DUCKRIGHT0, DUCKRIGHT1, DUCKUP0, DUCKUP1,
        COW, COWUPRIGHT, COWUPLEFT, COWDOWNRIGHT, COWDOWNLEFT, COW_FRONT_RIGHT,
        SHEEP, SHEEPUPRIGHT, SHEEPUPLEFT, SHEEPDOWNRIGHT, SHEEPDOWNLEFT,

        // Buildings
        PASTURE, BUTCHER, BAKERY, COMMUNITY_BUILDING, CONSTRUCTION,
        HOUSE, SAWMILL, CEMETERY, BARN, FORGE, HOSPITAL, OBSERVATORY, FARM,
        MINE, QUARRY, CHURCH,  

        // Miscellaneous
        BOX, LONG_BOX, WOOD_BOX

}
