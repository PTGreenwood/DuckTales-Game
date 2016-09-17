package uq.deco2800.ducktales.features.missions;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.level.LevelHandler;

/**
 * Handles in-game missions.
 * 
 * @author Naehyung Kim
 */
public class MissionHandler {
	
	/** ImageViews that will be used in MissionManager to display tick box */
	private ImageView mission1ImageCompleted;
	private ImageView mission2ImageCompleted;
	private ImageView mission3ImageCompleted;
	private ImageView mission4ImageCompleted;
	
	private ArrayList<ImageView> missionsArray;
	
	private int[] countCompletedMissions;	

	public static double numberOfCompletedMissions = 0.0;

	/** Load checked and unchecked box */
	private Image uncheckedBox = new Image("/missions/boxUnchecked.png");
	private Image checkedBox = new Image("/missions/boxChecked.png");
	
	/** Initialize classes */	
	MissionProgressIndicator piMain = MissionProgressIndicator.getInstance();	
	LevelHandler levelMain = LevelHandler.getInstance();
	
	private static MissionHandler instance = new MissionHandler();
	
	/**
	 * Constructor of {@link Missions}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static MissionHandler getInstance() {
		return instance;		
	}
	
	/**
	 * Main constructor of {@link Missions} class
	 * 
	 */
	public MissionHandler() {
		this.countCompletedMissions = new int[4];
		Arrays.fill(this.countCompletedMissions, 0);
		this.missionsArray = new ArrayList<ImageView>();
		this.mission1ImageCompleted = new ImageView();
		this.mission2ImageCompleted = new ImageView();
		this.mission3ImageCompleted = new ImageView();
		this.mission4ImageCompleted = new ImageView();
		
		this.missionsArray.add(0, this.mission1ImageCompleted);
		this.missionsArray.add(1, this.mission2ImageCompleted);
		this.missionsArray.add(2, this.mission3ImageCompleted);
		this.missionsArray.add(3, this.mission4ImageCompleted);
		
		
		for(int i = 0; i < 4; i++) {
			this.missionsArray.get(i).setImage(uncheckedBox);
		}
	}	
	
	/**
	 * Checks checkbox on mission complete.
	 * 
	 * @param i
	 */
	public void MissionImageCompleted(int i) {
		this.missionsArray.get(i).setImage(checkedBox);
		this.countCompletedMissions[i] = 1;
	}
	
	/**
	 * Get mission image
	 * 
	 * @param i
	 * @return Returns mission Image
	 */
	public ImageView getMissionImageCompleted(int i) {
		return this.missionsArray.get(i);
	}
	
	/**
	 * Check number of missions completed
	 * 
	 */	
	public void countNumberOfCompletedMissions() {

		double numberOfCompletedMissions = 0.0;
		for(int i =0; i<4; i++){
			if(this.countCompletedMissions[i] == 1) {
				numberOfCompletedMissions += 1;
			}						
		}
		MissionHandler.numberOfCompletedMissions = numberOfCompletedMissions;
		piMain.setProgressPercentage(numberOfCompletedMissions/3);		
		levelMain.setProgressBar(numberOfCompletedMissions/2);
	}
	
	/**
	 * get number of completed missions
	 * 
	 * @return numberOfcompletedMissions
	 */
	public double getNumberOfCompletedMissions() {
		
		return MissionHandler.numberOfCompletedMissions;
	}
}
