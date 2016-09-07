package uq.deco2800.ducktales.core.world;

/**
 * Holds the initial enum data set.
 * 
 */

public enum Season {
	SPRING("Spring", 1.0f, 13, 20, 7, 5),//HumidityLevel, MinTemperature, MaxTemperature, TimeNightFall, TimeDayBreak), 
	SUMMER("Summer", 0.7f, 16, 26, 9, 3),
	AUTUMN("Autumn", 0.2f, 10, 15, 8, 4),
	WINTER("Winter", 0.5f, 6, 14, 4, 6);
	
	//Variable declaration for each Season
	private final String name;
	private final float humidityLevel;
	private final int minTemperature;
	private final int maxTemperature;
	private final int timeNightFall; //24Hour time (integer is hour. so getHour() will be able to retrieve it
	private final int timeDayBreak; //24Hour time (integer is hour. so getHour() will be able to retrieve it
	
	
	
	//Re state the attributes here next to int humidityLevel (The int declares the type that you are wanting
	//it to be, so if you want minTemperature you'd put int minTemperature because you'd want to save that as an integer
	Season(String name, float humidityLevel, int minTemperature, int maxTemperature, int timeNightFall, int timeDayBreak) {
		this.name = name;
		this.humidityLevel = humidityLevel;
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.timeNightFall = timeNightFall;
		this.timeDayBreak = timeDayBreak;
		
		//If you've added things above then you have to add them here with a this.whateverItIs = whateverItIs;

}
	/**
	 * Getter Method: getName();
	 * returns the name of the season in string format
	 * 
	 * @return String: Name
	 */
	public String getName() {
		return this.name;
		
	}
	
	/**
	 * Getter Method: getHumidity()
	 * gets the Humidity value of the current season
	 * 
	 * @return Float: Humidity
	 */
	public float getHumidity() {
		return this.humidityLevel;
	}
	
	/**
	 * Getter Method: getMinTemp()
	 * gets the minimum temperature value of the current season
	 * 
	 * @return Int: Minimum Temperature
	 */
	public int getMinTemp() {
		return this.minTemperature;
	}
	
	/**
	 * Getter Method: getMaxTemp()
	 * gets the maximum temperature value of the current season
	 * 
	 * @return Int: Maximum Temperature
	 */
	public int getMaxTemp() {
		return this.maxTemperature;
	}
	
	/**
	 * Getter Method: getTimeNightFall()
	 * gets the time that nightfall happens for the current season
	 * 
	 * @return Int: Hour value for when Nightfall begins
	 */
	public int getTimeNightFall() {
		return this.timeNightFall;
	}
	
	/**
	 * Getter Method: getTimeDayBreak()
	 * gets the time that daybreak happens for the current season
	 * 
	 * @return Int: Hour value for when DayBreak begins
	 */
	public int getTimeDayBreak() {
		return this.timeDayBreak;
	}
}

