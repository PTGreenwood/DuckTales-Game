package uq.deco2800.ducktales;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.rendering.engine.WorldEntityRenderingInfo;
import uq.deco2800.ducktales.rendering.hud.AnimalSprite;
import uq.deco2800.ducktales.rendering.hud.BuildingSprite;

import uq.deco2800.ducktales.rendering.managers.RenderingManager;
import uq.deco2800.ducktales.rendering.managers.WorldEntityInfoManager;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.rendering.tiles.TileBeta;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.util.events.tile.*;
import uq.deco2800.ducktales.util.events.ui.*;
import uq.deco2800.ducktales.world.WorldBeta;

import java.util.ArrayList;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This is the rendering engine for the game. More information can be found on the
 * wiki page called New Rendering Engine.
 * <p>
 * Created on 31/08/2016.
 *
 * @author khoiphan21
 */
public class GameRendererBeta extends AnimationTimer {
    /**
     * CONSTANTS
     */
    // TODO: TO ADD NEW BUILDINGS, REGISTER THEIR NAMES HERE
    private static final ResourceType[] BUILDINGS = {
        //HOSPITAL, BAKERY, BARN, <--- these buildings are of the wrong size
        PASTURE, BUTCHER, COMMUNITY_BUILDING, BAKERY, CONSTRUCTION
    };
    // TODO: TO ADD NEW ANIMALS, REGISTER THEIR NAMES HERE
    private static final ResourceType[] ANIMALS = {
        DUCK
    };

    /** The Root pane where all HUD elements, and world pane will be added to*/
    private AnchorPane root;

    /** HUD variables */
    private Pane worldPane; // The main area where game graphics will be rendered onto
    private AnchorPane buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation
    private HBox animalsMenu; // Where animals can be added to the world
    private ArrayList<BuildingSprite> buildingSprites; // The sprites of the buildings in the menu
    private ArrayList<AnimalSprite> animalSprites; // The sprites of the animals

    /** UI Variables */
    // The image to be show at the cursor whenever the play is 'drag&dropping'
    private ImageView cursorImage;
    // The variable to determine when the root must handle the cursor again
    private boolean cursorImageFreeMoving = true;

    /**
     * The global game variables
     */
    private WorldBeta world; // the game world
    private GameManagerBeta manager; // the game manager
    private ResourceSpriteRegister resource;
    private WorldEntityInfoManager worldEntityInfoManager; // for rendering purposes

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
     * List of all rendered entities. Current implementation is only ImageView,
     * but in the future, each rendered entity will have their own respective
     * classes, in order to handle click event more appropriately
     */
    private ArrayList<ImageView> renderedEntities;

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
    public GameRendererBeta(AnchorPane root, Pane worldPane, AnchorPane buttonsMenu,
                            HBox buildingsMenu, HBox animalsMenu) {
        // Setup UI elements
        this.root = root;
        this.worldPane = worldPane;
        this.buttonsMenu = buttonsMenu;
        this.buildingsMenu = buildingsMenu;
        this.animalsMenu = animalsMenu;

        worldEntityInfoManager = WorldEntityInfoManager.getInstance();

        resource = ResourceSpriteRegister.getInstance();
    }

    /**
     * This method is where most of the setup will be done, since when this is
     * called, it is made sure that all UI elements have already been instantiated
     */
    public void start() {
        super.start();

        // Setting up for the initial rendering
        setupInitialRenderingInfo();

        // Setup cursor image
        this.cursorImage = new ImageView();
        this.cursorImage.setMouseTransparent(true);
        worldPane.getChildren().add(this.cursorImage);

        // Initialize the sprites for the buildings and animals menu
        buildingSprites = new ArrayList<>();
        animalSprites = new ArrayList<>();
        addSpritesToMenuList();

        // Do the initial rendering of the world
        renderWorld();

        // Setup the CUSTOM event handlers for the game
        setupCustomEventHandler();
    }

