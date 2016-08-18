package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.util.Point;

import java.util.Random;

/**
 * Base class for all animals.
 */
public abstract class Animal extends AgentEntity {

	// The animal's current location.
	protected Point currentLocation;
	// The location that the animal will move to.
	protected Point nextLocation;
	// The animal's state of health.
	private int health;
	// The animal's state of hunger.
	private int hunger;
	// The animal's state of thirst.
	private int thirst;
	// The animal's movement speed.
	private double speed;
	// The image to be rendered.
	private String image;
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
		newNextLocation();
	}

	/**
	 * Determines the Point that the animal will move to.
	 */
	public void newNextLocation() {
		Random random = new Random();
		nextLocation = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
	}

	public Point getCurrentLocation() {
		return new Point(currentLocation);
	}

	public Point getNextLocation() {
		return new Point(nextLocation);
	}

	public int getHealth() {
		return health;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public void isOutOfZone() {
		this.outOfZone = true;
	}

	// ???
	public void spawnAnimal() {
		// animals spawned using the world class under world package?
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
