package uq.deco2800.ducktales.features.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.deprecated.OldGameManager;
import uq.deco2800.ducktales.features.jobframework.Job;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.AStar;
import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.features.entities.agententities.PeonDebuffType;
import uq.deco2800.ducktales.features.entities.agententities.PeonBuffType;

/**
 * Class representing the worker.
 * Peon will have 1000 health, 100 hunger and thirst
 * hunger and thirst will decrease (be more hungry/thirsty) over time
 * lower hunger/thirst will affect its strength
 *
 * @author Leggy, Jin Shin
 *
 */
public class Peon extends AgentEntity {

	private static final Random RANDOM = new Random();
	private static final ResourceType TYPE = ResourceType.PEON;
	private List<Point> goalPoints;

	private int time;
	private double speed;
	private int health;
	private int hunger;
	private int thirst;
	private int resource;
	private int strength;
	private int intelligence;

	private List<PeonDebuffType> debuffs = new ArrayList<PeonDebuffType>(); //access debuff by PeonDebuffType.DEBUFFNAME
	private List<PeonBuffType> buffs = new ArrayList<PeonBuffType>(); //access debuff by PeonBuffType.BUFFNAME

	// Job related information

	private String job = "Jobless";
	String jobless  = "Jobless";
	private double qualification = 0;
	private boolean mentorStatus = false;

	/**
	 * how many trees the Peon has chopped (used in Lumberjack.java)
	 */
	private int treesChopped;
        
        /**
         * how many buildings the Peon has created (used in Builder.java)
         */
        private int buildingsMade;
	// affinity bounds
	private static final int DEFAULT_MAX = 10;
	private static final int DEFAULT_MIN = 1;


	/**
	 * @param x
	 * @param y
	 */
	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
		this.time = 0;
		this.health = 1000;
		this.hunger = 100;
		this.thirst = 100;
		this.strength = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		this.intelligence = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		this.speed = 0.05;
		this.resource = 0;
		this.treesChopped = 0;
		this.qualification = 0;
		this.mentorStatus = false;
		this.job = "Jobless";

		this.goalPoints = new ArrayList<Point>();
                this.buildingsMade = 0;
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
	 * Hunger limit is between 100 and 0
	 */
	public void setHunger(int newValue) {
		if (newValue > 100) {
			this.hunger = 100;
		} else if (newValue >= 0) {
			this.hunger = newValue;
		} else if (newValue < 0 ) {
			this.hunger = 0;
		}
	}

	public int getHunger() {
		return hunger;
	}

	/**
	 * Thirst limit is between 100 and 0
	 */
	public void setThirst(int newValue) {
		if (newValue > 100) {
			this.thirst = 100;
		} else if (newValue >= 0) {
			this.thirst = newValue;
		} else if (newValue < 0 ) {
			this.thirst = 0;
		}
	}

	public int getThirst() {
		return thirst;
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
    public String applyForJob(Job job){
            if (job.isQualified(this)){
                    this.setJob(job.toString());
                    return "You're hired!";
            } else if (	this.getStrength()<job.getRequiredStrength()
                    &&		this.getIntelligence()<job.getRequiredIntelligence()){
                    return "Peon is not qualified in both aspects";
            } else if (this.getStrength()<job.getRequiredStrength()){
                    return "Peon strength is not high enough";
            } else {
                    return "Peon intelligence is not high enough";
            }
    }

	/**
	 * Peon quits job if it has one
	 *
	 * @param job
	 */
	public void quitJob() {
		if (this.getJob() != jobless)
			this.setJob(jobless);
	}

	/**
	 * Check if Peon finished the current job
	 *
	 * every time Peon completes a task they will gain attributes that affects
	 * job completion time
	 */
	public void checkJobFinshed() {
		//check if current job finishes

		//increase attribtues
		increaseAttribute();
	}

	/**
	 * Increase attributes that affects the job completion time
	 *	- Strengh and Intelligence will increase according to its Job finished
	 */
	public void increaseAttribute() {
		//need to be implemented
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
        public void setStrength(int strength){
            this.strength=strength;
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
        public void setIntelligence(int intellgience){
            this.intelligence=intelligence;
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
	/**
	 * add a debuff to Peon
	 */
	public void addDebuff(PeonDebuffType _debuff) {
		if (!debuffs.contains(_debuff)) { debuffs.add(_debuff); }
	}

	/**
	 *	remove a debuff from Peon
	 */
	 public void removeDebuff(PeonDebuffType _debuff) {
		 int index = debuffs.indexOf(_debuff);

		 if (index != -1) { debuffs.remove(index); }
	 }

	/**
	 * return all debuffs that Peon has
	 * 	- to access each debuff in the arraylist use ArrayList built-in functions
	 *		such as .get(index) or .contains(var name)
	 *		when .get(index) used to compare to string use .get(index).toString() method
	 */
	public List<PeonDebuffType> getDebuffs() {
		return this.debuffs;
	}

	/**
	 * add a buff to Peon
	 */
	public void addBuff(PeonBuffType _buff) {
		if (!buffs.contains(_buff)) { buffs.add(_buff); }
	}

	/**
	 *	remove a buff from Peon
	 */
	 public void removeBuff(PeonBuffType _buff) {
		 int index = buffs.indexOf(_buff);

		 if (index != -1) { buffs.remove(index); }
	 }

	/**
	 * return all buffs that Peon has
	 * 	- to access each buff in the arraylist use ArrayList built-in functions
	 *		such as .get(index) or .contains(var name)
	 *		when .get(index) used to compare to string use .get(index).toString() method
	 */
	public List<PeonBuffType> getBuffs() {
		return this.buffs;
	}

        
        public int getBuildingsMade() {
            return this.buildingsMade;
        }
	@Override
	public void tick() {
		if (goalPoints.isEmpty()) {
			goalPoints = newGoalPoints();
		} else if (point.distance(goalPoints.get(0)) < speed) {
			point = goalPoints.remove(0);
			OldGameManager.getInstance().getWorld().getTile(point).reset();
			if (goalPoints.isEmpty()) {
				this.goalPoints = newGoalPoints();
			}
		} else {
			point.moveToward(goalPoints.get(0), speed);
		}
		calculateRenderingOrderValues();

		autoDecrease();
	}

	private List<Point> newGoalPoints() {
		Random random = new Random();
		Point goalPoint = null;
		while (goalPoint == null || !OldGameManager.getInstance().getWorld().getTile(goalPoint).isPassable()) {
			goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
		}

		List<AStar.Tuple> path = AStar.aStar(point, goalPoint, OldGameManager.getInstance().getWorld());
		List<Point> goalPoints = new ArrayList<Point>();

		for (AStar.Tuple tuple : path) {
			goalPoints.add(new Point(tuple.getX(), tuple.getY()));
			OldGameManager.getInstance().getWorld().getTile(tuple.getX(), tuple.getY()).makePath();
		}
		return goalPoints;
	}

	/**
	 * function that auto decrease the Peon's hunger and thirst
	 * 	- natural decrease hunger -= 2 and thirst -=3 every 3 hours
	 *	- weather decrease
	 *
	 */
	private void autoDecrease() {
		++time;

		//natural decrease
		if (time == 180) {
			hunger -= 2;
			thirst -= 3;
			time = 0;
		}
	}

	/**
   * function that decrease the Peon's stats according to the weather
	 * different weather will have different effect on peon's stats.
	 */
	private void weatherEffect() {
		//need to be implemented
	}
	/**
	 * function that check the status of Peon to add buff/debuff
	 * 	- hunger/thirst threshold
	 */
	 private void checkPeonStatus() {
		 //need to be implemented
	 }
}
