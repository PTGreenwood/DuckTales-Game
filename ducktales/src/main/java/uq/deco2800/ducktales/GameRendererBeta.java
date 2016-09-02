package uq.deco2800.ducktales;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.renderingEngine.WorldEntityRenderingInfo;
import uq.deco2800.ducktales.hud.BuildingSprite;
import uq.deco2800.ducktales.renderingEngine.RenderingManager;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.renderingEngine.tiles.TileBeta;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.util.Events.TileEvents.TileClickedEvent;
import uq.deco2800.ducktales.util.Events.TileEvents.TileEnteredEvent;
import uq.deco2800.ducktales.util.Events.TileEvents.TileExitedEvent;
import uq.deco2800.ducktales.util.Events.UIEvents.BuildingMenuDeselectedEvent;
import uq.deco2800.ducktales.util.Events.UIEvents.BuildingMenuSelectedEvent;
import uq.deco2800.ducktales.util.Events.UIEvents.CursorMovedEvent;
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
    private static final ResourceType[] BUILDINGS = {
        //HOSPITAL, BAKERY, BARN, <--- these buildings are of the wrong size
        CLINIC, PASTURE
    };

    /** The Root pane where all HUD elements, and world pane will be added to*/
    private AnchorPane root;

    /** HUD variables */
    private Pane worldPane; // The main area where game graphics will be rendered onto
    private AnchorPane buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation
    private ArrayList<BuildingSprite> buildingSprites; // The sprites of the buildings in the menu

    /** UI Variables */
    // The image to be show at the cursor whenever the play is 'drag&dropping'
    private ImageView cursorImage;

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
     * Initialize a game renderer with the given UI Elements
     *
     * NOTE: avoid setting up the renderer in this function, as the UI elements
     * might not have been initialized. Do it in start() instead
     *
     * Constructor class for {@link GameRendererBeta} class
     *
     * @param root
     * @param worldPane
     * @param buttonsMenu
     * @param buildingsMenu
     */
    public GameRendererBeta(AnchorPane root, Pane worldPane,
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

        // Setup cursor image
        this.cursorImage = new ImageView();
        this.cursorImage.setMouseTransparent(true);
        root.getChildren().add(this.cursorImage);

        // Initialize the building sprites for buildings menu
        buildingSprites = new ArrayList<>();
        for (int i = 0; i < BUILDINGS.length; i++) {
            BuildingSprite sprite = new BuildingSprite(BUILDINGS[i]);

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
        this.startingY = root.getPrefHeight() * 0.05;

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
                tile.setImage(resource.getResourceImage(tile.getTileType()));

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
            tile.setImage(resource.getResourceImage(tile.getTileType()));
        });
        worldPane.addEventHandler(TileClickedEvent.TILE_CLICKED, event -> {
            System.err.println("building " + manager.getCurrentResourceManaging()
            + " to be added to: " + event.getxPos() + ", " +event.getyPos());

            // Check if there is any resource currently being managed
            if (manager.getCurrentResourceManaging() != NONE) {
                // Tell the manager to add the building to the game world
                manager.addBuildingToWorld(
                        manager.getCurrentResourceManaging(),
                        event.getxPos(),
                        event.getyPos()
                );
            }

            // reset the cursor image
            cursorImage.setImage(null);

            // reset manager's current resource managing
            manager.setCurrentResourceManaging(NONE);
        });

        /*
         * Event handlers for the buildings menu
         */
        buildingsMenu.addEventHandler(BuildingMenuSelectedEvent.BUILDING_MENU_SELECTED_EVENT, event -> {
            // Setup the cursor image to that of the building clicked
            Image sprite = resource.getResourceImage(event.getType());

            // Reset the sprite's position
            this.cursorImage.setLayoutX(event.getStartingX());
            this.cursorImage.setLayoutY(event.getStartingY());

            // Scale the cursor image by the scale given by rendering manager
            double scale = renderingManager.getBuildingScale();
            this.cursorImage.setFitHeight(sprite.getHeight() * scale);
            this.cursorImage.setFitWidth(sprite.getWidth() * scale);

            // Setup the offset
            this.cursorImage.setX(-cursorImage.getFitWidth()/2);
            this.cursorImage.setY(-cursorImage.getFitHeight()/2);

            // reveal the sprite
            this.cursorImage.setImage(sprite);

            // notify the manager
            System.err.println("building clicked: " + event.getType());
            manager.setCurrentResourceManaging(event.getType());

        });
        buildingsMenu.addEventHandler(BuildingMenuDeselectedEvent.BUILDING_MENU_DESELECTED_EVENT, event -> {
            // Return the cursor image to null, and perform update on the world tiles
            // if the mouse is released on top of a tile
            this.cursorImage.setImage(null);

            // set the current resource managed to be NONE
            manager.setCurrentResourceManaging(NONE);

            System.err.println("deselected a building");

        });

        root.addEventHandler(CursorMovedEvent.CURSOR_MOVED_EVENT, event -> {
            // Update the cursor image to the corresponding position
            cursorImage.setLayoutX(event.getX());
            cursorImage.setLayoutY(event.getY());

            // Make the cursor image stop receiving mouse events
            cursorImage.setMouseTransparent(true);
        });

        root.setOnMouseMoved(event -> {
            if (cursorImage != null) {
                this.cursorImage.setLayoutX(event.getX());
                this.cursorImage.setLayoutY(event.getY());
            }
        });

        root.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                // right mouse is clicked - deselect the building
                cursorImage.setImage(null);
                manager.setCurrentResourceManaging(ResourceType.NONE);
            }
        });
    }

}
