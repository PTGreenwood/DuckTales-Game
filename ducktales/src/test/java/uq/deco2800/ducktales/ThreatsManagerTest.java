package uq.deco2800.ducktales;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import uq.deco2800.ducktales.entities.Effect;
import uq.deco2800.ducktales.entities.Enemy;
import uq.deco2800.ducktales.entities.ThreatManager;

public class ThreatsManagerTest {

	ThreatManager TM = new ThreatManager();
	
	@SuppressWarnings("deprecation")
	@Test // For level1 testing
	
	public void testLevel1() {
		
		
		//Temp Variables
		ArrayList<Effect> effectsList = new ArrayList<Effect>();
		ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();
		
		effectsList.clear();
		enemiesList.clear();
		
		 
		//Temp variables
		Effect tempEffect;
		Enemy tempEnemy;
		
		
		 //------Effects---------
	 	//Create Temp variable
	 	tempEffect = new Effect("Earthqauke");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	effectsList.add(tempEffect);
	 	
	 	//Create Temp variable
	 	tempEffect = new Effect("Poisson Cloud");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	effectsList.add(tempEffect);
	 	
	 	
	 	
	 	
	 	//-------Enemies--------
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Deathclaw");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	 	//Create Temp variable
	 	tempEnemy = new Enemy("Cartman");
	 	//Add parameters to temp variable
	 	//------------
	 	//Add temp variable to list
	 	enemiesList.add(tempEnemy);
	 	
	
		TM.ThreatsLVL1();
		
		assertTrue("Effects list is incorrect",TM.returnEffects().get(0).toString().equals(effectsList.get(0).toString()));
		assertTrue("Effects list is incorrect",TM.returnEffects().get(1).toString().equals(effectsList.get(1).toString()));
		assertTrue("Enemies list is incorrect", TM.returnEnemies().get(0).toString().equals(enemiesList.get(0).toString()));
		assertTrue("Enemies list is incorrect", TM.returnEnemies().get(1).toString().equals(enemiesList.get(1).toString()));
		

		
	}
	@Test
	public void testLevel2() {
		assertTrue("False test is true",true);
	}
	@Test
	public void testLevel3() {
		assertTrue("False test is true",true);
	}
	@Test
	public void testLevel4() {
		assertTrue("False test is true",true);
	}
	

}
