package uq.deco2800.ducktales;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.GameTime;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Responsible for updating the World and all entities in the game.
 * 
 * @author Leggy
 *
 */
public class GameLoop implements Runnable {
	
	private World world;
	private int tick;
	private AtomicBoolean quit;
	private static int SpCon = 50; //default tick rate 
	
	private EntityManager entityManager = EntityManager.getInstance();
	
	private GameTime gameTime = new GameTime();
	public GameLoop(AtomicBoolean quit, int tick) {
		this.world = GameManager.getInstance().getWorld();
		this.tick = tick;
		this.quit = quit;  

	}
	
	@Override
	public void run() {
		while (!quit.get()) {
			this.tick = SpCon;
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
	
	public static void setSpeed(int speed) {
		
		SpCon = speed;
		
	}
	/**
	 * 
	 * continues to add time functionality
	 * @author danl256
	 * */
	public static void SpeedControl(String code) {
		switch (code) {
		case "mallard":
			SpCon = 50; //set time scale to default
			break;

		case "canvasback":
			SpCon = 33; //set time scale to 1.5151x
			break;

		case "merganser":
			SpCon = 20; //set time scale to 2.5x
			break;

		default:
			break;
		}
		
	}
		

}
