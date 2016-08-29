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
 * ResourceRegister.getInstance(); you cannot instantiate it.
 * 
 * @author Anonymousthing, khoiphan21
 */
public class ResourceRegister {

	private static final ResourceRegister INSTANCE = new ResourceRegister();

	/**
	 * Returns the instance of {@link ResourceRegister}.
	 * 
	 * @return Returns an instance of ResourceRegister.
	 */
	public static ResourceRegister getInstance() {
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

	private ResourceRegister() {
		resourceTypeRegister = new ConcurrentHashMap<>();
		currentCount = 0;

		// Landscape resources
		addResource(VOID, "/black.png");
		addResource(CYAN, "/cyan.png");
		addResource(CYAN_CROSSED, "/cyan_crossed.png");
		addResource(YELLOW, "/yellow.png");
		addResource(GRASS_1, "/grass_1.png");
		addResource(GRASS_2, "/grass_2.png");
		addResource(GRASS_3, "/grass_3.png");
		addResource(WATER, "/water.png");
		addResource(DIRT_1, "/dirt_1.png");
		addResource(DIRT_2, "/dirt_2.png");
		addResource(DIRT_3, "/dirt_3.png");
		addResource(BLANK, "/blank.png");

		addResource(BOX, "/box2.png");
		addResource(LONG_BOX, "/longbox.png");
		addResource(PEON, "/peon.png");
		addResource(WOOD_BOX, "/wood_stock.png");
		addResource(TREE_1, "/tree_1.png");
		addResource(TREE_2, "/tree_2.png");
		addResource(TREE_3, "/tree_3.png");
		addResource(HOUSE, "/house.png");
		addResource(DUCK, "/duck.png");
		addResource(COW, "/cow.png");
//		addResource(SHEEP, "/sheep.png");

		
		addResource(SAWMILL, "/sawmill.png");
		//To be uncommented as the relevant graphics are created
		// note from creator of ResourceType: please remember to use the enums from
		// ResourceType enum class instead of the previous String implementation
		addResource(BAKERY, "/bakery.png");
		//addResource(CEMETERY, "/cemetery.png");
		addResource(FARMHOUSE, "/farm+barn.png");
		addResource(BARN, "/barn.png");
		//addResource(FORGE, "/forge.png");
		addResource(HOSPITAL, "/hospital.png");
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
							+ type + "\" to a ResourceRegister");
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
							+ resourceType + "\" from a ResourceRegister");
		return resourceTypeRegister.get(resourceType);
	}

}
