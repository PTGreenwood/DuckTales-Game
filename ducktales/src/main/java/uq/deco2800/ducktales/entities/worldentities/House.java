package uq.deco2800.ducktales.entities.worldentities;

/**
 * A House.
 * @author Leggy
 *
 */
public class House extends WorldEntity{
	
	private final static String TYPE = "house";
	
	private final static int TIME = 2;
	
	private final static int resourcesToBuild = 5;

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
		return resourcesToBuild;

	}
	
	public int resourcesReturn() {
		return (int) (0.5*resourcesToBuild);
	}

}
