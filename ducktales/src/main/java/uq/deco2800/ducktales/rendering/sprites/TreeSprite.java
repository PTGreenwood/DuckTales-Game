package uq.deco2800.ducktales.rendering.sprites;

import uq.deco2800.ducktales.features.entities.resourceentities.Tree;


/**
 * The sprite of a tree in the game, which can be gathered for lumber
 * resource
 *
 * Created on 22/10/2016.
 * @author khoiphan21
 */
public class TreeSprite extends EntitySprite {

    /**
     * The hashcode of the corresponding {@link Tree} object, used to
     * retrieve the tree or its sprite
     */
    private Integer hashCode;

    /**
     * Instantiate a {@link TreeSprite} object that stores the unique integer
     * used as key to retrieve either the sprite or the tree
     *
     * @param hashCode
     *          The hashcode of the {@link Tree} object
     */
    public TreeSprite(int hashCode) {
        this.hashCode = new Integer(hashCode);
    }

    /**
     * Retrieve the unique id of this tree - the value of the hashcode of the
     * corresponding {@link Tree}, used as key in the hashmap
     *
     * @return the unique id of the tree sprite
     */
    public Integer getHashCode() {
        return hashCode;
    }
}
