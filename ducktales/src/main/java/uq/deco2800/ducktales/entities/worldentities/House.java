package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A House.
 * @author Leggy
 *
 */
public class House extends WorldEntity {
	
	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.HOUSE;

	private int Health =1000;


	public House(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}
	
	public void ChangeHealth(int NewValue){
		if (NewValue >0){
			this.Health =NewValue;
		}
	}
	
	public int GetHealth(){
		return Health;
	}
	
	protected void specifications() {
		WorldEntity.STONERESOURCES = 2;
		WorldEntity.WOODRESOURCES = 4;
		WorldEntity.TIME = 2;
	}

	@Override
	public void tick() {
	}
}
