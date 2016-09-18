package uq.deco2800.ducktales.util.events.handlers;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;
import org.mockito.Mockito;

import uq.deco2800.ducktales.GameManager;

/**
 * Test class for the GameEventHandler. Uses mockito to create dummy 
 * GameManager instance.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class GameEventHandlerTest {
	
	/**
	 * Test GameEventHandler. Basic test, check if the gameManager is accessed 
	 * and set properly
	 */
	@Test
	public void basicTest() {
		
		// Create a mocked GameManager
		GameManager gameTestManager = Mockito.mock(GameManager.class);
		
		// Create a new GameEventHandler using mocked GameManager
		GameEventHandler testHandler = new GameEventHandler(gameTestManager);
		
		//Use reflection to access protected gameManager parameter
		Field field;
		try {
			try {
				// Access gameManager field and set to accessible
				field = GameEventHandler.class.getDeclaredField("gameManager");
				field.setAccessible(true);
				
				try {
					// Get the value of gameManager parameter
					GameManager value = (GameManager) field.get(testHandler);
					// Check if gameManager parameter and gameManager passed are 
					// equal
					assertEquals(gameTestManager, value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
