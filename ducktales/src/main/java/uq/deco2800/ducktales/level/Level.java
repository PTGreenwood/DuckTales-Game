package uq.deco2800.ducktales.level;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

/**
 * Handles player level.
 * 
 *
 */
public class Level {
	private static Level INSTANCE = new Level();
	
	private int level;
	private ProgressBar pb;
	private double barProgress;


	/**
	 * Constructor of {@link Level}.
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static Level getInstance() {
		return INSTANCE;		
	}
	
	public Level(){
		this.level = 1;
		this.barProgress = 0;
		this.pb = new ProgressBar(0.0);
	}
	
	public void LevelUp(){
		this.level = this.level + 1;
		this.barProgress = 0;
		this.pb.setProgress(0);
	}
	//later in levelController if isBarFull == true then levelup;
	
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
