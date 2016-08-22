package uq.deco2800.ducktales.worldBuilder;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uq.deco2800.ducktales.tiles.ResourceRegister;
import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.world.World;

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

    @Override
    public void handle(long arg0) {
        renderWorld();
    }

    /**
     * Renders the world to the canvas
     * This method also handles scaling of the world
     */
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
//                    graphicsContext.drawImage(
//                            // Draw the image at position x, y, and scaled to the box with given
//                            // scaledWidth and scaledHeight
//                            resourceRegister.getResourceImage(tile.getTileType()), x, y,
//                            scaledWidth, scaledHeight);

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
                        graphicsContext.setGlobalAlpha(TRANSPARENCY);
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

                        graphicsContext.drawImage(
                                // Draw the image at position x, y, and scaled to the box with given
                                // scaledWidth and scaledHeight
                                resourceRegister.getResourceImage(tile.getTileType()), x, y,
                                scaledWidth, scaledHeight);
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
