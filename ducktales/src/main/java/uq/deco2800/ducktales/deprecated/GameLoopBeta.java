package uq.deco2800.ducktales.deprecated;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import uq.deco2800.ducktales.features.time.GameTime;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class is responsible for updating the world and all entities in it
 *
 * @author Leggy, khoiphan21
 */
@Deprecated
public class GameLoopBeta implements Runnable {

    /** Variable to control the running state of the game */
    private AtomicBoolean quit;
    
    //added a logger to fix vulnerability 
//    private static Logger logger = LoggerFactory.getLogger(GameLoopBeta.class);
    
    /** Variable controlling how fast the game time is */
    private int tickTime;
    private GameTime gameTime;
    
    /**
     * Main constructor for the {@link GameLoopBeta} class.
     * 
     * @param quit Controls the running state of the game.
     * @param tickTime Controls the game tick interval.
     */
    public GameLoopBeta(AtomicBoolean quit, int tickTime) {
        this.tickTime = tickTime;
        this.quit = quit;
        this.gameTime = new GameTime();
    }
    
    @Override
    public void run() {
        while (!quit.get()) {
            gameTime.tick();

            try {
                Thread.sleep(tickTime);
            } catch (InterruptedException e) {
//            	logger.info("context", e);
            }
        }
    }
    
}
