package uq.deco2800.ducktales.features.entities.threats;

import java.util.ArrayList;
import java.util.HashMap;

import uq.deco2800.ducktales.rendering.sprites.EnemySprite;

/**
 * 
 * This class creates enemy and
 * effects types and defines
 * their parameters
 * 
 * Created by Krista Harrison and Wian Botha
 * @author kristasusanne, wianb
 */

public class ThreatFactory {
	 /** CONSTANTS */
	private static String timer = "Timer";
	protected static ArrayList<Effect> effectsList = new ArrayList<Effect>();
	protected static ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();
	//list for enemy ad threat sprites to be stored in
	protected static ArrayList<EnemySprite> enemySpriteList = new ArrayList<EnemySprite>();
	public HashMap<String, Enemy> enemyMap;
    public HashMap<String, Effect> effectMap;
	/**
	 * 
	 * Defines the enum types of enemies
	 *
	 */
	public enum EnemyType {
		RACCOON, BEETLE, WILD_VILLAGER, WOLF, CROW, GORILLA, EVIL_DUCK,
		LION, CHIMP, BEAR, ZOMBIE_DUCK, ROBBER, ELEPHANT,
		
	}
	
	/**
	 * 
	 * Defines the enum types of effects
	 *
	 */
	public enum EffectType {
		BLACK_SMOKE, SHAKE, POISON_CLOUD, RUMBLE,  EARTHQUAKE, GREEN_FEL_FIRE,
		BLIGHT, FEL,
	}
	
	 /**
     * Create enemies at level 1
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel1Enemy(EnemyType enemy) {
		switch(enemy) {
		case RACCOON:
				createRaccoon(EnemyType.RACCOON);
		case BEETLE:
				createBeetle(EnemyType.BEETLE);
		case WILD_VILLAGER:
				createWildVillager(EnemyType.WILD_VILLAGER);
		default:
			// throw error message
		}
		
	}
	
	 /**
     * Create effects at level 1
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel1Effect(EffectType effect) {
		switch(effect) {
		case BLACK_SMOKE:
				createBlackSmoke(EffectType.BLACK_SMOKE);
		case SHAKE:
				createShake(EffectType.SHAKE);
		default:
			//throw error message
		}
	}
	
	 /**
     * Create enemies at level 2
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel2Enemy(EnemyType enemy) {
		switch(enemy) {
		case WOLF:
				createWolf(EnemyType.WOLF);
		case CROW:
				createCrow(EnemyType.CROW);
		case GORILLA:
				createGorilla(EnemyType.GORILLA);
		case EVIL_DUCK:
				createEvilDuck(EnemyType.EVIL_DUCK);
		default:
			//Throw error message
		}	
	}
	
	 /**
     * Create effects at level 2
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel2Effect(EffectType effect) {
		switch(effect) {
		case POISON_CLOUD:
				createPoisonCloud(EffectType.POISON_CLOUD);
		case RUMBLE:
				createRumble(EffectType.RUMBLE);
		default:
			//Throw error message
		}
	}
	
	 /**
     * Create enemies at level 3
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel3Enemy(EnemyType enemy) {
		switch(enemy) {
		case LION:
				createLion(EnemyType.LION);
		case CHIMP:
				createChimp(EnemyType.CHIMP);
		case BEAR:
				createBear(EnemyType.BEAR);
		
		default:
			//Throw error message
		}
	}
	
	 /**
     * Create effects at level 3
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel3Effect(EffectType effect) {
		switch(effect) {
		case EARTHQUAKE: 
			createEarthquake(EffectType.EARTHQUAKE);
		case GREEN_FEL_FIRE:
			createGreenFelFire(EffectType.GREEN_FEL_FIRE);
		default:
			//Throw error message
		}
	}
	
	 /**
     * Create enemies at level 4
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel4Enemy(EnemyType enemy) {
		switch(enemy) {
		case ZOMBIE_DUCK:
				createZombieDuck(EnemyType.ZOMBIE_DUCK);
		case ROBBER:
				createRobber(EnemyType.ROBBER);
		case ELEPHANT:
				createElephant(EnemyType.ELEPHANT);
		default:
			//Throw error message
		}	
	}
	
	 /**
     * Create effects at level 4
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel4Effect(EffectType effect) {
		switch(effect) {
		case BLIGHT:
				createBlight(EffectType.BLIGHT);
		case FEL:
				createFel(EffectType.FEL);
		default:
			//Throw error message
		}
	}
	
	 /**
     * Set the start timer, end timer, level
     * of damage and random x and y values
     * for effects
     *
     * @param effect
     *          the effect to have the parameter set
     * @param start
     * 			the integer for the start timer
     * @param end
     * 			the integer for the end timer
     * @param damage
     *			the integer for level of damage
     *          
     */
	private static void setEffectParameters(Effect effect, int start, int end, int damage) {
		effect.setStartTimer(start, timer);
		effect.setEndTimer(end);
		effect.setTheLevelOfDamage(damage);
		double X = effect.getRandomX();
		double Y = effect.getRandomY();
		effectsList.add(effect);
	}
	
