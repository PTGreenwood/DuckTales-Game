package uq.deco2800.ducktales.features.entities.threats;

import java.util.ArrayList;

import uq.deco2800.ducktales.rendering.sprites.EnemySprite;

/**
 * 
 * This class creates enemy and
 * effects types and defines
 * their parameters
 * 
 * Created by Krista Harrison on 4/10/2016.
 * @author kristasusanne
 */

public class ThreatFactory {
	 /** CONSTANTS */
	private static String timer = "Timer";
	protected static ArrayList<Effect> effectsList = new ArrayList<Effect>();
	protected static ArrayList<Enemy> enemiesList = new ArrayList<Enemy>();
	//list for enemy ad threat sprites to be stored in
	protected static ArrayList<EnemySprite> enemySpriteList = new ArrayList<EnemySprite>();
	
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
	public static Enemy createLevel1Enemy(EnemyType enemy) {
		switch(enemy) {
		case RACCOON:
			return createRaccoon(EnemyType.RACCOON);
		case BEETLE:
			return createBeetle(EnemyType.BEETLE);
		case WILD_VILLAGER:
			return createWildVillager(EnemyType.WILD_VILLAGER);
		default:
			return null;
		}
		
	}
	
	 /**
     * Create effects at level 1
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static Effect createLevel1Effect(EffectType effect) {
		switch(effect) {
		case BLACK_SMOKE:
			return createBlackSmoke(EffectType.BLACK_SMOKE);
		case SHAKE:
			return createShake(EffectType.SHAKE);
		default:
			return null;
		}
	}
	
	 /**
     * Create enemies at level 2
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static Enemy createLevel2Enemy(EnemyType enemy) {
		switch(enemy) {
		case WOLF:
			return createWolf(EnemyType.WOLF);
		case CROW:
			return createCrow(EnemyType.CROW);
		case GORILLA:
			return createGorilla(EnemyType.GORILLA);
		case EVIL_DUCK:
			return createEvilDuck(EnemyType.EVIL_DUCK);
		default:
			return null;
		}	
	}
	
	 /**
     * Create effects at level 2
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static Effect createLevel2Effect(EffectType effect) {
		switch(effect) {
		case POISON_CLOUD:
			return createPoisonCloud(EffectType.POISON_CLOUD);
		case RUMBLE:
			return createRumble(EffectType.RUMBLE);
		default:
			return null;
		}
	}
	
	 /**
     * Create enemies at level 3
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static Enemy createLevel3Enemy(EnemyType enemy) {
		switch(enemy) {
		case LION:
			return createLion(EnemyType.LION);
		case CHIMP:
			return createChimp(EnemyType.CHIMP);
		case BEAR:
			return createBear(EnemyType.BEAR);
		
		default:
			return null;
		}
	}
	
	 /**
     * Create effects at level 3
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static Effect createLevel3Effect(EffectType effect) {
		switch(effect) {
		case EARTHQUAKE: 
			return createEarthquake(EffectType.EARTHQUAKE);
		case GREEN_FEL_FIRE:
			return createGreenFelFire(EffectType.GREEN_FEL_FIRE);
		default:
			return null;
		}
	}
	
	 /**
     * Create enemies at level 4
     *
     * @param enemyType
     *          the type of the enemy to be created
     *          
     */
	public static Enemy createLevel4Enemy(EnemyType enemy) {
		switch(enemy) {
		case ZOMBIE_DUCK:
			return createZombieDuck(EnemyType.ZOMBIE_DUCK);
		case ROBBER:
			return createRobber(EnemyType.ROBBER);
		case ELEPHANT:
			return createElephant(EnemyType.ELEPHANT);
		default:
			return null;
		}	
	}
	
