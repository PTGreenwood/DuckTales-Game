package uq.deco2800.ducktales.util.events.handlers;

import org.junit.Assert;
import org.junit.Test;

import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import uq.deco2800.ducktales.util.events.handlers.keyboard.KeyboardManager;

public class KeyboardManagerTest {
	@Test
	public void testGetters() {
		KeyCombination keyCombination = null;
		KeyEvent event = null;

		// Test MOVE LEFT key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.A, false,
				false, false, false);
		keyCombination = KeyboardManager.getMoveLeftKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test MOVE RIGHT key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.D, false,
				false, false, false);
		keyCombination = KeyboardManager.getMoveRightKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test MOVE RIGHT key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.W, false,
				false, false, false);
		keyCombination = KeyboardManager.getMoveUpKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test MOVE DOWN key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.S, false,
				false, false, false);
		keyCombination = KeyboardManager.getMoveDownKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test OPEN MISSIONS key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.I, false,
				false, false, false);
		keyCombination = KeyboardManager.getOpenMissionsKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test OPEN MARKETPLACE key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.M, false,
				false, false, false);
		keyCombination = KeyboardManager.getOpenMarketplaceKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test OPEN ACHIEVEMENTS key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.H, false,
				false, false, false);
		keyCombination = KeyboardManager.getOpenAchievementsKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test OPEN TUTORIAL key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.T, false,
				false, false, false);
		keyCombination = KeyboardManager.getOpenTutorialKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test NORMAL SPEED key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT1,
				true, false, false, false);
		keyCombination = KeyboardManager.getNormalSpeedKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test FAST SPEED key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT2,
				true, false, false, false);
		keyCombination = KeyboardManager.getFastSpeedKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test FASTEST SPEED key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT3,
				true, false, false, false);
		keyCombination = KeyboardManager.getFastestSpeedKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test PAUSE GAME key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.P, false,
				false, false, false);
		keyCombination = KeyboardManager.getPauseGameKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD FIRST key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT1,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildFirstKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD SECOND key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT2,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildSecondKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD THIRD key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT3,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildThirdKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD FOURTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT4,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildFourthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD FIFTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT5,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildFifthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD SIXTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT6,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildSixthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD SEVENTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT7,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildSeventhKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD EIGHTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT8,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildEighthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD NINTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT9,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildNinthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD TENTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT0,
				false, false, false, false);
		keyCombination = KeyboardManager.getBuildTenthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD ELEVENTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.Z, false,
				false, false, false);
		keyCombination = KeyboardManager.getBuildEleventhKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD TWELFTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.X, false,
				false, false, false);
		keyCombination = KeyboardManager.getBuildTwelfthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD THIRTEENTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.C, false,
				false, false, false);
		keyCombination = KeyboardManager.getBuildThirteenthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		// Test BUILD FOURTEENTH key combination
		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.V, false,
				false, false, false);
		keyCombination = KeyboardManager.getBuildFourteenthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));
	}

	@Test
	public void testSetters() {
		KeyCombination keyCombination = null;
		KeyCombination testKeyCombination = null;
		KeyEvent event = null;

		event = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.DIGIT5,
				true, false, false, false);

		testKeyCombination = new KeyCodeCombination(KeyCode.DIGIT5,
				KeyCombination.SHIFT_DOWN);

		KeyboardManager.setMoveLeftKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getMoveLeftKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setMoveLeftKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getMoveLeftKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setMoveRightKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getMoveRightKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setMoveUpKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getMoveUpKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setMoveDownKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getMoveDownKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setOpenMissionsKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getOpenMissionsKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setOpenMarketplaceKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getOpenMarketplaceKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setOpenAchievementsKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getOpenAchievementsKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setOpenTutorialKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getOpenTutorialKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setNormalSpeedKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getNormalSpeedKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setFastSpeedKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getFastSpeedKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setFastestSpeedKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getFastestSpeedKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setPauseGameKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getPauseGameKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildFirstKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildFirstKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildSecondKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildSecondKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildThirdKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildThirdKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildFourthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildFourthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildFifthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildFifthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildSixthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildSixthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildSeventhKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildSeventhKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildEighthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildEighthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildNinthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildNinthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildTenthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildTenthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildEleventhKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildEleventhKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildTwelfthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildTwelfthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildThirteenthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildThirteenthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));

		KeyboardManager.setBuildFourteenthKeyCombination(testKeyCombination);
		keyCombination = KeyboardManager.getBuildFourteenthKeyCombination();
		Assert.assertTrue(keyCombination.match(event));
	}
}
