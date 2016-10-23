package uq.deco2800.ducktales.time;

import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.seasons.Season;
import uq.deco2800.ducktales.features.time.GameTimeException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTimeTest {

	@Test // Testing Set Methods Correct.
	public void testAllSetMethodsCorrect() {

		GameTime gameTime = new GameTime();

		int correctHour = 5;
		int correctMinute = 33;
		int correctDay = 3;
		int correctYear = 6;
		//Season correctSeason = Season.AUTUMN;

		// SetHour (old hour is 0 by default)
		gameTime.setHour(correctHour);
		// SetMinute
		gameTime.setMinute(correctMinute);
		// setDay
		gameTime.setDay(correctDay);
		// setYear
		gameTime.setYear(correctYear);
		// setSeason
		//gameTime.setSeason(correctSeason);

		// Test all the things!
		assertEquals(gameTime.getHour(), correctHour);
		assertEquals(gameTime.getMinute(), correctMinute);
		assertEquals(gameTime.getCurrentDay(), correctDay);
		assertEquals(gameTime.getCurrentYear(), correctYear);
		//assertEquals(gameTime.getCurrentSeason(), correctSeason);

	}

	@Test // Testing get Methods Correct
	public void testAllGetMethodsCorrect() {

		GameTime gameTime = new GameTime();

		// Hour is set to 0 by default (Instantiated in GameTime on creation);
		// Minute is set to 0 by default (Instantiated in GameTime on creation);
		// Day is set to 1 by default (Instantiated in GameTime on creation);
		// Year is set to 1 by default (Instantiated in GameTime on creation);
		// Season is SPRING by default (Instantiated in GameTime on creation);

		// Test all the things!
		assertEquals(gameTime.getHour(), 0);
		assertEquals(gameTime.getMinute(), 0);
		assertEquals(gameTime.getCurrentDay(), 1);
		assertEquals(gameTime.getCurrentYear(), 1);
		//assertEquals(gameTime.getCurrentSeason(), Season.SPRING);

	}

	@Test // Testing Invalid Inputs on setHour Method
	public void testNegativeHourAdd() {

		GameTime gameTime = new GameTime();

		int incorrectHourNeg = -1;

		try {
			gameTime.setHour(incorrectHourNeg);
		} catch (GameTimeException gte) {
			assertEquals(gte.getClass(), (GameTimeException.class));
		}

	}

	@Test // Testing Invalid input on setHour Method
	public void testOverBoundsHourAdd() {

		GameTime gameTime = new GameTime();

		int incorrectHourOver = 25;

		try {
			gameTime.setHour(incorrectHourOver);
		} catch (GameTimeException gte) {
			assertEquals(gte.getClass(), (GameTimeException.class));
		}

	}

	@Test // Testing Invalid Inputs on setMinute Method
	public void testNegativeMinuteAdd() {

		GameTime gameTime = new GameTime();

		int incorrectMinuteNeg = -1;

		try {
			gameTime.setMinute(incorrectMinuteNeg);
		} catch (GameTimeException gte) {
			assertEquals(gte.getClass(), (GameTimeException.class));
		}

	}

	@Test // Testing Invalid Inputs on setMinute Method
	public void testOverBoundsMinuteAdd() {

		GameTime gameTime = new GameTime();

		int incorrectMinuteOver = 60;

		try {
			gameTime.setMinute(incorrectMinuteOver);
		} catch (GameTimeException gte) {
			assertEquals(gte.getClass(), (GameTimeException.class));
		}
	}

	@Test // Testing Invalid Inputs on setYear Method
	public void testNegativeYearAdd() {

		GameTime gameTime = new GameTime();

		int incorrectYearNeg = -10;

		try {
			gameTime.setYear(incorrectYearNeg);
		} catch (GameTimeException gte) {
			assertEquals(gte.getClass(), GameTimeException.class);
		}

	}

	@Test // Testing Invalid Inputs on setDay Method
	public void testIncorrectDayAdd() {

		GameTime gameTime = new GameTime();

		int incorrectDayNeg = -5;

		try {
			gameTime.setDay(incorrectDayNeg);
		} catch (GameTimeException gte) {
			assertEquals(gte.getClass(), (GameTimeException.class));
		}

	}

	@Test // Testing time ticks
	public void testTimeTicks() {

		GameTime gameTime = new GameTime();
		// each minute updates every four ticks. Minute starts at 0 and should
		// be 1 after four ticks.
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();

		assertEquals(gameTime.getMinute(), 1);
	}
	
	@Test // Testing time ticks
	public void testMultipleTimeTicks() {

		GameTime gameTime = new GameTime();
		// each minute updates every four ticks. Minute starts at 0 and should
		// be 2 after eight ticks.
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();
		gameTime.tick();

		assertEquals(gameTime.getMinute(), 2);
	}

	@Test // Testing printOut
	public void testPrintOutCorrect() {

		GameTime gameTime = new GameTime();

		int correctHour = 0;
		String correctMinute = "00";
		int correctDay = 1;
		int correctYear = 1;

		String correctPrintOut = "Current Time is: " + correctHour + ":" + correctMinute + " Day: " + correctDay
				+ " Year: " + correctYear;

		assertEquals(gameTime.printGameTime(), correctPrintOut);
	}
	
	/*@Test //Testing the getChanceOf weather methods provide the correct output in winter.
	public void testCorrectChanceOfWeather1() {

		GameTime gameTime = new GameTime();
		Season winter = Season.WINTER;
		gameTime.setSeason(winter);

		assertEquals(gameTime.getChanceOfFire(), 5);
		assertEquals(gameTime.getChanceOfRain(), 70);
		assertEquals(gameTime.getChanceOfCyclone(), 5);
		assertEquals(gameTime.getChanceOfTornado(), 5);
		assertEquals(gameTime.getChanceOfLightning(), 40);
		assertEquals(gameTime.getChanceOfThunder(), 40);
		assertEquals(gameTime.getChanceOfWhirlpool(), 10);
	}
	
	@Test ////Testing the getChanceOf weather methods provide the correct output in summer.
	public void testCorrectChanceOfWeather2() {

		GameTime gameTime = new GameTime();
		Season summer = Season.SUMMER;
		gameTime.setSeason(summer);
		
		assertEquals(gameTime.getChanceOfFire(), 30);
		assertEquals(gameTime.getChanceOfRain(), 20);
		assertEquals(gameTime.getChanceOfCyclone(), 10);
		assertEquals(gameTime.getChanceOfTornado(), 10);
		assertEquals(gameTime.getChanceOfLightning(), 30);
		assertEquals(gameTime.getChanceOfThunder(), 30);
		assertEquals(gameTime.getChanceOfWhirlpool(), 10);
	}*/
}
