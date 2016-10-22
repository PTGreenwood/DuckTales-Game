package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.*;

import org.junit.Test;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Unit test class for WorldBuilderModel.
 * 
 * @author Oliver Yule
 *
 */
public class WorldBuilderModelTest {

	private static World testWorld1 = new World("TestWorld", 30, 30);
	private static World testWorld2 = new World("TestWorld", 30, 30);

	/**
	 * Test the getter and setter methods.
	 */
	@Test
	public void basicTest() {
		WorldBuilderModel testModel = WorldBuilderModel.getInstance();
		
		// Test setWorld(), getWorld()
		testModel.setWorld(testWorld1);
		assertTrue(testModel.getWorld() == testWorld1);
		assertFalse(testModel.getWorld() == testWorld2);
		testModel.setWorld(testWorld2);
		assertTrue(testModel.getWorld() == testWorld2);
		assertFalse(testModel.getWorld() == testWorld1);
		
		// Test setCurrentResource(), getCurrentResource(), getCurrentType()
		testModel.setCurrentResource(ResourceType.DUCK, WorldBuilderModel.ENTITY);
		assertTrue(testModel.getCurrentResource().equals(ResourceType.DUCK));
		assertTrue(testModel.getCurrentType() == WorldBuilderModel.ENTITY);
		testModel.setCurrentResource(ResourceType.GRASS_1, WorldBuilderModel.TILE);
		assertTrue(testModel.getCurrentResource().equals(ResourceType.GRASS_1));
		assertTrue(testModel.getCurrentType() == WorldBuilderModel.TILE);
	}
	
	/**
	 * Ensure that the class behaves properly as a singleton.
	 */
	@Test
	public void singletonTest() {
		WorldBuilderModel testModel1 = WorldBuilderModel.getInstance();
		assertTrue(testModel1.equals(WorldBuilderModel.getInstance()));
		WorldBuilderModel testModel2 = WorldBuilderModel.getInstance();
		
		// Ensure that expected results are returned from different references
		// to the WorldBuilderModel singleton.
		testModel1.setWorld(testWorld1);
		assertTrue(testModel2.getWorld() == testWorld1);
		assertTrue(WorldBuilderModel.getInstance().getWorld() == testWorld1);
	}

}
