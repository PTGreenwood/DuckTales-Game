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
	private ImageView mission5ImageCompleted;
	private ImageView mission6ImageCompleted;
	private ImageView mission7ImageCompleted;
	private ImageView mission8ImageCompleted;
	
	private ArrayList<ImageView> missionsArray;
	
	private int[] countCompletedMissions;	

	public static double numberOfCompletedMissions = 0.0;

	/** Load checked and unchecked box */
	private Image uncheckedBox = new Image("/missions/boxUnchecked.png");
	private Image checkedBox = new Image("/missions/boxChecked.png");
	
	/** Initialize classes */	
	LevelHandler levelMain = LevelHandler.getInstance();
	
	MissionProgressController piController = MissionProgressController.getInstance();
	private MissionProgressController missionProgressController = MissionProgressController.getInstance();
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
		
		this.countCompletedMissions = new int[8];
		Arrays.fill(this.countCompletedMissions, 0);
		this.missionsArray = new ArrayList<ImageView>();
		this.mission1ImageCompleted = new ImageView();
		this.mission2ImageCompleted = new ImageView();
		this.mission3ImageCompleted = new ImageView();
		this.mission4ImageCompleted = new ImageView();
		this.mission5ImageCompleted = new ImageView();
		this.mission6ImageCompleted = new ImageView();
		this.mission7ImageCompleted = new ImageView();
		this.mission8ImageCompleted = new ImageView();
		
		this.missionsArray.add(0, this.mission1ImageCompleted);
		this.missionsArray.add(1, this.mission2ImageCompleted);
		this.missionsArray.add(2, this.mission3ImageCompleted);
		this.missionsArray.add(3, this.mission4ImageCompleted);
		this.missionsArray.add(4, this.mission5ImageCompleted);
		this.missionsArray.add(5, this.mission6ImageCompleted);
		this.missionsArray.add(6, this.mission7ImageCompleted);
		this.missionsArray.add(7, this.mission8ImageCompleted);
		
		for(int i = 0; i < 8; i++) {
			this.missionsArray.get(i).setImage(uncheckedBox);
		}
	}	
	
	/**
	 * Checks checkbox on mission complete.
	 * 
	 * @param i
	 */
	public void missionImageCompleted(int i) {
		this.missionsArray.get(i).setImage(checkedBox);
		this.countCompletedMissions[i] = 1;
	}
	
	/**
	 * Get countCompletedMissions
	 * 
	 * @return countCompletedMissions
	 */
	public int[] getCountCompletedMissions() {
		return this.countCompletedMissions;
	}
	
	/**
	 * Get mission image
	 * 
	 * @param i
	 * @return Returns mission Image
	 */
	public Image getmissionImageCompleted(int i) {
		return this.missionsArray.get(i).getImage();
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
		this.numberOfCompletedMissions = numberOfCompletedMissions;
	}
	
	/**
	 * get number of completed missions
	 * 
	 * @return numberOfcompletedMissions
	 */
	public double getNumberOfCompletedMissions() {
		
		return this.numberOfCompletedMissions;
	}
}
