package uq.deco2800.ducktales;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;

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
    private HUDManager hudManager;


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
        loadHUD();
        loadMarketPlace();
        loadTimeDisplay();

        // Now pass all handles for the secondary managers to the GameManager
        gameManager.setHudManager(this.hudManager);
        gameManager.setMarketManager(this.marketManager);

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
     * Hide all information windows
     */
    @FXML
    public void hideAllInfoWindows() {
        marketManager.hideMarketPlace();
        closeButton.setVisible(false);
    }

    /**
     * Load the HUD Information into the current panes
     * TODO: For HUD Team: you guys can change this later to make it the
     *       controller for the loaded FXML instead of just passing the HUD
     *       Manager a handle of leftPane and bottomPane. Sorry for dodgy-ness...
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
            rootPane.setTopAnchor(root, 0.0);
            rootPane.setRightAnchor(root, 30.0);

            // Initially hide it first
            marketManager.hideMarketPlace();

        } catch (IOException e) {
            System.err.println("Unable to load Marketplace");
            e.printStackTrace();
        }
    }
}
