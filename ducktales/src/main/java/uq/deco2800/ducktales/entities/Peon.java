package uq.deco2800.ducktales.entities;

/**
 * Class representing the worker.
 * 
 * @author leggy
 *
 */
public class Peon extends Entity {

	private final static String TYPE = "peon";

	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
	}

	@Override
	public void tick() {
		//TODO: Implement movement.
	}

}
