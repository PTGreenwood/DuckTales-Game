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
public class SeasonManager implements SecondaryManager{

    /* Implement all Season Types */
    protected Season spring = new Spring();
    protected Season summer = new Summer();;
    protected Season autumn = new Autumn();;
    protected Season winter = new Winter();;
    
    private List<Season> seasonList = new ArrayList<Season>();
    private Season currentSeason;
    
    public SeasonManager() {
    	/*
    	 * Needs to instantiate:
    	 * 
    	 * Which season it currently is.
    	 * What weather events it has
    	 * What chance of the events happening do they have?
    	 * 
    	 */
    	this.currentSeason = spring;
    	
    	this.seasonList.addAll(Arrays.asList(spring, summer, autumn, winter));
    }
   
    /**
     * Updates the Season to the next one when currentDay is
     * within range of next season.
     * 
     * (currentDay / currentYear) % 20
     * 1 = Spring.
     * 2 = Summer.
     * 3 = Autumn(Fall).
     * 4 = Winter.
     */
    public void updateSeason(int seasonNumber) {
    	
    	this.currentSeason = this.seasonList.get(seasonNumber);
    }
    
    /**
     * Returns the Season that is currently being viewed in Game.
     * 
     * @return The Season currently viewed in Game along with it's values
     * 			WeatherEvent and WeatherChance.
     */
    public Season getSeason() {
    	return this.currentSeason;
    }
    
    @Override
    public void reload() {

    }
}