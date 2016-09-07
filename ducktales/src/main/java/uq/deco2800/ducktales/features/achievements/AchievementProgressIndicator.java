package uq.deco2800.ducktales.features.achievements;

import javafx.scene.control.ProgressIndicator;

/**
 * Handles player progress indicator.
 *
 *
 */
public class AchievementProgressIndicator {
	private ProgressIndicator pi;	
	
	private static AchievementProgressIndicator INSTANCE = new AchievementProgressIndicator();
	
	public static AchievementProgressIndicator getInstance() {
		return INSTANCE;		
	}
	
	public AchievementProgressIndicator(){
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
