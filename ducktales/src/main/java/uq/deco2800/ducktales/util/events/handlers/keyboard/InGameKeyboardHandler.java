package uq.deco2800.ducktales.util.events.handlers.keyboard;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.GameLoop;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;

import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager.Direction;

/**
 * Handle keyboard events happening in-game.
 *
 * Created on 8/09/2016.
 * 
 * @author khoiphan21
 */
public class InGameKeyboardHandler extends GameEventHandler
		implements EventHandler<KeyEvent> {

	/** The secondary managers */
	private WorldDisplayManager displayManager;

	// For testing, to check that the correct direction is selected
	protected Direction moveDirection;

	private boolean screenVisible;

	/**
	 * Create a handler for in-game keyboard events
	 *
	 * @param gameManager
	 *            The manager of the game
	 */
	public InGameKeyboardHandler(GameManager gameManager) {
		super(gameManager);
		displayManager = gameManager.getWorldDisplayManager();
	}

	@Override
	public void handle(KeyEvent event) {
		// Get the type of the key event
		EventType<KeyEvent> eventType = event.getEventType();

		// Check if it's a key pressed or key released
		if (eventType == KeyEvent.KEY_PRESSED) {
			handleKeyPressed(event.getCode(), event);
		} else if (eventType == KeyEvent.KEY_RELEASED) {
			handleKeyReleased(event.getCode(), event);
		}
	}

	/**
	 * Hide all UI menus.
	 */
	private void hideMenus() {
		gameManager.getMarketManager().hideMarketPlace();
		gameManager.getMissionManager().hideMission();
		gameManager.getTutorialManager().hideTutorial();
		gameManager.getAchievementManager().hideAchievement();
	}

	private void toggleMarketPlace() {
		gameManager.getMissionManager().missionCompletedAction(2);
		screenVisible = gameManager.getMarketManager().isVisible();
		hideMenus();
		if (screenVisible)
			gameManager.getMarketManager().hideMarketPlace();
		else
			gameManager.getMarketManager().showMarketPlace();
	}

	private void toggleAchievements() {
		gameManager.getMissionManager().missionCompletedAction(1);
		screenVisible = gameManager.getAchievementManager().isVisible();
		hideMenus();
		if (screenVisible)
			gameManager.getAchievementManager().hideAchievement();
		else
			gameManager.getAchievementManager().showAchievement();
	}

	private void toggleMissions() {
		screenVisible = gameManager.getMissionManager().isVisible();
		hideMenus();
		if (screenVisible)
			gameManager.getMissionManager().hideMission();
		else
			gameManager.getMissionManager().showMission();
	}

	private void toggleTutorial() {
		gameManager.getMissionManager().missionCompletedAction(0);
		screenVisible = gameManager.getTutorialManager().isVisible();
		hideMenus();
		if (screenVisible)
			gameManager.getTutorialManager().hideTutorial();
		else
			gameManager.getTutorialManager().showTutorial();
	}

	private void handleKeyPressed(KeyCode code, KeyEvent event) {
		if (KeyboardManager.getMoveLeftKeyCombination().match(event)) {
			moveDirection = Direction.RIGHT;
			displayManager.moveWorld(Direction.RIGHT);
		} else if (KeyboardManager.getMoveRightKeyCombination().match(event)) {
			moveDirection = Direction.LEFT;
			displayManager.moveWorld(Direction.LEFT);
		} else if (KeyboardManager.getMoveUpKeyCombination().match(event)) {
			moveDirection = Direction.DOWN;
			displayManager.moveWorld(Direction.DOWN);
		} else if (KeyboardManager.getMoveDownKeyCombination().match(event)) {
			moveDirection = Direction.UP;
			displayManager.moveWorld(Direction.UP);
		} else if (KeyboardManager.getOpenMarketplaceKeyCombination()
				.match(event)) {
			this.toggleMarketPlace();
		} else if (KeyboardManager.getOpenMissionsKeyCombination()
				.match(event)) {
			this.toggleMissions();
		} else if (KeyboardManager.getOpenAchievementsKeyCombination()
				.match(event)) {
			this.toggleAchievements();
		} else if (KeyboardManager.getOpenTutorialKeyCombination()
				.match(event)) {
			this.toggleTutorial();
		} else if (KeyboardManager.getNormalSpeedKeyCombination()
				.match(event)) {
			GameLoop.setSpeedModifier(1);
			System.out.println("Speed 1x"); // set time scale to default
		} else if (KeyboardManager.getFastSpeedKeyCombination().match(event)) {
			GameLoop.setSpeedModifier(1.5);
			System.out.println("Speed 1.5x"); // set time scale to 1.5151x
		} else if (KeyboardManager.getFastestSpeedKeyCombination()
				.match(event)) {
			GameLoop.setSpeedModifier(2.5);
			System.out.println("Speed 2.5x"); // set time scale to 2.5x
		} else if (KeyboardManager.getPauseGameKeyCombination().match(event)) {
			GameLoop.pauseWorld();
			System.out.println("Pause/UnPause");
		} else if (KeyboardManager.getBuildFirstKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(0);
		} else if (KeyboardManager.getBuildSecondKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(1);
		} else if (KeyboardManager.getBuildThirdKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(2);
		} else if (KeyboardManager.getBuildFourthKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(3);
		} else if (KeyboardManager.getBuildFifthKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(4);
		} else if (KeyboardManager.getBuildSixthKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(5);
		} else if (KeyboardManager.getBuildSeventhKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(6);
		} else if (KeyboardManager.getBuildEighthKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(7);
		} else if (KeyboardManager.getBuildNinthKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(8);
		} else if (KeyboardManager.getBuildTenthKeyCombination().match(event)) {
			MenuManager.selectItemByIndex(9);
		}
	}

	private void handleKeyReleased(KeyCode code, KeyEvent event) {
		if (KeyboardManager.getMoveLeftKeyCombination().match(event)) {
			moveDirection = Direction.RIGHT;
			displayManager.stopMoveWorld(Direction.RIGHT);
		} else if (KeyboardManager.getMoveRightKeyCombination().match(event)) {
			moveDirection = Direction.LEFT;
			displayManager.stopMoveWorld(Direction.LEFT);
		} else if (KeyboardManager.getMoveUpKeyCombination().match(event)) {
			moveDirection = Direction.DOWN;
			displayManager.stopMoveWorld(Direction.DOWN);
		} else if (KeyboardManager.getMoveDownKeyCombination().match(event)) {
			moveDirection = Direction.UP;
			displayManager.stopMoveWorld(Direction.UP);
		}
	}

	/**
	 * Method for testing, easy access to the moveDirection variable.
	 * 
	 * @return the moveDirection following key press/release
	 */
	public Direction moveDirection() {
		return moveDirection;
	}
}
