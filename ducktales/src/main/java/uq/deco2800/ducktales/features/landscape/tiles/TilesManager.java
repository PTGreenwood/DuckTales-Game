package uq.deco2800.ducktales.features.landscape.tiles;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.rendering.RenderingInformation;
import uq.deco2800.ducktales.rendering.info.WorldEntityInfo;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.util.SecondaryManager;

/**
 * This class is responsible for managing and updating all the tileSprites in the
 * game world
 *
 * Created on 2/09/2016.
 * @author khoiphan21
 */
public class TilesManager extends SecondaryManager {

    /** The root pane where everything will be added into */
    private Pane rootPane;

    /** The classes that hold different rendering information */
    private WorldEntityInfo worldEntityInfo;
    private ResourceSpriteRegister spriteRegister;

    /** The model and view for the tiles */
    private Array2D<Tile> tiles; // The model of the tiles
    private Array2D<TileSprite> tileSprites; // The view of the tiles


    /**
     * Create a new tile manager with the given handles on the OldGameManager
     * and the array of tileSprites in the game world
     */
    public TilesManager(World world, Pane rootPane, GameManager gameManager) {
        this.world = world;
        this.rootPane = rootPane;
        this.gameManager = gameManager;
        this.spriteRegister = gameManager.getResourceSpriteRegister();
        this.tiles = new Array2D<>(world.getWidth(), world.getHeight());
        this.tileSprites = new Array2D<>(world.getWidth(), world.getHeight());

        // Now load all the information of the tile model and instantiate the
        // corresponding tile sprites
        loadInitialTileInfo();

        // Initiate the rendering info classes
        worldEntityInfo = WorldEntityInfo.getInstance();

    }

    /**
     * Get the tile at the position x and y in the 2D array
     * @param x
     *          The x-coordinate of the tile
     * @param y
     *          The y-coordinate of the tile
     * @return the tile at the given coordinates
     */
    public Tile getTile(int x, int y) {
        return tiles.get(x, y);
    }

    /**
     * Get the sprite for the tile at positions x and y in the 2D array
     * @param x
     *          The x-coordinate of the tile
     * @param y
     *          The y-coordinate of the tile
     * @return the sprite of the tile at the given coordinates
     */
    public TileSprite getTileSprite(int x, int y) {
        return tileSprites.get(x, y);
    }

    /**
     * Get the width of the 2D tiles array of the world
     *
     * @return the width of the world
     */
    public int getWorldWidth() {
        return tiles.getWidth();
    }

    /**
     * Get the height of the 2D tiles array of the world
     *
     * @return the height of the world
     */
    public int getWorldHeight() {
        return tiles.getHeight();
    }

    /**
     * Render the initial world onto the root pane given
     */
    public void renderInitialWorld() {
        int tileHeight = ResourceSpriteRegister.TILE_HEIGHT;
        int tileWidth = ResourceSpriteRegister.TILE_WIDTH;

        double generalScale = RenderingInformation.TILE_SCALE;

        // The scaled width and height of the tile to be rendered
        int scaledWidth = (int) (tileWidth * generalScale);
        int scaledHeight = (int) (tileHeight * generalScale);

        // The point to start rendering from. Note: MAGIC NUMBERS
        double startingX = rootPane.getPrefWidth() / 2;
        double startingY = rootPane.getPrefHeight() * 0.05;

        // Temporary variables to hold the information of each tile
        TileSprite sprite;
        Tile tile;

        // Iterate over each tile and set their location to the default location
        for (int x = 0; x < tiles.getWidth(); x++) {
            for (int y = 0; y < tiles.getHeight(); y++) {
                // Okay tbh, this is a bit of math - draw it out and it makes
                // more sense. Essentially (x, y) is where to put the tile
                double layoutX = startingX + (y - x) * scaledWidth / 2;
                double layoutY = startingY + (y + x) * scaledHeight / 2;

                // Load the temporary variables
                sprite = tileSprites.get(x, y);
                tile = tiles.get(x, y);

                sprite.setImage(spriteRegister.getResourceImage(tile.getTileType()));

                // Adjust the height of the sprite to the given scale
                sprite.setFitHeight(tileHeight * generalScale);
                sprite.setFitWidth(tileWidth * generalScale);

                // Set the position of the tile - where it actually appears
                sprite.setLayoutX(layoutX);
                sprite.setLayoutY(layoutY);

                // Add the tile onto the screen
                rootPane.getChildren().add(sprite);

            }
        }
    }

    /**
     * Load all the information of the tiles in the world to the private list,
     * and instantiate the corresponding tile sprites
     */
    private void loadInitialTileInfo() {
        Tile temporaryTile;

        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                temporaryTile = world.getTile(x, y);

                // Load the tile model of this tile
                this.tiles.set(
                        x, y,
                        temporaryTile
                );

                // Instantiate and load the tile sprite of this tile
                this.tileSprites.set(
                        x, y,
                        new TileSprite(temporaryTile.getTileType(), x, y)
                );
            }
        }
    }

}
