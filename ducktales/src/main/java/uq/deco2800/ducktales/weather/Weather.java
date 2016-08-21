package uq.deco2800.ducktales.weather;

/**
 * Main weather for the game. 
 * 
 * @author mattyleggy
 *
 * Maybe this should be an interface instead of abstract? Something to consider.
 * Changed to an interface, still not 100% sure if I should at this stage.
 */
public interface Weather {
	
	
	/**
	 * @return sprite effect
	 */
	public Effect getEffect();
	
	/**
	 * @return true or false depending on if it is a land 
	 */
	public boolean isLand();
	
	/**
	 * @return
	 */
	public boolean isWater();
	
	/**
	 * Need a better name for this...
	 * Better name selected now. isAmphibious is more correct
	 * @return
	 */
	public boolean isAmphibious();
	
	/**
	 * @return true if an object (e.g. tree) requires an updated sprite
	 * 		   false if an object does not need an updated sprite
	 */
	public boolean requiresObjectUpdate();
	
	
}
