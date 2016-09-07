package uq.deco2800.ducktales.entities.worldentities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.features.entities.worldentities.Constructor;
import uq.deco2800.ducktales.features.entities.worldentities.Forge;
import uq.deco2800.ducktales.features.entities.worldentities.House;
import uq.deco2800.ducktales.features.entities.worldentities.Sawmill;

public class ConstructorTest {
	
	/**
	 * Test having 1 building
	 */
	@Test
	public void basicTest() {
		Constructor constructor = new Constructor();
		Bakery bakery = new Bakery(2,2);
		
		assertTrue("Bakery getStone incorrect!", constructor.getStone(bakery) == (4));
		assertTrue("Bakery getWood incorrect!", constructor.getWood(bakery) == (6));
		assertTrue("Bakery getTime incorrect!", constructor.getTime(bakery) == (4));
	}
	
	/**
	 * Test having multiple of the same building.
	 */
	@Test
	public void manySameTest() {
		Constructor constructor = new Constructor();
		Forge forge = new Forge(7,2);
		Forge forge2 = new Forge(5,3);
		
		assertTrue("forge2 getStone incorrect!", constructor.getStone(forge2) == (10));
		assertTrue("forge2 getWood incorrect!", constructor.getWood(forge2) == (6));
		assertTrue("forge getTime incorrect!", constructor.getTime(forge) == (3));
	}
	
	/**
	 * Test having multiple different buildings
	 */
	@Test
	public void multipleTest() {
		Constructor constructor = new Constructor();
		Bakery bakery = new Bakery(2,2);
		House house = new House(4,7);
		Sawmill sawmill = new Sawmill(7, 1);
		
		assertTrue("Bakery getStone incorrect!", constructor.getStone(bakery) == (4));
		assertTrue("House getWood incorrect!", constructor.getWood(house) == (4));
		assertTrue("House getTime incorrect!", constructor.getTime(house) == (2));
		assertTrue("House getproductionType incorrect", 
				constructor.getResourcesProductionAmount(house) == 0);
		assertTrue("House getproductionType incorrect", 
				constructor.getResourcesProductionType(house) == production.NULL);
		assertTrue("House getproductionType incorrect", 
				constructor.getResourcesProductionAmount(sawmill) == 5);
		assertTrue("House getproductionType incorrect", 
				constructor.getResourcesProductionType(sawmill) == production.WOOD);
	}
}
