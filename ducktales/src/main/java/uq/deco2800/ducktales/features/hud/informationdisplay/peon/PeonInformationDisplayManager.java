package uq.deco2800.ducktales.features.hud.informationdisplay.peon;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.util.SecondaryManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the FXML controller for the peon information display
 *
 * Created on 16/10/2016.
 * @author khoiphan21
 */
public class PeonInformationDisplayManager
        extends SecondaryManager
        implements Initializable {
    /**
     * FXML Variables
     */
    // ROOT
    @FXML
    HBox rootDisplay;

    // IMAGE
    @FXML
    ImageView peonImage;

    // GENERAL INFORMATION PANEL
    @FXML
    Label peonName;
    @FXML
    Label peonIntelligence;
    @FXML
    Label peonStrength;
    @FXML
    Label peonHealth;

    // PEON STATUS PANEL
    @FXML
    Label peonHunger;
    @FXML
    Label peonThirst;

    // JOB PANEL
    @FXML
    ScrollPane jobList;
    @FXML
    Label peonJobStatus;
    @FXML
    Button assignJobButton;

    /** The peon to display */
    private Peon peon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Hide the display at first
        rootDisplay.setVisible(false);
    }

    /**
     * Set the peon to display
     * @param peon
     */
    public void displayPeon(Peon peon) {
        this.peon = peon;

        // Show the display
        rootDisplay.setVisible(true);
    }

    public void changePeonJob() {

    }

}
