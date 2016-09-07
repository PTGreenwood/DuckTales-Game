package uq.deco2800.ducktales.features.landscape.tiles;

import uq.deco2800.ducktales.features.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Tickable;

import static uq.deco2800.ducktales.resources.ResourceType.NONE;

/**
 * Represents a square unit of the world.
 * 
 * @author Leggy
 *
 */
public class Tile implements Tickable {
	/**The type of this tile. */
	private ResourceType tileType;

	/** The type of the world entity on this tile */
	private ResourceType worldEntityType;

	/** Variable to control whether this tile is passable */
	private boolean isPassable;


	// TODO REMOVE THESE
	private ResourceType oldType = ResourceType.YELLOW;
	private boolean path = false;

	/**
	 * Initialises this Tile with a specified tile type.
	 * 
	 * @param tileType
	 *            The tile type to create this Tile with
	 */
	public Tile(ResourceType tileType) {
		this.tileType = tileType;

		// Set up initial info
		worldEntityType = NONE;
		isPassable = true;
	}

	/**
	 * Sets the type of this Tile to the specified value.
	 * 
	 * @param tileType
	 *            The type to set this Tile to
	 */
	public void setTileType(ResourceType tileType) {
		this.tileType = tileType;
	}

	/**
	 * Gets the type of this Tile.
	 * 
	 * @return The type of the Tile
	 */
	public ResourceType getTileType() {
		if(isPassable()){
			return tileType;
		}
		return ResourceType.CYAN_CROSSED;
	}

	/**
	 * Set the type of world entity on this tile
	 * @param worldEntityType
	 * 			The type of the world entity on this tile
	 *
	 * 	TODO: ALSO CHECK FOR PASSABILITY HERE TOO
	 */
	public void setWorldEntityType(ResourceType worldEntityType) {
		this.worldEntityType = worldEntityType;
	}


	/**
	 * Set the passability of this tile
	 * @param newValue
	 * 			The new passability value of this tile
	 */
	public void setPassable(boolean newValue) {
		this.isPassable = newValue;
	}

	/**
	 * Check if this tile is passable
	 * @return the passability of this tile
	 */
	public boolean isPassable() {
		return isPassable;
	}

	@Override
	public void tick() {
	}


	public void reset() {
		path = false;
		this.tileType = oldType;

	}

	public void makePath() {
		if (!path) {
			this.path = true;
			this.oldType = tileType;
			this.tileType = ResourceType.YELLOW;
		}
	}

}
