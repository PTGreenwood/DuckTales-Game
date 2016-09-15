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

public class TutorialTest extends GuiTest {
		
	
	
	@Override
    protected Parent getRootNode() {
		
		
        FXMLLoader fxmlLoader = new FXMLLoader();
        
        try {
			return fxmlLoader.load(getClass().getResource("/tutorial.fxml"));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
        
    }
	
	@Test
	public void checkBasicInterface() {		
		clickOn("#basicInter");
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
