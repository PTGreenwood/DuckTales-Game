package uq.deco2800.ducktales.entities.resourceentities;

import static org.junit.Assert.assertTrue;
import static uq.deco2800.ducktales.resources.ResourceType.ROCK_1;
import static uq.deco2800.ducktales.resources.ResourceType.ROCK_2;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_1_SUMMER;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_2_SUMMER;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_3_SUMMER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.resourceentities.*;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * 
 * @author Jake Wood, Andrew Georgiou
 *
 *         Tests the creation of all resource types and their behaviors.
 *
 */
public class ResourceNodeTest {

	/**
	 * 
	 * Tests the creation of the tree type.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void TreeTest() throws Exception {
		Tree entity1 = new Tree(2, 3);
		Tree entity2 = new Tree(4, 5);
		Tree entity3 = new Tree(1, 1);

		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);

		// Check entity functionality still works
		Collections.sort(entities);

		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));

		// Test getValue
		assertTrue("Correct default value",
				entity1.getValue() == ResourceEntity.defaultValue || entity1.getValue() == 2 * ResourceEntity.defaultValue);

		// Test getx/gety
				assertTrue("Correct xLength", entity3.getXLength() == 1);
				assertTrue("Correct xLength", entity3.getYLength() == 1);
				
		// Test valid values
		entity2.increaseValue(50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		
		// Test invalid values
		entity2.increaseValue(0);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity2.increaseValue(-50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity3.decreaseValue(0);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity3.decreaseValue(-50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);		
	}

	/**
	 * 
	 * Tests the creation of the Rock type of resource.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void RockTest() throws Exception {
		Rock entity1 = new Rock(2, 3);
		Rock entity2 = new Rock(4, 5);
		Rock entity3 = new Rock(1, 1);

		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);

		// Check entity functionality still works
		Collections.sort(entities);

		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));

		// Test getValue
		assertTrue("Correct default value",
				entity1.getValue() == ResourceEntity.defaultValue || entity1.getValue() == 2 * ResourceEntity.defaultValue);

		// Test getx/gety
		assertTrue("Correct xLength", entity3.getXLength() == 1);
		assertTrue("Correct xLength", entity3.getYLength() == 1);
		
		// Test valid values
		entity2.increaseValue(50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		
		// Test invalid values
		entity2.increaseValue(0);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity2.increaseValue(-50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(0);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity3.decreaseValue(-50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
	}

	/**
	 * 
	 * Tests the creation of the Food & Meat type of resource.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void FoodTest() throws Exception {
		Food entity1 = new Meat(2, 3, null);
		Food entity2 = new Meat(4, 5, null);
		Food entity3 = new Meat(1, 1, null);

		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);

		// Check entity functionality still works
		Collections.sort(entities);

		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));

		// Test getValue
		assertTrue("Correct default value",
				entity1.getValue() == ResourceEntity.defaultValue || entity1.getValue() == 2 * ResourceEntity.defaultValue);

		// Test getx/gety
		assertTrue("Correct xLength", entity3.getXLength() == 1);
		assertTrue("Correct xLength", entity3.getYLength() == 1);
		
		// Test valid values
		entity2.increaseValue(50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		
		// Test invalid values
		entity2.increaseValue(0);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity2.increaseValue(-50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(0);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity3.decreaseValue(-50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
	}

	/**
	 * 
	 * Tests the creation of the Rock type of resource.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void DroppableResourceEntityTest() throws Exception {
		DroppableResourceEntity entity1 = new Wool(2, 3, null);
		DroppableResourceEntity entity2 = new Wool(4, 5, null);
		DroppableResourceEntity entity3 = new Wool(1, 1, null);
		DroppableResourceEntity entity4 = new Feather(2, 3, null);
		DroppableResourceEntity entity5 = new Feather(4, 5, null);
		DroppableResourceEntity entity6 = new Feather(1, 1, null);

		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		entities.add(entity4);
		entities.add(entity5);
		entities.add(entity6);

		// Check entity functionality still works
		Collections.sort(entities);

		// Test getValue
		assertTrue("Correct default value",
				entity1.getValue() == ResourceEntity.defaultValue || entity1.getValue() == 2 * ResourceEntity.defaultValue);
		assertTrue("Correct default value",
				entity4.getValue() == ResourceEntity.defaultValue || entity4.getValue() == 2 * ResourceEntity.defaultValue);

		// Test valid values
		entity2.increaseValue(50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity5.increaseValue(50);
		assertTrue("Correct value", entity5.getValue() == ResourceEntity.defaultValue + 50
				|| entity5.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity6.decreaseValue(50);
		assertTrue("Correct value", entity6.getValue() == ResourceEntity.defaultValue - 50
				|| entity6.getValue() == 2 * ResourceEntity.defaultValue - 50);		
		
		// Test invalid values
		
		
		entity2.increaseValue(0);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity2.increaseValue(-50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.defaultValue + 50
				|| entity2.getValue() == 2 * ResourceEntity.defaultValue + 50);		
		entity5.increaseValue(0);
		assertTrue("Correct value", entity5.getValue() == ResourceEntity.defaultValue + 50
				|| entity5.getValue() == 2 * ResourceEntity.defaultValue + 50);
		entity5.increaseValue(-50);
		assertTrue("Correct value", entity5.getValue() == ResourceEntity.defaultValue + 50
				|| entity5.getValue() == 2 * ResourceEntity.defaultValue + 50);
		
		// Test invalid values		
		entity3.decreaseValue(0);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity3.decreaseValue(-50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.defaultValue - 50
				|| entity3.getValue() == 2 * ResourceEntity.defaultValue - 50);		
		entity6.decreaseValue(0);
		assertTrue("Correct value", entity6.getValue() == ResourceEntity.defaultValue - 50
				|| entity6.getValue() == 2 * ResourceEntity.defaultValue - 50);
		entity6.decreaseValue(-50);
		assertTrue("Correct value", entity6.getValue() == ResourceEntity.defaultValue - 50
				|| entity6.getValue() == 2 * ResourceEntity.defaultValue - 50);
	}

	@Test
	public void RareTest() {
		ResourceType[] TYPES1 = { TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER };
		ResourceType[] TYPES2 = { ROCK_1, ROCK_2 };
		ResourceType type1 = ResourceEntity.rare(TYPES1);
		ResourceType type2 = ResourceEntity.rare(TYPES2);
		assertTrue("Valid ResourceType",
				type1.equals(TREE_1_SUMMER) || type1.equals(TREE_2_SUMMER) || type1.equals(TREE_3_SUMMER));
		assertTrue("Valid ResourceType", type2.equals(ROCK_1) || type2.equals(ROCK_2));
	}
}