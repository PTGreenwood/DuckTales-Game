package uq.deco2800.ducktales.features.entities;

import java.util.ArrayList;

import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.rendering.sprites.PeonSprite;

/**
 * Manager for all the entities in the game.
 *
 * @author eduardlio, TheFractal
 */
public class PeonManager extends EntityManager {
    
    private ArrayList<Peon> peonInstances;
    private ArrayList<PeonSprite> peonSprites;
    
    private static final PeonManager INSTANCE = new PeonManager();
    
    private PeonManager() {
    	peonInstances = new ArrayList<>();
    }
    
    public static EntityManager getInstance(){
        return INSTANCE;
    }
    
    /**
     * x and y coordinates of the peon starting point.
     * @param x 
     * @param y 
     */
    public void addPeon(int x, int y){
        // add peon sprite
        // add peon
    }

    public void removePeon(String firstName, String lastName){
        
    }
}