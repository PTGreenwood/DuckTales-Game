package uq.deco2800.ducktales;

import uq.deco2800.ducktales.entities.Box;
import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.UberBox;
import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.tiles.TileRegister;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.WorldManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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
	
	public List<Entity> entities;

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
		this.baseX = (int) (world.getWidth() * tileWidth * scale * 0.5);
		this.baseY = 0;// (int) (world.getHeight() * tileHeight * scale) / 2;
		
		entities = new ArrayList<Entity>();
		entities.add(new Box(14, 14));
		entities.add(new Box(12, 7));
		entities.add(new Box(13, 13));
		entities.add(new Box(7, 5));
		entities.add(new Box(15, 14));
		entities.add(new Box(14, 17));
		entities.add(new UberBox(9, 15));

	}

	@Override
	public void handle(long arg0) {
		renderWorld();
		renderEntities();
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

	private void renderEntities() {
		Collections.sort(entities);
		for(int index = 0; index < entities.size(); index++) {
			Entity box = entities.get(index);
			
			int scaledWidth = (int) (tileWidth * scale);
			int scaledHeight = (int) (tileHeight * scale);

			int i = box.getX() - box.getXLength();
			int j = box.getY() - box.getYLength();

			// for (int i = 0; i < world.getWidth(); i++) {
			// for (int j = 0; j < world.getHeight(); j++) {
			
			Image g = tileRegister.getTileImage(box.getType());
			int x = baseX + (j - i) * scaledWidth / 2;
			int y = baseY + (j + i) * scaledHeight / 2;
			
			//g.hei
			graphicsContext.drawImage(g, x, y, scaledWidth, (int)(scaledHeight * g.getHeight()/tileHeight));
			// }
			// }
		}
		
	}
}
