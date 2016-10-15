package uq.deco2800.ducktales.features.seasons;

public class Summer extends Season {

	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Summer() {
		super.name = "Summer";
		super.humidityLevel = 0.7f;
		super.maxTemperature = 16;
		super.minTemperature = 26;
		super.timeNightFall = 9;
		super.timeDayBreak = 4;

		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}

}
