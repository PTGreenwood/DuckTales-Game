package uq.deco2800.ducktales.world;


import uq.deco2800.ducktales.util.Tickable;
import uq.deco2800.ducktales.world.DuckCalendar;
/*
 * 
 * Time consists of a clock object that contains
 * hours and minutes
 */
public class DuckClock{// implements Tickable{

	//Instantiate a the time variables
	int hour;
	int minute;
	
	
	public DuckClock(int h, int m) {
		this.hour = h;
		this.minute = m;
		//DuckCalendar duckCalendar = new DuckCalendar(h, m);
		
	}

	/*
	public void updateClock() {
		this.minute++;
		if(this.minute == 60) {
			this.hour++;
			this.minute = 0;
		}
	}
	*/
	/*Notes/thoughts
	*
	*Need to somehow implement the day counter in for when it reaches 24 hours in the day
	*This could be super.day++ but that cause's errors
	*Maybe I'm implementing Super/implements wrong.
	*/
}