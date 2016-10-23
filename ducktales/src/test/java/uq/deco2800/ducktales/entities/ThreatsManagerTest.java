package uq.deco2800.ducktales.entities;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.threats.Threat;
import uq.deco2800.ducktales.features.entities.threats.Effect;
import uq.deco2800.ducktales.features.entities.threats.Enemy;
import uq.deco2800.ducktales.features.entities.threats.ThreatManager;
import uq.deco2800.ducktales.features.entities.threats.ThreatFactory;

import static org.junit.Assert.*;


public class ThreatsManagerTest extends ApplicationTest{
	
	ThreatManager TM = new ThreatManager();
	
	@Test 
	public void testForThreatsLvl1(){
		
		
		String name= "world";
		int worldWidth = 700;
		int worldHeight = 700;
		World world = new World(name, worldWidth, worldHeight);
		
		Enemy enemy1 = new Enemy("Raccoon");
		enemy1.setWorld(world);
		assertNotNull("Enemy cannot be null.", enemy1);
		assertNotNull("The enemy's speed cannot be null.", enemy1.getRandomX());
		assertNotNull("The enemy's speed cannot be null.", enemy1.getRandomY());
		assertNotNull("Enemy's X coordinate cannot be null.", enemy1.getX());
		assertNotNull("Enemy's Y coordinate cannot be null.", enemy1.getY());
		assertNotNull("The enemy's level of damage cannot be null", enemy1.getTheLevelOfDamage());
		assertNotNull("The enemy's speed cannot be null.", enemy1.getSpeed());
		
		Enemy enemy2 = new Enemy("Beetle");
		enemy2.setWorld(world);
		assertNotNull("Enemy cannot be null.", enemy2);
		assertNotNull("The enemy's speed cannot be null.", enemy2.getRandomX());
		assertNotNull("The enemy's speed cannot be null.", enemy2.getRandomY());
		assertNotNull("Enemy's X coordinate cannot be null.", enemy2.getX());
		assertNotNull("Enemy's Y coordinate cannot be null.", enemy2.getY());
		assertNotNull("The enemy's level of damage cannot be null", enemy2.getTheLevelOfDamage());
		assertNotNull("The enemy's speed cannot be null.", enemy2.getSpeed());
		
		Enemy enemy3 = new Enemy("Wild Villager");
		enemy3.setWorld(world);
		assertNotNull("Enemy cannot be null.", enemy3);
		assertNotNull("The enemy's speed cannot be null.", enemy3.getRandomX());
		assertNotNull("The enemy's speed cannot be null.", enemy3.getRandomY());
		assertNotNull("Enemy's X coordinate cannot be null.", enemy3.getX());
		assertNotNull("Enemy's Y coordinate cannot be null.", enemy3.getY());
		assertNotNull("The enemy's level of damage cannot be null", enemy3.getTheLevelOfDamage());
		assertNotNull("The enemy's speed cannot be null.", enemy3.getSpeed());
		
		Effect effect1 = new Effect("Black Smoke");
		effect1.setWorld(world);
		assertNotNull("Effect cannot be null.", effect1);
		assertNotNull("Effect's X coordinate cannot be null.", effect1.getX());
		assertNotNull("Effect's Y coordinate cannot be null.", effect1.getY());
		assertNotNull("The effect's level of damage cannot be null", effect1.getTheLevelOfDamage());
		assertNotNull("The effect's speed cannot be null.", effect1.getSpeed());
		
		Effect effect2 = new Effect("Shake");

		ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();
		enemiesList.add(enemy1);
		enemiesList.add(enemy2);
		enemiesList.add(enemy3);
		
		ArrayList<Effect> effectsList = new ArrayList<Effect>();
		effectsList.add(effect1);
		effectsList.add(effect2);

	}

	@Test
	public void testForThreatsLvl2() {

	}

	@Test
	public void testForThreatsLvl3() {
		
	}

	@Test
	public void testForThreatsLvl4() {

	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
