package uq.deco2800.ducktales.world;

import java.util.Random;

import uq.deco2800.ducktales.entities.EntityManager;

import uq.deco2800.ducktales.entities.agententities.*;
import uq.deco2800.ducktales.entities.resourceentities.*;
import uq.deco2800.ducktales.entities.worldentities.*;

import uq.deco2800.ducktales.tiles.ResourceRegister;

import uq.deco2800.ducktales.tiles.Tile;
import uq.deco2800.ducktales.util.*;

/**
 * Models the game's physical environment.
 * 
 * @author Leggy
 *
 */
public class World implements Tickable {
	private Array2D<Tile> tiles;
	private String name;
	private static ResourceRegister tileRegister = ResourceRegister.getInstance();
	private static EntityManager entityManager = EntityManager.getInstance();

	/**
	 * Instantiates a World object with the specified parameters.
	 *
	 * Entities are also added
	 * 
	 * @param name
	 *            The name of the World
	 * @param width
	 *            The width of the World
	 * @param height
	 *            The height of the World
	 * @param baseTileType
	 *            The initial tile type to set every tile to
	 */
	public World(String name, int width, int height, int baseTileType) {
		tiles = new Array2D<Tile>(width, height);

		int[] tileTypes = { tileRegister.getResourceType("grass_1"), tileRegister.getResourceType("grass_2"),
				tileRegister.getResourceType("grass_3") };

		Random random = new Random();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (Math.sqrt(Math.pow(y + 1, 2) + Math.pow(x + 1, 2)) < 5) {
					// Make a basic lake.
					tiles.set(x, y, new Tile(tileRegister.getResourceType("water")));
				} else {
					tiles.set(x, y, new Tile(tileTypes[random.nextInt(3)]));
				}
			}
		}

		addEntity(new Sawmill(13, 6));
		addEntity(new Box(4, 15));

		addEntity(new Peon(3, 4));
		addEntity(new Peon(13, 17));
	}

	/**
	 * Instantiates a World object with the specified parameters, with the tile
	 * type defaulting to type "grass_1".
	 * 
	 * @param name
	 *            The name of the World
	 * @param width
	 *            The width of the World
	 * @param height
	 *            The height of the World
	 */
	public World(String name, int width, int height) {
		tiles = new Array2D<Tile>(width, height);

		Random random = new Random();

		for (int y = 0; y < width; y++) {
			for (int x = 0; x < height; x++) {
				tiles.set(x, y, new Tile(tileRegister.getResourceType("grass_1")));
			}
		}
	}

	/**
	 * @return The name of the world.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieves a Tile at the specified coordinates.
	 * 
	 * @param x
	 *            The x-coordinate of the Tile to retrieve
	 * @param y
	 *            The y-coordinate of the Tile to retrieve
	 * @return The Tile at the specified coordinates
	 */
	public Tile getTile(int x, int y) {
		return tiles.get(x, y);
	}

	public Tile getTile(Point point) {
		return tiles.get((int) point.getX(), (int) point.getY());
	}

	/**
	 * @return The width of the World
	 */
	public int getWidth() {
		return tiles.getWidth();
	}

	/**
	 * @return The height of the World
	 */
	public int getHeight() {
		return tiles.getHeight();
	}

	@Override
	public void tick() {
		for (int y = 0; y < tiles.getHeight(); y++) {
			for (int x = 0; x < tiles.getWidth(); x++) {
				tiles.get(x, y).tick();
			}
		}
	}

	public void setTile(int x, int y, int tileType) {
		getTile(x, y).setTileType(tileType);
	}

	public void addEntity(AgentEntity entity) {
		entityManager.addEntity(entity);

	}

	public void addEntity(WorldEntity entity) {
		int entityX = (int) entity.getX();
		int entityY = (int) entity.getY();

		int xMin = (int) (entity.getX() - entity.getXLength()) + 1;
		int yMin = (int) (entity.getY() - entity.getYLength()) + 1;

		if (!(xMin >= 0 && entityX < getWidth() && yMin >= 0 && entityY < getHeight())) {
			System.out.println("CANNOT ADD WORLD ENTITY");
			return;
		}
		for (int x = xMin; x <= entityX; x++) {
			for (int y = yMin; y <= entityY; y++) {
				tiles.get(x, y).setWorldEntity(entity);
			}
		}
		entityManager.addEntity(entity);

	}
}
