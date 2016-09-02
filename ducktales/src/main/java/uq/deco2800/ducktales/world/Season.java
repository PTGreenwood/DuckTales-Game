package uq.deco2800.ducktales.world;

/**
 * Holds the initial enum data set.
 * Utilised by SeasonData
 */
enum Season {
	SPRING("Spring", 1.0f, 13, 20),//HumidityLevel, MinTemperature, MaxTemperature, TimeNightFall, TimeDayBreak), 
	SUMMER("Summer", 0.7f, 16, 26),
	AUTUMN("Autumn", 0.2f, 10, 15),
	WINTER("Winter", 0.5f, 6, 14);
	
	//Variable declaration for each Season
	private final String name;
	private final float humidityLevel;
	private final int minTemperature;
	private final int maxTemperature;
	
	
	
	//Re state the attributes here next to int humidityLevel (The int declares the type that you are wanting
	//it to be, so if you want minTemperature you'd put int minTemperature because you'd want to save that as an integer
	Season(String name, float humidityLevel, int minTemperature, int maxTemperature) {
		this.name = name;
		this.humidityLevel = humidityLevel;
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		
		//If you've added things above then you have to add them here with a this.whateverItIs = whateverItIs;

}
	
}
