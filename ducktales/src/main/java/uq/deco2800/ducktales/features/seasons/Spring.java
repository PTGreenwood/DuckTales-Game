package uq.deco2800.ducktales.features.seasons;
import uq.deco2800.ducktales.features.weather.*;

public class Spring extends Season {

	
	// Re state the attributes here next to int humidityLevel (The int declares
	// the type that you are wanting
	// it to be, so if you want minTemperature you'd put int minTemperature
	// because you'd want to save that as an integer
	public Spring() {
		super.name = SeasonType.SPRING;
		super.humidityLevel = 2.4f;
		super.maxTemperature = 20;
		super.currentTemperature = 13;
		super.minTemperature = 11;
		super.timeNightFall = 19;
		super.timeDayBreak = 6;
		super.atmosphericIceLevel = 0.0f;
		super.windLevel = 2.0f;
		super.fireDanger = 0.8f;

		super.weatherEvents = new WeatherEvents();
		
		// If you've added things above then you have to add them here with a
		// this.whateverItIs = whateverItIs;

	}


}
