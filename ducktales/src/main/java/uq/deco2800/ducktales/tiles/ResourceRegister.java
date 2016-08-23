package uq.deco2800.ducktales.tiles;

import javafx.scene.image.Image;

import java.util.concurrent.ConcurrentHashMap;

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

	/*
	 * We have two registers that have the same values; one is keyed by name,
	 * and the other is keyed by tile type. It adds a bit of redundancy
	 * regarding ResourceTypeInfo fields but makes it easy to retrieve the
	 * ResourceTypeInfo since we can retrieve via either key.
	 */
	// As we're a static instance we use a ConcurrentHashMap to prevent
	// potential threading issues
	private ConcurrentHashMap<Integer, ResourceTypeInfo> resourceTypeRegister;
	private ConcurrentHashMap<String, ResourceTypeInfo> nameRegister;
	private int currentCount;

	private ResourceRegister() {
		resourceTypeRegister = new ConcurrentHashMap<Integer, ResourceTypeInfo>();
		nameRegister = new ConcurrentHashMap<String, ResourceTypeInfo>();
		currentCount = 0;

		addResource("void", "/black.png");
		addResource("cyan", "/cyan.png");
		addResource("grass_1", "/grass_1.png");
		addResource("grass_2", "/grass_2.png");
		addResource("grass_3", "/grass_3.png");
		addResource("water", "/water.png");
		addResource("box", "/box2.png");
		addResource("long_box", "/longbox.png");
		addResource("peon", "/peon.png");
		addResource("wood_box", "/wood_stock.png");
		addResource("tree_1", "/tree_1.png");
		addResource("tree_2", "/tree_2.png");
		addResource("tree_3", "/tree_3.png");
		addResource("house", "/house.png");
		addResource("duck", "/duck.png");
		addResource("blank", "/blank.png");
		
		addResource("sawmill", "/sawmill.png");
		//To be uncommented as the relevant graphics are created
		//addResource("bakery", "/bakery.png");
		//addResource("cemetery", "/cemetery.png");
		//addResource("farmhouse", "/farmhouse.png");
		//addResource("forge", "/forge.png");
		//addResource("hospital", "/hospital.png");
		//addResource("observatory", "/observatory.png");

	}

	/**
	 * Adds a resource to the register.
	 * 
	 * @param name
	 *            The name of the resource
	 * @param resourceImageName
	 *            The file name of the corresponding image
	 */
	private void addResource
	(String name, String resourceImageName) {
		if (nameRegister.containsKey(name)) {
			throw new RuntimeException(
					"Attempted to add an already registered ResourceTypeInfo \""
							+ name + "\" to a ResourceRegister");
		}

		ResourceTypeInfo resource = new ResourceTypeInfo(currentCount++, name, new Image(
				getClass().getResource(resourceImageName).toString()));
		resourceTypeRegister.put(resource.resourceType, resource);
		nameRegister.put(resource.resourceName, resource);
	}

	/**
	 * Retrieves the Image of the specified resource
	 * 
	 * @param name
	 *            The name of the resource
	 * @return The sprite Image of the resource
	 */
	public Image getResourceImage(String name) {
		if (!nameRegister.containsKey(name))
			throw new RuntimeException(
					"Attempted to access non-registered ResourceTypeInfo \"" + name
							+ "\" from a ResourceRegister");
		return nameRegister.get(name).resourceImage;
	}

	/**
	 * Retrieves the Image of the specified resource
	 * 
	 * @param resourceType
	 *            The type of the resource
	 * @return The sprite Image of the resource
	 */
	public Image getResourceImage(int resourceType) {
		if (!resourceTypeRegister.containsKey(resourceType))
			throw new RuntimeException(
					"Attempted to access non-registered ResourceTypeInfo of tile type \""
							+ resourceType + "\" from a ResourceRegister");
		return resourceTypeRegister.get(resourceType).resourceImage;
	}

	/**
	 * Gets the tile type of a tile from a given name
	 * 
	 * @param name
	 *            The name of the tile
	 * @return The tile type of the tile
	 */
	public int getResourceType(String name) {
		if (!nameRegister.containsKey(name))
			throw new RuntimeException(
					"Attempted to access non-registered ResourceTypeInfo \"" + name
							+ "\" from a ResourceRegister");
		return nameRegister.get(name).resourceType;
	}

	private class ResourceTypeInfo {
		public int resourceType;
		public String resourceName;
		public Image resourceImage;

		public ResourceTypeInfo(int resourceType, String resourceName, Image resourceImage) {
			this.resourceType = resourceType;
			this.resourceName = resourceName;
			this.resourceImage = resourceImage;
		}
	}
}
