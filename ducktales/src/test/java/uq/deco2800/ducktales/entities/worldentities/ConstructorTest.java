package uq.deco2800.ducktales.entities.worldentities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.features.entities.worldentities.Constructor;
import uq.deco2800.ducktales.features.entities.worldentities.Farm;
import uq.deco2800.ducktales.features.entities.worldentities.Forge;
import uq.deco2800.ducktales.features.entities.worldentities.House;
import uq.deco2800.ducktales.features.entities.worldentities.Sawmill;

/**
 * Test class for the constructor class (worldEntities package). Contains 
 * tests for all the methods in the class, using a variety of buildings. 
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class ConstructorTest {
	
	/**
	 * Test having 1 building. Check the 'get' methods for Stone, Wood and Time. 
	 * A single bakery has been used.
	 */
	@Test
	public void basicTest() {
		// Instantiate a new constructor and bakery
		Constructor constructor = new Constructor();
		Bakery bakery = new Bakery(2,2);
		
		// Check the get Stone method
		assertTrue("Bakery getStone incorrect", constructor.getStone(bakery) == (4));
		// Check the get Wood method
		assertTrue("Bakery getWood incorrect!", constructor.getWood(bakery) == (6));
		// Check the get Time method
		assertTrue("Bakery getTime incorrect!", constructor.getTime(bakery) == (4));
	}
	
	/**
	 * Test having multiple of the same building. Check that the get stone, 
	 * wood and time methods work when multiple of the same building are 
	 * instantiated. 
	 */
	@Test
	public void manySameTest() {
		// Instantiate a new constructor and 2 forges
		Constructor constructor = new Constructor();
		Forge forge = new Forge(7,2);
		Forge forge2 = new Forge(5,3);
		
		// Check if the get stone method is correct, forge2
		assertTrue("forge2 getStone incorrect!", constructor.getStone(forge2) 
				== (10));
		// Check if the get wood method is correct, forge2
		assertTrue("forge2 getWood incorrect!", constructor.getWood(forge2) 
				== (6));
		// Check if the get time method is correct, forge
		assertTrue("forge getTime incorrect!", constructor.getTime(forge) == 
				(3));
	}
	
	/**
	 * Test having multiple different buildings. Check that the get stone, 
	 * wood and time methods are correct. Check the get and change health 
	 * methods for each different building.
	 * 
	 * Also check the 'production' values (type and amount) for each different 
	 * building.
	 */
	@Test
	public void multipleTest() {
		// Instantiate a new constructor and bakery, house and sawmill
		Constructor constructor = new Constructor();
		Bakery bakery = new Bakery(2,2);
		House house = new House(4,7);
		Sawmill sawmill = new Sawmill(7, 1);
		Farm farm = new Farm(3, 8);
		
		// Check get stone, for bakery
		assertTrue("Bakery getStone incorrect!", constructor.getStone(bakery) 
				== (4));
		// Check get wood, for house
		assertTrue("House getWood incorrect!", constructor.getWood(house) 
				== (4));
		// Check get time, for house
		assertTrue("House getTime incorrect!", constructor.getTime(house) 
				== (2));
		// Check house get production amount
		assertTrue("House getproductionAmount incorrect", 
				constructor.getResourcesProductionAmount(house) == 0);
		// Check house get production type
		assertTrue("House getproductionType incorrect", 
				constructor.getResourcesProductionType(house) == 
				production.NULL);
		// Check sawmill get production amount
		assertTrue("Sawmill getproductionAmount incorrect", 
				constructor.getResourcesProductionAmount(sawmill) == 5);
		// Check get production type, for samwill
		assertTrue("Sawmill getproductionType incorrect", 
				constructor.getResourcesProductionType(sawmill) == 
				production.WOOD);
		
		// Check get health for sawmill, house and bakery
		assertTrue("Correct Health", sawmill.getHealth() == 1400);
		assertTrue("Correct Health", house.getHealth() == 1000);
		assertTrue("Correct Health", bakery.getHealth() == 850);
		
		// Check update health, bakery
		bakery.changeHealth(10);
		assertTrue("Correct Health, bakery update", bakery.getHealth() == 10);
		// Check update health, house
		house.changeHealth(0);
		assertTrue("Correct Health, house invalid update", house.getHealth() 
				== 1000);
		// Check sawmill update health
		sawmill.changeHealth(978000);
		assertTrue("Correct Health, sawmill update", sawmill.getHealth() == 
				978000);
		// Check update health, bakery
		bakery.changeHealth(-10);
		assertTrue("Correct Health, bakery invalid update", bakery.getHealth() 
				== 10);
		
		// Check change health, valid (decrease)
		farm.upgradeProduce(10);
		assertTrue("Incorrect produce", farm.resourcesProductionAmount() == 10);
		// Check change health, invalid (=0)
		sawmill.upgradeProduce(0);
		assertTrue("Incorrect produce", sawmill.resourcesProductionAmount() == 0);
		// Check change health, valid (increase)
		sawmill.upgradeProduce(978000);
		assertTrue("Incorrect produce", sawmill.resourcesProductionAmount() == 978000);
		// Check change health, invalid (<0)
		farm.upgradeProduce(-10);
		assertTrue("Incorrect produce", farm.resourcesProductionAmount() == 10);
	}
}
