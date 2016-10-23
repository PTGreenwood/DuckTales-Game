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
	
    /**
	 * Required serialVersionUID variable 
	 */
	private static final long serialVersionUID = 1L;

	/** Setup the type of event for this event class */
    public static final EventType<AnimalEvent> ANIMAL_EVENT =
            new EventType<>("ANIMAL_EVENT");
    
    /** the x and y coordinates of the animal that triggered this event */
    private int x;
    private int y;
    
    /** the animal ResourceType that triggered this event */
    private ResourceType animalResourceType;
    
    public AnimalEvent(@NamedArg("eventType") EventType<? extends Event> 
         eventType) {
        super(eventType);
    }

    public AnimalEvent(@NamedArg("source") Object source, @NamedArg("target")
             EventTarget target, @NamedArg("eventType") EventType<? extends 
            		 Event> eventType) {
        super(source, target, eventType);
    }
    
    /**
     * The constructor for an animal event, constructs a new animal
     * event with the specified resource type, x location, and y
     * location
     * 
     * @param animalResourceType, the resource type of the animal
     * @param x, the x location of the animal when the event is fired
     * @param y, the y location of the animal when the event is fired
     */
    public AnimalEvent(ResourceType animalResourceType, int x, int y) {
        super(ANIMAL_EVENT);
        this.animalResourceType = animalResourceType;
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X coordinate of an animal
     * 
     * @return the X coordinate of an animal
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Returns the Y coordinate of an animal
     * 
     * @return the Y coordinate of an animal
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Returns the type of an animal
     * 
     * @return the ResourceType coordinate of an animal
     */
    public ResourceType getAnimalType() {
    	return this.animalResourceType;
    }
}
