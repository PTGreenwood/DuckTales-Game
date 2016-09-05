package uq.deco2800.ducktales.rendering.managers;

/**
 * This class contains the information about the size of the world, as well
 * as scaling factor for easier rendering management
 *
 * Created on 31/08/2016.
 *
 * @author khoiphan21
 */
public class RenderingManager {

    /** The width and height of the world, in tile units */
    private int worldTileWidth;
    private int worldTileHeight;

//    /** The actual pixel width and height of a tile */
//    public static final int TileHeight = 104;
//    public static final int TileWidth = 170;


    /** Scaling factors */
    // THIS IS THE MAIN SCALE FACTOR TO SCALE ALL IN-GAME SPRITES
    private double mainScaleFactor;
    // just brainstorming. don't judge pls
    private double agentScale;
    // the scale of the buildings to be displayed in-game. technically
    // should be the same as mainScaleFactor, but this can be fixed later
    // when the building designers have time to fix the pixel ratio
    private double buildingScale;
    // the scale for the animals, optimally 1, but for now this will make sure
    // the sprites look alright first
    private double animalScale;
    // THE MAIN SCALE FOR UI ELEMENTS
    private double UIScale;

    /**
     * Construct a {@link RenderingManager} class with the given initial scale
     * factor, width and height
     *
     * @param scaleFactor
     *          The initial main scaleFactor
     * @param width
     *          The width of the world, in number of tiles
     * @param height
     *          The height of the world, in number of tiles
     */
    public RenderingManager(double scaleFactor, int width, int height) {
        this.worldTileWidth = width;
        this.worldTileHeight = height;
        this.mainScaleFactor = scaleFactor;

        // TODO ADJUST THESE SCALE FACTORS AS DEEM FIT
        this.UIScale = 2;
        this.buildingScale = 1.2;
        this.animalScale = 0.8;
    }

    /*----------
     * GETTERS
     -----------*/
    /**
     * Get the main scale factor of the game
     *
     * @return the main scale factor of the game
     */
    public double getMainScaleFactor() {
        return mainScaleFactor;
    }

    /**
     * Get the scale factor for all agents displayed in the game
     *
     * @return The scale factor for game agents
     */
    public double getAgentScale() {
        return agentScale;
    }

    public double getBuildingScale() {
        return buildingScale;
    }

    public double getUIScale() {
        return UIScale;
    }

    public int getWorldTileHeight() {

        return worldTileHeight;
    }

    public int getWorldTileWidth() {
        return this.worldTileWidth;
    }

    /*----------
     * SETTERS
     -----------*/
    public void setWorldTileWidth(int worldTileWidth) {
        this.worldTileWidth = worldTileWidth;
    }

    public void setWorldTileHeight(int worldTileHeight) {
        this.worldTileHeight = worldTileHeight;
    }

    public void setMainScaleFactor(double mainScaleFactor) {
        this.mainScaleFactor = mainScaleFactor;
    }

    public void setAgentScale(double agentScale) {
        this.agentScale = agentScale;
    }

    public void setBuildingScale(double buildingScale) {
        this.buildingScale = buildingScale;
    }

    public void setUIScale(double UIScale) {
        this.UIScale = UIScale;
    }

    public double getAnimalScale() {
        return animalScale;
    }
}
