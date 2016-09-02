package uq.deco2800.ducktales.missions;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Missions {
	
	private ImageView mission1ImageCompleted;
	private ImageView mission2ImageCompleted;
	private ImageView mission3ImageCompleted;
	private ImageView mission4ImageCompleted;
	private Image uncheckedBox = new Image("/boxUnchecked.png");
	private Image checkedBox = new Image("/boxChecked.png");
	
	private static Missions INSTANCE = new Missions();
	
	public static Missions getInstance() {
		return INSTANCE;		
	}
	
	public Missions(){
		this.mission1ImageCompleted = new ImageView();
		this.mission2ImageCompleted = new ImageView();
		this.mission3ImageCompleted = new ImageView();
		this.mission4ImageCompleted = new ImageView();
		this.mission1ImageCompleted.setImage(uncheckedBox);
		this.mission2ImageCompleted.setImage(uncheckedBox);
		this.mission3ImageCompleted.setImage(uncheckedBox);
		this.mission4ImageCompleted.setImage(uncheckedBox);
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
	
	public void Mission3ImageCompleted(){
		this.mission3ImageCompleted.setImage(checkedBox);
	}	
	public ImageView getMission3ImageCompleted() {
		return mission3ImageCompleted;
	}
	
	public void Mission4ImageCompleted(){
		this.mission4ImageCompleted.setImage(checkedBox);
	}	
	public ImageView getMission4ImageCompleted() {
		return mission4ImageCompleted;
	}
}
