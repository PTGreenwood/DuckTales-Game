package uq.deco2800.ducktales.entities.worldentities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.worldentities.*;
import uq.deco2800.ducktales.features.entities.worldentities.StorageProduceBuilding.production;
import uq.deco2800.ducktales.features.entities.Entity;

/**
 * Test for Building.java and all building classes. Check inherited and 
 * locally defined methods. 
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class BuildingTest {
	
	/**
	 * Basic test, test equality, sort and tick of Box buildings.
	 */
	@Test
	public void basicTest(){
		// Instantiate 3 boxes
		Entity entity1 = new Box(2, 3);
		Entity entity2 = new Box(4, 5);
		Entity entity3 = new Box(1, 1);
		
		// Add boxes to list
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Sort boxes
		Collections.sort(entities);
		
		// Check to ensure that sort was correct, box 3 is 1st in list
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		// Box 1 is 2nd in list (position 1)
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		// Box 2 is 3rd in list (position 3)
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Call tick method on box 1
		entity1.tick();
		// Call tick method on box 2
		entity2.tick();
		// Call tick method on box 3
		entity3.tick();
		
		// Check that the entities are unchanged, same results as above
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
	}
	
	/**
	 * House test, check all the methods and parameters of House buildings 
	 * that can be called/accessed. 
	 */
	@Test (expected = UnsupportedOperationException.class)
	public void storageBarnTest() {
		// Instantiate 3 Houses
		StorageBarn entity1 = new StorageBarn(2, 3);
		StorageBarn entity2 = new StorageBarn(4, 5);
		StorageBarn entity3 = new StorageBarn(1, 1);
		
		// Add house buildings to a list
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check that houses are sorted correctly
		Collections.sort(entities);
		
		// Check that house 3 is 1st in list
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		// Check that house 1 is 2nd in the list
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		// Check that house 2 is 3rd in the list
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct returned resources and time are accessed and returned
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (2));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 7);
		
		// Check correct production type and amount
		assertTrue("Wrong production type", entity1.resourcesProductionType() 
				== production.NULL);
		assertTrue("Wrong production amount", 
				entity3.resourcesProductionAmount() == 0);
		
		// Check tick method, call for each house
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		// Check that the objects are unchanged after tick called
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (2));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 7);
		
		// Check the getHealth method for a house
		assertTrue("Incorrect Health", entity3.getHealth() == 950);
		
		// Check change health, valid (decrease)
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, invalid (=0)
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, valid (increase)
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		// Check change health, invalid (<0)
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Test getx and gety methods, house 3
		assertTrue("Incorrect xLength", entity3.getXLength() == 5);
		assertTrue("Incorrect yLength", entity3.getYLength() == 5);
		
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,0), (LUMBER,200,0), (STONE,150,0), (ORE,100,0), (FOOD,250,0)]");
		entity3.addGoods(production.FOOD, 15);
		entity3.addGoods(production.ORE, 7);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,0), (LUMBER,200,0), (STONE,150,0), (ORE,100,7), (FOOD,250,15)]");
		entity3.addGoods(production.TIMBER, 30);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,100,7), (FOOD,250,15)]");
		entity3.upgradeBarn(production.ORE, 30);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,30,7), (FOOD,250,15)]");
		entity3.addGoods(production.ORE, 16);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,30,23), (FOOD,250,15)]");
		entity3.addGoods(production.ORE, -10);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,30,13), (FOOD,250,15)]");
		entity3.addGoods(null, -10);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,30,13), (FOOD,250,15)]");
		entity3.addGoods(production.ORE, 30);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,30,30), (FOOD,250,15)]");
		entity3.addGoods(production.NULL, 10);
		assertEquals(entity3.getStorage().toString(), "[(TIMBER,200,30), (LUMBER,200,0), (STONE,150,0), (ORE,30,30), (FOOD,250,15)]");
		
		entity3.upgradeProduce(10);
	}
	
	/**
	 * House test, check all the methods and parameters of House buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void houseTest() {
		// Instantiate 3 Houses
		House entity1 = new House(2, 3);
		House entity2 = new House(4, 5);
		House entity3 = new House(1, 1);
		
		// Add house buildings to a list
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check that houses are sorted correctly
		Collections.sort(entities);
		
		// Check that house 3 is 1st in list
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		// Check that house 1 is 2nd in the list
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		// Check that house 2 is 3rd in the list
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct returned resources and time are accessed and returned
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (2));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 2);
				
		// Check tick method, call for each house
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		// Check that the objects are unchanged after tick called
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (2));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 2);
		
		// Check the getHealth method for a house
		assertTrue("Incorrect Health", entity3.getHealth() == 1000);
		
		// Check change health, valid (decrease)
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, invalid (=0)
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, valid (increase)
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		// Check change health, invalid (<0)
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Test getx and gety methods, house 3
		assertTrue("Incorrect xLength", entity3.getXLength() == 2);
		assertTrue("Incorrect yLength", entity3.getYLength() == 2);
	}
	
	/**
	 * School test, check all the methods and parameters of School buildings 
	 * that can be called/accessed. 
	 */
	@Test
	public void schoolTest() {
		// Instantiate 3 Houses
		School entity1 = new School(2, 3);
		School entity2 = new School(4, 5);
		School entity3 = new School(1, 1);
		
		// Add house buildings to a list
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check that houses are sorted correctly
		Collections.sort(entities);
		
		// Check that house 3 is 1st in list
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		// Check that house 1 is 2nd in the list
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		// Check that house 2 is 3rd in the list
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct returned resources and time are accessed and returned
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (4));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 6);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 8);
		
		// Check tick method, call for each house
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		// Check that the objects are unchanged after tick called
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (4));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 6);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 8);
		
		// Check the getHealth method for a house
		assertTrue("Incorrect Health", entity3.getHealth() == 1000);
		
		// Check change health, valid (decrease)
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, invalid (=0)
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, valid (increase)
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		// Check change health, invalid (<0)
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Test getx and gety methods, house 3
		assertTrue("Incorrect xLength", entity3.getXLength() == 5);
		assertTrue("Incorrect yLength", entity3.getYLength() == 5);
	}
	
	/**
	 * Gymnasium test, check all the methods and parameters of gym buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void gymTest() {
		// Instantiate 3 Houses
		Gymnasium entity1 = new Gymnasium(2, 3);
		Gymnasium entity2 = new Gymnasium(4, 5);
		Gymnasium entity3 = new Gymnasium(1, 1);
		
		// Add house buildings to a list
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check that houses are sorted correctly
		Collections.sort(entities);
		
		// Check that house 3 is 1st in list
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		// Check that house 1 is 2nd in the list
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		// Check that house 2 is 3rd in the list
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct returned resources and time are accessed and returned
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (3));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 6);
		
		// Check tick method, call for each house
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		// Check that the objects are unchanged after tick called
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (3));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 6);
		
		// Check the getHealth method for a house
		assertTrue("Incorrect Health", entity3.getHealth() == 900);
		
		// Check change health, valid (decrease)
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, invalid (=0)
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		// Check change health, valid (increase)
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		// Check change health, invalid (<0)
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Test getx and gety methods, house 3
		assertTrue("Incorrect xLength", entity3.getXLength() == 2);
		assertTrue("Incorrect yLength", entity3.getYLength() == 2);
	}
	
	/**
	 * Box test, check all the methods and parameters of Box buildings  
	 * that can be called/accessed. 
	 */
	@Test 
	public void boxTest() {
		// Instantiate 3 new Boxes
		Box entity1 = new Box(2, 3);
		Box entity2 = new Box(4, 5);
		Box entity3 = new Box(1, 1);
		
		// Add boxes to a list
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort is correct
		Collections.sort(entities);
		
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (1));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 4);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (1));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time", entity2.timeToBuild() == 4);
		
		// Check get health
		assertTrue("Incorrect Health", entity3.getHealth() == 400);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Test getx and gety methods
		assertTrue("Incorrect xLength", entity3.getXLength() == 1);
		assertTrue("Incorrect yLength", entity3.getYLength() == 1);
	}
	
	/**
	 * LongBox test, check all the methods and parameters of LongBox buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void longBoxTest(){
		// Instantiate 3 new LongBox buildings
		LongBox entity1 = new LongBox(2, 3);
		LongBox entity2 = new LongBox(4, 5);
		LongBox entity3 = new LongBox(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (1));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 2);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (1));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 2);
		
		// Check get health
		assertTrue("Incorrect Health", entity3.getHealth() == 600);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Test getx and gety methods
		assertTrue("Incorrect xLength", entity3.getXLength() == 2);
		assertTrue("Incorrect yLength", entity3.getYLength() == 1);
	}
	
	/**
	 * Barn test, check all the methods and parameters of Barn buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void barnTest(){
		// Instantiate 3 new Barns
		Barn entity1 = new Barn(2, 3);
		Barn entity2 = new Barn(4, 5);
		Barn entity3 = new Barn(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 9);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 9);
		
		// Check get health for barns
		assertTrue("Incorrect Health", entity3.getHealth() == 900);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Sawmill test, check all the methods and parameters of Sawmill buildings 
	 * that can be called/accessed. 
	 */
	@Test
	public void sawmillTest(){
		// Instantiate 3 new Sawmills
		Sawmill entity1 = new Sawmill(2, 3);
		Sawmill entity2 = new Sawmill(4, 5);
		Sawmill entity3 = new Sawmill(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 3);
		
		// Check correct production type and amount
		assertTrue("Wrong production type", 
				entity1.resourcesProductionType() == production.TIMBER);
		assertTrue("Wrong production amount", 
				entity3.resourcesProductionAmount() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to buidl", entity2.timeToBuild() == 3);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 1400);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Check change health, valid (decrease)
		entity3.upgradeProduce(10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 10);
		// Check change health, invalid (=0)
		entity3.upgradeProduce(0);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 0);
		// Check change health, valid (increase)
		entity3.upgradeProduce(978000);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
		// Check change health, invalid (<0)
		entity3.upgradeProduce(-10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
	}
	
	/**
	 * Observatory test, check all the methods and parameters of Observatory 
	 * buildings that can be called/accessed. 
	 */
	@Test 
	public void observatoryTest(){
		// Instantiate 3 new Observatories
		Observatory entity1 = new Observatory(2, 3);
		Observatory entity2 = new Observatory(4, 5);
		Observatory entity3 = new Observatory(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 10);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 10);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 5);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 900);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Bakery test, check all the methods and parameters of Bakery buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void bakeryTest(){
		// Instantiate 3 new Bakeries
		Bakery entity1 = new Bakery(2, 3);
		Bakery entity2 = new Bakery(4, 5);
		Bakery entity3 = new Bakery(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong resources returned - stone", 
				entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 4);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong resources returned - stone", 
				entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 4);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 850);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Cemetery test, check all the methods and parameters of Cemetery 
	 * buildings that can be called/accessed. 
	 */
	@Test 
	public void cemeteryTest(){
		// Instantiate 3 new cemeteries
		Cemetery entity1 = new Cemetery(2, 3);
		Cemetery entity2 = new Cemetery(4, 5);
		Cemetery entity3 = new Cemetery(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 1);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 2);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 1);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 2);
		
		// Check get health
		assertTrue("Incorrect Health", entity3.getHealth() == 500);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Farm test, check all the methods and parameters of Farm buildings 
	 * that can be called/accessed. 
	 */
	@Test
	public void farmTest(){
		// Instantiate 3 new farms
		Farm entity1 = new Farm(2, 3);
		Farm entity2 = new Farm(4, 5);
		Farm entity3 = new Farm(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 9);
		
		// Check correct production type and amount
		assertTrue("Wrong production type", 
				entity1.resourcesProductionType() == production.FOOD);
		assertTrue("Wrong production amount", 
				entity3.resourcesProductionAmount() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 9);
		
		// Check method get health
		assertTrue("Incorrect Health", entity3.getHealth() == 900);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Check change health, valid (decrease)
		entity3.upgradeProduce(10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 10);
		// Check change health, invalid (=0)
		entity3.upgradeProduce(0);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 0);
		// Check change health, valid (increase)
		entity3.upgradeProduce(978000);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
		// Check change health, invalid (<0)
		entity3.upgradeProduce(-10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
	}
	
	/**
	 * Forge test, check all the methods and parameters of Forge buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void forgeTest(){
		// Instantiate 3 new forges
		Forge entity1 = new Forge(2, 3);
		Forge entity2 = new Forge(4, 5);
		Forge entity3 = new Forge(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 5);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 10);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 3);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 5);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 10);
		assertTrue("Wrong time to build", 
				entity2.timeToBuild() == 3);
		
		// Check get health
		assertTrue("Incorrect Health", entity3.getHealth() == 1000);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Hospital test, check all the methods and parameters of Hospital 
	 * buildings that can be called/accessed. 
	 */
	@Test 
	public void hospitalTest(){
		// Instantiate 3 new hospitals
		Hospital entity1 = new Hospital(2, 3);
		Hospital entity2 = new Hospital(4, 5);
		Hospital entity3 = new Hospital(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 4);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 4);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 5);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 1800);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Mine test, check all the methods and parameters of Mine buildings 
	 * that can be called/accessed. 
	 */
	@Test
	public void mineTest(){
		// Instantiate 3 new mines
		Mine entity1 = new Mine(2, 3);
		Mine entity2 = new Mine(4, 5);
		Mine entity3 = new Mine(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort method is correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (3));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 10);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 3);
		
		// Check correct production type and amount
		assertTrue("Wrong production type", 
				entity1.resourcesProductionType() == production.ORE);
		assertTrue("Wrong production amount", 
				entity3.resourcesProductionAmount() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == (3));
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 10);
		assertTrue("Wrong time", entity2.timeToBuild() == 3);
		
		// Test getx and gety methods
		assertTrue("Incorrect xLength", entity3.getXLength() == 5);
		assertTrue("Incorrect yLength", entity3.getYLength() == 5);
		
		// Chek gethealth method
		assertTrue("Incorrect Health", entity3.getHealth() == 1300);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Check change health, valid (decrease)
		entity3.upgradeProduce(10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 10);
		// Check change health, invalid (=0)
		entity3.upgradeProduce(0);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 0);
		// Check change health, valid (increase)
		entity3.upgradeProduce(978000);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
		// Check change health, invalid (<0)
		entity3.upgradeProduce(-10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
	}
	
	/**
	 * Butcher test, check all the methods and parameters of Butcher buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void butcherTest(){
		// Instantiate 3 new butchers
		Butcher entity1 = new Butcher(2, 3);
		Butcher entity2 = new Butcher(4, 5);
		Butcher entity3 = new Butcher(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 4);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 7);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 7);
		
		// Check get health
		assertTrue("Incorrect Health", entity3.getHealth() == 750);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Church test, check all the methods and parameters of Church buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void churchTest(){
		// Instantiate 3 new Churches
		Church entity1 = new Church(2, 3);
		Church entity2 = new Church(4, 5);
		Church entity3 = new Church(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 10);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 9);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 4);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time", entity2.timeToBuild() == 9);
		
		// Check get health
		assertTrue("Incorrect Health", entity3.getHealth() == 1900);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Community Building test, check all the methods and parameters of 
	 * Community Buildings that can be called/accessed. 
	 */
	@Test 
	public void communityBuildingTest(){
		// Instantiate 3 new Community Buildings
		CommunityBuilding entity1 = new CommunityBuilding(2, 3);
		CommunityBuilding entity2 = new CommunityBuilding(4, 5);
		CommunityBuilding entity3 = new CommunityBuilding(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 4);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 8);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 3);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 6);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 8);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 1400);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Pasture test, check all the methods and parameters of Pasture buildings 
	 * that can be called/accessed. 
	 */
	@Test 
	public void pastureTest(){
		// Instantiate 3 new Pastures
		Pasture entity1 = new Pasture(2, 3);
		Pasture entity2 = new Pasture(4, 5);
		Pasture entity3 = new Pasture(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 3 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 10);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 4);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 1);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 4);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 800);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
	}
	
	/**
	 * Quarry test, check all the methods and parameters of Quarry buildings 
	 * that can be called/accessed. 
	 */
	@Test
	public void quarryTest(){
		// Instantiate 3 new Quarries
		Quarry entity1 = new Quarry(2, 3);
		Quarry entity2 = new Quarry(4, 5);
		Quarry entity3 = new Quarry(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check sort correct
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources - wood", 
				entity1.resourcesReturnWood() == 3);
		assertTrue("Wrong resources to build - wood", 
				entity3.resourcesBuildWood() == 6);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 5);
		
		// Check correct production type and amount
		assertTrue("Wrong production type", 
				entity1.resourcesProductionType() == production.STONE);
		assertTrue("Wrong production amount", 
				entity3.resourcesProductionAmount() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		
		assertTrue("Wrong returned resources - stone", 
				entity1.resourcesReturnStone() == 4);
		assertTrue("Wrong resources to build - stone", 
				entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time to build", entity2.timeToBuild() == 5);
		
		// Check get health method
		assertTrue("Incorrect Health", entity3.getHealth() == 1300);
		
		// Check update health
		entity3.changeHealth(10);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(0);
		assertTrue("Incorrect Health", entity3.getHealth() == 10);
		entity3.changeHealth(978000);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		entity3.changeHealth(-10);
		assertTrue("Incorrect Health", entity3.getHealth() == 978000);
		
		// Check change health, valid (decrease)
		entity3.upgradeProduce(10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 10);
		// Check change health, invalid (=0)
		entity3.upgradeProduce(0);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 0);
		// Check change health, valid (increase)
		entity3.upgradeProduce(978000);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
		// Check change health, invalid (<0)
		entity3.upgradeProduce(-10);
		assertTrue("Incorrect Health", entity3.resourcesProductionAmount() == 978000);
	}
	
	/**
	 * Test for adjacent buildings of the same type (LongBox), 1 adjacent side.
	 *  Check the sort, and additional building methods. Ensure that locating 
	 * buildings adjacently does not interfere with parameters/methods.  
	 */
	@Test
	public void adjacentTest2(){
		// Instantiate 2 new LongBox buildings
		Entity foreground = new LongBox(7, 3);
		Entity background = new LongBox(6, 4);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		// Check that sort is correct
		Collections.sort(entities);
		
		// Check that tick does not alter parameters
		foreground.tick();
		background.tick();
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(background));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground));
		
		// Check get Health method for each
		assertTrue("Incorrect Health", ((LongBox) (foreground)).getHealth() == 600);
		assertTrue("Incorrect Health", ((LongBox) background).getHealth() == 600);
		
		// Check update health
		((LongBox) (foreground)).changeHealth(10);
		assertTrue("Incorrect Health", ((LongBox) (foreground)).getHealth() == 10);
		((LongBox) background).changeHealth(0);
		assertTrue("Incorrect Health", ((LongBox) background).getHealth() == 600);
		((LongBox) (foreground)).changeHealth(978000);
		assertTrue("Incorrect Health", ((LongBox) (foreground)).getHealth() == 978000);
		((LongBox) background).changeHealth(-10);
		assertTrue("Incorrect Health", ((LongBox) background).getHealth() == 600);
	}

	/**
	 * Check adjacent buildings, when they are the same type, and 2 adjacent 
	 * sides. Check the sort, and additional building methods. Ensure that 
	 * locating buildings adjacently does not interfere.   
	 */
	@Test
	public void adjacentTestMiddle(){
		Entity foreground = new LongBox(6, 7);
		Entity background = new LongBox(7, 6);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		// Check sort is correct
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(background));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground));	
		
		// Check get health method
		assertTrue("Incorrect Health", ((LongBox) (foreground)).getHealth() == 600);
		assertTrue("Incorrect Health", ((LongBox) background).getHealth() == 600);
		
		// Check update health
		((LongBox) (foreground)).changeHealth(10);
		assertTrue("Incorrect Health", ((LongBox) (foreground)).getHealth() == 10);
		((LongBox) background).changeHealth(0);
		assertTrue("Incorrect Health", ((LongBox) background).getHealth() == 600);
		((LongBox) (foreground)).changeHealth(978000);
		assertTrue("Incorrect Health", ((LongBox) (foreground)).getHealth() == 978000);
		((LongBox) background).changeHealth(-10);
		assertTrue("Incorrect Health", ((LongBox) background).getHealth() == 600);
	}
	
	/**
	 * Test for World Entities, 'passable' parameter. To ensure that the 
	 * passable parameter, for interaction, is correctly set for buildings. 
	 */
	@Test
	public void worldEntityTest() {
		// Instantiate 3 new buildings
		WorldEntity entity1 = new Box(2, 3);
		WorldEntity entity2 = new House(4, 5);
		WorldEntity entity3 = new Observatory(1, 1);
		
		// Check all buildings instantiated have passable parameter set to 
		// false
		assertTrue("isPassable - box", false == (entity1.isPassable()));
		assertTrue("isPassable - box", false == (entity2.isPassable()));
		assertTrue("isPassable - box", false == (entity3.isPassable()));
		
	}

	/**
	 * Test the upgrade Barn method (increase storage capacity). Should throw 
	 * unsupported operation exception as not valid for farms.
	 */
	@Test
	public void FarmUpgradeStoreTest() {
		Farm entity = new Farm(1,1);
		entity.upgradeBarn(production.ORE, 10);
		assertEquals(entity.getStorage().toString(), "[(FOOD,50,0)]");
		entity.upgradeBarn(production.FOOD, 10);
		assertEquals(entity.getStorage().toString(), "[(FOOD,10,0)]");
	}
	
	/**
	 * Test the add Goods method, add stored resources to a building. Should 
	 * throw unsupported operation exception as not a supported method for 
	 * farms.
	 */
	@Test
	public void FarmAddStoreTest() {
		Farm entity = new Farm(1,1);
		entity.addGoods(production.TIMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(FOOD,50,0)]");
		entity.addGoods(production.FOOD, 10);
		assertEquals(entity.getStorage().toString(), "[(FOOD,50,10)]");
	}
		
	/**
	 * Test the upgrade Barn method (increase storage capacity). Should throw 
	 * unsupported operation exception as not valid for mines.
	 */
	@Test
	public void MineUpgradeStoreTest() {
		Mine entity = new Mine(1,1);
		entity.upgradeBarn(production.LUMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(ORE,50,0)]");
		entity.upgradeBarn(production.ORE, 10);
		assertEquals(entity.getStorage().toString(), "[(ORE,10,0)]");
	}
	
	/**
	 * Test the add Goods method, add stored resources to a building. Should 
	 * throw unsupported operation exception as not a supported method for 
	 * mines.
	 */
	@Test 
	public void MineAddStoreTest() {
		Mine entity = new Mine(1,1);
		entity.addGoods(production.TIMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(ORE,50,0)]");
		entity.addGoods(production.ORE, 10);
		assertEquals(entity.getStorage().toString(), "[(ORE,50,10)]");
	}
	
	/**
	 * Test the upgrade Barn method (increase storage capacity). Should throw 
	 * unsupported operation exception as not valid for quarries.
	 */
	@Test 
	public void QuarryUpgradeStoreTest() {
		Quarry entity = new Quarry(1,1);
		entity.upgradeBarn(production.LUMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(STONE,50,0)]");
		entity.upgradeBarn(production.STONE, 10);
		assertEquals(entity.getStorage().toString(), "[(STONE,10,0)]");
	}
	
	/**
	 * Test the add Goods method, add stored resources to a building. Should 
	 * throw unsupported operation exception as not a supported method for 
	 * quarries.
	 */
	@Test 
	public void QuarryAddStoreTest() {
		Quarry entity = new Quarry(1,1);
		entity.addGoods(production.TIMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(STONE,50,0)]");
		entity.addGoods(production.STONE, 10);
		assertEquals(entity.getStorage().toString(), "[(STONE,50,10)]");
	}
	
	/**
	 * Test the upgrade Barn method (increase storage capacity). Should throw 
	 * unsupported operation exception as not valid for sawmills.
	 */
	@Test 
	public void SawmillUpgradeStoreTest() {
		Sawmill entity = new Sawmill(1,1);
		entity.upgradeBarn(production.LUMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(TIMBER,50,0), (LUMBER,10,0)]");
		entity.upgradeBarn(production.ORE, 10);
		assertEquals(entity.getStorage().toString(), "[(TIMBER,50,0), (LUMBER,10,0)]");
		entity.upgradeBarn(production.TIMBER, 15);
		assertEquals(entity.getStorage().toString(), "[(TIMBER,15,0), (LUMBER,10,0)]");
	}
	
	/**
	 * Test the add Goods method, add stored resources to a building. Should 
	 * throw unsupported operation exception as not a supported method for 
	 * sawmills.
	 */
	@Test 
	public void SawmillsAddStoreTest() {
		Sawmill entity = new Sawmill(1,1);
		entity.addGoods(production.TIMBER, 10);
		assertEquals(entity.getStorage().toString(), "[(TIMBER,50,10), (LUMBER,50,0)]");
		entity.addGoods(production.FOOD, 10);
		assertEquals(entity.getStorage().toString(), "[(TIMBER,50,10), (LUMBER,50,0)]");
	}
}
