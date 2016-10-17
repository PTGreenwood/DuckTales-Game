package uq.deco2800.ducktales.util.events.animal;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.tile.TileEvent;

/**
 * @author Damian Maher
 */

public class AnimalEvent extends Event {
    // Setup the type of event for this event class
    public static final EventType<AnimalEvent> ANIMAL_EVENT =
            new EventType<>("ANIMAL_EVENT");
    
    /** the x and y coordinates of the animal that triggered this event */
    private double x;
    private double y;
    
    /** the animal that triggered this event */
    private Animal animalType;
    
    public AnimalEvent(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public AnimalEvent(@NamedArg("source") Object source, @NamedArg("target") EventTarget 
    	    target, @NamedArg("eventType") EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }
    
    public AnimalEvent(Animal animalType, double x, double y) {
        super(ANIMAL_EVENT);
        this.animalType = animalType;
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X coordinate of an animal
     * 
     * @return the X coordinate of an animal
     */
    public double getX() {
        return this.x;
    }
    
    /**
     * Returns the Y coordinate of an animal
     * 
     * @return the Y coordinate of an animal
     */
    public double getY() {
        return this.y;
    }
    
    /**
     * Returns the type of an animal
     * 
     * @return the ResourceType coordinate of an animal
     */
    public Animal getAnimalType() {
    	return this.animalType;
    }
}
