package uq.deco2800.ducktales.features.builder;

import uq.deco2800.ducktales.World;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderLoop implements Runnable {

	// remove code smell due to 'unused'
    @SuppressWarnings("unused")
	private World world;
    @SuppressWarnings("unused")
	private int tick;
    @SuppressWarnings("unused")
	private AtomicBoolean quit;
    
    private WorldBuilderController controller = new WorldBuilderController();

    public WorldBuilderLoop(AtomicBoolean quit, int tick) {
        this.world = controller.getWorld();
        this.tick = tick;
        this.quit = quit;
    }

    @Override
    public void run() {
    	// Method currently overridden, comment to just remove code smell
    }
}
