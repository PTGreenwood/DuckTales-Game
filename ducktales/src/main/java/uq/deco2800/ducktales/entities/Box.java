package uq.deco2800.ducktales.entities;

/**
 * Class representing a basic box.
 * 
 * @author leggy
 *
 */
public class Box extends Entity {

	private final static String TYPE = "box";

	protected Box(int x, int y, int lengthX, int lengthY) {
		super(x, y, lengthX, lengthY, TYPE);
	}

	public Box(int x, int y) {
		this(x, y, 1, 1);
	}

	@Override
	public void tick() {
	}
}
