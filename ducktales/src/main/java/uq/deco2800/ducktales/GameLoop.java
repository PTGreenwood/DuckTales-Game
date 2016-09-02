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

	//public enum SpeedControl {50, 33, 20};
	
	private World world;
	private int tick;
	private AtomicBoolean quit;
	
	private EntityManager entityManager = EntityManager.getInstance();
	
	//Makeshift time add
	private int gameStartMinute = 0;
	private int gameStartHour = 0;

	private GameTime duckCalendar = new GameTime();
	public GameLoop(AtomicBoolean quit, int tick) {
		this.world = GameManager.getInstance().getWorld();
		this.tick = tick;
		this.quit = quit;  

	}

	@Override
	public void run() {
		while (!quit.get()) {
			//this.tick = SpeedController();
			world.tick();
			entityManager.tick();
			duckCalendar.tick();
			try {
				Thread.sleep(tick);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
