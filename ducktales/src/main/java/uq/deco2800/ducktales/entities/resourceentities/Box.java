package uq.deco2800.ducktales.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import uq.deco2800.ducktales.resources.ResourceType;

public class Box extends ResourceEntity{

	private static ResourceType[] TYPES = {BOX};

	public Box(double x, double y) {
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