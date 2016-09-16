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
	
	//level integer
	private int level;
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
