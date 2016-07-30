package uq.deco2800.ducktales;

import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.tiles.TileRegister;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.WorldManager;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

/**
 * GameRenderer renders the {@link World}.
 * 
 * @author Leggy
 *
 */
public class GameRenderer extends AnimationTimer {

	private GraphicsContext graphicsContext;
	private World world;
	private TileRegister tileRegister;
	private int tileHeight;
	private int tileWidth;

	/** The scale/zoom factor */
	private double scale = 0.3;

	private int baseX;
	private int baseY;

	public GameRenderer(GraphicsContext graphicsContext) {
		super();

		this.graphicsContext = graphicsContext;
		this.world = WorldManager.getInstance().getWorld();
		this.tileRegister = TileRegister.getInstance();
		this.tileHeight = TileRegister.TILE_HEIGHT;
		this.tileWidth = TileRegister.TILE_WIDTH;
		this.baseX = (int) (world.getWidth() * tileWidth * scale) / 2;
		this.baseY = (int) (world.getHeight() * tileHeight * scale) / 2;

	}

	@Override
	public void handle(long arg0) {
		renderWorld();
	}

	/**
	 * Renders the world to the canvas.
	 */
	private void renderWorld() {
		Tile tile = null;

		int scaledWidth = (int) (tileWidth * scale);
		int scaledHeight = (int) (tileHeight * scale);

		for (int i = 0; i < world.getWidth(); i++) {
			for (int j = 0; j < world.getHeight(); j++) {
				tile = world.getTile(i, j);
				int x = baseX + (j - i) * scaledWidth / 2;
				int y = baseY + (j + i) * scaledHeight / 2;
				graphicsContext.drawImage(
						tileRegister.getTileImage(tile.getTileType()), x, y,
						scaledWidth, scaledHeight);
			}
		}
	}
}
