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

	/*Notes/thoughts
	*
	*Need to somehow implement the day counter in for when it reaches 24 hours in the day
	*This could be super.day++ but that cause's errors
	*Maybe I'm implementing Super/implements wrong.
	*
	*/
}