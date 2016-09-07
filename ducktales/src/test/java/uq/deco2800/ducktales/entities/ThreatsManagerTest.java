package uq.deco2800.ducktales.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.Effect;
import uq.deco2800.ducktales.features.entities.Enemy;
import uq.deco2800.ducktales.features.entities.ThreatManager;

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
		// Create Temp variable
		tempEnemy = new Enemy("SCV");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Ducktron");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		TM.ThreatsLVL1();

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
		// Create Temp variable
		tempEnemy = new Enemy("Mutalisk");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Brutalisk");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		TM.ThreatsLVL2();

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
		// Create Temp variable
		tempEnemy = new Enemy("Deathclaw");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Cartman");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		TM.ThreatsLVL3();

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
		// Create Temp variable
		tempEnemy = new Enemy("Deathwing");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Lich - King");
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		TM.ThreatsLVL4();

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
