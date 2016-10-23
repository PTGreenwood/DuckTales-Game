package uq.deco2800.ducktales.features.entities.threats;

import java.util.Random;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.worldentities.Building;
import uq.deco2800.ducktales.features.landscape.tiles.Tile;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Handles game threats in the form of enemies
 * and effects.
 * 
 *@author Wian, Krista, and Zainab
 *
 */
public class Threat extends Entity {
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
	private String worldName;
	private int worldWidth;
	private int worldHeight;
	
	private Peon peon;
	private Building building;

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
		worldName = world.getName();
		worldWidth = world.getHeight();
		worldHeight = world.getWidth();
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
		}
		return false;
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
		}
		return false;
	}

	/**
	 * 
	 * @return StartTime if it exists or 0 if the timer has expired or otherwise.
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
	 * @return EndTime if it exists or 0 if the timer has expired or otherwise.
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
		//System.out.println("world width = "+ worldWidth);
		Random random = new Random();
		randomX = (double) random.nextInt(worldWidth) + 1;
		// need condition statement to check if the randomX intersect w/ tile not passable
		//System.out.println("random x = "+ randomX);
		return randomX;
	}

	/**
	 * It detects the world height and returns a random y-coordinate.
	 * 
	 * @return randomY
	 */
	public double getRandomY() {
		//System.out.println("world Height = "+ worldHeight);
		Random random = new Random();
		randomY = (double) random.nextInt(worldHeight) + 1;
		// need condition statement to check if the randomY intersect w/ tile not passable
		//System.out.println("random y = "+ randomY);
		return randomY;
	}
	
	/**
	 * Assign the level of damage for a threat
	 * @param damage
	 */
	public void setTheLevelOfDamage(int newLevelOfDamage) {
		this.levelOfDamage = newLevelOfDamage;
	}
	
	public int getTheLevelOfDamage(){
		return levelOfDamage; 
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
		if (available) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return a double which is the x
	 * coordinate of the threat
	 */
	public double getX() {
		return xCord;
	}

	/**
	 * @return a double which is the y
	 * coordinate of the threat
	 */
	public double getY() {
		return yCord;
	}
	
	/**
	 * Converts the x coordinate of 
	 * a threat from a double to an integer
	 * 
	 * @return an integer which is the x
	 * coordinate of the threat
	 */
	public int getXInt() {
		return (int) xCord;
	}
	
	/**
	 * Converts the y coordinate of 
	 * a threat from a double to an integer
	 * 
	 * @return an integer which is the x
	 * coordinate of the threat
	 */
	public int getYInt() {
		return (int) yCord;
	}
	
	/**
	 * Method to detect Peon/Enemy collisions
	 * 
	 * @return a boolean value which is true if the
	 * threat has collided with a peon, and false if it has not
	 */
	public boolean checkPeonCollision() {
		Tile temptile = world.getTile(this.getXInt(), this.getYInt());
		ResourceType tempType = temptile.getTileType();
		switch(tempType) {
		case PEON:
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Method to detect Building/Enemy collisions
	 * 
	 * @return a boolean value which is true if the
	 * threat has collided with a building, and false if it has not
	 */
	public boolean checkBuildingCollision() {
		Tile temptile = world.getTile(this.getXInt(), this.getYInt());
		ResourceType tempType = temptile.getTileType();
		switch(tempType) {
		case PASTURE:
			return true;
		case BUTCHER:
			return true;
		case BAKERY:
			return true;
		case COMMUNITY_BUILDING:
			return true;
		case CONSTRUCTION:
			return true;
		case HOUSE:
			return true;
		case SAWMILL:
			return true;
		case CEMETERY:
			return true;
		case BARN:
			return true;
		case FORGE:
			return true;
		case HOSPITAL:
			return true;
		case OBSERVATORY:
			return true;
		case FARM:
			return true;
		case MINE:
			return true;
		case QUARRY:
			return true;
		case CHURCH:
			return true;
		case SCHOOL:
			return true;
		case GYMNASIUM:
			return true;
		case CONSTRUCTION_2:
			return true;
		case STORAGEBARN:
			return true;
		case BUTCHER_1:
			return true;
		case BUTCHER_2:
			return true;
		case BUTCHER_3:
			return true;
		case BUTCHER_4:
			return true;
		case BUTCHER_5:
			return true;
		case ADV_BUTCHER_1:
			return true;
		case ADV_BUTCHER_2:
			return true;
		case ADV_BUTCHER_3:
			return true;
		case ADV_BUTCHER_4:
			return true;
		case ADV_BUTCHER_5:
			return true;
		case ADV_HOSPITAL_1:
			return true;
		case ADV_HOSPITAL_2:
			return true;
		case ADV_HOSPITAL_3:
			return true;
		case ADV_HOSPITAL_4:
			return true;
		case ADV_HOSPITAL_5:
			return true;
		case BAKERY_1:
			return true;
		case BAKERY_2:
			return true;
		case BAKERY_3:
			return true;
		case BAKERY_4:
			return true;
		case BAKERY_5:
			return true;
		case CEMETERY_1:
			return true;
		case CEMETERY_2:
			return true;
		case CEMETERY_3:
			return true;
		case CEMETERY_4:
			return true;
		case CEMETERY_5:
			return true;
		case CEMETERY_6:
			return true;
		case CEMETERY_7:
			return true;
		case CEMETERY_8:
			return true;
		case CEMETERY_9:
			return true;
		case CEMETERY_10:
			return true;
		case CEMETERY_11:
			return true;
		case CEMETERY_12:
			return true;
		case CEMETERY_13:
			return true;
		case CEMETERY_14:
			return true;
		case CEMETERY_15:
			return true;
		case CEMETERY_16:
			return true;
		case CHURCH_1:
			return true;
		case CHURCH_2:
			return true;
		case CHURCH_3:
			return true;
		case CHURCH_4:
			return true;
		case CHURCH_5:
			return true;
		case OBSERVATORY_1:
			return true;
		case OBSERVATORY_2:
			return true;
		case OBSERVATORY_3:
			return true;
		case OBSERVATORY_4:
			return true;
		case OBSERVATORY_5:
			return true;
		case SAWMILL_1:
			return true;
		case SAWMILL_2:
			return true;
		case SAWMILL_3:
			return true;
		case SAWMILL_4:
			return true;
		case SAWMILL_5:
			return true;
		case SAWMILL_6:
			return true;
		case FORGE_1:
			return true;
		case FORGE_2:
			return true;
		case FORGE_3:
			return true;
		case FORGE_4:
			return true;
		case FORGE_5:
			return true;
		case GYMNASIUM_1:
			return true;
		case GYMNASIUM_2:
			return true;
		case GYMNASIUM_3:
			return true;
		case GYMNASIUM_4:
			return true;
		case GYMNASIUM_5:
			return true;
		case HOSPITAL_1:
			return true;
		case HOSPITAL_2:
			return true;
		case HOSPITAL_3:
			return true;
		case HOSPITAL_4:
			return true;
		case HOSPITAL_5:
			return true;
		case HOUSE_1:
			return true;
		case HOUSE_2:
			return true;
		case HOUSE_3:
			return true;
		case HOUSE_4:
			return true;
		case HOUSE_5:
			return true;
		case MINE_1:
			return true;
		case MINE_2:
			return true;
		case MINE_3:
			return true;
		case MINE_4:
			return true;
		default:
			return false;
		}			
	}
	
	/**
	 * Method to change the Peon's integer health value
	 * upon collision with an enemy
	 * 
	 */
	public void peonHealthDamage() {
		boolean peonCollision = checkPeonCollision();
		if (peonCollision) {
			int currentPeonHealth = peon.getHealth();
			int newPeonHealth = currentPeonHealth - levelOfDamage;
			if (newPeonHealth >= 1) {
				peon.setHealth(newPeonHealth);
			}
		}
	}
	
	/**
	 * Method to change the Building's integer health value
	 * upon collision with an enemy
	 * 
	 */
	public void buildingHealthDamage() {
		boolean buildingCollision = checkBuildingCollision();
		if (buildingCollision) {
			int currentBuildingHealth = building.getHealth();
			int newBuildingHealth = currentBuildingHealth - levelOfDamage;
			if (newBuildingHealth >= 1) {
				building.changeHealth(newBuildingHealth);
			}
		}
	}
	
	//Create 2d array

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
