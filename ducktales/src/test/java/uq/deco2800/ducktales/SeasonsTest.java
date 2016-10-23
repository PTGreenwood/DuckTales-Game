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
		
		//Initial Spring Season Testing (Initial values on creation).
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
		
		//Summer Season Testing  (Initial values on creation).
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
		//Autumn Season Testing (Initial values on creation).
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
		//Winter Season Testing (Initial values on creation).
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
	/* Set and Gets
	 * New Test made stop the other from being too long.
	 */
	@Test
	public void setGetNewDeatils(){
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		//Initial Spring Season Testing (Initial values on creation).
		SeasonType correctSpName = SeasonType.SPRING;
		float correctSpHumidity = 8.0f;
		int correctSpMaxTemperature = 25;
		int correctSpMinTemperature = 5;
		int correctSpNightFall = 4;
		int correctSpDayBreak = 5;
		float correctSpAtmosphericIceLevel = 1.0f;
		float correctSpWindLevel = 1.0f;
		float correctSpFireDanger = 2.8f;
		
		tm.getSeasonManager().getCurrentSeason().setHumidity(correctSpHumidity);
		tm.getSeasonManager().getCurrentSeason().setMaximumTemperature(correctSpMaxTemperature);
		tm.getSeasonManager().getCurrentSeason().setMinimumTemperature(correctSpMinTemperature);
		tm.getSeasonManager().getCurrentSeason().setSunset(correctSpNightFall);
		tm.getSeasonManager().getCurrentSeason().setSunrise(correctSpDayBreak);
		tm.getSeasonManager().getCurrentSeason().setAtmosphericIceLevel(correctSpAtmosphericIceLevel);
		tm.getSeasonManager().getCurrentSeason().setWindlevel(correctSpWindLevel);
		tm.getSeasonManager().getCurrentSeason().setFireDanger(correctSpFireDanger);		
		
		assertEquals(correctSpName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctSpHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctSpMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctSpMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctSpNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctSpDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctSpAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctSpWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctSpFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
		tm.getSeasonManager().updateSeason(1);
		
		//Summer Season Testing  (Initial values on creation).
		SeasonType correctSuName = SeasonType.SUMMER;
		float correctSuHumidity = 2.7f;
		int correctSuMaxTemperature = 26;
		int correctSuMinTemperature = 16;
		int correctSuNightFall = 5;
		int correctSuDayBreak = 6;
		float correctSuAtmosphericIceLevel = 0.0f;
		float correctSuWindLevel = 3.0f;
		float correctSuFireDanger = 1.9f;
		
		tm.getSeasonManager().getCurrentSeason().setHumidity(correctSuHumidity);
		tm.getSeasonManager().getCurrentSeason().setMaximumTemperature(correctSuMaxTemperature);
		tm.getSeasonManager().getCurrentSeason().setMinimumTemperature(correctSuMinTemperature);
		tm.getSeasonManager().getCurrentSeason().setSunset(correctSuNightFall);
		tm.getSeasonManager().getCurrentSeason().setSunrise(correctSuDayBreak);
		tm.getSeasonManager().getCurrentSeason().setAtmosphericIceLevel(correctSuAtmosphericIceLevel);
		tm.getSeasonManager().getCurrentSeason().setWindlevel(correctSuWindLevel);
		tm.getSeasonManager().getCurrentSeason().setFireDanger(correctSuFireDanger);	
		
		assertEquals(correctSuName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctSuHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctSuMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctSuMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctSuNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctSuDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctSuAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctSuWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctSuFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
		tm.getSeasonManager().updateSeason(2);
		//Autumn Season Testing (Initial values on creation).
		SeasonType correctAuName = SeasonType.AUTUMN;
		float correctAuHumidity = 1.8f;
		int correctAuMaxTemperature = 18;
		int correctAuMinTemperature = 8;
		int correctAuNightFall = 15;
		int correctAuDayBreak = 10;
		float correctAuAtmosphericIceLevel = 0.0f;
		float correctAuWindLevel = 1.7f;
		float correctAuFireDanger = 0.6f;
		
		tm.getSeasonManager().getCurrentSeason().setHumidity(correctAuHumidity);
		tm.getSeasonManager().getCurrentSeason().setMaximumTemperature(correctAuMaxTemperature);
		tm.getSeasonManager().getCurrentSeason().setMinimumTemperature(correctAuMinTemperature);
		tm.getSeasonManager().getCurrentSeason().setSunset(correctAuNightFall);
		tm.getSeasonManager().getCurrentSeason().setSunrise(correctAuDayBreak);
		tm.getSeasonManager().getCurrentSeason().setAtmosphericIceLevel(correctAuAtmosphericIceLevel);
		tm.getSeasonManager().getCurrentSeason().setWindlevel(correctAuWindLevel);
		tm.getSeasonManager().getCurrentSeason().setFireDanger(correctAuFireDanger);		
		
		assertEquals(correctAuName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctAuHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctAuMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctAuMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctAuNightFall, tm.getSeasonManager().getCurrentSeason().getTimeNightFall());
		assertEquals(correctAuDayBreak, tm.getSeasonManager().getCurrentSeason().getTimeDayBreak());
		assertEquals(correctAuAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctAuWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctAuFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
		tm.getSeasonManager().updateSeason(3);
		//Winter Season Testing (Initial values on creation).
		SeasonType correctWiName = SeasonType.WINTER;
		float correctWiHumidity = 0.5f;
		int correctWiMaxTemperature = 11;
		int correctWiMinTemperature = 0;
		int correctWiNightFall = 12;
		int correctWiDayBreak = 15;
		float correctWiAtmosphericIceLevel = 4.8f;
		float correctWiWindLevel = 1.0f;
		float correctWiFireDanger = 0.0f;
		
		tm.getSeasonManager().getCurrentSeason().setHumidity(correctWiHumidity);
		tm.getSeasonManager().getCurrentSeason().setMaximumTemperature(correctWiMaxTemperature);
		tm.getSeasonManager().getCurrentSeason().setMinimumTemperature(correctWiMinTemperature);
		tm.getSeasonManager().getCurrentSeason().setSunset(correctWiNightFall);
		tm.getSeasonManager().getCurrentSeason().setSunrise(correctWiDayBreak);
		tm.getSeasonManager().getCurrentSeason().setAtmosphericIceLevel(correctWiAtmosphericIceLevel);
		tm.getSeasonManager().getCurrentSeason().setWindlevel(correctWiWindLevel);
		tm.getSeasonManager().getCurrentSeason().setFireDanger(correctWiFireDanger);		
		
		assertEquals(correctWiName, tm.getSeasonManager().getCurrentSeason().getName());
		assertEquals(correctWiHumidity, tm.getSeasonManager().getCurrentSeason().getHumidity(), 1.0f);
		assertEquals(correctWiMaxTemperature, tm.getSeasonManager().getCurrentSeason().getMaxTemp());
		assertEquals(correctWiMinTemperature, tm.getSeasonManager().getCurrentSeason().getMinTemp());
		assertEquals(correctWiAtmosphericIceLevel, tm.getSeasonManager().getCurrentSeason().getAtmosphericIceLevel(), 1.0f);
		assertEquals(correctWiWindLevel, tm.getSeasonManager().getCurrentSeason().getWindLevel(), 1.0f);
		assertEquals(correctWiFireDanger, tm.getSeasonManager().getCurrentSeason().getFireDanger(), 1.0f);
		
	}
	
	/*Incrementing Testing */
	@Test
	public void incrementBoundsAndValues() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		int correctDoNothingTemp = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature();
		int correctIncrementTillMaxTemp = tm.getSeasonManager().getCurrentSeason().getMaxTemp();
		//Incrementing (both bounds).
		//Modifier <0 for a do nothing.
		tm.getSeasonManager().getCurrentSeason().incrementCurrentTemperature(-5);
		assertEquals(correctDoNothingTemp, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		//Modifier >10 for a loop through to reduce the modifier to a doable figure
		//Result <= maxTemperature.
		tm.getSeasonManager().getCurrentSeason().incrementCurrentTemperature(20);
		assertEquals(correctIncrementTillMaxTemp, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		//Normal incrementing (by 1).
		tm.getSeasonManager().updateSeason(3); //Resets to new season to have base temperatures again.
		int correctTemperatureAfterIncrement = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature() + 1;
		
		tm.getSeasonManager().getCurrentSeason().incrementCurrentTemperature(1);
		assertEquals(correctTemperatureAfterIncrement, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
	}
	
	/*Decrementing Testing */
	@Test
	public void decrementingBoundsAndValues() {
		TimeManager tm = new TimeManager();
		SeasonManager sm = new SeasonManager();
		tm.setSeasonManager(sm);
		
		int correctDoNothingTemp = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature();
		int correctIncrementTillMinTemp = tm.getSeasonManager().getCurrentSeason().getMinTemp();
		//Incrementing (both bounds).
		//Modifier <0 for a do nothing.
		tm.getSeasonManager().getCurrentSeason().decrementCurrentTemperature(-5);
		assertEquals(correctDoNothingTemp, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		//Modifier >10 for a loop through to reduce the modifier to a doable figure
		//Result <= maxTemperature.
		tm.getSeasonManager().getCurrentSeason().decrementCurrentTemperature(20);
		assertEquals(correctIncrementTillMinTemp, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
		
		//Normal decrementing (by 1).
		tm.getSeasonManager().updateSeason(3); //Resets to new season to have base temperatures again.
		int correctTemperatureAfterDecrement = tm.getSeasonManager().getCurrentSeason().getCurrentTemperature() - 1;
		
		tm.getSeasonManager().getCurrentSeason().decrementCurrentTemperature(1);
		assertEquals(correctTemperatureAfterDecrement, tm.getSeasonManager().getCurrentSeason().getCurrentTemperature());
	}
}