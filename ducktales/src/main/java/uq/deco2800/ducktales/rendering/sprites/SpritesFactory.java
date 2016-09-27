package uq.deco2800.ducktales.rendering.sprites;

/**
 * This is the factory that will create and return sprites as requested
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class SpritesFactory {

    /** Variable holding the currently registered sprites that can be created */
    public enum RegisteredSprite {
        // Animals
        DUCK,
        // Buildings
        CHURCH
    }

    /**
     * Create and return a sprite of the given type
     *
     * @param spriteType
     *          The type of the sprite requested
     * @return
     */
    public static Sprite create(RegisteredSprite spriteType) {
        switch (spriteType) {
            case DUCK:
                Sprite sprite = createDuck();
                return sprite;
            default:
                return new Sprite();
        }
    }

    /**
     * Create and return a generic duck sprite
     *
     * @return the sprite of a generic duck
     */
    private static Sprite createDuck() {
        // The sprite to be returned
        Sprite sprite = new Sprite();

        return sprite;
    }
}
