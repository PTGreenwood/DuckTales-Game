package uq.deco2800.ducktales.util.events.animal;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.ui.UIEvent;

/**
 * This event is fired whenever an animal dies, this class is intended
 * to handle sprite resource drops from animals when they die
 *
 * @author Damian Maher
 */
public class AnimalDeadEvent extends AnimalEvent{
	
	/** The event type */
    public static final EventType<AnimalDeadEvent> ANIMAL_DEAD_EVENT =
            new EventType<>("ANIMAL DEAD EVENT");
    
    public AnimalDeadEvent(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public AnimalDeadEvent(@NamedArg("source") Object source, @NamedArg("target") EventTarget target, @NamedArg("eventType") EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }
    
	/** the coordinates of the animal when it died */
	private double deathX;
	private double deathY;
	
	/** the type of animal that died */
	private Animal animalDead;
    
    /**
     * Instantiate an event for when an animal dies
     * 
     * @param animalDead
     *          the type of animal that died
     * @param deathX
     *          the X coordinate of the animal when it dies
     * @param deathY
     *          the Y coordinate of the animal when it dies
     */
    public AnimalDeadEvent(Animal animalDead, double deathX, double deathY) {
    	super(ANIMAL_DEAD_EVENT);
    	this.animalDead = animalDead;
    	this.deathX = deathX;
    	this.deathY = deathY;
    }
}
