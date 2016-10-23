package uq.deco2800.ducktales.features.hud.informationdisplay.peon;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.JobType;
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
    Button upgradeToolsButton;

    // JOB PANEL
    @FXML
    ListView jobList;
    @FXML
    Label peonJobStatus;
    @FXML
    Button assignJobButton;
    @FXML
    Button lumberjackButton;
    @FXML
    Button minerButton;
    @FXML
    Button builderButton;
    @FXML
    Button doctorButton;
    @FXML
    Button farmerButton;
    @FXML
    Button teacherButton;
    @FXML
    Button blackSmithButton;
    @FXML
    Button masonButton;
    @FXML
    Button gymCoachButton;
    @FXML
    Button joblessButton;

    /** The peon to display */
    private Peon peon;
    private ResourceSpriteRegister rsr;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Hide the display at first

        rootDisplay.setVisible(false);
        
    }

    public void setPeon(Peon peon) {
    	this.peon = peon;
    	//Setting peons with jobs/tools for testing here.
    	//
         //Setting to axe level 1 to start with.
        //peon.setTool(ToolType.AXElevel1);
    	//this.peon.setJob(JobType.LUMBERJACK);
		//this.peon.setJob(JobType.BLACKSMITH);
		//this.peon.setJob(JobType.MINER);
		//this.peon.setJob(JobType.BUILDER);
		//this.peon.setJob(JobType.DOCTOR);
		//this.peon.setJob(JobType.FARMER);
    	//this.peon.setJob(JobType.GYMCOACH);
		//this.peon.setJob(JobType.MASON);
		//this.peon.setJob(JobType.TEACHER);
    	this.peon.setJob(JobType.JOBLESS);
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
    
    /**
     * Method that updates the Instance of the Peon to be the correct sprite
     * according to job and tool type.
     */
    public void updatePeonSprite(ResourceType newType) {
    	if(!(this.peon.getType() == newType)) {
    		this.peon.updateType(newType);
    	}
    	

        Image peonSpriteImage = rsr.getInstance().getResourceImage(newType);
        peonImage.setImage(peonSpriteImage);
    	gameManager.getMainEntityManager().getPeonManager().getPeonSprite(this.peon.getPeonName()).setImage(peonSpriteImage);
    }
    
    @FXML public void setLumberJack() {
    	
    }
    
    @FXML public void setMiner() {
    	
    }    
    
    @FXML public void setBuilder() {
    	
    }
    
    @FXML public void setDoctor() {
    	
    }
    
    @FXML public void setFarmer() {
    	
    }    
    
    @FXML public void setTeacher() {
    	
    }
    
    @FXML public void setBlackSmith() {
    	
    }
    
    @FXML public void setMason() {
    	
    }
    
    @FXML public void setGymCoach() {
    	
    }
    
    @FXML public void setJobless() {
    	
    }
    
    @FXML public void handleUpgradeToolButtonAction() {
    	this.peon.upgradeTool();
    	displayPeon();
		int toolLevel = this.peon.getTool().getToolLevel();
    	switch(this.peon.getJob()) {
    		case LUMBERJACK:

    				if(toolLevel == 1) {
    					updatePeonSprite(ResourceType.LUMBERJACK);
    				} else {
    					updatePeonSprite(ResourceType.LUMBERJACK);
    				}
    				break;
    		
    		/*case BAKER:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.BAKER);
					} else {
						updatePeonSprite(ResourceType.LUMBERJACK);
					}
					break;
			*/
    		case BLACKSMITH:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.BLACKSMITH);
					} else {
						updatePeonSprite(ResourceType.BLACKSMITH);
					}
					break;
					
    		case BUILDER:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.BUILDER);
					} else {
						updatePeonSprite(ResourceType.BUILDER);
					}

					break;
    		case DOCTOR:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.DOCTOR);
					} else {
						updatePeonSprite(ResourceType.DOCTOR);
					}

					break;
    		case FARMER:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.FARMER);
					} else {
						updatePeonSprite(ResourceType.FARMER);
					}

					break;
    		case GYMCOACH:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.GYMCOACH);
					} else {
						updatePeonSprite(ResourceType.GYMCOACH);
					}

					break;
    		case JOBLESS:
					break;
					
    		case MASON:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.STONE_MASON);
					} else {
						updatePeonSprite(ResourceType.STONE_MASON);
					}

					break;
    		case MINER:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.MINER);
					} else {
						updatePeonSprite(ResourceType.MINER);
					}

					break;
    		case PRIEST:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.PRIEST);
					} else {
						updatePeonSprite(ResourceType.PRIEST);
					}

					break;
    		case TEACHER:
					if(toolLevel == 1) {
						updatePeonSprite(ResourceType.TEACHER);
					} else {
						updatePeonSprite(ResourceType.TEACHER);
					}
					

					break;
    		default:
			break;

    	}
    	
    	/**
    	1. get the sprite of the peon currently being displayed in the information display panel:

    		[4:41]  
    		(via PeonManager. you guys will also need to write a getPeonManager in MainEntityManager class to let PeonInformationDisplay manager get that reference

    		[4:42]  
    		2. based on the current type of the tool (I'm not sure how you guys are doing this, so it's up to your implementation), change the sprite's image accordingly

    		[4:42]  
    		3. Done
    	*/

    	//Still to do.
    	//If on level 3 upgrade.
    	//Set style for button to be grayed out and unclickable.
    	
    }

}
