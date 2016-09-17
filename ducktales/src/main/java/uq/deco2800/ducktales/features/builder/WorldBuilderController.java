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
	
	public final int TILE = 1;
    public final int ENTITY = 2;
	
	private TileSprite tileSprite;
	private static WorldBuilderModel model;
	private static WorldBuilderRenderer renderer;
	
	public WorldBuilderController() {
		this.model = WorldBuilderModel.getInstance();
	}
	
	public void setWorld(World world) {
		model.setWorld(world);
	}	
	
	public World getWorld() {
		return model.getWorld();
	}	
	
	public int getCurrentType() {
		return model.getCurrentType();
	}
	
    /**
     * Register the rendering engine for the world builder
     * @param renderer
     *          The rendering engine
     */
    public void setRenderer(WorldBuilderRenderer renderer) {
        this.renderer = renderer;
        renderer.start();
    }
    
    public ResourceType getCurrentResource() {
    	return model.getCurrentResource();
    }
    
    public static void setCurrentResource(ResourceType resource, int type) {
        Object[] current = model.setCurrentResource(resource, type);
        if (current[0] == "tile") {
            renderer.setCurrentTileSelected(resource);
        } else if (current[0] == "entity") {
            renderer.setCurrentEntitySelected(resource);
        }
    }
    
    public void notifyTileEndHovering() {
    	renderer.notifyTileEndHovering();
    }
    
    public void notifyTileHovered(int x, int y) {
    	renderer.notifyTileHovered(x, y);
    }
    
    public void notifyTileClicked(int x, int y) {
    	renderer.notifyTileClicked(x, y);
    }
	
}