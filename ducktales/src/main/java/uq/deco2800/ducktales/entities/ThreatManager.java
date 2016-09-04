package uq.deco2800.ducktales.entities;
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
	 
	 
	/**
	 * Set threat level 1.
	 */
	public void ThreatsLVL1() {
		 //Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		 //------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Shake");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20,"Timer");
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Dust");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50,"Timer");
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("SCV");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Ducktron");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
	}
	
	/**
	 * Set threat level 2.
	 */
	public void ThreatsLVL2() {
		//Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		//------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Rumble");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20,"Timer");
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Cyanide");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50,"Timer");
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Mutalisk");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Brutalisk");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Evil Duck");
		 	//Add parameters to temp variable
		 	//------- parameters here will move evil 
		 	//duck and reduce health of any 
		 	//peons it collides with
		 	tempEnemy.setStartTimer(20, "Timer");
		 	tempEnemy.setEndTimer(50);
		 	enemiesList.add(tempEnemy);
	}
	 
	/**
	 * Set threat level 3.
	 */
	public void ThreatsLVL3() {
		//Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		//------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Earthqauke");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20,"Timer");
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Poisson Cloud");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50,"Timer");
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Deathclaw");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Cartman");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
	}
	 
	/**
	 * Set threat level 4.
	 */
	public void ThreatsLVL4() {
		//Clear Effects
		 effectsList.clear();
		 enemiesList.clear();
		 
		//------Effects---------
		 	//Create Temp variable
		 	tempEffect = new Effect("Blight");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(20,"Timer");
		 	tempEffect.setEndTimer(50);
		 	
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	//Create Temp variable
		 	tempEffect = new Effect("Fel");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEffect.setStartTimer(50,"Timer");
		 	tempEffect.setEndTimer(100);
		 	//Add temp variable to list
		 	effectsList.add(tempEffect);
		 	
		 	
		 //-------Enemies--------
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Deathwing");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
		 	tempEnemy.setEndTimer(50);
		 	//Add temp variable to list
		 	enemiesList.add(tempEnemy);
		 	
		 	//Create Temp variable
		 	tempEnemy = new Enemy("Lich - King");
		 	//Add parameters to temp variable
		 	//------------
		 	tempEnemy.setStartTimer(20,"Timer");
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
