package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class AchievementOreControllerTest extends ApplicationTest {

	@Test
	public void imageTest() {
		AchievementOreController oreController = new AchievementOreController();
		String expectedImageString = oreController.getAchievementOreImage().impl_getUrl();
		String actualImageString = "achievements/ore100.png";
		assertTrue(expectedImageString.contains(actualImageString));
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}
}
