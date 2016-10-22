package uq.deco2800.ducktales.features.missions;

import static org.junit.Assert.*;
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

public class MissionGameControllerTest extends ApplicationTest {

	/**
	 * Set up testFx
	 *
	 */
	@Override
    public void start(Stage stage) throws Exception {
		URL location = getClass().getResource("/missions/missionGame.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 1200, 600);

		stage.setTitle("Mission");
		stage.setScene(tutorialScene);
		stage.show();
    }
	/*
	@Test
	public void checkMissions() {

		
		//verifyThat("#Missions", hasText("Missions"));
		verifyThat("#labelTop", hasText("GAME"));
	}*/
	
	@Test
    public void testIsNotNull() {

        verifyThat("#labelTop", isNotNull());
        verifyThat("#mission1", isNotNull());
        verifyThat("#mission2", isNotNull());
        verifyThat("#mission3", isNotNull());
        verifyThat("#box1", isNotNull());
        verifyThat("#box2", isNotNull());
        verifyThat("#box3", isNotNull());
    }

}
