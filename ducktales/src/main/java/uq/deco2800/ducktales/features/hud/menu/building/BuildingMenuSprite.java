package uq.deco2800.ducktales.features.hud.menu.building;

import java.awt.MouseInfo;
import java.awt.Point;

import javafx.scene.input.MouseButton;
import uq.deco2800.ducktales.features.hud.HUDSprite;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.ui.MenuSelectedEvent;

/**
 * This class represents a sprite of a building, to be displayed in the
 * buildings menu
 *
 * Created on 31/08/2016.
 * @author khoiphan21
 */
public class BuildingMenuSprite extends HUDSprite {

    /**
     * Create a sprite of the given building sprite, and set up its
     * event handlers
     *
     * @param buildingType
     */
    public BuildingMenuSprite(ResourceType buildingType) {
        super(buildingType);

        setupMouseEventHandlers();
    }

    /**
     * Setup the mouse event handlers for this sprite
     */
    private void setupMouseEventHandlers() {
        this.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                fireEvent(new MenuSelectedEvent(
                        MenuManager.MenuType.BUILDING, this.getSpriteType(),
                        event.getSceneX(), event.getSceneY()));
            }
        });
    }   

}
