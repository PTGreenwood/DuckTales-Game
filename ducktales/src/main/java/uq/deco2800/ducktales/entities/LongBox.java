package uq.deco2800.ducktales.entities;

/**
 * Representation of a longer box.
 * @author leggy
 *
 */
public class LongBox extends Entity {
	
	private final static String TYPE = "long_box";

	public LongBox(int x, int y) {
		super(x, y, 2, 1, TYPE);
	}

	@Override
	public void tick() {
		
	}

}
