package uq.deco2800.ducktales.worldBuilder;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.tiles.Tile;
import uq.deco2800.ducktales.resources.tiles.WorldBuilderTile;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.world.World;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderRenderer extends AnimationTimer {

    /**
     * CONSTANTS
     */
    private final double TRANSPARENCY = 0.5;

    private GraphicsContext graphicsContext;
    private World world;
    private ResourceRegister resourceRegister;
    private int tileHeight;
    private int tileWidth;

    private WorldBuilderManager worldBuilderManager = WorldBuilderManager.getInstance();

    /** The scale/zoom factor */
    private double scale = 0.3;

    private int baseX;
    private int baseY;

    /**
     * starting X and Y positions to render the tiles
     */
    private int startingX;
    private int startingY;

    private Array2D<WorldBuilderTile> tiles;

    @Deprecated
    public WorldBuilderRenderer(GraphicsContext gc) {
        super();
        try {
            this.graphicsContext = gc;
            this.world = WorldBuilderManager.getInstance().getWorld();
            this.resourceRegister = ResourceRegister.getInstance();
            this.tileHeight = ResourceRegister.TILE_HEIGHT;
            this.tileWidth = ResourceRegister.TILE_WIDTH;
            this.baseX = (int) (world.getWidth() * tileWidth * scale * 0.5);
            this.baseY = 0;

        } catch (Exception e) {
            System.out.println("failed to finish world builder constructor");
        }

    }

    public WorldBuilderRenderer(Pane pane) {
        super();
        this.world = WorldBuilderManager.getInstance().getWorld();
        this.resourceRegister = ResourceRegister.getInstance();
        this.tileHeight = ResourceRegister.TILE_HEIGHT;
        this.tileWidth = ResourceRegister.TILE_WIDTH;
        this.startingX = (int) (this.world.getWidth() * tileWidth * scale * 0.5);
        this.startingY = 0;

        createWorld(pane);
    }

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
     * Renders the world to the canvas
     * This method also handles scaling of the world
     *
     */
    @Deprecated
    private void renderWorld() {
        Tile tile;

        int scaledWidth = (int) (tileWidth * scale);
        int scaledHeight = (int) (tileHeight * scale);

        Coordinate top;
        Coordinate bottom;
        Coordinate left;
        Coordinate right;

        boolean polygonDrawing = true;

        try {
            for (int i = 0; i < world.getWidth(); i++) {
                for (int j = 0; j < world.getHeight(); j++) {
                    tile = world.getTile(i, j);
                    int x = baseX + (j - i) * scaledWidth / 2;
                    int y = baseY + (j + i) * scaledHeight / 2;

                    // This is used for testing - only one polygon is drawn
                    if (polygonDrawing) {
                        // Draw the actual image first
                        graphicsContext.drawImage(
                                // Draw the image at position x, y, and scaled to the box with given
                                // scaledWidth and scaledHeight
                                resourceRegister.getResourceImage(tile.getTileType()), x, y,
                                scaledWidth, scaledHeight);

                        // Creating the coordinates to render the overlay polygon
                        top = new Coordinate(x + scaledWidth/2, y);
                        bottom = new Coordinate(x + scaledWidth/2, y + scaledHeight);
                        left = new Coordinate(x, y + scaledHeight/2);
                        right = new Coordinate(x + scaledWidth, y + scaledHeight/2);

                        // Draw the overlaying polygon, to be used for checking mouse click
                        graphicsContext.translate(100, 300);
                        graphicsContext.setFill(Color.BLACK);
                        graphicsContext.setStroke(Color.BLACK);
                        graphicsContext.fillPolygon(
                                new double[] {top.x, right.x, bottom.x, left.x},
                                new double[] {top.y, right.y, bottom.y, left.y},
                                4
                        );
                        graphicsContext.strokePolygon(
                                new double[] {top.x, right.x, bottom.x, left.x},
                                new double[] {top.y, right.y, bottom.y, left.y},
                                4
                        );
                        // polygonDrawing = false;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("failed to render world");
        }

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
