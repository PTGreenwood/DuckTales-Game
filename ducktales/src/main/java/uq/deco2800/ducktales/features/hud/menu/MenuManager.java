package uq.deco2800.ducktales.features.hud.menu;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import uq.deco2800.ducktales.features.hud.menu.animal.AnimalMenuSprite;
import uq.deco2800.ducktales.features.hud.menu.building.BuildingMenuSprite;
import uq.deco2800.ducktales.rendering.RenderingInformation;
import uq.deco2800.ducktales.rendering.info.WorldEntityInfo;
import uq.deco2800.ducktales.resources.ResourceType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static uq.deco2800.ducktales.resources.ResourceType.*;
import static uq.deco2800.ducktales.resources.ResourceType.DUCK_1_1;

/**
 * This manager manages the menu section of the HUD
 *
 * Created on 7/09/2016.
 */
public class MenuManager implements Initializable{
    /**
     * CONSTANTS
     */
    // TODO: TO ADD NEW BUILDINGS, REGISTER THEIR NAMES HERE
    private static final ResourceType[] BUILDINGS = {
            //HOSPITAL, BAKERY, BARN, <--- these buildings are of the wrong size
            BUTCHER, COMMUNITY_BUILDING, BAKERY, PASTURE, CONSTRUCTION
    };
    // TODO: TO ADD NEW ANIMALS, REGISTER THEIR NAMES HERE
    private static final ResourceType[] ANIMALS = {
            SHEEP, COW_FRONT_RIGHT, DUCK_1_1
    };

    /** The root pane to add all menu items into */
    private AnchorPane rootPane;

    /** GUI containers */
    private HBox buildingsMenu;
    private HBox animalsMenu;

    /** The lists of menu sprites */
    private ArrayList<BuildingMenuSprite> buildingMenuSprites;
    private ArrayList<AnimalMenuSprite> animalMenuSprites;

    /** Helpers for rendering information */
    private WorldEntityInfo worldEntityInfo;

    /**
     * Instantiating a helper manager to help manage the menu section of the HUD
     * @param rootPane
     *          The pane to add all menu sprites into
     */
    public MenuManager(AnchorPane rootPane) {
        this.rootPane = rootPane;
        this.worldEntityInfo = WorldEntityInfo.getInstance();

        // Instantiating and set up the menus
        setupMenus();

        // Add the menus to the root pane
        rootPane.getChildren().addAll(this.buildingsMenu, this.animalsMenu);

    }

    /**
     * Set up all the menus to be displayed on the HUD
     */
    private void setupMenus() {
        this.animalMenuSprites = new ArrayList<>();
        this.buildingMenuSprites = new ArrayList<>();
        this.animalsMenu = new HBox();
        this.buildingsMenu = new HBox();

        // Add the building sprites
        for (int i = 0; i < BUILDINGS.length; i++) {
            BuildingMenuSprite sprite = new BuildingMenuSprite(BUILDINGS[i]);

            if (!worldEntityInfo.containEntity(sprite.getSpriteType())) {
                // this building is not yet registered in the manager. not rendered
                System.err.println("BuildingMenuSprite " + sprite.getSpriteType() + " is " +
                        "not yet registered in WorldEntityInfo");
                continue;
            }

            buildingMenuSprites.add(sprite);
        }

        // Add the animal sprites
        for (int i = 0; i < ANIMALS.length; i++) {
            AnimalMenuSprite sprite = new AnimalMenuSprite(ANIMALS[i]);

            animalMenuSprites.add(sprite);
        }

        // Set up the menus
        setupBuildingsMenu();
        setupAnimalsMenu();

    }

    /**
     * Set up the animals menu
     */
    private void setupAnimalsMenu() {
        if (animalsMenu.getChildren().size() == 0) {
            /*
             * Firstly add all animal sprites to the menu first
             */
            animalsMenu.getChildren().addAll(animalMenuSprites);

            /*
             * Then adjust the size of the sprites accordingly
             */
            // TODO IMPLEMENT THIS
            for (int i = 0; i < animalMenuSprites.size(); i++) {
                AnimalMenuSprite sprite = animalMenuSprites.get(i);

                // STUB METHOD - set max height for the sprites
//                sprite.setFitHeight(animalsMenu.getHeight());
            }
        }
    }

    /**
     * Set up the buildings menu for players to select buildings to add to the world
     */
    private void setupBuildingsMenu() {
        // Check if the buildings menu has been instantiated before
        if (buildingsMenu.getChildren().size() == 0) {
            /*
             * Firstly add all building sprites to the menu first
             */
            buildingsMenu.getChildren().addAll(buildingMenuSprites);

            /*
             * Then adjust the size of the sprites accordingly
             */
            // Get the officially defined scale from the rendering manager
            double UIScale = RenderingInformation.UIScale;

            // adjust the size of the sprites
            for (int i = 0; i < buildingMenuSprites.size(); i++) {
                BuildingMenuSprite sprite = buildingMenuSprites.get(i);

                // Get the size of the building in tile-unit first
                int xLength = 0;
                int yLength = 0;
                try {
                    xLength = worldEntityInfo.getBuildingLength(
                            sprite.getSpriteType(), worldEntityInfo.XLength
                    );
                    yLength = worldEntityInfo.getBuildingLength(
                            sprite.getSpriteType(), worldEntityInfo.YLength
                    );
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                if (xLength == 0 || yLength == 0) {
                    // this building is not yet registered
                    System.err.println("BuildingMenuSprite: " + sprite.getSpriteType() + "is" +
                            " not yet registered in WorldEntityInfo");
                    return;
                }

                // Now set the size of the sprite based on the length in tile unit, and
                // the variable UIScale
                sprite.setFitHeight((sprite.getSpriteHeight() / xLength) * UIScale);
                sprite.setFitWidth((sprite.getSpriteWidth() / yLength) * UIScale);
            }
        }
    }

    /**
     * This method is called when FXML Loader instantiates this class
     *
     * TODO: constructor logic will be moved to this method later
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
