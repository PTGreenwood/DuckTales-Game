package uq.deco2800.ducktales.util.events.handlers.keyboard;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 * Keyboard Manager for getting and setting the keys to be used in game. These
 * can be changes from the Controls screen from the main menu.
 * 
 * @author mattyleggy
 *
 */
// @SuppressWarnings("unused")
public class KeyboardManager {
	/*
	 * private static KeyCombination firstBuildKeyCombination = new
	 * KeyCodeCombination( KeyCode.DIGIT1, KeyCombination.SHIFT_DOWN,
	 * KeyCombination.CONTROL_DOWN);
	 */
	
	private static KeyCombination moveUpKeyCombination = new KeyCodeCombination(
			KeyCode.W);
	
	private static KeyCombination moveDownKeyCombination = new KeyCodeCombination(
			KeyCode.S);
	
	private static KeyCombination moveLeftKeyCombination = new KeyCodeCombination(
			KeyCode.A);
	
	private static KeyCombination moveRightKeyCombination = new KeyCodeCombination(
			KeyCode.D);

	private static KeyCombination firstBuildKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT1);

	public static KeyCombination getFirstBuildKeyCombination() {
		return firstBuildKeyCombination;
	}
	
	/* ---------------------------- SETTERS -------------------------------- */
	
	public static void setMoveLeftKeyCombination(KeyCombination keyCombination) {
		moveLeftKeyCombination = keyCombination;
	}
	
	public static void setMoveRightKeyCombination(KeyCombination keyCombination) {
		moveRightKeyCombination = keyCombination;
	}
	
	public static void setMoveUpKeyCombination(KeyCombination keyCombination) {
		moveUpKeyCombination = keyCombination;
	}
	
	public static void setMoveDownKeyCombination(KeyCombination keyCombination) {
		moveDownKeyCombination = keyCombination;
	}
	
	/* ---------------------------- GETTERS -------------------------------- */
	
	public static KeyCombination getMoveLeftKeyCombination() {
		return moveLeftKeyCombination;
	}
	
	public static KeyCombination getMoveRightKeyCombination() {
		return moveRightKeyCombination;
	}
	
	public static KeyCombination getMoveUpKeyCombination() {
		return moveUpKeyCombination;
	}
	
	public static KeyCombination getMoveDownKeyCombination() {
		return moveDownKeyCombination;
	}
}
