package uq.deco2800.ducktales.features.achievements;

import uq.deco2800.ducktales.features.inventory.InventoryManager;
import uq.deco2800.ducktales.features.missions.MissionHandler;

/**
 * Contains all achievement methods.
 * 
 * 
 */
public class AchievementHandler {
	private static AchievementHandler INSTANCE = new AchievementHandler();
	
	private int intAchieve;
	
	public static AchievementHandler getInstance() {
		return INSTANCE;
	}
	
	public AchievementHandler(){
		this.intAchieve = 0;		
	}
	//Returns achievement score
	public int getAchieve(){
		return this.intAchieve;
	}
	public void setAchieve(int intAchieve){
		this.intAchieve = intAchieve;
	}
	//Sets value for varying difficulties of achievements, 
	//for each specific difficulty adds specified value to the achievement score
	public void achieveVeasy(){
		this.intAchieve = this.intAchieve + 10;
	}
	
    public void achieveEasy(){
	    this.intAchieve = this.intAchieve + 25;
    }
    
    public void achieveMedium(){
	    this.intAchieve = this.intAchieve + 50;
    }
    
    public void achieveHard(){
	    this.intAchieve = this.intAchieve + 75;
    }
    
    public void achieveVhard(){
	    this.intAchieve = this.intAchieve + 100;
    }
    
   public void achievementHolder(){
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
