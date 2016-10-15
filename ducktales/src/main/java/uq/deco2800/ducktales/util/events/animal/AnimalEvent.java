package uq.deco2800.ducktales.util.events.animal;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.tile.TileEvent;

public class AnimalEvent extends Event {
    // Setup the type of event for this event class
    public static final EventType<AnimalEvent> ANIMAL_EVENT =
            new EventType<>("ANIMAL_EVENT");
    
    /** the x and y coordinates of the animal that triggered this event */
    private double x;
    private double y;
    
    /** the resource type (animal type) that triggered this event */
    private ResourceType animalType;
    
    public AnimalEvent(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public AnimalEvent(@NamedArg("source") Object source, @NamedArg("target") EventTarget 
    	    target, @NamedArg("eventType") EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }
    
    public AnimalEvent(int x, int y) {
        super(ANIMAL_EVENT);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public ResourceType getResourceType() {
    	return this.animalType;
    }
}
