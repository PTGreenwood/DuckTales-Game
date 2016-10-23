package uq.deco2800.ducktales;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.features.achievements.AchievementManager;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.threats.ThreatManager;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.features.helper.HelperManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.features.level.LevelManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.tutorials.TutorialManager;
import uq.deco2800.ducktales.features.weather.WeatherManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.features.missions.MissionManager;
import uq.deco2800.ducktales.features.notifications.NotificationManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.animal.AnimalDeadEvent;
import uq.deco2800.ducktales.util.events.handlers.animal.AnimalDeadEventHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.HUDDeselectedHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.MenuSelectedEventHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.TileClickedHandler;
import uq.deco2800.ducktales.util.events.handlers.custom.TileEnteredHandler;
import uq.deco2800.ducktales.util.events.handlers.keyboard.InGameKeyboardHandler;
import uq.deco2800.ducktales.util.events.handlers.mouse.InGameMouseClickedHandler;
import uq.deco2800.ducktales.util.events.handlers.mouse.InGameMouseMovedHandler;
import uq.deco2800.ducktales.util.events.handlers.peon.PeonClickedEventHandler;
import uq.deco2800.ducktales.util.events.peon.PeonClickedEvent;
import uq.deco2800.ducktales.util.events.tile.TileClickedEvent;
import uq.deco2800.ducktales.util.events.tile.TileEnteredEvent;
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
    protected static final int DEFAULT_WORLD_WIDTH = 30;
    protected static final int DEFAULT_WORLD_HEIGHT = 30;
    protected static final int DEFAULT_GAME_SPEED = 10;
    protected static final String DEFAULT_WORLD_NAME = "The New World";

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
    private NotificationManager notificationManager;
    private MissionManager missionManager;
    private LevelManager levelManager;
    private AchievementManager achievementManager;
    private TutorialManager tutorialManager;
    private CursorManager cursorManager;
    private MainEntityManager mainEntityManager;
    private TimeManager timeManager;
    private ThreatManager threatManager;
    private WeatherManager weatherManager;
    private PeonInformationDisplayManager peonInformationDisplayManager;
    
    private static GameManager gameManager;
    
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
                DEFAULT_WORLD_NAME,
                DEFAULT_WORLD_WIDTH,
                DEFAULT_WORLD_HEIGHT
        );
        gameManager = this;
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
        mainEntityManager.startRoutine();

        //Play theme song for the start of the game
	        //Create Variable for first song to be played.
	        GameSound Sound1 = new GameSound("src/main/resources/sounds/EmotionalRain.wav");
	        //Play first song
	        Sound1.start();
      
        
        
        
        
        // Start the manager of all the horrible threats in the world.
        threatManager = new ThreatManager();
        threatManager.setWorld(this.world);
        threatManager.setGameManager(this);
        threatManager.addOneThreat();

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
     * Pass the handle for the HUD Manager to Game Manager
     *
     * @param hudManager
     *          The HUD Manager of the game
     */
    public void setHudManager(HUDManager hudManager) {
        this.hudManager = hudManager;
    }

    /**
     * Retrieve the Manager for the game HUD
     *
     * @return the manager for the game HUD
     */
    public HUDManager getHudManager() {
        return hudManager;
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

    /**
     * Get the manager for the helper pane, which is the pane that tells the user
     * the basic things about the game
     *
     * @return the manager of the helper pane
     */
    public HelperManager getHelperManager() {
    	return helperManager;
    }

    /**
     * Give the primary manager a handle on the helper manager. This is needed
     * since helper manager will be instantiated via FXMLLoader
     *
     * @param helperManager
     *          The manager for the helper pane
     */
    public void setHelperManager(HelperManager helperManager) {
    	this.helperManager = helperManager;
    }
    
    public NotificationManager getNotificationManager() {
    	return notificationManager;
    }
    public void setNotificationManager(NotificationManager notificationManager) {
    	this.notificationManager = notificationManager;
    }


    /**
     * Retrieve the manager that manages the missions in the game
     * 
     * @return the manager of the missions in the game
     */
    public MissionManager getMissionManager() {
        return missionManager;
    }

    /**
     * Give the primary manager a handle on the mission manager. This is needed
     * since mission manager will be instantiated via FXMLLoader
     *
     * @param missionManager
     *          The manager for all missions in the game
     */
    public void setMissionManager(MissionManager missionManager) {
        this.missionManager = missionManager;
    }

    /**
     * Retrieve the manager for the tutorials pane
     *
     * @return the manager for the tutorials pane
     */
    public TutorialManager getTutorialManager() {
    	return tutorialManager;
    }

    /**
     * Give the primary manager a handle on the tutorial manager. This is needed
     * since tutorial manager will be instantiated via FXMLLoader
     *
     * @param tutorialManager
     *          The manager for the tutorial section of the game
     */
    public void setTutorialManager(TutorialManager tutorialManager) {
    	this.tutorialManager = tutorialManager;
    }

    /**
     * Retrieve the manager for the overall difficulty level of the game
     *
     * @return the manager for the game levels
     */
    public LevelManager getLevelManager() {
        return levelManager;
    }

    /**
     * Give the primary manager a handle on the level manager. This is needed
     * since level manager will be instantiated via FXMLLoader
     *
     * @param levelManager
     *          The manager for the game difficulty levels
     */
    public void setLevelManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    /**
     * Retrieve the manager for all game achievements that the player can get while
     * playing the game
     *
     * @return the manager for all game achievements
     */
    public AchievementManager getAchievementManager() {
        return achievementManager;
    }

    /**
     * Give the primary manager a handle on the achievement manager. This is needed
     * since Achievement Manager will be instantiated by {@link GameController}
     *
     * @param achievementManager
     */
    public void setAchievementManager(AchievementManager achievementManager){
    	this.achievementManager = achievementManager;
    }

    /**
     * Retrieve the manager that handles changing the cursor images during the game
     *
     * @return the manager that handles changing of cursor images
     */
    public CursorManager getCursorManager() {
        return cursorManager;
    }

    /**
     * Retrieve the that handles changing the cursor images during the game.
     *
     * Currently only used to test the cursor manager setup
     *
     * @param cursorManager
     *          The manager for the cursor images in the game
     */
    public void setCursorManager(CursorManager cursorManager) {
        this.cursorManager = cursorManager;
    }

    /**
     * Retrieve the manager that manages all entities in the game. This manager
     * will have information about all the sprites of each entity, and how to
     * retrieve them as well
     *
     * @return the manager that manages all entities in the game
     */
    public MainEntityManager getMainEntityManager() {
        return mainEntityManager;
    }

    /**
     * Give the reference of the main entity manager, that manages all entity in
     * the game to the primary manager.
     *
     * Currently, {@link MainEntityManager} is a singleton, so this method is not
     * really necessary, but it is still needed for testing as well as for the
     * future when {@link MainEntityManager} is moved to another implementation
     *
     * @param mainEntityManager
     *          The manager for all entities in the game
     */
    public void setMainEntityManager(MainEntityManager mainEntityManager) {
        this.mainEntityManager = mainEntityManager;
    }

    /**
     * Retrieve the manager for the game time. It will also have information
     * about the current game time, as well as have controls over it
     *
     * @return The manager for the game time
     */
    public TimeManager getTimeManager() {
        return timeManager;
    }

    /**
     * Give the primary manager a handle on the time manager. This is needed
     * since {@link TimeManager} will be instantiated by {@link GameController}
     *
     * @param timeManager
     *          The manager for the game time, who controls the time and also
     *          allows retrieval of the current game time
     */
    public void setTimeManager(TimeManager timeManager) {
        this.timeManager = timeManager;
    }

    /**
     * Retrieve the manager for all weather events in game.
     *
     * Currently not needed in the actual game code, but needed for testing
     *
     * @return the manager for the game weather
     */
    public WeatherManager getWeatherManager() {
    	return this.weatherManager;
    }

    /**
     * Give the primary manager a handle on the weather manager. This is needed
     * since {@link WeatherManager} will be instantiated by {@link GameController}
     *
     * @param weatherManager
     *          The manager for all weather events in-game
     */
    public void setWeatherManager(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    /**
     * Retrieve the manager for the information display of the peons when a peon
     * is clicked on. The manager will be in charge of updating that display
     * accordingly when a peon is clicked on
     *
     * @return the manager for the display of peon information
     */
    public PeonInformationDisplayManager getPeonInformationDisplayManager() {
        return peonInformationDisplayManager;
    }

    /**
     * Give the primary manager a handle on the {@link PeonInformationDisplayManager}.
     * This is needed since {@link PeonInformationDisplayManager} will be
     * instantiated by {@link GameController}
     *
     * @param peonInformationDisplayManager
     *          The manager for the display of individual peon information
     */
    public void setPeonInformationDisplayManager(PeonInformationDisplayManager peonInformationDisplayManager) {
        this.peonInformationDisplayManager = peonInformationDisplayManager;
    }
    
    public static GameManager getGameManager() {
    	return gameManager;
    }

    /**
     * Set up the event handlers for the root pane of the game. The current
     * events being handled:
     *      1. A menu sprite is clicked on -> update cursor image
     *      
     *      8. When an animal dies -> drop a resource sprite and load death sprite
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
        PeonClickedEventHandler peonClickedEventHandler =
                new PeonClickedEventHandler(this);

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
        // Handler for when a peon sprite is clicked
        root.addEventHandler(PeonClickedEvent.PEON_CLICKED_EVENT, peonClickedEventHandler);
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

}