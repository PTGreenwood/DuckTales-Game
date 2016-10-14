package uq.deco2800.ducktales.features.seasons;

public class Autumn extends Season {
	
	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Autumn() {
		super.name = "Autumn";
		super.humidityLevel = 0.2f;
		super.maxTemperature = 10;
		super.minTemperature = 15;
		super.timeNightFall = 8;
		super.timeDayBreak = 5;

		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}

}
