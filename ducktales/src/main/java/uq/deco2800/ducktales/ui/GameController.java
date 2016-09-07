package uq.deco2800.ducktales.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

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
public class GameController {
    /** UI Elements loaded from FXML */
    @FXML
    private AnchorPane rootPane, leftPane, bottomPane, gamePane;
}
