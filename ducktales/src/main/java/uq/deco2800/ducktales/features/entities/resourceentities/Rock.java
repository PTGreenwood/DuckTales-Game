package uq.deco2800.ducktales.features.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import uq.deco2800.ducktales.resources.ResourceType;


public class Rock extends ResourceEntity{

	private static final ResourceType[] TYPES = {ROCK_1, ROCK_2};

	public Rock(double x, double y) {
		super(x, y, 1, 1, TYPES[1], 0);
	}

	@Override
	public void tick() {		
	}

	@Override
	public boolean isPassable() {
		return false;
	}
}
