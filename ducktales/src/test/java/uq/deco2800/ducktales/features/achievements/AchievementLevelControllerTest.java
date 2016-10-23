package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.image.Image;
import javafx.stage.Stage;
public class AchievementLevelControllerTest extends ApplicationTest {

	@Test
	public void imageTest() {
		AchievementLevelController levelController = new AchievementLevelController();
		String expectedImageString = levelController.getAchievementLevelImage().impl_getUrl();		
		String actualImageString = "/achievements/level1.png";		
		assertTrue(expectedImageString.contains(actualImageString));
	}
	
	@Test
	public void singletonTest() {
		AchievementLevelController levelController = AchievementLevelController.getInstance();
		assertTrue(levelController.equals(AchievementLevelController.getInstance()));
	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}
}