	 /**
     * Set the start timer, end timer, level
     * of damage and random x and y values
     * for enemies
     *
     * @param effect
     *          the enemy to have the parameter set
     * @param start
     * 			the integer for the start timer
     * @param end
     * 			the integer for the end timer
     * @param damage
     *			the integer for level of damage
     *          
     */
	private static void setEnemyParameters(Enemy enemy, int start, int end, int damage) {
		enemy.setStartTimer(start, timer);
		enemy.setEndTimer(end);
		enemy.setTheLevelOfDamage(damage);
		double X = enemy.getRandomX();
		double Y = enemy.getRandomY();
		enemiesList.add(enemy);
	}
	

	// Level 1 Effects
	
	 /**
     * Create black smoke effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createBlackSmoke(EffectType blackSmoke) {
		Effect blackSmokeEffect = new Effect("Black Smoke");
		setEffectParameters(blackSmokeEffect, 20, 50, 20);
		EnemySprite blackSmokeSprite = new EnemySprite();
		enemySpriteList.add(blackSmokeSprite);
		
	}
	
	 /**
     * Create shake effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createShake(EffectType shake) {
		Effect shakeEffect = new Effect("Shake");
		setEffectParameters(shakeEffect, 50, 100, 20);
		EnemySprite shakeSprite = new EnemySprite();
		enemySpriteList.add(shakeSprite);
		
	}
	
	// Level 1 Enemies
	
	 /**
     * Create raccoon enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the enemy type to be created from the enum class
     *          
     */
	private static void createRaccoon(EnemyType raccoon) {
		Enemy raccoonEnemy = new Enemy("Raccoon");
		setEnemyParameters(raccoonEnemy, 20, 50, 20);
		EnemySprite raccoonSprite = new EnemySprite();
		enemySpriteList.add(raccoonSprite);
			
	}
	
	 /**
     * Create beetle enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the enemy type to be created from the enum class
     *          
     */
	private static void createBeetle(EnemyType beetle) {
		Enemy beetleEnemy = new Enemy("Beetle");
		setEnemyParameters(beetleEnemy, 20, 50, 20);
		EnemySprite beetleSprite = new EnemySprite();
		enemySpriteList.add(beetleSprite);
		
	}
	
