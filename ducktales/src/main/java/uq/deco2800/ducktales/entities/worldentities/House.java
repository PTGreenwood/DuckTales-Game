package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A House.
 * @author Leggy
 *
 */
public class House extends WorldEntity{
	

	//private static final String TYPE = "house";

	private final static ResourceType TYPE = ResourceType.HOUSE;
	
	private static final int TIME = 2;
	
	private static final int BUILDRESOURCES = 5;

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
	
	public int resourcesBuild() {
		return BUILDRESOURCES;

	}
	
	public int resourcesReturn() {
		return (int) (0.5*BUILDRESOURCES);
	}

}
