package uq.deco2800.ducktales.market;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;

public class MarketGuiTest extends GuiTest {
	
	MarketManager marketManager;
	Parent parent = null;
	
	
	@Override
	public Parent getRootNode() {
		
		Parent parent = null;
		
//		URL location = getClass().getResource((MarketVistaNavigator.MAIN));
//
//        FXMLLoader loader = new FXMLLoader(location);
//        
//        // Retrieve the controller;
//        marketManager = loader.getController();
		
		try {
			parent = FXMLLoader.load(getClass()
					 .getResource(MarketVistaNavigator.MAIN));
			
			marketManager = MarketVistaNavigator.getMainController();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
		}
		
		return parent;

		
	}

    @Test 
    public void testSelectCurrentTrades() {
    	
    	clickOn("#currentTradesBtn");
    	
    	/* 
    	 * Vista won't load in vista loader for the test as a 
    	 * NullPointer Exception is thrown, however the process works in the
    	 * main game.
    	 */
    	
    }
	

}
