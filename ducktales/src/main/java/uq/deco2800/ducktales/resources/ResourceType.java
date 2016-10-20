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
        TREE_1_AUTUMN, TREE_1_SPRING, TREE_1_SUMMER, TREE_1_WINTER,
        TREE_2_AUTUMN, TREE_2_SPRING, TREE_2_SUMMER, TREE_2_WINTER,
        TREE_3_AUTUMN, TREE_3_SPRING, TREE_3_SUMMER, TREE_3_WINTER,
        ROCK_1, ROCK_2,

        // PEONS
        PEON,


        // ANIMALS
        DUCK, DUCKUp, DUCKLeft, DUCKRight, DUCKDown, DUCK_FRONT_RIGHT, DUCK_1_1,
        DUCKDown0, DUCKDown1, DUCKLeft0, DUCKLeft1, DUCKRight0, DUCKRight1, DUCKUp0, DUCKUp1,
        COW, COWUpRight, COWUpLeft, COWDownRight, COWDownLeft, COW_FRONT_RIGHT,
        SHEEPUp0, SHEEPUp1, SHEEPDown0, SHEEPDown1, SHEEPLeft0, SHEEPLeft1, SHEEPRight0, SHEEPRight1, SHEEP,
        WOLF,
        
        CLOUD,

        // BUILDINGS
        PASTURE, BUTCHER, BAKERY, COMMUNITY_BUILDING, CONSTRUCTION,
        HOUSE, SAWMILL, CEMETERY, BARN, FORGE, HOSPITAL, OBSERVATORY, FARM,
        MINE, QUARRY, CHURCH, SCHOOL, GYMNASIUM, 
        CONSTRUCTION_2, STORAGEBARN,
        // For buildings' animations
        BUTCHER_1, BUTCHER_2, BUTCHER_3, BUTCHER_4, BUTCHER_5,
        ADV_BUTCHER_1, ADV_BUTCHER_2, ADV_BUTCHER_3, ADV_BUTCHER_4, ADV_BUTCHER_5,
        ADV_HOSPITAL_1, ADV_HOSPITAL_2, ADV_HOSPITAL_3, ADV_HOSPITAL_4, ADV_HOSPITAL_5,
        BAKERY_1, BAKERY_2, BAKERY_3, BAKERY_4, BAKERY_5,
        CEMETERY_1, CEMETERY_2, CEMETERY_3, CEMETERY_4, CEMETERY_5, CEMETERY_6,
            CEMETERY_7, CEMETERY_8, CEMETERY_9, CEMETERY_10, CEMETERY_11, CEMETERY_12,
            CEMETERY_13, CEMETERY_14, CEMETERY_15, CEMETERY_16,
        CHURCH_1, CHURCH_2, CHURCH_3, CHURCH_4, CHURCH_5,
        OBSERVATORY_1, OBSERVATORY_2, OBSERVATORY_3, OBSERVATORY_4, OBSERVATORY_5,
        SAWMILL_1, SAWMILL_2, SAWMILL_3,  SAWMILL_4, SAWMILL_5, SAWMILL_6,

        FORGE_1, FORGE_2, FORGE_3, FORGE_4, FORGE_5,
        GYMNASIUM_1, GYMNASIUM_2, GYMNASIUM_3, GYMNASIUM_4, GYMNASIUM_5,
        HOSPITAL_1, HOSPITAL_2, HOSPITAL_3, HOSPITAL_4, HOSPITAL_5,
        HOUSE_1, HOUSE_2, HOUSE_3, HOUSE_4, HOUSE_5,
        MINE_1, MINE_2, MINE_3, MINE_4,

        // Miscellaneous
        BOX, LONG_BOX, WOOD_BOX

}
