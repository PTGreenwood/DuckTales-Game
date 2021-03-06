package uq.deco2800.ducktales.util.events.handlers.animal;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.animal.AnimalDeadEvent;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;

/**
 * This handler will do the following tasks
 * 1. remove the animal sprite from the game and replace it with a death sprite
 *
 * @author Damian Maher
 */
public class AnimalDeadEventHandler extends GameEventHandler implements 
         EventHandler<AnimalDeadEvent>{

	/** Secondary Managers */ 
	private ResourceEntityManager resourceEntityManager;
	
	/** the resource type of the animal that fired the AnimalDeadEvent */
	private ResourceType resourceType;
	
    /**
     * Create a handler for the AnimalDeadEvent event
     *
     * @param gameManager
     *          The game manager
     */
	public AnimalDeadEventHandler(GameManager gameManager) {
		super(gameManager);
		this.gameManager = gameManager;
		resourceEntityManager = gameManager.getMainEntityManager()
				.getResourceEntityManager();
	}

	/**
	 * handles the AnimalDeadEvent, drops a resource where the animal died
	 */
	@Override
	public void handle(AnimalDeadEvent event) {
		resourceEntityManager.dropResource(event.getAnimalType(), 
	    event.getX(), event.getY());
	}

}
