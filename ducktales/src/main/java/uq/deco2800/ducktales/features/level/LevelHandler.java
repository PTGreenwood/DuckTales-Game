package uq.deco2800.ducktales.features.level;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ProgressBar;

/**
 * Handles player level.
 * 
 * @author Naehyung Kim
 *
 */
public class LevelHandler {
	
	private static LevelHandler instance = new LevelHandler();
		
	private SimpleIntegerProperty level = new SimpleIntegerProperty(this, "level");

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
		level.set(1);;
		this.pb = new ProgressBar(0.0);
	}
	
	/**
	 * Level up 
	 */
	public void levelUp() {
		this.level.set(level.get()+1);;
		this.pb.setProgress(0);
	}
	
	/**
	 * Set level
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level.set(level);;

	}
	
	/**
	 * Get level
	 * 
	 * @return level.get()
	 */
	public int getLevel() {
		return level.get();
	}
	
	/**
	 * Return IntergerProperty
	 * 
	 * @return level
	 */
	public IntegerProperty valueProperty() {
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
	public ProgressBar getProgressBar() {
		return this.pb;
	}
	
	public void addProgressBar(double percentage) {
		this.pb.setProgress(this.pb.getProgress() + percentage);
	}
	
}
