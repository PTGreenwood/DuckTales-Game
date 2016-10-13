package uq.deco2800.ducktales.features.seasons;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.seasons.*;
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

    /** The model for the game time */
    protected Season season;

    public SeasonManager() {
    	/*
    	 * Needs to instantiate:
    	 * 
    	 * Which season it currently is.
    	 * What weather events it has
    	 * What chance of the events happening do they have?
    	 * 
    	 */
    	
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
    public void updateSeasoin() {
    	
    }
    
    @Override
    public void reload() {

    }
}