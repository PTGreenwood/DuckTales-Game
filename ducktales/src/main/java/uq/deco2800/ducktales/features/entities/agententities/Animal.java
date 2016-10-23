package uq.deco2800.ducktales.features.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.event.Event;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.AStar;
import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.util.events.animal.AnimalDeadEvent;

import uq.deco2800.ducktales.features.seasons.SeasonManager;

/**
 * Base class for all animals.
 *
 * @author Josh Benavides
 */
public class Animal extends AgentEntity {
    private SeasonManager season = new SeasonManager();

    /** The main manager of the game */
    protected GameManager gameManager;

    /** The animal manager of the game */
    protected AnimalManager animalManager;

    /** The droppable resource entity manager of the game */
    protected ResourceEntityManager resourceEntityManager;

    /** instance of AnimalDeadEvent */
    private AnimalDeadEvent animalDeadEvent;

    private static final int MINSTARTHEALTH = 20;
    private static final int MAXSTARTHEALTH = 100;
    private static final int MINSTARTHUNGER = 0;
    private static final int MAXSTARTHUNGER = 50;
    private static final int MINSTARTTHIRST = 0;
    private static final int MAXSTARTTHIRST = 50;
    private static final int MINSTARTSTRENGTH = 0;
    private static final int MAXSTARTSTRENGTH = 50;
    private static final int HUNGERINCREASERATE = 10; // Rate at which hunger will increase.
    private static final int THIRSTINCREASERATE = 10; // Rate at which thirst will increase.
    private static final int HEALTHDECREASERATE = 10; // Rate at which health will decrease.
    protected int health; // The animal's state of health.
    protected int hunger; // The animal's state of hunger.
    protected int thirst; // The animal's state of thirst.
    protected int strength; // The animal's strength.
    protected double speed; // The animal's movement speed.
    protected ResourceType type; // The type of the animal
    private int time = 0; // Interval in game minutes with which attributes will decrease.
    private boolean canBeKilled; // Determines whether the animal can be killed.
    private boolean outOfZone; // Determines whether the animal is out of its zone
    private boolean isDead = false; // Whether the animal is dead.
    private String direction; // The direction that the animal is travelling.
    private List<Point> goalPoints;
    private MainEntityManager mainEntityManager = MainEntityManager.getInstance();
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
        this.goalPoints = new ArrayList<>();
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
            point.moveToward(goalPoints.get(0), getSpeed());
        }
        if(isDead()) {
        	// change sprite to death animation
        }
        statusUpdate();
        calculateRenderingOrderValues();
        System.out.println(season.getCurrentSeason().getCurrentTemperature());
    }

    /**
     * Determines the destination of the animal as well as the pathing to get to the destination.
     */
    protected List<Point> newGoalPoints() {
        if (gameManager != null) {
            // This animal has had a handle on the game manager
            Random random = new Random();
            Point goalPoint = null;
            while (goalPoint == null || !gameManager.getWorld().getTile(goalPoint).isPassable() &&
                    !gameManager.getWorld().getTile(goalPoint).getTileType().equals(ResourceType.WATER)) {
                goalPoint = new Point(random.nextDouble() * gameManager.getWorld().getWidth(),
                        random.nextDouble() * gameManager.getWorld().getHeight());
            }
            List<AStar.Tuple> path = AStar.aStar(point, goalPoint, gameManager.getWorld());
            List<Point> goalPoints = new ArrayList<Point>();
            for (AStar.Tuple tuple : path) {
                goalPoints.add(new Point(tuple.getX(), tuple.getY()));
            }

            System.err.println("Goal points: " + goalPoints);

            return goalPoints;
        } else {
            return null;
        }
    }

    /**
     * Give the animal a handle on the main manager of the game
     *
     * @param gameManager
     *          The main manager of the game
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**     * Incrementally increases the hunger and thirst level of the animal.
     */
    private void statusUpdate() {
        time += 1;
        // the animal's hunger, thirst and/or health will be incremented every 3 minutes.
        if (time == 120) {
            setHunger(getHunger() + HUNGERINCREASERATE);
            setThirst(getThirst() + THIRSTINCREASERATE);
            if (getHunger() >= 50 || getThirst() >= 50) {
                setHealth(getHealth() - HEALTHDECREASERATE);
            }
            if(getHealth() <= 0) {
            	setIsDead();
            }
            time = 0; // reset timer until next update
        }
    }

    /**
     * Marks the animal as dead and removes itself from the mainEntityManager.
     */
    public void setIsDead() {
            this.isDead = true;
    }

    /**
     * Fires an event for when an animal dies
     */
    public void setOffAnimalDeadEvent() {
    	Event.fireEvent(animalDeadEvent.getTarget(), new AnimalDeadEvent(type, this.getX(), this.getY()));
    }

    /**
     * Tells the animal to attack a Peon.
     *
     * @param opponent The peon to be attacked.
     */
    public void attack(Peon opponent) {
        if (this.getOutOfZone()) {
            opponent.setHealth(opponent.getHealth() - this.getStrength());
        }
//        if (opponent.getHealth() <= 0) {
//            mainEntityManager.removeEntity(opponent);
//        }
    }

    /**
     * Sets the health that the animal is spawned with. The animal's starting health value must be between
     * MINSTARTHEALTH and MAXSTARTHEALTH inclusive.
     *
     * @param startingHealth The starting health value of the animal.
     */
    protected void setStartingHealth(int startingHealth) {
        if (startingHealth < MINSTARTHEALTH) {
            setHealth(MINSTARTHEALTH);
        } else if (startingHealth > MAXSTARTHEALTH) {
            setHealth(MAXSTARTHEALTH);
        } else {
            setHealth(startingHealth);
        }
    }

    /**
     * Sets the hunger state that the animal is spawned with.The animal's starting hunger level must be between
     * MINSTARTHUNGER and MAXSTARTHUNGER inclusive.
     *
     * @param startingHunger The starting hunger level of the animal.
     */
    protected void setStartingHunger(int startingHunger) {
        if (startingHunger <= MINSTARTHUNGER) {
            setHunger(MINSTARTHUNGER);
        } else if (startingHunger >= MAXSTARTHUNGER) {
            setHunger(MAXSTARTHUNGER);
        } else {
            setHunger(startingHunger);
        }
    }

    /**
     * Sets the thirst state that the animal is spawned with. The animal's starting thirst level must be between
     * MINSTARTTHIRST and MAXSTARTHUNGER inclusive.
     *
     * @param startingThirst The starting thirst level of the animal.
     */
    protected void setStartingThirst(int startingThirst) {
        if (startingThirst <= MINSTARTTHIRST) {
            setThirst(MINSTARTTHIRST);
        } else if (startingThirst >= MAXSTARTTHIRST) {
            setThirst(MAXSTARTTHIRST);
        } else {
            setThirst(startingThirst);
        }
    }

    /**
     * Sets the strength level that the animal is spawned with. The animal's starting strength level must be between
     * MINSTARTSTRENGTH and MAXSTARTSTRENGTH inclusive.
     *
     * @param startingStrength The starting strength level of the animal.
     */
    protected void setStartingStrength(int startingStrength) {
        if (startingStrength <= MINSTARTSTRENGTH) {
            setStrength(MINSTARTSTRENGTH);
        } else if (startingStrength >= MAXSTARTSTRENGTH) {
            setStrength(MAXSTARTSTRENGTH);
        } else {
            setStrength(startingStrength);
        }
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
     * Changes the animal's hunger level to the provided value. The animal's hunger level must always be between 0
     * and 100 inclusive. Hunger level equalling 100 will cause negative effects on animal health, while thirst level
     * equalling 0 means that the animal is not hungry.
     *
     * @param newHunger The new hunger value.
     */
    public void setHunger(int newHunger) {
        if (newHunger >= 100) {
            this.hunger = 100;
        } else if (newHunger <= 0) {
            this.hunger = 0;
        } else {
            this.hunger = newHunger;
        }
    }


    /**
     * Changes the animal's thirst level to the provided value. The animal's thirst level must always be between 0
     * and 100 inclusive.   Thirst level equalling 100 will cause negative effects on animal health, while thirst
     * level equalling 0 means that the animal is not thirsty.
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
     * Changes the animal's health to the provided value. The animal's health must always be between 0 and 100
     * inclusive.
     *
     * @param newHealth The new health value.
     */
    public void setHealth(int newHealth) {
        if (newHealth >= 100) {
            this.health = 100;
        } else if (newHealth <= 0) {
            this.health = 0;
        } else {
            this.health = newHealth;
        }
    }

    /**
     * Changes the animal's strength level to the provided value.
     *
     * @param newStrength The new strength value.
     */
    public void setStrength(int newStrength) {
        this.strength = newStrength;
    }

    // Getter Methods Below

    /**
     * Returns the animal's current health.
     *
     * @return health The animal's current health.
     */
    public int getHealth() {
        return health;
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
     * Returns the animal's current state of thirst.
     *
     * @return thirst The animal's thirst.
     */
    public int getThirst() {
        return thirst;
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

    /**
     * Get the resourceType of the animal
     * @return the resourceType of the animal
     */
    public ResourceType getType() {
    	return this.type;
    }
}
