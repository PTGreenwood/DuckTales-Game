package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a longer box.
 * @author Leggy
 *
 */
public class LongBox extends WorldEntity {
	
	private final static ResourceType TYPE = ResourceType.LONG_BOX;

	public LongBox(int x, int y) {
		super(x, y, 2, 1, TYPE);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public boolean isPassable() {
		return false;
	}

}
