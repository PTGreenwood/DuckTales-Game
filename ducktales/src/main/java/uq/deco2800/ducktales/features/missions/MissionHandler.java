package uq.deco2800.ducktales.features.missions;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles in-game missions.
 * 
 * @author Naehyung Nate Kim
 */
public class MissionHandler {
	
	private ImageView mission1ImageCompleted;
	private ImageView mission2ImageCompleted;
	private ImageView mission3ImageCompleted;
	private ImageView mission4ImageCompleted;
	private ArrayList<ImageView> missionsArray;
	private int[] countCompletedMissions;	
	
	private Image uncheckedBox = new Image("/missions/boxUnchecked.png");
	private Image checkedBox = new Image("/missions/boxChecked.png");
	
	MissionProgressIndicator piMain = MissionProgressIndicator.getInstance();	
		
	private static MissionHandler INSTANCE = new MissionHandler();
	public static MissionHandler getInstance() {
		return INSTANCE;		
	}
	
	/**
	 * Main constructor of {@link Missions} class.
	 */
	public MissionHandler(){
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
		
		
		for(int i =0; i<4; i++){
			this.missionsArray.get(i).setImage(uncheckedBox);
		}
	}	
	
	/**
	 * Checks checkbox on mission complete.
	 * @param i
	 */
	public void MissionImageCompleted(int i){
		this.missionsArray.get(i).setImage(checkedBox);
		this.countCompletedMissions[i] = 1;
	}
	
	/**
	 * 
	 * @param i
	 * @return Returns {@code missionsArray}
	 */
	public ImageView getMissionImageCompleted(int i){
		return this.missionsArray.get(i);
	}
	
	/**
	 * Check number of missions completed
	 */	
	public void countNumberOfCompletedMissions(){
		double numberOfCompletedMissions = 0.0;
		for(int i =0; i<4; i++){
			if(this.countCompletedMissions[i] == 1){
				numberOfCompletedMissions += 1;
			}						
		}
		piMain.setProgressPercentage(numberOfCompletedMissions/2);		
	}
}
