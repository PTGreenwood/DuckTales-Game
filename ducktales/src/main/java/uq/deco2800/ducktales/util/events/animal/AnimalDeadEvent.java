package uq.deco2800.ducktales.util.events.animal;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event is fired whenever an animal dies, this class is intended
 * to handle sprite resource drops from animals when they die
 *
 * @author Damian Maher
 */
public class AnimalDeadEvent extends AnimalEvent{
	
	/**
	 * Required serialVersionUID variable 
	 */
	private static final long serialVersionUID = 1L;

	/** The event type */
    public static final EventType<AnimalDeadEvent> ANIMAL_DEAD_EVENT =
            new EventType<>("ANIMAL DEAD EVENT");
    
	/** the coordinates of the animal when it died */
	private double deathX;
	private double deathY;
	
	/** the type of animal that died */
	private ResourceType animalDead;
    
    /**
     * Instantiate an event for when an animal dies
     * 
     * @param type
     *          the type of animal that died
     * @param deathX
     *          the X coordinate of the animal when it dies
     * @param deathY
     *          the Y coordinate of the animal when it dies
     */
    public AnimalDeadEvent(ResourceType type, double deathX, double deathY) {
    	super(ANIMAL_DEAD_EVENT);
    	this.animalDead = type;
    	this.deathX = deathX;
    	this.deathY = deathY;
    }
}
