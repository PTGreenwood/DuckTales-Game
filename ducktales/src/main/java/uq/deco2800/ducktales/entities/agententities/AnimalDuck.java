package uq.deco2800.ducktales.entities.agententities;

/**
 * Defines the animal Duck that lays eggs.
 *
 * @author Josh Benavides
 */
public class AnimalDuck extends Animal {

	private final static String IMAGE = "duck";
	// Whether the duck can lay eggs.
	private boolean canLayEggs = false;
	// Whether the duck can drop feathers.
	private boolean canDropFeathers = false;
	// Whether the duck is dead.
	private boolean isDead = false;


	// AnimalDuck attributes will be set in the AnimalManagerClass
	public AnimalDuck(int x, int y) {
		super(x, y, (int) ((Math.random() + 0.1) * 100), (int) ((Math.random() + 0.1) * 100), (int) ((Math.random() +
			0.1) * 100), 0.05, 1, 1, IMAGE);
	}

	/**
	 * Checks whether the duck can lay eggs. Ducks can only lay eggs if their health, hunger, and thirst meet satisfy
	 * a certain threshold.
	 */
	private void layEggs() {
		if(this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
			this.canLayEggs = true;
		}
	}

	/**
	 * Enables the duck to drop feathers.
	 */
	private void DropFeathers() {
		if(this.isDead() == true) {
			this.canDropFeathers = true;
		}
	}

	// Getter methods below.

	/**
	 * Returns whether the duck is dead.
	 * @return isDead;
	 */
	private boolean isDead() {
		return this.isDead;
	}

	/**
	 *  Returs whether the duck can lay eggs.
	 * @return canLayEggs
	 */
	private boolean canLayEggs() {
		return this.canLayEggs;
	}




}
