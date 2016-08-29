package uq.deco2800.ducktales.world;

/*
 * 
 * DuckClock is a superClass of DuckCalendar which consists of 
 * a DuckClock Object with hours and minutes
 */
public class DuckClock {

	//Instantiate a the time variables
	int hour;
	int minute;
	
	
	public DuckClock(int h, int m) {
		this.hour = h;
		this.minute = m;
		
	}
	
	/**
	 * Gets the current hour of the DuckClock
	 * 
	 * @return Integer - DuckClock hour
	 * 			
	 */
	public int getHour() {
		return this.hour;
	}
	
	/**
	 * Gets the current minute of the DuckClock
	 * 
	 * @return Integer - DuckClock minute
	 * 			
	 */
	public int getMinute() {
		return this.minute;
	}
	
	/**
	 * Sets the DuckClock with the specified
	 * Minute
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
	 * Sets the DuckClock with the specified
	 * Minute
	 * 
	 * 	@param Int setMinute
	 * 			-	Integer of the given minute must be 0 >= setMinute <= 59
	 *	@throws Exception
	 *			-	Throws Exception(Exception) if number is out of range
	 */
	public void setMinute(int setMinute){// throws Exception {
		if(setMinute < 0) {
			//throw new Exception("Minute must be >= 0");
		} else if (setMinute > 59) {
			//throw new Exception("Minute must be <= 59");
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
}