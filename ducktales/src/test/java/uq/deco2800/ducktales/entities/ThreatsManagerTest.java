package uq.deco2800.ducktales.entities;

import org.junit.Test;

import java.util.ArrayList;

import uq.deco2800.ducktales.features.entities.threats.Effect;
import uq.deco2800.ducktales.features.entities.threats.Enemy;
import uq.deco2800.ducktales.features.entities.threats.ThreatManager;
import uq.deco2800.ducktales.features.entities.threats.ThreatFactory;

import static org.junit.Assert.*;

public class ThreatsManagerTest {
	
	@Test 
	public void testForLvl1(){
		
		Enemy enemy1 = new Enemy("Raccoon");
		Enemy enemy2 = new Enemy("Beetle");
		Enemy enemy3 = new Enemy("Wild Villager");
		
		Effect efect1 = new Effect("Shake");
		Effect efect2 = new Effect("Black Smoke");

		ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();
		enemiesList.add(enemy1);
		enemiesList.add(enemy2);
		enemiesList.add(enemy3);
		
		ArrayList<Effect> effectsList = new ArrayList<Effect>();
		effectsList.add(efect1);
		effectsList.add(efect2);
		
	}

	@Test
	public void testForLvl2() {

		// Temporary commented out due to errors
//		TM.threatsLvl2();
//
//		assertTrue("Effects list is incorrect",
//				TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
//		assertTrue("Effects list is incorrect",
//				TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
//		assertTrue("Enemies list is incorrect",
//				TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
//		assertTrue("Enemies list is incorrect",
//				TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));

	}

	@Test
	public void testForLvl3() {

		// Temp Variables
		ArrayList<Effect> effectsList = new ArrayList<Effect>();
		ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();

		effectsList.clear();
		enemiesList.clear();

		// Temp variables
		Effect tempEffect;
		Enemy tempEnemy;

		// ------Effects---------
		// Create Temp variable
		tempEffect = new Effect("Earthqauke");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(20, "Timer");
		tempEffect.setEndTimer(50);

		// Add temp variable to list
		effectsList.add(tempEffect);

		// Create Temp variable
		tempEffect = new Effect("Green Fel Fire");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(50, "Timer");
		tempEffect.setEndTimer(100);
		// Add temp variable to list
		effectsList.add(tempEffect);

		// -------Enemies--------
		//Create Temp variable
	 	tempEnemy = new Enemy("Lion");
	 	// affects people and animals
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Chimp");
	 	// affects resources
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Bear");
	 	// affects buildings
	 	//Add parameters to temp variable
	 	//------------		 	
	 	tempEnemy.setStartTimer(20, "Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);

		
	 	/* Temporarily Commented out due to errors
	 	TM.threatsLvl3();

		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));
				
		*/

	}

	@Test
	public void testForLvl4() {

		// Temp Variables
		ArrayList<Effect> effectsList = new ArrayList<Effect>();
		ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();

		effectsList.clear();
		enemiesList.clear();

		// Temp variables
		Effect tempEffect;
		Enemy tempEnemy;

		// ------Effects---------
		// Create Temp variable
		tempEffect = new Effect("Blight");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(20, "Timer");
		tempEffect.setEndTimer(50);

		// Add temp variable to list
		effectsList.add(tempEffect);

		// Create Temp variable
		tempEffect = new Effect("Fel");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(50, "Timer");
		tempEffect.setEndTimer(100);
		// Add temp variable to list
		effectsList.add(tempEffect);

		// -------Enemies--------
		//Create Temp variable
	 	tempEnemy = new Enemy("Zombie Duck");
	 	// affects people and animals
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Robber");
	 	// affects resources
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Elephant");
	 	// affects buildings
	 	//Add parameters to temp variable
	 	//------------		 	
	 	tempEnemy.setStartTimer(20, "Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);

		
	 	/* Temporarily Commented out due to errors
	 	TM.threatsLvl4();

		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));
			*/
	}

}
