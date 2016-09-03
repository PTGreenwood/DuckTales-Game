package uq.deco2800.ducktales.util.events.ui;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * Created by Khoi on 1/09/2016.
 */
public class CursorMovedEvent extends UIEvent{
    /** The coords of the current mouse */
    private double x;
    private double y;

    /** The event type */
    public static final EventType<CursorMovedEvent> CURSOR_MOVED_EVENT =
            new EventType<>("CURSOR_MOVED_EVENT");

    public CursorMovedEvent(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public CursorMovedEvent(@NamedArg("source") Object source, @NamedArg("target") EventTarget target, @NamedArg("eventType") EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public CursorMovedEvent(double x, double y) {
        super(CURSOR_MOVED_EVENT);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
