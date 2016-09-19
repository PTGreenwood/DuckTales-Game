package uq.deco2800.ducktales.features.missions;

import javafx.scene.control.ProgressIndicator;

/**
 * Handles mission progress indicator.
 * 
 * @author Naehyung Kim
 *
 */
public class MissionProgressIndicator {
	
	//progress indicator
	private ProgressIndicator pi;	
	
	private static MissionProgressIndicator instance = new MissionProgressIndicator();
	
	/**
	 * Constructor of {@link Missions}
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static MissionProgressIndicator getInstance() {
		return instance;		
	}
	
	/**
	 * Main constructor of {@link Missions} class
	 * 
	 */
	public MissionProgressIndicator() {
		this.pi = new ProgressIndicator();	
		this.pi.setProgress(0.0);
		this.pi.setPrefSize(100.0, 100.0);
	}
	
	/**
	 * Set progress percentage
	 * 
	 * @param percentage
	 */
	public void setProgressPercentage(double percentage) {
		this.pi.setProgress(percentage);
	}
	
	/**
	 * get progress indicator
	 * 
	 * @return progress indicator
	 */
	public ProgressIndicator getProgressIndicator() {
		return this.pi;
	}
}
