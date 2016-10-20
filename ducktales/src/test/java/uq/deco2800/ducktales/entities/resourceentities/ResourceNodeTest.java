package uq.deco2800.ducktales.entities.resourceentities;

import static org.junit.Assert.assertTrue;
import static uq.deco2800.ducktales.resources.ResourceType.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.entities.resourceentities.*;
import uq.deco2800.ducktales.resources.ResourceType;

public class ResourceNodeTest {
	@Test
	public void TreeTest(){
		final ResourceType[] SUMMER_TYPES = {TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER};
		Tree entity1 = new Tree(2, 3, SUMMER_TYPES);
		Tree entity2 = new Tree(4, 5, SUMMER_TYPES);
		Tree entity3 = new Tree(1, 1, SUMMER_TYPES);
		
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		// Check entity functionality still works
		Collections.sort(entities);
		
		assertTrue("Entity 0 incorrect!", entities.get(0).equals(entity3));
		assertTrue("Entity 1 incorrect!", entities.get(1).equals(entity1));
		assertTrue("Entity 2 incorrect!", entities.get(2).equals(entity2));
		
		//Test getValue
		assertTrue("Correct default value", entity1.getValue() == ResourceEntity.DEFVALUE 
				|| entity1.getValue() == 2*ResourceEntity.DEFVALUE );
		
		//Test increaseValue
		entity2.increaseValue(50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.DEFVALUE + 50 
				|| entity2.getValue() == 2*ResourceEntity.DEFVALUE + 50);		
		entity2.increaseValue(0);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.DEFVALUE + 50 
				|| entity2.getValue() == 2*ResourceEntity.DEFVALUE + 50);		
		entity2.increaseValue(-50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.DEFVALUE + 50 
				|| entity2.getValue() == 2*ResourceEntity.DEFVALUE + 50);
		
		//Test decrease Value
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.DEFVALUE - 50 
				|| entity3.getValue() == 2*ResourceEntity.DEFVALUE - 50);		
		entity3.decreaseValue(0);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.DEFVALUE - 50 
				|| entity3.getValue() == 2*ResourceEntity.DEFVALUE - 50);		
		entity3.decreaseValue(-50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.DEFVALUE - 50 
				|| entity3.getValue() == 2*ResourceEntity.DEFVALUE - 50);
		
		
		// Test getx/gety
		assertTrue("Correct xLength", entity3.getXLength() == 1);
		assertTrue("Correct xLength", entity3.getYLength() == 1);
	}
	
	@Test
	public void RockTest(){
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
		
		//Test getValue
		assertTrue("Correct default value", entity1.getValue() == ResourceEntity.DEFVALUE 
				|| entity1.getValue() == 2*ResourceEntity.DEFVALUE );
		
		//Test increaseValue
		entity2.increaseValue(50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.DEFVALUE + 50 
				|| entity2.getValue() == 2*ResourceEntity.DEFVALUE + 50);		
		entity2.increaseValue(0);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.DEFVALUE + 50 
				|| entity2.getValue() == 2*ResourceEntity.DEFVALUE + 50);		
		entity2.increaseValue(-50);
		assertTrue("Correct value", entity2.getValue() == ResourceEntity.DEFVALUE + 50 
				|| entity2.getValue() == 2*ResourceEntity.DEFVALUE + 50);
		
		//Test decrease Value
		entity3.decreaseValue(50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.DEFVALUE - 50 
				|| entity3.getValue() == 2*ResourceEntity.DEFVALUE - 50);		
		entity3.decreaseValue(0);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.DEFVALUE - 50 
				|| entity3.getValue() == 2*ResourceEntity.DEFVALUE - 50);		
		entity3.decreaseValue(-50);
		assertTrue("Correct value", entity3.getValue() == ResourceEntity.DEFVALUE - 50 
				|| entity3.getValue() == 2*ResourceEntity.DEFVALUE - 50);
		
		
		// Test getx/gety
		assertTrue("Correct xLength", entity3.getXLength() == 1);
		assertTrue("Correct xLength", entity3.getYLength() == 1);
	}
	
	@Test
	public void RareTest(){
		ResourceType[] TYPES1 = {TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER};
		ResourceType[] TYPES2 = {ROCK_1, ROCK_2};
		ResourceType type1 = ResourceEntity.rare(TYPES1);
		ResourceType type2 = ResourceEntity.rare(TYPES2);
		assertTrue("Valid ResourceType", type1.equals(TREE_1_SUMMER) 
				|| type1.equals(TREE_2_SUMMER) 
				|| type1.equals(TREE_3_SUMMER));
		assertTrue("Valid ResourceType", type2.equals(ROCK_1) 
				|| type2.equals(ROCK_2));
	}
}