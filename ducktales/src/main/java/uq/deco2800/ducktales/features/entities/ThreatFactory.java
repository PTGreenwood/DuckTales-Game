package uq.deco2800.ducktales.features.entities;

/**
 * Created by Krista on 4/10/2016.
 * @author kristasusanne
 */

public class ThreatFactory {

	static String timer = "Timer";
	private static Effect smoke;
	
	public enum EnemyType {
		RACCOON, BEETLE, WILD_VILLAGER, WOLF, CROW, GORILLA, EVIL_DUCK,
		LION, CHIMP, BEAR, ZOMBIE_DUCK, ROBBER, ELEPHANT,
		
	}
	
	public enum EffectType {
		BLACK_SMOKE, SHAKE, POISON_CLOUD, RUMBLE,  EARTHQUAKE, GREEN_FEL_FIRE,
		BLIGHT, FEL,
	}
	
	public static Enemy createEnemy(EnemyType enemy) {
		switch(enemy) {
		case RACCOON:
			return createRaccoon(EnemyType.RACCOON);
		case BEETLE:
			return createBeetle(EnemyType.BEETLE);
		case WILD_VILLAGER:
			return createWildVillager(EnemyType.WILD_VILLAGER);
		case WOLF:
			return createWolf(EnemyType.WOLF);
		case BEAR:
			return createBear(EnemyType.BEAR);
		case CHIMP:
			return createChimp(EnemyType.CHIMP);
		case CROW:
			return createCrow(EnemyType.CROW);
		case ELEPHANT:
			return createElephant(EnemyType.ELEPHANT);
		case EVIL_DUCK:
			return createEvilDuck(EnemyType.EVIL_DUCK);
		case GORILLA:
			return createGorilla(EnemyType.GORILLA);
		case LION:
			return createLion(EnemyType.LION);
		case ROBBER:
			return createRobber(EnemyType.ROBBER);
		case ZOMBIE_DUCK:
			return createZombieDuck(EnemyType.ZOMBIE_DUCK);
		default:
			return null;
		}	
	}
	
	public static Effect createEffect(EffectType effect) {
		switch(effect) {
		case BLACK_SMOKE:
			return createBlackSmoke(EffectType.BLACK_SMOKE);
		case SHAKE:
			return createShake(EffectType.SHAKE);
		case POISON_CLOUD:
			return createPoisonCloud(EffectType.POISON_CLOUD);
		case RUMBLE:
			return createRumble(EffectType.RUMBLE);
		case EARTHQUAKE:
			return createEarthquake(EffectType.EARTHQUAKE);
		case GREEN_FEL_FIRE:
			return createGreenFelFire(EffectType.GREEN_FEL_FIRE);
		case BLIGHT:
			return createBlight(EffectType.BLIGHT);
		case FEL:
			return createFel(EffectType.FEL);
		default:
			return null;
		}
	}
	
	private static void setEffectParameters(Effect effect, int start, int end, int damage) {
		effect.setStartTimer(start, timer);
		effect.setEndTimer(end);
		effect.setTheLevelOfDamage(damage);
		double X = effect.getRandomX();
		double Y = effect.getRandomY();
	}
	
	private static void setEnemyParameters(Enemy enemy, int start, int end, int damage) {
		enemy.setStartTimer(start, timer);
		enemy.setEndTimer(end);
		enemy.setTheLevelOfDamage(damage);
		double X = enemy.getRandomX();
		double Y = enemy.getRandomY();
	}
	
	// Level 1 Effects
	private static Effect createBlackSmoke(EffectType blackSmoke) {
		Effect blackSmokeEffect = new Effect("Black Smoke");
		setEffectParameters(blackSmokeEffect, 20, 50, 20);
		return null;
	}
	
	private static Effect createShake(EffectType shake) {
		Effect shakeEffect = new Effect("Shake");
		setEffectParameters(shakeEffect, 50, 100, 20);
		return null;
	}
	
	// Level 1 Enemies
	private static Enemy createRaccoon(EnemyType raccoon) {
		Enemy raccoonEnemy = new Enemy("Raccoon");
		setEnemyParameters(raccoonEnemy, 20, 50, 20);
		return null;	
	}
	
