package uq.deco2800.ducktales;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.entities.Entity;

public class EntityTest {
	
	@Test
	public void basicTest(){
		Entity entity1 = new Entity(2, 3, 1, 1);
		Entity entity2 = new Entity(4, 5, 1, 1);
		Entity entity3 = new Entity(1, 1, 1, 1);
		
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
	public void adjacentTest1(){
		Entity entity1 = new Entity(3, 7, 1, 2);
		Entity entity2 = new Entity(4, 6, 1, 2);
		
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(entity2));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(entity2));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(entity1));	
	}
	
	@Test
	public void adjacentTest2(){
		Entity foreground = new Entity(7, 3, 2, 1);
		Entity background = new Entity(6, 4, 2, 1);
		
		
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
		Entity foreground = new Entity(6, 7, 2, 1);
		Entity background = new Entity(7, 6, 2, 1);
		
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
