package uq.deco2800.ducktales.features.seasons;

import uq.deco2800.ducktales.features.weather.WeatherEvents;

public class Winter extends Season {

	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Winter() {
		super.name = "Winter";
		super.humidityLevel = 0.5f;
		super.maxTemperature = 11;
		super.currentTemperature = 7;
		super.minTemperature = 0;
		super.timeNightFall = 17;
		super.timeDayBreak = 7;
		super.atmosphericIceLevel = 4.8f;
		super.windLevel = 1.0f;
		super.fireDanger = 0.0f;

		super.weatherEvents = new WeatherEvents();
		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}
}

