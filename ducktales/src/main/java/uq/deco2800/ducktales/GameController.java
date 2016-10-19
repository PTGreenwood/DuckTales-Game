package uq.deco2800.ducktales;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.features.achievements.AchievementManager;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.helper.HelperManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.features.level.LevelManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.tutorials.TutorialManager;
import uq.deco2800.ducktales.features.weather.*;

import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.features.missions.MissionManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * <p>
 *     This is the master controller for the actual game play, while
 *     DuckTalesController controls the main menu and switches between
 *     different views.
 * </p>
 * <p>
 *     GameController is responsible for <b>setting up</b> the game by loading FXML
 *     files and retrieving their controllers in order to pass them to OldGameManager.
 *     It is not responsible for any game logic
 * </p>
 * <p>
 *     This controller is instantiated by FXMLLoader, and retrieved in
 *     DuckTalesController
 * </p>
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class GameController implements Initializable{
    /** The main pane where everything is loaded into */
    @FXML
    private AnchorPane rootPane;
    
    /** The main UI elements */
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane bottomPane;
    @FXML
    private AnchorPane worldPane;
    
    @FXML
    private Button closeButton;

    /** The Primary Manager of the game, that manages game GUI logic */
    private GameManager gameManager;
    
    /** implementing a logger, to catch ioe exception */
    private static Logger logger = LoggerFactory.getLogger(GameController.class);
    
    /** The Secondary Managers of the game, each managing an FXML loader */
    private MarketManager marketManager;
    
    private HelperManager helperManager;
    private MissionManager missionManager;
    private LevelManager levelManager;
    private AchievementManager achievementManager;
    private TutorialManager tutorialManager;
    
    private HUDManager hudManager;
    private WorldDisplayManager worldDisplayManager;
    private WeatherManager weatherManager;
    private PeonInformationDisplayManager peonInformationDisplayManager;

    private MainEntityManager mainEntityManager;

    private TimeManager timeManager;


    /**
     * This method will be called when this controller is initialized by FXMLLoader
     * in DuckTalesController
     *
     * @param location
     *          The location of this FXML
     * @param resources
     *          The resources passed to FXML
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create the Game Manager, which will start the game model
        // Note: in the future, to load a game, just pass a World object to constructor
        gameManager = new GameManager(this.rootPane); // = new GameManager(loadedWorld) for later

        // Load each FXML element into the root pane on by one, and retrieve
        // their respective controllers        

        loadWorldDisplay();
        
        loadHUD();
        loadPeonInformationDisplay();
        
        loadMarketPlace();
        loadMissions();
        loadTutorial();
        loadLevel();
        loadAchievement();        
        loadHelper();
        
        loadTimeDisplay();
        loadWeatherDisplay();
        
        loadDayNightDisplay(); // This must be after loading TimeDisplay

        loadEntities(); // Note: this 'loader method' should be called LAST


        // Now pass all handles for the secondary managers to the GameManager
        gameManager.setHudManager(this.hudManager);
        gameManager.setMarketManager(this.marketManager);
        gameManager.setWorldDisplayManager(this.worldDisplayManager);
        gameManager.setMissionManager(this.missionManager);
        gameManager.setLevelManager(this.levelManager);
        gameManager.setAchievementManager(this.achievementManager);
        gameManager.setMainEntityManager(this.mainEntityManager);
        gameManager.setTutorialManager(this.tutorialManager);      
        gameManager.setHelperManager(this.helperManager);
        gameManager.setPeonInformationDisplayManager(this.peonInformationDisplayManager);

        // Now officially call the game starting method from Game Manager
        gameManager.startGame();        
        // Game Controller's job of setting up the UI is done.
    }


    /**
     * Show the Market Place pane
     */
    @FXML
    public void showMarketPlace() {
        // Hide all other panes first
        hideAllInfoWindows();

        marketManager.showMarketPlace();
        closeButton.setVisible(true);
        
        missionManager.missionCompletedAction(2);
    }
    
    /**
     * Show the Mission pane
     */
    @FXML
    public void showMissions() {
        // Hide all other panes first
        hideAllInfoWindows();

        missionManager.showMission();
        closeButton.setVisible(true);
    }    
    
    /**
     * Show the Level pane
     */
    @FXML
    public void showLevel() {
        // Hide all other panes first
        hideAllInfoWindows();

    	levelManager.showLevel();
    	closeButton.setVisible(true);
    	missionManager.missionCompletedAction(0);
    }
    
    /**
     * Show the achievement pane
     */
    @FXML
    public void showAchievement() {
        // Hide all other panes first
        hideAllInfoWindows();

    	achievementManager.showAchievement();
    	closeButton.setVisible(true);
    	missionManager.missionCompletedAction(1);
    }
    
    @FXML
    public void showTutorial() {
    	
    	hideAllInfoWindows();
    	
    	tutorialManager.showTutorial();
    	closeButton.setVisible(true);
    	missionManager.missionCompletedAction(0);
    }
    
    /**
     * Hide all information windows
     */
    @FXML
    public void hideAllInfoWindows() {
        marketManager.hideMarketPlace();
        missionManager.hideMission();
        achievementManager.hideAchievement();
        tutorialManager.hideTutorial();
        closeButton.setVisible(false);
    }

    /**
     * Load the information display for peons.
     *
     * Initially this will be hidden - it will only be shown when a peon
     * is clicked on
     */
    private void loadPeonInformationDisplay() {
        URL location = getClass().getResource("/ui/peondisplay/peonDisplay.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        try {
            Pane peonInformationDisplay = loader.load();
            this.peonInformationDisplayManager = loader.getController();

            this.peonInformationDisplayManager.setGameManager(this.gameManager);

            // Add the peon information display to the root pane
            rootPane.getChildren().add(peonInformationDisplay);

            // Set up the sizing for the root pane
            AnchorPane.setBottomAnchor(peonInformationDisplay, 20.0);
            AnchorPane.setLeftAnchor(peonInformationDisplay, 200.0);
            AnchorPane.setRightAnchor(peonInformationDisplay, 200.0);
        } catch (IOException e) {
            logger.info("Cannot load Peon Information Display", e);
            throw new GameSetupException("Cannot load Peon Information Display");
        }
    }

    /**
     * Load and show the game world
     */
    private void loadWorldDisplay() {
        // The typical thing.
        URL location = getClass().getResource("/worlddisplay/worldDisplay.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        try {
            Pane worldDisplayPane = loader.load();
            this.worldDisplayManager = loader.getController();

            worldDisplayManager.setGameManager(this.gameManager);
            
            // add the world pane to the root pane
            
            rootPane.getChildren().add(worldDisplayPane);
            // Set the sizing for world pane
            AnchorPane.setLeftAnchor(worldDisplayPane, 0.0);
            AnchorPane.setRightAnchor(worldDisplayPane, 0.0);
            AnchorPane.setTopAnchor(worldDisplayPane, 0.0);
            AnchorPane.setBottomAnchor(worldDisplayPane, 0.0);
        } catch (IOException e) {
            logger.info("Cannot load World Display", e);

            throw new GameSetupException("Cannot load World Display");
        }
    }
    
    /**
     * Overlay another pane, below other panes for day/night effect
     */
   public void loadDayNightDisplay() {
	   URL location = getClass().getResource("/time/daynightEffect.fxml");
	   FXMLLoader loader = new FXMLLoader(location);
	   
	   try {
		   Pane daynightPane = loader.load();
		   
		   // add dayNight pane to the root pane
		   rootPane.getChildren().add(daynightPane);

           this.worldDisplayManager.changeLightLevel(daynightPane);

           // Set the sizing for world pane
		   AnchorPane.setLeftAnchor(daynightPane,  0.0);
		   AnchorPane.setRightAnchor(daynightPane, 0.0);
		   AnchorPane.setTopAnchor(daynightPane, 0.0);
		   AnchorPane.setBottomAnchor(daynightPane, 0.0);
	   } catch (IOException e) {
		   logger.info("unable to set day/night effect", e);

           throw new GameSetupException("unable to set day/night effect");
	   }
   }
    /**
     * @mattyleggy
     * Overlay the weather pane on top of the main game pane.
     */
    private void loadWeatherDisplay() {
    	URL location = getClass().getResource("/weather/weatherDisplay.fxml");

        FXMLLoader loader = new FXMLLoader(location);

        try {
            // load the FXML
            Pane weatherDisplay = loader.load();

            // Retrieve the controller
            weatherManager = loader.getController();
            weatherManager.setTimeManager(this.timeManager);
            
            gameManager.setWeatherManager(this.weatherManager);

            // Add the time display to the GUI
            weatherDisplay.setOpacity(0.5);
            weatherDisplay.setMouseTransparent(true);            
            rootPane.getChildren().add(weatherDisplay);
            
            
            

            // Position the time display
            AnchorPane.setLeftAnchor(weatherDisplay, 0.0);
            AnchorPane.setRightAnchor(weatherDisplay, 0.0);
            AnchorPane.setTopAnchor(weatherDisplay, 0.0);
            AnchorPane.setBottomAnchor(weatherDisplay, 0.0);
            
            /*
            int canvasHeight = 737;
            int canvasWidth = 1295;   
            
            
            Canvas mainCanvas = new Canvas(canvasWidth,canvasHeight);            
            AnchorPane.setLeftAnchor(mainCanvas, 0.0);
            AnchorPane.setRightAnchor(mainCanvas, 0.0);
            AnchorPane.setTopAnchor(mainCanvas, 0.0);
            AnchorPane.setBottomAnchor(mainCanvas, 0.0);
            GraphicsContext ctx = mainCanvas.getGraphicsContext2D();
            //weatherManager.tick();
            Platform.runLater(() -> {            
	    		for (int i=0; i < 1000; i++) {		
	    			int randX = (int)Math.ceil(Math.random() * canvasWidth); 		
	    			int randY = (int)Math.ceil(Math.random() * canvasHeight);		
	    			int randD = (int)Math.floor(Math.random() * 7) - 3; //random direction between -3 && 3				
	    			int randA = (int)(Math.random() * 5) + 10; //random acceleration
	    			ctx.beginPath();            
	                ctx.setFill(Color.GREEN);
	                ctx.setStroke(Color.BLUE);
	                ctx.arc(randX,randY,20,20,2*Math.PI,1);            
	        		ctx.stroke();
	        		ctx.fill();		
	        		ctx.setLineWidth(2);
	        		ctx.stroke();    
	        		//ctx.clearRect(0, 0, canvasWidth, canvasHeight);
	    		}    		
            });
            */
            

        } catch (IOException e) {
            logger.info("Unable to load weather display:" + e);

            throw new GameSetupException("unable to load weather display");
        }
    	
        /*
        URL location = getClass().getResource("/weather/weatherEffects.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        try {
            Pane weatherPane = loader.load();     

            weatherManager = loader.getController();
            //gameManager.setWeatherManager(this.weatherManager);
            
            // add the weather pane to the root pane
            //rootPane.getChildren().add(weatherPane);           
            weatherPane.setOpacity(0.7);
            this.worldDisplayManager.changeWeather(new Rain(), weatherPane);
            // Set the sizing for world pane
            AnchorPane.setLeftAnchor(weatherPane, 0.0);
            AnchorPane.setRightAnchor(weatherPane, 0.0);
            AnchorPane.setTopAnchor(weatherPane, 0.0);
            AnchorPane.setBottomAnchor(weatherPane, 0.0);
            
            
            
            
            
            
        } catch (IOException e) {
            System.err.println("unable to load weather effects");
        }
        */
    }

    
    /**
     * Load the HUD Information into the current panes
     */
    private void loadHUD() {
        hudManager = new HUDManager(this.rootPane, this.leftPane, this.bottomPane);

        // Set the temporary button to be invisible
        closeButton.toFront();
        closeButton.setVisible(false);
    }

    /**
     * Initializes the entity manager and setting it up
     */
    private void loadEntities() {
        mainEntityManager = MainEntityManager.getInstance();
        mainEntityManager.setGameManager(gameManager);
        mainEntityManager.setWorld(gameManager.getWorld());
    }

    /**
     * Load the display for time into the game
     */
    private void loadTimeDisplay() {
        URL location = getClass().getResource("/time/timeDisplay.fxml");

        FXMLLoader loader = new FXMLLoader(location);

        try {
            // load the FXML
            AnchorPane timeDisplay = loader.load();

            // Retrieve the controller
            timeManager = loader.getController();

            gameManager.setTimeManager(this.timeManager);

            // Add the time display to the GUI
            leftPane.getChildren().add(timeDisplay);

            // Position the time display
            AnchorPane.setTopAnchor(timeDisplay, 20.0);
            AnchorPane.setLeftAnchor(timeDisplay, 20.0);

        } catch (IOException e) {
            logger.info("Unable to load time display:" + e);

            throw new GameSetupException("unable to load time display");
        }

    }
    
    /**
     * Load the tutorial FXML into the game
     */
    @FXML
    private void loadTutorial() {

        URL location = getClass().getResource("/tutorial.fxml");

        FXMLLoader loader = new FXMLLoader(location);

        try {
            // load the FXML
            AnchorPane root = loader.load();
            
            // retrieve the controller
            tutorialManager = loader.getController();

            // add the mission pane to the GUI
            rootPane.getChildren().add(root);
            
            // position the mission pane
            AnchorPane.setTopAnchor(root, 30.0);
            AnchorPane.setLeftAnchor(root, 250.0);
            
            
            tutorialManager.hideButtons();
            // initially hide it first
            tutorialManager.hideTutorial();
            

        } catch (IOException e) {
            logger.info("Unable to load Tutorial:" + e);

            throw new GameSetupException("Unable to load Tutorial");
        }
    }

    /**
     * Load the marketplace FXML into the game
     */
    private void loadMarketPlace() {
        URL location = getClass().getResource(MarketVistaNavigator.MAIN);

        FXMLLoader loader = new FXMLLoader(location);

        try {
            // load the FXML
            VBox root = loader.load();

            // Retrieve the controller
            marketManager = loader.getController();

            // add the marketplace pane to the GUI
            rootPane.getChildren().add(root);

            // Position the marketplace pane
            AnchorPane.setTopAnchor(root, 175.0);
            AnchorPane.setLeftAnchor(root, 30.0);

            // Initially hide it first
            marketManager.hideMarketPlace();

        } catch (IOException e) {
            logger.info("Unable to load Marketplace:" + e);

            throw new GameSetupException("Unable to load Marketplace");
        }
    }
    
    /**
     * Load the missions FXML into the game
     */
    @FXML
    private void loadMissions() {

        URL location = getClass().getResource("/missions/missionAndAchievement.fxml");

        FXMLLoader loader = new FXMLLoader(location);

        try {
            // load the FXML
            AnchorPane root = loader.load();
            
            // retrieve the controller
            missionManager = loader.getController();

            // add the mission pane to the GUI
            rootPane.getChildren().add(root);
            
            // position the mission pane
            AnchorPane.setTopAnchor(root, 30.0);
            AnchorPane.setLeftAnchor(root, 450.0);
            
            // initially hide it first
            missionManager.hideMission();

        } catch (IOException e) {
            logger.info("Unable to load Missions:" + e);

            throw new GameSetupException("Unable to load Missions");
        }
    }
    
    @FXML
    private void loadLevel() {

        URL location = getClass().getResource("/level/level.fxml");

        FXMLLoader loader = new FXMLLoader(location);
        

        try {
            // load the FXML
            AnchorPane root = loader.load();
            
            // retrieve the controller
            levelManager = loader.getController();
            
            levelManager.startLevel();
            
            // add the level pane to the GUI
            rootPane.getChildren().add(root);
            
            // position the level pane
            AnchorPane.setTopAnchor(root, 70.0);
            AnchorPane.setLeftAnchor(root, 20.0);            

        } catch (IOException e) {
            logger.info("Unable to load level:" + e);

            throw new GameSetupException("Unable to load Level");
        }
    }
    
    @FXML
    private void loadHelper() {
    	
    	URL location = getClass().getResource("/helper/helper.fxml");
    	
    	FXMLLoader loader = new FXMLLoader(location);
    	
    	try {
            // load the FXML
            AnchorPane root = loader.load();
            
            // retrieve the controller
            helperManager = loader.getController();
            
            // add the level pane to the GUI
            rootPane.getChildren().add(root);
            
            // position the level pane
            AnchorPane.setTopAnchor(root, 580.0);
            AnchorPane.setLeftAnchor(root, 350.0);            

            helperManager.hideHelper();
            
        } catch (IOException e) {
            logger.info("Unable to load Helper:" + e);

            throw new GameSetupException("Unable to load Helper");
        }
    }
    
    @FXML
    private void loadAchievement() {

        URL location = getClass().getResource("/achievements/achievementMain.fxml");

        FXMLLoader loader = new FXMLLoader(location);
        

        try {
            // load the FXML
            AnchorPane root = loader.load();
            
            // retrieve the controller
            achievementManager = loader.getController();
            
            // add the achievement pane to the GUI
            rootPane.getChildren().add(root);
            
            // position the achievement pane
            AnchorPane.setTopAnchor(root, 30.0);
            AnchorPane.setLeftAnchor(root, 450.0);
            
            // initially hide it first
            achievementManager.hideAchievement();

        } catch (IOException e) {
            logger.info("Unable to load Achievment:" + e);;

            throw new GameSetupException("Unable to load Achievement");
        }
    }
    

      
}
