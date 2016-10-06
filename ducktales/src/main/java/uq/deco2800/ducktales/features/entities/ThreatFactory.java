package uq.deco2800.ducktales.features.entities;

/**
 * Created by Krista on 4/10/2016.
 * @author kristasusanne
 */

public class ThreatFactory {
	
	public enum EnemyType {
		RACCOON, BEETLE, WILD_VILLAGER, WOLF, CROW, GORILLA, EVIL_DUCK,
		LION, CHIMP, BEAR, ZOMBIE_DUCK, ROBBER, ELEPHANT,
		
	}
	
	public enum effectType {
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
	
	private static Enemy createZombieDuck(EnemyType zombieDuck) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createRobber(EnemyType robber) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createLion(EnemyType lion) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createGorilla(EnemyType gorilla) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createEvilDuck(EnemyType evilDuck) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createElephant(EnemyType elephant) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createCrow(EnemyType crow) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createChimp(EnemyType chimp) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createBear(EnemyType bear) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createWolf(EnemyType wolf) {
		return null;
		// TODO Auto-generated method stub
	}

	private static Enemy createWildVillager(EnemyType wildVillager) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createBeetle(EnemyType beetle) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Enemy createRaccoon(EnemyType raccoon) {
		return null;
		
	}

}
