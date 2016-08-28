package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all static world entities.
 * 
 * @author Leggy
 *
 */
public abstract class WorldEntity extends Entity {

	protected WorldEntity(double x, double y, int lengthX, int lengthY, 
			ResourceType type, int time, int wood, int stone) {
		super(x, y, lengthX, lengthY, type);
	}

	/**
	 * Returns true if this {@link WorldEntity} is passable.
	 * 
	 * @return Returns true if this WorldEntity is passable.
	 */
	public abstract boolean isPassable();
	
	/**
	 * Returns the time to construct the building
	 * 
	 * @return int representing time to construct
	 */
	public abstract int timeToBuild();
	
	/**
	 * Returns the wood resources required to construct the 
	 * building
	 * 
	 * @return the int of wood required
	 */
	public abstract int resourcesBuildWood();
	
	/**
	 * Returns the stone resources required to construct the 
	 * building
	 * 
	 * @return the int of stone required
	 */
	public abstract int resourcesBuildStone();
	
	/**
	 * Returns the wood resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of wood returned
	 */
	public abstract int resourcesReturnWood();
	
	/**
	 * Returns the stone resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of stone returned
	 */
	public abstract int resourcesReturnStone();
	
}
