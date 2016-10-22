package uq.deco2800.ducktales.features.missions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class MissionGameControllerTest extends ApplicationTest {

	
	@Test
	public void ImageViewTest() {
		MissionGameController gameController = new MissionGameController();
		//System.out.println(gameController.getBox1().getImage().impl_getUrl());
		assertTrue(gameController.getBox1().getImage() == null);
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
