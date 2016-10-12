package uq.deco2800.ducktales.features.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.rendering.sprites.PeonSprite;

/**
 * Manager for all the entities in the game.
 *
 * @author eduardlio, TheFractal
 */
public class PeonManager extends EntityManager {
    
    private HashMap<String, Peon> peonInstances;
    private HashMap<String, PeonSprite> peonSprites;
    
    private static final PeonManager INSTANCE = new PeonManager();
    
    private PeonManager() {
    	peonInstances = new HashMap<String, Peon>(50);
        peonSprites = new HashMap<String, PeonSprite>(50);
    }
    
    public static EntityManager getInstance(){
        return INSTANCE;
    }
   	
    
    /**
     * x and y coordinates of the peon starting point.
     * @param x 
     * @param y 
     */
    public void addPeon(int x, int y) throws IOException{
    	Peon peon = new Peon(x, y);
        String name = "";
    	while(!peonInstances.containsKey(name)){
    		name = peon.generateName();
    	}
    	
    	PeonSprite peonSprite = new PeonSprite();
    	
    	peonInstances.put(name, peon);
    	peonSprites.put(name, peonSprite);
    	// TODO: new peon
    		// generate name
    		// pathfinder
    }
    
    public PeonSprite getPeon(String name){
    	 return peonSprites.get(name);
    }
    
    public Peon getPeonSprite(String name){
    	return peonInstances.get(name);
    }

    public void removePeon(String name){
        if (peonInstances.containsKey(name) && peonSprites.containsKey(name)){
        	peonInstances.remove(name);
        	peonSprites.remove(name);
        }
    }
    
}