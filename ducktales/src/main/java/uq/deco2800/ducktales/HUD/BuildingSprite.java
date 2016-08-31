package uq.deco2800.ducktales.HUD;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This class represents a sprite of a building, to be rendered into the game
 * It will contain event handlers which will notify the {@link GameManagerBeta}
 * when it is clicked on
 *
 * Created by Khoi on 31/08/2016.
 */
public class BuildingSprite extends ImageView {

    private ResourceType buildingType;
    private Image buildingSprite; // The sprite of the building

    public BuildingSprite(ResourceType buildingType) {
        this.buildingSprite =
                ResourceRegister.getInstance().getResourceImage(buildingType);
        this.buildingType = buildingType;
    }

    public ResourceType getBuildingType() {
        return this.buildingType;
    }
}
