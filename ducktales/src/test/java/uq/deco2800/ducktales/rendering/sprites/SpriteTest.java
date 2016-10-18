package uq.deco2800.ducktales.rendering.sprites;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Test class for the parent {@link Sprite} class
 *
 * Created on 18/10/2016.
 * @author khoiphan21
 */
public class SpriteTest extends ApplicationTest{
    private ResourceSpriteRegister spriteRegister;

    @Test
    public void testBasicSpriteCreation() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(spriteRegister.getResourceImage(DUCK));
        images.add(spriteRegister.getResourceImage(SHEEP));
        images.add(spriteRegister.getResourceImage(COW));

        Sprite sprite = new Sprite();
        sprite.setImageList(images);
        sprite.setupAnimation(2.0);

        // Attempt to play around with the animation
        sprite.pauseAnimation();
        sprite.startAnimation();
        sprite.stopAnimation();

        assertNotNull(sprite);
    }


    @Override
    public void start(Stage stage) throws Exception {
        /** The sprite register */
        spriteRegister = ResourceSpriteRegister.getInstance();
    }
}
