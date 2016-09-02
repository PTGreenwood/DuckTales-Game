package uq.deco2800.ducktales.world;
import uq.deco2800.ducktales.util.Tickable;


/*
 * 
 * DuckTime Encompasses all time, day and year data
 * Each tick the time is updated and this class does
 * things with that information to update other things with
 * it.
 * 
 */
public class GameTime implements Tickable {


	//Instantiate the Calendar variables
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
	 *			-	Throws Exception(Exception) if number is out of range
	 */
	public void setHour(int setHour){// throws Exception {
		if(setHour < 0) {
			//throw new Exception("Hour must be >= 0");
		} else if (setHour > 23) {
			//throw new Exception("Hour must be <= 23");
		} else {
		this.hour = setHour;
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
	public void setMinute(int setMinute){// throws Exception {
		if(setMinute < 0) {
			//throw new Exception("Minute must be >= 0");
			//then leave as is.
		} else if (setMinute > 59) {
			//throw new Exception("Minute must be <= 59");
			//then leave as is
		} else {
		this.minute = setMinute;
		}
	}
	/*Notes/thoughts
	*
	*Need to somehow implement the day counter in for when it reaches 24 hours in the day
	*This could be super.day++ but that cause's errors
	*Maybe I'm implementing Super/implements wrong.
	*
	*/
	
	/**
	 * Class implements tick method from Tickable interface
	 * Tick method is called within GameLoop class
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
			System.out.println(printDuckTime());
		} if(this.day/this.year > 80) {
			this.year++;
		}
	//Uncomment this to see a print out of the current time every minute update
	System.out.println(printDuckTime());
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
		this.year = yearSet;
	}
	
	/**
	 * Sets the current day of the Calendar
	 * @param Integer daySet: day to set the Calendar
	 */
	private void setDay(int daySet) {
		this.day = daySet;
	}
	

	/** Print out a String that has the 
	 * Current Hour, Current Minute and Current Day Number
	 * 
	 * @return a lame string telling the current time for lame debug
	 */
	private String printDuckTime() {
		int h = hour;
		int m = minute;
		int d = this.day;
		
		return "Current Time is: " + h + ":" + m + " day: " + d;
	} 
	
	/**
	 * markDate Method.
	 * To be implemented later
	 * 
	 * Main Point is for other groups to be able to access the game calendar
	 * and save dates/let things happen on certain dates within the game.
	 * 
	 * @param date object -> to be finalised
	 */
	/*
	public void markDate(int date) {
		
	}
	*/
	
	
	/**
	 * 
	 * Sets up a date event in the Calendar that records when something
	 * has been started, and when it is going to be finished (useful for Calendar events)
	 * 
	 * @param startDate
	 * 			- Integer for the day starting (Calendar.getDay())
	 * @param endDate
	 * 			- Integer for the day chosen to end
	 */
	/*public void setStartandEnd(int startDay, int endDay) {
		this.markedDates.add(startDay, endDay);
	}
	*/
}
	
	
