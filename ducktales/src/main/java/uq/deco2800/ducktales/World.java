package uq.deco2800.ducktales;

import java.util.ArrayList;
import java.util.HashMap;


import uq.deco2800.ducktales.features.entities.Entity;

import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.worldentities.Building;
import uq.deco2800.ducktales.features.entities.worldentities.StorageProduceBuilding;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
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
	private static final ResourceType DEFAULT_TILE_TYPE = GRASS_1;

	/** GENERAL properties of this world */
	private String name; // the name of the world

	/** The landscape of this world */
	private Array2D<Tile> tiles;

	/** The model for the actual game */
	private ArrayList<Entity> entities; // Note: will be gradually removed
	private ArrayList<Animal> animals; // All the animals in the game
	private ArrayList<Building> buildings; // All the buildings in the game
	private HashMap<String, Peon> peons; // All the peons in the game

	/** The registers */
	private ResourceSpriteRegister tileRegister = ResourceSpriteRegister.getInstance();
	private ResourceInfoRegister infoRegister = ResourceInfoRegister.getInstance();
	
	private int timer = 0;
	
	/**
	 * Instantiates a World with the given specified parameters, with the tiles
	 * type default to GRASS_1
	 * @param name
	 * @param width
	 * @param height
	 */
	public World(String name, int width, int height) {
		// Instantiates the model of the game
		tiles = new Array2D<>(width, height);
		entities = new ArrayList<>();
		animals = new ArrayList<>();
		buildings = new ArrayList<>();
		peons = new HashMap<>(50); 

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
	 * Add an animal to the world
	 *
	 * @param animal
	 * 			The animal to be added to the world
	 */
	public void addAnimal(Animal animal) {
		if (animals.contains(animal)) {
			throw new RuntimeException("Animal already exists in the game");
		} else {
			animals.add(animal);
		}
	}

	/**
	 * Add a peon to the game. This will check if the name of the peon
	 * is already in the name list.
	 *
	 * @param peonName
	 * 			The name of the peon. This is used to retrieve a peon when
	 * 			needed
	 * @param peonObject
	 * 			The actual peon object to be stored
	 */
	public void addPeon(String peonName, Peon peonObject) {
		if (!peons.containsKey(peonName)) {
			peons.put(peonName, peonObject);
		} else {
			throw new RuntimeException("Peon name already exists. Please" +
					"make sure peon name is checked when adding a new one");
		}
	}

	/**
	 * Retrieve the peon of the given name.
	 *
	 * @param peonName
	 *			The name of the peon is a unique identifier used to
	 *			Retrieve the peon. The sprite of the peon will have the
	 *			same identifier
	 *
	 * @return The peon with the given name/identifier
	 */
	public Peon getPeon(String peonName) {
		if (peons.containsKey(peonName)) {
			return peons.get(peonName);
		} else {
			throw new RuntimeException("Fail to retrieve a peon. Peon with" +
					" name: \"" + peonName + "\" has not been added to the" +
					"game yet.");
		}
	}

	/**
	 * Check if the given name is in the list of names of peons that have
	 * already been added to the world
	 *
	 * @param peonName
	 * 			The name to be checked
	 * @return {@code true} if name is already in the list
	 * 		   {@code false} if there is no duplication - the name is vailable
	 */
	public boolean checkPeonNameDuplication(String peonName) {
		return peons.containsKey(peonName);
	}

	/**
	 * Get the animal with the given index
	 *
	 * @param index
	 * 			The index of the animal
	 * @return The animal at the given index
	 */
	public Animal getAnimal(int index) {
		return animals.get(index);
	}

	/**
	 * Add the given building to the list of buildings, and set the tiles that
	 * it is on to its type, and its passability
	 *
	 * @param building
	 * 			The entity to be added
	 * @param startX
	 * 			The x-coordinate of the lead tile
	 * @param startY
	 * 			The y-coordinate of the lead tile
	 * @param xLength
	 * 			The x-length of the building
	 * @param yLength
	 * 			The y-length of the building
	 */
	public void addBuilding(Building building, int startX, int startY,
							int xLength, int yLength) {
		if (!entities.contains(building)) {
			// Add the entity
			if (buildings.contains(building)) {
				throw new RuntimeException("This building has already " +
						"been added to the world");
			} else {
				buildings.add(building);
			}

			// Set the tiles' worldEntity value and passability value
			for (int x = 0; x < xLength; x++) {
				for (int y = 0; y < yLength; y++) {
					// this is a bit of math. write it down and it will make more sense
					Tile tile = tiles.get(startX - x, startY - y); // Get the tile

					// Set world entity
					tile.setWorldEntityType(building.getType());
					// Set passability
					tile.setPassable(infoRegister.getPassability(building.getType()));

				}
			}
		}
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
	 * Get the entity at the given index. For the current implementation,
	 * the index of the entity and the index of the sprite will be the same
	 * @param index
	 * 			The index of the entity to be retrieved
	 *
	 * @return the entity at the given index
	 */
	public Entity getEntity(int index) {
		return entities.get(index);
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
	 * @param startX
	 * 		The x-coordinate of the lead tile
	 * @param startY
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
	public boolean checkTileAvailability(int startX, int startY, int xLength, int yLength) {
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {

				// this is a bit of math. write it down and it will make more sense
				Tile tile = tiles.get(startX - x, startY - y);

				if (tile.isPassable()) {
					continue;
				} else {
					// This tile has something in it
					System.out.println(startX-x);
					System.out.println(tile.getTileType());
					return false;
				}
			}
		}

		// Everything should be okay at this point
		return true;
	}

	@Override
	public void tick() {
		timer++;
		// Update all the tiles
		for (int y = 0; y < tiles.getHeight(); y++) {
			for (int x = 0; x < tiles.getWidth(); x++) {
				tiles.get(x, y).tick();
			}
		}
		// Update all the entities
		// TODO: REPLACE GENERIC ENTITIES WITH SPECIFIC ENTITIES, AND REMOVE THIS
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		// Update all the animals
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).tick();
		}
		// Produce materials every 1000 ticks
		for (int j = 0; j < buildings.size(); j++) {
			if (buildings.get(j).getType() == ResourceType.SAWMILL && 
					timer%1000==0) {
				StorageProduceBuilding buildingSelected = 
						buildings.get(j).toStorageProduceBuilding(buildings.get(j));
				buildingSelected.produceMaterial();
			}
		}
	}

}
