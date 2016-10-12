package uq.deco2800.ducktales.features.seasons;

public class Spring extends Season {

	private String name;
	private float humidityLevel;
	private int minTemperature;
	private int maxTemperature;
	private int timeNightFall; // 24Hour time (integer is hour. so getHour()
								// will be able to retrieve it
	private int timeDayBreak; // 24Hour time (integer is hour. so getHour() will
								// be able to retrieve it

	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Spring() {
		this.name = "Spring";
		this.humidityLevel = 1.0f;
		this.maxTemperature = 13;
		this.minTemperature = 20;
		this.timeNightFall = 7;
		this.timeDayBreak = 6;

		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}

}
