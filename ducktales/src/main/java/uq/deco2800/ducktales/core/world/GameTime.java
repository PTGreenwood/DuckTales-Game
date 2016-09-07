package uq.deco2800.ducktales.core.world;
import uq.deco2800.ducktales.util.Tickable;

/*
 *
 * GameTime Encompasses all time, day, season and year data
 * Each tick the time is updated and this class does
 * things with that information to update other things with
 * it.
 *
 */
public class GameTime implements Tickable {


	//Instantiate the GameTime
	protected int day;
	protected int year;
	protected Season season;

	private int hour;
	private int minute;


	/**
	 * 20 Day Seasons. 4 Seasons to 1 year.
	 * @param d
	 * 		- Integer: Current Day (1 >= d <= 80)
	 * @param y
	 * 		- Integer: Current Year (>0)
	 */
	public GameTime() {

		this.day = 1; //Set day of calendar at 1
		this.year = 1; //Set year of calendar at 1

		//As fixed variables are set for day and year
		//So to will the season automatically start in Spring
		this.season = Season.SPRING;


		//Considering making this just one number and mathing it to get the right time
		//depending on day and year. Can then also have total time in place. I spose I
		//could just math the total time off years and days...

		this.hour = 0; //Set the hour of the time
		this.minute = 0; //Set the minutes of the time.
	}

	/**
	 * Gets the current hour of the Time
	 *
	 * @return Integer - Hour
	 *
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * Gets the current minute of the Time
	 *
	 * @return Integer - Minute
	 *
	 */
	public int getMinute() {
		return this.minute;
	}

	/**
	 * Sets the Time with the specified Hour.
	 *
	 * 	@param Int setHour
	 * 			-	Integer of the given hour must be 0 >= setHour <= 23
	 *	@throws Exception
	 *			-	Throws GameTimeException if number is out of range
	 */
	public void setHour(int setHour)  {
		if((setHour >= 0) && (setHour <= 23)) {
			this.hour = setHour;
		} else {
			throw new GameTimeException("Error: Hour must be an Integer >= 0 && <= 23");
		}
	}

	/**
	 * Sets the Time with the specified Minute.
	 *
	 * 	@param Int setMinute
	 * 			-	Integer of the given minute must be 0 >= setMinute <= 59
	 *	@throws Exception
	 *			-	Throws Exception(Exception) if number is out of range
	 */
	public void setMinute(int setMinute){
		if((setMinute >= 0) && (setMinute <= 59)) {
			this.minute = setMinute;
		} else {
			throw new GameTimeException("Error: Minute must be an Integer >= 0 && <= 59");
		}
	}

	/**
	 * Class implements tick method from Tickable interface
	 * Tick method is called within OldGameLoop class
	 *
	 */
	@Override
	public void tick() {
		minute++;
		if(minute == 60) {
			hour++;
			minute = 0;
		}
		if(hour == 24) {
			day++;
			hour = 0;
			//Left this hear to print out the time once a day
			System.out.println(printGameTime());
		} if(this.day/this.year > 80) {
			this.year++;
		}
	//Uncomment this to see a print out of the current time every minute update
	//System.out.println(printGameTime());
	}

	/**
	 * Retrieves the current day of the year
	 * @return integer: currentDay of year
	 */
	public int getCurrentDay() {
		return this.day;
	}

	/**
	 * Retrieves the current year of the Calendar
	 * @return integer: currentYear on Calendar
	 */
	public int getCurrentYear() {
		return this.year;
	}

	/**
	 * Retrieves the current season
	 * @return Season: currentSeason of world
	 */
	public Season getCurrentSeason() {
		return this.season;
	}

	/**
	 * Sets the current season to be a season passed in
	 * Note: must be of type Season
	 *
	 * @param Season season: Spring, Summer, Autumn or Winter
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * Sets the current year of the Calendar
	 * to be whatever is passed in
	 *
	 * @param integer yearSet: year to set the Calendar
	 */
	public void setYear(int yearSet) {
		if(yearSet >= 1) {
			this.year = yearSet;
		} else {
			throw new GameTimeException("Error: Year must be an Integer >= 1");
		}
	}

	/**
	 * Sets the current day of the Calendar
	 * @param Integer daySet: day to set the Calendar
	 */
	public void setDay(int daySet) {
		if(daySet >= 1) {
			this.day = daySet;
		} else {
			throw new GameTimeException("Error: Day must be an Integer >= 1");
		}
	}

	/** Print out a String that has the
	 * Current Hour, Current Minute and Current Day Number
	 *
	 * @return a lame string telling the current time for lame debug
	 */
	public String printGameTime() {
		int h = hour;
		int m = minute;
		int d = this.day;

		return "Current Time is: " + h + ":" + m + " day: " + d;
	}
}
