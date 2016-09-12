package uq.deco2800.ducktales.market;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;

public class MarketGuiTest extends ApplicationTest {
	
	MarketManager marketManager;
	Parent parent = null;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		try {
			URL location = getClass().getResource((MarketVistaNavigator.MAIN));

	        FXMLLoader loader = new FXMLLoader(location);
	        
	     // Retrieve the controller;
	        marketManager = loader.getController();
		} finally {
				
		}
		
	}
	
	@Override 
	public void stop() {}

    @Test 
    public void testSelectCurrentTrades() {}
    
    @Test 
    public void testSelectYourTrades() {}
	

}
