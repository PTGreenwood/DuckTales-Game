package uq.deco2800.ducktales;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.renderingEngine.WorldEntityRenderingInfo;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameRendererBeta extends AnimationTimer{

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
    private VBox buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation

    // The constants to layout the HUD elements
    private double GAME_PANE_V_PORTION = 85.0/100.0;
    private double GAME_PANE_H_PORTION = 85.0/100.0;
    private double BUTTONS_MENU_H_PORTION = 1.0 - GAME_PANE_H_PORTION;
    private double BUTTONS_MENU_V_PORTION = GAME_PANE_V_PORTION;
    private double BUILDINGS_MENU_H_PORTION = 1.0;
    private double BUILDINGS_MENU_V_PORTION = 1.0 - GAME_PANE_V_PORTION;

    /** The Scale/Zoom factor */
    private double SCALE = 0.2;

    /**
     * The class containing the info to render different types of entities
     */
    WorldEntityRenderingInfo renderingInfo;



    /**
     * Constructor class for the GameRendererBeta
     * @param gamePane
     *          The root pane where everything will be added and rendered
     */
    public GameRendererBeta(Pane root, BorderPane gamePane) {
        super();

        // Setup the HUD elements
        this.gamePane = gamePane;
        this.root = root;

        System.err.println("root width and height is: " +
                root.getWidth() + ", " + root.getHeight());

        setupHUD();
    }

    /**
     * Setup the HUD for the game
     */
    private void setupHUD() {
        double renderingWidth = this.root.getWidth();
        double renderingHeight = this.root.getHeight();

        // Add styling to the root pane
        root.getStylesheets().add("/ducktales.css");

        // The pane where the world is rendered onto
        worldPane = new Pane();
        worldPane.setMaxSize(
                renderingWidth * GAME_PANE_H_PORTION,
                renderingHeight * GAME_PANE_V_PORTION
        );
        worldPane.getStyleClass().add("worldPane");

        // The pane containing the buttons to add new peons and stuff
        buttonsMenu = new VBox();
        buttonsMenu.setPrefSize(
                renderingWidth * BUTTONS_MENU_H_PORTION,
                renderingHeight * BUTTONS_MENU_V_PORTION
        );
        buttonsMenu.getStyleClass().add("buttonsMenu");
        buttonsMenu.setPadding(new Insets(25));
        buttonsMenu.setSpacing(20);

        // The pane containing the buildings
        buildingsMenu = new HBox();
        buildingsMenu.setPrefSize(
                renderingWidth * BUILDINGS_MENU_H_PORTION,
                renderingHeight * BUILDINGS_MENU_V_PORTION
        );
        buildingsMenu.getStyleClass().add("buildingsMenu");

        // Add the child panes into the main pane
        this.gamePane.setCenter(worldPane);
        this.gamePane.setLeft(buttonsMenu);
        this.gamePane.setBottom(buildingsMenu);
    }

    @Override
    public void handle(long now) {

    }
}
