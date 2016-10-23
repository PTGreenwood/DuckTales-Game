package uq.deco2800.ducktales.time;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uq.deco2800.ducktales.GameLoop;
import uq.deco2800.ducktales.features.time.TimeManager;

/**
 * Tests the play button GUI Element in the time display HUD element
 *
 * @author Felicia
 *
 */

public class PlayTimeGUITest extends GuiTest {

	TimeManager timeManager;
	GameLoop gameLoop;
	private AtomicBoolean quit;
	Parent parent = null;

	/**
	 * Set up for TestFX.
	 */
	@Override
	protected Parent getRootNode() {
		this.timeManager = new TimeManager();
		this.gameLoop = new GameLoop(quit, 10);

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/time/timeDisplay.fxml"));

			parent = loader.load();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

		}

		return parent;
	}

	@Test
	public void testPlayButton() {
		
		// test play on default game speed
		clickOn("#timePlay");
		Assert.assertTrue("The time loop isn't paused", !(GameLoop.isPaused()));
		Assert.assertTrue("The time loop speed is 1x", GameLoop.getGameSpeed() == 10);
		
		// test play after pausing game
		clickOn("#timePause");
		clickOn("#timePlay");
		Assert.assertTrue("The time loop isn't paused", !(GameLoop.isPaused()));
		Assert.assertTrue("The time loop speed is 1x", GameLoop.getGameSpeed() == 10);

		// test play after fast forwarding game
		clickOn("#timeFastForward");
		clickOn("#timePlay");
		Assert.assertTrue("The time loop isn't paused", !(GameLoop.isPaused()));
		Assert.assertTrue("The time loop speed is 1x", GameLoop.getGameSpeed() == 10);

		// test play after double fast forwarding game
		clickOn("#timeDoubleFastForward");
		clickOn("#timePlay");
		Assert.assertTrue("The time loop isn't paused", !(GameLoop.isPaused()));
		Assert.assertTrue("The time loop speed is 1x", GameLoop.getGameSpeed() == 10);

	}

}
