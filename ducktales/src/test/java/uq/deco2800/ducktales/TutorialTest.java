package uq.deco2800.ducktales;

import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;
import static org.testfx.api.FxAssert.verifyThat;

import java.net.URL;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import org.mockito.Mock;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import uq.deco2800.ducktales.features.tutorials.TutorialController;

import static org.loadui.testfx.GuiTest.find;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.testfx.api.FxToolkit.setupStage;


public class TutorialTest extends ApplicationTest {
				
	@Override
    public void start(Stage stage) throws Exception {
		URL location = getClass().getResource("/tutorial.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 1200, 600);
		
		stage.setTitle("Tutorial");
		stage.setScene(tutorialScene);
		stage.show();
    }
	
	@Test
	public void checkBasicInterface() {		
		
		clickOn("#basicInter");
		
		verifyThat("#basicInter", hasText("Basic Interface"));		
	}
	
	@Test
	public void checkBuildings() {
		
		clickOn("#buildings");
		
		verifyThat("#buildings", hasText("Buildings"));
	}

	@Test
	public void checkMarketPlace() {
		
		clickOn("#marketPlace");
		
		verifyThat("#marketPlace", hasText("Trading System"));
	}
	
	@Test
    public void testIsNotNull() {
        
        verifyThat("#basicInter", isNotNull());
        verifyThat("#buildings", isNotNull());
        verifyThat("#marketPlace", isNotNull());
    }
}
