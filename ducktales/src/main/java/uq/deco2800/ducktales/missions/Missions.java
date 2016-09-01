package uq.deco2800.ducktales.missions;

public class Missions {
	
	private String missionComplete = "X";
	
	private static Missions INSTANCE = new Missions();
	
	public static Missions getInstance() {
		return INSTANCE;		
	}
	
	public Missions(){
		this.missionComplete = "X";
	}
	
	public void MissionCompleted(){
		this.missionComplete = "O";
	}
	
	public String getMissionCompleted() {
		return this.missionComplete;
	}
	
}
