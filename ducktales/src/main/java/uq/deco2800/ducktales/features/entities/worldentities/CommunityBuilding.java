package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Community Building. Class containing all properties and specifications of a 
 * community building.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class CommunityBuilding extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.COMMUNITY_BUILDING;
	
	// Building health - starting value
	private static int health = 1400;
	
	// Size of the building
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new community building. Requires the location of the 
	 * community building to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public CommunityBuilding(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1400;
	}
	
	/**
	 * Update the WorldEntity properties with those of a community building.
	 */
	protected void specifications() {
		specifications(6, 8, 8, production.NULL, 0);
	}
	
	/**
	 * Update the 'health' of the community building. Requires an integer 
	 * value of the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	public void ChangeHealth(int newValue){
		if (newValue > 0){
			health = newValue;
		}
	}
	
	/**
	 * Method to access the 'health' of the community building. Returns the 
	 * integer value of the health.
	 * 
	 * @return the health of the community building.
	 */
	public int GetHealth(){
		return health;
	}
	
	/**
	 * Method to update community building at each discrete simulation step.
	 * 
	 * Note sure if any implementation will be used. To be determined later
	 * May implement for only some of the classes (hence left in the individual 
	 * buildings class files).
	 */
	@Override
	public void tick() {
		// To be implemented if there is to be animation of construction
	}
}
