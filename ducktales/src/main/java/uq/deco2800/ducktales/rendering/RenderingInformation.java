package uq.deco2800.ducktales.rendering;

/**
 * This class contains the information about the size of the world, as well
 * as scaling factor for easier rendering management
 *
 * Created on 31/08/2016.
 *
 * @author khoiphan21
 */
public class RenderingInformation {

    /** The width and height of the world, in tile units */
    private int worldTileWidth;
    private int worldTileHeight;

    /** Scaling factors */
    // THIS IS THE MAIN SCALE FACTOR TO SCALE ALL IN-GAME SPRITES
    public static final double MAIN_SCALE_FACTOR = 1;
    // This is the scale of the tiles. Ideally 1, but can be fixed later
    public static final double TILE_SCALE = 0.4;
    // just brainstorming. don't judge pls
    public static final double AGENT_SCALE = 1.0;
    // the scale of the buildings to be displayed in-game. technically
    // should be the same as MAIN_SCALE_FACTOR, but this can be fixed later
    // when the building designers have time to fix the pixel ratio
    public static final double BUILDING_SCALE = 1.2;
    // the scale for the animals, optimally 1, but for now this will make sure
    // the sprites look alright first
    public static final double ANIMAL_SCALE = 0.8;
    // THE MAIN SCALE FOR UI ELEMENTS
    public static final double UI_SCALE = 1.0;

    /**
     * Construct a {@link RenderingInformation} class with the given initial scale
     * factor, width and height
     *
     * @param scaleFactor
     *          The initial main scaleFactor
     * @param width
     *          The width of the world, in number of tiles
     * @param height
     *          The height of the world, in number of tiles
     */
    @Deprecated
    public RenderingInformation(double scaleFactor, int width, int height) {
        this.worldTileWidth = width;
        this.worldTileHeight = height;
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
}
