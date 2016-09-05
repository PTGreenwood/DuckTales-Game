package uq.deco2800.ducktales.rendering.sprites.hud;

import javafx.scene.input.MouseButton;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.ui.AnimalsMenuSelectedEvent;

/**
 * The sprite holding the animals to be displayed in the Animals Menu
 *
 * Created on 4/09/2016.
 * @author khoiphan21
 */
public class AnimalMenuSprite extends HUDSprite {

    /**
     * Create a sprite of the given animal type, and set up its event handlers
     * @param animalType
     */
    public AnimalMenuSprite(ResourceType animalType) {
        super(animalType);

        setupMouseEventHandlers();
    }

    /**
     * Set up all mouse event handlers for this sprite
     */
    private void setupMouseEventHandlers() {
        // Fire an event notifying that an animal menu sprite has been selected
        this.setOnMouseClicked(event -> {
            // Check if it's a left mouse click
            if (event.getButton() == MouseButton.PRIMARY) {
                fireEvent(new AnimalsMenuSelectedEvent(
                        this.getSpriteType(), event.getSceneX(), event.getSceneY()
                ));
            }
        });
    }
}
