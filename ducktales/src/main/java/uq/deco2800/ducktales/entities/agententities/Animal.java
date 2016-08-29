package uq.deco2800.ducktales.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;

/**
 * Base class for all animals.
 *
 * @author Josh Benavides
 */
public class Animal extends AgentEntity {

    private final static int minStartHealth = 20;
    private final static int minStartHunger = 20;
    private final static int minStartThirst = 20;
    private final static int minStartStrength = 5;

    protected Point currentLocation; // The animal's current location.
    protected Point nextLocation; // The location that the animal will move to.
    protected int health; // The animal's state of health.
    protected int hunger; // The animal's state of hunger.
    protected int thirst; // The animal's state of thirst.
    protected int strength; // The animal's strength.
    protected double speed; // The animal's movement speed.
    protected ResourceType type; // The type of the animal
    private boolean canBeKilled; // Determines whether the animal can be killed.
    private boolean outOfZone; // Determines whether the animal is out of its zone
    private boolean isDead = false; // Whether the animal is dead.


    public Animal(int x, int y, int lengthX, int lengthY, ResourceType type, int health, int hunger, int thirst, int
            strength, double speed) {
        super(x, y, lengthX, lengthY, type);
        this.type = type;
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.strength = strength;
        this.speed = speed;
        this.currentLocation = point;
        newNextLocation();
    }

    /**
     * Marks the animal as dead.
     */
    public void setIsDead() {
        if (this.getHealth() == 0) {
            this.isDead = true;
        }
    }

    /**
     * Tells the animal to attack.
     */
    public void attack(Peon opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }

    /**
     * Sets the health that the animal is spawned with.
     *
     * @param startingHealth The starting health of the animal.
     */
    protected void setStartingHealth(int startingHealth) {
        if (startingHealth < minStartHealth) {
            setHealth(minStartHealth);
        } else {
            setHealth(startingHealth);
        }
    }

    /**
     * Sets the hunger state that the animal is spawned with.
     *
     * @param startingHunger The starting hunger state of the animal.
     */
    protected void setStartingHunger(int startingHunger) {
        if (startingHunger < minStartHunger) {
            setHunger(minStartHunger);
        } else {
            setHunger(startingHunger);
        }
    }

    /**
     * Sets the thirst state that the animal is spawned with.
     *
     * @param startingThirst The starting thirst state of the animal.
     */
    protected void setStartingThirst(int startingThirst) {
        if (startingThirst < minStartThirst) {
            setThirst(minStartThirst);
        } else {
            setThirst(startingThirst);
        }
    }

    /**
     * Sets the strength level that the animal is spawned with.
     *
     * @param startingStrength The starting strength level of the animal.
     */
    protected void setStartingStrength(int startingStrength) {
        if (startingStrength < minStartStrength) {
            setStrength(minStartStrength);
        } else {
            setStrength(startingStrength);
        }
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
    public void isAttacked() {
        this.health -= 10; // the health will be decreased by the amount of the peon's attack/strength -> replace 10
        if (this.getHealth() <= 0) {
            killAnimal();
        }
    }

    /**
     * Enables the animal to be killed.
     */
    public void killAnimal() {
        this.canBeKilled = true;
//		if(this.getHunger() <= 0 && this.getThirst() <= 0) {
//			this.health = 0;
//		}
//		if(this.getHealth() <= 0) {
//			this.canBeKilled = true; // The animal will be removed in the AnimalManager class.
//		}
    }

    /**
     * Identifies whether the animal is out of its zone.
     */
    public void isOutOfZone() {
        // if animal location is out of zone limit:
        this.outOfZone = true;
    }

    /**
     * Tells the animal to attack another entity.
     */
    public void attack() {
    }

    /**
     * Changes the animal's image to the provided value.
     *
     * @param newType The new image to be rendered.
     */
    public void setType(ResourceType newType) {
        this.setType(newType);
    }

    /**
     * Returns the animal's current point on the map.
     *
     * @return currentLocation The animal's current point on the map.
     */
    public Point getCurrentLocation() {
        return new Point(currentLocation);
    }

    /**
     * Return the animal's next point on the map to move to.
     *
     * @return nextLocation The animal's destination point.
     */
    public Point getNextLocation() {
        return new Point(nextLocation);
    }

    /**
     * Returns the animal's current health.
     *
     * @return health The animal's current health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Changes the animal's health to the provided value.
     *
     * @param newHealth The new health value.
     */
    public void setHealth(int newHealth) {
        if (newHealth > 100) {
            this.health = 100;
        } else if (newHealth < 0) {
            this.health = 0;
        } else {
            this.health = newHealth;
        }
    }

    // Getter Methods Below

    /**
     * Returns the animal's current state of hunger.
     *
     * @return hunger The animal's hunger.
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Changes the animal's hunger level to the provided value.
     *
     * @param newHunger The new hunger value.
     */
    public void setHunger(int newHunger) {
        if (newHunger > 100) {
            this.hunger = 100;
        } else if (newHunger < 0) {
            this.hunger = 0;
        } else {
            this.hunger = newHunger;
        }
    }

    /**
     * Returns the animal's current state of thirst.
     *
     * @return thirst The animal's thirst.
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * Changes the animal's thirst level to the provided value.
     *
     * @param newThirst The new thirst value.
     */
    public void setThirst(int newThirst) {
        if (newThirst > 100) {
            this.thirst = 100;
        } else if (newThirst < 0) {
            this.thirst = 0;
        } else {
            this.thirst = newThirst;
        }
    }

    /**
     * Returns the animal's strength.
     *
     * @return strength The animal's strength.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Changes the animal's strength level to the provided value.
     *
     * @param newStrength The new strength value.
     */
    public void setStrength(int newStrength) {
        this.strength = newStrength;
    }

    /**
     * Returns the animal's speed.
     *
     * @return speed The animal's speed.
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

    /**
     * Returns whether the duck is dead.
     *
     * @return isDead
     */
    public boolean isDead() {
        return this.isDead;
    }
}
