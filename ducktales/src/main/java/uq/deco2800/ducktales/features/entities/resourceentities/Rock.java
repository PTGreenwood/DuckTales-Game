package uq.deco2800.ducktales.features.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import uq.deco2800.ducktales.resources.ResourceType;


public class Rock extends ResourceEntity{

	private static final ResourceType[] TYPES = {ROCK_1, ROCK_2};
	/**
	 * Initialise a new rock. Requires the location of the rock 
	 *  to be passed.
	 * @param x, x location of the rock
	 * @param y, y location of the rock
	 */	
	public Rock(double x, double y) {
		super(x, y, 1, 1, rare(TYPES), DEFVALUE);
	}

	@Override
	public void tick() {		
	}

	@Override
	public boolean isPassable() {
		return false;
	}
}
