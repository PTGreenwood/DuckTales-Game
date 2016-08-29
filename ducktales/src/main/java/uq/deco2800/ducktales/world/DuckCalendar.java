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
	int day;
	int year;
	int season; //0 = Spring, 1 = Summer, 2 = Autumn, 3 = Winter
	
	
	//Instantiate a clock within the calendar with variables
	//DuckClock duckClock = new DuckClock();

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
	public DuckCalendar(DuckClock dc, int m, int h) {
		
		super(m, h); //inherit minutes and hours from DuckClock SuperClass
		this.day = 1; //Set day of calendar at 1
		this.year = 1; //Set year of calendar at 1
		this.season = 0; //Set season to 0 (spring)
		
	}
	
	@Override
	public void tick() {
		super.minute++;
		if(super.minute == 60) {
			super.hour++;
			super.minute = 0;
		} 
		if(super.hour == 24) {
			setDay(1);
			super.hour = 0;
		}
	System.out.println(printDuckTime());
	}
	
	private void setDay(int daySet) {
		this.day = this.day + daySet;
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
	 * @return integer: currentSeason of world
	 */
	public int getCurrentSeason() {
		return this.season;
	}
	
	/**
	 * Updates the duckClock time
	 * this is called in GameLoop every loop (so every tick).
	 */
	/*public void updateTime() {
		duckClock.updateClock();
		System.out.println(printDuckTime());
	}*/
	
	/** Print out Time
	 * 
	 * @return a lame string telling the current time
	 */
	private String printDuckTime() {
		int h = super.hour;
		int m = super.minute;
		int d = this.day;
		
		return "Current Time is: " + h + ":" + m + " day: " + d;
	} 
	
	/*
	 * 
	 * To be implemented later
	 * 
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
	
	
