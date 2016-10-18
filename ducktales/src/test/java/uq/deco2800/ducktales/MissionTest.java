//package uq.deco2800.ducktales;
//
//import static org.testfx.api.FxAssert.verifyThat;
//import static org.testfx.matcher.base.NodeMatchers.hasText;
//import static org.testfx.matcher.base.NodeMatchers.isNotNull;
//
//import java.net.URL;
//
//import org.junit.Test;
//import org.testfx.framework.junit.ApplicationTest;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
///**
// * Tests the GUI for Mission
// * @author Naehyung Kim
// *
// */
//public class MissionTest extends ApplicationTest{
//
//	/**
//	 * Set up testFx
//	 *
//	 */
//	@Override
//    public void start(Stage stage) throws Exception {
//		URL location = getClass().getResource("/missions/missionAndAchievement.fxml");
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(location);
//		Parent root = loader.load(location.openStream());
//		Scene tutorialScene = new Scene(root, 1200, 600);
//
//		stage.setTitle("Mission");
//		stage.setScene(tutorialScene);
//		stage.show();
//    }
//
//	/**
//	 * Test for Missions Button
//	 *
//	 */
//	@Test
//	public void checkMissions() {
//
//		clickOn("#Missions");
//
//		//verifyThat("#Missions", hasText("Missions"));
//		verifyThat("#titleLabel", hasText("Missions"));
//	}
//
//	/**
//	 * Test for Mission Progress Button
//	 *
//	 */
//	@Test
//	public void checkMissionProgress() {
//
//		clickOn("#MissionProgress");
//
//		verifyThat("#MissionProgress", hasText("Mission Progress Circle"));
//		verifyThat("#titleLabel", hasText("Mission Progress"));
//	}
//
//	/**
//	 * Tests if there is any null on the buttons
//	 *
//	 */
//	@Test
//    public void testIsNotNull() {
//
//        verifyThat("#Missions", isNotNull());
//        verifyThat("#MissionProgress", isNotNull());
//    }
//}
