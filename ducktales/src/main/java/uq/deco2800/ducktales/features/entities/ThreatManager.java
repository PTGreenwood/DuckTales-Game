package uq.deco2800.ducktales.features.entities;

import uq.deco2800.ducktales.World;
import static uq.deco2800.ducktales.features.entities.ThreatFactory.EffectType.*;
import static uq.deco2800.ducktales.features.entities.ThreatFactory.EnemyType.*;

import java.util.*;

/**
 * Creates enemies and effects and manages when they are deployed
 * 
 * 
 * @author Wian and Krista
 *
 */
public class ThreatManager {

	// Temp variables
	/** The world of the game */
	private World world;

	/**
	 * Set threat level 1.
	 */
	public void threatsLvl1() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel1Enemy(RACCOON);
		ThreatFactory.createLevel1Enemy(BEETLE);
		ThreatFactory.createLevel1Enemy(WILD_VILLAGER);
		// ------Effects---------
		ThreatFactory.createLevel1Effect(BLACK_SMOKE);
		ThreatFactory.createLevel1Effect(SHAKE);
	}

	/**
	 * Set threat level 2.
	 */
	public void threatsLvl2() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel2Enemy(WOLF);
		ThreatFactory.createLevel2Enemy(CROW);
		ThreatFactory.createLevel2Enemy(GORILLA);
		ThreatFactory.createLevel2Enemy(EVIL_DUCK);
		
		// ------Effects---------
		ThreatFactory.createLevel2Effect(POISON_CLOUD);
		ThreatFactory.createLevel2Effect(RUMBLE);	
	}

	/**
	 * Set threat level 3.
	 */
	public void threatsLvl3() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();
		
		// -------Enemies--------
		ThreatFactory.createLevel3Enemy(LION);
		ThreatFactory.createLevel3Enemy(CHIMP);
		ThreatFactory.createLevel3Enemy(BEAR);
		
		// ------Effects---------
		ThreatFactory.createLevel3Effect(EARTHQUAKE);
		ThreatFactory.createLevel3Effect(GREEN_FEL_FIRE);
	}

	/**
	 * Set threat level 4.
	 */
	public void threatsLvl4() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel4Enemy(ZOMBIE_DUCK);
		ThreatFactory.createLevel4Enemy(ROBBER);
		ThreatFactory.createLevel4Enemy(ELEPHANT);
		
		// ------Effects---------
		ThreatFactory.createLevel4Effect(BLIGHT);
		ThreatFactory.createLevel4Effect(FEL);

		
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