	 /**
     * Create wild villager enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createWildVillager(EnemyType wildVillager) {
		Enemy wildVillagerEnemy = new Enemy("Wild Villager");
		setEnemyParameters(wildVillagerEnemy, 20, 50, 20);
		EnemySprite wildVillagerSprite = new EnemySprite();
		enemySpriteList.add(wildVillagerSprite);
	}
	
	// Level 2 Effects
	
	 /**
     * Create poison cloud effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createPoisonCloud(EffectType poisonCloud) {
		Effect poisonCloudEffect = new Effect("Poison Cloud");
		setEffectParameters(poisonCloudEffect, 20, 50, 30);
		EnemySprite poisonCloudSprite = new EnemySprite();
		enemySpriteList.add(poisonCloudSprite);
		
	}
	
	 /**
     * Create rumble effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createRumble(EffectType rumble) {
		Effect rumbleEffect = new Effect("Rubmle");
		setEffectParameters(rumbleEffect, 50, 100, 30);
		EnemySprite rumbleSprite = new EnemySprite();
		enemySpriteList.add(rumbleSprite);
	}
	
	// Level 2 Enemies

	 /**
     * Create wolf enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createWolf(EnemyType wolf) {
		Enemy wolfEnemy = new Enemy("Wolf");
		setEnemyParameters(wolfEnemy, 20, 50, 30);
		EnemySprite wolfSprite = new EnemySprite();
		enemySpriteList.add(wolfSprite);
	}
	
	 /**
     * Create crow enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createCrow(EnemyType crow) {
		Enemy crowEnemy = new Enemy("Crow");
		setEnemyParameters(crowEnemy, 20, 50, 30);
		EnemySprite crowSprite = new EnemySprite();
		enemySpriteList.add(crowSprite);
	}
	
	 /**
     * Create gorilla enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createGorilla(EnemyType gorilla) {
		Enemy gorillaEnemy = new Enemy("Gorilla");
		setEnemyParameters(gorillaEnemy, 20, 50, 30);
		EnemySprite gorillaSprite = new EnemySprite();
		enemySpriteList.add(gorillaSprite);
	}
	
	 /**
     * Create evil duck enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createEvilDuck(EnemyType evilDuck) {
		Enemy evilDuckEnemy = new Enemy("Evil Duck");
		setEnemyParameters(evilDuckEnemy, 20, 50, 30);
		EnemySprite evilDuckSprite = new EnemySprite();
		enemySpriteList.add(evilDuckSprite);
	}
	
	// Level 3 Effects

	 /**
     * Create earthquake effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createEarthquake(EffectType earthquake) {
		Effect earthquakeEffect = new Effect("Earthquake");
		setEffectParameters(earthquakeEffect, 20, 50, 40);
		EnemySprite earthquakeSprite = new EnemySprite();
		enemySpriteList.add(earthquakeSprite);
	}
	
	 /**
     * Create green fel fire effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createGreenFelFire(EffectType greenFelFire) {
		Effect greenFelFireEffect = new Effect("Green Fel Fire");
		setEffectParameters(greenFelFireEffect, 20, 50, 40);
		EnemySprite greenFelFireSprite = new EnemySprite();
		enemySpriteList.add(greenFelFireSprite);
	}
	
	// Level 3 Enemies
	
	 /**
     * Create lion enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createLion(EnemyType lion) {
		Enemy lionEnemy = new Enemy("Lion");
		setEnemyParameters(lionEnemy, 50, 100, 40);
		EnemySprite lionSprite = new EnemySprite();
		enemySpriteList.add(lionSprite);
	}

	 /**
     * Create chimp enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createChimp(EnemyType chimp) {
		Enemy chimpEnemy = new Enemy ("Chimp");
		setEnemyParameters(chimpEnemy, 20, 50, 40);
		EnemySprite chimpSprite = new EnemySprite();
		enemySpriteList.add(chimpSprite);
	}
	
	 /**
     * Create bear enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createBear(EnemyType bear) {
		Enemy bearEnemy = new Enemy("Bear");
		setEnemyParameters(bearEnemy, 20, 50, 40);
		EnemySprite bearSprite = new EnemySprite();
		enemySpriteList.add(bearSprite);
	}
	
	// Level 4 Effects
	
	 /**
     * Create blight effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createBlight(EffectType blight) {
		Effect blightEffect = new Effect("Blight");
		setEffectParameters(blightEffect, 20, 50, 50);
		EnemySprite blightSprite = new EnemySprite();
		enemySpriteList.add(blightSprite);
	}
	
	 /**
     * Create fel effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param EffectType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createFel(EffectType fel) {
		Effect felEffect = new Effect("Fel");
		setEffectParameters(felEffect, 20, 50, 50);
		EnemySprite felSprite = new EnemySprite();
		enemySpriteList.add(felSprite);
	}
	
	// Level 4 Enemies
	
	 /**
     * Create zombie duck enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createZombieDuck(EnemyType zombieDuck) {
		Enemy zombieDuckEnemy = new Enemy("Zombie Duck");
		setEnemyParameters(zombieDuckEnemy, 20, 50, 50);
		EnemySprite zombieDuckSprite = new EnemySprite();
		enemySpriteList.add(zombieDuckSprite);
	}

	 /**
     * Create robber enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createRobber(EnemyType robber) {
		Enemy robberEnemy = new Enemy("Robber");
		setEnemyParameters(robberEnemy, 20, 50, 50);
		EnemySprite robberSprite = new EnemySprite();
		enemySpriteList.add(robberSprite);
	}

	 /**
     * Create elephant enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param EnemyType
     * 		the effect type to be created from the enum class
     *          
     */
	private static void createElephant(EnemyType elephant) {
		Enemy elephantEnemy = new Enemy("Elephant");
		setEnemyParameters(elephantEnemy, 20, 50, 50);
		EnemySprite elephantSprite = new EnemySprite();
		enemySpriteList.add(elephantSprite);
	}

}
