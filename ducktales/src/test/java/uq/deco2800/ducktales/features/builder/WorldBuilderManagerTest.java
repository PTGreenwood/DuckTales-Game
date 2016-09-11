package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceType;

public class WorldBuilderManagerTest {
	
	/**
	 * Basic test for the WorldEntitySprite class, checks all fields 
	 * and calls each method.
	 */
	@Test
	public void basicTest(){
		
		Method test;
		try {
			Constructor<WorldBuilderManager> testManager = WorldBuilderManager.class.getDeclaredConstructor();
			testManager.setAccessible(true);
			WorldBuilderManager manager = testManager.newInstance(); 
					
			//World world = new World("test", 40, 40);
			
			//manager.setWorld(world);
			
			assertTrue("error", manager.getCurrentType() == 0);
						
//			// Use reflection to test protected method
//			Field testAccess;
//			try {
//				// Check the quit field
//				testAccess = WorldBuilderManager.class.getDeclaredField("world");
//				testAccess.setAccessible(true);
//				try {
//					assertTrue("error", world == testAccess.get(world));
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}			
//		}
//		catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
