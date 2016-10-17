package uq.deco2800.ducktales.features.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.worldentities.StorageProduceBuilding.production;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.AStar;
import uq.deco2800.ducktales.util.Point;

import org.apache.commons.lang3.tuple.Triple;
/**
 * Class representing the worker.
 * Cart will have 1000 health
 *
 * 
 *
 */
public class Cart extends AgentEntity {

	/** The Main Manager of the game */
	protected GameManager gameManager;

	private static final ResourceType TYPE = ResourceType.PEON;
	private List<Point> goalPoints;

	private double speed = 0.05;
	private int health = 1000;
	private int resource = 0;
	
	// Cart storage
	private ArrayList<Triple<production, Integer, Integer>> storage = 
			new ArrayList<Triple<production, Integer, Integer>>();
	
		/**
	 * @param x
	 * @param y
	 */
	public Cart(int x, int y) {
		super(x, y, 1, 1, TYPE);
		storage.add(0, Triple.of(production.TIMBER, 10, 0));
		storage.add(1, Triple.of(production.STONE, 10, 0));
		storage.add(2, Triple.of(production.ORE, 10, 0));
		storage.add(3, Triple.of(production.FOOD, 10, 0));
	}

	/**
	 * Health limit is between 1000 and 0
	 */
	public void setHealth(int newValue) {
		if (newValue > 1000) {
			this.health = 1000;
		} else if (newValue >= 0) {
			this.health = newValue;
		} else if (newValue < 0) {
			this.health = 0;
		}
	}

	public int getHealth() {
		return health;
	}

	

	/**
	 * Speed limit is between 0 and
	 * speed 0 means no movement?
	 */
	public void setSpeed(double newSpeed) {
		if (newSpeed < 0) {
			this.speed = 0;
		} else {
			this.speed = newSpeed;
		}
	}

	public double getSpeed() {
		return this.speed;
	}
	
	/**
	 * Set up an value of cart can carry the 
	 * resource start up from 0
	 * @param newResource
	 */	
	public void setResource(int newResource) {
		if (newResource> 1) {
			this.resource = newResource;
		} else  {
			this.resource = 0;
		}
	}	
	/**
	 * Return the Cart's resource value
	 *
	 * @return
	 */
	public int getResources() {
		return resource;
	}
	
	
	@Override
	public void tick() {
		if (gameManager != null) {
			if (goalPoints.isEmpty()) {
				goalPoints = newGoalPoints();
			} else if (point.distance(goalPoints.get(0)) < speed) {
				point = goalPoints.remove(0);
				gameManager.getWorld().getTile(point).reset();
				if (goalPoints.isEmpty()) {
					this.goalPoints = newGoalPoints();
				}
			} else {
				point.moveToward(goalPoints.get(0), speed);
			}
			calculateRenderingOrderValues();
		} else {
			// this cart doesn't know who the main manager is
			return;
		}

	}

	private List<Point> newGoalPoints() {
		Random random = new Random();
		Point goalPoint = null;
		while (goalPoint == null || !gameManager.getWorld().getTile(goalPoint).isPassable()) {
			goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
		}

		List<AStar.Tuple> path = AStar.aStar(point, goalPoint, gameManager.getWorld());
		List<Point> goalPoints = new ArrayList<Point>();

		for (AStar.Tuple tuple : path) {
			goalPoints.add(new Point(tuple.getX(), tuple.getY()));
			gameManager.getWorld().getTile(tuple.getX(), tuple.getY()).makePath();
		}
		return goalPoints;
	}

	/**
	 * Give the cart the handle on the manager of the game
	 * @param gameManager
	 */
	public void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}
}
