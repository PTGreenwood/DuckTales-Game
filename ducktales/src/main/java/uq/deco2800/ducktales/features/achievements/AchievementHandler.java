package uq.deco2800.ducktales.features.achievements;


import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;

/**
 * Contains all achievement methods.
 * 
 * @author Naehyung Kim
 * 
 */
public class AchievementHandler {
	private static final AchievementHandler INSTANCE = new AchievementHandler();
	
	/** Achievement Score */
	private int intAchieve;
	
	LevelHandler levelHandler = LevelHandler.getInstance();
	
	/**
	 * Constructor of {@link Achievement}.
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementHandler getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Achievement} class
	 * 
	 */
	public AchievementHandler() {
		this.intAchieve = 0;		
	}
	
	/**
	 * Return achievement score
	 * 
	 * @return achievement score
	 */
	public int getAchieve() {
		return this.intAchieve;
	}
	
	/**
	 * Set achievement score
	 * 
	 * @param intAchieve
	 */
	public void setAchieve(int intAchieve) {
		this.intAchieve = intAchieve;
	}
	
	
	//Sets value for varying difficulties of achievements, 
	//for each specific difficulty adds specified value to the achievement score
	public void achieveVeasy() {
		this.intAchieve = this.intAchieve + 10;
	}
	
    public void achieveEasy() {
	    this.intAchieve = this.intAchieve + 25;
    }
    
    public void achieveMedium() {
	    this.intAchieve = this.intAchieve + 50;
    }
    
    public void achieveHard() {
	    this.intAchieve = this.intAchieve + 75;
    }
    
    public void achieveVhard() {
	    this.intAchieve = this.intAchieve + 100;
    }
    
    
    /**
     * Contains all achievements.
     * 
     * @author Justin Kuhnel
     * 
     */
   public void achievementHolder() {
	   if(MissionHandler.numberOfCompletedMissions == 1)
	    {
	    this.achieveVeasy();
	    }
	    
	    if(MissionHandler.numberOfCompletedMissions == 3)
	    {
	    this.achieveEasy();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 5)
	    {
	    this.achieveMedium();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 15)
	    {
	    this.achieveHard();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 25)
	    {
	    this.achieveVhard();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 50)
	    {
	    //some award, resource boost or multiplier, possible duck god or god skin
	    }
	    if(levelHandler.getLevel() == 1)
	    {
	    	this.achieveVeasy();
	    }
	    if(levelHandler.getLevel() == 5)
	    {
	    	this.achieveEasy();
	    }
	    if(levelHandler.getLevel() == 10)
	    {
	    	this.achieveMedium();
	    }
	    if(levelHandler.getLevel() == 15)
	    {
	    	this.achieveHard();
	    }
	    if(levelHandler.getLevel() == 25)
	    {
	    	this.achieveVhard();
	    }
	    if(levelHandler.getLevel() == 1)
	    {
	        //resource reward
	    }

   }
   
}
