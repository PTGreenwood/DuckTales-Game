package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a longer box.
 * @author Leggy
 *
 */
public class LongBox extends Building {
	
	private final static ResourceType TYPE = ResourceType.LONG_BOX;
	
	private static final int TIME = 2;
	
	private static final int WOODRESOURCES = 2;
	
	private static final int STONERESOURCES = 2;

	public LongBox(int x, int y) {
		super(x, y, 2, 1, TYPE);
		Building.STONERESOURCES = 2;
		Building.WOODRESOURCES = 2;
		Building.TIME = 2;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public boolean isPassable() {
		return false;
	}
	
	public int timeToBuild() {
		return TIME;
	}
	
	/**
	 * Public method to access and return the integer representation of the 
	 * wood required to construct the bakery.
	 * 
	 * @return the amount of wood required to construct a house
	 */
	public int resourcesBuildWood() {
		return WOODRESOURCES;

	}
	
	/**
	 * Public method to access and return the integer representation of the 
	 * wood returned when a building is selected to be destroyed by the 
	 * user. Will return half of the wood required to construct.
	 * 
	 * @return the amount of wood refunded when demolished
	 */
	public int resourcesReturnWood() {
		return (int) (0.5*WOODRESOURCES);
	}
	
	/**
	 * Public method to access and return the integer representation of the 
	 * stone required to construct the bakery.
	 * 
	 * @return the amount of stone required to construct a house
	 */
	public int resourcesBuildStone() {
		return STONERESOURCES;

	}
	
	/**
	 * Public method to access and return the integer representation of the 
	 * stone returned when a building is selected to be destroyed by the 
	 * user. Will return half of the wood required to construct.
	 * 
	 * @return the amount of stone refunded when demolished
	 */
	public int resourcesReturnStone() {
		return (int) (0.5*STONERESOURCES);
	}
	
}
