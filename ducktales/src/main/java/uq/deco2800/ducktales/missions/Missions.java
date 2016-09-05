package uq.deco2800.ducktales.missions;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Handles in-game missions.
 * 
 *
 */
public class Missions {
	
	private ImageView mission1ImageCompleted;
	private ImageView mission2ImageCompleted;
	private ImageView mission3ImageCompleted;
	private ImageView mission4ImageCompleted;
	private ArrayList<ImageView> missionsArray;
	private Image uncheckedBox = new Image("/boxUnchecked.png");
	private Image checkedBox = new Image("/boxChecked.png");
	
	private double missionCount = 0;
	
	private static Missions INSTANCE = new Missions();
	
	public static Missions getInstance() {
		return INSTANCE;		
	}
	
	/**
	 * Main constructor of {@link Missions} class.
	 */
	public Missions(){
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
		this.missionCount = this.missionCount + 0.5;
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
	 * 
	 * @return Returns {@code missionCount}
	 */
	public double getMissionCount(){
		return this.missionCount;
	}
}
