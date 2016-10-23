package uq.deco2800.ducktales.features.entities.threats;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import java.util.*;

/**
 * Creates enemies and effects and manages when they are deployed
 * 
 * @author Wian and Krista
 *
 */
public class ThreatManager extends SecondaryManager {

	/**
	 * Add one initial threat to the world. This is for testing purposes only
	 */
	public void addOneThreat() {
		if (this.gameManager != null && this.world != null) {
            // Create a threat

            // Create a sprite

            // Add the threat to the world

            // Add the sprite to the world
		} else {
            throw new GameSetupException("ThreatManager does not have a reference" +
                    " to GameManager or World yet");
        }
	}
	/**
	 * Set threat level 1.
	 * @throws Exception 
	 */
	public void threatsLvl1() throws Exception {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel1Enemy(ResourceType.RACCOON);
		ThreatFactory.createLevel1Enemy(ResourceType.BEETLE);
		ThreatFactory.createLevel1Enemy(ResourceType.WILD_VILLAGER);
		// ------Effects---------
		ThreatFactory.createLevel1Effect(ResourceType.BLACK_SMOKE);
		ThreatFactory.createLevel1Effect(ResourceType.SHAKE);
	}

	/**
	 * Set threat level 2.
	 * @throws Exception 
	 */
	public void threatsLvl2() throws Exception {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel2Enemy(ResourceType.WOLF);
		ThreatFactory.createLevel2Enemy(ResourceType.CROW);
		ThreatFactory.createLevel2Enemy(ResourceType.GORILLA);
		ThreatFactory.createLevel2Enemy(ResourceType.EVIL_DUCK);
		
		// ------Effects---------
		ThreatFactory.createLevel2Effect(ResourceType.POISON_CLOUD);
		ThreatFactory.createLevel2Effect(ResourceType.RUMBLE);
	}

	/**
	 * Set threat level 3.
	 * @throws Exception 
	 */
	public void threatsLvl3() throws Exception {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();
		
		// -------Enemies--------
		ThreatFactory.createLevel3Enemy(ResourceType.LION);
		ThreatFactory.createLevel3Enemy(ResourceType.CHIMP);
		ThreatFactory.createLevel3Enemy(ResourceType.BEAR);
		
		// ------Effects---------
		ThreatFactory.createLevel3Effect(ResourceType.EARTHQUAKE);
		ThreatFactory.createLevel3Effect(ResourceType.GREEN_FEL_FIRE);
	}

	/**
	 * Set threat level 4.
	 * @throws Exception 
	 */
	public void threatsLvl4() throws Exception {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel4Enemy(ResourceType.ZOMBIE_DUCK);
		ThreatFactory.createLevel4Enemy(ResourceType.ROBBER);
		ThreatFactory.createLevel4Enemy(ResourceType.ELEPHANT);
		
		// ------Effects---------
		ThreatFactory.createLevel4Effect(ResourceType.BLIGHT);
		ThreatFactory.createLevel4Effect(ResourceType.FEL);

		
	}

	/**
	 * 
	 * @return The current list of enemies created
	 */
	public static ArrayList<Enemy> returnEnemies() {
		return ThreatFactory.enemiesList;
	}

	/**
	 * 
	 * @return The current list of Effects created.
	 */
	public static ArrayList<Effect> returnEffects() {
		return ThreatFactory.effectsList;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	

}
