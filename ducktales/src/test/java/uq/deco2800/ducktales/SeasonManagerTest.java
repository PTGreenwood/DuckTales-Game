package uq.deco2800.ducktales;

import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.seasons.Season;
import uq.deco2800.ducktales.features.seasons.Spring;
import uq.deco2800.ducktales.features.seasons.Summer;
import uq.deco2800.ducktales.features.seasons.Autumn;
import uq.deco2800.ducktales.features.seasons.Winter;

import uq.deco2800.ducktales.features.seasons.SeasonManager;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SeasonManagerTest {

	//Instantiate Here 
	TimeManager tm = new TimeManager();
	SeasonManager sm = new SeasonManager();
	
	/* First Test
	 * 
	 * Testing to get the appropriate season name (for each).
	 * Testing to update the season to the next one.
	 */
	@Test 
	public void getCurrentSeason() {
		
		tm.setSeasonManager(sm);
		
		String correctSpringSeasonName = "Spring";
		String correctSummerSeasonName = "Summer";
		String correctAutumnSeasonName = "Autumn";
		String correctWinterSeasonName = "Winter";
		
		Season Spring = new Spring();
		Season Summer = new Summer();
		Season Autumn = new Autumn();
		Season Winter = new Winter();
		
		String season;
		
		/*
		 * Correct Updating of the Seasons
		 */
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctSpringSeasonName, season);
		tm.getSeasonManager().updateSeason(Summer);
		
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctSummerSeasonName, season);
		tm.getSeasonManager().updateSeason(Autumn);
		
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctAutumnSeasonName, season);
		tm.getSeasonManager().updateSeason(Winter);
		
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctWinterSeasonName, season);
		tm.getSeasonManager().updateSeason(Spring);
		
	}
	
	@Test //for secondTest testing (also not sure if we will use it just yet)
	public void getSeasonList() {
		
		tm.setSeasonManager(sm);
		
		List<Season> correctSeasonList = new ArrayList<Season>();
		
		Season Spring = new Spring();
		Season Summer = new Summer();
		Season Autumn = new Autumn();
		Season Winter = new Winter();
		
    	correctSeasonList.addAll(Arrays.asList(Spring, Summer, Autumn, Winter));
    	
    	/* Compare Classes within the list */
    	List<Season> testList = tm.getSeasonManager().getSeasonList();
    	
    	// Loop through lists to compare all classes.
    	for(int i = 0; i < correctSeasonList.size(); i++) {
    		assertEquals(correctSeasonList.get(i).getClass(), testList.get(i).getClass());
    	}
		
	}


}
