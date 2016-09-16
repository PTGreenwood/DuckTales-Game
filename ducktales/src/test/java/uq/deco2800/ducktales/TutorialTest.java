package uq.deco2800.ducktales;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit.ApplicationTest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import uq.deco2800.ducktales.features.tutorials.TutorialController;

public class TutorialTest extends ApplicationTest {
		
	TutorialController tutorialController;
	/*@Override
    protected Parent getRootNode() {
		
		
        FXMLLoader fxmlLoader = new FXMLLoader();
        
        try {
			return fxmlLoader.load(getClass().getResource("/tutorial.fxml"));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
        
    }*/
	
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
		
		//verifyThat("#titleLabel", containsText("User logged in!"));
	}
	
	@Test
	public void checkBuildings() {
		clickOn("#buildings");
	}

	@Test
	public void checkMarketPlace() {
		clickOn("#marketPlace");
	}
	
	@Test
    public void testIsNotNull() {
        
        verifyThat("#basicInter", isNotNull());
        verifyThat("#buildings", isNotNull());
        verifyThat("#marketPlace", isNotNull());
    }
}
