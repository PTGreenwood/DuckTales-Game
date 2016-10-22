package uq.deco2800.ducktales.features.missions;

import java.net.URL;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MissionManagerTest extends ApplicationTest {
	
	/**
	 * Set up testFx
	 *
	 */
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
	
	

}
