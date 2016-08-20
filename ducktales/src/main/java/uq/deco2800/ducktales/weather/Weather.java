package uq.deco2800.ducktales.weather;



/**
 * Main weather for the game. 
 * 
 * @author mattyleggy
 *
 */
public abstract class Weather {
	protected int land;	
	protected int water;	
	public Weather() {
		
	}
	
	/**
	 * @return sprite effect
	 */
	public Effect getEffect() {
		Effect effect = new Effect();
		return effect;
	}	
	
	/**
	 * @return true or false depending on if it is a land 
	 */
	public boolean isLand() {
		return false;
	}
	
	/**
	 * @return
	 */
	public boolean isWater() {
		return false;
	}
	
	/**
	 * Need a better name for this...
	 * @return
	 */
	public boolean isAnywhere() {
		return isLand() && isWater();
	}
	
	/**
	 * @return true if an object (e.g. tree) requires an updated sprite
	 * 		   false if an object does not need an updated sprite
	 */
	public boolean requiresObjectUpdate() {
		return false;
	}
	
	
}
