package uq.deco2800.ducktales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.weather.WeatherManager;
import uq.deco2800.ducktales.features.time.DayNightManager;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

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
	private MainEntityManager mainEntityManager;

	// private DayNightManager daynightManager; //not in use currently
	private WeatherManager weatherManager;

	private static boolean paused;

	/**
	 * Create a new game loop with the given quit control and game speed
	 *
	 * @param quit
	 *            The variable to control when the game should quit
	 * @param gameSpeed
	 *            The initial speed of the game
	 */
	public GameLoop(AtomicBoolean quit, int gameSpeed) {
		GameLoop.baseGameSpeed = gameSpeed;
		GameLoop.gameSpeed = gameSpeed;
		this.quit = quit;
		GameLoop.paused = false;

	}

	@Override
	public void run() {
		while (!quit.get()) {
			if (world != null && mainEntityManager != null && timeManager != null) {

				// Continue Loop if not paused
				if (!GameLoop.paused) {
					// All the managers are ready to go
					world.tick();
					mainEntityManager.tick();
					timeManager.tick();
					weatherManager.tick();

				}
			} else {
				throw new GameSetupException(" game loop not ready");
			}
			try {
				Thread.sleep(gameSpeed);
			} catch (InterruptedException e) {
				logger.info("context", e);
				// Clean up state
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * Set the world of the game
	 * 
	 * @param world
	 *            the game world
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
		GameLoop.paused = false;

	}
	
	public static int getGameSpeed(){
		return gameSpeed;
	}

	/**
	 * Modifies the gameLoop to keep going or not
	 * 
	 */
	public static void pauseWorld() {
		if (GameLoop.paused) {
			GameLoop.paused = false;
		} else {
			GameLoop.paused = true;
		}
	}

	public static void justPause() {
		GameLoop.paused = true;
	}

	public static void justPlay() {
		GameLoop.paused = false;
	}
	
	public static boolean isPaused(){
		return GameLoop.paused;
	}

	/**
	 * Pass the handle of the Time Manager to the game loop
	 *
	 * @param timeManager
	 *            The Time Manager of the game
	 **/
	public void setTimeManager(TimeManager timeManager) {
		this.timeManager = timeManager;
	}

	public void setWeatherManager(WeatherManager weatherManager) {
		this.weatherManager = weatherManager;
	}

	/**
	 * Pass the handle of the Entity Manager to the game loop
	 * 
	 * @param mainEntityManager
	 *            The Entity Manager of the game
	 */
	public void setMainEntityManager(MainEntityManager mainEntityManager) {
		this.mainEntityManager = mainEntityManager;
	}

}
