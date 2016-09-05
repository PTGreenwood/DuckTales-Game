package uq.deco2800.ducktales.world;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.rendering.tiles.TileBeta;
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
    private final ResourceType DefaultTileType = ResourceType.GRASS_1;

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
     * Get the width of the world, in tile-unit
     *
     * @return The width of the world
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the world, in tile-unit
     *
     * @return The height of the world
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the tile at position x and y given
     *
     * @param x
     *          The x-coordinate of the tile
     * @param y
     *          The y-coordinate of the tile
     *
     * @return The tile at the given coordinate
     */
    public TileBeta getTile(int x, int y) {
        return tiles.get(x, y);
    }

    /**
     * Return a handle on the array containing the tiles in the current world
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
        this.tiles = new Array2D<TileBeta>(this.width, this.height);

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                tiles.set(x, y, new TileBeta(DefaultTileType, x, y));
            }
        }
    }
}
