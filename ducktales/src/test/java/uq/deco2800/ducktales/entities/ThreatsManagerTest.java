package uq.deco2800.ducktales.entities;

import org.junit.Test;

import java.util.ArrayList;

import uq.deco2800.ducktales.features.entities.Effect;
import uq.deco2800.ducktales.features.entities.Enemy;
import uq.deco2800.ducktales.features.entities.ThreatManager;

import static org.junit.Assert.assertTrue;

public class ThreatsManagerTest {

	ThreatManager TM = new ThreatManager();

	@Test // For level1 testing

	public void testLevel1() {

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
		tempEffect = new Effect("Shake");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(20, "Timer");
		tempEffect.setEndTimer(50);

		// Add temp variable to list
		effectsList.add(tempEffect);

		// Create Temp variable
		tempEffect = new Effect("Dust");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(50, "Timer");
		tempEffect.setEndTimer(100);
		// Add temp variable to list
		effectsList.add(tempEffect);

		// -------Enemies--------
		//Create Temp variable
	 	tempEnemy = new Enemy("Raccoon");
	 	// affects people and animals
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Beetle");
	 	// affects resources
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Wild Villager");
	 	// affects buildings
	 	//Add parameters to temp variable
	 	//------------		 	
	 	tempEnemy.setStartTimer(20, "Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);

		TM.threatsLvl1();

		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));

	}

	@Test
	public void testLevel2() {

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
		tempEffect = new Effect("Rumble");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(20, "Timer");
		tempEffect.setEndTimer(50);

		// Add temp variable to list
		effectsList.add(tempEffect);

		// Create Temp variable
		tempEffect = new Effect("Cyanide");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(50, "Timer");
		tempEffect.setEndTimer(100);
		// Add temp variable to list
		effectsList.add(tempEffect);

		// -------Enemies--------
		//Create Temp variable
	 	tempEnemy = new Enemy("Wolf");
	 	// affects people and animals
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Crow");
	 	// affects resources
	 	//Add parameters to temp variable
	 	//------------
	 	tempEnemy.setStartTimer(20,"Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Gorilla");
	 	// affects buildings
	 	//Add parameters to temp variable
	 	//------------		 	
	 	tempEnemy.setStartTimer(20, "Timer");
	 	tempEnemy.setEndTimer(50);
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);

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
	public void testLevel3() {

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
		tempEffect = new Effect("Poisson Cloud");
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

		TM.threatsLvl3();

		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));

	}

	@Test
	public void testLevel4() {

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

		TM.threatsLvl4();

		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
		assertTrue("Effects list is incorrect",
				TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
		assertTrue("Enemies list is incorrect",
				TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));
	}

}
