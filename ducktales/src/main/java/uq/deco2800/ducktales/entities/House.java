package uq.deco2800.ducktales.entities;

/**
 * A House.
 * @author Leggy
 *
 */
public class House extends WorldEntity{
	
	private final static String TYPE = "house";

	protected House(double x, double y) {
		super(x, y, 3, 3, TYPE);
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}

}
