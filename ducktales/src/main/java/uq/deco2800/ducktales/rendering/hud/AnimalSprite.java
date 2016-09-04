package uq.deco2800.ducktales.rendering.hud;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * The sprite holding the animals to be displayed in the Animals Menu
 *
 * Created on 4/09/2016.
 * @author khoiphan21
 */
public class AnimalSprite extends HUDSprite {

    public AnimalSprite(ResourceType animalType) {
        super(animalType);

        setupMouseEventHandlers();
    }

    private void setupMouseEventHandlers() {


    }
}
