package uq.deco2800.ducktales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.features.seasons.SeasonType;
import uq.deco2800.ducktales.features.time.TimeManager;

public class SeasonsTest {

	/* First Test
	 * 
	 * Tests all getter methods in Seasons
	*/ 
	@Test 
	public void getDetails() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		//Spring Season Testing
		SeasonType correctSpName = SeasonType.SPRING;
		float correctSpHumidity = 2.4f;
		int correctSpMaxTemperature = 20;
		int correctSpCurrentTemperature = 13;
		int correctSpMinTemperature = 11;
		int correctSpTimeNightFall = 19;
		int correctSpTimeDayBreak = 6;
		float correctSpAtmosphericIceLevel = 0.0f;
		float correctSpWindLevel = 2.0f;
		float correctSpFireDanger = 0.8f;
		
		assertEquals(correctSpName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctSpHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctSpMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctSpCurrentTemperature, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		assertEquals(correctSpMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctSpTimeNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctSpTimeDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctSpAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctSpWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctSpFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
		tm.getSeasonManager().updateSeason(1);
		
		//Summer Season Testing
		SeasonType correctSuName = SeasonType.SUMMER;
		float correctSuHumidity = 2.7f;
		int correctSuMaxTemperature = 26;
		int correctSuCurrentTemperature = 22;
		int correctSuMinTemperature = 16;
		int correctSuTimeNightFall = 21;
		int correctSuTimeDayBreak = 4;
		float correctSuAtmosphericIceLevel = 0.0f;
		float correctSuWindLevel = 3.0f;
		float correctSuFireDanger = 1.9f;
		
		assertEquals(correctSuName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctSuHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctSuMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctSuCurrentTemperature, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		assertEquals(correctSuMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctSuTimeNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctSuTimeDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctSuAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctSuWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctSuFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
		tm.getSeasonManager().updateSeason(2);
		//Autumn Season Testing
		SeasonType correctAuName = SeasonType.AUTUMN;
		float correctAuHumidity = 1.8f;
		int correctAuMaxTemperature = 18;
		int correctAuCurrentTemperature = 12;
		int correctAuMinTemperature = 8;
		int correctAuTimeNightFall = 20;
		int correctAuTimeDayBreak = 5;
		float correctAuAtmosphericIceLevel = 0.0f;
		float correctAuWindLevel = 1.7f;
		float correctAuFireDanger = 0.6f;
		
		assertEquals(correctAuName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctAuHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctAuMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctAuCurrentTemperature, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		assertEquals(correctAuMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctAuTimeNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctAuTimeDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctAuAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctAuWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctAuFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
		tm.getSeasonManager().updateSeason(3);
		//Winter Season Testing
		SeasonType correctWiName = SeasonType.WINTER;
		float correctWiHumidity = 0.5f;
		int correctWiMaxTemperature = 11;
		int correctWiCurrentTemperature = 7;
		int correctWiMinTemperature = 0;
		int correctWiTimeNightFall = 17;
		int correctWiTimeDayBreak = 7;
		float correctWiAtmosphericIceLevel = 4.8f;
		float correctWiWindLevel = 1.0f;
		float correctWiFireDanger = 0.0f;
		
		assertEquals(correctWiName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctWiHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctWiMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctWiCurrentTemperature, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		assertEquals(correctWiMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctWiTimeNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctWiTimeDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctWiAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctWiWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctWiFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
	}
	
	/*
	 * Second test.
	 * 
	 * Test set methods and get methods on the new non static values.
	 */
	@Test
	public void setDetails() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		
	}
}