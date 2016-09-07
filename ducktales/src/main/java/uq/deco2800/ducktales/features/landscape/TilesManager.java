package uq.deco2800.ducktales.features.landscape;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.deprecated.GameManagerBeta;
import uq.deco2800.ducktales.deprecated.GameRendererBeta;
import uq.deco2800.ducktales.features.landscape.tiles.TileBeta;
import uq.deco2800.ducktales.rendering.info.WorldEntityInfo;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Array2D;

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
    private GameRendererBeta renderer;

    /** The managers that manage different rendering information */
    private WorldEntityInfo worldEntityInfo;

    /**
     * Create a new tile manager with the given handles on the OldGameManager
     * and the array of tiles in the game world
     *
     * @param gameManager
     *          The manager of the game
     * @param tiles
     */
    public TilesManager(GameManagerBeta gameManager,
                        Array2D<TileBeta> tiles, GameRendererBeta renderer) {
        this.gameManager = gameManager;
        this.tiles = tiles;
        this.renderer = renderer;

        // Initiate the info manager for world entities
        worldEntityInfo = WorldEntityInfo.getInstance();

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
        int xLength = 0;
        int yLength = 0;

        // Get the x- and y-length of the building type given
        try {
            xLength = worldEntityInfo.getBuildingLength(
                    buildingType,
                    worldEntityInfo.XLength
            );
            yLength = worldEntityInfo.getBuildingLength(
                    buildingType,
                    worldEntityInfo.YLength
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // At this point, there should be no more problem

        // Set the appropriate tiles to the building type, and make them non-passable
        if (xLength == 2 && yLength == 2) {
            ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
            Image image = register.getResourceImage(ResourceType.BLANK);
            // 2 x 2 building
            // Set the bottom tile
            tiles.get(x, y).setWorldEntity(buildingType);
            tiles.get(x, y).setPassable(false);
            // Set the top tile
            tiles.get(x - 1, y - 1).setWorldEntity(buildingType);
            tiles.get(x - 1, y - 1).setPassable(false);
            // Set the left tile
            tiles.get(x, y - 1).setWorldEntity(buildingType);
            tiles.get(x, y - 1).setPassable(false);
            // Set the right tile
            tiles.get(x - 1, y).setWorldEntity(buildingType);
            tiles.get(x - 1, y).setPassable(false);
        }
    }


}
