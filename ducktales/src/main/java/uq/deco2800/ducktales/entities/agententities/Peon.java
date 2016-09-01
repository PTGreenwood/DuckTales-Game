package uq.deco2800.ducktales.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.AStar;
import uq.deco2800.ducktales.util.Point;

/**
 * Class representing the worker.
 * 
 * @author Leggy
 *
 */
public class Peon extends AgentEntity {

	private static final Random RANDOM = new Random();

	private final static ResourceType TYPE = ResourceType.PEON;

	private List<Point> goalPoints;

	//Peon stats
	private double speed;
	private int health = 1000;
	private int hunger = 100;
	private int thirst = 100;
	
	private int resource= 0;

	// affinity
	private int strength;
	private int intelligence;

	// affinity bounds
	private static final int DEFAULT_MAX = 10;
	private static final int DEFAULT_MIN = 1;

	/**
	 * @param x
	 * @param y
	 */
	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
		strength = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		intelligence = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		this.speed = 0.05;
		this.goalPoints = new ArrayList<Point>();
	}

	public void setHealth(int newValue) {
		if (newValue > 0) {
			this.health = newValue;
		}
	}
	public void setResources(int sourceValue){
		if (sourceValue > 0){
			this.resource= sourceValue;
			
		}
	}
	
	//lower hunger/thirst would decrease the speed?
	public void setHunger(int newValue) {
		if (newValue > 0) {
			this.hunger = newValue;
		}
	}
	
	public void setThirst(int newValue) {
		if (newValue > 0) {
			this.thirst = newValue;
		}
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
	
	public int getStrength(){
		return strength;
	}
	
	public int getIntelligence(){
		return intelligence;
	}

	@Override
	public void tick() {
		if (goalPoints.isEmpty()) {
			goalPoints = newGoalPoints();
		} else if (point.distance(goalPoints.get(0)) < speed) {
			point = goalPoints.remove(0);
			GameManager.getInstance().getWorld().getTile(point).reset();
			if (goalPoints.isEmpty()) {
				this.goalPoints = newGoalPoints();
			}
		} else {
			point.moveToward(goalPoints.get(0), speed);
		}
		calculateRenderingOrderValues();
	}

	private List<Point> newGoalPoints() {
		Random random = new Random();
		Point goalPoint = null;
		while (goalPoint == null || !GameManager.getInstance().getWorld().getTile(goalPoint).isPassable()) {
			goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
		}

		List<AStar.Tuple> path = AStar.aStar(point, goalPoint, GameManager.getInstance().getWorld());
		List<Point> goalPoints = new ArrayList<Point>();

		for (AStar.Tuple tuple : path) {
			goalPoints.add(new Point(tuple.getX(), tuple.getY()));
			GameManager.getInstance().getWorld().getTile(tuple.getX(), tuple.getY()).makePath();
		}
		return goalPoints;
	}
}
