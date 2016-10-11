package uq.deco2800.ducktales.features.entities;

import java.util.ArrayList;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Manager for all the entities in the game.
 *
 * @author eduardlio, TheFractal
 */
public class PeonManager extends EntityManager {
    
    private ArrayList<Peon> peonInstances;
    
    private static final PeonManager INSTANCE = new PeonManager();
    
    private PeonManager() {
    	peonInstances = new ArrayList<>();
    }
    
    public static EntityManager getInstance(){
        return INSTANCE;
    }
    
    public void addPeon(){
        
    }

    public void removePeon(String firstName, String lastName){
        
    }
}