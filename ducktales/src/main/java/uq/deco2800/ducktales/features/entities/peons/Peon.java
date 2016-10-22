package uq.deco2800.ducktales.features.entities.peons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.agententities.AgentEntity;
import uq.deco2800.ducktales.features.jobframework.Job;
import uq.deco2800.ducktales.features.jobframework.JobType;
import uq.deco2800.ducktales.features.peonupgrades.ToolType;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.AStar;
import uq.deco2800.ducktales.util.Point;

/**
 * Class representing the worker. Peon will have 1000 health, 100 hunger and
 * thirst hunger and thirst will decrease (be more hungry/thirsty) over time
 * lower hunger/thirst will affect its strength
 *
 * @author Leggy, Jin Shin, Daniel Leong
 * 
 *
 */
public class Peon extends AgentEntity {
	/** The randomizer */
	private static final Random RANDOM = new Random();

	/** The Main Manager of the game */
	protected GameManager gameManager;

	private static final ResourceType TYPE = ResourceType.PEON;
	private List<Point> goalPoints;

	private int time = 0;
	private double speed = 0.05;
	private int health = 1000;
	private int hunger = 100;
	private int thirst = 100;
	private int resource = 0;
	private int strength;
	private int intelligence;
	private String peonName;
	private ArrayList<ArrayList<ToolType>> allTools;

	private List<PeonDebuffType> debuffs = new ArrayList<PeonDebuffType>(); // access
																			// debuff
																			// by
																			// PeonDebuffType.DEBUFFNAME
	private List<PeonBuffType> buffs = new ArrayList<PeonBuffType>(); // access
																		// debuff
																		// by
																		// PeonBuffType.BUFFNAME

	// Job related information

	private JobType job = JobType.JOBLESS;
	private double qualification = 0;
	private boolean mentorStatus = false;
	
	//Tool related information
	private ToolType tool = ToolType.NOTHING;

	/**
	 * how many trees the Peon has chopped (used in Lumberjack.java)
	 */
	private int treesChopped = 0;

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
	public Peon(int x, int y, String name) {
		super(x, y, 1, 1, TYPE);
		this.peonName = name;
		this.strength = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		this.intelligence = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		this.goalPoints = new ArrayList<>();
		this.buildingsMade = 0;
		this.allTools = new ArrayList<ArrayList<ToolType>>();
		
		constructList();

	}

	public String getPeonName() {
		return peonName;
	}

