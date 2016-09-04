package uq.deco2800.ducktales.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.jobframework.Job;
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

	private static final ResourceType TYPE = ResourceType.PEON;

	private List<Point> goalPoints;

	private double speed;

	private int health = 1000;

	private int resource = 0;

	// Job related information
	private String job = "Jobless";
	private double qualification = 0;
	private boolean mentorStatus = false;

	/**
	 * how many trees the Peon has chopped (used in Lumberjack.java)
	 */
	private int treesChopped;

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
		this.treesChopped = 0;
	}

	public void setHealth(int newValue) {
		if (newValue > 0) {
			this.health = newValue;
		}
	}

	public int getHealth() {
		return health;
	}

	/**
	 * Keep update how many resource does peon have
	 * 
	 * @param sourceValue
	 */
	public void setResources(int sourceValue) {
		if (sourceValue > 0) {
			this.resource = sourceValue;
		}
	}

	/**
	 * Return the Peon's resource value
	 * 
	 * @return
	 */
	public int getResources() {
		return resource;
	}

	/**
	 * Stores what job the peon has
	 * 
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	/**
	 * Peon applies for job. If peon is qualified, it gets the job. Doesn't get
	 * it otherwise.
	 * 
	 * @param job
	 */
	public void applyForJob(Job job) {
		if (job.isQualified(this))
			this.setJob(job.toString());
	}

	/**
	 * Peon quits job if it has one
	 * 
	 * @param job
	 */
	public void quitJob(Job job) {
		if (this.getJob() != "Jobless")
			this.setJob("Jobless");
	}

	/**
	 * Stores the level of qualification
	 * 
	 * @param qualification
	 */
	public void setQualification(double qualification) {
		this.qualification = qualification;
	}

	public double getQualification() {
		return qualification;
	}

	/**
	 * Stores if peon is qualified to be a mentor
	 * 
	 * @param mentorStatus
	 */
	public void setMentorStatus(boolean mentorStatus) {
		this.mentorStatus = mentorStatus;
	}

	public boolean getMentorStatus() {
		return mentorStatus;
	}

	/**
	 * Increase the peon's strength through experience
	 * 
	 * @param strength
	 */
	public void StrengthExp(int strength) {
		this.strength += strength;
	}

	public int getStrength() {
		return strength;
	}

	/**
	 * Increase the peon's intelligence through experience
	 * 
	 * @param intell
	 */
	public void IntelligenceExp(int intell) {
		this.intelligence += intell;
	}

	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * Add one to treesChopped
	 */
	public void choppedATree() {
		this.treesChopped++;
	}

	/**
	 * How many trees the peon has chopped
	 * 
	 * @return current amount of trees chopped by this peon
	 */
	public int getTreesChopped() {
		return this.treesChopped;
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
