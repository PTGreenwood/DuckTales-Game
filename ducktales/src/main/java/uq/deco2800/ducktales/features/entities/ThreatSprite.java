package uq.deco2800.ducktales.features.entities;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is used to construct the sprite for a threat.
 * @author zainabalnaboud
 *
 */
public class ThreatSprite extends ImageView {
	
	//Declare variables
	
	// ArrayList for the effects
	private ArrayList<Effect> effectsList;
	// ArrayList for the enemies
	private ArrayList<Enemy> enemiesList;
	// new list for all threat
	private ArrayList<Threat> threat;
	// a HashMap for threat and its image
	private HashMap<Threat, Image> threatImageHashMap;
	
	private int threatIndex;
	
	private Image threatSprite;
	
	private double xCord;
	private double yCord;
	private double threatSpriteWidth;
	private double threatSpriteHeight;
	private int startFrame; // the frame to start with regard to its direction
	private int currentFrame;
	private int tweenFrames; // the period between the current frame & the next one
	
	//constructor
	public ThreatSprite(int threatIndex){
		
		// set name/index
		this.threatIndex = threatIndex;
		
		//int threatType = ThreatManager.effectsList.indexOf("Black Smoke");
		//Effect nameOfThreat = ThreatManager.effectsList.get(threatType);
		
		// load the image
		//this.setImage(threatSprite);
	}
	
	/**
	 * Returns all the effect on the effect list on the ThreatManager
	 * @return effectsList
	 */
	public ArrayList<Effect> getEffectList(){
		effectsList = ThreatManager.returnEffects();
		return effectsList;
	}
	
	/**
	 * Returns all the effect on the enemies list on the ThreatManager
	 * @return enemiesList
	 */
	public ArrayList<Enemy> getEnemyList(){
		enemiesList = ThreatManager.returnEnemies();
		return enemiesList;
	}
	
	//more method
	//get sprite height & width
	//set all frames
	//set start frame
	//get the start frame
	//update


}
