package uq.deco2800.ducktales;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.HUD.BuildingSprite;
import uq.deco2800.ducktales.renderingEngine.WorldEntityRenderingInfo;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.builder.WorldEntitySprite;

import java.util.ArrayList;
import java.util.Collection;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameRendererBeta extends AnimationTimer {
    /**
     * CONSTANTS
     */
    private final ResourceType[] BUILDINGS = {
        HOSPITAL, BAKERY, BARN
    };

    /** The Root pane */
    private Pane root;

    /** The game pane where all HUD elements, and world pane will be added to */
    private BorderPane gamePane;

    /** HUD variables */
    private Pane worldPane; // The main area where game graphics will be rendered onto
    private AnchorPane buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation
    private ArrayList<ImageView> buildingSprites; // The sprites of the buildings in the menu

    /**
     * The global game variables
     */
    private World world; // the game world
    private GameManagerBeta manager; // the game manager

    /**
     * VARIABLES FOR RENDERING
     */
    // The scale/zoom factor
    private double SCALE = 0.2;
    // The very first point to start render the tiles
    private double startingX;
    private double startingY;

    /**
     * The class containing the info to render different types of entities
     */
    WorldEntityRenderingInfo renderingInfo;

    /**
     * Constructor class for {@link GameRendererBeta} class
     */
    public GameRendererBeta() {
        // Retrieving the global game variables
        this.world = GameManagerBeta.getInstance().getWorld();
        this.manager = GameManagerBeta.getInstance();


    }



    /**
     * Show the buildings being able to construct in the buildings menu
     */
    public void showBuildingMenu() {
        buildingsMenu.getChildren().addAll(buildingSprites);

    }

    /**
     * Store the handles for the given UI elements
     * @param worldPane
     * @param buttonsMenu
     * @param buildingsMenu
     */
    public void setUIElements(BorderPane root, Pane worldPane, AnchorPane buttonsMenu, HBox buildingsMenu) {
        this.root = root;
        this.worldPane = worldPane;
        this.buttonsMenu = buttonsMenu;
        this.buildingsMenu = buildingsMenu;

        System.err.println("root pane width length: " + root.getWidth() + ", " +
        root.getHeight());
    }

    @Override
    public void handle(long now) {

    }

    @Override
    public void start() {
        super.start();

        // Setting up for the initial rendering
        setupInitialRendering();

        // Initialize the building sprites for buildings menu
        buildingSprites = new ArrayList<>();
        for (int i = 0; i < BUILDINGS.length; i++) {
            buildingSprites.add(new BuildingSprite(BUILDINGS[i]));
        }
    }

    /**
     * Setting up the initial rendering values for the game
     *
     * NOTE: make sure to call this method after all UI elements have been
     * instantiated
     */
    private void setupInitialRendering() {
        this.startingX = root.getWidth() / 2;
        this.startingY = root.getHeight() * 0.2;
    }

}
