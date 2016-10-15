package uq.deco2800.ducktales.util.events.animal;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.ui.UIEvent;

/**
 * This event is fired whenever an animal dies, this class is intended
 * to handle sprite resource drops from animals when they die
 *
 * @author Damian Maher
 */
public class AnimalDeadEvent extends UIEvent{

	/** the coordinates of the animal when it died */
	private double deathX;
	private double deathY;
	
	/** The event type */
    public static final EventType<AnimalDeadEvent> ANIMAL_DEAD_EVENT =
            new EventType<>("ANIMAL DEAD EVENT");
    
    /**
     * Instantiate an event for when an animal dies
     *
     * @param deathX
     *          the X coordinate of the animal when it dies
     * @param deathY
     *          the Y coordinate of the animal when it dies
     */
    public AnimalDeadEvent(double deathX, double deathY) {
    	super(ANIMAL_DEAD_EVENT);
    	this.deathX = deathX;
    	this.deathY = deathY;
    }
    
}
