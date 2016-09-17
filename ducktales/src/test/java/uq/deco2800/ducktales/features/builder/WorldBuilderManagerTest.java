package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Test class for the WorldBuilderManager class.
 * 
 * @author Gabrielle Hodge
 *
 */

public class WorldBuilderManagerTest {
	
	ResourceType testResource;
	
	@Mock
	World mockWorld;
	ResourceSpriteRegister mockReg;
	WorldBuilderRenderer mockRenderer;
	
	/**
	 * Basic test for the WorldBuilderManager class, checks the set and get world methods.
	 */
	@Test
	public void worldTest(){
		mockWorld = Mockito.mock(World.class);
		
		WorldBuilderManager testManager = WorldBuilderManager.getInstance();
		
		testManager.setWorld(mockWorld);
		
		assertEquals(testManager.getWorld(), mockWorld);
					
		// Use reflection to test protected field
		Field testAccess;
		try {
			// Check the world field
			testAccess = WorldBuilderManager.class.getDeclaredField("world");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", mockWorld == testAccess.get(testManager));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Basic test for the WorldEntitySprite class, checks the set and get renderer methods.
	 */
	@Test
	public void rendererTest(){
		mockRenderer = Mockito.mock(WorldBuilderRenderer.class);
		
		WorldBuilderManager testManager = WorldBuilderManager.getInstance();
		
		testManager.setRenderer(mockRenderer);
					
		// Use reflection to test protected field
		Field testAccess;
		try {
			// Check the renderer field
			testAccess = WorldBuilderManager.class.getDeclaredField("renderer");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", mockRenderer == testAccess.get(testManager));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Basic test for the WorldEntitySprite class, checks the set and get resource methods.
	 */
	@Test
	public void resourceTest(){
		mockRenderer = Mockito.mock(WorldBuilderRenderer.class);
		testResource = ResourceType.BAKERY;
		
		WorldBuilderManager testManager = WorldBuilderManager.getInstance();
		
		testManager.setRenderer(mockRenderer);
		
		// Test building resource
		testManager.setCurrentResource(testResource, 2);
		
		assertEquals(testManager.getCurrentResource(), testResource);
		assertEquals(testManager.getCurrentType(), 2);
					
		// Use reflection to test protected field
		Field testAccess;
		try {
			// Check the renderer field
			testAccess = WorldBuilderManager.class.getDeclaredField("currentResource");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testResource == testAccess.get(testManager));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Basic test for the WorldEntitySprite class, checks the set and get resource methods.
	 */
	@Test
	public void resourceTileTest(){
		mockRenderer = Mockito.mock(WorldBuilderRenderer.class);
		testResource = ResourceType.DIRT_3;
		
		WorldBuilderManager testManager = WorldBuilderManager.getInstance();
		
		testManager.setRenderer(mockRenderer);
		
		// Test tile resource
		testManager.setCurrentResource(testResource, 1);
		
		assertEquals(testManager.getCurrentResource(), testResource);
		assertEquals(testManager.getCurrentType(), 1);
					
		// Use reflection to test protected field
		Field testAccess;
		try {
			// Check the renderer field
			testAccess = WorldBuilderManager.class.getDeclaredField("currentResource");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testResource == testAccess.get(testManager));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Basic test for the WorldEntitySprite class, checks the set and get 
	 * resource for an invalid entity number.
	 */
	@Test
	public void resourceInvalidTest(){
		mockRenderer = Mockito.mock(WorldBuilderRenderer.class);
		testResource = ResourceType.DIRT_3;
		
		WorldBuilderManager testManager = WorldBuilderManager.getInstance();
		
		testManager.setRenderer(mockRenderer);
		
		// Test tile resource
		testManager.setCurrentResource(testResource, 4);
		assertEquals(testManager.getCurrentResource(), testResource);
		assertEquals(testManager.getCurrentType(), 4);
					
		// Use reflection to test protected field
		Field testAccess;
		try {
			// Check the renderer field
			testAccess = WorldBuilderManager.class.getDeclaredField("currentResource");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testResource == testAccess.get(testManager));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
