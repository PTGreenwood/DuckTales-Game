package uq.deco2800.ducktales.features.achievements;

<<<<<<< HEAD
import uq.deco2800.ducktales.features.inventory.InventoryManager;
import uq.deco2800.ducktales.features.level.LevelHandler;
=======
>>>>>>> 38e4453008e53a1fd7d2eb4c5b211da1b49849d5
import uq.deco2800.ducktales.features.missions.MissionHandler;

/**
 * Contains all achievement methods.
 * 
 * @author Naehyung Kim
 * 
 */
public class AchievementHandler {
	private static AchievementHandler INSTANCE = new AchievementHandler();
	
	/** Achievement Score */
	private int intAchieve;
	
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
	    if(LevelHandler.level == 1)
	    {
	    	this.achieveVeasy();
	    }
	    
    //	if(InventoryManager.getWoodAmount() >= 100){
	//		this.achieveVeasy();
    //	}
    //	if(InventoryManager.woodAmount == 1337){
	//		this.achieveEasy();
	//	}
	//	if(InventoryManager.woodAmount>=10000){
	//		this.achieveMedium();
	//	}
	//	if(InventoryManager.woodAmount>=25000){
	//		this.achieveHard();
	//	}
	//	if(InventoryManager.woodAmount>=50000){
	//		this.achieveVhard();
	//	}	
   }
   
}
