package uq.deco2800.ducktales.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.GameRendererBeta;
import uq.deco2800.ducktales.achievements.Achievements;
import uq.deco2800.ducktales.achievements.progressIndicator;
import uq.deco2800.ducktales.level.Level;
import uq.deco2800.ducktales.missions.Missions;
import uq.deco2800.ducktales.resources.InventoryManager;

import java.net.URL;

/**
 * This is the master controller for the actual game play, while
 * DuckTalesController controls the main menu and switches between
 * different views.
 *
 * This class will be the first class to have the handles of the UI elements
 * created by FXML. This class will then need to pass the handles along to
 * the renderer.
 *
 * Created  on 31/08/2016.
 * @author khoiphan21
 */
public class GameController{
    /**
     * UI Elements loaded from FXML
     */
    // the mane panes
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Pane worldPane;
    @FXML
    private AnchorPane buttonsMenu;
    @FXML
    private HBox buildingsMenu;
    // The Inventory menu
    @FXML
    private ImageView woodSprite, foodSprite, oresSprite;
    @FXML
    private Label woodLabel, foodLabel, oresLabel;
    // The button to close all info panes
    @FXML
    private Button closeInfoPaneButton;
    // The Achievement window
    private AnchorPane achievementPane;
    // The Marketplace window
    private VBox marketplacePane;

    /** The rendering engine of the game */
    private GameRendererBeta renderer;

    /** The manager of the game */
    private GameManagerBeta manager;

    /** The Inventory manager */
    private InventoryManager inventoryManager;

    /**
     * This method sets up the GameManager, GameRenderer and other
     * global game control classes
     */
    public void setupGame() {
        // Initialize the renderer and pass it the UI elements
        renderer = new GameRendererBeta(rootPane, worldPane, buttonsMenu, buildingsMenu);
        // Initialize the manager
        manager = new GameManagerBeta();

        // Let manager and renderer know about each other and the world
        manager.setRenderer(renderer);
        renderer.setManager(manager);

        // Setup the inventory display
        inventoryManager = new InventoryManager(
                woodSprite, foodSprite, oresSprite,
                woodLabel, foodLabel, oresLabel
        );
        manager.setInventoryManager(inventoryManager);


        // Officially start the game engine
        try {
            manager.startGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void constructBuildings(ActionEvent event) {
        System.err.println("constructing buildings");
        renderer.showBuildingMenu();
    }

    @FXML
    public void showMissionAndAchievement(ActionEvent event) throws Exception {
        URL location = getClass().getResource("/missionAndAchievement.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        achievementPane = loader.load();

        showInfoPane(achievementPane);
    }

    @FXML
    public void showMarketplace(ActionEvent event) throws Exception {    	
        URL location = getClass().getResource("/marketplace.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        marketplacePane = loader.load();

        showInfoPane(marketplacePane);
        
        missionCompletedAction(3);
    }

    @FXML
    public void addPeon(ActionEvent event) {
    	
    	missionCompletedAction(2);
    }

    @FXML
    public void closeInfoPane() {
        rootPane.getChildren().removeAll(this.achievementPane, this.marketplacePane);
        closeInfoPaneButton.setVisible(false);
    }

    /**
     * Show the given info pane - must remove all other info panes first
     *
     * @param pane
     *          The pane to be shown in the in-game screen
     */
    private void showInfoPane(Pane pane) {
        // All info panes must have been removed at this point

        // Add the given pane
        rootPane.getChildren().add(pane);

        // The anchors for the window
        double sideAnchor = rootPane.getWidth() / 4;
        double verticalAnchor = rootPane.getHeight() / 4;

        // Set the location of the given pane to be rendered at
        rootPane.setLeftAnchor(pane, sideAnchor);
        rootPane.setRightAnchor(pane, sideAnchor);
        rootPane.setBottomAnchor(pane, verticalAnchor);

        closeInfoPaneButton.setVisible(true);

        // Re-layout the closing button
        rootPane.setLeftAnchor(closeInfoPaneButton, sideAnchor);
        rootPane.setRightAnchor(closeInfoPaneButton, sideAnchor);
        rootPane.setBottomAnchor(closeInfoPaneButton, verticalAnchor - 30);

    }
    
    private void missionCompletedAction(int i){
    	
    	//Untick mission2 box in Achievement window of Gamebeta when marketplace is clicked
        Missions.getInstance().MissionImageCompleted(i);
        //Increment percentage of progress indicator in achievement
        progressIndicator.getInstance().setProgressPercentage(Missions.getInstance().getMissionCount());
        //Increment total achievement score
        Achievements.getInstance().achieveEasy();
        //Increment percentage of progress bar in leveling system
        Level.getInstance().setProgressBar(0.5);
        //if progress bar is full then level up
        if(Level.getInstance().getBarProgress() == 1.0){
        	Level.getInstance().LevelUp();
        }
    }

}
