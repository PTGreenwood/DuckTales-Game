package uq.deco2800.ducktales.features.builder;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Controller for builder package (part of MVC) architecture. Interacts with 
 * external classes, as well as the Model and View classes within the builder 
 * package.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class WorldBuilderController {
	
	// Constants 
	public static final int TILE = 1;
    public static final int ENTITY = 2;
	
	private static WorldBuilderModel model;
	private static WorldBuilderRenderer renderer;
	
	/**
	 * Instantiate a new WorldBuilderController, updates the model variable 
	 * with the current instance of WorldBuilderModel.
	 */
	public WorldBuilderController() {
		WorldBuilderController.model = WorldBuilderModel.getInstance();
	}
	
	/**
	 * Method to set the world to contain all objects for the game.
	 * 
	 * @param world, a valid World instance
	 */
	public void setWorld(World world) {
		model.setWorld(world);
	}	
	
	/**
	 * Method to return the instance of the world.
	 * 
	 * @return the current World
	 */
	public World getWorld() {
		return model.getWorld();
	}	
	
	/**
	 * Method to access the current selected type.
	 * 
	 * @return the current type selected by the user
	 */
	public int getCurrentType() {
		return model.getCurrentType();
	}
	
    /**
     * Register the rendering engine for the world builder
     * @param renderer
     *          The rendering engine
     */
    public static void setRenderer(WorldBuilderRenderer renderer) {
        WorldBuilderController.renderer = renderer;
        renderer.start();
    }
    
    /**
     * Method to get the current resource selected by the user.
     * 
     * @return the current resource
     */
    public ResourceType getCurrentResource() {
    	return model.getCurrentResource();
    }
    
    /**
     * Set the current resource to that which has been selected by the user. 
     * Calls the method in model which contains logic, and passes that to the 
     * renderer to update the view.
     * 
     * @param resource, the resource just selected by the user
     * @param type, type of resource selected
     */
    public static void setCurrentResource(ResourceType resource, int type) {
        Object[] current = model.setCurrentResource(resource, type);
        if (current[0] == "tile") {
            renderer.setCurrentTileSelected(resource);
        } else if (current[0] == "entity") {
            renderer.setCurrentEntitySelected(resource);
        }
    }
    
    /**
     * Method to call renderer method 'notifyTileEndHovering', called from 
     * external methods.
     */
    public void notifyTileEndHovering() {
    	renderer.notifyTileEndHovering();
    }
    
    /**
     * Method to call renderer method 'notifyTileHovered', called from 
     * external methods. 
     * 
     * @param x, the x location of the tile
     * @param y, the y location of the tile
     */
    public void notifyTileHovered(int x, int y) {
    	renderer.notifyTileHovered(x, y);
    }
    
    /**
     * Method to call renderer method 'notifyTileClicked', called from 
     * external methods.
     * 
     * @param x, the x location of the tile
     * @param y, the y location of the tile
     */
    public void notifyTileClicked(int x, int y) {
    	renderer.notifyTileClicked(x, y);
    }
	
}