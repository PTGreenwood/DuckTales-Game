package uq.deco2800.ducktales.features.tutorials;

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

public class TutorialManagerTest extends ApplicationTest {
	
	
	/**
	 * Set up testFx
	 *
	 */
	@Override
    public void start(Stage stage) throws Exception {
		URL location = getClass().getResource("/tutorial.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 1200, 600);

		stage.setTitle("Mission");
		stage.setScene(tutorialScene);
		stage.show();
    }

	/**
	 * Check basicInterface title has same title as expected
	 */
	@Test
	public void loadBasicInterfaceTest() {
		
		clickOn("#basicInterface");
		verifyThat("#labelTop", hasText("Interface"));
		
	}
	
	/**
	 * Check buildings title has same title as expected
	 */
	@Test
	public void loadBuildingsTest() {
		
		clickOn("#buildings");
		verifyThat("#labelTop", hasText("Buildings"));
	}
	
	/**
	 * Check market place title has same title as expected
	 */
	/*
	@Test
	public void loadMarketPlace() {
		
		clickOn("#marketPlace");
		verifyThat("#labelTop", hasText("Market Place"));
	}
	*/
//	/**
//	 * Check npc title has same title as expected
//	 */
//	@Test
//	public void loadNPC() {
//
//		clickOn("#NPC");
//		verifyThat("#labelTop",  hasText("NPC"));
//	}
//}
