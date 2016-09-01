package uq.deco2800.ducktales.HUD;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Events.TileEvents.TileClickedEvent;
import uq.deco2800.ducktales.util.Events.UIEvents.BuildingMenuDeselectedEvent;
import uq.deco2800.ducktales.util.Events.UIEvents.BuildingMenuSelectedEvent;
import uq.deco2800.ducktales.util.Events.UIEvents.CursorMovedEvent;

/**
 * This class represents a sprite of a building, to be rendered into the game
 * It will contain event handlers which will notify the {@link GameManagerBeta}
 * when it is clicked on
 *
 * Created by Khoi on 31/08/2016.
 */
public class BuildingSprite extends ImageView {

    /** Variables holding the information about this sprite */
    private ResourceType buildingType;
    private Image buildingSprite; // The sprite of the building

    /** The manager of the game */
    private GameManagerBeta manager;

    /**
     * Create a sprite of the given building sprite, and give it a handle of
     * the game manager
     *
     * @param buildingType
     */
    public BuildingSprite(ResourceType buildingType, GameManagerBeta manager) {
        this.manager = manager;
        this.buildingSprite =
                ResourceRegister.getInstance().getResourceImage(buildingType);
        this.buildingType = buildingType;

        // Load the sprite into the image view
        this.setImage(buildingSprite);

        setupMouseEventHandler();
    }

    /**
     * Get the type of the building represented by this sprite
     *
     * @return the type of this sprite's building
     */
    public ResourceType getBuildingType() {
        return this.buildingType;
    }

    public double getSpriteHeight() {
        return this.buildingSprite.getHeight();
    }

    public double getSpriteWidth() {
        return this.buildingSprite.getWidth();
    }

    /**
     * Setup the mouse event handlers for this sprite
     */
    private void setupMouseEventHandler() {
        this.setOnMousePressed(event -> {
            fireEvent(new BuildingMenuSelectedEvent(
                    this.buildingType, event.getSceneX(), event.getSceneY()));
        });
        this.setOnMouseReleased(event -> {
            System.err.println("Mouse released on building " + this.buildingType);
            fireEvent(new BuildingMenuDeselectedEvent(this.buildingType));
        });
        this.setOnMouseDragged(event -> {
            fireEvent(new CursorMovedEvent(event.getSceneX(), event.getSceneY()));
        });


        this.setOnMouseEntered(event -> {
            System.err.println("mouse hovered on: " + event.getSource().toString());
            // stub event just to trigger parent event
        });
    }


}
