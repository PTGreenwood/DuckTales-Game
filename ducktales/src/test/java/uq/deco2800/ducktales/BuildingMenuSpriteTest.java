package uq.deco2800.ducktales;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Barn;
import uq.deco2800.ducktales.features.entities.worldentities.Box;
import uq.deco2800.ducktales.features.entities.worldentities.Cemetery;
import uq.deco2800.ducktales.features.entities.worldentities.Farm;
import uq.deco2800.ducktales.features.entities.worldentities.Forge;
import uq.deco2800.ducktales.features.entities.worldentities.Hospital;
import uq.deco2800.ducktales.features.entities.worldentities.House;
import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.worldentities.LongBox;
import uq.deco2800.ducktales.features.entities.worldentities.Observatory;
import uq.deco2800.ducktales.features.entities.worldentities.Sawmill;
import uq.deco2800.ducktales.features.entities.worldentities.WorldEntity;

public class BuildingMenuSpriteTest {
	
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == (2));
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time", entity2.timeToBuild() == 2);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == (2));
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 2);
		assertTrue("Wrong time", entity2.timeToBuild() == 2);
	}
	
	@Test
	public void barnTest(){
		Barn entity1 = new Barn(2, 3);
		Barn entity2 = new Barn(4, 5);
		Barn entity3 = new Barn(1, 1);
		
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 9);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 9);
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 3);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildWood() == 10);
		assertTrue("Wrong time", entity2.timeToBuild() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildWood() == 10);
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
		assertTrue(String.valueOf(entity1.resourcesReturnStone()), entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 4);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue(String.valueOf(entity1.resourcesReturnStone()), entity1.resourcesReturnStone() == 2);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 4);
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnStone() == 1);
		assertTrue("Wrong resources to build", entity3.resourcesBuildWood() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 2);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnStone() == 1);
		assertTrue("Wrong resources to build", entity3.resourcesBuildWood() == 4);
		assertTrue("Wrong time", entity2.timeToBuild() == 2);
	}
	
	@Test
	public void farmTest(){
		Farm entity1 = new Farm(2, 3);
		Farm entity2 = new Farm(4, 5);
		Farm entity3 = new Farm(1, 1);
		
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 8);
		assertTrue("Wrong time", entity2.timeToBuild() == 9);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 8);
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
		assertTrue("Wrong returned resources", entity1.resourcesReturnStone() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 10);
		assertTrue("Wrong time", entity2.timeToBuild() == 3);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnStone() == 5);
		assertTrue("Wrong resources to build", entity3.resourcesBuildStone() == 10);
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
		assertTrue(String.valueOf(entity1.resourcesReturnWood()), entity1.resourcesReturnWood() == 4);
		assertTrue("Wrong resources to build", entity3.resourcesBuildWood() == 8);
		assertTrue("Wrong time", entity2.timeToBuild() == 5);
		
		// Check if nothing has changed after call tick()
		entity1.tick();
		entity2.tick();
		entity3.tick();
		assertTrue("Wrong returned resources", entity1.resourcesReturnWood() == 4);
		assertTrue("Wrong resources to build", entity3.resourcesBuildWood() == 8);
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
	
	@Test
	public void worldEntityTest() {
		WorldEntity entity1 = new Box(2, 3);
		WorldEntity entity2 = new House(4, 5);
		WorldEntity entity3 = new Observatory(1, 1);
		
		assertTrue("isPassable - box", false == (entity1.isPassable()));
		assertTrue("isPassable - box", false == (entity2.isPassable()));
		assertTrue("isPassable - box", false == (entity3.isPassable()));
		
	}
}
