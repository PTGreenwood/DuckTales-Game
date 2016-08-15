package uq.deco2800.ducktales.entities;

/**
 * Created by joooo on 15/08/2016.
 */
public class AnimalDuck extends Animal{

	private final static String IMAGE = "duck";

	public AnimalDuck(int x, int y) {
		super(x, y, 100, 100, 100, 0.05, 1, 1, IMAGE);
	}

	@Override
	public void tick() {
		if (point.distance(nextLocation) < speed) {
			point = nextLocation;
			newNextLocation();
		} else {
			point.moveToward(nextLocation, speed);
		}
		calculateRenderingOrderValues();
	}
}
