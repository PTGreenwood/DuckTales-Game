package uq.deco2800.ducktales;

import uq.deco2800.ducktales.renderingEngine.RenderingManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.WorldBeta;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 31/08/2016.
 */
public class GameManagerBeta {
    /**
     * CONSTANTS
     */
    private final double DEFAULT_SCALE = 0.2;
    private final int DEFAULT_WORLD_WIDTH = 20;
    private final int DEFAULT_WORLD_HEIGHT = 20;

    /** The game world */
    private WorldBeta world;

    /** The rendering engine */
    private GameRendererBeta renderer;

    /** The class holding rendering information */
    private RenderingManager renderingManager;

    /**
     * Variables for managing the game
     */
    // The thing the player currently wants to add to the world, eg. building
    private ResourceType currentResourceManaging = NONE;

    /**
     * Main constructor of the {@link GameManagerBeta} class
     *
     * Initialize a game manager with all the default settings
     */
    public GameManagerBeta() {
        // Stub constructor for a normal game manager
    }

    /**
     * Initialize a game manager with the preloaded world
     *
     * @param preloadedWorld
     *          The world to be loaded into the game
     */
    public GameManagerBeta(WorldBeta preloadedWorld) {
        this.world = preloadedWorld;
    }

    /**
     * Officially start the game
     */
    public void startGame() {
        // Initialize the renderingManager and the world
        if (renderingManager == null) {
            // No rendering info is loaded. start a default renderingManager
            renderingManager = new RenderingManager(
                    DEFAULT_SCALE, DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT);
        }
        if (world == null) {
            // No world has been pre-loaded. Start a default world
            this.world = new WorldBeta(
                    "New World",
                    renderingManager.getWorldTileWidth(),
                    renderingManager.getWorldTileHeight()
            );
        }

        // Setup the rendering manager and world for the renderer
        renderer.setWorld(this.world);
        renderer.setRenderingManager(this.renderingManager);

        // Start the rendering engine
        this.renderer.start();

    }

    /**
     * Set the renderer for this manager
     * 
     * @param renderer
     *          The main game rendering engine
     */
    public void setRenderer (GameRendererBeta renderer) {
        this.renderer = renderer;
    }

    /**
     * Set the world for the current game
     *
     * @param world
     */
    public void setWorld(WorldBeta world) {
        this.world = world;
    }

    /**
     * Return the current game world, which contains all the information about
     * the current game being played
     *
     * @return the current world of the game
     */
    public WorldBeta getWorld() {
        return this.world;
    }

    /**
     * Notify itself that a building sprite in the buildings menu has been clicked
     *
     * @param buildingType
     *          The type of building in the buildings menu clicked
     */
    public void notifyBuildingMenuClicked(ResourceType buildingType) {

    }

    /**
     * Notify itself that a tile has been hovered upon
     * @param xPos
     *          The x-index in the 2D array of the tile hovered
     * @param yPos
     *          The y-index in the 2D array of the tile hovered
     */
    public void notifyTileHovered(int xPos, int yPos) {
    }

    /**
     * Notify itself that a tile has been clicked
     * @param xPos
     *          The x-index in the 2D array of the tile clicked
     * @param yPos
     *          The y-index in the 2D array of the tile clicked
     */
    public void notifyTileClicked(int xPos, int yPos) {
    }
}