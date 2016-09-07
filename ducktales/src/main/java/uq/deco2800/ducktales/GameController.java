package uq.deco2800.ducktales;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.features.achievements.AchievementManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.level.LevelManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.features.missions.MissionManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private AnchorPane leftPane, bottomPane, worldPane;
    @FXML
    private Button closeButton;

    /** The Primary Manager of the game, that manages game GUI logic */
    private GameManager gameManager;

    /** The Secondary Managers of the game, each managing an FXML loader */
    private MarketManager marketManager;
    
    private MissionManager missionManager;
    private LevelManager levelManager;
    private AchievementManager achievementManager;
    
    private HUDManager hudManager;
    private WorldDisplayManager worldDisplayManager;


    /**
     * This method will be called when this controller is initialized by FXMLLoader
     * in DuckTalesController
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create the Game Manager, which will start the game model
        // Note: in the future, to load a game, just pass a World object to constructor
        gameManager = new GameManager(); // = new GameManager(loadedWorld) for later

        // Load each FXML element into the root pane on by one, and retrieve
        // their respective controllers
        loadWorldDisplay();
        loadHUD();
        loadMarketPlace();
        loadMissions();
        loadLevel();
        loadAchievement();
        loadTimeDisplay();
        
        // Now pass all handles for the secondary managers to the GameManager
        gameManager.setHudManager(this.hudManager);
        gameManager.setMarketManager(this.marketManager);
        gameManager.setWorldDisplayManager(this.worldDisplayManager);
        gameManager.setMissionManager(this.missionManager);
        gameManager.setLevelManager(this.levelManager);
        gameManager.setAchievementManager(this.achievementManager);

        // Set the temporary button to be invisible
        closeButton.toFront();
        closeButton.setVisible(false);




        // Game Controller's job of setting up the UI is done.
    }
    
    /**
     * Show the Market Place pane
     */
    @FXML
    public void showMarketPlace() {
        marketManager.showMarketPlace();
        closeButton.setVisible(true);
    }
    
    /**
     * Show the Mission pane
     */
    @FXML
    public void showMissions() {
        missionManager.showMission();
        closeButton.setVisible(true);
    }    
    
    /**
     * Show the Level pane
     */
    @FXML
    public void showLevel() {
    	levelManager.showLevel();
    	closeButton.setVisible(true);
    }
    
    /**
     * Show the achievement pane
     */
    @FXML
    public void showAchievement() {
    	achievementManager.showAchievement();
    	closeButton.setVisible(true);
    }
    
    /**
     * Hide all information windows
     */
    @FXML
    public void hideAllInfoWindows() {
        marketManager.hideMarketPlace();
        missionManager.hideMission();
        levelManager.hideLevel();
        achievementManager.hideAchievement();
        closeButton.setVisible(false);
    }

    /**
     * Load and show the game world
     */
    private void loadWorldDisplay() {
        // The typical thing.
        URL location = getClass().getResource("/worlddisplay/worldDisplay.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        try {
            Pane worldPane = loader.load();
            worldDisplayManager = loader.getController();

            // add the world pane to the root pane
            rootPane.getChildren().add(worldPane);

            // Set the sizing for world pane
            AnchorPane.setLeftAnchor(worldPane, 150.0);
            AnchorPane.setRightAnchor(worldPane, 0.0);
            AnchorPane.setTopAnchor(worldPane, 0.0);
            AnchorPane.setBottomAnchor(worldPane, 180.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load the HUD Information into the current panes
     */
    private void loadHUD() {
        hudManager = new HUDManager(this.rootPane, this.bottomPane);
    }

    /**
     * Load the display for time into the game
     */
    private void loadTimeDisplay() {

    }

    /**
     * Load the marketplace FXML into the game
     */
    private void loadMarketPlace() {
        URL location = getClass().getResource((MarketVistaNavigator.MAIN));

        FXMLLoader loader = new FXMLLoader(location);

        try {
            // load the FXML
            VBox root = loader.load();

            // Retrieve the controller;
            marketManager = loader.getController();

            // add the marketplace pane to the GUI
            rootPane.getChildren().add(root);

            // Position the marketplace pane
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 30.0);

            // Initially hide it first
            marketManager.hideMarketPlace();

        } catch (IOException e) {
            System.err.println("Unable to load Marketplace");
            e.printStackTrace();
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
            
            missionManager = loader.getController();

            rootPane.getChildren().add(root);

            rootPane.setTopAnchor(root, 0.0);
            rootPane.setRightAnchor(root, 30.0);

            missionManager.hideMission();

        } catch (IOException e) {
            System.err.println("Unable to load Missions");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void loadLevel() {

        URL location = getClass().getResource("/level/level.fxml");

        FXMLLoader loader = new FXMLLoader(location);
        

        try {
            // load the FXML
            AnchorPane root = loader.load();
            
            levelManager = loader.getController();
            levelManager.startLevel();
            
            rootPane.getChildren().add(root);

            rootPane.setTopAnchor(root, 0.0);
            rootPane.setLeftAnchor(root, 170.0);

            levelManager.hideLevel();

        } catch (IOException e) {
            System.err.println("Unable to load Level");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void loadAchievement() {

        URL location = getClass().getResource("/achievements/achievementMain.fxml");

        FXMLLoader loader = new FXMLLoader(location);
        

        try {
            // load the FXML
            AnchorPane root = loader.load();
            
            achievementManager = loader.getController();
            
            rootPane.getChildren().add(root);

            rootPane.setTopAnchor(root, 0.0);
            rootPane.setRightAnchor(root, 30.0);

            achievementManager.hideAchievement();

        } catch (IOException e) {
            System.err.println("Unable to load Achievement");
            e.printStackTrace();
        }
    }
      
}
