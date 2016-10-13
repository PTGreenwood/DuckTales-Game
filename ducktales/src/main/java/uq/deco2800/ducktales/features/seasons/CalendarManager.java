package uq.deco2800.ducktales.features.seasons;

import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.features.seasons.*;
import uq.deco2800.ducktales.features.time.*;

/* 
 * The point of this Manager class is to control both
 * TimeManager and SeasonManager and be the 'update controller'
 * between the 2.
 * 
 */
public class CalendarManager implements SecondaryManager{

    /** The model for the game time */
    protected Season season;
    public SeasonManager seasonManager;
    public TimeManager timeManager;

    public CalendarManager() {
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