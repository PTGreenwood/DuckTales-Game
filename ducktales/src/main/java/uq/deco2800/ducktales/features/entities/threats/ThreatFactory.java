package uq.deco2800.ducktales.features.entities.threats;

import java.util.ArrayList;
import java.util.HashMap;

import uq.deco2800.ducktales.rendering.sprites.EnemySprite;
import uq.deco2800.ducktales.resources.ResourceType;

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
	public static HashMap<String, Enemy> enemyMap = new HashMap<String, Enemy>();
    public static HashMap<String, Effect> effectMap = new HashMap<String, Effect>();
	
	 /**
     * Create enemies at level 1
     *
     * @param ResourceType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel1Enemy(ResourceType enemy) {
		switch(enemy) {
		case RACCOON:
				createRaccoon(ResourceType.RACCOON);
		case BEETLE:
				createBeetle(ResourceType.BEETLE);
		case WILD_VILLAGER:
				createWildVillager(ResourceType.WILD_VILLAGER);
		default:
			// throw error message
		}
		
	}
	
	 /**
     * Create effects at level 1
     *
     * @param ResourceType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel1Effect(ResourceType effect) {
		switch(effect) {
		case BLACK_SMOKE:
				createBlackSmoke(ResourceType.BLACK_SMOKE);
		case SHAKE:
				createShake(ResourceType.SHAKE);
		default:
			//throw error message
		}
	}
	
	 /**
     * Create enemies at level 2
     *
     * @param ResourceType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel2Enemy(ResourceType enemy) {
		switch(enemy) {
		// note the name of this resource had to be changed to 
		// ENEMY_WOLF due to the pre-existence of a WOLF resource
		case ENEMY_WOLF:
				createWolf(ResourceType.ENEMY_WOLF);
		case CROW:
				createCrow(ResourceType.CROW);
		case GORILLA:
				createGorilla(ResourceType.GORILLA);
		case EVIL_DUCK:
				createEvilDuck(ResourceType.EVIL_DUCK);
		default:
			//Throw error message
		}	
	}
	
	 /**
     * Create effects at level 2
     *
     * @param ResourceType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel2Effect(ResourceType effect) {
		switch(effect) {
		case POISON_CLOUD:
				createPoisonCloud(ResourceType.POISON_CLOUD);
		case RUMBLE:
				createRumble(ResourceType.RUMBLE);
		default:
			//Throw error message
		}
	}
	
	 /**
     * Create enemies at level 3
     *
     * @param ResourceType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel3Enemy(ResourceType enemy) {
		switch(enemy) {
		case LION:
				createLion(ResourceType.LION);
		case CHIMP:
				createChimp(ResourceType.CHIMP);
		case BEAR:
				createBear(ResourceType.BEAR);
		
		default:
			//Throw error message
		}
	}
	
	 /**
     * Create effects at level 3
     *
     * @param ResourceType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel3Effect(ResourceType effect) {
		switch(effect) {
		case EARTHQUAKE: 
			createEarthquake(ResourceType.EARTHQUAKE);
		case GREEN_FEL_FIRE:
			createGreenFelFire(ResourceType.GREEN_FEL_FIRE);
		default:
			//Throw error message
		}
	}
	
	 /**
     * Create enemies at level 4
     *
     * @param ResourceType
     *          the type of the enemy to be created
     *          
     */
	public static void createLevel4Enemy(ResourceType enemy) {
		switch(enemy) {
		case ZOMBIE_DUCK:
				createZombieDuck(ResourceType.ZOMBIE_DUCK);
		case ROBBER:
				createRobber(ResourceType.ROBBER);
		case ELEPHANT:
				createElephant(ResourceType.ELEPHANT);
		default:
			//Throw error message
		}	
	}
	
	 /**
     * Create effects at level 4
     *
     * @param ResourceType
     *          the type of the effect to be created
     *          
     */
	public static void createLevel4Effect(ResourceType effect) {
		switch(effect) {
		case BLIGHT:
				createBlight(ResourceType.BLIGHT);
		case FEL:
				createFel(ResourceType.FEL);
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
		double x = effect.getRandomX();
		double y = effect.getRandomY();
		putInEffectHashMap(effect);
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
		double x = enemy.getRandomX();
		double y = enemy.getRandomY();
		putInEnemyHashMap(enemy);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createBlackSmoke(ResourceType blackSmoke) {
		Effect blackSmokeEffect = new Effect("Black Smoke");
		setEffectParameters(blackSmokeEffect, 20, 50, 20);
		EnemySprite blackSmokeSprite = new EnemySprite(0, blackSmoke);
		enemySpriteList.add(blackSmokeSprite);
		putInEffectHashMap(blackSmokeEffect);
		
	}
	
	 /**
     * Create shake effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createShake(ResourceType shake) {
		Effect shakeEffect = new Effect("Shake");
		setEffectParameters(shakeEffect, 50, 100, 20);
		EnemySprite shakeSprite = new EnemySprite(0, shake);
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
     * @param ResourceType
     * 		the enemy type to be created from the ResourceType class
     *          
     */
	private static void createRaccoon(ResourceType raccoon) {
		Enemy raccoonEnemy = new Enemy("Raccoon");
		setEnemyParameters(raccoonEnemy, 20, 50, 20);
		EnemySprite raccoonSprite = new EnemySprite(0, raccoon);
		enemySpriteList.add(raccoonSprite);
			
	}
	
	 /**
     * Create beetle enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the enemy type to be created from the ResourceType class
     *          
     */
	private static void createBeetle(ResourceType beetle) {
		Enemy beetleEnemy = new Enemy("Beetle");
		setEnemyParameters(beetleEnemy, 20, 50, 20);
		EnemySprite beetleSprite = new EnemySprite(0, beetle);
		enemySpriteList.add(beetleSprite);
		
	}
	
	 /**
     * Create wild villager enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createWildVillager(ResourceType wildVillager) {
		Enemy wildVillagerEnemy = new Enemy("Wild Villager");
		setEnemyParameters(wildVillagerEnemy, 20, 50, 20);
		EnemySprite wildVillagerSprite = new EnemySprite(0, wildVillager);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createPoisonCloud(ResourceType poisonCloud) {
		Effect poisonCloudEffect = new Effect("Poison Cloud");
		setEffectParameters(poisonCloudEffect, 20, 50, 30);
		EnemySprite poisonCloudSprite = new EnemySprite(0, poisonCloud);
		enemySpriteList.add(poisonCloudSprite);
		
	}
	
	 /**
     * Create rumble effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createRumble(ResourceType rumble) {
		Effect rumbleEffect = new Effect("Rubmle");
		setEffectParameters(rumbleEffect, 50, 100, 30);
		EnemySprite rumbleSprite = new EnemySprite(0, rumble);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createWolf(ResourceType enemy_wolf) {
		Enemy wolfEnemy = new Enemy("Wolf");
		setEnemyParameters(wolfEnemy, 20, 50, 30);
		EnemySprite wolfSprite = new EnemySprite(0, enemy_wolf);
		enemySpriteList.add(wolfSprite);
	}
	
	 /**
     * Create crow enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createCrow(ResourceType crow) {
		Enemy crowEnemy = new Enemy("Crow");
		setEnemyParameters(crowEnemy, 20, 50, 30);
		EnemySprite crowSprite = new EnemySprite(0, crow);
		enemySpriteList.add(crowSprite);
	}
	
	 /**
     * Create gorilla enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createGorilla(ResourceType gorilla) {
		Enemy gorillaEnemy = new Enemy("Gorilla");
		setEnemyParameters(gorillaEnemy, 20, 50, 30);
		EnemySprite gorillaSprite = new EnemySprite(0, gorilla);
		enemySpriteList.add(gorillaSprite);
	}
	
	 /**
     * Create evil duck enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createEvilDuck(ResourceType evilDuck) {
		Enemy evilDuckEnemy = new Enemy("Evil Duck");
		setEnemyParameters(evilDuckEnemy, 20, 50, 30);
		EnemySprite evilDuckSprite = new EnemySprite(0, evilDuck);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createEarthquake(ResourceType earthquake) {
		Effect earthquakeEffect = new Effect("Earthquake");
		setEffectParameters(earthquakeEffect, 20, 50, 40);
		EnemySprite earthquakeSprite = new EnemySprite(0, earthquake);
		enemySpriteList.add(earthquakeSprite);
	}
	
	 /**
     * Create green fel fire effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createGreenFelFire(ResourceType greenFelFire) {
		Effect greenFelFireEffect = new Effect("Green Fel Fire");
		setEffectParameters(greenFelFireEffect, 20, 50, 40);
		EnemySprite greenFelFireSprite = new EnemySprite(0, greenFelFire);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createLion(ResourceType lion) {
		Enemy lionEnemy = new Enemy("Lion");
		setEnemyParameters(lionEnemy, 50, 100, 40);
		EnemySprite lionSprite = new EnemySprite(0, lion);
		enemySpriteList.add(lionSprite);
	}

	 /**
     * Create chimp enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createChimp(ResourceType chimp) {
		Enemy chimpEnemy = new Enemy ("Chimp");
		setEnemyParameters(chimpEnemy, 20, 50, 40);
		EnemySprite chimpSprite = new EnemySprite(0, chimp);
		enemySpriteList.add(chimpSprite);
	}
	
	 /**
     * Create bear enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createBear(ResourceType bear) {
		Enemy bearEnemy = new Enemy("Bear");
		setEnemyParameters(bearEnemy, 20, 50, 40);
		EnemySprite bearSprite = new EnemySprite(0, bear);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createBlight(ResourceType blight) {
		Effect blightEffect = new Effect("Blight");
		setEffectParameters(blightEffect, 20, 50, 50);
		EnemySprite blightSprite = new EnemySprite(0, blight);
		enemySpriteList.add(blightSprite);
	}
	
	 /**
     * Create fel effect, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the effect
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createFel(ResourceType fel) {
		Effect felEffect = new Effect("Fel");
		setEffectParameters(felEffect, 20, 50, 50);
		EnemySprite felSprite = new EnemySprite(0, fel);
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
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createZombieDuck(ResourceType zombieDuck) {
		Enemy zombieDuckEnemy = new Enemy("Zombie Duck");
		setEnemyParameters(zombieDuckEnemy, 20, 50, 50);
		EnemySprite zombieDuckSprite = new EnemySprite(0, zombieDuck);
		enemySpriteList.add(zombieDuckSprite);
	}

	 /**
     * Create robber enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createRobber(ResourceType robber) {
		Enemy robberEnemy = new Enemy("Robber");
		setEnemyParameters(robberEnemy, 20, 50, 50);
		EnemySprite robberSprite = new EnemySprite(0, robber);
		enemySpriteList.add(robberSprite);
	}

	 /**
     * Create elephant enemy, assign its
     * start timer, end timer, level
     * of damage and random x and y values, 
     * and create the sprite for
     * the enemy
     *
     * @param ResourceType
     * 		the effect type to be created from the ResourceType class
     *          
     */
	private static void createElephant(ResourceType elephant) {
		Enemy elephantEnemy = new Enemy("Elephant");
		setEnemyParameters(elephantEnemy, 20, 50, 50);
		EnemySprite elephantSprite = new EnemySprite(0, elephant);
		enemySpriteList.add(elephantSprite);
	}
	
	private static void putInEnemyHashMap(Enemy enemy){
		enemyMap.put(enemy.toString(), enemy);
	}
	
	private static void putInEffectHashMap(Effect effect){
		effectMap.put(effect.toString(), effect);
	}

	
	public static void clearEnemyHashMap(){
		enemyMap.clear();
	}
	
	
	public static void clearEffectHashMap(){
		effectMap.clear();
	}

}
