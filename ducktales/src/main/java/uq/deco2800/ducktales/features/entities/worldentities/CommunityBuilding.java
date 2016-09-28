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
	private int health = 1400;
	
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
		specifications(6, 8, 8, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the community building. Requires an integer 
	 * value of the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
}
