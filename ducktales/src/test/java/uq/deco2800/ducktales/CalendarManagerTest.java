package uq.deco2800.ducktales;

import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.seasons.Season;
import uq.deco2800.ducktales.features.seasons.CalendarManager;
import uq.deco2800.ducktales.features.seasons.SeasonManager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalendarManagerTest {

	//Instantiate Here 
	//DuckClock clock = new DuckClock();
	CalendarManager calendarManager = new CalendarManager();
	SeasonManager seasonManager = new SeasonManager();
	
	@Test // For firstTest testing
	public void getSeasonName() {
		
		String correctSpringSeasonName = "Spring";
		String correctSummerSeasonName = "Summer";
		String correctAutumnSeasonName = "Autumn";
		String correctWinterSeasonName = "Winter";
		String season;
		
		season = calendarManager.seasonManager.getSeason().getName();
		assertEquals(correctSpringSeasonName, season);
		calendarManager.updateSeason(1);
		
		season = calendarManager.seasonManager.getSeason().getName();
		assertEquals(correctSummerSeasonName, season);
		calendarManager.updateSeason(2);
		
		season = calendarManager.seasonManager.getSeason().getName();
		assertEquals(correctAutumnSeasonName, season);
		calendarManager.updateSeason(3);
		
		season = calendarManager.seasonManager.getSeason().getName();
		assertEquals(correctWinterSeasonName, season);
		calendarManager.updateSeason(1);

	}
	
	@Test //for secondTest testing (also not sure if we will use it just yet)
	public void secondTest() {
		
		//Temp Variables
	 	
		
		//Test Here:
	 	//assertTrue("");
		
	}


}
