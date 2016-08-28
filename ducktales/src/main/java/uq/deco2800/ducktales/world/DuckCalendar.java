package uq.deco2800.ducktales.world;
//import java.util.List;


/*
 * 
 * Calendar consists of a Calendar object that contains
 * days and years
 * 
 * has Clock Object inside it (probably needs to be fixed)
 */
public class DuckCalendar {// implements Tickable{


	//Instantiate a the Calendar variables
	int day;
	int year;
	int season; //0 = Spring, 1 = Summer, 2 = Autumn, 3 = Winter
	
	//Instantiate a clock within the calendar
	DuckClock duckClock = new DuckClock();
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
	public DuckCalendar(int d, int y) {
		
		if(d <= 0) {
			//Throw Exception
			//Day can't be 0 or negative... Time begins on day 1 
		} else {
			this.day = d;
		}
		
		if(y <= 0) {
			//throw exception
			//Can't be year 0 or negatives
		} else {
			this.year = y;
		}
		
		if(d <= 20) {
			//Set season to spring
			this.season = 0;
		} else if (d > 20 && d <= 40) {
			//Set season to summer
			this.season = 1;
		} else if (d > 40 && d <= 60) {
			//Set season to autumn
			this.season = 2;
		} else if (d > 60 && d <= 80) {
			//Set season to winter
			this.season = 3;
		} else {
			//The day given is not even on the calendar
			//Throw Exception
		}
		
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
	public void updateTime() {
		duckClock.updateClock();
		System.out.println(printDuckTime());
	}
	
	/** Print out Time
	 * 
	 * @return a lame string telling the current time
	 */
	private String printDuckTime() {
		int h = duckClock.hour;
		int m = duckClock.minute;
		
		return "Current Time is: " + h + ":" + m;
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
	
	
