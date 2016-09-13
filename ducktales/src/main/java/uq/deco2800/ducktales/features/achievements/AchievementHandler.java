package uq.deco2800.ducktales.features.achievements;

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
	public int getAchieve(){
		return this.intAchieve;
	}
	public void setAchieve(int intAchieve){
		this.intAchieve = intAchieve;
	}
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
	
}
