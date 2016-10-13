package uq.deco2800.ducktales.util.events.ui;

import javafx.event.EventType;

/**
 * This event is fired whenever an animal dies, this class is intended
 * to handle resource drops from animals when they die
 *
 * @author Damian Maher
 */
public class AnimalDeadEvent extends  UIEvent{
	/** The event type */
    public static final EventType<AnimalDeadEvent> ANIMAL_DEAD_EVENT =
            new EventType<>("ANIMAL DEAD EVENT");
    
    public AnimalDeadEvent() {
    	super(ANIMAL_DEAD_EVENT);
    }
    
    // REST OF CLASS TO BE CODED 
}
