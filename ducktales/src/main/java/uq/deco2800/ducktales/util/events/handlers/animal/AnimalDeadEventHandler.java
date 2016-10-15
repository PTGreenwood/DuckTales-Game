package uq.deco2800.ducktales.util.events.handlers.animal;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.util.events.animal.AnimalDeadEvent;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;

/**
 * This handler will do the following tasks
 * 1. remove the animal sprite from the game and replace it with a death sprite
 * 2. place an animal resource sprite at the location of death
 *
 * Created on 1/09/2016.
 * @author Damian Maher
 */
public class AnimalDeadEventHandler extends GameEventHandler implements EventHandler<AnimalDeadEvent>{

	/** Secondary Managers */ 
	private ResourceEntityManager resourceEntityManager;
	
    /**
     * Create a handler for the AnimalDeadEvent event
     *
     * @param gameManager
     *          The game manager
     */
	public AnimalDeadEventHandler(GameManager gameManager) {
		super(gameManager);
		this.gameManager = gameManager;
		resourceEntityManager = gameManager.getResourceEntityManager();
	}

	@Override
	public void handle(AnimalDeadEvent event) {
		// resourceEntityManager.dropResource(type, x, y);
	}

}
