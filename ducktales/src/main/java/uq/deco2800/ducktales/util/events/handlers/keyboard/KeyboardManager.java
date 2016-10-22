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
	
	
	
	private static KeyCombination moveUpKeyCombination = new KeyCodeCombination(KeyCode.W);
	
	private static KeyCombination moveDownKeyCombination = new KeyCodeCombination(
			KeyCode.S);
	
	private static KeyCombination moveLeftKeyCombination = new KeyCodeCombination(
			KeyCode.A);
	
	private static KeyCombination moveRightKeyCombination = new KeyCodeCombination(
			KeyCode.D);
	
	private static KeyCombination openMissionsKeyCombination = new KeyCodeCombination(
			KeyCode.I);
	
	private static KeyCombination openMarketplaceKeyCombination = new KeyCodeCombination(
			KeyCode.M);
	
	private static KeyCombination openAchievementsKeyCombination = new KeyCodeCombination(
			KeyCode.H);
	
	private static KeyCombination openTutorialKeyCombination = new KeyCodeCombination(
			KeyCode.T);

	private static KeyCombination normalSpeedKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT1, KeyCombination.SHIFT_DOWN);
	
	private static KeyCombination fastSpeedKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT2, KeyCombination.SHIFT_DOWN);
	
	private static KeyCombination fastestSpeedKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT3, KeyCombination.SHIFT_DOWN);
	
	private static KeyCombination pauseGameKeyCombination = new KeyCodeCombination(
			KeyCode.P);
	
	private static KeyCombination buildFirstKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT1);
	
	private static KeyCombination buildSecondKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT2);
	
	private static KeyCombination buildThirdKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT3);
	
	private static KeyCombination buildFourthKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT4);
	
	private static KeyCombination buildFifthKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT5);
	
	private static KeyCombination buildSixthKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT6);
	
	private static KeyCombination buildSeventhKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT7);
	
	private static KeyCombination buildEighthKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT8);
	
	private static KeyCombination buildNinthKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT9);
	
	private static KeyCombination buildTenthKeyCombination = new KeyCodeCombination(
			KeyCode.DIGIT0);
	
	private static KeyCombination buildEleventhKeyCombination = new KeyCodeCombination(
			KeyCode.Z);
	
	private static KeyCombination buildTwelfthKeyCombination = new KeyCodeCombination(
			KeyCode.X);
	
	private static KeyCombination buildThirteenthKeyCombination = new KeyCodeCombination(
			KeyCode.C);
	
	private static KeyCombination buildFourteenthKeyCombination = new KeyCodeCombination(
			KeyCode.V);
	
	
	//Keep this here so the compiler knows this class should not be instantiated
	private KeyboardManager() {
		
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
	
	public static void setOpenMissionsKeyCombination(KeyCombination keyCombination) {
		openMissionsKeyCombination = keyCombination;
	}
	
	public static void setOpenMarketplaceKeyCombination(KeyCombination keyCombination) {
		openMarketplaceKeyCombination = keyCombination;
	}
	
	public static void setOpenAchievementsKeyCombination(KeyCombination keyCombination) {
		openAchievementsKeyCombination = keyCombination;
	}
	
	public static void setOpenTutorialKeyCombination(KeyCombination keyCombination) {
		openTutorialKeyCombination = keyCombination;
	}
	
	public static void setNormalSpeedKeyCombination(KeyCombination keyCombination) {
		normalSpeedKeyCombination = keyCombination;
	}
	
	public static void setFastSpeedKeyCombination(KeyCombination keyCombination) {
		fastSpeedKeyCombination = keyCombination;
	}
	
	public static void setFastestSpeedKeyCombination(KeyCombination keyCombination) {
		fastestSpeedKeyCombination = keyCombination;
	}
	
	public static void setPauseGameKeyCombination(KeyCombination keyCombination) {
		pauseGameKeyCombination = keyCombination;
	}
	
	public static void setBuildFirstKeyCombination(KeyCombination keyCombination) {
		buildFirstKeyCombination = keyCombination;
	}
	
	public static void setBuildSecondKeyCombination(KeyCombination keyCombination) {
		buildSecondKeyCombination = keyCombination;
	}
	
	public static void setBuildThirdKeyCombination(KeyCombination keyCombination) {
		buildThirdKeyCombination = keyCombination;
	}
	
	public static void setBuildFourthKeyCombination(KeyCombination keyCombination) {
		buildFourthKeyCombination = keyCombination;
	}
	
	public static void setBuildFifthKeyCombination(KeyCombination keyCombination) {
		buildFifthKeyCombination = keyCombination;
	}
	
	public static void setBuildSixthKeyCombination(KeyCombination keyCombination) {
		buildSixthKeyCombination = keyCombination;
	}
	
	public static void setBuildSeventhKeyCombination(KeyCombination keyCombination) {
		buildSeventhKeyCombination = keyCombination;
	}
	
	public static void setBuildEighthKeyCombination(KeyCombination keyCombination) {
		buildEighthKeyCombination = keyCombination;
	}
	
	public static void setBuildNinthKeyCombination(KeyCombination keyCombination) {
		buildNinthKeyCombination = keyCombination;
	}
	
	public static void setBuildTenthKeyCombination(KeyCombination keyCombination) {
		buildTenthKeyCombination = keyCombination;
	}
	
	public static void setBuildEleventhKeyCombination(KeyCombination keyCombination) {
		buildEleventhKeyCombination = keyCombination;
	}
	
	public static void setBuildTwelfthKeyCombination(KeyCombination keyCombination) {
		buildTwelfthKeyCombination = keyCombination;
	}
	
	public static void setBuildThirteenthKeyCombination(KeyCombination keyCombination) {
		buildThirteenthKeyCombination = keyCombination;
	}
	
	public static void setBuildFourteenthKeyCombination(KeyCombination keyCombination) {
		buildFourteenthKeyCombination = keyCombination;
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
	
	public static KeyCombination getOpenMissionsKeyCombination() {
		return openMissionsKeyCombination;
	}
	
	public static KeyCombination getOpenMarketplaceKeyCombination() {
		return openMarketplaceKeyCombination;
	}
	
	public static KeyCombination getOpenAchievementsKeyCombination() {
		return openAchievementsKeyCombination;
	}
	
	public static KeyCombination getOpenTutorialKeyCombination() {
		return openTutorialKeyCombination;
	}
	
	public static KeyCombination getNormalSpeedKeyCombination() {
		return normalSpeedKeyCombination;
	}
	
	public static KeyCombination getFastSpeedKeyCombination() {
		return fastSpeedKeyCombination;
	}
	
	public static KeyCombination getFastestSpeedKeyCombination() {
		return fastestSpeedKeyCombination;
	}
	
	public static KeyCombination getPauseGameKeyCombination() {
		return pauseGameKeyCombination;
	}
	
	public static KeyCombination getBuildFirstKeyCombination() {
		return buildFirstKeyCombination;
	}
	
	public static KeyCombination getBuildSecondKeyCombination() {
		return buildSecondKeyCombination;
	}
	
	public static KeyCombination getBuildThirdKeyCombination() {
		return buildThirdKeyCombination;
	}
	
	public static KeyCombination getBuildFourthKeyCombination() {
		return buildFourthKeyCombination;
	}
	
	public static KeyCombination getBuildFifthKeyCombination() {
		return buildFifthKeyCombination;
	}
	
	public static KeyCombination getBuildSixthKeyCombination() {
		return buildSixthKeyCombination;
	}
	
	public static KeyCombination getBuildSeventhKeyCombination() {
		return buildSeventhKeyCombination;
	}
	
	public static KeyCombination getBuildEighthKeyCombination() {
		return buildEighthKeyCombination;
	}
	
	public static KeyCombination getBuildNinthKeyCombination() {
		return buildNinthKeyCombination;
	}
	
	public static KeyCombination getBuildTenthKeyCombination() {
		return buildTenthKeyCombination;
	}
	
	public static KeyCombination getBuildEleventhKeyCombination() {
		return buildEleventhKeyCombination;
	}
	
	public static KeyCombination getBuildTwelfthKeyCombination() {
		return buildTwelfthKeyCombination;
	}
	
	public static KeyCombination getBuildThirteenthKeyCombination() {
		return buildThirteenthKeyCombination;
	}
	
	public static KeyCombination getBuildFourteenthKeyCombination() {
		return buildFourteenthKeyCombination;
	}
	
}
