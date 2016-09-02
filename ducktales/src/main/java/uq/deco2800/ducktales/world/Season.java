package uq.deco2800.ducktales.world;

/**
 * Holds the initial enum data set.
 * Utilised by SeasonData
 */
enum Season {
	SPRING("Spring", 1),//HumidityLevel, MinTemperature, MaxTemperature, TimeNightFall, TimeDayBreak), 
	SUMMER("SUMMER", 1),
	AUTUMN("Autumn", 1),
	WINTER("Winter", 1);
	
	//Variable declaration for each Season
	private final String name;
	private final int humidityLevel;
	//Delete this line and add all the season attributes you want
	
	
	
	//Re state the attributes here next to int humidityLevel (The int declares the type that you are wanting
	//it to be, so if you want minTemperature you'd put int minTemperature because you'd want to save that as an integer
	Season(String name, int humidityLevel) {
		this.name = name;
		this.humidityLevel = humidityLevel;
		
		//If you've added things above then you have to add them here with a this.whateverItIs = whateverItIs;

}
	
}
