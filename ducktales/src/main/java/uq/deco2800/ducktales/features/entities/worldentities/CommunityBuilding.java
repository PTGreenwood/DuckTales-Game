package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Community Building.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class CommunityBuilding extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.COMMUNITY_BUILDING;
	
	
	/**
	 * Initialise a new barn. Requires the location of the community building 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public CommunityBuilding(double x, double y) {
		super(x, y, 2, 2, TYPE);
		
	}
	
	/**
	 * Update the WorldEntity properties with those of a community building.
	 */
	protected void specifications() {
		STONERESOURCES = 6;
		WOODRESOURCES = 8;
		TIME = 8;
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
