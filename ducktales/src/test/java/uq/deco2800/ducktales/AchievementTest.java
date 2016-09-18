package uq.deco2800.ducktales;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;

import java.net.URL;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Tests the GUI for Achievements
 * @author Naehyung Kim
 *
 */
public class AchievementTest extends ApplicationTest {
	
	/**
	 * Set up testFx
	 * 
	 */
	@Override
    public void start(Stage stage) throws Exception {
		URL location = getClass().getResource("/achievements/achievementMain.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 1200, 600);
		
		stage.setTitle("Achievement");
		stage.setScene(tutorialScene);
		stage.show();
    }
	
	/**
	 * Test for mission achievement Button 
	 *
	 */
	@Test
	public void checkAchievementMission() {		
		
		clickOn("#achievementMissionBtn");
		
		verifyThat("#achievementMissionBtn", hasText("Mission Achievement"));
		//verifyThat("#titleLabel", hasText("Mission Achievement"));
	}
	
	/**
	 * Test for level achievement Button 
	 *
	 */
	@Test
	public void checkAchievementLevel() {
		
		clickOn("#achievementLevelBtn");
		
		verifyThat("#achievementLevelBtn", hasText("Level Achievement"));
		//verifyThat("#titleLabel", hasText("Level Achievement"));
	}
	
	/**
	 * Tests if there is any null on the buttons
	 * 
	 */
	@Test
    public void testIsNotNull() {
        
        verifyThat("#achievementMissionBtn", isNotNull());
        verifyThat("#achievementLevelBtn", isNotNull());
    }

}
