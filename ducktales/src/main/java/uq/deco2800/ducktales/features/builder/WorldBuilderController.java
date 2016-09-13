package uq.deco2800.ducktales.features.builder;

import uq.deco2800.ducktales.DuckTalesController;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.missions.MissionHandler;
import uq.deco2800.ducktales.resources.ResourceType;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import com.sun.glass.events.MouseEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Controller for builder package (part of MVC) architecture.
 * 
 * @author Gabbi
 *
 */

public class WorldBuilderController {
	
	private WorldBuilderManager manager; // The manager that this sprite reports to
	private TileSprite tileSprite;
	private WorldBuilderModel model;
	private WorldBuilderRenderer renderer;
	
	public WorldBuilderController() {
		//this.manager = WorldBuilderManager.getInstance();
		//this.tileSprite = new TileSprite(resource);
		this.model = new WorldBuilderModel();
		//this.renderer = new WorldBuilderRenderer(new Pane(), new BorderPane());
	}
	
	public void setWorld(World world) {
		model.setWorld(world);
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
    
    public void setCurrentResource(ResourceType resource, int type) {
        Object[] current = model.setCurrentResource(resource, type);
        if (current[0] == "tile") {
            this.renderer.setCurrentTileSelected(resource);
        } else if (current[1] == "entity") {
            renderer.setCurrentEntitySelected(resource);
        }
    }
    
    MissionHandler missions = MissionHandler.getInstance();
	
}