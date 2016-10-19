package uq.deco2800.ducktales.features.entities.threats;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.rendering.sprites.ThreatSprite;
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

    /** The list of sprites for the enemies */
    private List<ThreatSprite> threatSprites;
    
    

    public ThreatManager() {
        threatSprites = new ArrayList<>(50);
    }

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
	 */
	public void threatsLvl1() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel1Enemy(ThreatFactory.EnemyType.RACCOON);
		ThreatFactory.createLevel1Enemy(ThreatFactory.EnemyType.BEETLE);
		ThreatFactory.createLevel1Enemy(ThreatFactory.EnemyType.WILD_VILLAGER);
		// ------Effects---------
		ThreatFactory.createLevel1Effect(ThreatFactory.EffectType.BLACK_SMOKE);
		ThreatFactory.createLevel1Effect(ThreatFactory.EffectType.SHAKE);
	}

	/**
	 * Set threat level 2.
	 */
	public void threatsLvl2() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel2Enemy(ThreatFactory.EnemyType.WOLF);
		ThreatFactory.createLevel2Enemy(ThreatFactory.EnemyType.CROW);
		ThreatFactory.createLevel2Enemy(ThreatFactory.EnemyType.GORILLA);
		ThreatFactory.createLevel2Enemy(ThreatFactory.EnemyType.EVIL_DUCK);
		
		// ------Effects---------
		ThreatFactory.createLevel2Effect(ThreatFactory.EffectType.POISON_CLOUD);
		ThreatFactory.createLevel2Effect(ThreatFactory.EffectType.RUMBLE);
	}

	/**
	 * Set threat level 3.
	 */
	public void threatsLvl3() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();
		
		// -------Enemies--------
		ThreatFactory.createLevel3Enemy(ThreatFactory.EnemyType.LION);
		ThreatFactory.createLevel3Enemy(ThreatFactory.EnemyType.CHIMP);
		ThreatFactory.createLevel3Enemy(ThreatFactory.EnemyType.BEAR);
		
		// ------Effects---------
		ThreatFactory.createLevel3Effect(ThreatFactory.EffectType.EARTHQUAKE);
		ThreatFactory.createLevel3Effect(ThreatFactory.EffectType.GREEN_FEL_FIRE);
	}

	/**
	 * Set threat level 4.
	 */
	public void threatsLvl4() {
		// Clear Effects
		ThreatFactory.effectsList.clear();
		ThreatFactory.enemiesList.clear();

		// -------Enemies--------
		ThreatFactory.createLevel4Enemy(ThreatFactory.EnemyType.ZOMBIE_DUCK);
		ThreatFactory.createLevel4Enemy(ThreatFactory.EnemyType.ROBBER);
		ThreatFactory.createLevel4Enemy(ThreatFactory.EnemyType.ELEPHANT);
		
		// ------Effects---------
		ThreatFactory.createLevel4Effect(ThreatFactory.EffectType.BLIGHT);
		ThreatFactory.createLevel4Effect(ThreatFactory.EffectType.FEL);

		
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
