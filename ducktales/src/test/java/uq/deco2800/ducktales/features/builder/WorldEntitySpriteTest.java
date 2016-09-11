package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Ignore;
import org.junit.Test;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceType;

// CURRENTLY DOESNT WORK YAY
public class WorldEntitySpriteTest {
	
	/**
	 * Basic test for the WorldEntitySprite class, checks all fields 
	 * and calls each method.
	 */
	@Ignore
	@Test
	public void basicTest(){
		// Need to be able to create internal graphics to get the test to run
		WorldEntitySprite bakery = new WorldEntitySprite(ResourceType.BAKERY);
		WorldEntitySprite dirt = new WorldEntitySprite(ResourceType.DIRT_1);
				
		// Use reflection to test protected method
		Field testAccess;
		try {
			// Check the quit field
			testAccess = WorldBuilderLoop.class.getDeclaredField("SCALE");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testAccess.getDouble(bakery) == 0.25);
				assertTrue("error", testAccess.getDouble(dirt) == 0.25);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			int[][] size = {{1,1,1},{1,1,1}};
			
			bakery.setTileUnitSize(size);
			dirt.setTileUnitSize(size);
			
			// Check the tick field
			testAccess = WorldBuilderLoop.class.getDeclaredField("setTileUnitSize");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testAccess.get(dirt) == size);
				assertTrue("error", testAccess.get(bakery) == size);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			assertTrue("error", dirt.getTileUnitSize(size) == size);
			assertTrue("error", bakery.getTileUnitSize(size) == size);
			
			// Check the world field
			testAccess = WorldBuilderLoop.class.getDeclaredField("getTileUnitSize");
			testAccess.setAccessible(true);
			try {
				// Currently null because there is no world in this 
				// stand alone test
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		Method test;
		try {
			int[][] size = {{1,1,1},{1,1,1}};
			test = WorldEntitySprite.class.getDeclaredMethod("setMouseEventHandler");
			test.setAccessible(true);
			test.invoke(dirt);
			test.invoke(bakery);
			assertTrue("error", dirt.getTileUnitSize(size) == size);
			assertTrue("error", bakery.getTileUnitSize(size) == size);
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
	}
}
