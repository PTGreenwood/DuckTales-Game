package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.features.weather.Weather;
import uq.deco2800.ducktales.features.weather.WeatherEffect;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayRenderer.*;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the manager for the display of the world - where the player can see
 * and interact with the actual game world
 *
 * Created on 7/09/2016.
 * @author khoiphan21
 */
public class WorldDisplayManager extends SecondaryManager implements Initializable {
    /** The pane where all world objects will be added to */
    @FXML
    private Pane worldDisplay;

    /** Helper managers */
    private TilesManager tilesManager;

    /** The rendering engine for the world display */
    private WorldDisplayRenderer renderer;

    /** The directions to move the world */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Create and start the renderer
        renderer = new WorldDisplayRenderer();
        renderer.start();

    }

    /**
     * This method is called by Game Manager when all managers have been set up,
     * which will render the initial world onto the display
     */
    public void initializeWorld() {
        checkWorldAndGameManager();
        if (this.worldDisplay == null) {
            throw new GameSetupException("World display has not been passed to" +
                    " WorldDisplayManager");
        } if (this.renderer == null) {
            throw new GameSetupException("Renderer is not initialized" +
                    " for WorldDisplayManager");
        }
        // Instantiate the helper managers
        tilesManager = new TilesManager(this.world, this.worldDisplay);

        // render the tiles
        tilesManager.renderInitialWorld();

        // Load the rendering engine
        renderer.setTilesManager(tilesManager);
        renderer.setMainEntityManager(gameManager.getMainEntityManager());

    }

    /**
     * Change the display of the game's rendered world
     *
     * @param worldDisplay
     *          The new display for the game's rendered world
     */
    public void setWorldDisplay(Pane worldDisplay) {
        this.worldDisplay = worldDisplay;
    }

    /**
     * Set the renderer that will handle rendering tasks for the world display
     *
     * @param renderer
     *          The renderer for the world display
     */
    public void setRenderer(WorldDisplayRenderer renderer) {
        this.renderer = renderer;
    }

    /**
	 * Change the current weather of the scene to given weather.
	 * 
	 * @param weather
	 * 			weather to change current scene to
	 * @param pane
	 * 			pane to place the weather effects into
	 */
	public void changeWeather(Weather weather, Pane pane) {
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		String sprite = weatherEffect.getSprite();
		String weatherName = weatherEffect.toString();
		pane.setStyle("-fx-background-image: url('"+sprite+"')");
		System.out.println("Weather set to: "+weather.toString().toUpperCase());
	}
	
    /**
     * Pass a handle of the game world to this manager
     *
     * @param world
     *          The game world
     */
	
    
	/**
	 * 
	 * Change the current day 'overlay' to that of Day or Night
	 * 
	 *  
	 */
	public void changeLightLevel(Pane pane) {
		if (this.gameManager.getTimeManager() == null) {
            throw new GameSetupException("Time manager is still empty");
        } else {   
                pane.setStyle("-fx-background-image: url('time/dayTime.png')"); //Uncomment this for dayTime
        }

	}

    /**
     * Get the world display pane, which is the pane that all world objects will
     * be rendered onto
     *
     * @return the world display pane
     */
    public Pane getWorldDisplay() {
        return worldDisplay;
    }

    /**
     * Get the tiles manager
     *
     * @return the tiles manager
     */
    public TilesManager getTilesManager() {
        return this.tilesManager;
    }

    /**
     * Move the whole world in the given direction
     *
     * @param direction
     *          The direction to move the whole world towards
     */
    public void moveWorld(Direction direction) {
        switch (direction) {
            case UP:
                renderer.setMovingDirectionV(VDirection.UP);
                break;
            case DOWN:
                renderer.setMovingDirectionV(VDirection.DOWN);
                break;
            case LEFT:
                renderer.setMovingDirectionH(HDirection.LEFT);
                break;
            case RIGHT:
                renderer.setMovingDirectionH(HDirection.RIGHT);
                break;
        }
    }

    /**
     * Stop moving the world in the given direction
     *
     * @param direction
     *          The direction that the world should stop moving towards
     */
    public void stopMoveWorld(Direction direction) {
        switch (direction) {
            case UP:case DOWN:
                renderer.setMovingDirectionV(VDirection.NONE);
                break;
            case LEFT:case RIGHT:
                renderer.setMovingDirectionH(HDirection.NONE);
                break;
        }
    }

}
