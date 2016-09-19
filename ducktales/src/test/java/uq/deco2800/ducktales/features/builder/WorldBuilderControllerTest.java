package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Test class for the WorldBuilderController class. 
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class WorldBuilderControllerTest {
		
	/**
	 * 
	 */
	@Test
	public void basicTest() {
		World mockWorld = Mockito.mock(World.class);
		WorldBuilderController testController = new WorldBuilderController();
		WorldBuilderRenderer testRenderer = Mockito.mock(WorldBuilderRenderer.class);
		
		assertEquals(testController.ENTITY, 2);
		assertEquals(testController.TILE, 1);
		
		testController.setWorld(mockWorld);
		
		assertEquals(mockWorld, testController.getWorld());
		
		testController.setRenderer(testRenderer);
		
		WorldBuilderController.setCurrentResource(ResourceType.BAKERY, 2);
		assertEquals(testController.getCurrentResource(), ResourceType.BAKERY);
		assertEquals(testController.getCurrentType(), 2);
		
		WorldBuilderController.setCurrentResource(ResourceType.GRASS_3, 1);
		assertEquals(testController.getCurrentResource(), ResourceType.GRASS_3);
		assertEquals(testController.getCurrentType(), 1);
		
		WorldBuilderController.setCurrentResource(ResourceType.HOUSE, 5);
		assertEquals(testController.getCurrentResource(), ResourceType.HOUSE);
		assertEquals(testController.getCurrentType(), 5);
	}
	
	@Test
	public void notifyTest() {
		World mockWorld = Mockito.mock(World.class);
		WorldBuilderController testController = new WorldBuilderController();
		WorldBuilderRenderer testRenderer = Mockito.mock(WorldBuilderRenderer.class);
		
		testController.notifyTileEndHovering();
		
		assertEquals(testController.ENTITY, 2);
		assertEquals(testController.TILE, 1);
		
		testController.setWorld(mockWorld);
		
		assertEquals(mockWorld, testController.getWorld());
		
		testController.setRenderer(testRenderer);
		
		WorldBuilderController.setCurrentResource(ResourceType.BAKERY, 2);
		assertEquals(testController.getCurrentResource(), ResourceType.BAKERY);
		assertEquals(testController.getCurrentType(), 2);
		
		WorldBuilderController.setCurrentResource(ResourceType.GRASS_3, 1);
		assertEquals(testController.getCurrentResource(), ResourceType.GRASS_3);
		assertEquals(testController.getCurrentType(), 1);
		
		WorldBuilderController.setCurrentResource(ResourceType.HOUSE, 5);
		assertEquals(testController.getCurrentResource(), ResourceType.HOUSE);
		assertEquals(testController.getCurrentType(), 5);
		
		testController.notifyTileClicked(1, 1);
		
		assertEquals(testController.ENTITY, 2);
		assertEquals(testController.TILE, 1);
		
		testController.setWorld(mockWorld);
		
		assertEquals(mockWorld, testController.getWorld());
		
		testController.setRenderer(testRenderer);
		
		WorldBuilderController.setCurrentResource(ResourceType.BAKERY, 2);
		assertEquals(testController.getCurrentResource(), ResourceType.BAKERY);
		assertEquals(testController.getCurrentType(), 2);
		
		WorldBuilderController.setCurrentResource(ResourceType.GRASS_3, 1);
		assertEquals(testController.getCurrentResource(), ResourceType.GRASS_3);
		assertEquals(testController.getCurrentType(), 1);
		
		WorldBuilderController.setCurrentResource(ResourceType.HOUSE, 5);
		assertEquals(testController.getCurrentResource(), ResourceType.HOUSE);
		assertEquals(testController.getCurrentType(), 5);	
		
		testController.notifyTileHovered(1, 1);
		
		assertEquals(testController.ENTITY, 2);
		assertEquals(testController.TILE, 1);
		
		testController.setWorld(mockWorld);
		
		assertEquals(mockWorld, testController.getWorld());
		
		testController.setRenderer(testRenderer);
		
		WorldBuilderController.setCurrentResource(ResourceType.BAKERY, 2);
		assertEquals(testController.getCurrentResource(), ResourceType.BAKERY);
		assertEquals(testController.getCurrentType(), 2);
		
		WorldBuilderController.setCurrentResource(ResourceType.GRASS_3, 1);
		assertEquals(testController.getCurrentResource(), ResourceType.GRASS_3);
		assertEquals(testController.getCurrentType(), 1);
		
		WorldBuilderController.setCurrentResource(ResourceType.HOUSE, 5);
		assertEquals(testController.getCurrentResource(), ResourceType.HOUSE);
		assertEquals(testController.getCurrentType(), 5);
	}
}
