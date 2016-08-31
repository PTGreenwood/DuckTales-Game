package uq.deco2800.ducktales.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameRendererBeta;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the controller for the actual game play, while DuckTalesController
 * controls the main menu and switches between different views
 *
 * Created  on 31/08/2016.
 * @author khoiphan21
 */
public class GameController implements Initializable{
    /**
     * UI Elements loaded from FXML
     */
    @FXML
    private Pane worldPane;
    @FXML
    private AnchorPane buttonsMenu;
    @FXML
    private HBox buildingsMenu;


    /**
     * This variable gives the controller a handle of the game renderer
     */
    private GameRendererBeta renderer;

    @FXML
    public void constructBuildings(ActionEvent event) {
        System.err.println("constructing buildings");
    }

    @FXML
    public void addPeon(ActionEvent actionEvent) {
    }

    /**
     * Store a handle of the given renderer, and also pass it the handles
     * of the UI elements loaded from FXML
     *
     * @param renderer
     *          The renderer of the game
     */
    public void setRenderer(GameRendererBeta renderer) {
        this.renderer = renderer;
        this.renderer.setUIElements(worldPane, buttonsMenu, buildingsMenu);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
