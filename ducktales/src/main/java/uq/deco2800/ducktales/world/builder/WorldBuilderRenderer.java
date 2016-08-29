package uq.deco2800.ducktales.world.builder;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.resources.tiles.Tile;
import uq.deco2800.ducktales.resources.tiles.WorldBuilderTile;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.world.World;

import java.util.ArrayList;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderRenderer extends AnimationTimer {

    /**
     * CONSTANTS
     */
    private final double TRANSPARENCY = 0.5;
    private final ResourceType[] TILE_TYPES = {
            GRASS_1, GRASS_2, GRASS_3, DIRT_1, DIRT_2, DIRT_3};

    /** General rendering variables */
    private World world;
    private ResourceRegister resourceRegister;
    private int tileHeight;
    private int tileWidth;

    /** The scale/zoom factor */
    private double scale = 0.2;

    /**
     * starting X and Y positions to render the tiles
     */
    private int startingX;
    private int startingY;

    /**
     * The array containing all the tiles in the current world for this builder
     */
    private Array2D<WorldBuilderTile> tiles;

    public WorldBuilderRenderer(Pane buildingScene, VBox tileMenu, HBox resourceMenu) {
        super();
        this.world = WorldBuilderManager.getInstance().getWorld();
        this.resourceRegister = ResourceRegister.getInstance();
        this.tileHeight = ResourceRegister.TILE_HEIGHT;
        this.tileWidth = ResourceRegister.TILE_WIDTH;

        // Setup the initial point where the rendering will start from
        this.startingX = (int) (this.world.getWidth() * tileWidth * scale * 0.5);
        this.startingY = (int) (this.world.getHeight() * tileHeight * scale * 0.3);

        createWorld(buildingScene);
        createTileMenu(tileMenu);
        createResourceMenu(resourceMenu);
    }

    public void setCurrentTileSelected(ResourceType tileType) {
        for (int i = 0; i < tiles.getWidth(); i++) {
            for (int j = 0; j < tiles.getHeight(); j++) {
                tiles.get(i, j).setHoverType(tileType);
            }
        }
    }

    /**
     * Create the menu with all the resources to be added to the world
     * @param resourceMenu
     */
    private void createResourceMenu(HBox resourceMenu) {

    }

    /**
     * Create the menu with all the tiles to be added to the world
     * @param tileMenu
     */
    private void createTileMenu(VBox tileMenu) {
        for (int i = 0; i < TILE_TYPES.length; i++) {
            tileMenu.getChildren().add(new TileSprite(TILE_TYPES[i]));
        }
    }


    /**
     * Create and render the world into the world building scene
     * @param pane
     *          The pane to render all the tiles and resources into
     */
    private void createWorld(Pane pane) {
        this.tiles = new Array2D<>(world.getWidth(), world.getHeight());

        int scaledWidth = (int) (tileWidth * scale);
        int scaledHeight = (int) (tileHeight * scale);

        WorldBuilderTile tile;

        System.out.println("Starting width: " + this.startingX);


        // Create the array of ImageViews
        for (int i = 0; i < this.world.getWidth(); i++) {
            for (int j = 0; j < this.world.getHeight(); j++) {
                tiles.set(i, j, new WorldBuilderTile(i, j));

                int x = startingX + (j - i) * scaledWidth / 2;
                int y = startingY + (j + i) * scaledHeight / 2;

                tile = tiles.get(i, j);
                tile.setImage(resourceRegister.getResourceImage(GRASS_1));

                tile.setFitHeight(resourceRegister.TILE_HEIGHT*scale);
                tile.setFitWidth(resourceRegister.TILE_WIDTH*scale);

                tile.setLayoutX(x);
                tile.setLayoutY(y);

                pane.getChildren().add(tile);
            }
        }

    }

    @Override
    public void handle(long arg0) {
        //renderWorld();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    /**
     * The class used to store the coordinates for each tile whenever rendering each tile
     * The purpose of this class is to make rendering the tiles more understandable
     */
    private class Coordinate {
        private double x;
        private double y;

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return this.x;
        }
        public double getY() {
            return this.y;
        }
    }
}
