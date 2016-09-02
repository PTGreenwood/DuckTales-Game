package uq.deco2800.ducktales.util.events.uievents;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event holds the information of the sprite that fired it
 *
 * Created by Khoi on 1/09/2016.
 */
public class UIEvent extends Event{

    /** The type of the sprite that fired this event */
    protected ResourceType type;

    /** Defining the type of event */
    public static final EventType<UIEvent> UI_EVENT = new EventType<>("UI_EVENT");

    public UIEvent(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public UIEvent(@NamedArg("source") Object source, @NamedArg("target") EventTarget target, @NamedArg("eventType") EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    /**
     * Instantiate an event with the given type - which is the type of the entity
     * that fired this event
     *
     * @param type
     *          The type of the entity that fired the event
     */
    public UIEvent(ResourceType type) {
        super(UI_EVENT);
        this.type = type;
    }

    /**
     * Get the type of the entity that fired the event
     *
     * @return
     *          The type of the entity that fired the event
     */
    public ResourceType getType() {
        return this.type;
    }
}
