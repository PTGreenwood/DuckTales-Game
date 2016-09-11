package uq.deco2800.ducktales.util.event.handlers.keyboard;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.features.entities.worldentities.*;
import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.util.events.handlers.keyboard.InGameKeyboardHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.Entity;

public class InGameKeyboardHandlerTest {
	
	@Ignore
	@Test
	public void basicTest() {
		//GameManager testManager = new GameManager();
		InGameKeyboardHandler test = new InGameKeyboardHandler(null);
		
		KeyEvent key = new KeyEvent(KeyEvent.KEY_PRESSED, "D", null, null, false, false, false, false);
		
		test.handle(key);
	}
	
	
	
}