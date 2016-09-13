package uq.deco2800.ducktales;

import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.seasons.Season;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SeasonTest {

	//Instantiate Here 
	//DuckClock clock = new DuckClock();
	GameTime gameTime = new GameTime();
	
	@Test // For firstTest testing (not sure yet :S)
	public void getSeasonVariables() {
		
		Season correctSeason = Season.AUTUMN;
		String correctName = "Autumn";
		float correctHumidity = 0.2f;
		int correctMinTemp = 10;
		int correctMaxTemp = 15;
		int correctNightFall = 8;
		int correctDayBreak = 5;
		
		assertEquals(correctSeason.getName(), correctName);
		assertEquals(correctSeason.getHumidity(), correctHumidity, 0);
		assertEquals(correctSeason.getMinTemp(), correctMinTemp);
		assertEquals(correctSeason.getMaxTemp(), correctMaxTemp);
		assertEquals(correctSeason.getTimeNightFall(), correctNightFall);
		assertEquals(correctSeason.getTimeDayBreak(), correctDayBreak);

	}
	
	@Test //for secondTest testing (also not sure if we will use it just yet)
	public void secondTest() {
		
		//Temp Variables
	 	
		
		//Test Here:
	 	//assertTrue("");
		
	}


}
