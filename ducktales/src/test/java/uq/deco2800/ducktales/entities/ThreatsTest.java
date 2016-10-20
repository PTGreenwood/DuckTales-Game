package uq.deco2800.ducktales.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;
import uq.deco2800.ducktales.GameManagerTest;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.builder.WorldBuilderControllerTest;
import uq.deco2800.ducktales.features.entities.threats.Effect;
import uq.deco2800.ducktales.features.entities.threats.Enemy;



public class ThreatsTest{

	/**
	 * Test for the threats class as well as enemies and effects
	 * 
	 * 
	 */

	@Test
	public void basicThreatTest() {

		Enemy enemy = new Enemy("Raccoon");
		Effect effect = new Effect("Black Smoke");

		assertNotNull("Enemy cannot be null.", enemy);
		assertNotNull("Enemy's X coordinate cannot be null.", enemy.getX());
		assertNotNull("Enemy's Y coordinate cannot be null.", enemy.getY());
		assertNotNull("The enemy's level of damage cannot be null", enemy.getTheLevelOfDamage());
		assertNotNull("The enemy's speed cannot be null.", enemy.getSpeed());

		assertNotNull("Effect cannot be null.", effect);
		assertNotNull("Effect's X coordinate cannot be null.", effect.getX());
		assertNotNull("Effect's Y coordinate cannot be null.", effect.getY());
		assertNotNull("The effect's level of damage cannot be null", effect.getTheLevelOfDamage());
		assertNotNull("The effect's speed cannot be null.", effect.getSpeed());

	}

	@Test
	public void basicThreatTest2() {

		double xCord = 0;
		double yCord = 0;
		int speed = 0;
		int levelOfDamage = 0;

		Enemy enemy = new Enemy("Raccoon");

		assertEquals(enemy.getX(), xCord, 9);
		assertEquals(enemy.getY(), yCord, 9);
		assertEquals(enemy.getSpeed(), speed, 1);
		assertEquals(enemy.getTheLevelOfDamage(), levelOfDamage, 30);

		Effect effect = new Effect("Black Smoke");
		
		assertEquals(effect.getX(), xCord, 15);
		assertEquals(effect.getY(), yCord, 15);
		assertEquals(effect.getSpeed(), speed, 5);
		assertEquals(effect.getTheLevelOfDamage(), levelOfDamage, 20);

	}

	@Test
	public void basicThreatTest3() {
		
		Enemy enemy = new Enemy("Raccoon");
		Effect effect = new Effect("Black Smoke");
//		World world = new World("World", 700, 700);
//		double randomX=0;
//		double randomY=0;
//		double xCord=0;
//		double yCord=0;
//		
//		enemy.getRandomX();
//		enemy.setXCord();
//		assertTrue("x cord should be between 0 and 700",  xCord >= 0 || xCord <= 700);
		int levelOfDamage = 10;
		int speed = 0;
		enemy.setTheLevelOfDamage(30);
		assertTrue ("level of damage set is equal to level of damage from get", enemy.getTheLevelOfDamage() == 30);
		enemy.setTheSpeed(20);
		assertTrue ("speed from setting speed is equal to speed of get speed", enemy.getSpeed() == 20);
		effect.setTheLevelOfDamage(30);
		assertTrue ("level of damage set is equal to level of damage from get", effect.getTheLevelOfDamage() == 30);
		effect.setTheSpeed(20);
		assertTrue ("speed from setting speed is equal to speed of get speed", effect.getSpeed() == 20);
	}
}
