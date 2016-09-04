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
	
	/**
	 * Called during constructor of a new Resource.
	 * Has a 5% chance of spawning as a rare Resource with different visual and starting value.	
	 * 
	 * @param TYPES
	 * 			   Array of appearances the Resource can take, 
	 * 			   with the last one always being the rare option.
	 * 
	 * @return Returns the ResourceType that the Resource will use
	 */
	protected static ResourceType rare(ResourceType[] TYPES){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt < 5){
			return TYPES[TYPES.length-1];
		} else{
			return TYPES[0];
		}
	}
	
	/**
	 * Sets the resource value of the Resource to x
	 * 
	 * @param x
	 * 		   The new value of the Resource
	 */	
	protected void setValue(int x){
		this.value = x;
	}	
	
	/**
	 * @return The value of the Resource
	 */		
	public int getValue(){
		return value;
	}
	/**
	 * Increase the value of the Resource by a specified amount
	 * 
	 * @param x
	 * 		   The amount to add to the Resource value.
	 */
	public void increaseValue(int x){
		value += x;
	}
	/**
	 * Decrease the value of the Resource by a specified amount
	 * 
	 * @param x
	 * 		   The amount to remove from the Resource value.
	 */
	public void decreaseValue(int x){
		value -= x;
	}
}