package uq.deco2800.ducktales;

import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.features.achievements.AchievementManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.level.LevelManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.features.missions.MissionManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.handlers.InGameMouseMovedHandler;
import uq.deco2800.ducktales.util.events.handlers.MenuSelectedEventHandler;
import uq.deco2800.ducktales.util.events.ui.MenuSelectedEvent;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * <p>
 *     This class is responsible for controlling GUI logic - it will  have a
 *     handle on all secondary managers, and thus make sure the GUI is updated
 *     appropriately as the game state changes
 * </p>
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class GameManager {
    /**
     * CONSTANTS
     */
    private static final int DEFAULT_WORLD_WIDTH = 30;
    private static final int DEFAULT_WORLD_HEIGHT = 30;

    /** The root of everything. */
    private Pane root;

    /** Variables to control GUI logic */
    private ResourceType currentResourceManaging;

    /** The model of the game */
    private World world;

    /** The Secondary Managers */
    private HUDManager hudManager;
    private MarketManager marketManager;
    private WorldDisplayManager worldDisplayManager;
    private MissionManager missionManager;
    private LevelManager levelManager;
    private AchievementManager achievementManager;
    private CursorManager cursorManager;

    /**
     * Instantiate an empty game manager and create a new default world
     */
    public GameManager(Pane root) {
        // Instantiate an empty game manager without a pre-loaded world.
        // Setup initial variables
        this.root = root;
        currentResourceManaging = NONE;

        // Set up the secondary managers that are not linked to FXML
        cursorManager = new CursorManager(this.root);

        // Create a new world model for the game
        world = new World(
                "New World",
                DEFAULT_WORLD_WIDTH,
                DEFAULT_WORLD_HEIGHT
        );
    }

    /**
     * Instantiate a Game Manager with the given world
     * @param world
     *          The world to be loaded into the game
     */
    public GameManager(Pane root, World world) {
        this.root = root;
        this.world = world;
    }

    /**
     * This method is called by {@link GameController} when all the managers have
     * been set up. It will officially start the game by initiating all view logic
     * such as: tell {@link WorldDisplayManager} to render the initial world
     */
    public void startGame() {
        System.err.println("\n worldDisplayManager is: " + worldDisplayManager);
        // Pass the world model to the display manager, and initialize the display
        worldDisplayManager.setWorld(this.world);
        worldDisplayManager.initializeWorld();

        // This is needed since rendered tiles will be on top of HUD :(
        hudManager.bringGUIToFront();

        setupEventHandlers();

    }


    /**
     * Get the type of the resource being managed. For example, a building
     * that the player is trying to add to the game world
     *
     * @return the type of the resource currently being managed
     */
    public ResourceType getCurrentResourceManaging() {
        return currentResourceManaging;
    }

    /**
     * Set the current resource being managed
     *
     * @param currentResourceManaging
     */
    public void setCurrentResourceManaging(ResourceType currentResourceManaging) {
        this.currentResourceManaging = currentResourceManaging;
    }

    /**
     * Return the current game world, which contains all the information about
     * the current game being played
     *
     * @return the current world of the game
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * Set the world for the current game
     *
     * @param world
     *          The world of the game
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Get the HUD Manager of the game
     * @return the HUD Manager
     */
    public HUDManager getHudManager() {
        return hudManager;
    }

    /**
     * Pass the handle for the HUD Manager to Game Manager
     * @param hudManager
     *          The HUD Manager of the game
     */
    public void setHudManager(HUDManager hudManager) {
        this.hudManager = hudManager;
    }

    /**
     * Get the Market Manager of the game
     * @return the Market Manager
     */
    public MarketManager getMarketManager() {
        return marketManager;
    }

    /**
     * Pass the handle for the Market Manager to the Game Manager
     * @param marketManager
     *          The Market Manager of the game
     */
    public void setMarketManager(MarketManager marketManager) {
        this.marketManager = marketManager;
    }

    /**
     * Get the World Display Manager of the game
     * @return The World Display Manager
     */
    public WorldDisplayManager getWorldDisplayManager() {
        return worldDisplayManager;
    }

    /**
     * Pass the handle for the World Display Manager of the game to the Game Manager
     * @param worldDisplayManager
     *          The World Display Manager of the game
     */
    public void setWorldDisplayManager(WorldDisplayManager worldDisplayManager) {
        this.worldDisplayManager = worldDisplayManager;

    }

    public MissionManager getMissionManager() {
    	return missionManager;
    }
    
    public void setMissionManager(MissionManager missionManager) {
    	this.missionManager = missionManager;
    }
    
    public LevelManager getLevelManager() {
    	return levelManager;
    }

    public void setLevelManager(LevelManager levelManager) {
    	this.levelManager = levelManager;
    }
    
    public AchievementManager getAchievementManager() {
    	return achievementManager;
    }
    
    public void setAchievementManager(AchievementManager achievementManager){
    	this.achievementManager = achievementManager;
    }


    /**
     * Set up the event handlers for the root pane of the game. The current
     * events being handled:
     *      1. A menu sprite is clicked on -> update cursor image
     */
    private void setupEventHandlers() {
        // Initialize the handlers
        MenuSelectedEventHandler menuSelectedEventHandler =
                new MenuSelectedEventHandler(this, this.cursorManager);
        InGameMouseMovedHandler mouseMovedHandler =
                new InGameMouseMovedHandler(this.cursorManager);

        // Handler for when a sprite in the menu is selected
        root.addEventHandler(MenuSelectedEvent.MENU_SELECTED_EVENT, menuSelectedEventHandler );
        // Handler for when the mouse is moved in-game
        root.setOnMouseMoved(mouseMovedHandler);
    }

}
