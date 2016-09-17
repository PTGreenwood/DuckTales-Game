package uq.deco2800.ducktales.features.level;

import javafx.scene.control.ProgressBar;

/**
 * Handles player level.
 * 
 *
 */
public class LevelHandler {
	private static LevelHandler instance = new LevelHandler();
	
	public static int level;
	private ProgressBar pb;
	private double barProgress;


	/**
	 * Constructor of {@link Level}.
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static LevelHandler getInstance() {
		return instance;		
	}
	
	public LevelHandler(){
		LevelHandler.level = 1;
		this.barProgress = 0;
		this.pb = new ProgressBar(0.0);
	}
	
	public void levelUp(){
		LevelHandler.level = LevelHandler.level + 1;
		this.barProgress = 0;
		this.pb.setProgress(0);
	}
	
	public void setLevel(int level){
		LevelHandler.level = level;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setProgressBar(double percentage){
		this.pb.setProgress(percentage);
		this.barProgress = this.barProgress + percentage;
	}
	
	public ProgressBar getProgressIndicator(){
		return this.pb;
	}
	
	public double getBarProgress(){
		return this.barProgress;
	}
	
}
