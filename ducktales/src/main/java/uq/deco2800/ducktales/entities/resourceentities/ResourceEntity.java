package uq.deco2800.ducktales.entities.resourceentities;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all static world entities.
 * 
 * @author Andrew 22/08/16
 *
 */
public abstract class ResourceEntity extends Entity {

	protected ResourceEntity(double x, double y, int lengthX, int lengthY, ResourceType type) {
		super(x, y, lengthX, lengthY, type);
	}

	/**
	 * Returns true if this {@link WorldEntity} is passable.
	 * 
	 * @return Returns true if this WorldEntity is passable.
	 */
	public abstract boolean isPassable();
	
	
	public int getValue(){
		return 0;
	}

}