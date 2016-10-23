package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * Abstract representation of all static Resource entities.
 * 
 * @author Andrew 22/08/16
 *
 */
public abstract class ResourceEntity extends WorldEntity {
	
	/** The main manager of the game */
    protected GameManager gameManager;
    
	// Default starting value of Resource nodes
	public static final int DEFVALUE = 100;

	// Actual, editable value the Resources nodes will take
	protected int value;

	/**
	 * Main constructor of the Resource Entity class.
	 * 
	 * @param x,
	 *            x location of the resource
	 * @param y,
	 *            y location of the resource
	 * @param lengthX,
	 *            length of the resource (x direction)
	 * @param lengthY,
	 *            length of the resource (y direction)
	 * @param type,
	 *            resource type
	 * @param value,
	 *            the amount that can be harvested from the resource
	 */
	protected ResourceEntity(double x, double y, int lengthX, int lengthY, 
			ResourceType type, int value) {
		super(x, y, lengthX, lengthY, type);
		this.value = value;
	}
	
	/**
     * Give this resourceEntity a reference of the primary manager
     *
     * @param gameManager
     *          The primary manager of the game, from which ALL information
     *          can be retrieved regarding other managers
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
	 * Called during constructor of a new Resource. Has a 5% chance of spawning
	 * as a rare Resource with different visual and starting value.
	 * 
	 * @param TYPES
	 *            Array of appearances the Resource can take, with the last one
	 *            always being the rare option.
	 * 
	 * @return Returns the ResourceType that the Resource will use
	 */
	public static ResourceType rare(ResourceType[] types) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if (randomInt < 5) {
			return types[types.length - 1];
		} else {
			return types[0];
		}
	}

	/**
	 * Sets the resource value of the Resource to amount
	 * 
	 * @param amount
	 *            The new value of the Resource
	 * 
	 * @throws exception
	 *             if value is < 0
	 */
	protected void setValue(int amount) {
		if (amount > 0) {
			this.value = amount;
		} else {
			throw new GameSetupException("value of a resource must be" +
					" positive");
		}
	}

	/**
	 * Method that will return a numerical representation of the amount of resources
	 * contained in this entity..
	 * 
	 * @return The value of the Resource
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Increase the amount of resources contained in this Resource by a specified amount
	 * 
	 * @param amount
	 *            The amount to add to the Resource value.
	 * 
	 * @throws Exception
	 *             if amount is negative.
	 */
	public void increaseValue(int amount) throws Exception {
		if (amount > 0) {
			value += amount;
		} else {
			throw new IllegalArgumentException("amount cannot be negative.");
		}
	}

	/**
	 * Decrease the amount of resources contained in this Resource by a specified amount
	 * 
	 * @param amount
	 *            The amount to remove from the Resource value.
	 * 
	 * @throws Exception
	 *             if amount is negative.
	 */
	public void decreaseValue(int amount) throws Exception {
		if (amount > 0) {
			value -= amount;
		} else {
			throw new IllegalArgumentException("amount cannot be negative.");
		}
	}
}