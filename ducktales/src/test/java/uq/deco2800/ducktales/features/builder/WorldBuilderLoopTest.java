package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Ignore;
import org.junit.Test;

import uq.deco2800.ducktales.World;

/**
 * Test class for the WorldBuilderLoop class. 
 * 
 * @author Gabbi
 *
 */

public class WorldBuilderLoopTest {
	
	/**
	 * Basic test for the WorldBuilderLoop class, checks all fields 
	 * and calls each method.
	 */
	@Ignore
	@Test
	public void basicTest(){
		AtomicBoolean bool = new AtomicBoolean(true);
		WorldBuilderLoop test = new WorldBuilderLoop(bool, 3);
		// Warning as only used within try/catch block
		@SuppressWarnings("unused")
		World world = WorldBuilderModel.getInstance().getWorld();
		
		// Use reflection to test protected method
		Field testAccess;
		try {
			// Check the quit field
			testAccess = WorldBuilderLoop.class.getDeclaredField("quit");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testAccess.get(test).equals(bool));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			// Check the tick field
			testAccess = WorldBuilderLoop.class.getDeclaredField("tick");
			testAccess.setAccessible(true);
			try {
				assertTrue("error", testAccess.getInt(test) == (3));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			// Check the world field
			testAccess = WorldBuilderLoop.class.getDeclaredField("world");
			testAccess.setAccessible(true);
			try {
				// Currently null because there is no world in this 
				// stand alone test
				assertTrue("error", testAccess.get(test) == null);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
			
		// Check after calling run()
		test.run();
		
		// Use reflection to test private fields
		Field testAccess2;
		try {
			// Check the quit field
			testAccess2 = WorldBuilderLoop.class.getDeclaredField("quit");
			testAccess2.setAccessible(true);
			try {
				assertTrue("error", testAccess2.get(test).equals(bool));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			// Check the tick field
			testAccess2 = WorldBuilderLoop.class.getDeclaredField("tick");
			testAccess2.setAccessible(true);
			try {
				assertTrue("error", testAccess2.getInt(test) == (3));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			// Check the world field
			testAccess2 = WorldBuilderLoop.class.getDeclaredField("world");
			testAccess2.setAccessible(true);
			try {
				// Currently null because there is no world in this 
				// stand alone test
				assertTrue("error", testAccess2.get(test) == null);
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
