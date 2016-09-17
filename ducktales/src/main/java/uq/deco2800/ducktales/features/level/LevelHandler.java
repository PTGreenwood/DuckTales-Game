package uq.deco2800.ducktales.features.level;

import javafx.scene.control.ProgressBar;

/**
 * Handles player level.
 * 
 * @author Naehyung Kim
 *
 */
public class LevelHandler {
	
	private static LevelHandler instance = new LevelHandler();
	
<<<<<<< HEAD
	public static int level;
=======
	//level integer
	private int level;
	//progress bar
>>>>>>> 38e4453008e53a1fd7d2eb4c5b211da1b49849d5
	private ProgressBar pb;

	/**
	 * Constructor of {@link Level}.
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static LevelHandler getInstance() {
		return instance;		
	}
	
<<<<<<< HEAD
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
=======
	public LevelHandler() {
		this.level = 1;
		this.pb = new ProgressBar(0.0);
	}
	
	/**
	 * Level up 
	 */
	public void levelUp() {
		this.level = this.level + 1;
		this.pb.setProgress(0);
	}
	
	/**
	 * Set level
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
>>>>>>> 38e4453008e53a1fd7d2eb4c5b211da1b49849d5
	}
	
	/**
	 * Get level
	 * 
	 * @return level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Set progress bar
	 * 
	 * @param percentage
	 */
	public void setProgressBar(double percentage) {
		this.pb.setProgress(percentage);
	}
	
	/**
	 * Return progress bar
	 * 
	 * @return progress bar
	 */
	public ProgressBar getProgressIndicator() {
		return this.pb;
	}
	
}
