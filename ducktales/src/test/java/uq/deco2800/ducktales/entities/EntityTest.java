package uq.deco2800.ducktales.entities;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.worldentities.Box;
import uq.deco2800.ducktales.entities.worldentities.House;
import uq.deco2800.ducktales.entities.worldentities.LongBox;

public class EntityTest {
	
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
	
	/**
	 * Test for the compareTo() method. Will check if all the values are equal
	 */
	@Test
	public void sameSpotTest() {
		Entity foreground = new LongBox(4, 3);
		Entity background = new LongBox(4, 3);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == 0);
		assertTrue("Entity 2 incorrect!", background.compareTo(foreground) == 0);
	}
	
	/**
	 * Testing the compareTo()method. Will check if the distance to the 
	 * top is different.
	 */
	@Test
	public void diffDistanceTopTest() {
		// Different because different sized buildings
		Entity foreground = new Box(4, 3);
		//Entity background2 = new LongBox(6, 7);
		Entity background = new LongBox(4, 3);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == 1);
		//assertTrue("background2 incorrect!", background2.compareTo(foreground) == 1);
		assertTrue("Entity 2 incorrect!", background.compareTo(foreground) == -1);
	}
	
	/**
	 * Testing the compareTo() method. Will check if the dtsance bottom is different.
	 */
	@Test
	public void diffDistanceBottomTest() {
		Entity foreground = new Box(3, 4);
		Entity background = new LongBox(4, 3);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == 1);
		assertTrue("Entity 2 incorrect!", background.compareTo(foreground) == -1);
	}
	
	/**
	 * Testing the compareTo() method. Cecking cases when the inside distances are
	 *  different.
	 */
	@Test
	public void diffDistanceInsideTest() {
		Entity foreground = new Box(5, 4);
		Entity foreground2 = new Box(1, 2);
		Entity background = new LongBox(4, 3);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == 1);
		assertTrue("forground2 incorrect", foreground2.compareTo(foreground) == 0);
		assertTrue("Entity 2 incorrect!", background.compareTo(foreground) == -1);
	}
	
	/**
	 * Test hashCode method, to be updated when the hashcode method is also 
	 * updated.
	 */
	@Test
	public void hashCodeTest() {
		Entity box1 = new Box(5, 4);
				
		assertTrue("box1 incorrect!", box1.hashCode() == 4);
	}
	
	/**
	 * Test getX and getY methods
	 */
	@Test
	public void getXgetYTest() {
		Entity box = new Box(5, 4);
		Entity background = new LongBox(4, 3);
			
		assertTrue("box incorrect!", box.getX() == 5);
		assertTrue("background incorrect", background.getX() == 4);
		assertTrue("box incorrect!", box.getY() == 4);
		assertTrue("background incorrect", background.getY() == 3);
	}
	
	/**
	 * Test getX and getY methods
	 */
	@Test
	public void getXLengthgetYLengthTest() {
		Entity box = new Box(5, 4);
		Entity background = new LongBox(4, 3);
			
		assertTrue("box incorrect!", box.getXLength() == 1);
		assertTrue("background incorrect", background.getXLength() == 2);
		assertTrue("box incorrect!", box.getYLength() == 1);
		assertTrue("background incorrect", background.getYLength() == 1);
	}
	
	/**
	 * Test getType
	 */
	@Test
	public void getTypeTest() {
		Entity box = new Box(5, 4);
		Entity background = new House(4, 3);
			
		assertTrue("box incorrect!", box.getType().toString().equals("BOX"));
		assertTrue("background incorrect", background.getType().toString().equals("HOUSE"));
	}
}
