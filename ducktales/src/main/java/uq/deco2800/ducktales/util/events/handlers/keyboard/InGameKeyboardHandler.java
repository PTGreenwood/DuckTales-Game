package uq.deco2800.ducktales.util.events.handlers.keyboard;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.GameManager;
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
			handleKeyPressed(event.getCode());
		} else if (eventType == KeyEvent.KEY_RELEASED) {
			handleKeyReleased(event.getCode());
		}
	}

	
	/**
	 * Hide all UI menus. 
	 */
	private void hideMenus() {
		gameManager.getMarketManager().hideMarketPlace();
		gameManager.getMissionManager().hideMission();
		gameManager.getLevelManager().hideLevel();
		gameManager.getAchievementManager().hideAchievement();
	}

	private void handleKeyPressed(KeyCode code) {
		System.out.println(code);
		boolean visible;
		switch (code) {
		case D:
			moveDirection = Direction.LEFT;
			displayManager.moveWorld(Direction.LEFT);
			break;
		case W:
			moveDirection = Direction.DOWN;
			displayManager.moveWorld(Direction.DOWN);
			break;
		case A:
			moveDirection = Direction.RIGHT;
			displayManager.moveWorld(Direction.RIGHT);
			break;
		case S:
			moveDirection = Direction.UP;
			displayManager.moveWorld(Direction.UP);
			System.err.println("moving UP in Handler");
			break;
		case M:
			//mission completed action
			gameManager.getMissionManager().missionCompletedAction(2);
			visible = gameManager.getMarketManager().isVisible();
			hideMenus();			
			if (visible)
				gameManager.getMarketManager().hideMarketPlace();
			else 
				gameManager.getMarketManager().showMarketPlace();
			break;
		case I:
			visible = gameManager.getMissionManager().isVisible();
			hideMenus();
			if (visible)
				gameManager.getMissionManager().hideMission();
			else 
				gameManager.getMissionManager().showMission();
			break;
		case L:
			//mission completed action
			gameManager.getMissionManager().missionCompletedAction(0);
			visible = gameManager.getLevelManager().isVisible();
			hideMenus();
			if (visible)
				gameManager.getLevelManager().hideLevel();
			else 
				gameManager.getLevelManager().showLevel();
			break;
		case H:
			//mission completed action
			gameManager.getMissionManager().missionCompletedAction(1);
			visible = gameManager.getAchievementManager().isVisible();
			hideMenus();
			if (visible)
				gameManager.getAchievementManager().hideAchievement();
			else 
				gameManager.getAchievementManager().showAchievement();
			break;
		}
	}

	private void handleKeyReleased(KeyCode code) {
		switch (code) {
		case D:
			moveDirection = Direction.LEFT;
			displayManager.stopMoveWorld(Direction.LEFT);
			break;
		case W:
			moveDirection = Direction.DOWN;
			displayManager.stopMoveWorld(Direction.DOWN);
			break;
		case A:
			moveDirection = Direction.RIGHT;
			displayManager.stopMoveWorld(Direction.RIGHT);
			break;
		case S:
			moveDirection = Direction.UP;
			displayManager.stopMoveWorld(Direction.UP);
			break;
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
