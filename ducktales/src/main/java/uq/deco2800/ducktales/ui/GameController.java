package uq.deco2800.ducktales.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.GameRendererBeta;

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
    @FXML
    private BorderPane rootPane;
    @FXML
    private Pane worldPane;
    @FXML
    private AnchorPane buttonsMenu;
    @FXML
    private HBox buildingsMenu;

    /** The rendering engine of the game */
    private GameRendererBeta renderer;

    /** The manager of the game */
    private GameManagerBeta manager;

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

        // Officially start the game engine
        manager.startGame();
    }

    @FXML
    public void constructBuildings(ActionEvent event) {
        System.err.println("constructing buildings");
        renderer.showBuildingMenu();
    }

    @FXML
    public void addPeon(ActionEvent event) {
    }

}
