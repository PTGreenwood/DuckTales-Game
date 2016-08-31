package uq.deco2800.ducktales;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.World;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameManagerBeta {

    private World world;
    private GameRendererBeta renderer;
    private ResourceType currentResourceManaging = NONE;

    private static GameManagerBeta ourInstance = new GameManagerBeta();

    public static GameManagerBeta getInstance() {
        return ourInstance;
    }

    /**
     * Constructor of the {@link GameManagerBeta} class
     */
    private GameManagerBeta() {


    }

    /**
     * Set the
     * @param renderer
     */
    public void setRenderer (GameRendererBeta renderer) {
        this.renderer = renderer;
        this.renderer.start();
    }

    /**
     * Set the world for the current game
     *
     * @param world
     */
    public void setWorld(World world) {
        this.world = world;
    }

}
