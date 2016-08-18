package uq.deco2800.ducktales.entities.agententities;

/**
 * Duck animal that lays eggs.
 *
 * @author Josh Benavides
 */
public class AnimalDuck extends Animal{

	private final static String IMAGE = "duck";

	public AnimalDuck(int x, int y) {
		super(x, y, 100, 100, 100, 0.05, 1, 1, IMAGE);
	}


}
