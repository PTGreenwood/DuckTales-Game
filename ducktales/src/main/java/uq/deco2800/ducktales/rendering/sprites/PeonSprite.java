/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uq.deco2800.ducktales.rendering.sprites;

/**
 * This class represents a sprite of a peon. The sprite will have the same
 * name as the peon, in order to allow correct retrieval of corresponding peon
 *
 * This class will also handle animating peons
 *
 * @author khoiphan21
 */
public class PeonSprite extends EntitySprite {

    /**
     * The unique ID of this peon sprite. This should match up
     * with the ID of the peon in the model
     */
    private String peonName;

    /**
     * Create a peon sprite with the given name
     * The name is the unique ID of this sprite
     *
     * @param name
     *          The name (unique ID( of the sprite
     */
    public PeonSprite(String name) {
        super();

        // Store the unique identifier of this sprite
        this.peonName = name;
    }

    /**
     * Get the name of the peon whose sprite this is for
     *
     * @return the name of the peon of this sprite
     */
    public String getPeonName() {
        return peonName;
    }
}
