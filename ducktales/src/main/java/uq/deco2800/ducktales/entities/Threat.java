package uq.deco2800.ducktales.entities;

import java.util.ArrayList;

/**
 * Handles game threats. 
 * 
 *
 */
public class Threat {
	String name;
	String type;
	private boolean hasStartTimer = false;
	private boolean hasEndTimer = false;

	private float startTimer = 0;
	private float endTimer = 0;
	private float currentTime;
	
	private int x;
	private int y;
	
	private int xCord; //value to assign x coordinate
	private int yCord; //vlaue to assign y coordinate
	
	//private HashMap<Image> enemyTypeRegister;
	private ArrayList<String> imageStore;
	
	int speed;
	
	boolean isPassable; //detects whether a tile is passable

	/**
	 * Enemy takes a string name and a type of enemy which is Creature or
	 * Effect
	 * 
	 * @param name
	 *            - String name
	 * @param type
	 *            - String that is Creature or Effect
	 * @throws exception On invalid parameters.
	 */
	public Threat(String name, String type) {
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

	/**
	 * Set time for a timer of start
	 * 
	 * @param time
	 *            input the system time when the effect needs to start from now
	 * @param Type System if time is in System time in ms or type Timer if it is time from now   
	 * @throws exception On invalid parameters.        
	 */
	public void setStartTimer(float time, String type) {
		if (time > 0 && type =="System") {
			this.startTimer = time;
			this.hasStartTimer = true;
			
		}if (time > 0 && type =="Timer") {
			this.currentTime = System.currentTimeMillis();
			this.startTimer =  currentTime + time;
			this.hasStartTimer = true;
			
		}
		else {
			// throw new exception
		}
	}

	/**
	 * Set time for a timer of expiry
	 * 
	 * @param time
	 *            in seconds when effect ends from when it starts
	 * @throws exception If {@code time <= startTimer}
	 */
	public void setEndTimer(float time) {
		if (time > startTimer) {
			this.currentTime = System.currentTimeMillis();
			this.endTimer = currentTime +startTimer;
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
		if (endTimer == currentTime && hasEndTimer) {
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
		if (startTimer == currentTime && hasStartTimer) {
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
	public String toString(){
		return this.name;
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setXCord(int tempX) {
		this.xCord = x; 
	}
	
	public void setYCord(int tempY) {
		this.yCord = y;
	}
	
	public void setRandomX(){
		//return x value within range of possible plot points
	}
	
	public void setRandomY(){
		
	}
	
	public void addImage(String imageName) {
		imageStore.add(imageName);
		//imageStore.add(imageName);
		//getClass()
		//new Image(getClass().getResource(imageName).toString()));
	}

}
