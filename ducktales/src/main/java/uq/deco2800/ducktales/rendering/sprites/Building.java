package uq.deco2800.ducktales.rendering.sprites;

import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A building to be rendered into the game world, where other entities can interact
 * with. This building class will hold its own rendering information, since it is
 * a sub-class of ImageView
 *
 * Created on 2/09/2016.
 *
 * @author khoiphan21
 */
public class Building extends ImageView{
    /** The type of this building */
    protected ResourceType buildingType;

    /** The length in tile-unit of this building */
    protected int xLength;
    protected int yLength;

    public Building(ResourceType type) {
        super();
        this.buildingType = type;
    }

    /**
     * Get the type of this building
     *
     * @return the type of this building
     */
    public ResourceType getBuildingType() {
        return buildingType;
    }

    /**
     * Set the type of this building
     *
     * @param buildingType
     *          The type of this building
     */
    public void setBuildingType(ResourceType buildingType) {
        this.buildingType = buildingType;
    }

    /**
     * Get the x-length in tile-unit of this building
     *
     * @return the x-length in tile-unit of this building
     */
    public int getxLength() {
        return xLength;
    }

    /**
     * Set the x-length in tile-unit of this building
     *
     * @param xLength
     *          The x-length in tile-unit of this building
     */
    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    /**
     * Get the y-length in tile-unit of this building
     *
     * @return the y-length in tile-unit of this building
     */
    public int getyLength() {
        return yLength;
    }

    /**
     * Set the y-length in tile-unit of this building
     *
     * @param yLength
     *          The y-length in tile-unit of this building
     */
    public void setyLength(int yLength) {
        this.yLength = yLength;
    }
}
