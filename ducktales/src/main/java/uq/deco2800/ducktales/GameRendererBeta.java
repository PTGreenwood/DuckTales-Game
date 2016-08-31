package uq.deco2800.ducktales;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.renderingEngine.WorldEntityRenderingInfo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameRendererBeta extends AnimationTimer {

    /**
     * The Root pane
     */
    private Pane root;

    /**
     * The game pane where all HUD elements, and world pane will be added to
     */
    private BorderPane gamePane;

    /** HUD variables */
    private Pane worldPane;
    private AnchorPane buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation

    /** The Scale/Zoom factor */
    private double SCALE = 0.2;

    /**
     * The class containing the info to render different types of entities
     */
    WorldEntityRenderingInfo renderingInfo;


    public GameRendererBeta() {

    }

    /**
     * Constructor class for the GameRendererBeta
     * @param gamePane
     *          The root pane where everything will be added and rendered
     */
    public GameRendererBeta(Pane root, BorderPane gamePane) {
        super();

        worldPane.setVisible(false);

        // Setup the HUD elements
        this.gamePane = gamePane;
        this.root = root;

    }

    public void setUIElements(Pane worldPane, AnchorPane buttonsMenu, HBox buildingsMenu) {
        this.worldPane = worldPane;
        this.buttonsMenu = buttonsMenu;
        this.buildingsMenu = buildingsMenu;
    }

    @Override
    public void handle(long now) {

    }

    @Override
    public void start() {
        super.start();
//        worldPane.setVisible(false);
    }

}