	public void setPeonName(String peonName) {
		this.peonName = peonName;
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
		} else if (newValue < 0) {
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
		} else if (newValue < 0) {
			this.thirst = 0;
		}
	}

	public int getThirst() {
		return thirst;
	}

	/**
	 * Speed limit is between 0 and speed 0 means no movement?
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
	 * Set up an value of peon can carry the resource start up from 0
	 * 
	 * @param newResource
	 */
	public void setResource(int newResource) {
		if (newResource > 1) {
			this.resource = newResource;
		} else {
			this.resource = 0;
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
	public void setJob(JobType job) {
		this.job = job;
		
		//Set the tool to be level 0
		this.setTool(getJobToolList(job).get(0));
	}

	public JobType getJob() {
		return job;
	}

	/**
	 * May need to rework this? This functionality might be better inside of the
	 * job selection window. Nick
	 * 
	 * Peon applies for job. If peon is qualified, it gets the job. Doesn't get
	 * it otherwise.
	 *
	 * @param job
	 */
	public String applyForJob(Job job) {
		if (job.isQualified(this)) {
			this.setJob(job.getJobName());
			return "You're hired!";
		} else if (this.getStrength() < job.getRequiredStrength()
				&& this.getIntelligence() < job.getRequiredIntelligence()) {
			return "Peon is not qualified in both aspects";
		} else if (this.getStrength() < job.getRequiredStrength()) {
			return "Peon strength is not high enough";
		} else {
			return "Peon intelligence is not high enough";
		}
	}

	/**
	 * Will a peon ever be jobless again after he has been assigned a job? I
	 * feel like this is a case that will never happen. Nick
	 * 
	 * Peon quits job if it has one
	 */
	public void quitJob() {
		if (this.getJob() != JobType.JOBLESS){
			this.setJob(JobType.JOBLESS);
			this.tool = ToolType.NOTHING;
		}
	}

	/**
	 * Check if Peon finished the current job
	 *
	 * every time Peon completes a task they will gain attributes that affects
	 * job completion time
	 */
	public void checkJobFinshed() {
		// check if current job finishes

		// increase attribtues
		increaseAttribute();
	}

	/**
	 * Increase attributes that affects the job completion time - Strengh and
	 * Intelligence will increase according to its Job finished
	 */
	public void increaseAttribute() {
		// need to be implemented
	}

	/**
	 * Stores the level of qualification for a given job
	 *
	 * @param qualification
	 */
	public void setQualification(double qualification) {
		this.qualification = qualification;
	}
	/**
	 * 
	 * @param tool - the current equipped tool
	 * @return - returns the total harvest rate for the peon
	 */
	public double getQualificationToolEquipped() {
		return qualification + tool.getQualificationModifier(); 
	}
	
	/**
	 * 
	 * @param tool - the tool to check
	 * @return - returns the qualification modifier of the given tool.
	 */
	public double getQualificationToolGiven(ToolType tool) {
		return tool.getQualificationModifier();
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

	public void setStrength(int strength) {
		this.strength = strength;
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

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
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
	public void addDebuff(PeonDebuffType debuff) {
		if (!debuffs.contains(debuff)) {
			debuffs.add(debuff);
		}
	}

	/**
	 * remove a debuff from Peon
	 */
	public void removeDebuff(PeonDebuffType debuff) {
		int index = debuffs.indexOf(debuff);

		if (index != -1) {
			debuffs.remove(index);
		}
	}

	/**
	 * return all debuffs that Peon has - to access each debuff in the arraylist
	 * use ArrayList built-in functions such as .get(index) or .contains(var
	 * name) when .get(index) used to compare to string use
	 * .get(index).toString() method
	 */
	public List<PeonDebuffType> getDebuffs() {
		return this.debuffs;
	}

	/**
	 * add a buff to Peon
	 */
	public void addBuff(PeonBuffType buff) {
		if (!buffs.contains(buff)) {
			buffs.add(buff);
		}
	}

	/**
	 * remove a buff from Peon
	 */
	public void removeBuff(PeonBuffType buff) {
		int index = buffs.indexOf(buff);

		if (index != -1) {
			buffs.remove(index);
		}
	}

	/**
	 * return all buffs that Peon has - to access each buff in the arraylist use
	 * ArrayList built-in functions such as .get(index) or .contains(var name)
	 * when .get(index) used to compare to string use .get(index).toString()
	 * method
	 */
	public List<PeonBuffType> getBuffs() {
		return this.buffs;
	}

	/**
	 * Increases amount of buildings made
	 */
	public void madeABuilding() {
		this.buildingsMade++;
	}

	/**
	 * 
	 * @return amount of buildings made
	 */
	public int getBuildingsMade() {
		return this.buildingsMade;
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

			autoDecrease();
		} else {
			// this peon doesn't know who the main manager is
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
	 * Give the peon the handle on the manager of the game
	 * 
	 * @param gameManager
	 */
	public void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	/**
	 * function that auto decrease the Peon's hunger and thirst - natural
	 * decrease hunger -= 2 and thirst -=3 every 3 hours - weather decrease
	 *
	 */
	private void autoDecrease() {
		++time;

		// natural decrease
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
		// need to be implemented
	}

	/**
	 * function that check the status of Peon to add buff/debuff - hunger/thirst
	 * threshold
	 */
	private void checkPeonStatus() {
		// need to be implemented
	}
	
	/**
	 * this sets the tool to the peon, tool is the tool that will get set
	 * it also checks if the peon's job is suitable for the tool
	 */

	public void setTool(ToolType tool){
		if(this.getJob() == tool.getJob()) {
			this.tool = tool;
		}

	}
	
	/**
	 * Get the tool the peon has currently equipped
	 * 
	 * @return ToolType tool
	 */
	public ToolType getTool() {
		return this.tool;
	}
	
	/**
	 * Upgrade Tool the peon currently has by 1.
	 * 
	 */
	public void upgradeTool() {
		if((this.getTool().getToolLevel() < 2) && (this.getTool() != null)) {
			try {
				if(this.getJobToolList(this.job).get(this.getTool().getToolLevel() + 1) != null) {
					this.tool = (this.getJobToolList(this.getJob()).get(this.getTool().getToolLevel() + 1));
				} else {
					//Hold up. There is no next tool for this job.
					//do nothing.
					System.out.println("Get a job you jobless bum");
				}
			
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Can't upgrade this tool. Nothing to upgrade to");
			}
		}
		//Otherwise don't update cause there is no way to.
	}
	
	/**
     * Constructs an ArrayList<ArrayList<ToolType>> To be pulled to get information when needed
     * Not sure of any other way to access all the enums values... as .values() didn't work :S
     * TODO: Make less obtrusive. Use Iterator.
     */
    public void constructList() {
    	ArrayList<ToolType> lumberJackTools = new ArrayList<ToolType>(Arrays.asList(ToolType.AXElevel1, ToolType.AXElevel2, ToolType.AXElevel3));
    	ArrayList<ToolType> minerTools = new ArrayList<ToolType>(Arrays.asList(ToolType.PICKlevel1, ToolType.PICKlevel2, ToolType.PICKlevel3));
    	ArrayList<ToolType> builderTools = new ArrayList<ToolType>(Arrays.asList(ToolType.HAMMERlevel1, ToolType.HAMMERlevel2, ToolType.HAMMERlevel3));
    	ArrayList<ToolType> doctorTools = new ArrayList<ToolType>(Arrays.asList(ToolType.INSTRUMENTSlevel1, ToolType.INSTRUMENTSlevel2, ToolType.INSTRUMENTSlevel3));
    	ArrayList<ToolType> farmerTools = new ArrayList<ToolType>(Arrays.asList(ToolType.HOElevel1, ToolType.HOElevel2, ToolType.HOElevel3));
    	ArrayList<ToolType> teacherTools = new ArrayList<ToolType>(Arrays.asList(ToolType.CLOTHESlevel1, ToolType.CLOTHESlevel2, ToolType.CLOTHESlevel3));
    	ArrayList<ToolType> joblessTools = new ArrayList<ToolType>(Arrays.asList(ToolType.NOTHING));
    	ArrayList<ToolType> blacksmithTools = new ArrayList<ToolType>(Arrays.asList(ToolType.TONGSlevel1, ToolType.TONGSlevel2, ToolType.TONGSlevel3));
    	ArrayList<ToolType> bakerTools = new ArrayList<ToolType>(Arrays.asList(ToolType.ROLLINGPINlevel1, ToolType.ROLLINGPINlevel2, ToolType.ROLLINGPINlevel3));
    	ArrayList<ToolType> masonTools = new ArrayList<ToolType>(Arrays.asList(ToolType.CHISELlevel1, ToolType.CHISELlevel2, ToolType.CHISELlevel3));

    	this.allTools.addAll(Arrays.asList(lumberJackTools, minerTools, builderTools, doctorTools, farmerTools, teacherTools, blacksmithTools, bakerTools, masonTools, joblessTools ));
    }
    
    /**
     * Returns the list containing all the ENUM Values
     * @return ArrayList<ArrayList<ToolType>>
     * 
     * Chosen to go this route rather than .values() to do soemthing things with it.
     */
	public ArrayList<ArrayList<ToolType>> getAllToolsList() {
		System.out.println("TOOLTYPE: " + this.allTools);
		return this.allTools;
	}
	
	/**
	 * Returns the List containing only the tools for the job.
	 * This is only being used to get the tool list.
	 * 
	 * @param job - the currentJob
	 * @return the arrayList. 
	 */
	public ArrayList<ToolType> getJobToolList(JobType job) {
		if(job == JobType.LUMBERJACK) {
			return this.allTools.get(0);
			
		} else if(job == JobType.MINER) {
			return this.allTools.get(1);
			
		} else if(job == JobType.BUILDER) {
			return this.allTools.get(2);
			
		} else if(job == JobType.DOCTOR) {
			return this.allTools.get(3);
			
		} else if(job == JobType.FARMER) {
			return this.allTools.get(4);
			
		} else if(job == JobType.TEACHER) {
			return this.allTools.get(5);
		
		} else if(job == JobType.BLACKSMITH) {
			return this.allTools.get(6);
			
		} else if(job == JobType.BAKER) {
			return this.allTools.get(7);
			
		} else if(job == JobType.MASON) {
			return this.allTools.get(8);
			
		} else if(job == JobType.JOBLESS) {
			return this.allTools.get(9);
		}
		return null;
	}
	
	/**
	 * Returns a string of resources needed to upgrade the tool
	 * 
	 * @return String resources
	 */
	public String getResourceNeededForUpgrade(ArrayList<ToolType> tool, int currentLevel) {
		System.out.println("TOOL TYPE SENT: " + tool + ",,,, CURRENT LEVEL SENT: " + currentLevel);
		if((tool.size() == 1) || (currentLevel >=3) || (currentLevel < 0)) {
			return "N/A";
		} else {
			int timberNeed = tool.get(currentLevel).getTimberCost();
			int stoneNeed = tool.get(currentLevel).getStoneCost();
			int metalNeed = tool.get(currentLevel).getMetalCost();;
			int foodNeed = tool.get(currentLevel).getFoodCost();;
		
			String returnStatement = "" + timberNeed + "/" + stoneNeed + "/" + metalNeed + "/" + foodNeed;
			return returnStatement;
		}
	}



	
}