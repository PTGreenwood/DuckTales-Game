package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class AchievementMissionControllerTest extends ApplicationTest {

	/**
	 * Check Image from AchievementMissionController contains actual URL from the image
	 */
	@Test
	public void imageTest() {
		AchievementMissionController missionController = new AchievementMissionController();
		String expectedImageString = missionController.getAchievementMissionImage().impl_getUrl();
		String actualImageString = "/achievements/medalBronze.png";
		assertTrue(expectedImageString.contains(actualImageString));
	}
	
	/**
	 * Check instance in the class works properly
	 */
	@Test
	public void singletonTest() {
		AchievementMissionController missionController = AchievementMissionController.getInstance();
		assertTrue(missionController.equals(AchievementMissionController.getInstance()));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
