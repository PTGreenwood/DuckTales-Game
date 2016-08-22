package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.util.Point;

import java.util.Random;

/**
 * Base class for all animals.
 *
 * @author Josh Benavides
 */
public abstract class Animal extends AgentEntity {

	// The animal's current location.
	protected Point currentLocation;
	// The location that the animal will move to.
	protected Point nextLocation;
	// The animal's state of health.
	protected int health;
	// The animal's state of hunger.
	protected int hunger;
	// The animal's state of thirst.
	protected int thirst;
	// The animal's movement speed.
	protected double speed;
	// The image to be rendered.
	protected String image;
	// Determines whether the animal can be killed.
	private boolean canBeKilled;
	// Determines whether the animal is out of its zone
	private boolean outOfZone;

	public Animal(int x, int y, int health, int hunger, int thirst, double
			speed, int lengthX, int lengthY, String type) {
		super(x, y, lengthX, lengthY, type);
		this.image = type;
		this.health = health;
		this.hunger = hunger;
		this.thirst = thirst;
		this.speed = speed;
		this.currentLocation = point;
		newNextLocation();
	}

	/**
	 * Tick stuff.
	 */
	@Override
	public void tick() {
		if (point.distance(nextLocation) < speed) {
			point = nextLocation;
			newNextLocation();
		} else {
			point.moveToward(nextLocation, speed);
		}
		calculateRenderingOrderValues();
		currentLocation = nextLocation;
	}

	/**
	 * Determines the Point that the animal will move to.
	 */
	public void newNextLocation() {
		Random random = new Random();
		nextLocation = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
	}

	/**
	 * The animal's health is decreased when attacked by another entity.
	 */
	public void animalIsAttacked() {
		this.health -= 10; // the health will be decreased by the amount of the peon's attack/strength -> replace 10
		if (this.getHealth() <= 0) {
			killAnimal();
		}
	}

	/**
	 * Enables the animal to be killed.
	 */
	public void killAnimal() {
		if(this.getHunger() <= 0 && this.getThirst() <= 0) {
			this.health = 0;
		}
		if(this.getHealth() <= 0) {
			this.canBeKilled = true; // The animal will be removed in the AnimalManager class.
		}
	}

	/**
	 * Identifies that the animal is out of its zone.
	 */
	public void isOutOfZone() {
		// if animal location is out of zone limit:
		this.outOfZone = true;
	}

	// Getter Methods Below

	/**
	 * Returns the animal's current point on the map.
	 *
	 * @return currentLocation
	 */
	public Point getCurrentLocation() {
		return new Point(currentLocation);
	}

	/**
	 * Return the animal's next point on the map to move to.
	 *
	 * @return nextLocation
	 */
	public Point getNextLocation() {
		return new Point(nextLocation);
	}

	/**
	 * Returns the animal's current health.
	 *
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Returns the animal's current state of hunger.
	 *
	 * @return hunger
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Returns the animal's current state of thirst.
	 *
	 * @return thirst
	 */
	public int getThirst() {
		return thirst;
	}

	/**
	 * Returns the animal's speed.
	 *
	 * @return speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * Returns a value saying whether the animal can be killed.
	 *
	 * @return canBeKilled
	 */
	public boolean canBeKilled() {
		return canBeKilled;
	}

	// ???
	public void spawnAnimal() {
		// animals spawned using the world class under world package?
		// AnimalManager class?
	}
}
