package uq.deco2800.ducktales.features.entities;
import java.util.*;


/** Creates enemies and effects and manages when they are deployed
 * 
 * 
 * @author Wian
 *
 */
public class ThreatManager {
	private ArrayList<Effect> effectsList = new ArrayList<Effect>();
	private ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();
	 
	 
	//Temp variables
	private Effect tempEffect;
	private Enemy tempEnemy;
	String timer = "Timer";
	 
	 
	/**
	 * Set threat level 1.
	 */
	public void threatsLvl1() {
		 //Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		 //------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Shake");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20, timer);
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Dust");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50, timer);
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Raccoon");
		 	// affects people and animals
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Beetle");
		 	// affects resources
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Wild Villager");
		 	// affects buildings
		 	//Add parameters to temp variable
		 	//------------		 	
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
	}
	
	/**
	 * Set threat level 2.
	 */
	public void threatsLvl2() {
		//Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		//------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Rumble");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20, timer);
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Cyanide");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50, timer);
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Wolf");
		 	// affects people and animals
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Crow");
		 	// affects resources
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Gorilla");
		 	// affects buildings
		 	//Add parameters to temp variable
		 	//------------		 	
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
	}
	 
	/**
	 * Set threat level 3.
	 */
	public void threatsLvl3() {
		//Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		//------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Earthqauke");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20, timer);
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Poisson Cloud");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50, timer);
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Lion");
		 	// affects people and animals
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Chimp");
		 	// affects resources
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Bear");
		 	// affects buildings
		 	//Add parameters to temp variable
		 	//------------		 	
		 	tempEnemy.setStartTimer(20,  timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
	}
	 
	/**
	 * Set threat level 4.
	 */
	public void threatsLvl4() {
		//Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		//------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Blight");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20, timer);
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Fel");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50, timer);
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Zombie Duck");
		 	// affects people and animals
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Robber");
		 	// affects resources
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Elephant");
		 	// affects buildings
		 	//Add parameters to temp variable
		 	//------------		 	
		 	tempEnemy.setStartTimer(20, timer);
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
	}
	 
	 /**
	  * 
	  * @return The current list of enemies created
	  */
	public ArrayList<Enemy> returnEnemies() { 
		 return this.enemiesList;
	}
	
	 /**
	  * 
	  * @return The current list of Effects created.
	  */
	public ArrayList<Effect> returnEffects() {
		 return this.effectsList;
	}
	
}
