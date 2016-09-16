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

public class MissionTest extends ApplicationTest{
	
	@Override
    public void start(Stage stage) throws Exception {
		URL location = getClass().getResource("/missions/missionAndAchievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 1200, 600);
		
		stage.setTitle("Mission");
		stage.setScene(tutorialScene);
		stage.show();
    }
	
	@Test
	public void checkBasicInterface() {		
		
		clickOn("#Missions");
		
		verifyThat("#Missions", hasText("Missions"));
	}
	
	@Test
	public void checkBuildings() {
		
		clickOn("#MissionProgress");
		
		verifyThat("#MissionProgress", hasText("Mission Progress Circle"));
	}
	@Test
    public void testIsNotNull() {
        
        verifyThat("#Missions", isNotNull());
        verifyThat("#MissionProgress", isNotNull());
    }
}
