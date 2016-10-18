package uq.deco2800.ducktales.features.seasons;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;

import javafx.application.Platform;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.seasons.Season;
import uq.deco2800.ducktales.util.SecondaryManager;

/**
 * 
 * This Manager class handles Season changes, weather within each season and the chance
 * in which the weather events happen.
 * 
 * SeasonManager -> Season -> WeatherEvent -> WeatherChance
 * 
 * 
 *
 */
public class SeasonManager{

    /* Implement all Season Types */
    /*protected Season spring;
    protected Season summer;
    protected Season autumn;
    protected Season winter;
    */
	
    /* Setup intial Season Stuff for Season Manager */
    Season spring;
	Season summer;
	Season autumn;
	Season winter;
	
    public List<Season> seasonList;
    public Season currentSeason;
    
    public SeasonManager() {
    	/*
    	 * Needs to instantiate:
    	 * 
    	 * Which season it currently is.
    	 * What weather events it has
    	 * What chance of the events happening do they have?
    	 * 
    	 */
    	
    	spring = new Spring();
    	summer = new Summer();
    	autumn = new Autumn();
    	winter = new Winter();

    	this.currentSeason = spring;
    	
    	this.seasonList = new ArrayList<Season>();
    	this.seasonList.addAll(Arrays.asList(spring, summer, autumn, winter));
    	
    	this.setupInitialWeatherEvents();
    }
    
    /**
     * Sets up initial weatherEvents and their chances for each Season
     */
    public void setupInitialWeatherEvents() {
		for (Season seasonIterator : this.seasonList) {
			seasonIterator.setRainWeather();
			seasonIterator.setFireWeather();			
			//added in extra weather - @mattyleggy
			seasonIterator.setSnowWeather();
			seasonIterator.setStormWeather();
		}
    }
    /**
     * Returns the Season that is currently being viewed in Game.
     * 
     * @return The Season currently viewed in Game along with it's values
     * 			WeatherEvent and WeatherChance.
     */
    public Season getCurrentSeason() {
    	return this.currentSeason;
    }
    
    /**
     * Returns the list of possible seasons. Used for comparisons.
     * 
     * @return A list of seasons that are in the game.
     */
    public List<Season> getSeasonList() {
    	return this.seasonList;
    }
    
    /**
     * Updates the Season to the next one when currentDay is
     * within range of next season.
     * 
     * 1 = Spring.
     * 2 = Summer.
     * 3 = Autumn(Fall).
     * 4 = Winter.
     */
    public void updateSeason(int seasonNumber) {
    	this.currentSeason = seasonList.get(seasonNumber);
    }
    
    /**
     * Update the currentTemperature within the currentSeason
     * Has bounds of minTemperature and maxTemperature declared
     * within each season.
     * 
     * For note:
     * Spring: Max = 20, Min = 11 
     * Summer: Max = 26, Min = 16 
     * Autumn: Max = 18, Min = 8
     * Winter: Max = 11, Min = 0
     * 
     * @param integer temperatureValueChange
     * 			- The number to increment or decrement by
     * @param boolean increment
     * 			- True if increasing temperature.
     * 			- False if decreasing temperature.
     */
    
    public void updateTemperature(int temperatureValueChange, boolean increment) {
    	if(increment) {
    		this.currentSeason.incrementCurrentTemperature(temperatureValueChange);
    	} else {
    		this.currentSeason.decrementCurrentTemperature(temperatureValueChange);
    	}
    }
    
}