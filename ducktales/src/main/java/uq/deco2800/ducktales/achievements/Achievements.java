package uq.deco2800.ducktales.achievements;

import uq.deco2800.ducktales.GameManager;

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
	public void incrementAchieve(){
		this.intAchieve = this.intAchieve + 1;
	}
	
}
