package uq.deco2800.ducktales.missions;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Missions {
	
	private ImageView mission1ImageCompleted;
	private ImageView mission2ImageCompleted;
	private Image uncheckedBox = new Image("/boxUnchecked.png");
	private Image checkedBox = new Image("/boxChecked.png");
	
	private static Missions INSTANCE = new Missions();
	
	public static Missions getInstance() {
		return INSTANCE;		
	}
	
	public Missions(){
		this.mission1ImageCompleted = new ImageView();
		this.mission2ImageCompleted = new ImageView();
		this.mission1ImageCompleted.setImage(uncheckedBox);
		this.mission2ImageCompleted.setImage(uncheckedBox);
	}	
	
	public void Mission1ImageCompleted(){
		this.mission1ImageCompleted.setImage(checkedBox);
	}	
	public ImageView getMission1ImageCompleted() {
		return mission1ImageCompleted;
	}
	
	public void Mission2ImageCompleted(){
		this.mission2ImageCompleted.setImage(checkedBox);
	}	
	public ImageView getMission2ImageCompleted() {
		return mission2ImageCompleted;
	}
}
