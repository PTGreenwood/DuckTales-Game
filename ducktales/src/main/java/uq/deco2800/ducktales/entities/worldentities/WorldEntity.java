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
	
	protected static int TIME;
	
	protected static int WOODRESOURCES;

	protected static int STONERESOURCES;

	protected WorldEntity(double x, double y, int lengthX, int lengthY, 
			ResourceType type) {
		super(x, y, lengthX, lengthY, type);
		specifications();
	}
	
	/**
	 * Returns true if this {@link Building} is passable.
	 * 
	 * @return Returns true if this WorldEntity is passable.
	 */
	public boolean isPassable() {
		return false;
	}
	
	/**
	 * Returns the time to construct the building
	 * 
	 * @return int representing time to construct
	 */
	public int timeToBuild() {
		return TIME;
	}
	
	/**
	 * Returns the wood resources required to construct the 
	 * building
	 * 
	 * @return the int of wood required
	 */
	public int resourcesBuildWood() {
		return WOODRESOURCES;
	}
	
	/**
	 * Returns the stone resources required to construct the 
	 * building
	 * 
	 * @return the int of stone required
	 */
	public int resourcesBuildStone() {
		return STONERESOURCES;
	}
	
	/**
	 * Returns the wood resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of wood returned
	 */
	public int resourcesReturnWood() {
		return (int) (0.5*WOODRESOURCES);
	}
	
	/**
	 * Returns the stone resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of stone returned
	 */
	public int resourcesReturnStone() {
		return (int) (0.5*STONERESOURCES);
	}
	
	/**
	 * Update the variables with the building specifications, when the 
	 * building is called.
	 */
	protected abstract void specifications();
}
