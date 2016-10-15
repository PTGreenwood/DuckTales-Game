package uq.deco2800.ducktales;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.features.achievements.AchievementManager;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.ThreatManager;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.features.helper.HelperManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.features.inventory.InventoryManager;
import uq.deco2800.ducktales.features.level.LevelManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.tutorials.TutorialController;
import uq.deco2800.ducktales.features.weather.WeatherManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.features.missions.MissionManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.handlers.custom.AnimalDeadEventHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.HUDDeselectedHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.MenuSelectedEventHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.TileClickedHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.TileEnteredHandler;
import uq.deco2800.ducktales.util.events.handlers.keyboard.InGameKeyboardHandler;
import uq.deco2800.ducktales.util.events.handlers.mouse.InGameMouseClickedHandler;
import uq.deco2800.ducktales.util.events.handlers.mouse.InGameMouseMovedHandler;
import uq.deco2800.ducktales.util.events.tile.TileClickedEvent;
import uq.deco2800.ducktales.util.events.tile.TileEnteredEvent;
import uq.deco2800.ducktales.util.events.ui.AnimalDeadEvent;
import uq.deco2800.ducktales.util.events.ui.HUDDeselectedEvent;
import uq.deco2800.ducktales.util.events.ui.MenuSelectedEvent;
import uq.deco2800.ducktales.features.hud.menu.MenuManager.MenuType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

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
    private static final int DEFAULT_GAME_SPEED = 10;

    /** The root of everything. */
    private Pane root;

    /** Variables to control GUI logic */
    private ResourceType currentEntityManaging;
    private MenuType menuSelected;

    /** The model of the game */
    private World world;

    /** The main game loop control variables*/
    private ExecutorService executor; // I still don't know what this thing does...
    private GameLoop gameLoop; // The main loop of the game
    private AtomicBoolean quit; // Control ending the game

    /** The Secondary Managers */
    private HUDManager hudManager;
    private MarketManager marketManager;
    private WorldDisplayManager worldDisplayManager;
    private HelperManager helperManager;
    private MissionManager missionManager;
    private LevelManager levelManager;
    private AchievementManager achievementManager;
    private TutorialController tutorialManager;
    private CursorManager cursorManager;
    private MainEntityManager mainEntityManager;
    private TimeManager timeManager;
    private ThreatManager threatManager;
    private InventoryManager inventoryContainer;
    private WeatherManager weatherManager;
    private ResourceEntityManager resourceEntityManager;
    
    /**
     * Instantiate an empty game manager and createBuildingSprite a new default world
     */
    public GameManager(Pane root) {
        // Instantiate an empty game manager without a pre-loaded world.
        // Setup initial variables
        this.root = root;
        currentEntityManaging = NONE;

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
     * Get the root pane where everything is rendered onto
     *
     * @return the root pane
     */
    public Pane getRoot() {
        return this.root;
    }

    /**
     * This method is called by {@link GameController} when all the managers have
     * been set up. It will officially start the game by initiating all view logic
     * such as: tell {@link WorldDisplayManager} to render the initial world
     */
    public void startGame() {
        // Pass the world model to the display manager, and initialize the display
        worldDisplayManager.setWorld(this.world);
        worldDisplayManager.initializeWorld();

        // Now set up the entity manager and start its routine
        mainEntityManager.setTilesManager(worldDisplayManager.getTilesManager());
        mainEntityManager.setWorldDisplay(worldDisplayManager.getWorldDisplay());
        mainEntityManager.startRoutine();

        // Start the manager of all the horrible threats in the world.
        threatManager = new ThreatManager();
        threatManager.setWorld(this.world);

        // This is needed since rendered tiles will be on top of HUD :(
        hudManager.bringGUIToFront();

        // Set up the main game loop. This is done after rendering is set up
        setupGameLoop();

        setupEventHandlers();
    }


    /**
     * Get the type of the resource being managed. For example, a building
     * that the player is trying to add to the game world
     *
     * @return the type of the resource currently being managed
     */
    public ResourceType getCurrentEntityManaging() {
        return currentEntityManaging;
    }

    /**
     * Set the current resource being managed
     *
     * @param currentEntityManaging
     */
    public void setCurrentEntityManaging(ResourceType currentEntityManaging) {
        this.currentEntityManaging = currentEntityManaging;
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
        this.worldDisplayManager.setGameManager(this);
    }

    public HelperManager getHelperManager() {
    	return helperManager;
    }
    public void setHelperManager(HelperManager helperManager) {
    	this.helperManager = helperManager;
    }
    public MissionManager getMissionManager() {
        return missionManager;
    }
    
    public void setMissionManager(MissionManager missionManager) {
        this.missionManager = missionManager;
    }
    
    public TutorialController getTutorialManager() {
    	return tutorialManager;
    }
    
    public void setTutorialManager(TutorialController tutorialManager) {
    	this.tutorialManager = tutorialManager;
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

    public CursorManager getCursorManager() {
        return cursorManager;
    }

    public void setCursorManager(CursorManager cursorManager) {
        this.cursorManager = cursorManager;
    }

    public MainEntityManager getMainEntityManager() {
        return mainEntityManager;
    }

    public void setMainEntityManager(MainEntityManager mainEntityManager) {
        this.mainEntityManager = mainEntityManager;
    }
    
    public ResourceEntityManager getResourceEntityManager() {
    	return resourceEntityManager;
    }
    
    public void setResourceEntityManager(ResourceEntityManager resourceEntityManager) {
    	this.resourceEntityManager = resourceEntityManager;
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }
    
    public WeatherManager getWeatherManager() {
    	return this.weatherManager;
    }

    public void setTimeManager(TimeManager timeManager) {
        this.timeManager = timeManager;
    }
    
    public void setWeatherManager(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    /**
     * Set up the event handlers for the root pane of the game. The current
     * events being handled:
     *      1. A menu sprite is clicked on -> update cursor image
     */
    private void setupEventHandlers() {
        // Initialize the custom handlers
        MenuSelectedEventHandler menuSelectedEventHandler =
                new MenuSelectedEventHandler(this);
        InGameMouseMovedHandler mouseMovedHandler =
                new InGameMouseMovedHandler(this.cursorManager);
        InGameMouseClickedHandler mouseClickedHandler =
                new InGameMouseClickedHandler(this);
        TileEnteredHandler tileEnteredHandler =
                new TileEnteredHandler(this);
        TileClickedHandler tileClickedHandler =
                new TileClickedHandler(this);
        HUDDeselectedHandler hudDeselectedHandler =
                new HUDDeselectedHandler(this);
        InGameKeyboardHandler keyboardHandler =
                new InGameKeyboardHandler(this);
        AnimalDeadEventHandler animalDeadEventHandler = 
        		new AnimalDeadEventHandler(this); 


        // Handler for when a sprite in the menu is selected
        root.addEventHandler(MenuSelectedEvent.MENU_SELECTED_EVENT, menuSelectedEventHandler );
        // Handler for when the mouse is moved in-game
        root.setOnMouseMoved(mouseMovedHandler);
        // Handler for when the mouse is clicked
        root.setOnMouseClicked(mouseClickedHandler);
        // Handler for when a tile is entered
        root.addEventHandler(TileEnteredEvent.TILE_ENTERED, tileEnteredHandler);
        // Handler for when a tile is clicked on
        root.addEventHandler(TileClickedEvent.TILE_CLICKED, tileClickedHandler);
        // Handler for the HUD Deselected Event
        root.addEventHandler(HUDDeselectedEvent.HUD_DESELECTED_EVENT, hudDeselectedHandler);
        // Handler for all keyboard events
        root.addEventHandler(KeyEvent.ANY, keyboardHandler);
        // Handler for when an animal dies
        root.addEventHandler(AnimalDeadEvent.ANIMAL_DEAD_EVENT, animalDeadEventHandler);
    }

    /**
     * Set up the game loop for the game
     */
    private void setupGameLoop() {
        // NOTE: THESE METHODS SHOULD BE CALLED AFTER RENDERING IS SET UP
        executor = Executors.newCachedThreadPool();
        quit = new AtomicBoolean(false);
        this.gameLoop = new GameLoop(quit, DEFAULT_GAME_SPEED); // Initiate the game loop
        executor.execute(this.gameLoop); // Start the game loop

        // Pass the managers to the game loop
        gameLoop.setMainEntityManager(this.mainEntityManager);
        gameLoop.setTimeManager(this.timeManager);        
        gameLoop.setWeatherManager(this.weatherManager);        
        gameLoop.setWorld(this.world);
    }

    /**
     * Set the type of the menu selected - used when user tries to add something
     * from the menu into the world
     *
     * @param menuSelected
     *          The type of menu item selected
     */
    public void setMenuSelected(MenuManager.MenuType menuSelected) {
        this.menuSelected = menuSelected;
    }

    /**
     * Get the type of menu selected
     *
     * @return the type of menu selected
     */
    public MenuType getMenuSelected() {
        return this.menuSelected;
    }


    /* Instantiate an empty Inventory container for resources */
    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryContainer = inventoryManager;
    }
    public InventoryManager getInventoryContainer() {
        return inventoryContainer;
    }
}