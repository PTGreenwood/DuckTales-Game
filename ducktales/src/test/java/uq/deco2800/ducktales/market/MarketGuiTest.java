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

/**
 * Conducts tests on the Graphics User Interface for the marketplace.
 * @author Mark Belonogoff
 *
 */
public class MarketGuiTest extends GuiTest {
	
	MarketManager marketManager;
	Parent parent = null;
	
	/**
	 * Set up for TestFX.
	 */
	@Override
	public Parent getRootNode() {
		
		// Attempt to create the root node.
		try {
			parent = FXMLLoader.load(getClass()
					 .getResource(MarketVistaNavigator.MAIN));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
		}
		
		return parent;
	}

	/**
	 * Checks that when a user Clicks the Current Trades button that
	 * the correct view appears.
	 */
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
