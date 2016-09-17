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
	

	//public static int level;

	//level integer
	public static int level;
	//progress bar

	private ProgressBar pb;

	/**
	 * Constructor of {@link Level}.
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static LevelHandler getInstance() {
		return instance;		
	}
	

	public LevelHandler() {
		LevelHandler.level = 1;
		this.pb = new ProgressBar(0.0);
	}
	
	/**
	 * Level up 
	 */
	public void levelUp() {
		LevelHandler.level = LevelHandler.level + 1;
		this.pb.setProgress(0);
	}
	
	/**
	 * Set level
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		LevelHandler.level = level;

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
