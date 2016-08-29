package uq.deco2800.ducktales.world;
import uq.deco2800.ducktales.util.Tickable;
//import java.util.List;


/*
 * 
 * Calendar consists of a Calendar object that contains
 * days and years
 * 
 * Inherits data from DuckCLock
 * has Clock Object inside it (probably needs to be fixed)
 */
public class DuckCalendar extends DuckClock implements Tickable {


	//Instantiate a the Calendar variables
	protected int day;
	protected int year;
	protected int season; //0 = Spring, 1 = Summer, 2 = Autumn, 3 = Winter
	
	//Array to hold Dates held
	//Still have to fully implement Date class
	//private List<Date> markedDates;
	
	/**
	 * 20 Day Seasons. 4 Seasons to 1 year.
	 * @param d
	 * 		- Integer: Current Day (1 >= d <= 80)
	 * @param y
	 * 		- Integer: Current Year (>0)
	 */
	public DuckCalendar(int minute, int hour) {
		
		super(minute, hour); //inherit minutes and hours from DuckClock SuperClass
		this.day = 1; //Set day of calendar at 1
		this.year = 1; //Set year of calendar at 1
		this.season = 0; //Set season to 0 (spring)
		
	}
	
	/**
	 * Class implements tick method from Tickable interface
	 * Tick method is called within GameLoop class
	 * 
	 */
	@Override
	public void tick() {
		super.minute++;
		if(super.minute == 60) {
			super.hour++;
			super.minute = 0;
		} 
		if(super.hour == 24) {
			this.day++;
			super.hour = 0;
			//Left this hear to print out the time once a day
			System.out.println(printDuckTime());
		} if(this.day/this.year > 80) {
			this.year++;
		}
	//Uncomment this to see a print out of the current time every minute update
	//System.out.println(printDuckTime());
	}
	
	/**
	 * Sets the current day of the Calendar
	 * @param Integer daySet: day to set the Calendar
	 */
	private void setDay(int daySet) {
		this.day = daySet;
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
	 * Sets the current year of the Calendar
	 * to be whatever is passed in
	 * 
	 * @param integer yearSet: year to set the Calendar
	 */
	public void setYear(int yearSet) {
		this.year = yearSet;
	}
	
	/**
	 * Retrieves the current season
	 * @return integer: currentSeason of world
	 */
	public int getCurrentSeason() {
		return this.season;
	}
		
	/** Print out a String that has the 
	 * Current Hour, Current Minute and Current Day Number
	 * 
	 * @return a lame string telling the current time for lame debug
	 */
	private String printDuckTime() {
		int h = super.hour;
		int m = super.minute;
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
	
	
