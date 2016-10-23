package uq.deco2800.ducktales.features.hud.informationdisplay.peon;


import java.awt.Button;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.JobType;
import uq.deco2800.ducktales.rendering.info.WorldEntityInfo;
import uq.deco2800.ducktales.rendering.sprites.JobSprite;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;

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
    Button upgradeToolbutton;

	private static final ResourceType[] JOBS = {
        ResourceType.LUMBERJACK_LV1_1,  ResourceType.MINER_LV1_1,  ResourceType.BUILDER_LV1_1,
        ResourceType.DOCTOR_LV1_1,  ResourceType.FARMER_LV1_1,  ResourceType.TEACHER_LV1_1, 
        ResourceType.PEON,  ResourceType.BLACKSMITH_LV1_1,  ResourceType.STONE_MASON_LV1_1, 
        ResourceType.GYMCOACH_LV1_1,  ResourceType.PRIEST_LV1_1
	};
	
	private ArrayList<JobSprite> jobDisplaySprites;
	/** Helpers for rendering info*/
	private WorldEntityInfo worldEntityInfo;
	
	//in this case would we not need to bring the lumberjack instance from peonManager to here?
	//possibly addd getter bethods to peonManager for the instances? Put the call in jobSprite?
	//peons are stored in world
	
	

	
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

        setupJobMenu();
    }

    /**
     * Get the peon currently being displayed
     *
     * @return the peon model that is currently displayed
     */
    public Peon getCurrentlyDisplayedPeon() {
        return this.peon;
    }

    public void setPeon(Peon peon) {
    	this.peon = peon;

    }
    
    private void setupMenus() {
		this.jobDisplaySprites = new ArrayList<>();
		
		// Add the building sprites
		for (int i = 0; i < JOBS.length; i++) {
			JobSprite sprite = new JobSprite(JOBS[i]);

			if (!worldEntityInfo.containEntity(sprite.getSpriteType())) {
				// this building is not yet registered in the manager. not
				// rendered
				System.err.println(
						"jobDisplaySprites " + sprite.getSpriteType() + " is "
								+ "not yet registered in WorldEntityInfo");
				continue;
			}

			jobDisplaySprites.add(sprite);
		}

		// Set up the menus
		setupJobMenu();
	}
	private void setupJobMenu() {
		JobSprite lumberjackSprite = new JobSprite(ResourceType.LUMBERJACK_LV1_1);
		JobSprite minerSprite = new JobSprite(ResourceType.MINER_LV1_1);
		//JobSprite blackSmithSprite = new JobSprite(ResourceType.BLACKSMITH_LV1_1);
		JobSprite builderSprite = new JobSprite(ResourceType.BUILDER_LV1_1);
		JobSprite doctorSprite = new JobSprite(ResourceType.DOCTOR_LV1_1);
		JobSprite farmerSprite = new JobSprite(ResourceType.FARMER_LV1_1);
		//JobSprite gymcoachSprite = new JobSprite(ResourceType.GYMCOACH_LV1_1);
		JobSprite priestSprite = new JobSprite( ResourceType.PRIEST_LV1_1);
		ArrayList<JobSprite> jobsList = new ArrayList<JobSprite>(Arrays.asList(
				lumberjackSprite, minerSprite, builderSprite,
				doctorSprite, farmerSprite, priestSprite
			));

        VBox content = new VBox(10);

		for (JobSprite jobsprite : jobsList){
			jobsprite.setFitHeight(100); // set max height to 100px
    		jobsprite.setFitWidth(100); // Will set it to a square
			content.getChildren().add(jobsprite);
		}

		System.err.println("\n\n\n Job sprites should have been added \n\n\n");

        jobList.setContent(content);
			
	}
    /**
     * Set the peon to display
     * @param peon
     */
    public void displayPeon() {

        // Get the information of the peon
        //Image peonSpriteImage = rsr.getInstance().getResourceImage(this.peon.getType());
      //  peonImage.setImage(peonSpriteImage);
        
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
		int toolLevel = this.peon.getTool().getToolLevel();
    }
}