	 /**
     * Create effects at level 4
     *
     * @param effectType
     *          the type of the effect to be created
     *          
     */
	public static Effect createLevel4Effect(EffectType effect) {
		switch(effect) {
		case BLIGHT:
			return createBlight(EffectType.BLIGHT);
		case FEL:
			return createFel(EffectType.FEL);
		default:
			return null;
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
	private static Effect createBlackSmoke(EffectType blackSmoke) {
		Effect blackSmokeEffect = new Effect("Black Smoke");
		setEffectParameters(blackSmokeEffect, 20, 50, 20);
		EnemySprite blackSmokeSprite = new EnemySprite();
		enemySpriteList.add(blackSmokeSprite);
		return null;
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
	private static Effect createShake(EffectType shake) {
		Effect shakeEffect = new Effect("Shake");
		setEffectParameters(shakeEffect, 50, 100, 20);
		EnemySprite shakeSprite = new EnemySprite();
		enemySpriteList.add(shakeSprite);
		return null;
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
	private static Enemy createRaccoon(EnemyType raccoon) {
		Enemy raccoonEnemy = new Enemy("Raccoon");
		setEnemyParameters(raccoonEnemy, 20, 50, 20);
		EnemySprite raccoonSprite = new EnemySprite();
		enemySpriteList.add(raccoonSprite);
		return null;	
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
	private static Enemy createBeetle(EnemyType beetle) {
		Enemy beetleEnemy = new Enemy("Beetle");
		setEnemyParameters(beetleEnemy, 20, 50, 20);
		EnemySprite beetleSprite = new EnemySprite();
		enemySpriteList.add(beetleSprite);
		return null;
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
	private static Enemy createWildVillager(EnemyType wildVillager) {
		Enemy wildVillagerEnemy = new Enemy("Wild Villager");
		setEnemyParameters(wildVillagerEnemy, 20, 50, 20);
		EnemySprite wildVillagerSprite = new EnemySprite();
		enemySpriteList.add(wildVillagerSprite);
		return null;
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
	private static Effect createPoisonCloud(EffectType poisonCloud) {
		Effect poisonCloudEffect = new Effect("Poison Cloud");
		setEffectParameters(poisonCloudEffect, 20, 50, 30);
		EnemySprite poisonCloudSprite = new EnemySprite();
		enemySpriteList.add(poisonCloudSprite);
		return null;
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
	private static Effect createRumble(EffectType rumble) {
		Effect rumbleEffect = new Effect("Rubmle");
		setEffectParameters(rumbleEffect, 50, 100, 30);
		EnemySprite rumbleSprite = new EnemySprite();
		enemySpriteList.add(rumbleSprite);
		return null;
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
	private static Enemy createWolf(EnemyType wolf) {
		Enemy wolfEnemy = new Enemy("Wolf");
		setEnemyParameters(wolfEnemy, 20, 50, 30);
		EnemySprite wolfSprite = new EnemySprite();
		enemySpriteList.add(wolfSprite);
		return null;
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
	private static Enemy createCrow(EnemyType crow) {
		Enemy crowEnemy = new Enemy("Crow");
		setEnemyParameters(crowEnemy, 20, 50, 30);
		EnemySprite crowSprite = new EnemySprite();
		enemySpriteList.add(crowSprite);
		return null;
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
	private static Enemy createGorilla(EnemyType gorilla) {
		Enemy gorillaEnemy = new Enemy("Gorilla");
		setEnemyParameters(gorillaEnemy, 20, 50, 30);
		EnemySprite gorillaSprite = new EnemySprite();
		enemySpriteList.add(gorillaSprite);
		return null;
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
	private static Enemy createEvilDuck(EnemyType evilDuck) {
		Enemy evilDuckEnemy = new Enemy("Evil Duck");
		setEnemyParameters(evilDuckEnemy, 20, 50, 30);
		EnemySprite evilDuckSprite = new EnemySprite();
		enemySpriteList.add(evilDuckSprite);
		return null;
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
	private static Effect createEarthquake(EffectType earthquake) {
		Effect earthquakeEffect = new Effect("Earthquake");
		setEffectParameters(earthquakeEffect, 20, 50, 40);
		EnemySprite earthquakeSprite = new EnemySprite();
		enemySpriteList.add(earthquakeSprite);
		return null;
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
	private static Effect createGreenFelFire(EffectType greenFelFire) {
		Effect greenFelFireEffect = new Effect("Green Fel Fire");
		setEffectParameters(greenFelFireEffect, 20, 50, 40);
		EnemySprite greenFelFireSprite = new EnemySprite();
		enemySpriteList.add(greenFelFireSprite);
		return null;
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
	private static Enemy createLion(EnemyType lion) {
		Enemy lionEnemy = new Enemy("Lion");
		setEnemyParameters(lionEnemy, 50, 100, 40);
		EnemySprite lionSprite = new EnemySprite();
		enemySpriteList.add(lionSprite);
		return null;
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
	private static Enemy createChimp(EnemyType chimp) {
		Enemy chimpEnemy = new Enemy ("Chimp");
		setEnemyParameters(chimpEnemy, 20, 50, 40);
		EnemySprite chimpSprite = new EnemySprite();
		enemySpriteList.add(chimpSprite);
		return null;
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
	private static Enemy createBear(EnemyType bear) {
		Enemy bearEnemy = new Enemy("Bear");
		setEnemyParameters(bearEnemy, 20, 50, 40);
		EnemySprite bearSprite = new EnemySprite();
		enemySpriteList.add(bearSprite);
		return null;
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
	private static Effect createBlight(EffectType blight) {
		Effect blightEffect = new Effect("Blight");
		setEffectParameters(blightEffect, 20, 50, 50);
		EnemySprite blightSprite = new EnemySprite();
		enemySpriteList.add(blightSprite);
		return null;
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
	private static Effect createFel(EffectType fel) {
		Effect felEffect = new Effect("Fel");
		setEffectParameters(felEffect, 20, 50, 50);
		EnemySprite felSprite = new EnemySprite();
		enemySpriteList.add(felSprite);
		return null;
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
	private static Enemy createZombieDuck(EnemyType zombieDuck) {
		Enemy zombieDuckEnemy = new Enemy("Zombie Duck");
		setEnemyParameters(zombieDuckEnemy, 20, 50, 50);
		EnemySprite zombieDuckSprite = new EnemySprite();
		enemySpriteList.add(zombieDuckSprite);
		return null;
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
	private static Enemy createRobber(EnemyType robber) {
		Enemy robberEnemy = new Enemy("Robber");
		setEnemyParameters(robberEnemy, 20, 50, 50);
		EnemySprite robberSprite = new EnemySprite();
		enemySpriteList.add(robberSprite);
		return null;
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
	private static Enemy createElephant(EnemyType elephant) {
		Enemy elephantEnemy = new Enemy("Elephant");
		setEnemyParameters(elephantEnemy, 20, 50, 50);
		EnemySprite elephantSprite = new EnemySprite();
		enemySpriteList.add(elephantSprite);
		return null;
	}

}
