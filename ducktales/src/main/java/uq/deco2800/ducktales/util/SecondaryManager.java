package uq.deco2800.ducktales.util;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * This class should be the interface for most secondary managers
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class SecondaryManager {

    /** The model of the game */
    protected World world;

    /** The primary manager of the game */
    protected GameManager gameManager;

    /**
     * Give this manager a reference of the game model
     *
     * @param world
     *          The model of the game
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Give this manager a reference of the primary manager
     *
     * @param gameManager
     *          The primary manager of the game, from which ALL information
     *          can be retrieved regarding other managers
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Check if this manager has the references on world and game manager,
     */
    protected void checkWorldAndGameManager() {
        if (this.gameManager == null) {
            throw new GameSetupException("Secondary Manager: "
                    + this.getClass().toString()
                    + " has not received a reference on GAME MANAGER yet"
            );
        } else if (this.world == null) {
            throw new GameSetupException("Secondary Manager: "
                    + this.getClass().toString()
                    + " has not received a reference on WORLD yet"
            );
        }
    }
}
