package uq.deco2800.ducktales;

import java.util.ArrayList;

import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.EntityManager;


import uq.deco2800.ducktales.features.entities.agententities.AgentEntity;

import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Building;
import uq.deco2800.ducktales.features.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;


import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.features.landscape.tiles.Tile;
import uq.deco2800.ducktales.util.*;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Models the game's physical environment.
 * 
 * @author Leggy, khoiphan21
 *
 */
public class World implements Tickable {
	/**
	 * CONSTANTS
	 */
	private final ResourceType DEFAULT_TILE_TYPE = GRASS_1;

	/** GENERAL properties of this world */
	private String name; // the name of the world

	/** The landscape of this world */
	private Array2D<Tile> tiles;

	/** The model for the actual game */
	private ArrayList<Entity> entities; // All the entities in the game


	private static ResourceSpriteRegister tileRegister = ResourceSpriteRegister.getInstance();

	/**
	 * Instantiates a World with the given specified parameters, with the tiles
	 * type default to GRASS_1
	 * @param name
	 * @param width
	 * @param height
	 */
	public World(String name, int width, int height) {
		// Instantiates the array of tiles
		tiles = new Array2D<>(width, height);

		// Instantiates the list of entities
		entities = new ArrayList<>();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles.set(x, y, new Tile(DEFAULT_TILE_TYPE));
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

	/**
	 * Add the given entity to the list of entities currently in the world
	 * @param entity
	 */
	public void addEntity(Entity entity) {
		if (entities.contains(entity)) {
			System.err.println("The entity [" + entity.toString() + "] is already" +
					"in the list");
			return;
		}
		entities.add(entity);
	}

	/**
	 * Remove the given entity from the world
	 *
	 * @param entity
	 */
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}

	/**
	 * Return the number of entities currently in the world
	 *
	 * @return the number of entities in the world
	 */
	public int getEntitiesNumber() {
		return this.entities.size();
	}

	/**
	 * Check the availability of the tiles around the given tile. This is mainly
	 * used when a building is to be added to the world.
	 *
	 * Note: The lead tile is the lowest tile. For example. for a 2x2 building:
	 *  .   x   .
	 *    x   x
	 *  .   o   .
	 *       The lead tile is 'o', and the tiles checked will are 'x' tiles
	 *
	 * @param x
	 * 		The x-coordinate of the lead tile
	 * @param y
	 * 		The y-coordinate of the lead tile
	 * @param xLength
	 * 		The length x of the building - define how many tiles to the upper right
	 * 		will be checked
	 * @param yLength
	 * 		The length y of the building - define how many tiles to the upper left
	 * 		will be checked
	 *
	 * @return Whether the building can be added to this tile
	 */
	public boolean checkTileAvailability(int x, int y, int xLength, int yLength) {

		;
		return true;
	}

	@Override
	public void tick() {
		// Update all the tiles
		for (int y = 0; y < tiles.getHeight(); y++) {
			for (int x = 0; x < tiles.getWidth(); x++) {
				tiles.get(x, y).tick();
			}
		}
		// Update all the entities
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
	}


//	/**
//	 * Instantiate the world with the given params, and the tile types are
//	 * randomized between GRASS_1, GRASS_2 and GRASS_3
//	 *
//	 * Entities are also added
//	 *
//	 * @param name
//	 *            The name of the World
//	 * @param width
//	 *            The width of the World
//	 * @param height
//	 *            The height of the World
//	 */
//	@Deprecated
//	public World(String name, int width, int height) {
//		tiles = new Array2D<Tile>(width, height);
//
//		ResourceType[] tileTypes = { GRASS_1, GRASS_2, GRASS_3 };
//
//		Random random = new Random();
//
//		for (int y = 0; y < height; y++) {
//			for (int x = 0; x < width; x++) {
//				// Changed 1 to 1.0 to remove bug, required at least 1 element to be
//				// a double
//				if (Math.sqrt(Math.pow(y + 1.0, 2) + Math.pow(x + 1.0, 2)) < 5) {
//					// Make a basic lake.
//					tiles.set(x, y, new Tile(WATER));
//				} else {
//					tiles.set(x, y, new Tile(tileTypes[random.nextInt(3)]));
//				}
//			}
//		}
//
//		addEntity(new Bakery(13, 6));
//		addEntity(new Box(4, 15));
//
//		addEntity(new Peon(3, 4));
//		addEntity(new Peon(13, 17));
//
//		addEntity(new Duck(0, 10));
//
//
////		addEntity(new Cow(8, 10));
//		addEntity(new Tree(5, 10));
//		addEntity(new Rock(15,15));
//		addEntity(new Tree(10, 10));
//	}


//	/**
//	 * Instantiates a World object with the specified parameters, with the tile
//	 * type defaulting to the given type
//	 *
//	 * @param name
//	 *            The name of the World
//	 * @param width
//	 *            The width of the World
//	 * @param height
//	 *            The height of the World
//	 * @param baseTileType
//	 *            The initial tile type to set every tile to
//	 */
//	public World(String name, int width, int height, ResourceType baseTileType) {
//		tiles = new Array2D<Tile>(width, height);
//
//		Random random = new Random();
//
//		for (int x = 0; x < width; x++) {
//			for (int y = 0; y < height; y++) {
//				tiles.set(x, y, new Tile(baseTileType));
//			}
//		}
//	}







//	public void setTile(int x, int y, ResourceType tileType) {
//		getTile(x, y).setTileType(tileType);
//	}
//
//	public void addEntity(AgentEntity entity) {
//		entityManager.addEntity(entity);
//	}
//
//	public void addEntity(WorldEntity entity) {
//		int entityX = (int) entity.getX();
//		int entityY = (int) entity.getY();
//
//		int xMin = (int) (entity.getX() - entity.getXLength()) + 1;
//		int yMin = (int) (entity.getY() - entity.getYLength()) + 1;
//
//		if (!(xMin >= 0 && entityX < getWidth() && yMin >= 0 && entityY < getHeight())) {
//			System.out.println("CANNOT ADD WORLD ENTITY");
//			return;
//		}
//		entityManager.addEntity(entity);
//
//	}
}
