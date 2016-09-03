package uq.deco2800.ducktales.entities.resourceentities;

import java.util.Random;

import uq.deco2800.ducktales.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all static world entities.
 * 
 * @author Andrew 22/08/16
 *
 */
public abstract class ResourceEntity extends WorldEntity {

	public static int defValue = 100;
	public int value;


	protected ResourceEntity(double x, double y, int lengthX, int lengthY, ResourceType type, int value) {
		super(x, y, lengthX, lengthY, type);
		this.value = value;
	}

	/**
	 * Returns true if this {@link WorldEntity} is passable.
	 * 
	 * @return Returns true if this WorldEntity is passable.
	 */
	public abstract boolean isPassable();
	
	protected static ResourceType rare(ResourceType[] TYPES){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt < 5){
			return TYPES[1];
		} else{
			return TYPES[0];
		}
	}
	
	protected void setValue(int x){
		this.value = x;
	}	
	
	protected void setResourceType(ResourceType R){
		
	}
	
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