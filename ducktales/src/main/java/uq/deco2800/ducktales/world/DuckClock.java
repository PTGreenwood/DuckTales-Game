package uq.deco2800.ducktales.world;


/*
 * 
 * Time consists of a clock object that contains
 * hours and minutes
 */
public class DuckClock {

	//Instantiate a the time variables
	int hour;
	int minute;
	//int day;
	//int year;
	
	public DuckClock() {
		this.hour = 0;
		this.minute = 0;
		
	}

	public void updateClock() {
		this.minute++;
		if(this.minute == 60) {
			this.hour++;
			this.minute = 0;
		}
		
		//if(this.hour == 24) {
		//	day++;
		//	this.currentHour = 0;
		//}
		//System.out.println(this.currentHour);
	}

	//public String getTime() {
	//	return "" + this.currentHour + ":" + this.currentMinute;*/
		
	//}
		
}