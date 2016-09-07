package uq.deco2800.ducktales;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.GameTime;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Responsible for updating the World and all entities in the game.
 * 
 * @author Leggy
 *
 */
public class GameLoop implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(GameLoop.class);
	private World world;
	private AtomicBoolean quit;
	
	private static int baseTick;
	private static int tick = 1;
	
	//Made redundant - Leggy
	//private static int SpCon = 50; // default tick rate

	private EntityManager entityManager = EntityManager.getInstance();

	private GameTime gameTime = new GameTime();

	public GameLoop(AtomicBoolean quit, int tick) {
		this.world = GameManager.getInstance().getWorld();
		GameLoop.baseTick = tick;
		GameLoop.tick = tick;
		this.quit = quit;

	}

	@Override
	public void run() {
		while (!quit.get()) {
			world.tick();
			entityManager.tick();
			gameTime.tick();
			try {
				Thread.sleep(tick);
			} catch (InterruptedException e) {
				 logger.info("context", e);
			}
		}

	}
	
	/**
	 * Modifies the tick rate of the game.
	 * 
	 * @param modifier
	 *            The tick modifier.
	 */
	public static void setTickModifier(double modifier) {
		tick = (int) (baseTick / modifier);
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
//			//tick = baseTick;
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
