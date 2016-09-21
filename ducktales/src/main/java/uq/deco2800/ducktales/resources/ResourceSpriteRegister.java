package uq.deco2800.ducktales.resources;

import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.image.Image;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import static uq.deco2800.ducktales.resources.ResourceType.BAKERY;
import static uq.deco2800.ducktales.resources.ResourceType.BLANK;
import static uq.deco2800.ducktales.resources.ResourceType.BOX;
import static uq.deco2800.ducktales.resources.ResourceType.BUTCHER;
import static uq.deco2800.ducktales.resources.ResourceType.CHURCH;
import static uq.deco2800.ducktales.resources.ResourceType.COMMUNITY_BUILDING;
import static uq.deco2800.ducktales.resources.ResourceType.CONSTRUCTION;
import static uq.deco2800.ducktales.resources.ResourceType.COW;
import static uq.deco2800.ducktales.resources.ResourceType.COW_FRONT_RIGHT;
import static uq.deco2800.ducktales.resources.ResourceType.CYAN;
import static uq.deco2800.ducktales.resources.ResourceType.CYAN_CROSSED;
import static uq.deco2800.ducktales.resources.ResourceType.DUCK;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKDown0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKDown1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKLeft0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKLeft1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKRight0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKRight1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKUp0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKUp1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCK_1_1;
import static uq.deco2800.ducktales.resources.ResourceType.FORGE;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_1;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_2;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_3;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_4;
import static uq.deco2800.ducktales.resources.ResourceType.HOSPITAL;
import static uq.deco2800.ducktales.resources.ResourceType.HOUSE;
import static uq.deco2800.ducktales.resources.ResourceType.LONG_BOX;
import static uq.deco2800.ducktales.resources.ResourceType.MINE;
import static uq.deco2800.ducktales.resources.ResourceType.OBSERVATORY;
import static uq.deco2800.ducktales.resources.ResourceType.PASTURE;
import static uq.deco2800.ducktales.resources.ResourceType.PEON;
import static uq.deco2800.ducktales.resources.ResourceType.ROCK_1;
import static uq.deco2800.ducktales.resources.ResourceType.ROCK_2;
import static uq.deco2800.ducktales.resources.ResourceType.SAWMILL;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEP;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEPRight0;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEPRight1;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_1;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_2;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_3;
import static uq.deco2800.ducktales.resources.ResourceType.VOID;
import static uq.deco2800.ducktales.resources.ResourceType.WATER;
import static uq.deco2800.ducktales.resources.ResourceType.WOOD_BOX;
import static uq.deco2800.ducktales.resources.ResourceType.YELLOW;


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
		addResource(DUCK_1_1, "/animal/duck_1_1.png");

		addResource(DUCKDown0, "/animal/duck/DUCKDown0.png");
		addResource(DUCKDown1, "/animal/duck/DUCKDown1.png");
		addResource(DUCKUp0, "/animal/duck/DUCKUp0.png");
		addResource(DUCKUp1, "/animal/duck/DUCKUp1.png");
		addResource(DUCKLeft0, "/animal/duck/DUCKLeft0.png");
		addResource(DUCKLeft1, "/animal/duck/DUCKLeft1.png");
		addResource(DUCKRight0, "/animal/duck/DUCKRight0.png");
		addResource(DUCKRight1, "/animal/duck/DUCKRight1.png");

		addResource(SHEEPDown0, "/animal/sheep/SHEEPDown0.png");
		addResource(SHEEPDown1, "/animal/sheep/SHEEPDown1.png");
		addResource(SHEEPUp0, "/animal/sheep/SHEEPUp0.png");
		addResource(SHEEPUp1, "/animal/sheep/SHEEPUp1.png");
		addResource(SHEEPLeft0, "/animal/sheep/SHEEPLeft0.png");
		addResource(SHEEPLeft1, "/animal/sheep/SHEEPLeft1.png");
		addResource(SHEEPRight0, "/animal/sheep/SHEEPRight0.png");
		addResource(SHEEPRight1, "/animal/sheep/SHEEPRight1.png");
		
        addResource(SHEEP, "/animal/sheep_with_wool.png");

		addResource(COW, "/cow.png");
		addResource(COW_FRONT_RIGHT, "/animal/cow_front_right.png");
    	// addResource(COWUpRight, "/COWUpRight.png");
		// addResource(COWUpLeft, "/COWUpLeft.png");
		// addResource(COWDownRight, "/COWDownRight.png");
		// addResource(COWDownLeft, "/COWDownLeft.png");

		// Buildings

		
		/*---Building resources---*/
		
		//To be uncommented as the relevant graphics are created
		// note from creator of ResourceType: please remember to use the enums from
		// ResourceType enum class instead of the previous String implementation
		
		addResource(QUARRY, "/buildings/quarry.png");
		addResource(PASTURE, "/buildings/pasture.png");
		addResource(HOSPITAL, "/buildings/hospital.png");
		addResource(BUTCHER, "/buildings/butcher.png");
		addResource(BAKERY, "/buildings/bakery.png");
		addResource(COMMUNITY_BUILDING, "/buildings/community_building.png");
		//addResource(CONSTRUCTION1, "/buildings/construction1_small.png");
		addResource(CONSTRUCTION, "/buildings/construction2.png");
		addResource(CHURCH, "/buildings/church.png");
		addResource(HOUSE, "/buildings/house.png");
		addResource(SAWMILL, "/buildings/sawmill.png");
		addResource(FORGE, "/buildings/forge.png");
		addResource(OBSERVATORY, "/buildings/observatory.png");
		addResource(MINE, "/buildings/mine.png");
		addResource(CEMETERY, "/buildings/cemetery_small.png");
		addResource(FARM, "/buildings/farmhouse.png");

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
