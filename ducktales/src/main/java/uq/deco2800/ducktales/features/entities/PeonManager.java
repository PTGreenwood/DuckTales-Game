package uq.deco2800.ducktales.features.entities;

import java.io.IOException;
import java.util.HashMap;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.rendering.sprites.PeonSprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.GeneralResourceRegister;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * Manager for all the entities in the game.
 *
 * @author eduardlio, TheFractal, khoiphan21
 */
public class PeonManager {

    /** The model of the game */
    private World world;

    /** The main manager of the game */
    private GameManager gameManager;
    
    private HashMap<String, PeonSprite> peonSprites;

    public PeonManager() {
        peonSprites = new HashMap<>(50);
    }
    
    /**
     * Add a peon to the game.
     *
     * @param x
     *          The x-coordinate of the location to add the peon to
     * @param y
     *          The y-coordinate of the location to add the peon to
     */
    public void addPeon(int x, int y) throws IOException{
    	Peon peon = new Peon(x, y);
        String name;

        // The register to get the randomized names from
        GeneralResourceRegister register = GeneralResourceRegister.getInstance();

        // Check for name duplication
        do {
            name = register.getRandomName();
        } while (world.checkPeonNameDuplication(name));

        // At this point, the name should be fine. Add the peon to World
        world.addPeon(name, peon);

        // Create the sprite of the given peon
    	PeonSprite peonSprite = SpritesFactory.createPeonSprite(name);
        // Setup the sprite
        if (gameManager != null) {
            Sprite.setupEntitySprite(peonSprite, x, y,
                    gameManager.getWorldDisplayManager().getTilesManager());
        } else {
            throw new GameSetupException("PeonManager has not received a handle" +
                    " on GameManager");
        }


        // Now add the sprite to the list of
        peonSprites.put(name, peonSprite);

        // Now render that peon sprite into the game
        gameManager.getWorldDisplayManager().getWorldDisplay()
                .getChildren().add(peonSprite);
    }

    /**
     * Give the peon manager a handle on the game model
     *
     * @param world
     *          The model of the game
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Give the peon manager a handle on the main game manager
     *
     * @param gameManager
     *          The main manager of the game
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}