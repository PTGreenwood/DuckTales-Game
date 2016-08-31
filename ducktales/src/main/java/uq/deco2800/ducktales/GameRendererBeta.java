package uq.deco2800.ducktales;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.HUD.BuildingSprite;
import uq.deco2800.ducktales.renderingEngine.WorldEntityRenderingInfo;
import uq.deco2800.ducktales.renderingEngine.RenderingManager;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.resources.tiles.TileBeta;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.util.Events.TileEvents.TileEnteredEvent;
import uq.deco2800.ducktales.util.Events.TileEvents.TileExitedEvent;
import uq.deco2800.ducktales.world.WorldBeta;

import java.util.ArrayList;

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

    /** The Root pane where all HUD elements, and world pane will be added to*/
    private BorderPane root;

    /** HUD variables */
    private Pane worldPane; // The main area where game graphics will be rendered onto
    private AnchorPane buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation
    private ArrayList<BuildingSprite> buildingSprites; // The sprites of the buildings in the menu

    /**
     * The global game variables
     */
    private WorldBeta world; // the game world
    private GameManagerBeta manager; // the game manager
    private ResourceRegister resource;

    /**
     * VARIABLES FOR RENDERING
     */
    // Variables managing rendering information
    private RenderingManager renderingManager;
    private WorldEntityRenderingInfo entityRenderingInfo;
    // The very first point to start render the tiles
    private double startingX;
    private double startingY;
    // The scale/zoom factor
    private double generalScale;

    /**
     * The class containing the info to render different types of entities
     */


    /**
     * Constructor class for {@link GameRendererBeta} class
     */
    public GameRendererBeta(BorderPane root, Pane worldPane,
                            AnchorPane buttonsMenu, HBox buildingsMenu) {
        // Setup UI elements
        this.root = root;
        this.worldPane = worldPane;
        this.buttonsMenu = buttonsMenu;
        this.buildingsMenu = buildingsMenu;

        resource = ResourceRegister.getInstance();
    }

    /**
     * This method is where most of the setup will be done, since when this is
     * called, it is made sure that all UI elements have already been instantiated
     */
    @Override
    public void start() {
        super.start();

        // Setting up for the initial rendering
        setupInitialRenderingInfo();

        // Initialize the building sprites for buildings menu
        buildingSprites = new ArrayList<>();
        for (int i = 0; i < BUILDINGS.length; i++) {
            BuildingSprite sprite = new BuildingSprite(BUILDINGS[i], this.manager);

            buildingSprites.add(sprite);
        }

        // Do the initial rendering of the world
        renderWorld();

        // Setup the CUSTOM event handlers for the game
        setupCustomEventHandler();
    }

    /*---------*
     * SETTERS *
     *---------*/
    /**
     * Store a handle of the game manager for communication
     *
     * @param manager
     *          The manager of the game
     */
    public void setManager(GameManagerBeta manager) {
        this.manager = manager;
    }

    /**
     * Set the game world for the renderer
     *
     * @param world
     *          The current game world
     */
    public void setWorld(WorldBeta world) {
        this.world = world;
    }

    /**
     * Set the rendering manager, which will provide the renderer with rendering
     * information such as scale factors and different sizes
     *
     * @param renderingManager
     *          The rendering manager for the game
     */
    public void setRenderingManager(RenderingManager renderingManager) {
        this.renderingManager = renderingManager;
    }

    /*---------*
     * GETTERS *
     *---------*/

    /**
     * Show the buildings being able to construct in the buildings menu
     */
    public void showBuildingMenu() {
        buildingsMenu.getChildren().addAll(buildingSprites);

        // Get the officially defined scale from the rendering manager
        double UIScale = renderingManager.getUIScale();

        // adjust the size of the sprites
        for (int i = 0; i < buildingSprites.size(); i++) {
            BuildingSprite sprite = buildingSprites.get(i);
            sprite.setFitHeight(sprite.getSpriteHeight() * UIScale);
            sprite.setFitWidth(sprite.getSpriteWidth() * UIScale);
        }

    }

    @Override
    public void handle(long now) {

    }

    /**
     * Setting up the initial rendering values for the game
     *
     * NOTE: make sure to call this method after all UI elements have been
     * instantiated
     */
    private void setupInitialRenderingInfo() {
        this.startingX = root.getPrefWidth() / 2;
        this.startingY = root.getPrefHeight() * 0.1;

        this.generalScale = renderingManager.getMainScaleFactor();

    }

    /**
     * Create the initial game world
     */
    private void renderWorld() {
        Array2D<TileBeta> tiles = world.getTiles();

        int tileHeight = resource.TILE_HEIGHT;
        int tileWidth = resource.TILE_WIDTH;

        int scaledWidth = (int) (tileWidth * generalScale);
        int scaledHeight = (int) (tileHeight * generalScale);

        TileBeta tile;

        // Iterate over each tile and set their location to the default location
        for (int i = 0; i < tiles.getWidth(); i++) {
            for (int j = 0; j < tiles.getHeight(); j++) {
                double x = startingX + (j - i) * scaledWidth / 2;
                double y = startingY + (j + i) * scaledHeight / 2;

                tile = tiles.get(i, j);
                tile.setImage(resource.getResourceImage(tile.getType()));

                tile.setFitHeight(tileHeight * generalScale);
                tile.setFitWidth(tileWidth * generalScale);

                tile.setLayoutX(x);
                tile.setLayoutY(y);

                worldPane.getChildren().add(tile);

            }
        }


    }


    /**
     * This method will set up the handler for custom events, as defined in
     * the util.Events package. The worldPane, as the parent node, will have handlers
     * for those event, in order for it to notify the Game Manager or Renderer
     * accordingly
     */
    private void setupCustomEventHandler() {
        worldPane.addEventHandler(TileEnteredEvent.TILE_ENTERED, event -> {
            TileBeta tile = world.getTiles().get(event.getxPos(), event.getyPos());
            tile.setImage(resource.getResourceImage(BLANK));
        });
        worldPane.addEventHandler(TileExitedEvent.TILE_EXITED, event -> {
            //System.err.println(event.toString());
            TileBeta tile = world.getTiles().get(event.getxPos(), event.getyPos());
            tile.setImage(resource.getResourceImage(tile.getType()));
        });
    }

}
