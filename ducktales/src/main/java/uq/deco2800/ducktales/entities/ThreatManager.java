package uq.deco2800.ducktales.entities;
import java.util.*;

/** Creates enemies and effects and manages when they are deployed
 * 
 * 
 * @author Wian
 *
 */


public class ThreatManager {
 private ArrayList<Effect> EffectsList = new ArrayList<Effect>();
 private ArrayList<Enemy> EnemiesList = new ArrayList<Enemy>();
 
 //Temp variables
 private Effect tempEffect;
 private Enemy tempEnemy;
 
 
 
 public void ThreatsLVL1(){
	 //Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
	 
	 //------Effects---------
	 	//Create Temp variable
	 	tempEffect = new Effect("Earthqauke");
	 	//Add parameters to temp variable
	 	//------------
	 	tempEffect.setEndTimer(50);
	 	//Add temp variable to list
	 	EffectsList.add(tempEffect);
	 	
	 	//Create Temp variable
	 	tempEffect = new Effect("Poisson Cloud");
	 	//Add parameters to temp variable
	 	//------------
	 	tempEffect.setEndTimer(100);
	 	//Add temp variable to list
	 	EffectsList.add(tempEffect);
	 	
	 	
	 //-------Enemies--------
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Deathclaw");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	EnemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Cartman");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	EnemiesList.add(tempEnemy);
	 	
	 	
	 
	 
	 
	 
 }
 
 
 
 
 public void ThreatsLVL2(){
	//Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
 }
 
 
 public void ThreatsLVL3(){
	//Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
	 
 }
 
 
 public void ThreatsLVL4(){
	//Clear Effects
	 EffectsList.clear();
	 EnemiesList.clear();
	 
 }
 
 
 
 /**Returns
  * 
  * @return The current list of enemies created
  * 
  * 
  */
 public ArrayList<Enemy> returnEnemies(){ 
	 return this.EnemiesList;
 }
 
 
 
 
 /**
  * 
  * 
  * @return The current list of Effects created.
  * 
  * 
  */
 public ArrayList<Effect> returnEffects(){
	 return this.EffectsList;
 }
 
 
 
 
}