    @Override
    public void handle(long now) {

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
     * Show the animals that the player can add in the animals menu
     */
    public void showAnimalsMenu() {
        if (animalsMenu.getChildren().size() == 0) {
            /*
             * Firstly add all animal sprites to the menu first
             */
            animalsMenu.getChildren().addAll(animalSprites);

            /*
             * Then adjust the size of the sprites accordingly
             */
            // TODO IMPLEMENT THIS
            for (int i = 0; i < animalSprites.size(); i++) {
                AnimalSprite sprite = animalSprites.get(i);

                // STUB METHOD - set max height for the sprites
                sprite.setFitHeight(animalsMenu.getHeight());
            }
        }

        animalsMenu.setVisible(true);
        buildingsMenu.setVisible(false);
    }

    /**
     * Show the buildings that the player can construct in the buildings menu
     *
     * @require all buildings in buildingSprites must have been registered in
     *          WorldEntityInfoManager
     * @ensure each building in buildingSprites will be shown onto the buildingsMenu
     */
    public void showBuildingMenu() {
        // Check if the buildings menu has been instantiated before
        if (buildingsMenu.getChildren().size() == 0) {
            /*
             * Firstly add all building sprites to the menu first
             */
            buildingsMenu.getChildren().addAll(buildingSprites);

            /*
             * Then adjust the size of the sprites accordingly
             */
            // Get the officially defined scale from the rendering manager
            double UIScale = renderingManager.getUIScale();

            // adjust the size of the sprites
            for (int i = 0; i < buildingSprites.size(); i++) {
                BuildingSprite sprite = buildingSprites.get(i);

                // Get the size of the building in tile-unit first
                int xLength = 0;
                int yLength = 0;
                try {
                    xLength = worldEntityInfoManager.getBuildingLength(
                            sprite.getSpriteType(), worldEntityInfoManager.XLength
                    );
                    yLength = worldEntityInfoManager.getBuildingLength(
                            sprite.getSpriteType(), worldEntityInfoManager.YLength
                    );
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                if (xLength == 0 || yLength == 0) {
                    // this building is not yet registered
                    System.err.println("Building: " + sprite.getSpriteType() + "is" +
                            " not yet registered in WorldEntityInfoManager");
                    return;
                }

                // Now set the size of the sprite based on the length in tile unit, and
                // the variable UIScale
                sprite.setFitHeight((sprite.getSpriteHeight() / xLength) * UIScale);
                sprite.setFitWidth((sprite.getSpriteWidth() / yLength) * UIScale);
            }
        }

        buildingsMenu.setVisible(true);
        animalsMenu.setVisible(false);
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

        this.renderedEntities = new ArrayList<>();
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
                // Okay tbh, this is a bit of math - draw it out and it makes
                // more sense. Essentially (x, y) is where to put the tile
                double x = startingX + (j - i) * scaledWidth / 2;
                double y = startingY + (j + i) * scaledHeight / 2;

                tile = tiles.get(i, j);
                tile.setImage(resource.getResourceImage(tile.getTileType()));

                // Adjust the height of the sprite to the given scale
                tile.setFitHeight(tileHeight * generalScale);
                tile.setFitWidth(tileWidth * generalScale);

                // Set the position of the tile - where it actually appears
                tile.setLayoutX(x);
                tile.setLayoutY(y);

                // Add the tile onto the screen
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
        // This method is called when a tile is entered. The TileEnterEvent
        // COMPLETELY replaces the onMouseEntered event, so worldPane will not
        // receive onMouseEntered at all
        worldPane.addEventHandler(TileEnteredEvent.TILE_ENTERED, event -> {
            TileBeta tile = world.getTiles().get(event.getxPos(), event.getyPos());

            tile.setImage(resource.getResourceImage(BLANK)); //TODO DELETE

            // Disable the root from controlling the cursor image
            cursorImageFreeMoving = false;

            // Move the cursor image to the appropriate position
            moveCursorBuildingToTile(tile);
        });
        // Reset the cursor image to move with the mouse
        worldPane.setOnMouseEntered(event -> {
            cursorImageFreeMoving = true;
        });
        worldPane.addEventHandler(uq.deco2800.ducktales.util.events.tile.TileExitedEvent.TILE_EXITED, event -> {
            //System.err.println(event.toString());
            TileBeta tile = world.getTiles().get(event.getxPos(), event.getyPos());
            tile.setImage(resource.getResourceImage(tile.getTileType()));
        });
        // A tile is clicked on. Right now the implementation only handles
        // adding a building to the tile
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
                // Add the sprite of the building to the game world
                addToWorld(
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
        // Set the cursorImage to move together with the mouse only when
        // it is allowed to
        worldPane.setOnMouseMoved(event -> {
            if (cursorImageFreeMoving) {
                if (cursorImage != null) {
                    this.cursorImage.setLayoutX(event.getX());
                    this.cursorImage.setLayoutY(event.getY());
                }
            }
        });

        /*
         * Event handlers for the buildings menu
         */
        // This method is called when a building in the menu is clicked on
        buildingsMenu.addEventHandler(BuildingMenuSelectedEvent.BUILDING_MENU_SELECTED_EVENT, event -> {
            // Setup the cursor image to that of the building clicked
            Image sprite = resource.getResourceImage(event.getType());
            // Allow it to move
            cursorImageFreeMoving = true;

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
            this.cursorImage.toFront();

            // notify the manager
            System.err.println("building clicked: " + event.getType());
            manager.setCurrentResourceManaging(event.getType());

        });
        
        buildingsMenu.addEventHandler(HUDDeselectedEvent.HUDDeselectedEvent, event -> {
            // Return the cursor image to null, and perform update on the world tiles
            // if the mouse is released on top of a tile
            this.cursorImage.setImage(null);

            // set the current resource managed to be NONE
            manager.setCurrentResourceManaging(NONE);

            System.err.println("deselected a building");
        });

        root.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                // right mouse is clicked - deselect the building
                cursorImage.setImage(null);
                manager.setCurrentResourceManaging(ResourceType.NONE);
            }
        });
    }

