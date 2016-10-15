package uq.deco2800.ducktales.features.entities;

import java.util.Random;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Handles game threats.
 * 
 *
 */
public class Threat extends Entity{
	String name;
	String type;
	private boolean hasStartTimer = false;
	private boolean hasEndTimer = false;

	private float startTimer = 0;
	private float endTimer = 0;
	private float currentTime;

	private double randomX;
	private double randomY;
	private double xCord; // value to assign x coordinate
	private double yCord; // value to assign y coordinate
	
	private int speed; // value to assign the threat's movement speed
	private int levelOfDamage; // the level of damage cause by a threat

	protected boolean isPassable; // detects whether a tile is passable

	private World world;
	private Peon peon;

	/**
	 * Enemy takes a string name and a type of enemy which is Creature or Effect
	 * 
	 * @param name
	 *            - String name
	 * @param type
	 *            - String that is Creature or Effect
	 * @throws exception
	 *             On invalid parameters.
	 */
	public Threat(String name, String type) {
		super(1, 1, 1, 1, ResourceType.NONE);
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			// Throw exception
		} else {
			this.name = name;
		}

		if (!("Enemy".equals(type) || "Effect".equals(type))) {
			// Throw exception
		} else {
			this.type = type;
		}
	}

	public void setWorld(World world) {
		//Need to implement
	}

	/**
	 * Set time for a timer of start
	 * 
	 * @param time
	 *            input the system time when the effect needs to start from now
	 * @param Type
	 *            System if time is in System time in ms or type Timer if it is
	 *            time from now
	 * @throws exception
	 *             On invalid parameters.
	 */
	public void setStartTimer(float time, String type) {
		if (time > 0 && type == "System") {
			this.startTimer = time;
			this.hasStartTimer = true;

		}
		if (time > 0 && type == "Timer") {
			this.currentTime = System.currentTimeMillis();
			this.startTimer = currentTime + time;
			this.hasStartTimer = true;

		} else {
			// throw new exception
		}
	}

	/**
	 * Set time for a timer of expiry
	 * 
	 * @param time
	 *            in seconds when effect ends from when it starts
	 * @throws exception
	 *             If {@code time <= startTimer}
	 */
	public void setEndTimer(float time) {
		if (time > startTimer) {
			this.currentTime = System.currentTimeMillis();
			this.endTimer = currentTime + startTimer;
			this.hasEndTimer = true;
		} else {
			// throw new exception
		}

	}

	/**
	 * 
	 * @return true if the effect should/end expire
	 */
	public boolean hasThreatEnded() {
		this.currentTime = System.currentTimeMillis();
		if (endTimer >= currentTime && hasEndTimer) {
			// Change HasEndTimer to false (Not sure if if stat will break)
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true when the effect should start
	 */
	public boolean shouldThreatStart() {
		this.currentTime = System.currentTimeMillis();
		if (startTimer >= currentTime && hasStartTimer) {
			// Change HasStarTimer to false (Not sure if if stat will break)
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return StartTime if it exists or 0 if the timer has expired or otherwise
	 */
	public float returnStartTime() {
		if (hasStartTimer) {
			return startTimer;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @return EndTime if it exists or 0 if the timer has expired or otherwise
	 */
	public float returnEndTime() {
		if (hasEndTimer) {
			return endTimer;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void setXCord() {
		this.xCord = randomX;
	}

	public void setYCord() {
		this.yCord = randomY;
	}

	/**
	 * It detects the world width and returns a random x-coordinate.
	 * 
	 * @return randomX
	 */
	public double getRandomX() {
		int maxWidth = world.getWidth();
		Random random = new Random();
		randomX = (double) random.nextInt(maxWidth) + 1;
		// need condition statement to check if the randomX intersect w/ tile not passable
		return randomX;
	}

	/**
	 * It detects the world height and returns a random y-coordinate.
	 * 
	 * @return randomY
	 */
	public double getRandomY() {
		int maxHeight = world.getHeight();
		Random random = new Random();
		randomY = (double) random.nextInt(maxHeight) + 1;
		// need condition statement to check if the randomY intersect w/ tile not passable
		return randomY;
	}
	
	/**
	 * Assign the level of damage for a threat
	 * @param damage
	 */
	public void setTheLevelOfDamage(int newLevelOfDamage) {
		this.levelOfDamage = newLevelOfDamage;
	}
	
	/**
	 * Set the movement speed for a threat
	 * @param newSpeed
	 */
	public void setTheSpeed(int newSpeed){
		this.speed = newSpeed;
	}
	
	public int getSpeed(){
		return speed;
	}

	public boolean checkTile() {
		boolean available = world.checkTileAvailability(getXInt(), getYInt(), getXLength(), getYLength());
		if (available == true) {
			return true;
		}
		else {
			return false;
		}
	}

//	public void addImage(String imageName) {
//		imageStore.add(imageName);
//		// imageStore.add(imageName);
//		// getClass()
//		// new Image(getClass().getResource(imageName).toString()));
//	}
	
	public double getX() {
		return xCord;
	}

	public double getY() {
		return yCord;
	}
	
	public int getXInt() {
		int xInt = (int) xCord;
		return xInt;
	}
	
	public int getYInt() {
		int yInt = (int) yCord;
		return yInt;
	}
	
	/**
	 * Method to detect peon/enemy collisions
	 */

	public void checkCollision() {
		int currentHealth = peon.getHealth();
		int newHealth = currentHealth - levelOfDamage;
		if ((this.getX() >= peon.getX() && (this.getY() >= peon.getY()))) {
			peon.setHealth(newHealth);
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
