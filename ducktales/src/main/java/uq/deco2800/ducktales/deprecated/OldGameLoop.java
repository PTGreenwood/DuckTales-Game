package uq.deco2800.ducktales.deprecated;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.time.GameTime;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Responsible for updating the World and all entities in the game.
 * 
 * @author Leggy
 *
 */
public class OldGameLoop implements Runnable {

	private World world;
	private AtomicBoolean quit;
	
	private static int baseTick;
	private static int tick = 1;
	
	//Made redundant - Leggy
	//private static int SpCon = 50; // default tick rate

	private EntityManager entityManager = EntityManager.getInstance();

	private GameTime gameTime = new GameTime();

	public OldGameLoop(AtomicBoolean quit, int tick) {
		this.world = OldGameManager.getInstance().getWorld();
		OldGameLoop.baseTick = tick;
		OldGameLoop.tick = tick;
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
				e.printStackTrace();
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
