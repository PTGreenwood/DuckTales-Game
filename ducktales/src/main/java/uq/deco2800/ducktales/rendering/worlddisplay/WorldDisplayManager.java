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
     *
     * @param gameManager
     *          The main manager of the game
     */
    public void initializeWorld(GameManager gameManager) {
        // Instantiate the helper managers
        tilesManager = new TilesManager(this.world, this.worldDisplay, gameManager);

        // render the tiles
        tilesManager.renderInitialWorld();

        // Load the rendering engine
        renderer.setTilesManager(tilesManager);
        renderer.setMainEntityManager(this.gameManager.getMainEntityManager());

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
        //getTimeManager is now getCalendarManager.
		if (this.gameManager.getTimeManager() == null) {
            System.err.println("Time manager is still empty");
        } else {
        	//This will change once it's all worked out.
            //boolean nightTime = this.gameManager.getTimeManager().isNight();
        	//Commented out for easy change
        	
            //if(nightTime) {
                //pane.setStyle("-fx-background-image: url('time/nightTime.png')"); //Uncomment this for nightTime
            //} else {
                pane.setStyle("-fx-background-image: url('time/dayTime.png')"); //Uncomment this for dayTime
            //}
        }

	}
	
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Pass the handle of the game manager to this manager
     *
     * @param gameManager
     *
     */
    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
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
