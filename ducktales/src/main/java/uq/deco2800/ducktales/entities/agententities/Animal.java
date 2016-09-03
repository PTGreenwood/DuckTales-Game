package uq.deco2800.ducktales.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.AStar;
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

    protected int health; // The animal's state of health.
    protected int hunger; // The animal's state of hunger.
    protected int thirst; // The animal's state of thirst.
    protected int strength; // The animal's strength.
    protected double speed; // The animal's movement speed.
    protected ResourceType type; // The type of the animal
    private boolean canBeKilled; // Determines whether the animal can be killed.
    private boolean outOfZone; // Determines whether the animal is out of its zone
    private boolean isDead = false; // Whether the animal is dead.
    private String direction; // The direction that the animal is travelling.
    private List<Point> goalPoints;
    private EntityManager entityManager = EntityManager.getInstance();
    // The variables below are used to alternate images for animation.
    private int animationStage; // Determines which of the two images per direction is rendered.
    private int currentAnimationTick;
    private int animationSpeed;


    public Animal(int x, int y, ResourceType type, int health, int hunger, int thirst, int
            strength, double speed) {
        super(x, y, 1, 1, type);
        this.type = type;
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.strength = strength;
        this.speed = speed;
        this.canBeKilled = false;
        this.outOfZone = false;
        this.isDead = false;
        this.goalPoints = new ArrayList<Point>();
        this.animationStage = 0;
        this.currentAnimationTick = 0;
        this.animationSpeed = 1;
    }

    /**
     * Original tick
     */
    @Override
    public void tick() {
        if (goalPoints.isEmpty()) {
            goalPoints = newGoalPoints();
        } else if (point.distance(goalPoints.get(0)) < speed) {
            point = goalPoints.remove(0);
            if (goalPoints.isEmpty()) {
                this.goalPoints = newGoalPoints();
            }
        } else {
            String newDir = null;
            if (goalPoints.get(0).getX() > point.getX()) {
                newDir = "Left";
            }
            if (goalPoints.get(0).getX() < point.getX()) {
                newDir = "Right";
            }
            if (goalPoints.get(0).getY() > point.getY()) {
                newDir = "Down";
            }
            if (goalPoints.get(0).getY() < point.getY()) {
                newDir = "Up";
            }
            setDirection(newDir);
            updateType(ResourceType.valueOf(getSprite()));
            point.moveToward(goalPoints.get(0), getSpeed());
        }
        calculateRenderingOrderValues();
    }

    /**
     * Determines the destination of the animal as well as the pathing to get to the destination.
     */
    private List<Point> newGoalPoints() {
        Random random = new Random();
        Point goalPoint = null;
        while (goalPoint == null || !GameManager.getInstance().getWorld().getTile(goalPoint).isPassable() &&
                !GameManager.getInstance().getWorld().getTile(goalPoint).getTileType().equals(ResourceType.WATER)) {
            goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
        }
        List<AStar.Tuple> path = AStar.aStar(point, goalPoint, GameManager.getInstance().getWorld());
        List<Point> goalPoints = new ArrayList<Point>();
        for (AStar.Tuple tuple : path) {
            goalPoints.add(new Point(tuple.getX(), tuple.getY()));
        }
        return goalPoints;
    }

    /**
     * Marks the animal as dead.
     */
    public void setIsDead() {
        if (this.getHealth() <= 0) {
            this.isDead = true;
            entityManager.removeEntity(this);
        }
    }

    /**
     * Tells the animal to attack a Peon.
     *
     * @param opponent The peon to be attacked.
     */
    public void attack(Peon opponent) {
        if (this.getOutOfZone() == true) {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
        }
        if (opponent.getHealth() <= 0) {
            entityManager.removeEntity(opponent);
        }
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
     * Enables the animal to be killed.
     */
    public void killAnimal() {
        this.canBeKilled = true;
        entityManager.removeEntity(this);
    }

    /**
     * Changes the animal's image to the provided value.
     *
     * @param newType The new image to be rendered.
     */
    public void setType(ResourceType newType) {
        this.type = newType;
    }

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
     * Get the sprite string name. The sprite string name, i.e. "DuckDownLeft"
     *
     * @return sprite The String name of the sprite to be rendered.
     */
    public String getSprite() {
        String spriteName;
        if (this.getType().toString().contains("DUCK")) {
            spriteName = ResourceType.DUCK.toString();
            spriteName += this.getDirection();
        } else {
            spriteName = ResourceType.COW.toString();
            spriteName += this.getDirection();
        }
        if (currentAnimationTick == animationSpeed) {
            if (animationStage > 0) {
                animationStage = 0;
            } else {
                animationStage = 1;
            }
            currentAnimationTick = 0;
        } else {
            currentAnimationTick++;
        }
        spriteName += Integer.toString(animationStage);
        return spriteName;
    }

    /**
     * Returns a value saying whether the animal can be killed.
     *
     * @return canBeKilled Flags the animal as able to be killed.
     */
    public boolean canBeKilled() {
        return this.canBeKilled;
    }

    /**
     * Returns whether the animal is dead.
     *
     * @return isDead Flags the animal as dead.
     */
    public boolean isDead() {
        return this.isDead;
    }

    /**
     * Returns the string direction of the animal.
     *
     * @return direction The string direction of the animal
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * Sets the direction of the animal to the new animal.
     *
     * @param newDirection The string new direction of the animal's movement.
     */
    public void setDirection(String newDirection) {
        this.direction = newDirection;
    }

    /**
     * Returns the animal's speed.
     *
     * @return speed The animal's speed.
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Identifies whether the animal is out of its zone.
     */
    public boolean getOutOfZone() {
        // if animal location is out of zone limit:
        return outOfZone;
    }

    /**
     * Set status of animal's out of zone state.
     *
     * @param x The status of the animal's out of zone state.
     */
    public void setOutOfZone(boolean x) {
        this.outOfZone = x;
    }
}
