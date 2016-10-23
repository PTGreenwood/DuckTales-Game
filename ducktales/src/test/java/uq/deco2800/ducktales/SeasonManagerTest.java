package uq.deco2800.ducktales;

import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.seasons.Season;
import uq.deco2800.ducktales.features.seasons.Spring;
import uq.deco2800.ducktales.features.seasons.Summer;
import uq.deco2800.ducktales.features.seasons.Autumn;
import uq.deco2800.ducktales.features.seasons.Winter;

import uq.deco2800.ducktales.features.weather.Weather;
import uq.deco2800.ducktales.features.weather.InvalidWeatherChanceException;
import uq.deco2800.ducktales.features.weather.Rain;
import uq.deco2800.ducktales.features.weather.Snow;
import uq.deco2800.ducktales.features.weather.Storm;
import uq.deco2800.ducktales.features.weather.StormType;
import uq.deco2800.ducktales.features.weather.Fire;
import uq.deco2800.ducktales.features.weather.WeatherChance;
import uq.deco2800.ducktales.features.weather.WeatherEvents;

import uq.deco2800.ducktales.features.seasons.SeasonManager;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SeasonManagerTest {

	//Instantiate Here 

	
	/* First Test
	 * 
	 * Testing to get the appropriate season name (for each).
	 * Testing to update the season to the next one.
	*/ 
	@Test 
	public void getCurrentSeason() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		String correctSpringSeasonName = "Spring";
		String correctSummerSeasonName = "Summer";
		String correctAutumnSeasonName = "Autumn";
		String correctWinterSeasonName = "Winter";
				
		String season;
		
		/*
		 * Correct Updating of the Seasons
		*/
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctSpringSeasonName, season);
		tm.getSeasonManager().updateSeason(1);
		
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctSummerSeasonName, season);
		tm.getSeasonManager().updateSeason(2);
		
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctAutumnSeasonName, season);
		tm.getSeasonManager().updateSeason(3);
		
		season = tm.getSeasonManager().getCurrentSeason().getName();
		assertEquals(correctWinterSeasonName, season);
		tm.getSeasonManager().updateSeason(0);
		
	}
	/* Second Test
	 * 
	 * Testing for the return of a correct Season Data list.
	*/
	@Test 
	public void getSeasonList() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		List<Season> correctSeasonList = new ArrayList<Season>();
		
		Season Spring = new Spring();
		Season Summer = new Summer();
		Season Autumn = new Autumn();
		Season Winter = new Winter();
    	
		correctSeasonList.addAll(Arrays.asList(Spring, Summer, Autumn, Winter));
    	
    	//Compare Classes within the list 
    	List<Season> testList = tm.getSeasonManager().getSeasonList();
    	
    	// Loop through lists to compare all classes.
    	for(int i = 0; i < correctSeasonList.size(); i++) {
    		assertEquals(correctSeasonList.get(i).getClass(), testList.get(i).getClass());
    	}
		
	}
	
	/*Third Test
	 * 
	 * Testing for the return of WeatherEvents hashSet;
	 */
	@Test
	public void getWeatherEvents() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);

		
		WeatherEvents springWeather = new WeatherEvents();
		WeatherEvents summerWeather = new WeatherEvents();
		WeatherEvents autumnWeather = new WeatherEvents();
		WeatherEvents winterWeather = new WeatherEvents();
			
		
		/* Spring WeatherEvents */
		int springFireChance = (int) (tm.getSeasonManager().getSeasonList().get(0).getCurrentTemperature());
		
		int springRainChance = (int) ((tm.getSeasonManager().getSeasonList().get(0).getHumidity()) * 
				tm.getSeasonManager().getSeasonList().get(0).getCurrentTemperature());
		
		int springSnowChance = (int) 0;
		
		int springStormChance = (int) ((tm.getSeasonManager().getSeasonList().get(0).getCurrentTemperature() *
				tm.getSeasonManager().getSeasonList().get(0).getHumidity()) - 
				((tm.getSeasonManager().getSeasonList().get(0).getHumidity() * 
				tm.getSeasonManager().getSeasonList().get(0).getCurrentTemperature()) / 
				tm.getSeasonManager().getSeasonList().get(0).getWindLevel()));
		
		/*Summer WeatherEvents */
		int summerFireChance = (int) (tm.getSeasonManager().getSeasonList().get(1).getCurrentTemperature());
		
		int summerRainChance = (int) ((tm.getSeasonManager().getSeasonList().get(1).getHumidity()) * 
				tm.getSeasonManager().getSeasonList().get(1).getCurrentTemperature());
		
		int summerSnowChance = (int) 0;
		
		int summerStormChance = (int) ((tm.getSeasonManager().getSeasonList().get(1).getCurrentTemperature() *
				tm.getSeasonManager().getSeasonList().get(1).getHumidity()) - 
				((tm.getSeasonManager().getSeasonList().get(1).getHumidity() * 
				tm.getSeasonManager().getSeasonList().get(1).getCurrentTemperature()) / 
				tm.getSeasonManager().getSeasonList().get(1).getWindLevel()));
		
		/* Autumn WeatherEvents */
		int autumnFireChance = (int) (tm.getSeasonManager().getSeasonList().get(2).getCurrentTemperature());
		
		int autumnRainChance = (int) ((tm.getSeasonManager().getSeasonList().get(2).getHumidity()) * 
				tm.getSeasonManager().getSeasonList().get(2).getCurrentTemperature());
		
		int autumnSnowChance = (int) 0;
		
		int autumnStormChance = (int) ((tm.getSeasonManager().getSeasonList().get(2).getCurrentTemperature() *
				tm.getSeasonManager().getSeasonList().get(2).getHumidity()) - 
				((tm.getSeasonManager().getSeasonList().get(2).getHumidity() * 
				tm.getSeasonManager().getSeasonList().get(2).getCurrentTemperature()) / 
				tm.getSeasonManager().getSeasonList().get(2).getWindLevel()));
		
		
		/* Winter WeatherEvents */
		int winterFireChance = (int) (tm.getSeasonManager().getSeasonList().get(3).getCurrentTemperature());
		
		int winterRainChance = (int) ((tm.getSeasonManager().getSeasonList().get(3).getHumidity()) * 
				tm.getSeasonManager().getSeasonList().get(3).getCurrentTemperature());
		
		int winterSnowChance = (int) (100 - ((tm.getSeasonManager().getSeasonList().get(3).getCurrentTemperature() *
				tm.getSeasonManager().getSeasonList().get(3).getAtmosphericIceLevel())));
		
		int winterStormChance = (int) ((tm.getSeasonManager().getSeasonList().get(3).getCurrentTemperature() *
				tm.getSeasonManager().getSeasonList().get(3).getHumidity()) - 
				((tm.getSeasonManager().getSeasonList().get(3).getHumidity() * 
				tm.getSeasonManager().getSeasonList().get(3).getCurrentTemperature()) / 
				tm.getSeasonManager().getSeasonList().get(3).getWindLevel()));
		
		Weather rain = new Rain();
		Weather fire = new Fire();
		Weather snow = new Snow();
		Weather storm = new Storm(StormType.THUNDER);
		
    	try {
    		WeatherChance spRainChance = new WeatherChance(rain, springRainChance);
    		WeatherChance suRainChance = new WeatherChance(rain, summerRainChance);
    		WeatherChance auRainChance = new WeatherChance(rain, autumnRainChance);
    		WeatherChance wiRainChance = new WeatherChance(rain, winterRainChance);
    		
    		WeatherChance spFireChance = new WeatherChance(fire, springFireChance);
    		WeatherChance suFireChance = new WeatherChance(fire, summerFireChance);
    		WeatherChance auFireChance = new WeatherChance(fire, autumnFireChance);
    		WeatherChance wiFireChance = new WeatherChance(fire, winterFireChance);
    		
    		WeatherChance spSnowChance = new WeatherChance(snow, springSnowChance);
    		WeatherChance suSnowChance = new WeatherChance(snow, summerSnowChance);
    		WeatherChance auSnowChance = new WeatherChance(snow, autumnSnowChance);
    		WeatherChance wiSnowChance = new WeatherChance(snow, winterSnowChance);
    		
    		WeatherChance spStormChance = new WeatherChance(storm, springStormChance);
    		WeatherChance suStormChance = new WeatherChance(storm, summerStormChance);
    		WeatherChance auStormChance = new WeatherChance(storm, autumnStormChance);
    		WeatherChance wiStormChance = new WeatherChance(storm, winterStormChance);

    		springWeather.add(spRainChance);
    		springWeather.add(spFireChance);
    		springWeather.add(spSnowChance);
    		springWeather.add(spStormChance);
    		
    		summerWeather.add(suRainChance);
    		summerWeather.add(suFireChance);
    		summerWeather.add(suSnowChance);
    		summerWeather.add(suStormChance);
    		
    		autumnWeather.add(auRainChance);
    		autumnWeather.add(auFireChance);
    		autumnWeather.add(auSnowChance);
    		autumnWeather.add(auStormChance);
    		
    		winterWeather.add(wiRainChance);
    		winterWeather.add(wiFireChance);
    		winterWeather.add(wiSnowChance);
    		winterWeather.add(wiStormChance);

    		
    	}  catch (InvalidWeatherChanceException e) {
    		System.out.println("ERROR: Chance must be > 0 and <= 100 and weather Cannot be Null");
    	}
		
		
		for (Season seasonIterator : tm.getSeasonManager().getSeasonList()) {
			seasonIterator.setRainWeather();
			seasonIterator.setFireWeather();
			seasonIterator.setSnowWeather();
			seasonIterator.setStormWeather();
		}
		
		assertEquals(springWeather.getWeatherEvents(), 
				tm.getSeasonManager().getSeasonList().get(0).getSeasonalWeatherEvents().getWeatherEvents());
		assertEquals(summerWeather.getWeatherEvents(), 
				tm.getSeasonManager().getSeasonList().get(1).getSeasonalWeatherEvents().getWeatherEvents());
		assertEquals(autumnWeather.getWeatherEvents(), 
				tm.getSeasonManager().getSeasonList().get(2).getSeasonalWeatherEvents().getWeatherEvents());
		assertEquals(winterWeather.getWeatherEvents(), 
				tm.getSeasonManager().getSeasonList().get(3).getSeasonalWeatherEvents().getWeatherEvents());

    		 
    	}
	
	
	/*Fourth Test
	 * 
	 * Testing for the return of WeatherEvents hashSet;
	 */
	@Test
	public void updateTemperatureTest() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		int initialTemperature = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature();

		int correctTemperatureAfterIncreaseBy1 = initialTemperature + 1;

		//Test for temperature Increment by 1
		tm.getSeasonManager().updateTemperature(1, true);

		assertEquals(correctTemperatureAfterIncreaseBy1, 
				tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		int correctTemperatureAfterIncreaseBy2 = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature() + 2;
		
		//Test for temperature Increment by 2 
		tm.getSeasonManager().updateTemperature(2, true);

		assertEquals(correctTemperatureAfterIncreaseBy2, 
				tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		int correctTemperatureAfterDecreaseBy2 = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature() - 2;
		
		//Test for temperature decrement by 2 
		tm.getSeasonManager().updateTemperature(2, false);

		assertEquals(correctTemperatureAfterDecreaseBy2,
				tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		int correctTemperatureAfterDecreaseBy1 = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature() - 1;	


		//Test for temperature decrement by 1
		tm.getSeasonManager().updateTemperature(1, false);

		assertEquals(correctTemperatureAfterDecreaseBy1, 
				tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
	}
}