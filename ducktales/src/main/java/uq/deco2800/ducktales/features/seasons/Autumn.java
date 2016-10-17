package uq.deco2800.ducktales.features.seasons;

import uq.deco2800.ducktales.features.weather.Fire;
import uq.deco2800.ducktales.features.weather.InvalidWeatherChanceException;
import uq.deco2800.ducktales.features.weather.Rain;
import uq.deco2800.ducktales.features.weather.WeatherChance;
import uq.deco2800.ducktales.features.weather.WeatherEvents;

public class Autumn extends Season {
	
	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Autumn() {
		super.name = "Autumn";
		super.humidityLevel = 2.2f;
		super.maxTemperature = 15;
		super.currentTemperature = 12;
		super.minTemperature = 10;
		super.timeNightFall = 20;
		super.timeDayBreak = 5;

		super.weatherEvents = new WeatherEvents();
		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}
}
