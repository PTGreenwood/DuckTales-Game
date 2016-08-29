package uq.deco2800.ducktales;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.world.World;
import uq.deco2800.ducktales.world.DuckCalendar;

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
	
	private EntityManager entityManager = EntityManager.getInstance();
	
	private DuckCalendar duckCalendar = new DuckCalendar(0, 0);
	public GameLoop(AtomicBoolean quit, int tick) {
		this.world = GameManager.getInstance().getWorld();
		this.tick = tick;
		this.quit = quit;  

	}

	@Override
	public void run() {
		while (!quit.get()) {
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
