package uq.deco2800.ducktales.features.missions;

import javafx.scene.control.ProgressIndicator;

public class MissionProgressIndicator {
	private ProgressIndicator pi;	
	
	private static MissionProgressIndicator instance = new MissionProgressIndicator();
	
	public static MissionProgressIndicator getInstance() {
		return instance;		
	}
	
	public MissionProgressIndicator(){
		this.pi = new ProgressIndicator();	
		this.pi.setProgress(0.0);
		this.pi.setPrefSize(100.0, 100.0);
	}
	
	public void setProgressPercentage(double percentage){
		this.pi.setProgress(percentage);
	}
	
	public ProgressIndicator getProgressIndicator(){
		return this.pi;
	}
}
