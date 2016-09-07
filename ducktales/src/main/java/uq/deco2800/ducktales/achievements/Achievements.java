package uq.deco2800.ducktales.achievements;

/**
 * Contains all achievement methods.
 * 
 * 
 */
public class Achievements {
	private static Achievements INSTANCE = new Achievements();
	
	private int intAchieve;
	
	public static Achievements getInstance() {
		return INSTANCE;
	}
	
	public Achievements(){
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
