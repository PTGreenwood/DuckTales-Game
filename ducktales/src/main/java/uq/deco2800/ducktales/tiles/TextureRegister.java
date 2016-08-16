package uq.deco2800.ducktales.tiles;

import javafx.scene.image.Image;

import java.util.concurrent.ConcurrentHashMap;
import java.net.URL;
import java.lang.Exception;

/**
 * The Tile class holds information about an instance of a tile -- however there
 * is information that is common to every Tile of a certain type (for example,
 * their name, sprite image, type ID, etc). This class manages information of a
 * tile type and removes the requirement of having to know or store the tile
 * type itself. It allows for easy retrieval of tile type information either
 * through the name (as a string) or through the tile type which can be
 * retrieved from the instance method Tile.getTileType().
 *
 * This class is a singleton -- to get an instance of this class, you must call
 * TextureRegister.getInstance(); you cannot instantiate it.
 * 
 * @author Anonymousthing
 */
public class TextureRegister {

	private static final TextureRegister INSTANCE = new TextureRegister();

	/**
	 * Returns the instance of {@link TextureRegister}.
	 * 
	 * @return Returns an instance of TextureRegister.
	 */
	public static TextureRegister getInstance() {
		return INSTANCE;
	}

	/**
	 * The base height for a 1*1 texture.
	 */
	public static final int TEXTURE_HEIGHT = 100;
	
	/**
	 * The base width for a 1*1 texture.
	 */
	public static final int TEXTURE_WIDTH = 174;

	/*
	 * We have two registers that have the same values; one is keyed by name,
	 * and the other is keyed by tile type. It adds a bit of redundancy
	 * regarding TileTypeInfo fields but makes it easy to retrieve the
	 * TileTypeInfo since we can retrieve via either key.
	 */
	// As we're a static instance we use a ConcurrentHashMap to prevent
	// potential threading issues
	private ConcurrentHashMap<Integer, TileTypeInfo> tileTypeRegister;
	private ConcurrentHashMap<String, TileTypeInfo> nameRegister;
	private int currentCount;

	private TextureRegister() {
		tileTypeRegister = new ConcurrentHashMap<Integer, TileTypeInfo>();
		nameRegister = new ConcurrentHashMap<String, TileTypeInfo>();
		currentCount = 0;

		try {
			// NOTE: the '..' is needed since TextureRegister is in the 'tiles' folder,
			// and Class.getResource is relative to the .java file
			addTile("void", "../resources/black.png");
			addTile("grass_1", "../resources/grass_1.png");
			addTile("grass_2", "../resources/grass_2.png");
			addTile("grass_3", "../resources/grass_3.png");
			addTile("water", "../resources/water.png");
			addTile("box", "../resources/box2.png");
			addTile("long_box", "../resources/longbox.png");
			addTile("peon", "../resources/peon.png");
			addTile("wood_box", "../resources/wood_stock.png");
			addTile("tree_1", "../resources/tree_1.png");
			addTile("tree_2", "../resources/tree_2.png");
			addTile("tree_3", "../resources/tree_3.png");
			addTile("house", "../resources/house.png");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/**
	 * Adds a tile to the register.
	 * 
	 * @param name
	 *            The name of the tile
	 * @param tileImageName
	 *            The file name of the corresponding image
	 */
	private void addTile(String name, String tileImageName) {
		if (nameRegister.containsKey(name)) {
			throw new RuntimeException(
					"Attempted to add an already registered TileTypeInfo \""
							+ name + "\" to a TextureRegister");
		}
		URL tileImageURL = getClass().getResource(tileImageName);

		if (tileImageURL == null) throw new RuntimeException("tile Image is null for: " + tileImageName);

		TileTypeInfo tile = new TileTypeInfo(currentCount++, name, new Image(
				tileImageURL.toString()));
		tileTypeRegister.put(tile.tileType, tile);
		nameRegister.put(tile.tileName, tile);
	}

	/**
	 * Retrieves the Image of the specified tile
	 * 
	 * @param name
	 *            The name of the tile
	 * @return The sprite Image of the tile
	 */
	public Image getTileImage(String name) {
		if (!nameRegister.containsKey(name))
			throw new RuntimeException(
					"Attempted to access non-registered TileTypeInfo \"" + name
							+ "\" from a TextureRegister");
		return nameRegister.get(name).tileImage;
	}

	/**
	 * Retrieves the Image of the specified tile
	 * 
	 * @param tileType
	 *            The tile type of the tile
	 * @return The sprite Image of the tile
	 */
	public Image getTileImage(int tileType) {
		if (!tileTypeRegister.containsKey(tileType))
			throw new RuntimeException(
					"Attempted to access non-registered TileTypeInfo of tile type \""
							+ tileType + "\" from a TextureRegister");
		return tileTypeRegister.get(tileType).tileImage;
	}

	/**
	 * Gets the tile type of a tile from a given name
	 * 
	 * @param name
	 *            The name of the tile
	 * @return The tile type of the tile
	 */
	public int getTileType(String name) {
		if (!nameRegister.containsKey(name))
			throw new RuntimeException(
					"Attempted to access non-registered TileTypeInfo \"" + name
							+ "\" from a TextureRegister");
		return nameRegister.get(name).tileType;
	}

	private class TileTypeInfo {
		public int tileType;
		public String tileName;
		public Image tileImage;

		public TileTypeInfo(int tileType, String tileName, Image tileImage) {
			this.tileType = tileType;
			this.tileName = tileName;
			this.tileImage = tileImage;
		}
	}
}
