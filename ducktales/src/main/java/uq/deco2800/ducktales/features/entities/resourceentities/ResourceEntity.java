package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all static Resource entities.
 * 
 * @author Andrew 22/08/16
 *
 */
public abstract class ResourceEntity extends WorldEntity {

	/** The main manager of the game */
    protected GameManager gameManager;
    
	//Default starting value of Resource nodes
	public static final int DEFVALUE = 100;
	//Actual, editable value the Resources nodes will take
	protected int value;

	/**
	 * Main constructor of the Resource Entity class.
	 * @param x, x location of the resource
	 * @param y, y location of the resource
	 * @param lengthX, length of the resource (x direction) 
	 * @param lengthY, length of the resource (y direction)
	 * @param type, resource type
	 * @param value, the amount that can be harvested from the resource
	 */
	protected ResourceEntity(double x, double y, int lengthX, int lengthY, ResourceType type, int value) {
		super(x, y, lengthX, lengthY, type);
		this.value = value;
	}
	
	/**
     * Give the resource a handle on the main manager of the game
     *
     * @param gameManager
     *          The main manager of the game
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
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
	public static ResourceType rare(ResourceType[] types){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if(randomInt < 5){
			return types[types.length-1];
		} else{
			return types[0];
		}
	}
	
	/**
	 * Sets the resource value of the Resource to x
	 * 
	 * @param x
	 * 		   The new value of the Resource
	 * 
	 * @throws exception if value is < 0
	 */	
	protected void setValue(int x){
		if(x > 0){
			this.value = x;
		}else{
			//throw new exception
		}
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
	 * 
	 * @throws exception if x is negative.
	 */
	public void increaseValue(int x){
		if(x > 0){
			value += x;
		}else{
			//throw new exception
		}
	}
	/**
	 * Decrease the value of the Resource by a specified amount
	 * 
	 * @param x
	 * 		   The amount to remove from the Resource value.
	 * 
	 * @throws exception if x is negative.
	 */
	public void decreaseValue(int x){
		if(x > 0){
			value -= x;
		}else{
			//throw new exception
		}
	}
}