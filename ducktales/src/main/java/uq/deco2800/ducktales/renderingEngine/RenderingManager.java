package uq.deco2800.ducktales.renderingEngine;

/**
 * This class contains the information about the size of the world, as well
 * as scaling factor for easier rendering management
 *
 * Created on 31/08/2016.
 *
 * @author khoiphan21
 */
public class WorldRenderingInfo {

    /** The width and height of the world, in tile units */
    private int worldTileWidth;
    private int worldTileHeight;

    /** Scaling factors */
    private double mainScaleFactor;
    private double agentScale;
    private double buildingScale;
    private double UIScale;

    /**
     * Construct a {@link WorldRenderingInfo} class with the given initial scale
     * factor, width and height
     *
     * @param scaleFactor
     *          The initial main scaleFactor
     * @param width
     *          The width of the world, in number of tiles
     * @param height
     *          The height of the world, in number of tiles
     */
    public WorldRenderingInfo(double scaleFactor, int width, int height) {
        this.worldTileWidth = width;
        this.worldTileHeight = height;
        this.mainScaleFactor = scaleFactor;
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
}
