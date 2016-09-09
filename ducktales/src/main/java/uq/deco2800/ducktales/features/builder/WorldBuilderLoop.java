package uq.deco2800.ducktales.features.builder;

import uq.deco2800.ducktales.World;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderLoop implements Runnable {

    private World world;
    private int tick;
    private AtomicBoolean quit;

    public WorldBuilderLoop(AtomicBoolean quit, int tick) {
        this.world = WorldBuilderManager.getInstance().getWorld();
        this.tick = tick;
        this.quit = quit;
    }

    @Override
    public void run() {
    	// Method currently overridden, comment to just remove code smell
    }
}
