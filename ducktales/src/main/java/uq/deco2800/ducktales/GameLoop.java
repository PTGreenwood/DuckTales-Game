package uq.deco2800.ducktales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.features.time.GameTime;
import uq.deco2800.ducktales.features.time.TimeManager;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Responsible for updating the World and all entities in the game.
 * 
 * @author Leggy
 *
 */
public class GameLoop implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(GameLoop.class);

	/** The model of the game world */
	private World world;

	/** Variable to control start/end logic of the game */
	private AtomicBoolean quit;
	
	private static int baseGameSpeed;
	private static int gameSpeed = 1;
	
	/** The secondary managers of the game */
	private TimeManager timeManager;
	private EntityManager entityManager;

	/**
	 * Create a new game loop with the given quit control and game speed
	 *
	 * @param quit
	 * 			The variable to control when the game should quit
	 * @param gameSpeed
	 * 			The initial speed of the game
	 */
	public GameLoop(AtomicBoolean quit, int gameSpeed) {
		GameLoop.baseGameSpeed = gameSpeed;
		GameLoop.gameSpeed = gameSpeed;
		this.quit = quit;

	}

	@Override
	public void run() {
		while (!quit.get()) {
			if (world != null && entityManager != null && timeManager != null ) {
				// All the managers are ready to go
				world.tick();
				entityManager.tick();
				timeManager.tick();
			} else {
				System.err.println(" game loop not ready");
			}
			try {
				Thread.sleep(gameSpeed);
			} catch (InterruptedException e) {
				 logger.info("context", e);
			}
		}

	}

	/**
	 * Set the world of the game
	 * @param world
	 * 			the game world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * Modifies the gameSpeed rate of the game.
	 * 
	 * @param modifier
	 *            The gameSpeed modifier.
	 */
	public static void setSpeedModifier(double modifier) {
		gameSpeed = (int) (baseGameSpeed / modifier);
	}

	/**
	 * Pass the handle of the Time Manager to the game loop
	 *
	 * @param timeManager
	 * 			The Time Manager of the game
	 */
	public void setTimeManager(TimeManager timeManager) {
		this.timeManager = timeManager;
	}

	/**
	 * Pass the handle of the Entity Manager to the game loop
	 * @param entityManager
	 * 			The Entity Manager of the game
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//	public static void setSpeed(int speed) {
//		SpCon = speed;
//	}

//	/**
//	 * 
//	 * continues to add time functionality
//	 * 
//	 * @author danl256
//	 */
//	public static void SpeedControl(String code) {
//		switch (code) {
//		case "mallard":
//			//gameSpeed = baseGameSpeed;
//			//SpCon = 50; // set time scale to default
//			break;
//
//		case "canvasback":
//			SpCon = 33; // set time scale to 1.5151x
//			break;
//
//		case "merganser":
//			SpCon = 20; // set time scale to 2.5x
//			break;
//
//		default:
//			break;
//		}
//
//	}

}
