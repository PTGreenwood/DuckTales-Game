package uq.deco2800.ducktales.world;

/**
 * WorldManager is responsible for the managing of current World.
 * 
 * @author Leggy
 *
 */
public class WorldManager {

	private static final WorldManager INSTANCE = new WorldManager();

	private World world;

	/**
	 * Returns the instance of {@link WorldManager}.
	 * 
	 * @return Returns an instance of WorldManager.
	 */
	public static WorldManager getInstance() {
		return INSTANCE;
	}

	private WorldManager() {
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

}