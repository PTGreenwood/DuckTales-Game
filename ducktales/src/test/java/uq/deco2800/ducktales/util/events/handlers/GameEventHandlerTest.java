package uq.deco2800.ducktales.util.events.handlers;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;
import org.junit.Ignore;

import uq.deco2800.ducktales.DuckTalesLauncher;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.builder.WorldBuilderLoop;
import uq.deco2800.ducktales.features.builder.WorldBuilderManager;
import uq.deco2800.ducktales.features.entities.worldentities.Bakery;
import uq.deco2800.ducktales.features.entities.worldentities.Constructor;

public class GameEventHandlerTest {
	
	/**
	 * Test having 1 building
	 */
	@Ignore
	@Test
	public void basicTest() {
		
		//GameManager gameTestManager = DuckTalesLauncher.main([]).GameEventHandlerTest;
		
		// test = new GameManager(null);
		//GameEventHandler testHandler = new GameEventHandler(test);
		
		Field testAccess;
		try {
			// Check the quit field
			
			
			testAccess = GameEventHandler.class.getDeclaredField("gameManager");
			testAccess.setAccessible(true);
					
//			try {
//				try {
//					//assertTrue("event handler incorrect", 
//						//	testAccess.get(testHandler).equals(test));
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}
//			} catch (IllegalArgumentException e) {
//				e.printStackTrace();
//			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
