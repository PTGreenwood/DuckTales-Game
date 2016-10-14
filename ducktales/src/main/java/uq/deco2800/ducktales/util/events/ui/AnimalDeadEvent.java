package uq.deco2800.ducktales.util.events.ui;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event is fired whenever an animal dies, this class is intended
 * to handle sprite resource drops from animals when they die
 *
 * @author Damian Maher
 */
public class AnimalDeadEvent extends UIEvent{
	
	/** The event type */
    public static final EventType<AnimalDeadEvent> ANIMAL_DEAD_EVENT =
            new EventType<>("ANIMAL DEAD EVENT");
    
    /**
     * Instantiate an event for when an animal dies
     *
     * @param type
     *          The type of entity that fired the event 
     *          (the animal that died) 
     */
    public AnimalDeadEvent(ResourceType type, double deathX, double deathY) {
    	super(type);
    }
    
}
