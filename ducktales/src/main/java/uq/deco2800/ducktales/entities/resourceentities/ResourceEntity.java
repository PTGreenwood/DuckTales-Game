package uq.deco2800.ducktales.entities.resourceentities;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all static world entities.
 * 
 * @author Andrew 22/08/16
 *
 */
public abstract class ResourceEntity extends WorldEntity {

	public static int value;


	protected ResourceEntity(double x, double y, int lengthX, int lengthY, ResourceType type, int value) {
		super(x, y, lengthX, lengthY, type);
		this.value = value;
	}

	/**
	 * Returns true if this {@link Building} is passable.
	 * 
	 * @return Returns true if this WorldEntity is passable.
	 */
	public abstract boolean isPassable();
	
	
	public int getValue(){
		return value;
	}
	
	public void increaseValue(int x){
		value += x;
	}

	public void decreaseValue(int x){
		value -= x;
	}
}