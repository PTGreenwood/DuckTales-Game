package uq.deco2800.ducktales.worldBuilder;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.GameRenderer;
import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.tiles.ResourceRegister;
import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.world.World;

/**
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderRenderer extends AnimationTimer {
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
            System.out.println("failed to finish worldbuilder constructor");
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

        try {
            for (int i = 0; i < world.getWidth(); i++) {
                for (int j = 0; j < world.getHeight(); j++) {
                    tile = world.getTile(i, j);
                    int x = baseX + (j - i) * scaledWidth / 2;
                    int y = baseY + (j + i) * scaledHeight / 2;
                    graphicsContext.drawImage(
                            // Draw the image at position x, y, and scaled to the box with given
                            // scaledWidth and scaledHeight
                            resourceRegister.getResourceImage(tile.getTileType()), x, y,
                            scaledWidth, scaledHeight);
                }
            }
        } catch (Exception e) {
            System.out.println("failed to render world");
        }

    }
}
