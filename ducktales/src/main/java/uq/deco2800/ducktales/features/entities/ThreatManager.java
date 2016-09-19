package uq.deco2800.ducktales.features.entities;

import uq.deco2800.ducktales.World;

import java.util.*;

/**
 * Creates enemies and effects and manages when they are deployed
 * 
 * 
 * @author Wian
 *
 */
public class ThreatManager {
	public static ArrayList<Effect> effectsList = new ArrayList<Effect>();
	public static ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();

	// Temp variables
	private Effect tempEffect;
	private Enemy tempEnemy;
	String timer = "Timer";

	/** The world of the game */
	private World world;

	/**
	 * Set threat level 1.
	 */
	public void threatsLvl1() {
		// Clear Effects
		effectsList.clear();
		enemiesList.clear();

		// ------Effects---------
		// Create Temp variable
		tempEffect = new Effect("Black Smoke");
		tempEffect.setStartTimer(20, timer);
		tempEffect.setEndTimer(50);
		tempEffect.getRandomX();
		tempEffect.getRandomY();
		tempEffect.setTheLevelOfDamage(20);
		//tempEffect.checkCollision();
		effectsList.add(tempEffect);
		int blackSmokeValue = effectsList.indexOf("Black Smoke");
		Effect blackSmoke = effectsList.get(blackSmokeValue);
		//ThreatSprite blackSmokeSprite = new ThreatSprite();
		//ThreatSprite.add(blackSmokeSprite);
		
		// Create Temp variable
		tempEffect = new Effect("Shake");
		tempEffect.setStartTimer(50, timer);
		tempEffect.setEndTimer(100);
		//tempEffect.setTheLevelOfDamage(25);
		effectsList.add(tempEffect);
		int shakeValue = effectsList.indexOf("Shake");
		Effect shake = effectsList.get(shakeValue);

		// -------Enemies--------
		// Create Temp variable
		tempEnemy = new Enemy("Raccoon");
		// affects people and animals
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		tempEnemy.getRandomX();
		tempEnemy.getRandomY();
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Beetle");
		// affects resources
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		tempEnemy.getRandomX();
		tempEnemy.getRandomY();
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Wild Villager");
		// affects buildings
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		tempEnemy.getRandomX();
		tempEnemy.getRandomY();
		// Add temp variable to list
		enemiesList.add(tempEnemy);
	}

	/**
	 * Set threat level 2.
	 */
	public void threatsLvl2() {
		// Clear Effects
		effectsList.clear();
		enemiesList.clear();

		// ------Effects---------
		// Create Temp variable
		tempEffect = new Effect("Poison Cloud");
		tempEffect.setStartTimer(20, timer);
		tempEffect.setEndTimer(50);
		tempEffect.getRandomX();
		tempEffect.getRandomY();
		tempEffect.setTheLevelOfDamage(30);
		//tempEffect.checkCollision();
		effectsList.add(tempEffect);
		int poisonCloudValue = effectsList.indexOf("Poison Cloud");
		Effect poisonCloud = effectsList.get(poisonCloudValue);
		
		tempEffect = new Effect("Rumble");
		tempEffect.setStartTimer(50, timer);
		tempEffect.setEndTimer(100);
		tempEffect.getRandomX();
		tempEffect.getRandomY();
		tempEffect.setTheLevelOfDamage(30);
		//tempEffect.checkCollision();
		effectsList.add(tempEffect);
		int rumbleValue = effectsList.indexOf("Rumble");
		Effect rumble = effectsList.get(rumbleValue);

		// -------Enemies--------
		// Create Temp variable
		tempEnemy = new Enemy("Wolf");
		// affects people and animals
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Crow");
		// affects resources
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Gorilla");
		// affects buildings
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Evil Duck");
		// Add parameters to temp variable
		tempEnemy.setStartTimer(20, "Timer");
		tempEnemy.setEndTimer(50);
		tempEnemy.getRandomX();
		tempEnemy.getRandomY();
		tempEnemy.checkCollision();
		tempEnemy.setTheLevelOfDamage(50);
		enemiesList.add(tempEnemy);
	}

	/**
	 * Set threat level 3.
	 */
	public void threatsLvl3() {
		// Clear Effects
		effectsList.clear();
		enemiesList.clear();

		// ------Effects---------
		// Create Temp variable
		tempEffect = new Effect("Earthqauke");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(20, timer);
		tempEffect.setEndTimer(50);

		// Add temp variable to list
		effectsList.add(tempEffect);

		// Create Temp variable
		tempEffect = new Effect("Green Fel Fire");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(50, timer);
		tempEffect.setEndTimer(100);
		// Add temp variable to list
		effectsList.add(tempEffect);

		// -------Enemies--------
		// Create Temp variable
		tempEnemy = new Enemy("Lion");
		// affects people and animals
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Chimp");
		// affects resources
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Bear");
		// affects buildings
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);
	}

	/**
	 * Set threat level 4.
	 */
	public void threatsLvl4() {
		// Clear Effects
		effectsList.clear();
		enemiesList.clear();

		// ------Effects---------
		// Create Temp variable
		tempEffect = new Effect("Blight");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(20, timer);
		tempEffect.setEndTimer(50);

		// Add temp variable to list
		effectsList.add(tempEffect);

		// Create Temp variable
		tempEffect = new Effect("Fel");
		// Add parameters to temp variable
		// ------------
		tempEffect.setStartTimer(50, timer);
		tempEffect.setEndTimer(100);
		// Add temp variable to list
		effectsList.add(tempEffect);

		// -------Enemies--------
		// Create Temp variable
		tempEnemy = new Enemy("Zombie Duck");
		// affects people and animals
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Robber");
		// affects resources
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);

		// Create Temp variable
		tempEnemy = new Enemy("Elephant");
		// affects buildings
		// Add parameters to temp variable
		// ------------
		tempEnemy.setStartTimer(20, timer);
		tempEnemy.setEndTimer(50);
		// Add temp variable to list
		enemiesList.add(tempEnemy);
	}

	/**
	 * 
	 * @return The current list of enemies created
	 */
	public static ArrayList<Enemy> returnEnemies() {
		return enemiesList;
	}

	/**
	 * 
	 * @return The current list of Effects created.
	 */
	public static ArrayList<Effect> returnEffects() {
		return effectsList;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	

}
