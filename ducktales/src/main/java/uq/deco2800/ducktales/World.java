package uq.deco2800.ducktales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.resourceentities.DroppableResourceEntity;
import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
import uq.deco2800.ducktales.features.entities.threats.Threat;
import uq.deco2800.ducktales.features.entities.worldentities.Building;
import uq.deco2800.ducktales.features.entities.worldentities.BuildingManager;
import uq.deco2800.ducktales.features.entities.worldentities.StorageProduceBuilding;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;


import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.features.landscape.tiles.Tile;
import uq.deco2800.ducktales.features.seasons.Season;
import uq.deco2800.ducktales.features.seasons.Winter;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.rendering.sprites.BuildingSprite;
import uq.deco2800.ducktales.util.*;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

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
	// The list of production buildings
	private static final ResourceType[] productionBuildingTypes = {
			SAWMILL, MINE, FARM, QUARRY
	};

	/** GENERAL properties of this world */
	private String name; // the name of the world
	private int worldWidth;
	private int worldHeight;

	/** The landscape of this world */
	private Array2D<Tile> tiles;

	/** The model for the actual game */
	private ArrayList<Animal> animals; // All the animals in the game
	private ArrayList<Building> buildings; // All the buildings in the game
	private HashMap<String, Peon> peons; // All the peons in the game
	private ArrayList<Threat> threats;
	private HashMap<Integer, Tree> trees;
	private HashMap<Integer, DroppableResourceEntity> droppedResources; // All the dropped resources in the game

	/** The registers */
	private ResourceInfoRegister infoRegister = ResourceInfoRegister.getInstance();

	/** Helper variables */
	ArrayList<ResourceType> productionBuildingsList;
	
	private int timer = 0;
	
	private ArrayList<Boolean> nightAnimation = new ArrayList<Boolean>();
	
	/**
	 * Instantiates a World with the given specified parameters, with the tiles
	 * type default to GRASS_1
	 *
	 * @param name
	 * 			The name of the world
	 * @param width
	 * 			The width of the world (in tile-unit)
	 * @param height
	 * 			The height of the world (in tile-unit)
	 */
	public World(String name, int width, int height) {
		// Store the properties of the world
		this.name = name;
		this.worldHeight = height;
		this.worldWidth = width;

		// Instantiate game model
		this.tiles = new Array2D<>(width, height);
		this.trees = new HashMap<>(50);
		this.animals = new ArrayList<>(50);
		this.buildings = new ArrayList<>(50);
		this.peons = new HashMap<>(50);
		this.threats = new ArrayList<>(50);
		this.droppedResources = new HashMap<>(50);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles.set(x, y, new Tile(DEFAULT_TILE_TYPE));
			}
		}

		// add the types of buildings that belong to production buildings to the
		// list for easier retrieval
		this.productionBuildingsList = new ArrayList<>();
		for (ResourceType type : productionBuildingTypes) {
			productionBuildingsList.add(type);
		}
	}

	/**
	 * Get the name of the world
	 *
	 * @return The name of the world.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the default tile type.
	 * 
	 * @return The ResourceType used as the default tile type.
	 */
	public static ResourceType getDefaultTileType() {
		return DEFAULT_TILE_TYPE;
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
		return this.worldWidth;
	}

	/**
	 * @return The height of the World
	 */
	public int getHeight() {
		return this.worldHeight;
	}

	/**
	 * Add an animal to the world
	 *
	 * @param animal
	 * 			The animal to be added to the world
	 */
	public void addAnimal(Animal animal) {
		if (animals.contains(animal)) {
			throw new GameSetupException("Animal already exists in the game");
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
			throw new GameSetupException("Peon name already exists. Please" +
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
			throw new GameSetupException("Fail to retrieve a peon. Peon with" +
					" name: \"" + peonName + "\" has not been added to the" +
					"game yet.");
		}
	}

	/**
	 * Add a tree to the world model, throwing an exception if a tree with
	 * the same hashcode is already in the model
	 *
	 * @param tree
	 * 			The tree to be added to the model
	 */
	public void addTree(Tree tree) {
		if (!trees.containsKey(tree.hashCode())) {
			trees.put(tree.hashCode(), tree);
		} else {
			throw new GameSetupException("Failed to add a tree to the world." +
					" A tree with the same hashcode already exists in the " +
					"model");
		}
	}

	/**
	 * Retrieve the {@link Tree} with the given hashcode from the game model
	 * {@link GameSetupException} is thrown if the given hashcode is not
	 * a key in the hashmap
	 *
	 * @param treeHashcode
	 * 			The hashcode of the tree to be retrieved
	 */
	public Tree getTree(int treeHashcode) {
		if (trees.containsKey(treeHashcode)) {
			return trees.get(treeHashcode);
		} else {
			throw new GameSetupException("A tree with the given hashcode" +
					" does not exist in the game model");
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
	 * Get the droppedResource with the given index
	 * 
	 * @return The dropped resource at the given index in the droppedResources 
	 *         List
	 */
	public DroppableResourceEntity getDroppedResource(int hashCode) {
		if(droppedResources.containsKey(hashCode)) {
			return droppedResources.get(hashCode);
		} else {
			throw new GameSetupException("Fail to retrieve a droppedResource."
				+ " droppedResource with the given hashCode has not been added"
					+ " to the game yet.");
		}
	}
	
	/**
	 * Set a dropped resource in the droppedResource List using the 
	 * given Value
	 */
	public void addDroppedResource(DroppableResourceEntity value) {
		if(droppedResources.containsKey(value.hashCode())) {
			throw new GameSetupException("droppedResources already contains "
					+ "a dropped resource with value: " + value);
		} else {
			droppedResources.put(value.hashCode(), value);
		}	
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
		// Add the entity
		if (buildings.contains(building)) {
			throw new GameSetupException("This building has already " +
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

	/**
	 * Return the number of entities currently in the world
	 *
	 * @return the number of entities in the world
	 */
	public int getEntitiesNumber() {
		return animals.size() + buildings.size() + peons.size() + trees.size()
				+ droppedResources.size();
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
	 * @return true if the location given is available
	 * 		   false otherwise
	 */
	public boolean checkTileAvailability(int startX, int startY, int xLength, int yLength) {
		for (int x = 0; x < xLength; x++) {
			for (int y = 0; y < yLength; y++) {

				// this is a bit of math. write it down and it will make more sense
				Tile tile = tiles.get(startX - x, startY - y);

				if (tile.isPassable()) {
					continue;
				} else {
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
		
		// change the animation between day/night animation depending on time of day
		// declared here, as not used elsewhere within the class
		MainEntityManager mainManager = MainEntityManager.getInstance();
		BuildingManager buildingManager = mainManager.getBuildingManager();
		GameManager gameManager = GameManager.getGameManager();
		TimeManager timeManager = gameManager.getTimeManager();
		
		List<BuildingSprite> buildingSprites = buildingManager.getBuildingSprites();
				
		boolean isWinter = timeManager.seasonManager.getCurrentSeason().getName() 
				== "Winter";

		for (int x = 0; x < buildingSprites.size(); x++) {
			// Set the new buildings to be true of false depending on time of day (to get 
			// right animation started) 
			if (nightAnimation.size() < buildingSprites.size()) {
				for (int y = nightAnimation.size(); y < buildingSprites.size(); y++) {
					nightAnimation.add(y, timeManager.isNight());
				}
			}		
			
			
			// Day time during winter
			if ((isWinter) && // Check its winter
					// Check its day time and not updated
					(!timeManager.isNight() && nightAnimation.get(x))) { 
				BuildingSprite buildingSprite = buildingSprites.get(x);
				if (buildingSprite.winterDayAnimation(buildingSprite.getEntityType())) {
					nightAnimation.set(x, true);
				}
			}
			// Night time during winter
			else if ((isWinter) && // Check its winter
					// Check its night and not updated
					(timeManager.isNight() && !nightAnimation.get(x))) {
				BuildingSprite buildingSprite = buildingSprites.get(x);
				if (buildingSprite.winterNightAnimation(buildingSprite.getEntityType())) {
					nightAnimation.set(x, false);
				}
			}
			// Its night time, change animation to night type - NOT WINTER
			else if (!nightAnimation.get(x) && timeManager.isNight() && !isWinter) {
				BuildingSprite buildingSprite = buildingSprites.get(x);
				if (buildingSprite.nightAnimation(buildingSprite.getEntityType())) {
					nightAnimation.set(x, true);
				}
			} 
			// Its day time, change animation to day type - NOT WINTER
			else if (nightAnimation.get(x) && !timeManager.isNight() && !isWinter) {
				BuildingSprite buildingSprite = buildingSprites.get(x);
				if (buildingSprite.dayAnimation(buildingSprite.getEntityType())) {
					nightAnimation.set(x, false);
				}
			}
		}
		
		// Update all the tiles
		for (int y = 0; y < tiles.getHeight(); y++) {
			for (int x = 0; x < tiles.getWidth(); x++) {
				tiles.get(x, y).tick();
			}
		}
		// Update all the animals
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).tick();
		}
		// Produce materials every 1000 ticks

		ResourceType buildingType;
		for (int j = 0; j < buildings.size(); j++) {
			buildingType = buildings.get(j).getType();
			if (productionBuildingsList.contains(buildingType) && timer%1000==0) {
				StorageProduceBuilding buildingSelected = 
						buildings.get(j).toStorageProduceBuilding(buildings.get(j));
				buildingSelected.produceMaterial();
			}
		}
	}
	
	/** gets number of peons for achievement tracking */
	public int getNumberOfPeons() {
		return peons.size();
	}

}
