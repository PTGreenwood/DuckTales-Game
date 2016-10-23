package uq.deco2800.ducktales.util.exceptions;

/**
 * This class handles an exception thrown when adding a
 * droppable resource to the game, when that resource has
 * not been registered yet
 * 
 * @author Damian Maher
 */

public class DroppableResourceNotRegisteredException extends RuntimeException {
    public DroppableResourceNotRegisteredException(String message) {
        super(message);
    }
}
