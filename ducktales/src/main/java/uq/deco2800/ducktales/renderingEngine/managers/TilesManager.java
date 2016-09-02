package uq.deco2800.ducktales.renderingEngine.managers;

import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.renderingEngine.tiles.TileBeta;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.world.WorldBeta;

/**
 * This class is responsible for managing and updating all the tiles in the
 * game world
 *
 * Created by Khoi on 2/09/2016.
 */
public class TilesManager {

    /** The global game variables */
    private Array2D<TileBeta> tiles; // The array of tiles in the world
    private GameManagerBeta gameManager;

    /**
     * Create a new tile manager with the given handles on the GameManager
     * and the array of tiles in the game world
     *
     * @param gameManager
     *          The manager of the game
     * @param tiles
     */
    public TilesManager(GameManagerBeta gameManager, Array2D<TileBeta> tiles) {
        this.gameManager = gameManager;
        this.tiles = tiles;
    }

    /**
     * Add a building entity to the actual game world. from the given blueprint
     *
     * NOTE: depending on the size of the building, the logic for adding it will
     * be different.
     * For (even)x(even) buildings, the tile clicked will be defined as the tile
     *      closest but lower than the mid-point
     * For (odd)x(odd) buildings, the tile clicked will be defined as the tile
     *      in the middle of the building
     *
     * For (any)x(any)... God Bless.
     *
     * @param buildingType
     *          The type of the building to be constructed
     * @param x
     *          The x-coordinate in tile-unit of the tile that was clicked on
     * @param y
     *          The y-coordinate in tile-unit of the tile that was clicked on
     */
    public void addBuildingToTile(ResourceType buildingType, int x, int y) {

    }


}
