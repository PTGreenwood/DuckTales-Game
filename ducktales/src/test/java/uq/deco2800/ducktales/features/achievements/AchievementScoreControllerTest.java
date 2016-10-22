package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;


public class AchievementScoreControllerTest extends ApplicationTest {
	
	@Test
	public void initTest() {
		AchievementScoreController scoreController = new AchievementScoreController();
		int expectedAchievementScore = scoreController.getAchieve();
		int actualAchievementScore = 0;
		assertTrue(expectedAchievementScore == actualAchievementScore);
	}
	
	@Test
	public void setAchieveTest() {
		AchievementScoreController scoreController = new AchievementScoreController();
		scoreController.setAchieve(10);
		int expectedAchievementScore = scoreController.getAchieve();
		int actualAchievementScore = 10;
		assertTrue(expectedAchievementScore == actualAchievementScore);		
	}
	
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

	@Test
	public void achievementHolderTest() {
		
		AchievementScoreController scoreController = new AchievementScoreController();
		LevelHandler.getInstance().setLevel(1);
		
		assertTrue(scoreController.achievementHolder() == 2);
	
	}
	
	@Test
	public void singletonTest() {
		AchievementScoreController scoreController = AchievementScoreController.getInstance();
		assertTrue(scoreController.equals(AchievementScoreController.getInstance()));
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
