package uq.deco2800.ducktales.rendering.hud;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.ui.BuildingMenuSelectedEvent;

/**
 * This class represents a sprite of a building, to be displayed in the
 * buildings menu
 *
 * Created on 31/08/2016.
 * @author khoiphan21
 */
public class BuildingSprite extends HUDSprite {

    /**
     * Create a sprite of the given building sprite, and give it a handle of
     * the game manager
     *
     * @param buildingType
     */
    public BuildingSprite(ResourceType buildingType) {
        super(buildingType);

        setupMouseEventHandlers();
    }

    /**
     * Setup the mouse event handlers for this sprite
     */
    private void setupMouseEventHandlers() {
        this.setOnMouseClicked(event -> {
            fireEvent(new BuildingMenuSelectedEvent(
                    this.getSpriteType(), event.getSceneX(), event.getSceneY()));
        });

//        this.setOnMouseReleased(event -> {
//            System.err.println("Mouse released on building " + this.buildingType);
//            fireEvent(new HUDDeselectedEvent(this.buildingType));
//        });
//        this.setOnMouseDragged(event -> {
//            fireEvent(new CursorMovedEvent(event.getSceneX(), event.getSceneY()));
//        });


        this.setOnMouseEntered(event -> {
            System.err.println("mouse hovered on: " + event.getSource().toString());
            // stub event just to trigger parent event
        });
    }


}
