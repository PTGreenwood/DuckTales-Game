package uq.deco2800.ducktales.features.seasons;

import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.features.seasons.*;
import uq.deco2800.ducktales.features.time.*;
import uq.deco2800.ducktales.util.Tickable;

/* 
 * The point of this Manager class is to control both
 * TimeManager and SeasonManager and be the 'update controller'
 * between the two.
 * 
 */
public class CalendarManager implements SecondaryManager, Tickable {

    
    public SeasonManager seasonManager;
    public TimeManager timeManager;

    //Holds simple integer value for current Season to be compared with.
    private int currentSeason;
    
    public CalendarManager() {
    	/*
    	 * Needs to instantiate:
    	 * 
    	 * Which season it currently is.
    	 * What weather events it has
    	 * What chance of the events happening do they have?
    	 * 
    	 */
    	this.seasonManager = new SeasonManager();
    	this.timeManager = new TimeManager();
    	this.currentSeason = 0;
    }
   
    /**
     * Updates the Season to the next one when currentDay is
     * within range of next season.
     * 
     * ((currentDay / currentYear) % 20 - 1)
     * 0 = Spring.
     * 1 = Summer.
     * 2 = Autumn(Fall).
     * 3 = Winter.
     */
    public void updateSeason(int seasonInt) {
    	seasonManager.updateSeason(seasonInt);
    }
    
    @Override
    public void reload() {

    }
    
    @Override
    public void tick() {
    	int currentDay = timeManager.getGameTimeObject().getCurrentDay();
    	int currentYear = timeManager.getGameTimeObject().getCurrentYear();
    	
    	for(int i = 0; i <= 3; i++) {
    		if((((currentDay / currentYear) % 20) - 1) == this.currentSeason) {
    			updateSeason(this.currentSeason);
    		} else {
    			if(this.currentSeason <= 3) {
    				this.currentSeason++;
    			} else {
    				this.currentSeason = 0;
    			}
    		}
    	}
    }
}