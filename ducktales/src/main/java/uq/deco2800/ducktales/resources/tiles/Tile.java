package uq.deco2800.ducktales.resources.tiles;

import uq.deco2800.ducktales.entities.worldentities.Building;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Represents a square unit of the world.
 * 
 * @author Leggy
 *
 */
public class Tile implements Tickable {
	/**
	 * The type of this tile.
	 */
	private ResourceType tileType;

	// TODO REMOVE THESE
	private ResourceType oldType = ResourceType.YELLOW;
	private boolean path = false;

	private Building worldEntity;

	/**
	 * Initialises this Tile with a specified tile type.
	 * 
	 * @param tileType
	 *            The tile type to create this Tile with
	 */
	public Tile(ResourceType tileType) {
		this.tileType = tileType;
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
	 * Adds a world entity to this tile.
	 * 
	 * @param worldEntity
	 */
	public void addWorldEntity(Building worldEntity) {
		if (this.worldEntity != null) {
			this.worldEntity = worldEntity;
		}
	}

	public void setWorldEntity(Building entity) {
		this.worldEntity = entity;
	}

	/**
	 * Returns the {@link Building} at this location.
	 * 
	 * @return Returns the WorldEntity at this location.
	 */
	public Building getWorldEntity() {
		return worldEntity;
	}

	@Override
	public void tick() {
	}

	public boolean isPassable() {
		if (worldEntity == null) {
			return true;
		}
		return worldEntity.isPassable();
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
