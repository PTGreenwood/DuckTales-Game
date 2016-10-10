package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;


/**
 * Test class for the WorldBuilderLoop class. 
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class WorldBuilderLoopTest {
		
	@Test
	public void test1() {
		WorldBuilderLoop testLoop = new WorldBuilderLoop(new AtomicBoolean(false), 10);
		//Use reflection to access protected gameManager parameter
				Field field1;
				Field field2;
				Field field3;
				try {
					try {
						// Access loop field and set to accessible
						field1 = WorldBuilderLoop.class.getDeclaredField("quit");
						field1.setAccessible(true);
						field2 = WorldBuilderLoop.class.getDeclaredField("world");
						field2.setAccessible(true);
						field3 = WorldBuilderLoop.class.getDeclaredField("tick");
						field3.setAccessible(true);
						
						try {
							// Get the value of loop parameter
							AtomicBoolean value1 = (AtomicBoolean) field1.get(testLoop);
							
							int value3 = field3.getInt(testLoop);
							
							assertEquals((new AtomicBoolean(false)).toString(), value1.toString());
							assertEquals(10, value3);
							
							testLoop.run();
							
							AtomicBoolean value4 = (AtomicBoolean) field1.get(testLoop);
							
							int value6 = field3.getInt(testLoop);
							
							assertEquals((new AtomicBoolean(false)).toString(), value4.toString());
							assertEquals(10, value6);
							
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
