package uq.deco2800.ducktales.features.entities;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.rendering.sprites.EntitySprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;

import java.util.List;

/**
 * This will be the parent class for all other secondary entity managers such as
 * AnimalManager and BuildingManager
 *
 * Created on 12/10/2016.
 * @author khoiphan21
 */
public class SecondaryEntityManager {
    /** The main manager of the game */
    protected GameManager gameManager;

    /** The main model of the game */
    protected World world;

    /**
     * Give this manager a handle on the main game manager
     *
     * @param gameManager
     *          The main manager of the game
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Give this manager a handle on the model of the game - the game world
     *
     * @param world
     *          The model of the game
     */
    public void setWorld(World world) {
        this.world = world;
    }
}
