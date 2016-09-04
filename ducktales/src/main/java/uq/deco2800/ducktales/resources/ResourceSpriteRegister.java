package uq.deco2800.ducktales.resources;

import javafx.scene.image.Image;

import java.util.concurrent.ConcurrentHashMap;
import static uq.deco2800.ducktales.resources.ResourceType.*;


/**
 * Every resource of the same type will have some common attributes such as name,
 * image, type ID etc. Thus this class is used to manage those common resource attributes
 * and also makes it easier for Renderers to retrieve the images of the different
 * resource types. This will also save up memory as each sprite type is only stored once
 *
 * For example, The Tile class holds information about an instance of a tile --
 * however there is information that is common to every Tile of a certain type.
 * This class can manage information of a tile type and removes the requirement
 * of having to know or store the tile type itself. It allows for easy retrieval
 * of tile type information either through the name (as a string) or through the
 * tile type which can be retrieved from the instance method Tile.getResourceType().
 *
 * This class is a singleton -- to get an instance of this class, you must call
 * ResourceSpriteRegister.getInstance(); you cannot instantiate it.
 * 
 * @author Anonymousthing, khoiphan21
 */
public class ResourceSpriteRegister {

	private static final ResourceSpriteRegister INSTANCE = new ResourceSpriteRegister();

	/**
	 * Returns the instance of {@link ResourceSpriteRegister}.
	 * 
	 * @return Returns an instance of ResourceSpriteRegister.
	 */
	public static ResourceSpriteRegister getInstance() {
		return INSTANCE;
	}

	/**
	 * The base height for a 1*1 tile.
	 */
	public static final int TILE_HEIGHT = 100;
	
	/**
	 * The base width for a 1*1 tile.
	 */
	public static final int TILE_WIDTH = 174;

	// As we're a static instance we use a ConcurrentHashMap to prevent
	// potential threading issues
	private ConcurrentHashMap<ResourceType, Image> resourceTypeRegister;
	private int currentCount;

	private ResourceSpriteRegister() {
		resourceTypeRegister = new ConcurrentHashMap<>();
		currentCount = 0;

		// GROUND TILES
		addResource(GRASS_1, "/tiles/grass_1.png");
		addResource(GRASS_2, "/tiles/grass_2.png");
		addResource(GRASS_3, "/tiles/grass_3.png");
		addResource(GRASS_4, "/tiles/grass_4.png");

		// OLD Ground tiles

		/*---Landscape resources---*/
		
		addResource(VOID, "/black.png");
		addResource(CYAN, "/cyan.png");
		addResource(CYAN_CROSSED, "/cyan_crossed.png");
		addResource(YELLOW, "/yellow.png");

		addResource(WATER, "/water.png");
		addResource(BLANK, "/blank.png");

		// OLD Landscape entities

		
		/*---Object resources---*/
		addResource(BOX, "/box2.png");
		addResource(LONG_BOX, "/longbox.png");
		addResource(WOOD_BOX, "/wood_stock.png");
		addResource(TREE_1, "/tree_1.png");
		addResource(TREE_2, "/tree_2.png");
		addResource(TREE_3, "/tree_3.png");
		addResource(ROCK_1, "/rock_1.png");
		addResource(ROCK_2, "/rock_2.png");

		// Agent entities
		addResource(PEON, "/peon.png");
		addResource(DUCK, "/duck.png");
		addResource(DUCKDown0, "/animal/duck/DUCKDown0.png");
		addResource(DUCKDown1, "/animal/duck/DUCKDown1.png");
		addResource(DUCKUp0, "/animal/duck/DUCKUp0.png");
		addResource(DUCKUp1, "/animal/duck/DUCKUp1.png");
		addResource(DUCKLeft0, "/animal/duck/DUCKLeft0.png");
		addResource(DUCKLeft1, "/animal/duck/DUCKLeft1.png");
		addResource(DUCKRight0, "/animal/duck/DUCKRight0.png");
		addResource(DUCKRight1, "/animal/duck/DUCKRight1.png");

		addResource(COW, "/cow.png");
		// the following will be uncommented once the relevant resources
		// are created and added to the game, @team pokeducks

		// addResource(COWUpRight, "/COWUpRight.png");
		// addResource(COWUpLeft, "/COWUpLeft.png");
		// addResource(COWDownRight, "/COWDownRight.png");
		// addResource(COWDownLeft, "/COWDownLeft.png");

		// addResource(SHEEP, "/sheep.png");
		// addResource(SHEEPUpRight, "/SHEEPUpRight.png");
		// addResource(SHEEPUpLeft, "/SHEEPUpLeft.png");
		// addResource(SHEEPDownRight, "/SHEEPDownRight.png");
		// addResource(SHEEPDownLeft, "/SHEEPDownLeft.png");

		// Buildings

		
		/*---Building resources---*/
		
		//To be uncommented as the relevant graphics are created
		// note from creator of ResourceType: please remember to use the enums from
		// ResourceType enum class instead of the previous String implementation
		
		//addResource(MINE, "/mine.png");
		//addResource(FARM, "/farm.png");
		//addResource(QUARRY, "/quarry.png");
		//addResource(PLANTATION, "/plantation.png");
		
		addResource(PASTURE, "/buildings/pasture.png");
		addResource(CLINIC, "/buildings/clinic.png");
		addResource(BUTCHER, "/buildings/butcher.png");
		addResource(BAKERY, "/buildings/bakery.png");
		addResource(COMMUNITY_BUILDING, "/buildings/community_building.png");
		addResource(CONSTRUCTION, "/buildings/construction.png");

		addResource(HOUSE, "/house.png");
		addResource(SAWMILL, "/sawmill.png");

		//addResource(CEMETERY, "/cemetery.png");
		//addResource(FARMHOUSE, "/farm+barn.png");
		//addResource(BARN, "/barn.png");
		//addResource(FORGE, "/forge.png");
		//addResource(HOSPITAL, "/hospital.png");
		//addResource(OBSERVATORY, "/observatory.png");

	}

	/**
	 * Adds a resource to the register.
	 * 
	 * @param type
	 *            The type of the resource
	 * @param imageName
	 *            The file name of the corresponding image
	 */
	private void addResource ( ResourceType type, String imageName) {
		if (resourceTypeRegister.containsKey(type)) {
			throw new RuntimeException(
					"Attempted to add an already registered ResourceTypeInfo \""
							+ type + "\" to a ResourceSpriteRegister");
		}
		resourceTypeRegister.put(type,
				new Image(getClass().getResource(imageName).toString()));
	};

	/**
	 * Retrieves the Image of the specified resource
	 * 
	 * @param resourceType
	 *            The type of the resource
	 * @return The sprite Image of the resource
	 */
	public Image getResourceImage(ResourceType resourceType) {
		if (!resourceTypeRegister.containsKey(resourceType))
			throw new RuntimeException(
					"Attempted to access non-registered ResourceTypeInfo of tile type \""
							+ resourceType + "\" from a ResourceSpriteRegister");
		return resourceTypeRegister.get(resourceType);
	}

}