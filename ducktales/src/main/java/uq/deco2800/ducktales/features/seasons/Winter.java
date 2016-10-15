package uq.deco2800.ducktales.features.seasons;

public class Winter extends Season {

	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Winter() {
		super.name = "Winter";
		super.humidityLevel = 0.5f;
		super.maxTemperature = 6;
		super.minTemperature = 14;
		super.timeNightFall = 5;
		super.timeDayBreak = 7;

		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}

}
