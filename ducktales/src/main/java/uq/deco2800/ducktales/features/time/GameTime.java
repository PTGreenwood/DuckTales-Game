package uq.deco2800.ducktales.features.time;

import uq.deco2800.ducktales.features.seasons.Season;
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

	// Instantiate the GameTime
	protected int day;
	protected int year;
	protected int seasonDayTracker;

	private int hour;
	private int minute;
	private int tickCounter = 0;

	/**
	 * 20 Day Seasons. 4 Seasons to 1 year.
	 * 
	 * @param d
	 *            - Integer: Current Day (1 >= d <= 80)
	 * @param y
	 *            - Integer: Current Year (>0)
	 */
	public GameTime() {

		this.day = 1; // Set day of calendar at 1
		this.year = 1; // Set year of calendar at 1
		this.seasonDayTracker = 1;
		

		this.hour = 0; // Set the hour of the time
		this.minute = 0; // Set the minutes of the time.
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
	 * @param Int
	 *            setHour - Integer of the given hour must be 0 >= setHour <= 23
	 * @throws Exception
	 *             - Throws GameTimeException if number is out of range
	 */
	public void setHour(int setHour) {
		if ((setHour >= 0) && (setHour <= 23)) {
			this.hour = setHour;
		} else {
			throw new GameTimeException("Error: Hour must be an Integer >= 0 && <= 23");
		}
	}

	/**
	 * Sets the Time with the specified Minute.
	 *
	 * @param Int
	 *            setMinute - Integer of the given minute must be 0 >= setMinute
	 *            <= 59
	 * @throws Exception
	 *             - Throws Exception(Exception) if number is out of range
	 */
	public void setMinute(int setMinute) {
		if ((setMinute >= 0) && (setMinute <= 59)) {
			this.minute = setMinute;
		} else {
			throw new GameTimeException("Error: Minute must be an Integer >= 0 && <= 59");
		}
	}

	/**
	 * Class implements tick method from Tickable interface Tick method is
	 * called within GameLoop class
	 *
	 */
	@Override
	public void tick() {
		if (tickCounter == 3) {
			tickCounter = 0;
			minute++;
			if (minute == 60) {
				hour++;
				minute = 0;
			}
			if (hour == 24) {
				day++;
				seasonDayTracker++;
				hour = 0;
			}
			if (this.day / this.year > 80) {
				this.year++;
			}
		} else {
			tickCounter++;
		}

	}

	/**
	 * Retrieves the current day of the year
	 * 
	 * @return integer: currentDay of year
	 */
	public int getCurrentDay() {
		return this.day;
	}

	/**
	 * Retrieves the current year of the Calendar
	 * 
	 * @return integer: currentYear on Calendar
	 */
	public int getCurrentYear() {
		return this.year;
	}


	/**
	 * Sets the current year of the Calendar to be whatever is passed in
	 *
	 * @param integer
	 *            yearSet: year to set the Calendar
	 */
	public void setYear(int yearSet) {
		if (yearSet >= 1) {
			this.year = yearSet;
		} else {
			throw new GameTimeException("Error: Year must be an Integer >= 1");
		}
	}

	/**
	 * Sets the current day of the Calendar
	 * 
	 * @param Integer
	 *            daySet: day to set the Calendar
	 */
	public void setDay(int daySet) {
		if (daySet >= 1) {
			this.day = daySet;
		} else {
			throw new GameTimeException("Error: Day must be an Integer >= 1");
		}
	}

	/**
	 * Print out a String that has the Current Hour, Current Minute and Current
	 * Day Number
	 *
	 * @return a string telling the current time
	 */
	public String printGameTime() {
		int h = hour;
		String m = String.format("%02d", minute);
		int d = this.day;
		int y = this.year;

		return "Current Time is: " + h + ":" + m + " Day: " + d + " Year: " + y;
	}

	/**
	 * Get the seasonalDay Tracker. 20 days in each season
	 * 
	 * @return int
	 * 			- Returns the day within the season.
	 */
	public int getSeasonalDayTracker() {
		return this.seasonDayTracker;
	}
	
	/**
	 * Reset the seasonalDay tracker when changing seasons
	 * Utilised by TimeManager.
	 */
	public void resetTracker() {
		this.seasonDayTracker = 1;
	}

}
