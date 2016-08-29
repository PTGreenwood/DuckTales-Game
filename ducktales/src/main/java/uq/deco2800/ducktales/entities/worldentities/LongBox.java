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
		WorldEntity.STONERESOURCES = 2;
		WorldEntity.WOODRESOURCES = 2;
		WorldEntity.TIME = 2;
	}

	@Override
	public void tick() {
		
	}
	
}
