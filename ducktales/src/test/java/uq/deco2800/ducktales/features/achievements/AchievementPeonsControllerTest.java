package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import uq.deco2800.ducktales.World;

public class AchievementPeonsControllerTest extends ApplicationTest {

	
	@Test
	public void ImageTest() {
		AchievementPeonsController peonsController = new AchievementPeonsController();
		
		String expectedImageURL = peonsController.getAchievementPeonsImage().impl_getUrl();
		String actualImageURL = "/achievements/peon1.png";
		
		assertTrue(expectedImageURL.contains(actualImageURL));
	
		
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
