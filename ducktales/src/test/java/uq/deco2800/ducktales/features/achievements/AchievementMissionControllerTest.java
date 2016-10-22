package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class AchievementMissionControllerTest extends ApplicationTest {

	@Test
	public void imageTest() {
		AchievementMissionController missionController = new AchievementMissionController();
		String expectedImageString = missionController.getAchievementMissionImage().impl_getUrl();
		String actualImageString = "/achievements/medalBronze.png";
		assertTrue(expectedImageString.contains(actualImageString));
	}
	
	@Test
	public void singletonTest() {
		AchievementMissionController missionController = AchievementMissionController.getInstance();
		assertTrue(missionController.equals(AchievementMissionController.getInstance()));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