    /**
     * Add the given resource to the world, as well as to the array of
     * entities to manage, when moving the world around
     */
    private void addToWorld(ResourceType type, int xIndex, int yIndex) {
        // shorten the name for easier reading
        WorldEntityInfoManager manager = this.worldEntityInfoManager;

        if (manager.containEntity(type)) {
            // Create (for now) an ImageView at the position of the cursor image
            // and add that image to the list of entities rendered
            ImageView entity = new ImageView();

            // Duplicate all properties from cursor image to entity
            deepCloneSprite(entity, cursorImage);

            // Add the entity to the world, and to the list
            worldPane.getChildren().add(entity);
            renderedEntities.add(entity);
        } else {
            // later will check for agent entities
            System.err.println("Building '" + type + "' is not yet registered");
        }
    }

    /**
     * Move the cursor image to the given tile, at an appropriate point to
     * show the player where the entity would be added if mouse is clicked
     *
     * @param targetTile
     *          The tile currently under the cursor
     */
    private void moveCursorBuildingToTile(TileBeta targetTile) {
        // Shorten the name
        WorldEntityInfoManager manager = this.worldEntityInfoManager;

        // relocate the origin of the cursor image
        cursorImage.setX(-cursorImage.getFitWidth() / 2);
        cursorImage.setY(-cursorImage.getFitHeight());

        System.err.println("x and y origins are: " + cursorImage.getX() +
                ", " + cursorImage.getY());

        // Re-set the location of the cursor image
        cursorImage.setLayoutX(
                targetTile.getLayoutX() + targetTile.getFitWidth() / 2);
        cursorImage.setLayoutY(
                targetTile.getLayoutY() + targetTile.getFitHeight());
    }

    /**
     * Add the building sprites to the list of buildings in the menu
     */
    private void addSpritesToMenuList() {
        // Add the building sprites
        for (int i = 0; i < BUILDINGS.length; i++) {
            BuildingSprite sprite = new BuildingSprite(BUILDINGS[i]);

            if (!worldEntityInfoManager.containEntity(sprite.getSpriteType())) {
                // this building is not yet registered in the manager. not rendered
                System.err.println("Building " + sprite.getSpriteType() + " is " +
                        "not yet registered in WorldEntityInfoManager");
                continue;
            }

            buildingSprites.add(sprite);
        }

        // Add the animal sprites
        for (int i = 0; i < ANIMALS.length; i++) {
            AnimalSprite sprite = new AnimalSprite(ANIMALS[i]);

            animalSprites.add(sprite);
        }
    }

    /**
     * Deep clone a sprite into the given sprite
     *
     * @param source
     *          The sprite to clone from
     * @param destination
     *          The sprite that will store the deep clone
     */
    private void deepCloneSprite(ImageView destination, ImageView source) {
        // Set the image
        destination.setImage(source.getImage());

        // Set the origin
        destination.setX(source.getX());
        destination.setY(source.getY());

        // Set the actual position
        destination.setLayoutX(source.getLayoutX());
        destination.setLayoutY(source.getLayoutY());

        // Set the fit height and width
        destination.setFitHeight(source.getFitHeight());
        destination.setFitWidth(source.getFitWidth());
    }

}
