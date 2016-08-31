package uq.deco2800.ducktales.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.GameRendererBeta;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameController implements Initializable{
    /**
     * UI Elements loaded from FXML
     */
    @FXML
    Pane worldPane;
    @FXML
    VBox buttonsMenu;
    @FXML
    HBox buildingsMenu;


    /**
     * This variable gives the controller a handle of the game renderer
     */
    private GameRendererBeta renderer;

    public void setRenderer(GameRendererBeta renderer) {
        this.renderer = renderer;
        this.renderer.setUIElements(worldPane, buttonsMenu, buildingsMenu);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
