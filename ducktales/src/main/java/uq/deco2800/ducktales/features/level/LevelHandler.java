package uq.deco2800.ducktales.features.level;

import javafx.scene.control.ProgressBar;

/**
 * Handles player level.
 * 
 *
 */
public class LevelHandler {
	private static LevelHandler instance = new LevelHandler();
	
	private int level;
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
		this.level = 1;
		this.barProgress = 0;
		this.pb = new ProgressBar(0.0);
	}
	
	public void levelUp(){
		this.level = this.level + 1;
		this.barProgress = 0;
		this.pb.setProgress(0);
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
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
