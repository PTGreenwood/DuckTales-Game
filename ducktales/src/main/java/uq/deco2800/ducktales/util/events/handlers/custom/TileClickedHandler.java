package uq.deco2800.ducktales.util.events.handlers.custom;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;
import uq.deco2800.ducktales.util.events.tile.TileClickedEvent;

/**
 * This method will handle the event when a tile is clicked on. Current tasks:
 *      1. Check if there is any 'currently managed' entity in Game Manager. if so:
 *          i. Notify Entity Manager that an entity is being added
 *
 * Created on 9/09/2016.
 * @author khoiphan21
 */
public class TileClickedHandler extends GameEventHandler
        implements EventHandler<TileClickedEvent> {
    /** The secondary manager */
    private EntityManager entityManager;

    /**
     * Instantiate an event handler with a handle on the game manager
     *
     * @param gameManager The manager of the game
     */
    public TileClickedHandler(GameManager gameManager) {
        super(gameManager);
        entityManager = EntityManager.getInstance();
    }

    @Override
    public void handle(TileClickedEvent event) {
        if (gameManager.getCurrentEntityManaging() != ResourceType.NONE) {
            // There is an entity to be added to the given world tile

            // Get the current menu selected from the manager
            MenuManager.MenuType menuSelected = gameManager.getMenuSelected();

            // Check what kind of entity is to be added
            if (menuSelected == MenuManager.MenuType.ANIMAL) {
                // add an animal
                entityManager.addAnimal(
                        gameManager.getCurrentEntityManaging(),
                        event.getxPos(), event.getyPos()
                );
            } else if (menuSelected == MenuManager.MenuType.BUILDING){
                // Add a building
                entityManager.addWorldEntity(
                        gameManager.getCurrentEntityManaging(),
                        event.getxPos(), event.getyPos()
                );
            }


        }

    }
}
