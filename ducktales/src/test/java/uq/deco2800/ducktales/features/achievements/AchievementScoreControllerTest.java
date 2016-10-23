package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;


public class AchievementScoreControllerTest extends ApplicationTest {
	
	/**
	 * Check achievementScoreController initiate variables with proper values
	 */
	@Test
	public void initTest() {
		AchievementScoreController scoreController = new AchievementScoreController();
		int expectedAchievementScore = scoreController.getAchieve();
		int actualAchievementScore = 0;
		assertTrue(expectedAchievementScore == actualAchievementScore);
	}
	
	/**
	 * Check the setAchieve methods 
	 */
	@Test
	public void setAchieveTest() {
		AchievementScoreController scoreController = new AchievementScoreController();
		scoreController.setAchieve(10);
		int expectedAchievementScore = scoreController.getAchieve();
		int actualAchievementScore = 10;
		assertTrue(expectedAchievementScore == actualAchievementScore);		
	}
	
	/**
	 * Check that difficulty methods increment intAchieve or not.
	 */
	@Test
	public void difficultyScoreTest() {
		AchievementScoreController scoreController = new AchievementScoreController();
		
		scoreController.setAchieve(0);
		scoreController.achieveVeryEasy();
		assertTrue(scoreController.getAchieve() == 1);
		
		scoreController.setAchieve(0);
		scoreController.achieveEasy();
		assertTrue(scoreController.getAchieve() == 2);
		
		scoreController.setAchieve(0);
		scoreController.achieveMedium();
		assertTrue(scoreController.getAchieve() == 3);
		
		scoreController.setAchieve(0);
		scoreController.achieveHard();
		assertTrue(scoreController.getAchieve() == 4);
		
		scoreController.setAchieve(0);
		scoreController.achieveVeryHard();
		assertTrue(scoreController.getAchieve() == 5);
	}

	/**
	 * Check the achievementHolder method in the class.
	 */
	@Test
	public void achievementHolderTest() {
		
		AchievementScoreController scoreController = new AchievementScoreController();
		LevelHandler.getInstance().setLevel(1);
		
		assertTrue(scoreController.achievementHolder() == 2);
	
	}
	
	/**
	 * Check instance in the class works properly
	 */
	@Test
	public void singletonTest() {
		AchievementScoreController scoreController = AchievementScoreController.getInstance();
		assertTrue(scoreController.equals(AchievementScoreController.getInstance()));
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
