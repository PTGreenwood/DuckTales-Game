package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a basic box.
 * 
 * @author Leggy
 *
 */
public class Box extends Building {

	private final static ResourceType TYPE = ResourceType.BOX;

	public Box(int x, int y) {
		super(x, y, 1, 1, TYPE);
		Building.STONERESOURCES = 2;
		Building.WOODRESOURCES = 2;
		Building.TIME = 4;
	}

	@Override
	public void tick() {
	}
}
