package uq.deco2800.ducktales.world;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.resources.tiles.TileBeta;
import uq.deco2800.ducktales.util.Array2D;

/**
 * This is the model of the game world. It will contain information of
 * all entities in the game world
 *
 * Created on 31/08/2016.
 *
 * @author khoiphan21
 */
public class WorldBeta {
    /**
     * CONSTANTS
     */
    private final ResourceType DEFAULT_TILE_TYPE = ResourceType.GRASS_1;

    /** Properties of this world */
    private String name;
    private int width; // in tile-unit
    private int height; // in tile-unit

    /** The landscape of the world */
    private Array2D<TileBeta> tiles;

    public WorldBeta(String name, int widthTileUnit, int heightTileUnit) {
        this.name = name;
        this.width = widthTileUnit;
        this.height = heightTileUnit;

        initializeDefaultTiles();
    }


    /*---------*
     * GETTERS *
     *---------*/

    /**
     * Get the array containing the tiles in the current world
     *
     * @return  The set of tiles in the current world
     */
    public Array2D<TileBeta> getTiles() {
        return tiles;
    }

    /**
     * Initialize the array of tiles to the default type
     */
    private void initializeDefaultTiles() {

    }
}
