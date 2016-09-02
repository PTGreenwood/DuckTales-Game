package uq.deco2800.ducktales;

import uq.deco2800.ducktales.renderingengine.RenderingManager;
import uq.deco2800.ducktales.resources.InventoryManager;
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
    private static final double defaultScale = 0.2;
    private static final int defaultWorldwidth = 30;
    private static final int defaultWorldheight = 30;

    /** The game world */
    private WorldBeta world;

    /** The rendering engine */
    private GameRendererBeta renderer;

    /** Static HUD element managers */
    private InventoryManager inventoryManager;

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
                    defaultScale, defaultWorldwidth, defaultWorldheight);
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
     * Return the current game world, which contains all the information about
     * the current game being played
     *
     * @return the current world of the game
     */
    public WorldBeta getWorld() {
        return this.world;
    }

    /**
     * Get the type of the resource being managed. For example, a building
     * that the player is trying to add to the game world
     *
     * @return the type of the resource currently being managed
     */
    public ResourceType getCurrentResourceManaging() {
        return currentResourceManaging;
    }

    /**
     * Set the inventory manager for this current game
     *
     * @param inventoryManager
     *          The inventory manager of the current game
     */
    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
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
     * Set the current resource being managed
     *
     * @param currentResourceManaging
     */
    public void setCurrentResourceManaging(ResourceType currentResourceManaging) {
        this.currentResourceManaging = currentResourceManaging;
    }
}
