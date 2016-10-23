package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class AchievementWoodControllerTest extends ApplicationTest {

	@Test
	public void imageTest() {
		AchievementWoodController woodController = new AchievementWoodController();
		String expectedImageString = woodController.getAchievementWoodImage().impl_getUrl();
		String actualImageString = "achievements/wood100.png";
		assertTrue(expectedImageString.contains(actualImageString));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}
	

}
