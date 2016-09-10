package uq.deco2800.ducktales.entities;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Box;
import uq.deco2800.ducktales.features.entities.worldentities.House;
import uq.deco2800.ducktales.features.entities.worldentities.LongBox;
import uq.deco2800.ducktales.features.entities.worldentities.Observatory;
import uq.deco2800.ducktales.resources.ResourceType;

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
		Entity background2 = new LongBox(6, 7);
		Entity background = new LongBox(4, 3);
				
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(background);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(background));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == 1);
		assertTrue("background2 incorrect!", background2.compareTo(foreground) == 1);
		assertTrue("Entity 2 incorrect!", background.compareTo(foreground) == -1);
	}
	
	/**
	 * Testing the compareTo() method. Will check if the distance bottom is different.
	 */
	@Test
	public void diffDistanceBottomTest() {
		Entity foreground = new Box(3, 4);
		Entity foreground2 = new Box(1, 7); //Distance Bottom = 5
		Entity background = new LongBox(4, 4);
		Entity background2 = new Box(8, 9); //Distance Bottom = 0
		Entity background3 = new LongBox(16, 2); //Distance Bottom = 0
		Entity background4 = new LongBox(3, 6); //Distance Bottom = 0
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(foreground2);
		entities.add(background);
		entities.add(background2);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground2));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == -1);
		assertTrue("Entity 1 incorrect!", background.compareTo(foreground) == 1);
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background3) == -1);
		assertTrue("Entity 1 incorrect!", background3.compareTo(foreground) == 1);
		assertTrue("Entity 1 incorrect!", background3.compareTo(foreground2) == 1);
		assertTrue("Entity 1 incorrect!", foreground2.compareTo(background3) == -1);
		assertTrue("Entity 2 incorrect!", background2.compareTo(foreground2) == 1);
		assertTrue("Entity 2 incorrect!", foreground2.compareTo(foreground) == 1);
		assertTrue("Entity 2 incorrect!", background2.compareTo(background3) == -1);
		assertTrue("Entity 2 incorrect!", background2.compareTo(background3) == -1);
		assertTrue("Entity 2 incorrect!", background2.compareTo(background4) == 1);
		assertTrue("Entity 2 incorrect!", foreground2.compareTo(background4) == -1);
	}
	
	/**
	 * Testing the compareTo() method. Checking cases when the inside distances are
	 *  different.
	 */
	@Test
	public void diffDistanceInsideTest() {
		Entity foreground = new Box(5, 4); //Distance Inside = 0
		Entity foreground2 = new Box(1, 7); //Distance Inside = 5
		Entity background = new LongBox(4, 3); //Distance Inside = -1
		Entity background2 = new Box(5, 5); //Distance Inside = 0
		Entity background4 = new LongBox(5, 2); //Distance Bottom = 0
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(foreground);
		entities.add(foreground2);
		entities.add(background);
		entities.add(background2);
		
		assertTrue("Entity 1 incorrect!", entities.get(0).equals(foreground));
		assertTrue("Entity 2 incorrect!", entities.get(1).equals(foreground2));	
		
		Collections.sort(entities);
		
		assertTrue("Entity 1 incorrect!", foreground.compareTo(background) == 1);
		assertTrue("Entity 1 incorrect!", background.compareTo(foreground) == -1);
		assertTrue("Entity 1 incorrect!", foreground.compareTo(foreground) == 0);
		assertTrue("Entity 1 incorrect!", foreground.compareTo(foreground2) == 1);
		assertTrue("forground2 incorrect", foreground2.compareTo(background) == 1);
		assertTrue("forground2 incorrect", background2.compareTo(background) == 1);
		assertTrue("forground2 incorrect", background2.compareTo(foreground) == 1);
		assertTrue(String.valueOf(background2.compareTo(background)), background.compareTo(background2) == -1);
		assertTrue("forground2 incorrect", background4.compareTo(background) == 1);
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
			
		assertTrue(String.valueOf(box.getXLength()), box.getXLength() == 1);
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
	
	/**
	 * Test updateType
	 */
	@Test
	public void getUpdateTest() {
		Entity box = new Box(5, 4);
		Entity background = new House(4, 3);
			
		// Use reflection to test protected method
		Method test;
		try {
			test = Entity.class.getDeclaredMethod("updateType", ResourceType.class);
			test.setAccessible(true);
			test.invoke(box, ResourceType.HOUSE);
			test.invoke(background, ResourceType.FARM);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		assertTrue("box incorrect!", box.getType().toString().equals("HOUSE"));
		assertTrue("background incorrect", background.getType().toString().equals("FARM"));
	}
	
	/**
	 * Test getDistanceInside
	 */
	@Test
	public void getDistanceInsideTest() {
		Entity box = new Box(5, 4);
		Entity background = new House(4, 4);
			
		assertTrue("box incorrect!", box.getDistanceInside() == 0);
		assertTrue("background incorrect", background.getDistanceInside() == -2);
	}
	
	/**
	 * Test getDistanceTop
	 */
	@Test
	public void getDistanceTopTest() {
		Entity box = new Box(5, 4);
		Entity background = new House(4, 4);
			
		assertTrue("box incorrect!", box.getDistanceTop() == 7);
		assertTrue("background incorrect", background.getDistanceTop() == 4);
	}
	
	/**
	 * Test getDistanceBottom
	 */
	@Test
	public void getDistanceBottomTest() {
		Entity box = new Box(5, 4);
		Entity background = new House(4, 4);
			
		assertTrue("box incorrect!", box.getDistanceBottom() == 9);
		assertTrue("background incorrect", background.getDistanceBottom() == 8);
	}
	
	/**
	 * Test toString
	 */
	@Test
	public void toStringTest() {
		Entity box = new Box(5, 4);
		Entity background = new House(4, 4);
		Entity bakery = new Bakery(1, 2);
		Entity observatory = new Observatory(5, 8); 
			
		assertTrue(box.toString(), box.toString().equals("[5.000000 4.000000 1 1    0.000000]"));
		assertTrue("background incorrect", background.toString().equals("[4.000000 4.000000 2 2    -2.000000]"));
		assertTrue(bakery.toString(), bakery.toString().equals("[1.000000 2.000000 2 2    -1.000000]"));
		assertTrue(observatory.toString(), observatory.toString().equals("[5.000000 8.000000 2 2    1.000000]"));
	}
	
	/**
	 * Equals() test
	 */
	@Test
	public void equalTest() {
		Entity box = new Box(5, 4);
		Entity house = new House(4, 4);
		Entity house2 = new House(6,7);
		Object object = new Object();
		
		assertTrue("both entity, but diff", house.equals(box)== false);
		
		assertTrue("non entity", house.equals(object) == false);
		
		assertTrue("diff houses", house.equals(house2) == false);
		
		assertTrue("same", house.equals(house) == true);
		
	}
	
	
	
}
