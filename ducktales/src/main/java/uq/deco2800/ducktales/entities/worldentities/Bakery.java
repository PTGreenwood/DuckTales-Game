package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * A Bakery.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public class Bakery extends WorldEntity{
	
	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = BAKERY;

	private static final int TIME = 4;
	
	private static final int WOODRESOURCES = 6;

	private static final int STONERESOURCES = 4;
	
	public Bakery(double x, double y) {
		super(x, y, 2, 2, TYPE, TIME, WOODRESOURCES, STONERESOURCES);
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
	 * @return the amount of wood required to construct a bakery
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
	 * @return the amount of stone required to construct a bakery
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