	private static Enemy createBeetle(EnemyType beetle) {
		Enemy beetleEnemy = new Enemy("Beetle");
		setEnemyParameters(beetleEnemy, 20, 50, 20);
		return null;
	}
	

	private static Enemy createWildVillager(EnemyType wildVillager) {
		Enemy wildVillagerEnemy = new Enemy("Wild Villager");
		setEnemyParameters(wildVillagerEnemy, 20, 50, 20);
		return null;
	}
	
	// Level 2 Effects
	private static Effect createPoisonCloud(EffectType poisonCloud) {
		Effect poisonCloudEffect = new Effect("Poison Cloud");
		setEffectParameters(poisonCloudEffect, 20, 50, 30);
		return null;
	}
	
	private static Effect createRumble(EffectType rumble) {
		Effect rumbleEffect = new Effect("Rubmle");
		setEffectParameters(rumbleEffect, 50, 100, 30);
		return null;
	}
	
	// Level 2 Enemies

	private static Enemy createWolf(EnemyType wolf) {
		Enemy wolfEnemy = new Enemy("Wolf");
		setEnemyParameters(wolfEnemy, 20, 50, 30);
		return null;
	}
	
	private static Enemy createCrow(EnemyType crow) {
		Enemy crowEnemy = new Enemy("Crow");
		setEnemyParameters(crowEnemy, 20, 50, 30);
		return null;
	}
	
	private static Enemy createGorilla(EnemyType gorilla) {
		Enemy gorillaEnemy = new Enemy("Gorilla");
		setEnemyParameters(gorillaEnemy, 20, 50, 30);
		return null;
	}
	
	private static Enemy createEvilDuck(EnemyType evilDuck) {
		Enemy evilDuckEnemy = new Enemy("Evil Duck");
		setEnemyParameters(evilDuckEnemy, 20, 50, 30);
		return null;
	}
	
	// Level 3 Effects

	private static Effect createEarthquake(EffectType earthquake) {
		Effect earthquakeEffect = new Effect("Earthquake");
		setEffectParameters(earthquakeEffect, 20, 50, 40);
		return null;
	}
	
	private static Effect createGreenFelFire(EffectType greenFelFire) {
		Effect greenFelFireEffect = new Effect("Green Fel Fire");
		setEffectParameters(greenFelFireEffect, 20, 50, 40);
		return null;
	}
	
	// Level 3 Enemies
	private static Enemy createLion(EnemyType lion) {
		Enemy lionEnemy = new Enemy("Lion");
		setEnemyParameters(lionEnemy, 50, 100, 40);
		return null;
	}

	private static Enemy createChimp(EnemyType chimp) {
		Enemy chimpEnemy = new Enemy ("Chimp");
		setEnemyParameters(chimpEnemy, 20, 50, 40);
		return null;
	}
	
	private static Enemy createBear(EnemyType bear) {
		Enemy bearEnemy = new Enemy("Bear");
		setEnemyParameters(bearEnemy, 20, 50, 40);
		return null;
	}
	
	// Level 4 Effects
	private static Effect createBlight(EffectType blight) {
		Effect blightEffect = new Effect("Blight");
		setEffectParameters(blightEffect, 20, 50, 50);
		return null;
	}
	
	private static Effect createFel(EffectType fel) {
		Effect felEffect = new Effect("Fel");
		setEffectParameters(felEffect, 20, 50, 50);
		return null;
	}
	
	// Level 4 Enemies
	private static Enemy createZombieDuck(EnemyType zombieDuck) {
		Enemy zombieDuckEnemy = new Enemy("Zombie Duck");
		setEnemyParameters(zombieDuckEnemy, 20, 50, 50);
		return null;
	}

	private static Enemy createRobber(EnemyType robber) {
		Enemy robberEnemy = new Enemy("Robber");
		setEnemyParameters(robberEnemy, 20, 50, 50);
		return null;
	}

	private static Enemy createElephant(EnemyType elephant) {
		Enemy elephantEnemy = new Enemy("Elephant");
		setEnemyParameters(elephantEnemy, 20, 50, 50);
		return null;
	}

}
