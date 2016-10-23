package uq.deco2800.ducktales.features.hud.informationdisplay.peon;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.JobType;
import uq.deco2800.ducktales.features.peonupgrades.ToolType;
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
    @FXML
    Label peonUpgradeTool;
    @FXML
    Label currentToolLevel;
    @FXML
    Label resourceCost;
    @FXML
    Button upgradeToolsButton;

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

    public void setPeon(Peon peon) {
    	this.peon = peon;
    	//Setting peons with jobs/tools for testing here.
    	//peon.setJob(JobType.LUMBERJACK);
         //Setting to axe level 1 to start with.
        //peon.setTool(ToolType.AXElevel1);
    }
    
    /**
     * Set the peon to display
     * @param peon
     */
    public void displayPeon() {

       
        // Get the information of the peon
        peonName.setText(peon.getPeonName());
        peonIntelligence.setText(Integer.toString(peon.getIntelligence()));
        peonStrength.setText(Integer.toString(peon.getStrength()));
        peonHealth.setText(Integer.toString(peon.getHealth()));
        peonHunger.setText(Integer.toString(peon.getHunger()));
        peonThirst.setText(Integer.toString(peon.getThirst()));

        currentToolLevel.setText(peon.getTool().getName());
        resourceCost.setText(peon.getResourceNeededForUpgrade(
        		peon.getJobToolList(peon.getJob()), peon.getTool().getNextToolLevel()));

        rootDisplay.setVisible(true);
    }
    
    @FXML public void handleUpgradeToolButtonAction() {
    	this.peon.upgradeTool();
    	displayPeon();
    	

    	//Still to do.
    	//If on level 3 upgrade.
    	//Set style for button to be grayed out and unclickable.
    	
    }
}
