package uq.deco2800.ducktales.features.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.rendering.sprites.PeonSprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.GeneralResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;
import uq.deco2800.ducktales.features.jobframework.*;
/**
 * Manager for all the entities in the game.
 *
 * @author eduardlio, TheFractal, khoiphan21
 */
public class PeonManager extends SecondaryManager{

    /** The list of peon sprites */
    private HashMap<String, PeonSprite> peonSprites;
    private Job builder;
    private Job miner;
    private Job lumberjack;
    private Job doctor;
    private Job farmer;
    private ArrayList<Job> availableJobs;
    /**
     * Initialize a peon manager with initial sprite list capacity of 50
     */
    public PeonManager() {
        this.availableJobs = new ArrayList<Job>(Arrays.asList(builder, miner, lumberjack, doctor, farmer));
        this.farmer = new Farmer();
        this.doctor = new Doctor();
        this.lumberjack = new Lumberjack();
        this.miner = new Miner();
        this.builder = new Builder();
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
    	
        String name;

        // The register to get the randomized names from
        GeneralResourceRegister register = GeneralResourceRegister.getInstance();

        // Check for name duplication
        do {
            name = register.getRandomName();
        } while (world.checkPeonNameDuplication(name));

        Peon peon = new Peon(x, y, name);
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
     * Retrieve a sprite of a peon. The parameter passed in is the name of
     * the peon, which is also the unique ID of that peon. return {@code null}
     * if the name is invalid
     *
     * @param name
     *          The name of the peon whose sprite is to be retrieved
     * @return the sprite of the peon whose name is given
     *         {@code null} if the name is not in the list of peon sprites
     */
    public PeonSprite getPeonSprite(String name) {
        if (peonSprites.containsKey(name)) {
            return peonSprites.get(name);
        } else {
            return null;
        }
    }


    /**
     * Move all the peon sprites by the given x- and y-amount on the screen
     *
     * @param xAmount
     *          The amount to move in x-direction
     * @param yAmount
     *          The amount to move in y-direction
     */
    public void moveAllPeonSprites(double xAmount, double yAmount) {
        PeonSprite sprite;
        for (String key : peonSprites.keySet()) {
            sprite = peonSprites.get(key);

            if (sprite != null) {
                sprite.setLayoutX(sprite.getLayoutX() + xAmount);
                sprite.setLayoutY(sprite.getLayoutY() + yAmount);
            } else {
                throw new GameSetupException("A sprite is not yet " +
                        "instantiated");
            }
        }
    }
    
}