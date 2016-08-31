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
     * The root pane where all HUD elements, and world pane will be added to
     */
    BorderPane root;

    /** HUD variables */
    private Pane worldPane;
    private VBox buttonsMenu; // This is only for testing - HUD team pls change
    private HBox buildingsMenu; // Again, only basic implementation

    // The constants to layout the HUD elements
    private double GAME_PANE_V_PORTION = 85.0/100.0;
    private double GAME_PANE_H_PORTION = 60.0/100.0;
    private double TILE_MENU_H_PORTION = 100.0 - GAME_PANE_V_PORTION;
    private double TILE_MENU_V_PORTION = GAME_PANE_H_PORTION;
    private double RESOURCE_MENU_H_PORTION = 1.0;
    private double RESOURCE_MENU_V_PORTION = 100.0 - GAME_PANE_H_PORTION;

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
    public GameRendererBeta(BorderPane gamePane) {
        super();

        // Setup the HUD elements
        this.root = gamePane;
        setupHUD();
    }

    /**
     * Setup the HUD for the game
     */
    private void setupHUD() {
        double renderingWidth = root.getWidth();
        double renderingHeight = root.getHeight();

        // Add styling to the root pane
        root.getStylesheets().add("/ducktales.css");

        // The pane where the world is rendered onto
        worldPane = new Pane();
        worldPane.setPrefSize(
                renderingWidth * GAME_PANE_V_PORTION,
                renderingHeight * GAME_PANE_H_PORTION
        );
        worldPane.getStyleClass().add("worldPane");

        // The pane containing the tiles
        buttonsMenu = new VBox();
        buttonsMenu.setPrefSize(
                renderingWidth * TILE_MENU_H_PORTION,
                renderingHeight * TILE_MENU_V_PORTION
        );
        buttonsMenu.getStyleClass().add("buttonsMenu");
        buttonsMenu.setPadding(new Insets(25));
        buttonsMenu.setSpacing(20);

        // The pane containing the resources
        buildingsMenu = new HBox();
        buildingsMenu.setPrefWidth(renderingWidth * RESOURCE_MENU_H_PORTION);
        buildingsMenu.setMaxHeight(renderingHeight * RESOURCE_MENU_V_PORTION);
        buildingsMenu.getStyleClass().add("buildingsMenu");

        // Add the child panes into the main pane
        this.root.setCenter(worldPane);
        this.root.setLeft(buttonsMenu);
        this.root.setBottom(buildingsMenu);


    }

    @Override
    public void handle(long now) {

    }
}
