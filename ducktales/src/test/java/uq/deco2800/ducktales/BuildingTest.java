package uq.deco2800.ducktales;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.entities.worldentities.Bakery;
import uq.deco2800.ducktales.entities.worldentities.Box;
import uq.deco2800.ducktales.entities.worldentities.Cemetery;
import uq.deco2800.ducktales.entities.worldentities.Farmhouse;
import uq.deco2800.ducktales.entities.worldentities.Forge;
import uq.deco2800.ducktales.entities.worldentities.Hospital;
import uq.deco2800.ducktales.entities.worldentities.House;
import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.worldentities.LongBox;
import uq.deco2800.ducktales.entities.worldentities.Observatory;
import uq.deco2800.ducktales.entities.worldentities.Sawmill;

public class BuildingTest {
	
	@Test
	public void basicTest(){
		Entity entity1 = new Box(2, 3);
		Entity entity2 = new Box(4, 5);
		Entity entity3 = new Box(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
	}
	
	@Test
	public void houseTest(){
		House entity1 = new House(2, 3);
		House entity2 = new House(4, 5);
		House entity3 = new House(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == (2));
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 5);
		assertTrue("Wrong time", entity2.timeToBuild() == 2);
	}
	
	@Test
	public void sawmillTest(){
		Sawmill entity1 = new Sawmill(2, 3);
		Sawmill entity2 = new Sawmill(4, 5);
		Sawmill entity3 = new Sawmill(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 10);
		assertTrue("Wrong time", entity2.timeToBuild() == 3);
	}
	
	@Test
	public void observatoryTest(){
		Observatory entity1 = new Observatory(2, 3);
		Observatory entity2 = new Observatory(4, 5);
		Observatory entity3 = new Observatory(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 6);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 12);
		assertTrue("Wrong time", entity2.timeToBuild() == 5);
	}
	
	@Test
	public void bakeryTest(){
		Bakery entity1 = new Bakery(2, 3);
		Bakery entity2 = new Bakery(4, 5);
		Bakery entity3 = new Bakery(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 7);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 14);
		assertTrue("Wrong time", entity2.timeToBuild() == 4);
	}
	
	@Test
	public void cemeteryTest(){
		Cemetery entity1 = new Cemetery(2, 3);
		Cemetery entity2 = new Cemetery(4, 5);
		Cemetery entity3 = new Cemetery(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 3);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 7);
		assertTrue("Wrong time", entity2.timeToBuild() == 2);
	}
	
	@Test
	public void farmhouseTest(){
		Farmhouse entity1 = new Farmhouse(2, 3);
		Farmhouse entity2 = new Farmhouse(4, 5);
		Farmhouse entity3 = new Farmhouse(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 9);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 18);
		assertTrue("Wrong time", entity2.timeToBuild() == 9);
	}
	
	@Test
	public void forgeTest(){
		Forge entity1 = new Forge(2, 3);
		Forge entity2 = new Forge(4, 5);
		Forge entity3 = new Forge(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 8);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 16);
		assertTrue("Wrong time", entity2.timeToBuild() == 3);
	}
	
	@Test
	public void hospitalTest(){
		Hospital entity1 = new Hospital(2, 3);
		Hospital entity2 = new Hospital(4, 5);
		Hospital entity3 = new Hospital(1, 1);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		// Check correct resources and time
		assertTrue("Wrong returned resources", entity1.resourcesReturn() == 8);
		assertTrue("Wrong resources to build", entity3.resourcesBuild() == 17);
		assertTrue("Wrong time", entity2.timeToBuild() == 5);
	}
	
//	@Test
//	public void adjacentTest1(){
//		Entity entity1 = new Entity(3, 7, 1, 2);
//		Entity entity2 = new Entity(4, 6, 1, 2);
//		
//		
//		List<Entity> entities = new ArrayList<Entity>();
//		entities.add(entity1);
//		entities.add(entity2);
//		
//		assertTrue("Entity 1 incorrect!", entities.get(0).equals(entity1));
//		assertTrue("Entity 2 incorrect!", entities.get(1).equals(entity2));	
//		
//		Collections.sort(entities);
//		
//		assertTrue("Entity 1 incorrect!", entities.get(0).equals(entity2));
//		assertTrue("Entity 2 incorrect!", entities.get(1).equals(entity1));	
//	}
	
	@Test
	public void adjacentTest2(){
		Entity foreground = new LongBox(7, 3);
		Entity background = new LongBox(6, 4);
		
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);

		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(background));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground));	
	}

	
	@Test
	public void adjacentTestMiddle(){
		Entity foreground = new LongBox(6, 7);
		Entity background = new LongBox(7, 6);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(background));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground));	
	}
}
